package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.measurement.zze;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzkb extends zze<zzkb> {
    private final Map<String, Object> zzxc = new HashMap();

    private String zzaT(String str) {
        zzx.zzcG(str);
        if (str != null && str.startsWith("&")) {
            str = str.substring(1);
        }
        zzx.zzh(str, "Name can not be empty or \"&\"");
        return str;
    }

    public void set(String name, String value) {
        this.zzxc.put(zzaT(name), value);
    }

    public String toString() {
        return zze.zzE(this.zzxc);
    }

    public void zza(zzkb com_google_android_gms_internal_zzkb) {
        zzx.zzy(com_google_android_gms_internal_zzkb);
        com_google_android_gms_internal_zzkb.zzxc.putAll(this.zzxc);
    }

    public Map<String, Object> zziz() {
        return Collections.unmodifiableMap(this.zzxc);
    }
}
