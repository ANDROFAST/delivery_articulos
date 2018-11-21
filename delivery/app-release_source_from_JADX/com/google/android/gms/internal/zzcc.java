package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.zzb;

@zzha
public class zzcc {
    public zzcb zza(zzca com_google_android_gms_internal_zzca) {
        if (com_google_android_gms_internal_zzca == null) {
            throw new IllegalArgumentException("CSI configuration can't be null. ");
        } else if (!com_google_android_gms_internal_zzca.zzdn()) {
            zzb.m7v("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
            return null;
        } else if (com_google_android_gms_internal_zzca.getContext() == null) {
            throw new IllegalArgumentException("Context can't be null. Please set up context in CsiConfiguration.");
        } else if (!TextUtils.isEmpty(com_google_android_gms_internal_zzca.zzbY())) {
            return new zzcb(com_google_android_gms_internal_zzca.getContext(), com_google_android_gms_internal_zzca.zzbY(), com_google_android_gms_internal_zzca.zzdo(), com_google_android_gms_internal_zzca.zzdp());
        } else {
            throw new IllegalArgumentException("AfmaVersion can't be null or empty. Please set up afmaVersion in CsiConfiguration.");
        }
    }
}
