package com.google.android.gms.internal;

import android.os.SystemClock;

public final class zzno implements zznl {
    private static zzno zzamk;

    public static synchronized zznl zzrM() {
        zznl com_google_android_gms_internal_zznl;
        synchronized (zzno.class) {
            if (zzamk == null) {
                zzamk = new zzno();
            }
            com_google_android_gms_internal_zznl = zzamk;
        }
        return com_google_android_gms_internal_zznl;
    }

    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public long elapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }

    public long nanoTime() {
        return System.nanoTime();
    }
}
