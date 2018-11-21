package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.measurement.zze;
import java.util.HashMap;
import java.util.Map;

public final class zzkc extends zze<zzkc> {
    private String zzJg;
    private String zzOt;
    private String zzOu;
    private String zzOv;
    private boolean zzOw;
    private String zzOx;
    private boolean zzOy;
    private double zzOz;

    public String getClientId() {
        return this.zzOu;
    }

    public String getUserId() {
        return this.zzJg;
    }

    public void setClientId(String clientId) {
        this.zzOu = clientId;
    }

    public void setSampleRate(double percentage) {
        boolean z = percentage >= 0.0d && percentage <= 100.0d;
        zzx.zzb(z, (Object) "Sample rate must be between 0% and 100%");
        this.zzOz = percentage;
    }

    public void setUserId(String userId) {
        this.zzJg = userId;
    }

    public String toString() {
        Map hashMap = new HashMap();
        hashMap.put("hitType", this.zzOt);
        hashMap.put("clientId", this.zzOu);
        hashMap.put("userId", this.zzJg);
        hashMap.put("androidAdId", this.zzOv);
        hashMap.put("AdTargetingEnabled", Boolean.valueOf(this.zzOw));
        hashMap.put("sessionControl", this.zzOx);
        hashMap.put("nonInteraction", Boolean.valueOf(this.zzOy));
        hashMap.put("sampleRate", Double.valueOf(this.zzOz));
        return zze.zzE(hashMap);
    }

    public void zzH(boolean z) {
        this.zzOw = z;
    }

    public void zzI(boolean z) {
        this.zzOy = z;
    }

    public void zza(zzkc com_google_android_gms_internal_zzkc) {
        if (!TextUtils.isEmpty(this.zzOt)) {
            com_google_android_gms_internal_zzkc.zzaU(this.zzOt);
        }
        if (!TextUtils.isEmpty(this.zzOu)) {
            com_google_android_gms_internal_zzkc.setClientId(this.zzOu);
        }
        if (!TextUtils.isEmpty(this.zzJg)) {
            com_google_android_gms_internal_zzkc.setUserId(this.zzJg);
        }
        if (!TextUtils.isEmpty(this.zzOv)) {
            com_google_android_gms_internal_zzkc.zzaV(this.zzOv);
        }
        if (this.zzOw) {
            com_google_android_gms_internal_zzkc.zzH(true);
        }
        if (!TextUtils.isEmpty(this.zzOx)) {
            com_google_android_gms_internal_zzkc.zzaW(this.zzOx);
        }
        if (this.zzOy) {
            com_google_android_gms_internal_zzkc.zzI(this.zzOy);
        }
        if (this.zzOz != 0.0d) {
            com_google_android_gms_internal_zzkc.setSampleRate(this.zzOz);
        }
    }

    public void zzaU(String str) {
        this.zzOt = str;
    }

    public void zzaV(String str) {
        this.zzOv = str;
    }

    public void zzaW(String str) {
        this.zzOx = str;
    }

    public String zziA() {
        return this.zzOt;
    }

    public String zziB() {
        return this.zzOv;
    }

    public boolean zziC() {
        return this.zzOw;
    }

    public String zziD() {
        return this.zzOx;
    }

    public boolean zziE() {
        return this.zzOy;
    }

    public double zziF() {
        return this.zzOz;
    }
}
