package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.internal.reward.client.zzf;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.internal.zzdb;
import com.google.android.gms.internal.zzha;

@zzha
public class zzl {
    private static final Object zzqf = new Object();
    private static zzl zzud;
    private final zza zzue = new zza();
    private final zze zzuf = new zze();
    private final zzad zzug = new zzad();
    private final zzdb zzuh = new zzdb();
    private final zzf zzui = new zzf();

    static {
        zza(new zzl());
    }

    protected zzl() {
    }

    protected static void zza(zzl com_google_android_gms_ads_internal_client_zzl) {
        synchronized (zzqf) {
            zzud = com_google_android_gms_ads_internal_client_zzl;
        }
    }

    private static zzl zzcM() {
        zzl com_google_android_gms_ads_internal_client_zzl;
        synchronized (zzqf) {
            com_google_android_gms_ads_internal_client_zzl = zzud;
        }
        return com_google_android_gms_ads_internal_client_zzl;
    }

    public static zza zzcN() {
        return zzcM().zzue;
    }

    public static zze zzcO() {
        return zzcM().zzuf;
    }

    public static zzad zzcP() {
        return zzcM().zzug;
    }

    public static zzdb zzcQ() {
        return zzcM().zzuh;
    }

    public static zzf zzcR() {
        return zzcM().zzui;
    }
}
