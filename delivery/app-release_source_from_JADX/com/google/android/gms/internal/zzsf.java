package com.google.android.gms.internal;

import com.google.android.gms.internal.zzaf.zzf;
import com.google.android.gms.internal.zzaf.zzj;
import java.io.IOException;

public interface zzsf {

    public static final class zza extends zzte<zza> {
        public long zzbgX;
        public zzj zzbgY;
        public zzf zzjl;

        public zza() {
            zzFK();
        }

        public static zza zzx(byte[] bArr) throws zztj {
            return (zza) zztk.mergeFrom(new zza(), bArr);
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zzsf_zza = (zza) o;
            if (this.zzbgX != com_google_android_gms_internal_zzsf_zza.zzbgX) {
                return false;
            }
            if (this.zzjl == null) {
                if (com_google_android_gms_internal_zzsf_zza.zzjl != null) {
                    return false;
                }
            } else if (!this.zzjl.equals(com_google_android_gms_internal_zzsf_zza.zzjl)) {
                return false;
            }
            if (this.zzbgY == null) {
                if (com_google_android_gms_internal_zzsf_zza.zzbgY != null) {
                    return false;
                }
            } else if (!this.zzbgY.equals(com_google_android_gms_internal_zzsf_zza.zzbgY)) {
                return false;
            }
            if (this.zzbpQ == null || this.zzbpQ.isEmpty()) {
                return com_google_android_gms_internal_zzsf_zza.zzbpQ == null || com_google_android_gms_internal_zzsf_zza.zzbpQ.isEmpty();
            } else {
                return this.zzbpQ.equals(com_google_android_gms_internal_zzsf_zza.zzbpQ);
            }
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzbgY == null ? 0 : this.zzbgY.hashCode()) + (((this.zzjl == null ? 0 : this.zzjl.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + ((int) (this.zzbgX ^ (this.zzbgX >>> 32)))) * 31)) * 31)) * 31;
            if (!(this.zzbpQ == null || this.zzbpQ.isEmpty())) {
                i = this.zzbpQ.hashCode();
            }
            return hashCode + i;
        }

        public /* synthetic */ zztk mergeFrom(zztc x0) throws IOException {
            return zzy(x0);
        }

        public void writeTo(zztd output) throws IOException {
            output.zzb(1, this.zzbgX);
            if (this.zzjl != null) {
                output.zza(2, this.zzjl);
            }
            if (this.zzbgY != null) {
                output.zza(3, this.zzbgY);
            }
            super.writeTo(output);
        }

        public zza zzFK() {
            this.zzbgX = 0;
            this.zzjl = null;
            this.zzbgY = null;
            this.zzbpQ = null;
            this.zzbqb = -1;
            return this;
        }

        public zza zzy(zztc com_google_android_gms_internal_zztc) throws IOException {
            while (true) {
                int zzHi = com_google_android_gms_internal_zztc.zzHi();
                switch (zzHi) {
                    case 0:
                        break;
                    case 8:
                        this.zzbgX = com_google_android_gms_internal_zztc.zzHk();
                        continue;
                    case 18:
                        if (this.zzjl == null) {
                            this.zzjl = new zzf();
                        }
                        com_google_android_gms_internal_zztc.zza(this.zzjl);
                        continue;
                    case 26:
                        if (this.zzbgY == null) {
                            this.zzbgY = new zzj();
                        }
                        com_google_android_gms_internal_zztc.zza(this.zzbgY);
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

        protected int zzz() {
            int zzz = super.zzz() + zztd.zzd(1, this.zzbgX);
            if (this.zzjl != null) {
                zzz += zztd.zzc(2, this.zzjl);
            }
            return this.zzbgY != null ? zzz + zztd.zzc(3, this.zzbgY) : zzz;
        }
    }
}
