package com.google.android.gms.internal;

import java.io.IOException;

public final class zztn {
    public static final long[] zzboC = new long[0];
    public static final int[] zzboD = new int[0];
    public static final float[] zzbqd = new float[0];
    public static final double[] zzbqe = new double[0];
    public static final boolean[] zzbqf = new boolean[0];
    public static final String[] zzbqg = new String[0];
    public static final byte[][] zzbqh = new byte[0][];
    public static final byte[] zzbqi = new byte[0];

    static int zzL(int i, int i2) {
        return (i << 3) | i2;
    }

    public static boolean zzb(zztc com_google_android_gms_internal_zztc, int i) throws IOException {
        return com_google_android_gms_internal_zztc.zzml(i);
    }

    public static final int zzc(zztc com_google_android_gms_internal_zztc, int i) throws IOException {
        int i2 = 1;
        int position = com_google_android_gms_internal_zztc.getPosition();
        com_google_android_gms_internal_zztc.zzml(i);
        while (com_google_android_gms_internal_zztc.zzHi() == i) {
            com_google_android_gms_internal_zztc.zzml(i);
            i2++;
        }
        com_google_android_gms_internal_zztc.zzmp(position);
        return i2;
    }

    static int zzmF(int i) {
        return i & 7;
    }

    public static int zzmG(int i) {
        return i >>> 3;
    }
}
