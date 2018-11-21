package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.zztc;
import com.google.android.gms.internal.zztd;
import com.google.android.gms.internal.zzte;
import com.google.android.gms.internal.zztj;
import com.google.android.gms.internal.zztk;
import java.io.IOException;

public final class zzat extends zzte<zzat> {
    public int versionCode;
    public long zzapT;
    public String zzapV;
    public long zzapW;
    public int zzapX;

    public zzat() {
        zzsM();
    }

    public static zzat zzm(byte[] bArr) throws zztj {
        return (zzat) zztk.mergeFrom(new zzat(), bArr);
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzat)) {
            return false;
        }
        zzat com_google_android_gms_drive_internal_zzat = (zzat) o;
        if (this.versionCode != com_google_android_gms_drive_internal_zzat.versionCode) {
            return false;
        }
        if (this.zzapV == null) {
            if (com_google_android_gms_drive_internal_zzat.zzapV != null) {
                return false;
            }
        } else if (!this.zzapV.equals(com_google_android_gms_drive_internal_zzat.zzapV)) {
            return false;
        }
        if (this.zzapW != com_google_android_gms_drive_internal_zzat.zzapW || this.zzapT != com_google_android_gms_drive_internal_zzat.zzapT || this.zzapX != com_google_android_gms_drive_internal_zzat.zzapX) {
            return false;
        }
        if (this.zzbpQ == null || this.zzbpQ.isEmpty()) {
            return com_google_android_gms_drive_internal_zzat.zzbpQ == null || com_google_android_gms_drive_internal_zzat.zzbpQ.isEmpty();
        } else {
            return this.zzbpQ.equals(com_google_android_gms_drive_internal_zzat.zzbpQ);
        }
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((((((this.zzapV == null ? 0 : this.zzapV.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + this.versionCode) * 31)) * 31) + ((int) (this.zzapW ^ (this.zzapW >>> 32)))) * 31) + ((int) (this.zzapT ^ (this.zzapT >>> 32)))) * 31) + this.zzapX) * 31;
        if (!(this.zzbpQ == null || this.zzbpQ.isEmpty())) {
            i = this.zzbpQ.hashCode();
        }
        return hashCode + i;
    }

    public /* synthetic */ zztk mergeFrom(zztc x0) throws IOException {
        return zzm(x0);
    }

    public void writeTo(zztd output) throws IOException {
        output.zzG(1, this.versionCode);
        output.zzb(2, this.zzapV);
        output.zzc(3, this.zzapW);
        output.zzc(4, this.zzapT);
        if (this.zzapX != -1) {
            output.zzG(5, this.zzapX);
        }
        super.writeTo(output);
    }

    public zzat zzm(zztc com_google_android_gms_internal_zztc) throws IOException {
        while (true) {
            int zzHi = com_google_android_gms_internal_zztc.zzHi();
            switch (zzHi) {
                case 0:
                    break;
                case 8:
                    this.versionCode = com_google_android_gms_internal_zztc.zzHl();
                    continue;
                case 18:
                    this.zzapV = com_google_android_gms_internal_zztc.readString();
                    continue;
                case 24:
                    this.zzapW = com_google_android_gms_internal_zztc.zzHo();
                    continue;
                case 32:
                    this.zzapT = com_google_android_gms_internal_zztc.zzHo();
                    continue;
                case 40:
                    this.zzapX = com_google_android_gms_internal_zztc.zzHl();
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

    public zzat zzsM() {
        this.versionCode = 1;
        this.zzapV = "";
        this.zzapW = -1;
        this.zzapT = -1;
        this.zzapX = -1;
        this.zzbpQ = null;
        this.zzbqb = -1;
        return this;
    }

    protected int zzz() {
        int zzz = (((super.zzz() + zztd.zzI(1, this.versionCode)) + zztd.zzp(2, this.zzapV)) + zztd.zze(3, this.zzapW)) + zztd.zze(4, this.zzapT);
        return this.zzapX != -1 ? zzz + zztd.zzI(5, this.zzapX) : zzz;
    }
}
