package com.google.android.gms.nearby.messages.devices;

import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public class zzb {
    private final zzc zzaXc;

    public zzb(byte[] bArr) {
        this.zzaXc = new zzc(zzt(bArr));
    }

    private static byte[] zzt(byte[] bArr) {
        zzx.zzb(bArr.length == 16, (Object) "Bytes must be a namespace plus instance ID (16 bytes).");
        return bArr;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof zzb)) {
            return false;
        }
        return zzw.equal(this.zzaXc, ((zzb) o).zzaXc);
    }

    public String getId() {
        return this.zzaXc.zzCC();
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaXc);
    }

    public String toString() {
        return "EddystoneUid{id=" + getId() + '}';
    }
}
