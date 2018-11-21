package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.zztc;
import com.google.android.gms.internal.zztd;
import com.google.android.gms.internal.zzte;
import com.google.android.gms.internal.zztk;
import java.io.IOException;

public final class zzau extends zzte<zzau> {
    public long zzapT;
    public long zzapW;

    public zzau() {
        zzsN();
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzau)) {
            return false;
        }
        zzau com_google_android_gms_drive_internal_zzau = (zzau) o;
        if (this.zzapW != com_google_android_gms_drive_internal_zzau.zzapW || this.zzapT != com_google_android_gms_drive_internal_zzau.zzapT) {
            return false;
        }
        if (this.zzbpQ == null || this.zzbpQ.isEmpty()) {
            return com_google_android_gms_drive_internal_zzau.zzbpQ == null || com_google_android_gms_drive_internal_zzau.zzbpQ.isEmpty();
        } else {
            return this.zzbpQ.equals(com_google_android_gms_drive_internal_zzau.zzbpQ);
        }
    }

    public int hashCode() {
        int hashCode = (((((getClass().getName().hashCode() + 527) * 31) + ((int) (this.zzapW ^ (this.zzapW >>> 32)))) * 31) + ((int) (this.zzapT ^ (this.zzapT >>> 32)))) * 31;
        int hashCode2 = (this.zzbpQ == null || this.zzbpQ.isEmpty()) ? 0 : this.zzbpQ.hashCode();
        return hashCode2 + hashCode;
    }

    public /* synthetic */ zztk mergeFrom(zztc x0) throws IOException {
        return zzn(x0);
    }

    public void writeTo(zztd output) throws IOException {
        output.zzc(1, this.zzapW);
        output.zzc(2, this.zzapT);
        super.writeTo(output);
    }

    public zzau zzn(zztc com_google_android_gms_internal_zztc) throws IOException {
        while (true) {
            int zzHi = com_google_android_gms_internal_zztc.zzHi();
            switch (zzHi) {
                case 0:
                    break;
                case 8:
                    this.zzapW = com_google_android_gms_internal_zztc.zzHo();
                    continue;
                case 16:
                    this.zzapT = com_google_android_gms_internal_zztc.zzHo();
                    continue;
                default:
                    if (!zza(com_google_android_gms_internal_zztc, zzHi)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }

    public zzau zzsN() {
        this.zzapW = -1;
        this.zzapT = -1;
        this.zzbpQ = null;
        this.zzbqb = -1;
        return this;
    }

    protected int zzz() {
        return (super.zzz() + zztd.zze(1, this.zzapW)) + zztd.zze(2, this.zzapT);
    }
}
