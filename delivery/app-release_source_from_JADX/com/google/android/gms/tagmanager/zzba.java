package com.google.android.gms.tagmanager;

import android.util.LruCache;
import com.google.android.gms.tagmanager.zzm.zza;

class zzba<K, V> implements zzl<K, V> {
    private LruCache<K, V> zzbej;

    zzba(int i, final zza<K, V> com_google_android_gms_tagmanager_zzm_zza_K__V) {
        this.zzbej = new LruCache<K, V>(this, i) {
            final /* synthetic */ zzba zzbel;

            protected int sizeOf(K key, V value) {
                return com_google_android_gms_tagmanager_zzm_zza_K__V.sizeOf(key, value);
            }
        };
    }

    public V get(K key) {
        return this.zzbej.get(key);
    }

    public void zzh(K k, V v) {
        this.zzbej.put(k, v);
    }
}
