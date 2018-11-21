package com.google.android.gms.internal;

import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.zzp;

@zzha
public abstract class zzbv<T> {
    private final int zzuW;
    private final String zzuX;
    private final T zzuY;

    private zzbv(int i, String str, T t) {
        this.zzuW = i;
        this.zzuX = str;
        this.zzuY = t;
        zzp.zzbF().zza(this);
    }

    public static zzbv<Integer> zza(int i, String str, int i2) {
        return new zzbv<Integer>(i, str, Integer.valueOf(i2)) {
            public /* synthetic */ Object zza(SharedPreferences sharedPreferences) {
                return zzc(sharedPreferences);
            }

            public Integer zzc(SharedPreferences sharedPreferences) {
                return Integer.valueOf(sharedPreferences.getInt(getKey(), ((Integer) zzdk()).intValue()));
            }
        };
    }

    public static zzbv<Long> zza(int i, String str, long j) {
        return new zzbv<Long>(i, str, Long.valueOf(j)) {
            public /* synthetic */ Object zza(SharedPreferences sharedPreferences) {
                return zzd(sharedPreferences);
            }

            public Long zzd(SharedPreferences sharedPreferences) {
                return Long.valueOf(sharedPreferences.getLong(getKey(), ((Long) zzdk()).longValue()));
            }
        };
    }

    public static zzbv<Boolean> zza(int i, String str, Boolean bool) {
        return new zzbv<Boolean>(i, str, bool) {
            public /* synthetic */ Object zza(SharedPreferences sharedPreferences) {
                return zzb(sharedPreferences);
            }

            public Boolean zzb(SharedPreferences sharedPreferences) {
                return Boolean.valueOf(sharedPreferences.getBoolean(getKey(), ((Boolean) zzdk()).booleanValue()));
            }
        };
    }

    public static zzbv<String> zza(int i, String str, String str2) {
        return new zzbv<String>(i, str, str2) {
            public /* synthetic */ Object zza(SharedPreferences sharedPreferences) {
                return zze(sharedPreferences);
            }

            public String zze(SharedPreferences sharedPreferences) {
                return sharedPreferences.getString(getKey(), (String) zzdk());
            }
        };
    }

    public static zzbv<String> zzc(int i, String str) {
        zzbv<String> zza = zza(i, str, (String) null);
        zzp.zzbF().zzb(zza);
        return zza;
    }

    public static zzbv<String> zzd(int i, String str) {
        zzbv<String> zza = zza(i, str, (String) null);
        zzp.zzbF().zzc(zza);
        return zza;
    }

    public T get() {
        return zzp.zzbG().zzd(this);
    }

    public String getKey() {
        return this.zzuX;
    }

    protected abstract T zza(SharedPreferences sharedPreferences);

    public T zzdk() {
        return this.zzuY;
    }
}
