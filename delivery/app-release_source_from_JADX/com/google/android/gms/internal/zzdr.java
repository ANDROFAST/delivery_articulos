package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zze;
import java.util.Map;

@zzha
public class zzdr implements zzdl {
    static final Map<String, Integer> zzzd = zznm.zza("resize", Integer.valueOf(1), "playVideo", Integer.valueOf(2), "storePicture", Integer.valueOf(3), "createCalendarEvent", Integer.valueOf(4), "setOrientationProperties", Integer.valueOf(5), "closeResizedAd", Integer.valueOf(6));
    private final zze zzzb;
    private final zzfm zzzc;

    public zzdr(zze com_google_android_gms_ads_internal_zze, zzfm com_google_android_gms_internal_zzfm) {
        this.zzzb = com_google_android_gms_ads_internal_zze;
        this.zzzc = com_google_android_gms_internal_zzfm;
    }

    public void zza(zzjn com_google_android_gms_internal_zzjn, Map<String, String> map) {
        int intValue = ((Integer) zzzd.get((String) map.get("a"))).intValue();
        if (intValue == 5 || this.zzzb == null || this.zzzb.zzbg()) {
            switch (intValue) {
                case 1:
                    this.zzzc.zzg(map);
                    return;
                case 3:
                    new zzfo(com_google_android_gms_internal_zzjn, map).execute();
                    return;
                case 4:
                    new zzfl(com_google_android_gms_internal_zzjn, map).execute();
                    return;
                case 5:
                    new zzfn(com_google_android_gms_internal_zzjn, map).execute();
                    return;
                case 6:
                    this.zzzc.zzp(true);
                    return;
                default:
                    zzb.zzaG("Unknown MRAID command called.");
                    return;
            }
        }
        this.zzzb.zzp(null);
    }
}
