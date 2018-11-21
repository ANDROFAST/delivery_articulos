package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

@zzha
public abstract class zzhk {
    public abstract void zza(Context context, zzhe com_google_android_gms_internal_zzhe, VersionInfoParcel versionInfoParcel);

    protected void zze(zzhe com_google_android_gms_internal_zzhe) {
        com_google_android_gms_internal_zzhe.zzgq();
        if (com_google_android_gms_internal_zzhe.zzgo() != null) {
            com_google_android_gms_internal_zzhe.zzgo().release();
        }
    }
}
