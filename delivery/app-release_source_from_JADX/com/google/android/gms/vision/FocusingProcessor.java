package com.google.android.gms.vision;

import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.vision.Detector.Detections;
import com.google.android.gms.vision.Detector.Processor;

public abstract class FocusingProcessor<T> implements Processor<T> {
    private Detector<T> zzbhH;
    private Tracker<T> zzbhX;
    private int zzbhY = 3;
    private boolean zzbhZ = false;
    private int zzbia;
    private int zzbib = 0;

    public FocusingProcessor(Detector<T> detector, Tracker<T> tracker) {
        this.zzbhH = detector;
        this.zzbhX = tracker;
    }

    public void receiveDetections(Detections<T> detections) {
        SparseArray detectedItems = detections.getDetectedItems();
        if (detectedItems.size() == 0) {
            if (this.zzbib == this.zzbhY) {
                this.zzbhX.onDone();
                this.zzbhZ = false;
            } else {
                this.zzbhX.onMissing(detections);
            }
            this.zzbib++;
            return;
        }
        this.zzbib = 0;
        if (this.zzbhZ) {
            Object obj = detectedItems.get(this.zzbia);
            if (obj != null) {
                this.zzbhX.onUpdate(detections, obj);
                return;
            } else {
                this.zzbhX.onDone();
                this.zzbhZ = false;
            }
        }
        int selectFocus = selectFocus(detections);
        Object obj2 = detectedItems.get(selectFocus);
        if (obj2 == null) {
            Log.w("FocusingProcessor", "Invalid focus selected: " + selectFocus);
            return;
        }
        this.zzbhZ = true;
        this.zzbia = selectFocus;
        this.zzbhH.setFocus(this.zzbia);
        this.zzbhX.onNewItem(this.zzbia, obj2);
        this.zzbhX.onUpdate(detections, obj2);
    }

    public void release() {
        this.zzbhX.onDone();
    }

    public abstract int selectFocus(Detections<T> detections);

    protected void zzjZ(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Invalid max gap: " + i);
        }
        this.zzbhY = i;
    }
}
