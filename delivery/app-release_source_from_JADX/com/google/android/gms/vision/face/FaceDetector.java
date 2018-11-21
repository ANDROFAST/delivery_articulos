package com.google.android.gms.vision.face;

import android.content.Context;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.internal.client.FaceSettingsParcel;
import com.google.android.gms.vision.face.internal.client.zzg;
import com.google.android.gms.vision.internal.client.FrameMetadataParcel;
import com.google.android.gms.vision.zza;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Set;

public final class FaceDetector extends Detector<Face> {
    public static final int ACCURATE_MODE = 1;
    public static final int ALL_CLASSIFICATIONS = 1;
    public static final int ALL_LANDMARKS = 1;
    public static final int FAST_MODE = 0;
    public static final int NO_CLASSIFICATIONS = 0;
    public static final int NO_LANDMARKS = 0;
    private final zza zzbiA;
    private final zzg zzbiB;
    private boolean zzbiC;
    private final Object zzpK;

    public static class Builder {
        private final Context mContext;
        private int zzamE = 0;
        private int zzbiD = 0;
        private boolean zzbiE = false;
        private int zzbiF = 0;
        private boolean zzbiG = true;

        public Builder(Context context) {
            this.mContext = context;
        }

        public FaceDetector build() {
            FaceSettingsParcel faceSettingsParcel = new FaceSettingsParcel();
            faceSettingsParcel.mode = this.zzamE;
            faceSettingsParcel.zzbiO = this.zzbiD;
            faceSettingsParcel.zzbiP = this.zzbiF;
            faceSettingsParcel.zzbiQ = this.zzbiE;
            faceSettingsParcel.zzbiR = this.zzbiG;
            return new FaceDetector(new zzg(this.mContext, faceSettingsParcel));
        }

        public Builder setClassificationType(int classificationType) {
            if (classificationType == 0 || classificationType == 1) {
                this.zzbiF = classificationType;
                return this;
            }
            throw new IllegalArgumentException("Invalid classification type: " + classificationType);
        }

        public Builder setLandmarkType(int landmarkType) {
            if (landmarkType == 0 || landmarkType == 1) {
                this.zzbiD = landmarkType;
                return this;
            }
            throw new IllegalArgumentException("Invalid landmark type: " + landmarkType);
        }

        public Builder setMode(int mode) {
            switch (mode) {
                case 0:
                case 1:
                    this.zzamE = mode;
                    return this;
                default:
                    throw new IllegalArgumentException("Invalid mode: " + mode);
            }
        }

        public Builder setProminentFaceOnly(boolean prominentFaceOnly) {
            this.zzbiE = prominentFaceOnly;
            return this;
        }

        public Builder setTrackingEnabled(boolean trackingEnabled) {
            this.zzbiG = trackingEnabled;
            return this;
        }
    }

    private FaceDetector() {
        this.zzbiA = new zza();
        this.zzpK = new Object();
        this.zzbiC = true;
        throw new IllegalStateException("Default constructor called");
    }

    private FaceDetector(zzg handle) {
        this.zzbiA = new zza();
        this.zzpK = new Object();
        this.zzbiC = true;
        this.zzbiB = handle;
    }

    public SparseArray<Face> detect(Frame frame) {
        if (frame == null) {
            throw new IllegalArgumentException("No frame supplied.");
        }
        Face[] zzb;
        ByteBuffer grayscaleImageData = frame.getGrayscaleImageData();
        synchronized (this.zzpK) {
            if (this.zzbiC) {
                zzb = this.zzbiB.zzb(grayscaleImageData, FrameMetadataParcel.zzc(frame));
            } else {
                throw new RuntimeException("Cannot use detector after release()");
            }
        }
        Set hashSet = new HashSet();
        SparseArray<Face> sparseArray = new SparseArray(zzb.length);
        int i = 0;
        for (Face face : zzb) {
            int id = face.getId();
            i = Math.max(i, id);
            if (hashSet.contains(Integer.valueOf(id))) {
                id = i + 1;
                i = id;
            }
            hashSet.add(Integer.valueOf(id));
            sparseArray.append(this.zzbiA.zzka(id), face);
        }
        return sparseArray;
    }

    protected void finalize() throws Throwable {
        try {
            synchronized (this.zzpK) {
                if (this.zzbiC) {
                    Log.w("FaceDetector", "FaceDetector was not released with FaceDetector.release()");
                    release();
                }
            }
        } finally {
            super.finalize();
        }
    }

    public boolean isOperational() {
        return this.zzbiB.isOperational();
    }

    public void release() {
        synchronized (this.zzpK) {
            if (this.zzbiC) {
                this.zzbiB.zzGm();
                this.zzbiC = false;
                return;
            }
        }
    }

    public boolean setFocus(int id) {
        boolean zzks;
        int zzkb = this.zzbiA.zzkb(id);
        synchronized (this.zzpK) {
            if (this.zzbiC) {
                zzks = this.zzbiB.zzks(zzkb);
            } else {
                throw new RuntimeException("Cannot use detector after release()");
            }
        }
        return zzks;
    }
}
