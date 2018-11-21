package com.google.android.gms.vision.face.internal.client;

import android.content.Context;
import android.graphics.PointF;
import android.util.Log;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.Landmark;
import com.google.android.gms.vision.internal.client.FrameMetadataParcel;
import java.nio.ByteBuffer;

public class zzg {
    private final Context mContext;
    private final FaceSettingsParcel zzbiT;
    private zzc zzbiU = null;
    private boolean zzbiV = false;
    private final Object zzpK = new Object();

    public zzg(Context context, FaceSettingsParcel faceSettingsParcel) {
        this.mContext = context;
        this.zzbiT = faceSettingsParcel;
        zzGn();
    }

    private zzc zzGn() {
        zzc com_google_android_gms_vision_face_internal_client_zzc;
        synchronized (this.zzpK) {
            if (this.zzbiU != null) {
                com_google_android_gms_vision_face_internal_client_zzc = this.zzbiU;
            } else {
                this.zzbiU = zzf.zza(this.mContext, this.zzbiT);
                if (!this.zzbiV && this.zzbiU == null) {
                    Log.w("FaceDetectorHandle", "Native face detector not yet available.  Reverting to no-op detection.");
                    this.zzbiV = true;
                } else if (this.zzbiV && this.zzbiU != null) {
                    Log.w("FaceDetectorHandle", "Native face detector is now available.");
                }
                com_google_android_gms_vision_face_internal_client_zzc = this.zzbiU;
            }
        }
        return com_google_android_gms_vision_face_internal_client_zzc;
    }

    private Face zza(FaceParcel faceParcel) {
        return new Face(faceParcel.id, new PointF(faceParcel.centerX, faceParcel.centerY), faceParcel.width, faceParcel.height, faceParcel.zzbiI, faceParcel.zzbiJ, zzb(faceParcel), faceParcel.zzbiL, faceParcel.zzbiM, faceParcel.zzbiN);
    }

    private Landmark zza(LandmarkParcel landmarkParcel) {
        return new Landmark(new PointF(landmarkParcel.f1122x, landmarkParcel.f1123y), landmarkParcel.type);
    }

    private Landmark[] zzb(FaceParcel faceParcel) {
        int i = 0;
        LandmarkParcel[] landmarkParcelArr = faceParcel.zzbiK;
        if (landmarkParcelArr == null) {
            return new Landmark[0];
        }
        Landmark[] landmarkArr = new Landmark[landmarkParcelArr.length];
        while (i < landmarkParcelArr.length) {
            landmarkArr[i] = zza(landmarkParcelArr[i]);
            i++;
        }
        return landmarkArr;
    }

    public boolean isOperational() {
        return zzGn() != null;
    }

    public void zzGm() {
        synchronized (this.zzpK) {
            if (this.zzbiU == null) {
                return;
            }
            try {
                this.zzbiU.zzGm();
            } catch (Throwable e) {
                Log.e("FaceDetectorHandle", "Could not finalize native face detector", e);
            }
        }
    }

    public Face[] zzb(ByteBuffer byteBuffer, FrameMetadataParcel frameMetadataParcel) {
        int i = 0;
        zzc zzGn = zzGn();
        if (zzGn == null) {
            return new Face[0];
        }
        try {
            FaceParcel[] zzc = zzGn.zzc(zze.zzB(byteBuffer), frameMetadataParcel);
            Face[] faceArr = new Face[zzc.length];
            while (i < zzc.length) {
                faceArr[i] = zza(zzc[i]);
                i++;
            }
            return faceArr;
        } catch (Throwable e) {
            Log.e("FaceDetectorHandle", "Could not call native face detector", e);
            return new Face[0];
        }
    }

    public boolean zzks(int i) {
        boolean z = false;
        zzc zzGn = zzGn();
        if (zzGn != null) {
            try {
                z = zzGn.zzks(i);
            } catch (Throwable e) {
                Log.e("FaceDetectorHandle", "Could not call native face detector", e);
            }
        }
        return z;
    }
}
