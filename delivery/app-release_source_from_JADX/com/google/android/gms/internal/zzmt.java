package com.google.android.gms.internal;

import android.os.Binder;

public abstract class zzmt<T> {
    private static zza zzahn = null;
    private static int zzaho = 0;
    private static String zzahp = "com.google.android.providers.gsf.permission.READ_GSERVICES";
    private static final Object zzqf = new Object();
    private T zzRi = null;
    protected final String zzuX;
    protected final T zzuY;

    private interface zza {
        Long getLong(String str, Long l);

        String getString(String str, String str2);

        Boolean zza(String str, Boolean bool);

        Float zzb(String str, Float f);

        Integer zzb(String str, Integer num);
    }

    protected zzmt(String str, T t) {
        this.zzuX = str;
        this.zzuY = t;
    }

    public static boolean isInitialized() {
        return zzahn != null;
    }

    public static zzmt<Float> zza(String str, Float f) {
        return new zzmt<Float>(str, f) {
            protected /* synthetic */ Object zzcn(String str) {
                return zzcr(str);
            }

            protected Float zzcr(String str) {
                return zzmt.zzahn.zzb(this.zzuX, (Float) this.zzuY);
            }
        };
    }

    public static zzmt<Integer> zza(String str, Integer num) {
        return new zzmt<Integer>(str, num) {
            protected /* synthetic */ Object zzcn(String str) {
                return zzcq(str);
            }

            protected Integer zzcq(String str) {
                return zzmt.zzahn.zzb(this.zzuX, (Integer) this.zzuY);
            }
        };
    }

    public static zzmt<Long> zza(String str, Long l) {
        return new zzmt<Long>(str, l) {
            protected /* synthetic */ Object zzcn(String str) {
                return zzcp(str);
            }

            protected Long zzcp(String str) {
                return zzmt.zzahn.getLong(this.zzuX, (Long) this.zzuY);
            }
        };
    }

    public static zzmt<Boolean> zzg(String str, boolean z) {
        return new zzmt<Boolean>(str, Boolean.valueOf(z)) {
            protected /* synthetic */ Object zzcn(String str) {
                return zzco(str);
            }

            protected Boolean zzco(String str) {
                return zzmt.zzahn.zza(this.zzuX, (Boolean) this.zzuY);
            }
        };
    }

    public static int zzpE() {
        return zzaho;
    }

    public static zzmt<String> zzw(String str, String str2) {
        return new zzmt<String>(str, str2) {
            protected /* synthetic */ Object zzcn(String str) {
                return zzcs(str);
            }

            protected String zzcs(String str) {
                return zzmt.zzahn.getString(this.zzuX, (String) this.zzuY);
            }
        };
    }

    public final T get() {
        return this.zzRi != null ? this.zzRi : zzcn(this.zzuX);
    }

    protected abstract T zzcn(String str);

    public final T zzpF() {
        long clearCallingIdentity = Binder.clearCallingIdentity();
        try {
            T t = get();
            return t;
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }
}
