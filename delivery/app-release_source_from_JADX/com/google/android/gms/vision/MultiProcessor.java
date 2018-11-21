package com.google.android.gms.vision;

import android.util.SparseArray;
import com.google.android.gms.vision.Detector.Detections;
import com.google.android.gms.vision.Detector.Processor;
import java.util.HashSet;
import java.util.Set;

public class MultiProcessor<T> implements Processor<T> {
    private int zzbhY;
    private Factory<T> zzbik;
    private SparseArray<zza> zzbil;

    public static class Builder<T> {
        private MultiProcessor<T> zzbim = new MultiProcessor();

        public Builder(Factory<T> factory) {
            if (factory == null) {
                throw new IllegalArgumentException("No factory supplied.");
            }
            this.zzbim.zzbik = factory;
        }

        public MultiProcessor<T> build() {
            return this.zzbim;
        }

        public Builder<T> setMaxGapFrames(int maxGapFrames) {
            if (maxGapFrames < 0) {
                throw new IllegalArgumentException("Invalid max gap: " + maxGapFrames);
            }
            this.zzbim.zzbhY = maxGapFrames;
            return this;
        }
    }

    public interface Factory<T> {
        Tracker<T> create(T t);
    }

    private class zza {
        private Tracker<T> zzbhX;
        private int zzbib;
        final /* synthetic */ MultiProcessor zzbin;

        private zza(MultiProcessor multiProcessor) {
            this.zzbin = multiProcessor;
            this.zzbib = 0;
        }
    }

    private MultiProcessor() {
        this.zzbil = new SparseArray();
        this.zzbhY = 3;
    }

    private void zza(Detections<T> detections) {
        SparseArray detectedItems = detections.getDetectedItems();
        for (int i = 0; i < detectedItems.size(); i++) {
            int keyAt = detectedItems.keyAt(i);
            Object valueAt = detectedItems.valueAt(i);
            if (this.zzbil.get(keyAt) == null) {
                zza com_google_android_gms_vision_MultiProcessor_zza = new zza();
                com_google_android_gms_vision_MultiProcessor_zza.zzbhX = this.zzbik.create(valueAt);
                com_google_android_gms_vision_MultiProcessor_zza.zzbhX.onNewItem(keyAt, valueAt);
                this.zzbil.append(keyAt, com_google_android_gms_vision_MultiProcessor_zza);
            }
        }
    }

    private void zzb(Detections<T> detections) {
        SparseArray detectedItems = detections.getDetectedItems();
        Set<Integer> hashSet = new HashSet();
        for (int i = 0; i < this.zzbil.size(); i++) {
            int keyAt = this.zzbil.keyAt(i);
            if (detectedItems.get(keyAt) == null) {
                zza com_google_android_gms_vision_MultiProcessor_zza = (zza) this.zzbil.valueAt(i);
                com_google_android_gms_vision_MultiProcessor_zza.zzbib = com_google_android_gms_vision_MultiProcessor_zza.zzbib + 1;
                if (com_google_android_gms_vision_MultiProcessor_zza.zzbib >= this.zzbhY) {
                    com_google_android_gms_vision_MultiProcessor_zza.zzbhX.onDone();
                    hashSet.add(Integer.valueOf(keyAt));
                } else {
                    com_google_android_gms_vision_MultiProcessor_zza.zzbhX.onMissing(detections);
                }
            }
        }
        for (Integer intValue : hashSet) {
            this.zzbil.delete(intValue.intValue());
        }
    }

    private void zzc(Detections<T> detections) {
        SparseArray detectedItems = detections.getDetectedItems();
        for (int i = 0; i < detectedItems.size(); i++) {
            int keyAt = detectedItems.keyAt(i);
            Object valueAt = detectedItems.valueAt(i);
            zza com_google_android_gms_vision_MultiProcessor_zza = (zza) this.zzbil.get(keyAt);
            com_google_android_gms_vision_MultiProcessor_zza.zzbib = 0;
            com_google_android_gms_vision_MultiProcessor_zza.zzbhX.onUpdate(detections, valueAt);
        }
    }

    public void receiveDetections(Detections<T> detections) {
        zza(detections);
        zzb(detections);
        zzc(detections);
    }

    public void release() {
        for (int i = 0; i < this.zzbil.size(); i++) {
            ((zza) this.zzbil.valueAt(i)).zzbhX.onDone();
        }
        this.zzbil.clear();
    }
}
