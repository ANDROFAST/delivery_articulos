package com.google.android.gms.internal;

import java.io.IOException;

public interface zzto {

    public static final class zza extends zztk {
        public String name;
        public zzb[] zzbqj;

        public zza() {
            zzHJ();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zzto_zza = (zza) o;
            if (this.name == null) {
                if (com_google_android_gms_internal_zzto_zza.name != null) {
                    return false;
                }
            } else if (!this.name.equals(com_google_android_gms_internal_zzto_zza.name)) {
                return false;
            }
            return zzti.equals(this.zzbqj, com_google_android_gms_internal_zzto_zza.zzbqj);
        }

        public int hashCode() {
            return (((this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + zzti.hashCode(this.zzbqj);
        }

        public /* synthetic */ zztk mergeFrom(zztc x0) throws IOException {
            return zzF(x0);
        }

        public void writeTo(zztd output) throws IOException {
            if (this.name != null) {
                output.zzb(1, this.name);
            }
            if (this.zzbqj != null && this.zzbqj.length > 0) {
                for (zztk com_google_android_gms_internal_zztk : this.zzbqj) {
                    if (com_google_android_gms_internal_zztk != null) {
                        output.zza(2, com_google_android_gms_internal_zztk);
                    }
                }
            }
            super.writeTo(output);
        }

        public zza zzF(zztc com_google_android_gms_internal_zztc) throws IOException {
            while (true) {
                int zzHi = com_google_android_gms_internal_zztc.zzHi();
                switch (zzHi) {
                    case 0:
                        break;
                    case 10:
                        this.name = com_google_android_gms_internal_zztc.readString();
                        continue;
                    case 18:
                        int zzc = zztn.zzc(com_google_android_gms_internal_zztc, 18);
                        zzHi = this.zzbqj == null ? 0 : this.zzbqj.length;
                        Object obj = new zzb[(zzc + zzHi)];
                        if (zzHi != 0) {
                            System.arraycopy(this.zzbqj, 0, obj, 0, zzHi);
                        }
                        while (zzHi < obj.length - 1) {
                            obj[zzHi] = new zzb();
                            com_google_android_gms_internal_zztc.zza(obj[zzHi]);
                            com_google_android_gms_internal_zztc.zzHi();
                            zzHi++;
                        }
                        obj[zzHi] = new zzb();
                        com_google_android_gms_internal_zztc.zza(obj[zzHi]);
                        this.zzbqj = obj;
                        continue;
                    default:
                        if (!zztn.zzb(com_google_android_gms_internal_zztc, zzHi)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public zza zzHJ() {
            this.name = null;
            this.zzbqj = zzb.zzHK();
            this.zzbqb = -1;
            return this;
        }

        protected int zzz() {
            int zzz = super.zzz();
            if (this.name != null) {
                zzz += zztd.zzp(1, this.name);
            }
            if (this.zzbqj == null || this.zzbqj.length <= 0) {
                return zzz;
            }
            int i = zzz;
            for (zztk com_google_android_gms_internal_zztk : this.zzbqj) {
                if (com_google_android_gms_internal_zztk != null) {
                    i += zztd.zzc(2, com_google_android_gms_internal_zztk);
                }
            }
            return i;
        }
    }

    public static final class zzb extends zztk {
        private static volatile zzb[] zzbqk;
        public String name;
        public Integer zzbql;
        public Boolean zzbqm;

        public zzb() {
            zzHL();
        }

        public static zzb[] zzHK() {
            if (zzbqk == null) {
                synchronized (zzti.zzbqa) {
                    if (zzbqk == null) {
                        zzbqk = new zzb[0];
                    }
                }
            }
            return zzbqk;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzb)) {
                return false;
            }
            zzb com_google_android_gms_internal_zzto_zzb = (zzb) o;
            if (this.name == null) {
                if (com_google_android_gms_internal_zzto_zzb.name != null) {
                    return false;
                }
            } else if (!this.name.equals(com_google_android_gms_internal_zzto_zzb.name)) {
                return false;
            }
            if (this.zzbql == null) {
                if (com_google_android_gms_internal_zzto_zzb.zzbql != null) {
                    return false;
                }
            } else if (!this.zzbql.equals(com_google_android_gms_internal_zzto_zzb.zzbql)) {
                return false;
            }
            return this.zzbqm == null ? com_google_android_gms_internal_zzto_zzb.zzbqm == null : this.zzbqm.equals(com_google_android_gms_internal_zzto_zzb.zzbqm);
        }

        public int hashCode() {
            int i = 0;
            int intValue = ((this.zzbql == null ? 0 : this.zzbql.intValue()) + (((this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
            if (this.zzbqm != null) {
                i = this.zzbqm.hashCode();
            }
            return intValue + i;
        }

        public /* synthetic */ zztk mergeFrom(zztc x0) throws IOException {
            return zzG(x0);
        }

        public void writeTo(zztd output) throws IOException {
            if (this.name != null) {
                output.zzb(1, this.name);
            }
            if (this.zzbql != null) {
                output.zzG(3, this.zzbql.intValue());
            }
            if (this.zzbqm != null) {
                output.zzb(4, this.zzbqm.booleanValue());
            }
            super.writeTo(output);
        }

        public zzb zzG(zztc com_google_android_gms_internal_zztc) throws IOException {
            while (true) {
                int zzHi = com_google_android_gms_internal_zztc.zzHi();
                switch (zzHi) {
                    case 0:
                        break;
                    case 10:
                        this.name = com_google_android_gms_internal_zztc.readString();
                        continue;
                    case 24:
                        zzHi = com_google_android_gms_internal_zztc.zzHl();
                        switch (zzHi) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                                this.zzbql = Integer.valueOf(zzHi);
                                break;
                            default:
                                continue;
                        }
                    case 32:
                        this.zzbqm = Boolean.valueOf(com_google_android_gms_internal_zztc.zzHm());
                        continue;
                    default:
                        if (!zztn.zzb(com_google_android_gms_internal_zztc, zzHi)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public zzb zzHL() {
            this.name = null;
            this.zzbql = null;
            this.zzbqm = null;
            this.zzbqb = -1;
            return this;
        }

        protected int zzz() {
            int zzz = super.zzz();
            if (this.name != null) {
                zzz += zztd.zzp(1, this.name);
            }
            if (this.zzbql != null) {
                zzz += zztd.zzI(3, this.zzbql.intValue());
            }
            return this.zzbqm != null ? zzz + zztd.zzc(4, this.zzbqm.booleanValue()) : zzz;
        }
    }
}
