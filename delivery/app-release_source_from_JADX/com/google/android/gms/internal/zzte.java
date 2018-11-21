package com.google.android.gms.internal;

import java.io.IOException;

public abstract class zzte<M extends zzte<M>> extends zztk {
    protected zztg zzbpQ;

    public /* synthetic */ zztk clone() throws CloneNotSupportedException {
        return zzHz();
    }

    public /* synthetic */ Object m1313clone() throws CloneNotSupportedException {
        return zzHz();
    }

    public void writeTo(zztd output) throws IOException {
        if (this.zzbpQ != null) {
            for (int i = 0; i < this.zzbpQ.size(); i++) {
                this.zzbpQ.zzmD(i).writeTo(output);
            }
        }
    }

    public M zzHz() throws CloneNotSupportedException {
        zzte com_google_android_gms_internal_zzte = (zzte) super.clone();
        zzti.zza(this, com_google_android_gms_internal_zzte);
        return com_google_android_gms_internal_zzte;
    }

    public final <T> T zza(zztf<M, T> com_google_android_gms_internal_zztf_M__T) {
        if (this.zzbpQ == null) {
            return null;
        }
        zzth zzmC = this.zzbpQ.zzmC(zztn.zzmG(com_google_android_gms_internal_zztf_M__T.tag));
        return zzmC != null ? zzmC.zzb(com_google_android_gms_internal_zztf_M__T) : null;
    }

    protected final boolean zza(zztc com_google_android_gms_internal_zztc, int i) throws IOException {
        int position = com_google_android_gms_internal_zztc.getPosition();
        if (!com_google_android_gms_internal_zztc.zzml(i)) {
            return false;
        }
        int zzmG = zztn.zzmG(i);
        zztm com_google_android_gms_internal_zztm = new zztm(i, com_google_android_gms_internal_zztc.zzF(position, com_google_android_gms_internal_zztc.getPosition() - position));
        zzth com_google_android_gms_internal_zzth = null;
        if (this.zzbpQ == null) {
            this.zzbpQ = new zztg();
        } else {
            com_google_android_gms_internal_zzth = this.zzbpQ.zzmC(zzmG);
        }
        if (com_google_android_gms_internal_zzth == null) {
            com_google_android_gms_internal_zzth = new zzth();
            this.zzbpQ.zza(zzmG, com_google_android_gms_internal_zzth);
        }
        com_google_android_gms_internal_zzth.zza(com_google_android_gms_internal_zztm);
        return true;
    }

    protected int zzz() {
        int i = 0;
        if (this.zzbpQ == null) {
            return 0;
        }
        int i2 = 0;
        while (i < this.zzbpQ.size()) {
            i2 += this.zzbpQ.zzmD(i).zzz();
            i++;
        }
        return i2;
    }
}
