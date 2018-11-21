package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.measurement.zze;
import com.google.android.gms.plus.PlusShare;
import java.util.HashMap;
import java.util.Map;

public final class zzqp extends zze<zzqp> {
    public String mCategory;
    public String zzaRQ;
    public String zzaSc;
    public long zzaSd;

    public String getLabel() {
        return this.zzaRQ;
    }

    public long getTimeInMillis() {
        return this.zzaSd;
    }

    public void setTimeInMillis(long milliseconds) {
        this.zzaSd = milliseconds;
    }

    public String toString() {
        Map hashMap = new HashMap();
        hashMap.put("variableName", this.zzaSc);
        hashMap.put("timeInMillis", Long.valueOf(this.zzaSd));
        hashMap.put("category", this.mCategory);
        hashMap.put(PlusShare.KEY_CALL_TO_ACTION_LABEL, this.zzaRQ);
        return zze.zzE(hashMap);
    }

    public String zzAj() {
        return this.mCategory;
    }

    public String zzAr() {
        return this.zzaSc;
    }

    public void zza(zzqp com_google_android_gms_internal_zzqp) {
        if (!TextUtils.isEmpty(this.zzaSc)) {
            com_google_android_gms_internal_zzqp.zzeu(this.zzaSc);
        }
        if (this.zzaSd != 0) {
            com_google_android_gms_internal_zzqp.setTimeInMillis(this.zzaSd);
        }
        if (!TextUtils.isEmpty(this.mCategory)) {
            com_google_android_gms_internal_zzqp.zzen(this.mCategory);
        }
        if (!TextUtils.isEmpty(this.zzaRQ)) {
            com_google_android_gms_internal_zzqp.zzep(this.zzaRQ);
        }
    }

    public void zzen(String str) {
        this.mCategory = str;
    }

    public void zzep(String str) {
        this.zzaRQ = str;
    }

    public void zzeu(String str) {
        this.zzaSc = str;
    }
}
