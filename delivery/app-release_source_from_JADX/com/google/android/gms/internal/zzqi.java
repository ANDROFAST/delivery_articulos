package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.measurement.zze;
import java.util.HashMap;
import java.util.Map;

public final class zzqi extends zze<zzqi> {
    private String mName;
    private String zzaMP;
    private String zzaRH;
    private String zzaRI;
    private String zzaRJ;
    private String zzaRK;
    private String zzaRL;
    private String zzaRM;
    private String zzxX;
    private String zzxi;

    public String getContent() {
        return this.zzxi;
    }

    public String getId() {
        return this.zzxX;
    }

    public String getName() {
        return this.mName;
    }

    public String getSource() {
        return this.zzaMP;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String toString() {
        Map hashMap = new HashMap();
        hashMap.put("name", this.mName);
        hashMap.put("source", this.zzaMP);
        hashMap.put("medium", this.zzaRH);
        hashMap.put("keyword", this.zzaRI);
        hashMap.put("content", this.zzxi);
        hashMap.put("id", this.zzxX);
        hashMap.put("adNetworkId", this.zzaRJ);
        hashMap.put("gclid", this.zzaRK);
        hashMap.put("dclid", this.zzaRL);
        hashMap.put("aclid", this.zzaRM);
        return zze.zzE(hashMap);
    }

    public void zza(zzqi com_google_android_gms_internal_zzqi) {
        if (!TextUtils.isEmpty(this.mName)) {
            com_google_android_gms_internal_zzqi.setName(this.mName);
        }
        if (!TextUtils.isEmpty(this.zzaMP)) {
            com_google_android_gms_internal_zzqi.zzee(this.zzaMP);
        }
        if (!TextUtils.isEmpty(this.zzaRH)) {
            com_google_android_gms_internal_zzqi.zzef(this.zzaRH);
        }
        if (!TextUtils.isEmpty(this.zzaRI)) {
            com_google_android_gms_internal_zzqi.zzeg(this.zzaRI);
        }
        if (!TextUtils.isEmpty(this.zzxi)) {
            com_google_android_gms_internal_zzqi.zzeh(this.zzxi);
        }
        if (!TextUtils.isEmpty(this.zzxX)) {
            com_google_android_gms_internal_zzqi.zzei(this.zzxX);
        }
        if (!TextUtils.isEmpty(this.zzaRJ)) {
            com_google_android_gms_internal_zzqi.zzej(this.zzaRJ);
        }
        if (!TextUtils.isEmpty(this.zzaRK)) {
            com_google_android_gms_internal_zzqi.zzek(this.zzaRK);
        }
        if (!TextUtils.isEmpty(this.zzaRL)) {
            com_google_android_gms_internal_zzqi.zzel(this.zzaRL);
        }
        if (!TextUtils.isEmpty(this.zzaRM)) {
            com_google_android_gms_internal_zzqi.zzem(this.zzaRM);
        }
    }

    public void zzee(String str) {
        this.zzaMP = str;
    }

    public void zzef(String str) {
        this.zzaRH = str;
    }

    public void zzeg(String str) {
        this.zzaRI = str;
    }

    public void zzeh(String str) {
        this.zzxi = str;
    }

    public void zzei(String str) {
        this.zzxX = str;
    }

    public void zzej(String str) {
        this.zzaRJ = str;
    }

    public void zzek(String str) {
        this.zzaRK = str;
    }

    public void zzel(String str) {
        this.zzaRL = str;
    }

    public void zzem(String str) {
        this.zzaRM = str;
    }

    public String zzzU() {
        return this.zzaRH;
    }

    public String zzzV() {
        return this.zzaRI;
    }

    public String zzzW() {
        return this.zzaRJ;
    }

    public String zzzX() {
        return this.zzaRK;
    }

    public String zzzY() {
        return this.zzaRL;
    }

    public String zzzZ() {
        return this.zzaRM;
    }
}
