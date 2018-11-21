package com.google.android.gms.nearby.messages.devices;

import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import java.util.UUID;

public class zzd {
    private final zze zzaXd;

    public zzd(byte[] bArr) {
        this.zzaXd = new zze(zzt(bArr));
    }

    private static byte[] zzt(byte[] bArr) {
        zzx.zzb(bArr.length == 20, (Object) "iBeacon ID must be a UUID, a major, and a minor (20 total bytes).");
        return bArr;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof zzd)) {
            return false;
        }
        return zzw.equal(this.zzaXd, ((zzd) o).zzaXd);
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaXd);
    }

    public String toString() {
        return "IBeaconId{proximityUuid=" + zzCD() + ", major=" + zzCE() + ", minor=" + zzCF() + '}';
    }

    public UUID zzCD() {
        return this.zzaXd.zzCD();
    }

    public short zzCE() {
        return this.zzaXd.zzCG().shortValue();
    }

    public short zzCF() {
        return this.zzaXd.zzCH().shortValue();
    }
}
