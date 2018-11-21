package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;

class zzm<K, V> {
    final zza<K, V> zzbcD = new C07941(this);

    public interface zza<K, V> {
        int sizeOf(K k, V v);
    }

    class C07941 implements zza<K, V> {
        final /* synthetic */ zzm zzbcE;

        C07941(zzm com_google_android_gms_tagmanager_zzm) {
            this.zzbcE = com_google_android_gms_tagmanager_zzm;
        }

        public int sizeOf(K k, V v) {
            return 1;
        }
    }

    int zzEc() {
        return VERSION.SDK_INT;
    }

    public zzl<K, V> zza(int i, zza<K, V> com_google_android_gms_tagmanager_zzm_zza_K__V) {
        if (i > 0) {
            return zzEc() < 12 ? new zzcw(i, com_google_android_gms_tagmanager_zzm_zza_K__V) : new zzba(i, com_google_android_gms_tagmanager_zzm_zza_K__V);
        } else {
            throw new IllegalArgumentException("maxSize <= 0");
        }
    }
}
