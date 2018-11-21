package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Map;

@zzha
public class zzdo implements zzdl {
    private final zzdp zzyZ;

    public zzdo(zzdp com_google_android_gms_internal_zzdp) {
        this.zzyZ = com_google_android_gms_internal_zzdp;
    }

    public void zza(zzjn com_google_android_gms_internal_zzjn, Map<String, String> map) {
        float parseFloat;
        boolean equals = "1".equals(map.get("transparentBackground"));
        boolean equals2 = "1".equals(map.get("blur"));
        try {
            if (map.get("blurRadius") != null) {
                parseFloat = Float.parseFloat((String) map.get("blurRadius"));
                this.zzyZ.zzd(equals);
                this.zzyZ.zza(equals2, parseFloat);
            }
        } catch (Throwable e) {
            zzb.zzb("Fail to parse float", e);
        }
        parseFloat = 0.0f;
        this.zzyZ.zzd(equals);
        this.zzyZ.zza(equals2, parseFloat);
    }
}
