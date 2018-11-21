package com.google.android.gms.vision;

import android.util.SparseArray;
import com.google.android.gms.vision.Detector.Processor;
import java.util.ArrayList;
import java.util.List;

public class MultiDetector extends Detector<Object> {
    private List<Detector<? extends Object>> zzbii;

    public static class Builder {
        private MultiDetector zzbij = new MultiDetector();

        public Builder add(Detector<? extends Object> detector) {
            this.zzbij.zzbii.add(detector);
            return this;
        }

        public MultiDetector build() {
            if (this.zzbij.zzbii.size() != 0) {
                return this.zzbij;
            }
            throw new RuntimeException("No underlying detectors added to MultiDetector.");
        }
    }

    private MultiDetector() {
        this.zzbii = new ArrayList();
    }

    public SparseArray<Object> detect(Frame frame) {
        SparseArray<Object> sparseArray = new SparseArray();
        for (Detector detect : this.zzbii) {
            SparseArray detect2 = detect.detect(frame);
            for (int i = 0; i < detect2.size(); i++) {
                int keyAt = detect2.keyAt(i);
                if (sparseArray.get(keyAt) != null) {
                    throw new IllegalStateException("Detection ID overlap for id = " + keyAt + ".  " + "This means that one of the detectors is not using global IDs.");
                }
                sparseArray.append(keyAt, detect2.valueAt(i));
            }
        }
        return sparseArray;
    }

    public boolean isOperational() {
        for (Detector isOperational : this.zzbii) {
            if (!isOperational.isOperational()) {
                return false;
            }
        }
        return true;
    }

    public void receiveFrame(Frame frame) {
        for (Detector receiveFrame : this.zzbii) {
            receiveFrame.receiveFrame(frame);
        }
    }

    public void release() {
        for (Detector release : this.zzbii) {
            release.release();
        }
        this.zzbii.clear();
    }

    public void setProcessor(Processor<Object> processor) {
        throw new UnsupportedOperationException("MultiDetector.setProcessor is not supported.  You should set a processor instance on each underlying detector instead.");
    }
}
