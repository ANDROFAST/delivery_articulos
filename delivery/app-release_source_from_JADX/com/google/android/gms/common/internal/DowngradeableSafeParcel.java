package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public abstract class DowngradeableSafeParcel implements SafeParcelable {
    private static final Object zzajw = new Object();
    private static ClassLoader zzajx = null;
    private static Integer zzajy = null;
    private boolean zzajz = false;

    private static boolean zza(Class<?> cls) {
        boolean z = false;
        try {
            z = SafeParcelable.NULL.equals(cls.getField("NULL").get(null));
        } catch (NoSuchFieldException e) {
        } catch (IllegalAccessException e2) {
        }
        return z;
    }

    protected static boolean zzcz(String str) {
        ClassLoader zzqi = zzqi();
        if (zzqi == null) {
            return true;
        }
        try {
            return zza(zzqi.loadClass(str));
        } catch (Exception e) {
            return false;
        }
    }

    protected static ClassLoader zzqi() {
        ClassLoader classLoader;
        synchronized (zzajw) {
            classLoader = zzajx;
        }
        return classLoader;
    }

    protected static Integer zzqj() {
        Integer num;
        synchronized (zzajw) {
            num = zzajy;
        }
        return num;
    }

    protected boolean zzqk() {
        return this.zzajz;
    }
}
