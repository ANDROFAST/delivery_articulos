package com.google.android.gms.internal;

import android.support.v4.util.ArrayMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class zznm {
    public static <K, V> Map<K, V> zza(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6) {
        Map arrayMap = new ArrayMap(6);
        arrayMap.put(k, v);
        arrayMap.put(k2, v2);
        arrayMap.put(k3, v3);
        arrayMap.put(k4, v4);
        arrayMap.put(k5, v5);
        arrayMap.put(k6, v6);
        return Collections.unmodifiableMap(arrayMap);
    }

    public static <T> Set<T> zza(T t, T t2, T t3) {
        Set com_google_android_gms_internal_zzng = new zzng(3);
        com_google_android_gms_internal_zzng.add(t);
        com_google_android_gms_internal_zzng.add(t2);
        com_google_android_gms_internal_zzng.add(t3);
        return Collections.unmodifiableSet(com_google_android_gms_internal_zzng);
    }

    public static <T> Set<T> zza(T t, T t2, T t3, T t4) {
        Set com_google_android_gms_internal_zzng = new zzng(4);
        com_google_android_gms_internal_zzng.add(t);
        com_google_android_gms_internal_zzng.add(t2);
        com_google_android_gms_internal_zzng.add(t3);
        com_google_android_gms_internal_zzng.add(t4);
        return Collections.unmodifiableSet(com_google_android_gms_internal_zzng);
    }

    public static <T> List<T> zzc(T t, T t2) {
        List arrayList = new ArrayList(2);
        arrayList.add(t);
        arrayList.add(t2);
        return Collections.unmodifiableList(arrayList);
    }

    public static <T> Set<T> zzc(T... tArr) {
        switch (tArr.length) {
            case 0:
                return zzrL();
            case 1:
                return zzz(tArr[0]);
            case 2:
                return zzd(tArr[0], tArr[1]);
            case 3:
                return zza(tArr[0], tArr[1], tArr[2]);
            case 4:
                return zza(tArr[0], tArr[1], tArr[2], tArr[3]);
            default:
                return Collections.unmodifiableSet(tArr.length <= 32 ? new zzng(Arrays.asList(tArr)) : new HashSet(Arrays.asList(tArr)));
        }
    }

    public static <T> Set<T> zzd(T t, T t2) {
        Set com_google_android_gms_internal_zzng = new zzng(2);
        com_google_android_gms_internal_zzng.add(t);
        com_google_android_gms_internal_zzng.add(t2);
        return Collections.unmodifiableSet(com_google_android_gms_internal_zzng);
    }

    public static <T> Set<T> zzrL() {
        return Collections.emptySet();
    }

    public static <T> Set<T> zzz(T t) {
        return Collections.singleton(t);
    }
}
