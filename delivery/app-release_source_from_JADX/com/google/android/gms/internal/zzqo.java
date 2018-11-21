package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.measurement.zze;
import java.util.HashMap;
import java.util.Map;

public final class zzqo extends zze<zzqo> {
    public String zzRA;
    public String zzaSa;
    public String zzaSb;

    public String getAction() {
        return this.zzRA;
    }

    public String getTarget() {
        return this.zzaSb;
    }

    public String toString() {
        Map hashMap = new HashMap();
        hashMap.put("network", this.zzaSa);
        hashMap.put("action", this.zzRA);
        hashMap.put("target", this.zzaSb);
        return zze.zzE(hashMap);
    }

    public String zzAq() {
        return this.zzaSa;
    }

    public void zza(zzqo com_google_android_gms_internal_zzqo) {
        if (!TextUtils.isEmpty(this.zzaSa)) {
            com_google_android_gms_internal_zzqo.zzes(this.zzaSa);
        }
        if (!TextUtils.isEmpty(this.zzRA)) {
            com_google_android_gms_internal_zzqo.zzeo(this.zzRA);
        }
        if (!TextUtils.isEmpty(this.zzaSb)) {
            com_google_android_gms_internal_zzqo.zzet(this.zzaSb);
        }
    }

    public void zzeo(String str) {
        this.zzRA = str;
    }

    public void zzes(String str) {
        this.zzaSa = str;
    }

    public void zzet(String str) {
        this.zzaSb = str;
    }
}
