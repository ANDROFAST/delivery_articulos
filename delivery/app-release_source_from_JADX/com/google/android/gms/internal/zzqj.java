package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.measurement.zze;
import java.util.HashMap;
import java.util.Map;

public final class zzqj extends zze<zzqj> {
    public int zzCC;
    public int zzCD;
    private String zzZe;
    public int zzaRN;
    public int zzaRO;
    public int zzaRP;

    public String getLanguage() {
        return this.zzZe;
    }

    public void setLanguage(String language) {
        this.zzZe = language;
    }

    public String toString() {
        Map hashMap = new HashMap();
        hashMap.put("language", this.zzZe);
        hashMap.put("screenColors", Integer.valueOf(this.zzaRN));
        hashMap.put("screenWidth", Integer.valueOf(this.zzCC));
        hashMap.put("screenHeight", Integer.valueOf(this.zzCD));
        hashMap.put("viewportWidth", Integer.valueOf(this.zzaRO));
        hashMap.put("viewportHeight", Integer.valueOf(this.zzaRP));
        return zze.zzE(hashMap);
    }

    public int zzAa() {
        return this.zzaRN;
    }

    public int zzAb() {
        return this.zzCC;
    }

    public int zzAc() {
        return this.zzCD;
    }

    public int zzAd() {
        return this.zzaRO;
    }

    public int zzAe() {
        return this.zzaRP;
    }

    public void zza(zzqj com_google_android_gms_internal_zzqj) {
        if (this.zzaRN != 0) {
            com_google_android_gms_internal_zzqj.zzio(this.zzaRN);
        }
        if (this.zzCC != 0) {
            com_google_android_gms_internal_zzqj.zzip(this.zzCC);
        }
        if (this.zzCD != 0) {
            com_google_android_gms_internal_zzqj.zziq(this.zzCD);
        }
        if (this.zzaRO != 0) {
            com_google_android_gms_internal_zzqj.zzir(this.zzaRO);
        }
        if (this.zzaRP != 0) {
            com_google_android_gms_internal_zzqj.zzis(this.zzaRP);
        }
        if (!TextUtils.isEmpty(this.zzZe)) {
            com_google_android_gms_internal_zzqj.setLanguage(this.zzZe);
        }
    }

    public void zzio(int i) {
        this.zzaRN = i;
    }

    public void zzip(int i) {
        this.zzCC = i;
    }

    public void zziq(int i) {
        this.zzCD = i;
    }

    public void zzir(int i) {
        this.zzaRO = i;
    }

    public void zzis(int i) {
        this.zzaRP = i;
    }
}
