package com.google.android.gms.nearby.messages.devices;

import com.google.android.gms.common.internal.zzx;

class zzc extends zza {
    public zzc(byte[] bArr) {
        super(zzt(bArr));
    }

    private static byte[] zzt(byte[] bArr) {
        boolean z = bArr.length == 10 || bArr.length == 16;
        zzx.zzb(z, (Object) "Bytes must be a namespace (10 bytes), or a namespace plus instance ID (16 bytes).");
        return bArr;
    }

    public String toString() {
        return "EddystoneUidPrefix{bytes=" + zzCC() + '}';
    }
}
