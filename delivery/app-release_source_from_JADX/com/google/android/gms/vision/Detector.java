package com.google.android.gms.vision;

import android.util.SparseArray;
import com.google.android.gms.vision.Frame.Metadata;

public abstract class Detector<T> {
    private Object zzbhS = new Object();
    private Processor<T> zzbhT;

    public static class Detections<T> {
        private SparseArray<T> zzbhU;
        private Metadata zzbhV;
        private boolean zzbhW;

        public Detections(SparseArray<T> detectedItems, Metadata frameMetadata, boolean isOperational) {
            this.zzbhU = detectedItems;
            this.zzbhV = frameMetadata;
            this.zzbhW = isOperational;
        }

        public boolean detectorIsOperational() {
            return this.zzbhW;
        }

        public SparseArray<T> getDetectedItems() {
            return this.zzbhU;
        }

        public Metadata getFrameMetadata() {
            return this.zzbhV;
        }
    }

    public interface Processor<T> {
        void receiveDetections(Detections<T> detections);

        void release();
    }

    public abstract SparseArray<T> detect(Frame frame);

    public boolean isOperational() {
        return true;
    }

    public void receiveFrame(Frame frame) {
        synchronized (this.zzbhS) {
            if (this.zzbhT == null) {
                throw new IllegalStateException("Detector processor must first be set with setProcessor in order to receive detection results.");
            }
            Metadata metadata = new Metadata(frame.getMetadata());
            metadata.zzGk();
            this.zzbhT.receiveDetections(new Detections(detect(frame), metadata, isOperational()));
        }
    }

    public void release() {
        synchronized (this.zzbhS) {
            if (this.zzbhT != null) {
                this.zzbhT.release();
                this.zzbhT = null;
            }
        }
    }

    public boolean setFocus(int id) {
        return true;
    }

    public void setProcessor(Processor<T> processor) {
        this.zzbhT = processor;
    }
}
