package com.google.android.gms.analytics.internal;

public enum zzo {
    NONE,
    GZIP;

    public static zzo zzbk(String str) {
        return "GZIP".equalsIgnoreCase(str) ? GZIP : NONE;
    }
}
