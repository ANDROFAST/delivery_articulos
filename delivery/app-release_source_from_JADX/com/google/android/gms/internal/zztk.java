package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

public abstract class zztk {
    protected volatile int zzbqb = -1;

    public static final <T extends zztk> T mergeFrom(T msg, byte[] data) throws zztj {
        return mergeFrom(msg, data, 0, data.length);
    }

    public static final <T extends zztk> T mergeFrom(T msg, byte[] data, int off, int len) throws zztj {
        try {
            zztc zza = zztc.zza(data, off, len);
            msg.mergeFrom(zza);
            zza.zzmk(0);
            return msg;
        } catch (zztj e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    public static final boolean messageNanoEquals(zztk a, zztk b) {
        if (a == b) {
            return true;
        }
        if (a == null || b == null || a.getClass() != b.getClass()) {
            return false;
        }
        int serializedSize = a.getSerializedSize();
        if (b.getSerializedSize() != serializedSize) {
            return false;
        }
        byte[] bArr = new byte[serializedSize];
        byte[] bArr2 = new byte[serializedSize];
        toByteArray(a, bArr, 0, serializedSize);
        toByteArray(b, bArr2, 0, serializedSize);
        return Arrays.equals(bArr, bArr2);
    }

    public static final void toByteArray(zztk msg, byte[] data, int offset, int length) {
        try {
            zztd zzb = zztd.zzb(data, offset, length);
            msg.writeTo(zzb);
            zzb.zzHy();
        } catch (Throwable e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public static final byte[] toByteArray(zztk msg) {
        byte[] bArr = new byte[msg.getSerializedSize()];
        toByteArray(msg, bArr, 0, bArr.length);
        return bArr;
    }

    public zztk clone() throws CloneNotSupportedException {
        return (zztk) super.clone();
    }

    public int getCachedSize() {
        if (this.zzbqb < 0) {
            getSerializedSize();
        }
        return this.zzbqb;
    }

    public int getSerializedSize() {
        int zzz = zzz();
        this.zzbqb = zzz;
        return zzz;
    }

    public abstract zztk mergeFrom(zztc com_google_android_gms_internal_zztc) throws IOException;

    public String toString() {
        return zztl.zzf(this);
    }

    public void writeTo(zztd output) throws IOException {
    }

    protected int zzz() {
        return 0;
    }
}
