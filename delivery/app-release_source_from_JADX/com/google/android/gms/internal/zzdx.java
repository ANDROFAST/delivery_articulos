package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;

@zzha
public class zzdx implements zzdl {
    public void zza(zzjn com_google_android_gms_internal_zzjn, Map<String, String> map) {
        zzdv zzbL = zzp.zzbL();
        if (!map.containsKey("abort")) {
            String str = (String) map.get("src");
            if (str == null) {
                zzb.zzaH("Precache video action is missing the src parameter.");
                return;
            }
            int parseInt;
            try {
                parseInt = Integer.parseInt((String) map.get("player"));
            } catch (NumberFormatException e) {
                parseInt = 0;
            }
            String str2 = map.containsKey("mimetype") ? (String) map.get("mimetype") : "";
            if (zzbL.zzb(com_google_android_gms_internal_zzjn)) {
                zzb.zzaH("Precache task already running.");
                return;
            }
            com.google.android.gms.common.internal.zzb.zzu(com_google_android_gms_internal_zzjn.zzhz());
            new zzdu(com_google_android_gms_internal_zzjn, com_google_android_gms_internal_zzjn.zzhz().zzpm.zza(com_google_android_gms_internal_zzjn, parseInt, str2), str).zzgX();
        } else if (!zzbL.zza(com_google_android_gms_internal_zzjn)) {
            zzb.zzaH("Precache abort but no preload task running.");
        }
    }
}
