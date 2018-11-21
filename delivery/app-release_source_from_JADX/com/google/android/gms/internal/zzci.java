package com.google.android.gms.internal;

import android.view.View;
import com.google.android.gms.ads.internal.zzg;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzck.zza;

@zzha
public final class zzci extends zza {
    private final zzg zzxg;
    private final String zzxh;
    private final String zzxi;

    public zzci(zzg com_google_android_gms_ads_internal_zzg, String str, String str2) {
        this.zzxg = com_google_android_gms_ads_internal_zzg;
        this.zzxh = str;
        this.zzxi = str2;
    }

    public String getContent() {
        return this.zzxi;
    }

    public void recordClick() {
        this.zzxg.recordClick();
    }

    public void recordImpression() {
        this.zzxg.recordImpression();
    }

    public void zza(zzd com_google_android_gms_dynamic_zzd) {
        if (com_google_android_gms_dynamic_zzd != null) {
            this.zzxg.zzc((View) zze.zzp(com_google_android_gms_dynamic_zzd));
        }
    }

    public String zzdy() {
        return this.zzxh;
    }
}
