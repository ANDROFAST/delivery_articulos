package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.zztc;
import com.google.android.gms.internal.zztd;
import com.google.android.gms.internal.zzte;
import com.google.android.gms.internal.zztk;
import java.io.IOException;

public final class zzas extends zzte<zzas> {
    public int versionCode;
    public long zzapS;
    public long zzapT;
    public long zzapU;

    public zzas() {
        zzsL();
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzas)) {
            return false;
        }
        zzas com_google_android_gms_drive_internal_zzas = (zzas) o;
        if (this.versionCode != com_google_android_gms_drive_internal_zzas.versionCode || this.zzapS != com_google_android_gms_drive_internal_zzas.zzapS || this.zzapT != com_google_android_gms_drive_internal_zzas.zzapT || this.zzapU != com_google_android_gms_drive_internal_zzas.zzapU) {
            return false;
        }
        if (this.zzbpQ == null || this.zzbpQ.isEmpty()) {
            return com_google_android_gms_drive_internal_zzas.zzbpQ == null || com_google_android_gms_drive_internal_zzas.zzbpQ.isEmpty();
        } else {
            return this.zzbpQ.equals(com_google_android_gms_drive_internal_zzas.zzbpQ);
        }
    }

    public int hashCode() {
        int hashCode = (((((((((getClass().getName().hashCode() + 527) * 31) + this.versionCode) * 31) + ((int) (this.zzapS ^ (this.zzapS >>> 32)))) * 31) + ((int) (this.zzapT ^ (this.zzapT >>> 32)))) * 31) + ((int) (this.zzapU ^ (this.zzapU >>> 32)))) * 31;
        int hashCode2 = (this.zzbpQ == null || this.zzbpQ.isEmpty()) ? 0 : this.zzbpQ.hashCode();
        return hashCode2 + hashCode;
    }

    public /* synthetic */ zztk mergeFrom(zztc x0) throws IOException {
        return zzl(x0);
    }

    public void writeTo(zztd output) throws IOException {
        output.zzG(1, this.versionCode);
        output.zzc(2, this.zzapS);
        output.zzc(3, this.zzapT);
        output.zzc(4, this.zzapU);
        super.writeTo(output);
    }

    public zzas zzl(zztc com_google_android_gms_internal_zztc) throws IOException {
        while (true) {
            int zzHi = com_google_android_gms_internal_zztc.zzHi();
            switch (zzHi) {
                case 0:
                    break;
                case 8:
                    this.versionCode = com_google_android_gms_internal_zztc.zzHl();
                    continue;
                case 16:
                    this.zzapS = com_google_android_gms_internal_zztc.zzHo();
                    continue;
                case 24:
                    this.zzapT = com_google_android_gms_internal_zztc.zzHo();
                    continue;
                case 32:
                    this.zzapU = com_google_android_gms_internal_zztc.zzHo();
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

    public zzas zzsL() {
        this.versionCode = 1;
        this.zzapS = -1;
        this.zzapT = -1;
        this.zzapU = -1;
        this.zzbpQ = null;
        this.zzbqb = -1;
        return this;
    }

    protected int zzz() {
        return (((super.zzz() + zztd.zzI(1, this.versionCode)) + zztd.zze(2, this.zzapS)) + zztd.zze(3, this.zzapT)) + zztd.zze(4, this.zzapU);
    }
}
