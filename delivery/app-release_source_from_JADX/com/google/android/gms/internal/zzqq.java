package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import com.google.android.gms.location.places.Place;
import java.io.IOException;

public interface zzqq {

    public static final class zza extends zztk {
        private static volatile zza[] zzaVj;
        public Integer count;
        public String name;
        public zzb[] zzaVk;
        public Long zzaVl;
        public Long zzaVm;

        public zza() {
            zzCc();
        }

        public static zza[] zzCb() {
            if (zzaVj == null) {
                synchronized (zzti.zzbqa) {
                    if (zzaVj == null) {
                        zzaVj = new zza[0];
                    }
                }
            }
            return zzaVj;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zzqq_zza = (zza) o;
            if (!zzti.equals(this.zzaVk, com_google_android_gms_internal_zzqq_zza.zzaVk)) {
                return false;
            }
            if (this.name == null) {
                if (com_google_android_gms_internal_zzqq_zza.name != null) {
                    return false;
                }
            } else if (!this.name.equals(com_google_android_gms_internal_zzqq_zza.name)) {
                return false;
            }
            if (this.zzaVl == null) {
                if (com_google_android_gms_internal_zzqq_zza.zzaVl != null) {
                    return false;
                }
            } else if (!this.zzaVl.equals(com_google_android_gms_internal_zzqq_zza.zzaVl)) {
                return false;
            }
            if (this.zzaVm == null) {
                if (com_google_android_gms_internal_zzqq_zza.zzaVm != null) {
                    return false;
                }
            } else if (!this.zzaVm.equals(com_google_android_gms_internal_zzqq_zza.zzaVm)) {
                return false;
            }
            return this.count == null ? com_google_android_gms_internal_zzqq_zza.count == null : this.count.equals(com_google_android_gms_internal_zzqq_zza.count);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzaVm == null ? 0 : this.zzaVm.hashCode()) + (((this.zzaVl == null ? 0 : this.zzaVl.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + zzti.hashCode(this.zzaVk)) * 31)) * 31)) * 31)) * 31;
            if (this.count != null) {
                i = this.count.hashCode();
            }
            return hashCode + i;
        }

        public /* synthetic */ zztk mergeFrom(zztc x0) throws IOException {
            return zzt(x0);
        }

        public void writeTo(zztd output) throws IOException {
            if (this.zzaVk != null && this.zzaVk.length > 0) {
                for (zztk com_google_android_gms_internal_zztk : this.zzaVk) {
                    if (com_google_android_gms_internal_zztk != null) {
                        output.zza(1, com_google_android_gms_internal_zztk);
                    }
                }
            }
            if (this.name != null) {
                output.zzb(2, this.name);
            }
            if (this.zzaVl != null) {
                output.zzb(3, this.zzaVl.longValue());
            }
            if (this.zzaVm != null) {
                output.zzb(4, this.zzaVm.longValue());
            }
            if (this.count != null) {
                output.zzG(5, this.count.intValue());
            }
            super.writeTo(output);
        }

        public zza zzCc() {
            this.zzaVk = zzb.zzCd();
            this.name = null;
            this.zzaVl = null;
            this.zzaVm = null;
            this.count = null;
            this.zzbqb = -1;
            return this;
        }

        public zza zzt(zztc com_google_android_gms_internal_zztc) throws IOException {
            while (true) {
                int zzHi = com_google_android_gms_internal_zztc.zzHi();
                switch (zzHi) {
                    case 0:
                        break;
                    case 10:
                        int zzc = zztn.zzc(com_google_android_gms_internal_zztc, 10);
                        zzHi = this.zzaVk == null ? 0 : this.zzaVk.length;
                        Object obj = new zzb[(zzc + zzHi)];
                        if (zzHi != 0) {
                            System.arraycopy(this.zzaVk, 0, obj, 0, zzHi);
                        }
                        while (zzHi < obj.length - 1) {
                            obj[zzHi] = new zzb();
                            com_google_android_gms_internal_zztc.zza(obj[zzHi]);
                            com_google_android_gms_internal_zztc.zzHi();
                            zzHi++;
                        }
                        obj[zzHi] = new zzb();
                        com_google_android_gms_internal_zztc.zza(obj[zzHi]);
                        this.zzaVk = obj;
                        continue;
                    case 18:
                        this.name = com_google_android_gms_internal_zztc.readString();
                        continue;
                    case 24:
                        this.zzaVl = Long.valueOf(com_google_android_gms_internal_zztc.zzHk());
                        continue;
                    case 32:
                        this.zzaVm = Long.valueOf(com_google_android_gms_internal_zztc.zzHk());
                        continue;
                    case 40:
                        this.count = Integer.valueOf(com_google_android_gms_internal_zztc.zzHl());
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

        protected int zzz() {
            int zzz = super.zzz();
            if (this.zzaVk != null && this.zzaVk.length > 0) {
                for (zztk com_google_android_gms_internal_zztk : this.zzaVk) {
                    if (com_google_android_gms_internal_zztk != null) {
                        zzz += zztd.zzc(1, com_google_android_gms_internal_zztk);
                    }
                }
            }
            if (this.name != null) {
                zzz += zztd.zzp(2, this.name);
            }
            if (this.zzaVl != null) {
                zzz += zztd.zzd(3, this.zzaVl.longValue());
            }
            if (this.zzaVm != null) {
                zzz += zztd.zzd(4, this.zzaVm.longValue());
            }
            return this.count != null ? zzz + zztd.zzI(5, this.count.intValue()) : zzz;
        }
    }

    public static final class zzb extends zztk {
        private static volatile zzb[] zzaVn;
        public String name;
        public Float zzaVi;
        public Long zzaVo;
        public String zzakS;

        public zzb() {
            zzCe();
        }

        public static zzb[] zzCd() {
            if (zzaVn == null) {
                synchronized (zzti.zzbqa) {
                    if (zzaVn == null) {
                        zzaVn = new zzb[0];
                    }
                }
            }
            return zzaVn;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzb)) {
                return false;
            }
            zzb com_google_android_gms_internal_zzqq_zzb = (zzb) o;
            if (this.name == null) {
                if (com_google_android_gms_internal_zzqq_zzb.name != null) {
                    return false;
                }
            } else if (!this.name.equals(com_google_android_gms_internal_zzqq_zzb.name)) {
                return false;
            }
            if (this.zzakS == null) {
                if (com_google_android_gms_internal_zzqq_zzb.zzakS != null) {
                    return false;
                }
            } else if (!this.zzakS.equals(com_google_android_gms_internal_zzqq_zzb.zzakS)) {
                return false;
            }
            if (this.zzaVo == null) {
                if (com_google_android_gms_internal_zzqq_zzb.zzaVo != null) {
                    return false;
                }
            } else if (!this.zzaVo.equals(com_google_android_gms_internal_zzqq_zzb.zzaVo)) {
                return false;
            }
            return this.zzaVi == null ? com_google_android_gms_internal_zzqq_zzb.zzaVi == null : this.zzaVi.equals(com_google_android_gms_internal_zzqq_zzb.zzaVi);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzaVo == null ? 0 : this.zzaVo.hashCode()) + (((this.zzakS == null ? 0 : this.zzakS.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31;
            if (this.zzaVi != null) {
                i = this.zzaVi.hashCode();
            }
            return hashCode + i;
        }

        public /* synthetic */ zztk mergeFrom(zztc x0) throws IOException {
            return zzu(x0);
        }

        public void writeTo(zztd output) throws IOException {
            if (this.name != null) {
                output.zzb(1, this.name);
            }
            if (this.zzakS != null) {
                output.zzb(2, this.zzakS);
            }
            if (this.zzaVo != null) {
                output.zzb(3, this.zzaVo.longValue());
            }
            if (this.zzaVi != null) {
                output.zzb(4, this.zzaVi.floatValue());
            }
            super.writeTo(output);
        }

        public zzb zzCe() {
            this.name = null;
            this.zzakS = null;
            this.zzaVo = null;
            this.zzaVi = null;
            this.zzbqb = -1;
            return this;
        }

        public zzb zzu(zztc com_google_android_gms_internal_zztc) throws IOException {
            while (true) {
                int zzHi = com_google_android_gms_internal_zztc.zzHi();
                switch (zzHi) {
                    case 0:
                        break;
                    case 10:
                        this.name = com_google_android_gms_internal_zztc.readString();
                        continue;
                    case 18:
                        this.zzakS = com_google_android_gms_internal_zztc.readString();
                        continue;
                    case 24:
                        this.zzaVo = Long.valueOf(com_google_android_gms_internal_zztc.zzHk());
                        continue;
                    case 37:
                        this.zzaVi = Float.valueOf(com_google_android_gms_internal_zztc.readFloat());
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

        protected int zzz() {
            int zzz = super.zzz();
            if (this.name != null) {
                zzz += zztd.zzp(1, this.name);
            }
            if (this.zzakS != null) {
                zzz += zztd.zzp(2, this.zzakS);
            }
            if (this.zzaVo != null) {
                zzz += zztd.zzd(3, this.zzaVo.longValue());
            }
            return this.zzaVi != null ? zzz + zztd.zzc(4, this.zzaVi.floatValue()) : zzz;
        }
    }

    public static final class zzc extends zztk {
        public zzd[] zzaVp;

        public zzc() {
            zzCf();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzc)) {
                return false;
            }
            return zzti.equals(this.zzaVp, ((zzc) o).zzaVp);
        }

        public int hashCode() {
            return ((getClass().getName().hashCode() + 527) * 31) + zzti.hashCode(this.zzaVp);
        }

        public /* synthetic */ zztk mergeFrom(zztc x0) throws IOException {
            return zzv(x0);
        }

        public void writeTo(zztd output) throws IOException {
            if (this.zzaVp != null && this.zzaVp.length > 0) {
                for (zztk com_google_android_gms_internal_zztk : this.zzaVp) {
                    if (com_google_android_gms_internal_zztk != null) {
                        output.zza(1, com_google_android_gms_internal_zztk);
                    }
                }
            }
            super.writeTo(output);
        }

        public zzc zzCf() {
            this.zzaVp = zzd.zzCg();
            this.zzbqb = -1;
            return this;
        }

        public zzc zzv(zztc com_google_android_gms_internal_zztc) throws IOException {
            while (true) {
                int zzHi = com_google_android_gms_internal_zztc.zzHi();
                switch (zzHi) {
                    case 0:
                        break;
                    case 10:
                        int zzc = zztn.zzc(com_google_android_gms_internal_zztc, 10);
                        zzHi = this.zzaVp == null ? 0 : this.zzaVp.length;
                        Object obj = new zzd[(zzc + zzHi)];
                        if (zzHi != 0) {
                            System.arraycopy(this.zzaVp, 0, obj, 0, zzHi);
                        }
                        while (zzHi < obj.length - 1) {
                            obj[zzHi] = new zzd();
                            com_google_android_gms_internal_zztc.zza(obj[zzHi]);
                            com_google_android_gms_internal_zztc.zzHi();
                            zzHi++;
                        }
                        obj[zzHi] = new zzd();
                        com_google_android_gms_internal_zztc.zza(obj[zzHi]);
                        this.zzaVp = obj;
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

        protected int zzz() {
            int zzz = super.zzz();
            if (this.zzaVp != null && this.zzaVp.length > 0) {
                for (zztk com_google_android_gms_internal_zztk : this.zzaVp) {
                    if (com_google_android_gms_internal_zztk != null) {
                        zzz += zztd.zzc(1, com_google_android_gms_internal_zztk);
                    }
                }
            }
            return zzz;
        }
    }

    public static final class zzd extends zztk {
        private static volatile zzd[] zzaVq;
        public String appId;
        public String osVersion;
        public String zzaKi;
        public String zzaSn;
        public String zzaSo;
        public String zzaSr;
        public String zzaVA;
        public String zzaVB;
        public Integer zzaVC;
        public Long zzaVD;
        public Long zzaVE;
        public String zzaVF;
        public Boolean zzaVG;
        public String zzaVH;
        public Long zzaVI;
        public Integer zzaVJ;
        public Boolean zzaVK;
        public Integer zzaVr;
        public zza[] zzaVs;
        public zze[] zzaVt;
        public Long zzaVu;
        public Long zzaVv;
        public Long zzaVw;
        public Long zzaVx;
        public Long zzaVy;
        public String zzaVz;

        public zzd() {
            zzCh();
        }

        public static zzd[] zzCg() {
            if (zzaVq == null) {
                synchronized (zzti.zzbqa) {
                    if (zzaVq == null) {
                        zzaVq = new zzd[0];
                    }
                }
            }
            return zzaVq;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzd)) {
                return false;
            }
            zzd com_google_android_gms_internal_zzqq_zzd = (zzd) o;
            if (this.zzaVr == null) {
                if (com_google_android_gms_internal_zzqq_zzd.zzaVr != null) {
                    return false;
                }
            } else if (!this.zzaVr.equals(com_google_android_gms_internal_zzqq_zzd.zzaVr)) {
                return false;
            }
            if (!zzti.equals(this.zzaVs, com_google_android_gms_internal_zzqq_zzd.zzaVs)) {
                return false;
            }
            if (!zzti.equals(this.zzaVt, com_google_android_gms_internal_zzqq_zzd.zzaVt)) {
                return false;
            }
            if (this.zzaVu == null) {
                if (com_google_android_gms_internal_zzqq_zzd.zzaVu != null) {
                    return false;
                }
            } else if (!this.zzaVu.equals(com_google_android_gms_internal_zzqq_zzd.zzaVu)) {
                return false;
            }
            if (this.zzaVv == null) {
                if (com_google_android_gms_internal_zzqq_zzd.zzaVv != null) {
                    return false;
                }
            } else if (!this.zzaVv.equals(com_google_android_gms_internal_zzqq_zzd.zzaVv)) {
                return false;
            }
            if (this.zzaVw == null) {
                if (com_google_android_gms_internal_zzqq_zzd.zzaVw != null) {
                    return false;
                }
            } else if (!this.zzaVw.equals(com_google_android_gms_internal_zzqq_zzd.zzaVw)) {
                return false;
            }
            if (this.zzaVx == null) {
                if (com_google_android_gms_internal_zzqq_zzd.zzaVx != null) {
                    return false;
                }
            } else if (!this.zzaVx.equals(com_google_android_gms_internal_zzqq_zzd.zzaVx)) {
                return false;
            }
            if (this.zzaVy == null) {
                if (com_google_android_gms_internal_zzqq_zzd.zzaVy != null) {
                    return false;
                }
            } else if (!this.zzaVy.equals(com_google_android_gms_internal_zzqq_zzd.zzaVy)) {
                return false;
            }
            if (this.zzaVz == null) {
                if (com_google_android_gms_internal_zzqq_zzd.zzaVz != null) {
                    return false;
                }
            } else if (!this.zzaVz.equals(com_google_android_gms_internal_zzqq_zzd.zzaVz)) {
                return false;
            }
            if (this.osVersion == null) {
                if (com_google_android_gms_internal_zzqq_zzd.osVersion != null) {
                    return false;
                }
            } else if (!this.osVersion.equals(com_google_android_gms_internal_zzqq_zzd.osVersion)) {
                return false;
            }
            if (this.zzaVA == null) {
                if (com_google_android_gms_internal_zzqq_zzd.zzaVA != null) {
                    return false;
                }
            } else if (!this.zzaVA.equals(com_google_android_gms_internal_zzqq_zzd.zzaVA)) {
                return false;
            }
            if (this.zzaVB == null) {
                if (com_google_android_gms_internal_zzqq_zzd.zzaVB != null) {
                    return false;
                }
            } else if (!this.zzaVB.equals(com_google_android_gms_internal_zzqq_zzd.zzaVB)) {
                return false;
            }
            if (this.zzaVC == null) {
                if (com_google_android_gms_internal_zzqq_zzd.zzaVC != null) {
                    return false;
                }
            } else if (!this.zzaVC.equals(com_google_android_gms_internal_zzqq_zzd.zzaVC)) {
                return false;
            }
            if (this.zzaSo == null) {
                if (com_google_android_gms_internal_zzqq_zzd.zzaSo != null) {
                    return false;
                }
            } else if (!this.zzaSo.equals(com_google_android_gms_internal_zzqq_zzd.zzaSo)) {
                return false;
            }
            if (this.appId == null) {
                if (com_google_android_gms_internal_zzqq_zzd.appId != null) {
                    return false;
                }
            } else if (!this.appId.equals(com_google_android_gms_internal_zzqq_zzd.appId)) {
                return false;
            }
            if (this.zzaKi == null) {
                if (com_google_android_gms_internal_zzqq_zzd.zzaKi != null) {
                    return false;
                }
            } else if (!this.zzaKi.equals(com_google_android_gms_internal_zzqq_zzd.zzaKi)) {
                return false;
            }
            if (this.zzaVD == null) {
                if (com_google_android_gms_internal_zzqq_zzd.zzaVD != null) {
                    return false;
                }
            } else if (!this.zzaVD.equals(com_google_android_gms_internal_zzqq_zzd.zzaVD)) {
                return false;
            }
            if (this.zzaVE == null) {
                if (com_google_android_gms_internal_zzqq_zzd.zzaVE != null) {
                    return false;
                }
            } else if (!this.zzaVE.equals(com_google_android_gms_internal_zzqq_zzd.zzaVE)) {
                return false;
            }
            if (this.zzaVF == null) {
                if (com_google_android_gms_internal_zzqq_zzd.zzaVF != null) {
                    return false;
                }
            } else if (!this.zzaVF.equals(com_google_android_gms_internal_zzqq_zzd.zzaVF)) {
                return false;
            }
            if (this.zzaVG == null) {
                if (com_google_android_gms_internal_zzqq_zzd.zzaVG != null) {
                    return false;
                }
            } else if (!this.zzaVG.equals(com_google_android_gms_internal_zzqq_zzd.zzaVG)) {
                return false;
            }
            if (this.zzaVH == null) {
                if (com_google_android_gms_internal_zzqq_zzd.zzaVH != null) {
                    return false;
                }
            } else if (!this.zzaVH.equals(com_google_android_gms_internal_zzqq_zzd.zzaVH)) {
                return false;
            }
            if (this.zzaVI == null) {
                if (com_google_android_gms_internal_zzqq_zzd.zzaVI != null) {
                    return false;
                }
            } else if (!this.zzaVI.equals(com_google_android_gms_internal_zzqq_zzd.zzaVI)) {
                return false;
            }
            if (this.zzaVJ == null) {
                if (com_google_android_gms_internal_zzqq_zzd.zzaVJ != null) {
                    return false;
                }
            } else if (!this.zzaVJ.equals(com_google_android_gms_internal_zzqq_zzd.zzaVJ)) {
                return false;
            }
            if (this.zzaSr == null) {
                if (com_google_android_gms_internal_zzqq_zzd.zzaSr != null) {
                    return false;
                }
            } else if (!this.zzaSr.equals(com_google_android_gms_internal_zzqq_zzd.zzaSr)) {
                return false;
            }
            if (this.zzaSn == null) {
                if (com_google_android_gms_internal_zzqq_zzd.zzaSn != null) {
                    return false;
                }
            } else if (!this.zzaSn.equals(com_google_android_gms_internal_zzqq_zzd.zzaSn)) {
                return false;
            }
            return this.zzaVK == null ? com_google_android_gms_internal_zzqq_zzd.zzaVK == null : this.zzaVK.equals(com_google_android_gms_internal_zzqq_zzd.zzaVK);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzaSn == null ? 0 : this.zzaSn.hashCode()) + (((this.zzaSr == null ? 0 : this.zzaSr.hashCode()) + (((this.zzaVJ == null ? 0 : this.zzaVJ.hashCode()) + (((this.zzaVI == null ? 0 : this.zzaVI.hashCode()) + (((this.zzaVH == null ? 0 : this.zzaVH.hashCode()) + (((this.zzaVG == null ? 0 : this.zzaVG.hashCode()) + (((this.zzaVF == null ? 0 : this.zzaVF.hashCode()) + (((this.zzaVE == null ? 0 : this.zzaVE.hashCode()) + (((this.zzaVD == null ? 0 : this.zzaVD.hashCode()) + (((this.zzaKi == null ? 0 : this.zzaKi.hashCode()) + (((this.appId == null ? 0 : this.appId.hashCode()) + (((this.zzaSo == null ? 0 : this.zzaSo.hashCode()) + (((this.zzaVC == null ? 0 : this.zzaVC.hashCode()) + (((this.zzaVB == null ? 0 : this.zzaVB.hashCode()) + (((this.zzaVA == null ? 0 : this.zzaVA.hashCode()) + (((this.osVersion == null ? 0 : this.osVersion.hashCode()) + (((this.zzaVz == null ? 0 : this.zzaVz.hashCode()) + (((this.zzaVy == null ? 0 : this.zzaVy.hashCode()) + (((this.zzaVx == null ? 0 : this.zzaVx.hashCode()) + (((this.zzaVw == null ? 0 : this.zzaVw.hashCode()) + (((this.zzaVv == null ? 0 : this.zzaVv.hashCode()) + (((this.zzaVu == null ? 0 : this.zzaVu.hashCode()) + (((((((this.zzaVr == null ? 0 : this.zzaVr.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + zzti.hashCode(this.zzaVs)) * 31) + zzti.hashCode(this.zzaVt)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
            if (this.zzaVK != null) {
                i = this.zzaVK.hashCode();
            }
            return hashCode + i;
        }

        public /* synthetic */ zztk mergeFrom(zztc x0) throws IOException {
            return zzw(x0);
        }

        public void writeTo(zztd output) throws IOException {
            int i = 0;
            if (this.zzaVr != null) {
                output.zzG(1, this.zzaVr.intValue());
            }
            if (this.zzaVs != null && this.zzaVs.length > 0) {
                for (zztk com_google_android_gms_internal_zztk : this.zzaVs) {
                    if (com_google_android_gms_internal_zztk != null) {
                        output.zza(2, com_google_android_gms_internal_zztk);
                    }
                }
            }
            if (this.zzaVt != null && this.zzaVt.length > 0) {
                while (i < this.zzaVt.length) {
                    zztk com_google_android_gms_internal_zztk2 = this.zzaVt[i];
                    if (com_google_android_gms_internal_zztk2 != null) {
                        output.zza(3, com_google_android_gms_internal_zztk2);
                    }
                    i++;
                }
            }
            if (this.zzaVu != null) {
                output.zzb(4, this.zzaVu.longValue());
            }
            if (this.zzaVv != null) {
                output.zzb(5, this.zzaVv.longValue());
            }
            if (this.zzaVw != null) {
                output.zzb(6, this.zzaVw.longValue());
            }
            if (this.zzaVy != null) {
                output.zzb(7, this.zzaVy.longValue());
            }
            if (this.zzaVz != null) {
                output.zzb(8, this.zzaVz);
            }
            if (this.osVersion != null) {
                output.zzb(9, this.osVersion);
            }
            if (this.zzaVA != null) {
                output.zzb(10, this.zzaVA);
            }
            if (this.zzaVB != null) {
                output.zzb(11, this.zzaVB);
            }
            if (this.zzaVC != null) {
                output.zzG(12, this.zzaVC.intValue());
            }
            if (this.zzaSo != null) {
                output.zzb(13, this.zzaSo);
            }
            if (this.appId != null) {
                output.zzb(14, this.appId);
            }
            if (this.zzaKi != null) {
                output.zzb(16, this.zzaKi);
            }
            if (this.zzaVD != null) {
                output.zzb(17, this.zzaVD.longValue());
            }
            if (this.zzaVE != null) {
                output.zzb(18, this.zzaVE.longValue());
            }
            if (this.zzaVF != null) {
                output.zzb(19, this.zzaVF);
            }
            if (this.zzaVG != null) {
                output.zzb(20, this.zzaVG.booleanValue());
            }
            if (this.zzaVH != null) {
                output.zzb(21, this.zzaVH);
            }
            if (this.zzaVI != null) {
                output.zzb(22, this.zzaVI.longValue());
            }
            if (this.zzaVJ != null) {
                output.zzG(23, this.zzaVJ.intValue());
            }
            if (this.zzaSr != null) {
                output.zzb(24, this.zzaSr);
            }
            if (this.zzaSn != null) {
                output.zzb(25, this.zzaSn);
            }
            if (this.zzaVx != null) {
                output.zzb(26, this.zzaVx.longValue());
            }
            if (this.zzaVK != null) {
                output.zzb(28, this.zzaVK.booleanValue());
            }
            super.writeTo(output);
        }

        public zzd zzCh() {
            this.zzaVr = null;
            this.zzaVs = zza.zzCb();
            this.zzaVt = zze.zzCi();
            this.zzaVu = null;
            this.zzaVv = null;
            this.zzaVw = null;
            this.zzaVx = null;
            this.zzaVy = null;
            this.zzaVz = null;
            this.osVersion = null;
            this.zzaVA = null;
            this.zzaVB = null;
            this.zzaVC = null;
            this.zzaSo = null;
            this.appId = null;
            this.zzaKi = null;
            this.zzaVD = null;
            this.zzaVE = null;
            this.zzaVF = null;
            this.zzaVG = null;
            this.zzaVH = null;
            this.zzaVI = null;
            this.zzaVJ = null;
            this.zzaSr = null;
            this.zzaSn = null;
            this.zzaVK = null;
            this.zzbqb = -1;
            return this;
        }

        public zzd zzw(zztc com_google_android_gms_internal_zztc) throws IOException {
            while (true) {
                int zzHi = com_google_android_gms_internal_zztc.zzHi();
                int zzc;
                Object obj;
                switch (zzHi) {
                    case 0:
                        break;
                    case 8:
                        this.zzaVr = Integer.valueOf(com_google_android_gms_internal_zztc.zzHl());
                        continue;
                    case 18:
                        zzc = zztn.zzc(com_google_android_gms_internal_zztc, 18);
                        zzHi = this.zzaVs == null ? 0 : this.zzaVs.length;
                        obj = new zza[(zzc + zzHi)];
                        if (zzHi != 0) {
                            System.arraycopy(this.zzaVs, 0, obj, 0, zzHi);
                        }
                        while (zzHi < obj.length - 1) {
                            obj[zzHi] = new zza();
                            com_google_android_gms_internal_zztc.zza(obj[zzHi]);
                            com_google_android_gms_internal_zztc.zzHi();
                            zzHi++;
                        }
                        obj[zzHi] = new zza();
                        com_google_android_gms_internal_zztc.zza(obj[zzHi]);
                        this.zzaVs = obj;
                        continue;
                    case 26:
                        zzc = zztn.zzc(com_google_android_gms_internal_zztc, 26);
                        zzHi = this.zzaVt == null ? 0 : this.zzaVt.length;
                        obj = new zze[(zzc + zzHi)];
                        if (zzHi != 0) {
                            System.arraycopy(this.zzaVt, 0, obj, 0, zzHi);
                        }
                        while (zzHi < obj.length - 1) {
                            obj[zzHi] = new zze();
                            com_google_android_gms_internal_zztc.zza(obj[zzHi]);
                            com_google_android_gms_internal_zztc.zzHi();
                            zzHi++;
                        }
                        obj[zzHi] = new zze();
                        com_google_android_gms_internal_zztc.zza(obj[zzHi]);
                        this.zzaVt = obj;
                        continue;
                    case 32:
                        this.zzaVu = Long.valueOf(com_google_android_gms_internal_zztc.zzHk());
                        continue;
                    case 40:
                        this.zzaVv = Long.valueOf(com_google_android_gms_internal_zztc.zzHk());
                        continue;
                    case 48:
                        this.zzaVw = Long.valueOf(com_google_android_gms_internal_zztc.zzHk());
                        continue;
                    case 56:
                        this.zzaVy = Long.valueOf(com_google_android_gms_internal_zztc.zzHk());
                        continue;
                    case 66:
                        this.zzaVz = com_google_android_gms_internal_zztc.readString();
                        continue;
                    case 74:
                        this.osVersion = com_google_android_gms_internal_zztc.readString();
                        continue;
                    case 82:
                        this.zzaVA = com_google_android_gms_internal_zztc.readString();
                        continue;
                    case 90:
                        this.zzaVB = com_google_android_gms_internal_zztc.readString();
                        continue;
                    case Place.TYPE_ZOO /*96*/:
                        this.zzaVC = Integer.valueOf(com_google_android_gms_internal_zztc.zzHl());
                        continue;
                    case 106:
                        this.zzaSo = com_google_android_gms_internal_zztc.readString();
                        continue;
                    case 114:
                        this.appId = com_google_android_gms_internal_zztc.readString();
                        continue;
                    case TransportMediator.KEYCODE_MEDIA_RECORD /*130*/:
                        this.zzaKi = com_google_android_gms_internal_zztc.readString();
                        continue;
                    case 136:
                        this.zzaVD = Long.valueOf(com_google_android_gms_internal_zztc.zzHk());
                        continue;
                    case 144:
                        this.zzaVE = Long.valueOf(com_google_android_gms_internal_zztc.zzHk());
                        continue;
                    case 154:
                        this.zzaVF = com_google_android_gms_internal_zztc.readString();
                        continue;
                    case 160:
                        this.zzaVG = Boolean.valueOf(com_google_android_gms_internal_zztc.zzHm());
                        continue;
                    case 170:
                        this.zzaVH = com_google_android_gms_internal_zztc.readString();
                        continue;
                    case 176:
                        this.zzaVI = Long.valueOf(com_google_android_gms_internal_zztc.zzHk());
                        continue;
                    case 184:
                        this.zzaVJ = Integer.valueOf(com_google_android_gms_internal_zztc.zzHl());
                        continue;
                    case 194:
                        this.zzaSr = com_google_android_gms_internal_zztc.readString();
                        continue;
                    case 202:
                        this.zzaSn = com_google_android_gms_internal_zztc.readString();
                        continue;
                    case 208:
                        this.zzaVx = Long.valueOf(com_google_android_gms_internal_zztc.zzHk());
                        continue;
                    case 224:
                        this.zzaVK = Boolean.valueOf(com_google_android_gms_internal_zztc.zzHm());
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

        protected int zzz() {
            int i = 0;
            int zzz = super.zzz();
            if (this.zzaVr != null) {
                zzz += zztd.zzI(1, this.zzaVr.intValue());
            }
            if (this.zzaVs != null && this.zzaVs.length > 0) {
                int i2 = zzz;
                for (zztk com_google_android_gms_internal_zztk : this.zzaVs) {
                    if (com_google_android_gms_internal_zztk != null) {
                        i2 += zztd.zzc(2, com_google_android_gms_internal_zztk);
                    }
                }
                zzz = i2;
            }
            if (this.zzaVt != null && this.zzaVt.length > 0) {
                while (i < this.zzaVt.length) {
                    zztk com_google_android_gms_internal_zztk2 = this.zzaVt[i];
                    if (com_google_android_gms_internal_zztk2 != null) {
                        zzz += zztd.zzc(3, com_google_android_gms_internal_zztk2);
                    }
                    i++;
                }
            }
            if (this.zzaVu != null) {
                zzz += zztd.zzd(4, this.zzaVu.longValue());
            }
            if (this.zzaVv != null) {
                zzz += zztd.zzd(5, this.zzaVv.longValue());
            }
            if (this.zzaVw != null) {
                zzz += zztd.zzd(6, this.zzaVw.longValue());
            }
            if (this.zzaVy != null) {
                zzz += zztd.zzd(7, this.zzaVy.longValue());
            }
            if (this.zzaVz != null) {
                zzz += zztd.zzp(8, this.zzaVz);
            }
            if (this.osVersion != null) {
                zzz += zztd.zzp(9, this.osVersion);
            }
            if (this.zzaVA != null) {
                zzz += zztd.zzp(10, this.zzaVA);
            }
            if (this.zzaVB != null) {
                zzz += zztd.zzp(11, this.zzaVB);
            }
            if (this.zzaVC != null) {
                zzz += zztd.zzI(12, this.zzaVC.intValue());
            }
            if (this.zzaSo != null) {
                zzz += zztd.zzp(13, this.zzaSo);
            }
            if (this.appId != null) {
                zzz += zztd.zzp(14, this.appId);
            }
            if (this.zzaKi != null) {
                zzz += zztd.zzp(16, this.zzaKi);
            }
            if (this.zzaVD != null) {
                zzz += zztd.zzd(17, this.zzaVD.longValue());
            }
            if (this.zzaVE != null) {
                zzz += zztd.zzd(18, this.zzaVE.longValue());
            }
            if (this.zzaVF != null) {
                zzz += zztd.zzp(19, this.zzaVF);
            }
            if (this.zzaVG != null) {
                zzz += zztd.zzc(20, this.zzaVG.booleanValue());
            }
            if (this.zzaVH != null) {
                zzz += zztd.zzp(21, this.zzaVH);
            }
            if (this.zzaVI != null) {
                zzz += zztd.zzd(22, this.zzaVI.longValue());
            }
            if (this.zzaVJ != null) {
                zzz += zztd.zzI(23, this.zzaVJ.intValue());
            }
            if (this.zzaSr != null) {
                zzz += zztd.zzp(24, this.zzaSr);
            }
            if (this.zzaSn != null) {
                zzz += zztd.zzp(25, this.zzaSn);
            }
            if (this.zzaVx != null) {
                zzz += zztd.zzd(26, this.zzaVx.longValue());
            }
            return this.zzaVK != null ? zzz + zztd.zzc(28, this.zzaVK.booleanValue()) : zzz;
        }
    }

    public static final class zze extends zztk {
        private static volatile zze[] zzaVL;
        public String name;
        public Long zzaVM;
        public Float zzaVi;
        public Long zzaVo;
        public String zzakS;

        public zze() {
            zzCj();
        }

        public static zze[] zzCi() {
            if (zzaVL == null) {
                synchronized (zzti.zzbqa) {
                    if (zzaVL == null) {
                        zzaVL = new zze[0];
                    }
                }
            }
            return zzaVL;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zze)) {
                return false;
            }
            zze com_google_android_gms_internal_zzqq_zze = (zze) o;
            if (this.zzaVM == null) {
                if (com_google_android_gms_internal_zzqq_zze.zzaVM != null) {
                    return false;
                }
            } else if (!this.zzaVM.equals(com_google_android_gms_internal_zzqq_zze.zzaVM)) {
                return false;
            }
            if (this.name == null) {
                if (com_google_android_gms_internal_zzqq_zze.name != null) {
                    return false;
                }
            } else if (!this.name.equals(com_google_android_gms_internal_zzqq_zze.name)) {
                return false;
            }
            if (this.zzakS == null) {
                if (com_google_android_gms_internal_zzqq_zze.zzakS != null) {
                    return false;
                }
            } else if (!this.zzakS.equals(com_google_android_gms_internal_zzqq_zze.zzakS)) {
                return false;
            }
            if (this.zzaVo == null) {
                if (com_google_android_gms_internal_zzqq_zze.zzaVo != null) {
                    return false;
                }
            } else if (!this.zzaVo.equals(com_google_android_gms_internal_zzqq_zze.zzaVo)) {
                return false;
            }
            return this.zzaVi == null ? com_google_android_gms_internal_zzqq_zze.zzaVi == null : this.zzaVi.equals(com_google_android_gms_internal_zzqq_zze.zzaVi);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzaVo == null ? 0 : this.zzaVo.hashCode()) + (((this.zzakS == null ? 0 : this.zzakS.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + (((this.zzaVM == null ? 0 : this.zzaVM.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31;
            if (this.zzaVi != null) {
                i = this.zzaVi.hashCode();
            }
            return hashCode + i;
        }

        public /* synthetic */ zztk mergeFrom(zztc x0) throws IOException {
            return zzx(x0);
        }

        public void writeTo(zztd output) throws IOException {
            if (this.zzaVM != null) {
                output.zzb(1, this.zzaVM.longValue());
            }
            if (this.name != null) {
                output.zzb(2, this.name);
            }
            if (this.zzakS != null) {
                output.zzb(3, this.zzakS);
            }
            if (this.zzaVo != null) {
                output.zzb(4, this.zzaVo.longValue());
            }
            if (this.zzaVi != null) {
                output.zzb(5, this.zzaVi.floatValue());
            }
            super.writeTo(output);
        }

        public zze zzCj() {
            this.zzaVM = null;
            this.name = null;
            this.zzakS = null;
            this.zzaVo = null;
            this.zzaVi = null;
            this.zzbqb = -1;
            return this;
        }

        public zze zzx(zztc com_google_android_gms_internal_zztc) throws IOException {
            while (true) {
                int zzHi = com_google_android_gms_internal_zztc.zzHi();
                switch (zzHi) {
                    case 0:
                        break;
                    case 8:
                        this.zzaVM = Long.valueOf(com_google_android_gms_internal_zztc.zzHk());
                        continue;
                    case 18:
                        this.name = com_google_android_gms_internal_zztc.readString();
                        continue;
                    case 26:
                        this.zzakS = com_google_android_gms_internal_zztc.readString();
                        continue;
                    case 32:
                        this.zzaVo = Long.valueOf(com_google_android_gms_internal_zztc.zzHk());
                        continue;
                    case 45:
                        this.zzaVi = Float.valueOf(com_google_android_gms_internal_zztc.readFloat());
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

        protected int zzz() {
            int zzz = super.zzz();
            if (this.zzaVM != null) {
                zzz += zztd.zzd(1, this.zzaVM.longValue());
            }
            if (this.name != null) {
                zzz += zztd.zzp(2, this.name);
            }
            if (this.zzakS != null) {
                zzz += zztd.zzp(3, this.zzakS);
            }
            if (this.zzaVo != null) {
                zzz += zztd.zzd(4, this.zzaVo.longValue());
            }
            return this.zzaVi != null ? zzz + zztd.zzc(5, this.zzaVi.floatValue()) : zzz;
        }
    }
}
