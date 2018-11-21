package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.internal.zzaw.zza;

public final class zzt extends zza {
    private zzm zzbnf;
    private zzu zzbnj;
    private final Object zzpK = new Object();

    public void zza(zzu com_google_android_gms_wearable_internal_zzu) {
        synchronized (this.zzpK) {
            this.zzbnj = (zzu) zzx.zzy(com_google_android_gms_wearable_internal_zzu);
            zzm com_google_android_gms_wearable_internal_zzm = this.zzbnf;
        }
        if (com_google_android_gms_wearable_internal_zzm != null) {
            com_google_android_gms_wearable_internal_zzu.zzb(com_google_android_gms_wearable_internal_zzm);
        }
    }

    public void zzx(int i, int i2) {
        synchronized (this.zzpK) {
            zzu com_google_android_gms_wearable_internal_zzu = this.zzbnj;
            zzm com_google_android_gms_wearable_internal_zzm = new zzm(i, i2);
            this.zzbnf = com_google_android_gms_wearable_internal_zzm;
        }
        if (com_google_android_gms_wearable_internal_zzu != null) {
            com_google_android_gms_wearable_internal_zzu.zzb(com_google_android_gms_wearable_internal_zzm);
        }
    }
}
