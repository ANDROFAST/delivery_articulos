package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.measurement.zze;
import java.util.HashMap;
import java.util.Map;

public final class zzqh extends zze<zzqh> {
    private String zzRk;
    private String zzRl;
    private String zzaRG;
    private String zzaRd;

    public void setAppId(String value) {
        this.zzaRd = value;
    }

    public void setAppInstallerId(String value) {
        this.zzaRG = value;
    }

    public void setAppName(String value) {
        this.zzRk = value;
    }

    public void setAppVersion(String value) {
        this.zzRl = value;
    }

    public String toString() {
        Map hashMap = new HashMap();
        hashMap.put("appName", this.zzRk);
        hashMap.put("appVersion", this.zzRl);
        hashMap.put("appId", this.zzaRd);
        hashMap.put("appInstallerId", this.zzaRG);
        return zze.zzE(hashMap);
    }

    public void zza(zzqh com_google_android_gms_internal_zzqh) {
        if (!TextUtils.isEmpty(this.zzRk)) {
            com_google_android_gms_internal_zzqh.setAppName(this.zzRk);
        }
        if (!TextUtils.isEmpty(this.zzRl)) {
            com_google_android_gms_internal_zzqh.setAppVersion(this.zzRl);
        }
        if (!TextUtils.isEmpty(this.zzaRd)) {
            com_google_android_gms_internal_zzqh.setAppId(this.zzaRd);
        }
        if (!TextUtils.isEmpty(this.zzaRG)) {
            com_google_android_gms_internal_zzqh.setAppInstallerId(this.zzaRG);
        }
    }

    public String zzkP() {
        return this.zzRk;
    }

    public String zzkR() {
        return this.zzRl;
    }

    public String zzwg() {
        return this.zzaRd;
    }

    public String zzzT() {
        return this.zzaRG;
    }
}
