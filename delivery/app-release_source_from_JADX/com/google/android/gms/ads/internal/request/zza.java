package com.google.android.gms.ads.internal.request;

import android.content.Context;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzil;

@zzha
public class zza {

    public interface zza {
        void zza(com.google.android.gms.internal.zzie.zza com_google_android_gms_internal_zzie_zza);
    }

    public zzil zza(Context context, com.google.android.gms.ads.internal.request.AdRequestInfoParcel.zza com_google_android_gms_ads_internal_request_AdRequestInfoParcel_zza, zzan com_google_android_gms_internal_zzan, zza com_google_android_gms_ads_internal_request_zza_zza) {
        zzil com_google_android_gms_ads_internal_request_zzm = com_google_android_gms_ads_internal_request_AdRequestInfoParcel_zza.zzGq.extras.getBundle("sdk_less_server_data") != null ? new zzm(context, com_google_android_gms_ads_internal_request_AdRequestInfoParcel_zza, com_google_android_gms_ads_internal_request_zza_zza) : new zzb(context, com_google_android_gms_ads_internal_request_AdRequestInfoParcel_zza, com_google_android_gms_internal_zzan, com_google_android_gms_ads_internal_request_zza_zza);
        com_google_android_gms_ads_internal_request_zzm.zzgX();
        return com_google_android_gms_ads_internal_request_zzm;
    }
}
