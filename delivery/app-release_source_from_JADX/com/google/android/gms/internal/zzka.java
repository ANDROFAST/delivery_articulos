package com.google.android.gms.internal;

import com.google.android.gms.measurement.zze;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class zzka extends zze<zzka> {
    private Map<Integer, Double> zzOs = new HashMap(4);

    public String toString() {
        Map hashMap = new HashMap();
        for (Entry entry : this.zzOs.entrySet()) {
            hashMap.put("metric" + entry.getKey(), entry.getValue());
        }
        return zze.zzE(hashMap);
    }

    public void zza(zzka com_google_android_gms_internal_zzka) {
        com_google_android_gms_internal_zzka.zzOs.putAll(this.zzOs);
    }

    public Map<Integer, Double> zziy() {
        return Collections.unmodifiableMap(this.zzOs);
    }
}
