package com.google.android.gms.vision.face.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.vision.face.internal.client.zzd.zza;

class zzf extends zzg<zzd> {
    private static zzf zzbiS;

    zzf() {
        super("com.google.android.gms.vision.client.DynamiteNativeFaceDetectorCreator");
    }

    static zzc zza(Context context, FaceSettingsParcel faceSettingsParcel) {
        if (zzbiS == null) {
            zzbiS = new zzf();
        }
        return zzbiS.zzb(context, faceSettingsParcel);
    }

    private zzc zzb(Context context, FaceSettingsParcel faceSettingsParcel) {
        try {
            return ((zzd) zzaA(context)).zza(zze.zzB(context), faceSettingsParcel);
        } catch (Throwable e) {
            Log.e("FaceDetectorHandle", "Could not create native face detector", e);
            return null;
        }
    }

    protected /* synthetic */ Object zzd(IBinder iBinder) {
        return zzed(iBinder);
    }

    protected zzd zzed(IBinder iBinder) {
        return zza.zzec(iBinder);
    }
}
