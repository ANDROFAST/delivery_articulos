package com.google.android.gms.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class zzoq {
    private static final double zzaxl = (1000.0d / ((double) TimeUnit.SECONDS.toNanos(1)));
    private static final double zzaxm = (1000.0d / ((double) TimeUnit.SECONDS.toNanos(1)));
    private static final zzoq zzaxp = new zzoq();
    private final Map<String, Map<String, zza>> zzaxn;
    private final Map<String, zza> zzaxo;

    public static class zza {
        private final double zzaxq;
        private final double zzaxr;

        private zza(double d, double d2) {
            this.zzaxq = d;
            this.zzaxr = d2;
        }

        public boolean zzh(double d) {
            return d >= this.zzaxq && d <= this.zzaxr;
        }
    }

    private zzoq() {
        Map hashMap = new HashMap();
        hashMap.put(zzom.zzavw.name, new zza(-90.0d, 90.0d));
        hashMap.put(zzom.zzavx.name, new zza(-180.0d, 180.0d));
        hashMap.put(zzom.zzavy.name, new zza(0.0d, 10000.0d));
        hashMap.put(zzom.zzavv.name, new zza(0.0d, 1000.0d));
        hashMap.put(zzom.zzavz.name, new zza(-100000.0d, 100000.0d));
        hashMap.put(zzom.zzavE.name, new zza(0.0d, 100.0d));
        hashMap.put(zzom.zzavo.name, new zza(0.0d, 100.0d));
        hashMap.put(zzom.zzavr.name, new zza(0.0d, 9.223372036854776E18d));
        hashMap.put(zzom.zzavB.name, new zza(0.0d, 10.0d));
        hashMap.put(zzom.zzavC.name, new zza(0.0d, 1000.0d));
        hashMap.put(zzom.zzavF.name, new zza(0.0d, 200000.0d));
        this.zzaxo = Collections.unmodifiableMap(hashMap);
        hashMap = new HashMap();
        hashMap.put("com.google.step_count.delta", zzf(zzom.zzavq.name, new zza(0.0d, zzaxl)));
        hashMap.put("com.google.calories.consumed", zzf(zzom.zzavI.name, new zza(0.0d, zzaxm)));
        hashMap.put("com.google.calories.expended", zzf(zzom.zzavI.name, new zza(0.0d, zzaxm)));
        this.zzaxn = Collections.unmodifiableMap(hashMap);
    }

    private static <K, V> Map<K, V> zzf(K k, V v) {
        Map<K, V> hashMap = new HashMap();
        hashMap.put(k, v);
        return hashMap;
    }

    public static zzoq zzud() {
        return zzaxp;
    }

    public zza zzD(String str, String str2) {
        Map map = (Map) this.zzaxn.get(str);
        return map != null ? (zza) map.get(str2) : null;
    }

    public zza zzdq(String str) {
        return (zza) this.zzaxo.get(str);
    }
}
