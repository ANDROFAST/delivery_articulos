package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznl;
import com.google.android.gms.measurement.zzg;

public class zzc {
    private final zzf zzOP;

    protected zzc(zzf com_google_android_gms_analytics_internal_zzf) {
        zzx.zzy(com_google_android_gms_analytics_internal_zzf);
        this.zzOP = com_google_android_gms_analytics_internal_zzf;
    }

    private void zza(int i, String str, Object obj, Object obj2, Object obj3) {
        zzaf com_google_android_gms_analytics_internal_zzaf = null;
        if (this.zzOP != null) {
            com_google_android_gms_analytics_internal_zzaf = this.zzOP.zzjh();
        }
        if (com_google_android_gms_analytics_internal_zzaf != null) {
            com_google_android_gms_analytics_internal_zzaf.zza(i, str, obj, obj2, obj3);
            return;
        }
        String str2 = (String) zzy.zzQr.get();
        if (Log.isLoggable(str2, i)) {
            Log.println(i, str2, zzc(str, obj, obj2, obj3));
        }
    }

    protected static String zzc(String str, Object obj, Object obj2, Object obj3) {
        if (str == null) {
            Object obj4 = "";
        }
        Object zzi = zzi(obj);
        Object zzi2 = zzi(obj2);
        Object zzi3 = zzi(obj3);
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "";
        if (!TextUtils.isEmpty(obj4)) {
            stringBuilder.append(obj4);
            str2 = ": ";
        }
        if (!TextUtils.isEmpty(zzi)) {
            stringBuilder.append(str2);
            stringBuilder.append(zzi);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(zzi2)) {
            stringBuilder.append(str2);
            stringBuilder.append(zzi2);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(zzi3)) {
            stringBuilder.append(str2);
            stringBuilder.append(zzi3);
            str2 = ", ";
        }
        return stringBuilder.toString();
    }

    private static String zzi(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        if (!(obj instanceof Boolean)) {
            return obj instanceof Throwable ? ((Throwable) obj).toString() : obj.toString();
        } else {
            return obj == Boolean.TRUE ? "true" : "false";
        }
    }

    protected Context getContext() {
        return this.zzOP.getContext();
    }

    public void zza(String str, Object obj) {
        zza(2, str, obj, null, null);
    }

    public void zza(String str, Object obj, Object obj2) {
        zza(2, str, obj, obj2, null);
    }

    public void zza(String str, Object obj, Object obj2, Object obj3) {
        zza(3, str, obj, obj2, obj3);
    }

    public void zzb(String str, Object obj) {
        zza(3, str, obj, null, null);
    }

    public void zzb(String str, Object obj, Object obj2) {
        zza(3, str, obj, obj2, null);
    }

    public void zzb(String str, Object obj, Object obj2, Object obj3) {
        zza(5, str, obj, obj2, obj3);
    }

    public void zzba(String str) {
        zza(2, str, null, null, null);
    }

    public void zzbb(String str) {
        zza(3, str, null, null, null);
    }

    public void zzbc(String str) {
        zza(4, str, null, null, null);
    }

    public void zzbd(String str) {
        zza(5, str, null, null, null);
    }

    public void zzbe(String str) {
        zza(6, str, null, null, null);
    }

    public void zzc(String str, Object obj) {
        zza(4, str, obj, null, null);
    }

    public void zzc(String str, Object obj, Object obj2) {
        zza(5, str, obj, obj2, null);
    }

    public void zzd(String str, Object obj) {
        zza(5, str, obj, null, null);
    }

    public void zzd(String str, Object obj, Object obj2) {
        zza(6, str, obj, obj2, null);
    }

    public void zze(String str, Object obj) {
        zza(6, str, obj, null, null);
    }

    public zzf zziQ() {
        return this.zzOP;
    }

    protected void zziR() {
        if (zziV().zzka()) {
            throw new IllegalStateException("Call only supported on the client side");
        }
    }

    protected void zziS() {
        this.zzOP.zziS();
    }

    protected zznl zziT() {
        return this.zzOP.zziT();
    }

    protected zzaf zziU() {
        return this.zzOP.zziU();
    }

    protected zzr zziV() {
        return this.zzOP.zziV();
    }

    protected zzg zziW() {
        return this.zzOP.zziW();
    }

    protected zzv zziX() {
        return this.zzOP.zziX();
    }

    protected zzai zziY() {
        return this.zzOP.zziY();
    }

    protected zzn zziZ() {
        return this.zzOP.zzjl();
    }

    public GoogleAnalytics zzik() {
        return this.zzOP.zzji();
    }

    protected zzb zzip() {
        return this.zzOP.zzip();
    }

    protected zzan zziq() {
        return this.zzOP.zziq();
    }

    protected zza zzja() {
        return this.zzOP.zzjk();
    }

    protected zzk zzjb() {
        return this.zzOP.zzjb();
    }

    protected zzu zzjc() {
        return this.zzOP.zzjc();
    }

    public boolean zzjd() {
        return Log.isLoggable((String) zzy.zzQr.get(), 2);
    }
}
