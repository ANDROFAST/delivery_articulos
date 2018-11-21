package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

@zzha
public class zzcg {
    private final zzch zzoU;
    private final Map<String, zzcf> zzxa = new HashMap();

    public zzcg(zzch com_google_android_gms_internal_zzch) {
        this.zzoU = com_google_android_gms_internal_zzch;
    }

    public void zza(String str, zzcf com_google_android_gms_internal_zzcf) {
        this.zzxa.put(str, com_google_android_gms_internal_zzcf);
    }

    public void zza(String str, String str2, long j) {
        zzcd.zza(this.zzoU, (zzcf) this.zzxa.get(str2), j, str);
        this.zzxa.put(str, zzcd.zza(this.zzoU, j));
    }

    public zzch zzdt() {
        return this.zzoU;
    }
}
