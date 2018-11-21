package com.google.android.gms.analytics.internal;

import com.google.android.gms.internal.zzqh;

public class zzk extends zzd {
    private final zzqh zzPD = new zzqh();

    zzk(zzf com_google_android_gms_analytics_internal_zzf) {
        super(com_google_android_gms_analytics_internal_zzf);
    }

    public void zzim() {
        zzan zziq = zziq();
        String zzkP = zziq.zzkP();
        if (zzkP != null) {
            this.zzPD.setAppName(zzkP);
        }
        String zzkR = zziq.zzkR();
        if (zzkR != null) {
            this.zzPD.setAppVersion(zzkR);
        }
    }

    protected void zzir() {
        zziW().zzzR().zza(this.zzPD);
        zzim();
    }

    public zzqh zzjB() {
        zzje();
        return this.zzPD;
    }
}
