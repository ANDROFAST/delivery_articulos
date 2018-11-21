package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Map;

@zzha
public final class zzdg implements zzdl {
    private final zzdh zzyy;

    public zzdg(zzdh com_google_android_gms_internal_zzdh) {
        this.zzyy = com_google_android_gms_internal_zzdh;
    }

    public void zza(zzjn com_google_android_gms_internal_zzjn, Map<String, String> map) {
        String str = (String) map.get("name");
        if (str == null) {
            zzb.zzaH("App event with no name parameter.");
        } else {
            this.zzyy.onAppEvent(str, (String) map.get("info"));
        }
    }
}
