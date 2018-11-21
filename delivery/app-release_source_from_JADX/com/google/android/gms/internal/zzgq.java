package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzn;

@zzha
public class zzgq {

    public interface zza {
        void zzb(zzie com_google_android_gms_internal_zzie);
    }

    public zzir zza(Context context, com.google.android.gms.ads.internal.zza com_google_android_gms_ads_internal_zza, com.google.android.gms.internal.zzie.zza com_google_android_gms_internal_zzie_zza, zzan com_google_android_gms_internal_zzan, zzjn com_google_android_gms_internal_zzjn, zzew com_google_android_gms_internal_zzew, zza com_google_android_gms_internal_zzgq_zza, zzch com_google_android_gms_internal_zzch) {
        zzir com_google_android_gms_internal_zzgt;
        AdResponseParcel adResponseParcel = com_google_android_gms_internal_zzie_zza.zzJL;
        if (adResponseParcel.zzGN) {
            com_google_android_gms_internal_zzgt = new zzgt(context, com_google_android_gms_internal_zzie_zza, com_google_android_gms_internal_zzew, com_google_android_gms_internal_zzgq_zza, com_google_android_gms_internal_zzch);
        } else if (!adResponseParcel.zztY) {
            com_google_android_gms_internal_zzgt = adResponseParcel.zzGT ? new zzgo(context, com_google_android_gms_internal_zzie_zza, com_google_android_gms_internal_zzjn, com_google_android_gms_internal_zzgq_zza) : (((Boolean) zzbz.zzvZ.get()).booleanValue() && zznx.zzrU() && !zznx.isAtLeastL() && com_google_android_gms_internal_zzjn.zzaP().zztW) ? new zzgs(context, com_google_android_gms_internal_zzie_zza, com_google_android_gms_internal_zzjn, com_google_android_gms_internal_zzgq_zza) : new zzgr(context, com_google_android_gms_internal_zzie_zza, com_google_android_gms_internal_zzjn, com_google_android_gms_internal_zzgq_zza);
        } else if (com_google_android_gms_ads_internal_zza instanceof zzn) {
            com_google_android_gms_internal_zzgt = new zzgu(context, (zzn) com_google_android_gms_ads_internal_zza, new zzbc(), com_google_android_gms_internal_zzie_zza, com_google_android_gms_internal_zzan, com_google_android_gms_internal_zzgq_zza);
        } else {
            throw new IllegalArgumentException("Invalid NativeAdManager type. Found: " + (com_google_android_gms_ads_internal_zza != null ? com_google_android_gms_ads_internal_zza.getClass().getName() : "null") + "; Required: NativeAdManager.");
        }
        zzb.zzaF("AdRenderer: " + com_google_android_gms_internal_zzgt.getClass().getName());
        com_google_android_gms_internal_zzgt.zzfR();
        return com_google_android_gms_internal_zzgt;
    }
}
