package com.google.android.gms.ads.internal.request;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzjg;

@zzha
public final class zzc {

    public interface zza {
        void zzb(AdResponseParcel adResponseParcel);
    }

    interface zzb {
        boolean zza(VersionInfoParcel versionInfoParcel);
    }

    public static zzir zza(final Context context, VersionInfoParcel versionInfoParcel, zzjg<AdRequestInfoParcel> com_google_android_gms_internal_zzjg_com_google_android_gms_ads_internal_request_AdRequestInfoParcel, zza com_google_android_gms_ads_internal_request_zzc_zza) {
        return zza(context, versionInfoParcel, com_google_android_gms_internal_zzjg_com_google_android_gms_ads_internal_request_AdRequestInfoParcel, com_google_android_gms_ads_internal_request_zzc_zza, new zzb() {
            public boolean zza(VersionInfoParcel versionInfoParcel) {
                return versionInfoParcel.zzLH || (GooglePlayServicesUtil.zzao(context) && !((Boolean) zzbz.zzvG.get()).booleanValue());
            }
        });
    }

    static zzir zza(Context context, VersionInfoParcel versionInfoParcel, zzjg<AdRequestInfoParcel> com_google_android_gms_internal_zzjg_com_google_android_gms_ads_internal_request_AdRequestInfoParcel, zza com_google_android_gms_ads_internal_request_zzc_zza, zzb com_google_android_gms_ads_internal_request_zzc_zzb) {
        return com_google_android_gms_ads_internal_request_zzc_zzb.zza(versionInfoParcel) ? zza(context, com_google_android_gms_internal_zzjg_com_google_android_gms_ads_internal_request_AdRequestInfoParcel, com_google_android_gms_ads_internal_request_zzc_zza) : zzb(context, versionInfoParcel, com_google_android_gms_internal_zzjg_com_google_android_gms_ads_internal_request_AdRequestInfoParcel, com_google_android_gms_ads_internal_request_zzc_zza);
    }

    private static zzir zza(Context context, zzjg<AdRequestInfoParcel> com_google_android_gms_internal_zzjg_com_google_android_gms_ads_internal_request_AdRequestInfoParcel, zza com_google_android_gms_ads_internal_request_zzc_zza) {
        com.google.android.gms.ads.internal.util.client.zzb.zzaF("Fetching ad response from local ad request service.");
        zzir com_google_android_gms_ads_internal_request_zzd_zza = new com.google.android.gms.ads.internal.request.zzd.zza(context, com_google_android_gms_internal_zzjg_com_google_android_gms_ads_internal_request_AdRequestInfoParcel, com_google_android_gms_ads_internal_request_zzc_zza);
        com_google_android_gms_ads_internal_request_zzd_zza.zzfO();
        return com_google_android_gms_ads_internal_request_zzd_zza;
    }

    private static zzir zzb(Context context, VersionInfoParcel versionInfoParcel, zzjg<AdRequestInfoParcel> com_google_android_gms_internal_zzjg_com_google_android_gms_ads_internal_request_AdRequestInfoParcel, zza com_google_android_gms_ads_internal_request_zzc_zza) {
        com.google.android.gms.ads.internal.util.client.zzb.zzaF("Fetching ad response from remote ad request service.");
        if (zzl.zzcN().zzT(context)) {
            return new com.google.android.gms.ads.internal.request.zzd.zzb(context, versionInfoParcel, com_google_android_gms_internal_zzjg_com_google_android_gms_ads_internal_request_AdRequestInfoParcel, com_google_android_gms_ads_internal_request_zzc_zza);
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("Failed to connect to remote ad request service.");
        return null;
    }
}
