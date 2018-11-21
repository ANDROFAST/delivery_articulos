package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.zzm.zza;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class zzcw<K, V> implements zzl<K, V> {
    private final Map<K, V> zzbfW = new HashMap();
    private final int zzbfX;
    private final zza<K, V> zzbfY;
    private int zzbfZ;

    zzcw(int i, zza<K, V> com_google_android_gms_tagmanager_zzm_zza_K__V) {
        this.zzbfX = i;
        this.zzbfY = com_google_android_gms_tagmanager_zzm_zza_K__V;
    }

    public synchronized V get(K key) {
        return this.zzbfW.get(key);
    }

    public synchronized void zzh(K k, V v) {
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        this.zzbfZ += this.zzbfY.sizeOf(k, v);
        if (this.zzbfZ > this.zzbfX) {
            Iterator it = this.zzbfW.entrySet().iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                this.zzbfZ -= this.zzbfY.sizeOf(entry.getKey(), entry.getValue());
                it.remove();
                if (this.zzbfZ <= this.zzbfX) {
                    break;
                }
            }
        }
        this.zzbfW.put(k, v);
    }
}
