package com.google.android.gms.internal;

import com.google.android.gms.location.places.Place;
import java.io.IOException;

public interface zzag {

    public static final class zza extends zzte<zza> {
        private static volatile zza[] zzjn;
        public int type;
        public String zzjo;
        public zza[] zzjp;
        public zza[] zzjq;
        public zza[] zzjr;
        public String zzjs;
        public String zzjt;
        public long zzju;
        public boolean zzjv;
        public zza[] zzjw;
        public int[] zzjx;
        public boolean zzjy;

        public zza() {
            zzR();
        }

        public static zza[] zzQ() {
            if (zzjn == null) {
                synchronized (zzti.zzbqa) {
                    if (zzjn == null) {
                        zzjn = new zza[0];
                    }
                }
            }
            return zzjn;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zzag_zza = (zza) o;
            if (this.type != com_google_android_gms_internal_zzag_zza.type) {
                return false;
            }
            if (this.zzjo == null) {
                if (com_google_android_gms_internal_zzag_zza.zzjo != null) {
                    return false;
                }
            } else if (!this.zzjo.equals(com_google_android_gms_internal_zzag_zza.zzjo)) {
                return false;
            }
            if (!zzti.equals(this.zzjp, com_google_android_gms_internal_zzag_zza.zzjp) || !zzti.equals(this.zzjq, com_google_android_gms_internal_zzag_zza.zzjq) || !zzti.equals(this.zzjr, com_google_android_gms_internal_zzag_zza.zzjr)) {
                return false;
            }
            if (this.zzjs == null) {
                if (com_google_android_gms_internal_zzag_zza.zzjs != null) {
                    return false;
                }
            } else if (!this.zzjs.equals(com_google_android_gms_internal_zzag_zza.zzjs)) {
                return false;
            }
            if (this.zzjt == null) {
                if (com_google_android_gms_internal_zzag_zza.zzjt != null) {
                    return false;
                }
            } else if (!this.zzjt.equals(com_google_android_gms_internal_zzag_zza.zzjt)) {
                return false;
            }
            if (this.zzju != com_google_android_gms_internal_zzag_zza.zzju || this.zzjv != com_google_android_gms_internal_zzag_zza.zzjv || !zzti.equals(this.zzjw, com_google_android_gms_internal_zzag_zza.zzjw) || !zzti.equals(this.zzjx, com_google_android_gms_internal_zzag_zza.zzjx) || this.zzjy != com_google_android_gms_internal_zzag_zza.zzjy) {
                return false;
            }
            if (this.zzbpQ == null || this.zzbpQ.isEmpty()) {
                return com_google_android_gms_internal_zzag_zza.zzbpQ == null || com_google_android_gms_internal_zzag_zza.zzbpQ.isEmpty();
            } else {
                return this.zzbpQ.equals(com_google_android_gms_internal_zzag_zza.zzbpQ);
            }
        }

        public int hashCode() {
            int i = 1231;
            int i2 = 0;
            int hashCode = ((((((this.zzjv ? 1231 : 1237) + (((((this.zzjt == null ? 0 : this.zzjt.hashCode()) + (((this.zzjs == null ? 0 : this.zzjs.hashCode()) + (((((((((this.zzjo == null ? 0 : this.zzjo.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + this.type) * 31)) * 31) + zzti.hashCode(this.zzjp)) * 31) + zzti.hashCode(this.zzjq)) * 31) + zzti.hashCode(this.zzjr)) * 31)) * 31)) * 31) + ((int) (this.zzju ^ (this.zzju >>> 32)))) * 31)) * 31) + zzti.hashCode(this.zzjw)) * 31) + zzti.hashCode(this.zzjx)) * 31;
            if (!this.zzjy) {
                i = 1237;
            }
            hashCode = (hashCode + i) * 31;
            if (!(this.zzbpQ == null || this.zzbpQ.isEmpty())) {
                i2 = this.zzbpQ.hashCode();
            }
            return hashCode + i2;
        }

        public /* synthetic */ zztk mergeFrom(zztc x0) throws IOException {
            return zzk(x0);
        }

        public void writeTo(zztd output) throws IOException {
            int i = 0;
            output.zzG(1, this.type);
            if (!this.zzjo.equals("")) {
                output.zzb(2, this.zzjo);
            }
            if (this.zzjp != null && this.zzjp.length > 0) {
                for (zztk com_google_android_gms_internal_zztk : this.zzjp) {
                    if (com_google_android_gms_internal_zztk != null) {
                        output.zza(3, com_google_android_gms_internal_zztk);
                    }
                }
            }
            if (this.zzjq != null && this.zzjq.length > 0) {
                for (zztk com_google_android_gms_internal_zztk2 : this.zzjq) {
                    if (com_google_android_gms_internal_zztk2 != null) {
                        output.zza(4, com_google_android_gms_internal_zztk2);
                    }
                }
            }
            if (this.zzjr != null && this.zzjr.length > 0) {
                for (zztk com_google_android_gms_internal_zztk22 : this.zzjr) {
                    if (com_google_android_gms_internal_zztk22 != null) {
                        output.zza(5, com_google_android_gms_internal_zztk22);
                    }
                }
            }
            if (!this.zzjs.equals("")) {
                output.zzb(6, this.zzjs);
            }
            if (!this.zzjt.equals("")) {
                output.zzb(7, this.zzjt);
            }
            if (this.zzju != 0) {
                output.zzb(8, this.zzju);
            }
            if (this.zzjy) {
                output.zzb(9, this.zzjy);
            }
            if (this.zzjx != null && this.zzjx.length > 0) {
                for (int zzG : this.zzjx) {
                    output.zzG(10, zzG);
                }
            }
            if (this.zzjw != null && this.zzjw.length > 0) {
                while (i < this.zzjw.length) {
                    zztk com_google_android_gms_internal_zztk3 = this.zzjw[i];
                    if (com_google_android_gms_internal_zztk3 != null) {
                        output.zza(11, com_google_android_gms_internal_zztk3);
                    }
                    i++;
                }
            }
            if (this.zzjv) {
                output.zzb(12, this.zzjv);
            }
            super.writeTo(output);
        }

        public zza zzR() {
            this.type = 1;
            this.zzjo = "";
            this.zzjp = zzQ();
            this.zzjq = zzQ();
            this.zzjr = zzQ();
            this.zzjs = "";
            this.zzjt = "";
            this.zzju = 0;
            this.zzjv = false;
            this.zzjw = zzQ();
            this.zzjx = zztn.zzboD;
            this.zzjy = false;
            this.zzbpQ = null;
            this.zzbqb = -1;
            return this;
        }

        public zza zzk(zztc com_google_android_gms_internal_zztc) throws IOException {
            while (true) {
                int zzHi = com_google_android_gms_internal_zztc.zzHi();
                int zzc;
                Object obj;
                int i;
                switch (zzHi) {
                    case 0:
                        break;
                    case 8:
                        zzHi = com_google_android_gms_internal_zztc.zzHl();
                        switch (zzHi) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                                this.type = zzHi;
                                break;
                            default:
                                continue;
                        }
                    case 18:
                        this.zzjo = com_google_android_gms_internal_zztc.readString();
                        continue;
                    case 26:
                        zzc = zztn.zzc(com_google_android_gms_internal_zztc, 26);
                        zzHi = this.zzjp == null ? 0 : this.zzjp.length;
                        obj = new zza[(zzc + zzHi)];
                        if (zzHi != 0) {
                            System.arraycopy(this.zzjp, 0, obj, 0, zzHi);
                        }
                        while (zzHi < obj.length - 1) {
                            obj[zzHi] = new zza();
                            com_google_android_gms_internal_zztc.zza(obj[zzHi]);
                            com_google_android_gms_internal_zztc.zzHi();
                            zzHi++;
                        }
                        obj[zzHi] = new zza();
                        com_google_android_gms_internal_zztc.zza(obj[zzHi]);
                        this.zzjp = obj;
                        continue;
                    case 34:
                        zzc = zztn.zzc(com_google_android_gms_internal_zztc, 34);
                        zzHi = this.zzjq == null ? 0 : this.zzjq.length;
                        obj = new zza[(zzc + zzHi)];
                        if (zzHi != 0) {
                            System.arraycopy(this.zzjq, 0, obj, 0, zzHi);
                        }
                        while (zzHi < obj.length - 1) {
                            obj[zzHi] = new zza();
                            com_google_android_gms_internal_zztc.zza(obj[zzHi]);
                            com_google_android_gms_internal_zztc.zzHi();
                            zzHi++;
                        }
                        obj[zzHi] = new zza();
                        com_google_android_gms_internal_zztc.zza(obj[zzHi]);
                        this.zzjq = obj;
                        continue;
                    case 42:
                        zzc = zztn.zzc(com_google_android_gms_internal_zztc, 42);
                        zzHi = this.zzjr == null ? 0 : this.zzjr.length;
                        obj = new zza[(zzc + zzHi)];
                        if (zzHi != 0) {
                            System.arraycopy(this.zzjr, 0, obj, 0, zzHi);
                        }
                        while (zzHi < obj.length - 1) {
                            obj[zzHi] = new zza();
                            com_google_android_gms_internal_zztc.zza(obj[zzHi]);
                            com_google_android_gms_internal_zztc.zzHi();
                            zzHi++;
                        }
                        obj[zzHi] = new zza();
                        com_google_android_gms_internal_zztc.zza(obj[zzHi]);
                        this.zzjr = obj;
                        continue;
                    case 50:
                        this.zzjs = com_google_android_gms_internal_zztc.readString();
                        continue;
                    case 58:
                        this.zzjt = com_google_android_gms_internal_zztc.readString();
                        continue;
                    case 64:
                        this.zzju = com_google_android_gms_internal_zztc.zzHk();
                        continue;
                    case 72:
                        this.zzjy = com_google_android_gms_internal_zztc.zzHm();
                        continue;
                    case 80:
                        int zzc2 = zztn.zzc(com_google_android_gms_internal_zztc, 80);
                        Object obj2 = new int[zzc2];
                        i = 0;
                        zzc = 0;
                        while (i < zzc2) {
                            if (i != 0) {
                                com_google_android_gms_internal_zztc.zzHi();
                            }
                            int zzHl = com_google_android_gms_internal_zztc.zzHl();
                            switch (zzHl) {
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                case 14:
                                case 15:
                                case 16:
                                case 17:
                                    zzHi = zzc + 1;
                                    obj2[zzc] = zzHl;
                                    break;
                                default:
                                    zzHi = zzc;
                                    break;
                            }
                            i++;
                            zzc = zzHi;
                        }
                        if (zzc != 0) {
                            zzHi = this.zzjx == null ? 0 : this.zzjx.length;
                            if (zzHi != 0 || zzc != obj2.length) {
                                Object obj3 = new int[(zzHi + zzc)];
                                if (zzHi != 0) {
                                    System.arraycopy(this.zzjx, 0, obj3, 0, zzHi);
                                }
                                System.arraycopy(obj2, 0, obj3, zzHi, zzc);
                                this.zzjx = obj3;
                                break;
                            }
                            this.zzjx = obj2;
                            break;
                        }
                        continue;
                    case 82:
                        i = com_google_android_gms_internal_zztc.zzmn(com_google_android_gms_internal_zztc.zzHp());
                        zzc = com_google_android_gms_internal_zztc.getPosition();
                        zzHi = 0;
                        while (com_google_android_gms_internal_zztc.zzHu() > 0) {
                            switch (com_google_android_gms_internal_zztc.zzHl()) {
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                case 14:
                                case 15:
                                case 16:
                                case 17:
                                    zzHi++;
                                    break;
                                default:
                                    break;
                            }
                        }
                        if (zzHi != 0) {
                            com_google_android_gms_internal_zztc.zzmp(zzc);
                            zzc = this.zzjx == null ? 0 : this.zzjx.length;
                            Object obj4 = new int[(zzHi + zzc)];
                            if (zzc != 0) {
                                System.arraycopy(this.zzjx, 0, obj4, 0, zzc);
                            }
                            while (com_google_android_gms_internal_zztc.zzHu() > 0) {
                                int zzHl2 = com_google_android_gms_internal_zztc.zzHl();
                                switch (zzHl2) {
                                    case 1:
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 6:
                                    case 7:
                                    case 8:
                                    case 9:
                                    case 10:
                                    case 11:
                                    case 12:
                                    case 13:
                                    case 14:
                                    case 15:
                                    case 16:
                                    case 17:
                                        zzHi = zzc + 1;
                                        obj4[zzc] = zzHl2;
                                        zzc = zzHi;
                                        break;
                                    default:
                                        break;
                                }
                            }
                            this.zzjx = obj4;
                        }
                        com_google_android_gms_internal_zztc.zzmo(i);
                        continue;
                    case 90:
                        zzc = zztn.zzc(com_google_android_gms_internal_zztc, 90);
                        zzHi = this.zzjw == null ? 0 : this.zzjw.length;
                        obj = new zza[(zzc + zzHi)];
                        if (zzHi != 0) {
                            System.arraycopy(this.zzjw, 0, obj, 0, zzHi);
                        }
                        while (zzHi < obj.length - 1) {
                            obj[zzHi] = new zza();
                            com_google_android_gms_internal_zztc.zza(obj[zzHi]);
                            com_google_android_gms_internal_zztc.zzHi();
                            zzHi++;
                        }
                        obj[zzHi] = new zza();
                        com_google_android_gms_internal_zztc.zza(obj[zzHi]);
                        this.zzjw = obj;
                        continue;
                    case Place.TYPE_ZOO /*96*/:
                        this.zzjv = com_google_android_gms_internal_zztc.zzHm();
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
            int i;
            int i2 = 0;
            int zzz = super.zzz() + zztd.zzI(1, this.type);
            if (!this.zzjo.equals("")) {
                zzz += zztd.zzp(2, this.zzjo);
            }
            if (this.zzjp != null && this.zzjp.length > 0) {
                i = zzz;
                for (zztk com_google_android_gms_internal_zztk : this.zzjp) {
                    if (com_google_android_gms_internal_zztk != null) {
                        i += zztd.zzc(3, com_google_android_gms_internal_zztk);
                    }
                }
                zzz = i;
            }
            if (this.zzjq != null && this.zzjq.length > 0) {
                i = zzz;
                for (zztk com_google_android_gms_internal_zztk2 : this.zzjq) {
                    if (com_google_android_gms_internal_zztk2 != null) {
                        i += zztd.zzc(4, com_google_android_gms_internal_zztk2);
                    }
                }
                zzz = i;
            }
            if (this.zzjr != null && this.zzjr.length > 0) {
                i = zzz;
                for (zztk com_google_android_gms_internal_zztk22 : this.zzjr) {
                    if (com_google_android_gms_internal_zztk22 != null) {
                        i += zztd.zzc(5, com_google_android_gms_internal_zztk22);
                    }
                }
                zzz = i;
            }
            if (!this.zzjs.equals("")) {
                zzz += zztd.zzp(6, this.zzjs);
            }
            if (!this.zzjt.equals("")) {
                zzz += zztd.zzp(7, this.zzjt);
            }
            if (this.zzju != 0) {
                zzz += zztd.zzd(8, this.zzju);
            }
            if (this.zzjy) {
                zzz += zztd.zzc(9, this.zzjy);
            }
            if (this.zzjx != null && this.zzjx.length > 0) {
                int i3 = 0;
                for (int zzmu : this.zzjx) {
                    i3 += zztd.zzmu(zzmu);
                }
                zzz = (zzz + i3) + (this.zzjx.length * 1);
            }
            if (this.zzjw != null && this.zzjw.length > 0) {
                while (i2 < this.zzjw.length) {
                    zztk com_google_android_gms_internal_zztk3 = this.zzjw[i2];
                    if (com_google_android_gms_internal_zztk3 != null) {
                        zzz += zztd.zzc(11, com_google_android_gms_internal_zztk3);
                    }
                    i2++;
                }
            }
            return this.zzjv ? zzz + zztd.zzc(12, this.zzjv) : zzz;
        }
    }
}
