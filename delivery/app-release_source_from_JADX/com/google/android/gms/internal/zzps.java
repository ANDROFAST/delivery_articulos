package com.google.android.gms.internal;

import com.google.android.gms.auth.GoogleAuthUtil;

public class zzps {
    private static final ThreadLocal<String> zzaxs = new ThreadLocal();

    public static String zzE(String str, String str2) {
        if (str == null || str2 == null) {
            return str;
        }
        Object obj = new byte[(str.length() + str2.length())];
        System.arraycopy(str.getBytes(), 0, obj, 0, str.length());
        System.arraycopy(str2.getBytes(), 0, obj, str.length(), str2.length());
        return Integer.toHexString(zznw.zza(obj, 0, obj.length, 0));
    }

    public static String zzdr(String str) {
        return zzue() ? str : zzE(str, (String) zzaxs.get());
    }

    public static boolean zzue() {
        String str = (String) zzaxs.get();
        return str == null || str.startsWith(GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE);
    }
}
