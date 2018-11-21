package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.measurement.zze;
import com.google.android.gms.plus.PlusShare;
import java.util.HashMap;
import java.util.Map;

public final class zzql extends zze<zzql> {
    private String mCategory;
    private String zzRA;
    private long zzaBq;
    private String zzaRQ;

    public String getAction() {
        return this.zzRA;
    }

    public String getLabel() {
        return this.zzaRQ;
    }

    public long getValue() {
        return this.zzaBq;
    }

    public String toString() {
        Map hashMap = new HashMap();
        hashMap.put("category", this.mCategory);
        hashMap.put("action", this.zzRA);
        hashMap.put(PlusShare.KEY_CALL_TO_ACTION_LABEL, this.zzaRQ);
        hashMap.put("value", Long.valueOf(this.zzaBq));
        return zze.zzE(hashMap);
    }

    public String zzAj() {
        return this.mCategory;
    }

    public void zzN(long j) {
        this.zzaBq = j;
    }

    public void zza(zzql com_google_android_gms_internal_zzql) {
        if (!TextUtils.isEmpty(this.mCategory)) {
            com_google_android_gms_internal_zzql.zzen(this.mCategory);
        }
        if (!TextUtils.isEmpty(this.zzRA)) {
            com_google_android_gms_internal_zzql.zzeo(this.zzRA);
        }
        if (!TextUtils.isEmpty(this.zzaRQ)) {
            com_google_android_gms_internal_zzql.zzep(this.zzaRQ);
        }
        if (this.zzaBq != 0) {
            com_google_android_gms_internal_zzql.zzN(this.zzaBq);
        }
    }

    public void zzen(String str) {
        this.mCategory = str;
    }

    public void zzeo(String str) {
        this.zzRA = str;
    }

    public void zzep(String str) {
        this.zzaRQ = str;
    }
}
