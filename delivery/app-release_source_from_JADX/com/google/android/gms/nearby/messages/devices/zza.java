package com.google.android.gms.nearby.messages.devices;

import java.util.Arrays;

abstract class zza {
    private static final char[] zzaXa = "0123456789abcdef".toCharArray();
    private final byte[] zzaXb;

    protected zza(byte[] bArr) {
        this.zzaXb = bArr;
    }

    static String zzs(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            stringBuilder.append(zzaXa[(b >> 4) & 15]).append(zzaXa[b & 15]);
        }
        return stringBuilder.toString();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!o.getClass().isAssignableFrom(getClass())) {
            return false;
        }
        return Arrays.equals(this.zzaXb, ((zza) o).zzaXb);
    }

    byte[] getBytes() {
        return this.zzaXb;
    }

    public int hashCode() {
        return Arrays.hashCode(this.zzaXb);
    }

    public String toString() {
        return zzs(this.zzaXb);
    }

    String zzCC() {
        return zzs(this.zzaXb);
    }
}
