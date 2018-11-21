package com.google.android.gms.measurement;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.measurement.internal.zzt;

public class AppMeasurement {
    private final zzt zzaQX;

    public interface zza {
        void zze(String str, String str2, Bundle bundle);
    }

    public AppMeasurement(zzt scion) {
        zzx.zzy(scion);
        this.zzaQX = scion;
    }

    public static AppMeasurement getInstance(Context context) {
        return zzt.zzaU(context).zzBC();
    }

    public void setMeasurementEnabled(boolean enabled) {
        this.zzaQX.zzBB().setMeasurementEnabled(enabled);
    }

    public void zzd(String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.zzaQX.zzBB().zze(str, str2, bundle);
    }
}
