package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzp;

@zzha
public class zzjp {
    public zzjn zza(Context context, AdSizeParcel adSizeParcel, boolean z, boolean z2, zzan com_google_android_gms_internal_zzan, VersionInfoParcel versionInfoParcel) {
        return zza(context, adSizeParcel, z, z2, com_google_android_gms_internal_zzan, versionInfoParcel, null, null);
    }

    public zzjn zza(Context context, AdSizeParcel adSizeParcel, boolean z, boolean z2, zzan com_google_android_gms_internal_zzan, VersionInfoParcel versionInfoParcel, zzch com_google_android_gms_internal_zzch, zzd com_google_android_gms_ads_internal_zzd) {
        zzjn com_google_android_gms_internal_zzjq = new zzjq(zzjr.zzb(context, adSizeParcel, z, z2, com_google_android_gms_internal_zzan, versionInfoParcel, com_google_android_gms_internal_zzch, com_google_android_gms_ads_internal_zzd));
        com_google_android_gms_internal_zzjq.setWebViewClient(zzp.zzbz().zzb(com_google_android_gms_internal_zzjq, z2));
        com_google_android_gms_internal_zzjq.setWebChromeClient(zzp.zzbz().zzh(com_google_android_gms_internal_zzjq));
        return com_google_android_gms_internal_zzjq;
    }
}
