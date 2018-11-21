package com.google.android.gms.internal;

import com.google.android.gms.measurement.zze;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class zzjz extends zze<zzjz> {
    private Map<Integer, String> zzOr = new HashMap(4);

    public String toString() {
        Map hashMap = new HashMap();
        for (Entry entry : this.zzOr.entrySet()) {
            hashMap.put("dimension" + entry.getKey(), entry.getValue());
        }
        return zze.zzE(hashMap);
    }

    public void zza(zzjz com_google_android_gms_internal_zzjz) {
        com_google_android_gms_internal_zzjz.zzOr.putAll(this.zzOr);
    }

    public Map<Integer, String> zzix() {
        return Collections.unmodifiableMap(this.zzOr);
    }
}
