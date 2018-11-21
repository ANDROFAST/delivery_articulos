package com.google.android.gms.internal;

import java.io.IOException;

public interface zzqd {

    public static final class zza extends zzte<zza> {
        public zza[] zzaJA;

        public static final class zza extends zzte<zza> {
            private static volatile zza[] zzaJB;
            public int viewId;
            public String zzaJC;
            public String zzaJD;

            public zza() {
                zzxF();
            }

            public static zza[] zzxE() {
                if (zzaJB == null) {
                    synchronized (zzti.zzbqa) {
                        if (zzaJB == null) {
                            zzaJB = new zza[0];
                        }
                    }
                }
                return zzaJB;
            }

            public boolean equals(Object o) {
                if (o == this) {
                    return true;
                }
                if (!(o instanceof zza)) {
                    return false;
                }
                zza com_google_android_gms_internal_zzqd_zza_zza = (zza) o;
                if (this.zzaJC == null) {
                    if (com_google_android_gms_internal_zzqd_zza_zza.zzaJC != null) {
                        return false;
                    }
                } else if (!this.zzaJC.equals(com_google_android_gms_internal_zzqd_zza_zza.zzaJC)) {
                    return false;
                }
                if (this.zzaJD == null) {
                    if (com_google_android_gms_internal_zzqd_zza_zza.zzaJD != null) {
                        return false;
                    }
                } else if (!this.zzaJD.equals(com_google_android_gms_internal_zzqd_zza_zza.zzaJD)) {
                    return false;
                }
                if (this.viewId != com_google_android_gms_internal_zzqd_zza_zza.viewId) {
                    return false;
                }
                if (this.zzbpQ == null || this.zzbpQ.isEmpty()) {
                    return com_google_android_gms_internal_zzqd_zza_zza.zzbpQ == null || com_google_android_gms_internal_zzqd_zza_zza.zzbpQ.isEmpty();
                } else {
                    return this.zzbpQ.equals(com_google_android_gms_internal_zzqd_zza_zza.zzbpQ);
                }
            }

            public int hashCode() {
                int i = 0;
                int hashCode = ((((this.zzaJD == null ? 0 : this.zzaJD.hashCode()) + (((this.zzaJC == null ? 0 : this.zzaJC.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31) + this.viewId) * 31;
                if (!(this.zzbpQ == null || this.zzbpQ.isEmpty())) {
                    i = this.zzbpQ.hashCode();
                }
                return hashCode + i;
            }

            public /* synthetic */ zztk mergeFrom(zztc x0) throws IOException {
                return zzp(x0);
            }

            public void writeTo(zztd output) throws IOException {
                if (!this.zzaJC.equals("")) {
                    output.zzb(1, this.zzaJC);
                }
                if (!this.zzaJD.equals("")) {
                    output.zzb(2, this.zzaJD);
                }
                if (this.viewId != 0) {
                    output.zzG(3, this.viewId);
                }
                super.writeTo(output);
            }

            public zza zzp(zztc com_google_android_gms_internal_zztc) throws IOException {
                while (true) {
                    int zzHi = com_google_android_gms_internal_zztc.zzHi();
                    switch (zzHi) {
                        case 0:
                            break;
                        case 10:
                            this.zzaJC = com_google_android_gms_internal_zztc.readString();
                            continue;
                        case 18:
                            this.zzaJD = com_google_android_gms_internal_zztc.readString();
                            continue;
                        case 24:
                            this.viewId = com_google_android_gms_internal_zztc.zzHl();
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

            public zza zzxF() {
                this.zzaJC = "";
                this.zzaJD = "";
                this.viewId = 0;
                this.zzbpQ = null;
                this.zzbqb = -1;
                return this;
            }

            protected int zzz() {
                int zzz = super.zzz();
                if (!this.zzaJC.equals("")) {
                    zzz += zztd.zzp(1, this.zzaJC);
                }
                if (!this.zzaJD.equals("")) {
                    zzz += zztd.zzp(2, this.zzaJD);
                }
                return this.viewId != 0 ? zzz + zztd.zzI(3, this.viewId) : zzz;
            }
        }

        public zza() {
            zzxD();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zzqd_zza = (zza) o;
            if (!zzti.equals(this.zzaJA, com_google_android_gms_internal_zzqd_zza.zzaJA)) {
                return false;
            }
            if (this.zzbpQ == null || this.zzbpQ.isEmpty()) {
                return com_google_android_gms_internal_zzqd_zza.zzbpQ == null || com_google_android_gms_internal_zzqd_zza.zzbpQ.isEmpty();
            } else {
                return this.zzbpQ.equals(com_google_android_gms_internal_zzqd_zza.zzbpQ);
            }
        }

        public int hashCode() {
            int hashCode = (((getClass().getName().hashCode() + 527) * 31) + zzti.hashCode(this.zzaJA)) * 31;
            int hashCode2 = (this.zzbpQ == null || this.zzbpQ.isEmpty()) ? 0 : this.zzbpQ.hashCode();
            return hashCode2 + hashCode;
        }

        public /* synthetic */ zztk mergeFrom(zztc x0) throws IOException {
            return zzo(x0);
        }

        public void writeTo(zztd output) throws IOException {
            if (this.zzaJA != null && this.zzaJA.length > 0) {
                for (zztk com_google_android_gms_internal_zztk : this.zzaJA) {
                    if (com_google_android_gms_internal_zztk != null) {
                        output.zza(1, com_google_android_gms_internal_zztk);
                    }
                }
            }
            super.writeTo(output);
        }

        public zza zzo(zztc com_google_android_gms_internal_zztc) throws IOException {
            while (true) {
                int zzHi = com_google_android_gms_internal_zztc.zzHi();
                switch (zzHi) {
                    case 0:
                        break;
                    case 10:
                        int zzc = zztn.zzc(com_google_android_gms_internal_zztc, 10);
                        zzHi = this.zzaJA == null ? 0 : this.zzaJA.length;
                        Object obj = new zza[(zzc + zzHi)];
                        if (zzHi != 0) {
                            System.arraycopy(this.zzaJA, 0, obj, 0, zzHi);
                        }
                        while (zzHi < obj.length - 1) {
                            obj[zzHi] = new zza();
                            com_google_android_gms_internal_zztc.zza(obj[zzHi]);
                            com_google_android_gms_internal_zztc.zzHi();
                            zzHi++;
                        }
                        obj[zzHi] = new zza();
                        com_google_android_gms_internal_zztc.zza(obj[zzHi]);
                        this.zzaJA = obj;
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

        public zza zzxD() {
            this.zzaJA = zza.zzxE();
            this.zzbpQ = null;
            this.zzbqb = -1;
            return this;
        }

        protected int zzz() {
            int zzz = super.zzz();
            if (this.zzaJA != null && this.zzaJA.length > 0) {
                for (zztk com_google_android_gms_internal_zztk : this.zzaJA) {
                    if (com_google_android_gms_internal_zztk != null) {
                        zzz += zztd.zzc(1, com_google_android_gms_internal_zztk);
                    }
                }
            }
            return zzz;
        }
    }

    public static final class zzb extends zzte<zzb> {
        private static volatile zzb[] zzaJE;
        public String name;
        public zzd zzaJF;

        public zzb() {
            zzxH();
        }

        public static zzb[] zzxG() {
            if (zzaJE == null) {
                synchronized (zzti.zzbqa) {
                    if (zzaJE == null) {
                        zzaJE = new zzb[0];
                    }
                }
            }
            return zzaJE;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzb)) {
                return false;
            }
            zzb com_google_android_gms_internal_zzqd_zzb = (zzb) o;
            if (this.name == null) {
                if (com_google_android_gms_internal_zzqd_zzb.name != null) {
                    return false;
                }
            } else if (!this.name.equals(com_google_android_gms_internal_zzqd_zzb.name)) {
                return false;
            }
            if (this.zzaJF == null) {
                if (com_google_android_gms_internal_zzqd_zzb.zzaJF != null) {
                    return false;
                }
            } else if (!this.zzaJF.equals(com_google_android_gms_internal_zzqd_zzb.zzaJF)) {
                return false;
            }
            if (this.zzbpQ == null || this.zzbpQ.isEmpty()) {
                return com_google_android_gms_internal_zzqd_zzb.zzbpQ == null || com_google_android_gms_internal_zzqd_zzb.zzbpQ.isEmpty();
            } else {
                return this.zzbpQ.equals(com_google_android_gms_internal_zzqd_zzb.zzbpQ);
            }
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzaJF == null ? 0 : this.zzaJF.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
            if (!(this.zzbpQ == null || this.zzbpQ.isEmpty())) {
                i = this.zzbpQ.hashCode();
            }
            return hashCode + i;
        }

        public /* synthetic */ zztk mergeFrom(zztc x0) throws IOException {
            return zzq(x0);
        }

        public void writeTo(zztd output) throws IOException {
            if (!this.name.equals("")) {
                output.zzb(1, this.name);
            }
            if (this.zzaJF != null) {
                output.zza(2, this.zzaJF);
            }
            super.writeTo(output);
        }

        public zzb zzq(zztc com_google_android_gms_internal_zztc) throws IOException {
            while (true) {
                int zzHi = com_google_android_gms_internal_zztc.zzHi();
                switch (zzHi) {
                    case 0:
                        break;
                    case 10:
                        this.name = com_google_android_gms_internal_zztc.readString();
                        continue;
                    case 18:
                        if (this.zzaJF == null) {
                            this.zzaJF = new zzd();
                        }
                        com_google_android_gms_internal_zztc.zza(this.zzaJF);
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

        public zzb zzxH() {
            this.name = "";
            this.zzaJF = null;
            this.zzbpQ = null;
            this.zzbqb = -1;
            return this;
        }

        protected int zzz() {
            int zzz = super.zzz();
            if (!this.name.equals("")) {
                zzz += zztd.zzp(1, this.name);
            }
            return this.zzaJF != null ? zzz + zztd.zzc(2, this.zzaJF) : zzz;
        }
    }

    public static final class zzc extends zzte<zzc> {
        public String type;
        public zzb[] zzaJG;

        public zzc() {
            zzxI();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzc)) {
                return false;
            }
            zzc com_google_android_gms_internal_zzqd_zzc = (zzc) o;
            if (this.type == null) {
                if (com_google_android_gms_internal_zzqd_zzc.type != null) {
                    return false;
                }
            } else if (!this.type.equals(com_google_android_gms_internal_zzqd_zzc.type)) {
                return false;
            }
            if (!zzti.equals(this.zzaJG, com_google_android_gms_internal_zzqd_zzc.zzaJG)) {
                return false;
            }
            if (this.zzbpQ == null || this.zzbpQ.isEmpty()) {
                return com_google_android_gms_internal_zzqd_zzc.zzbpQ == null || com_google_android_gms_internal_zzqd_zzc.zzbpQ.isEmpty();
            } else {
                return this.zzbpQ.equals(com_google_android_gms_internal_zzqd_zzc.zzbpQ);
            }
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((this.type == null ? 0 : this.type.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + zzti.hashCode(this.zzaJG)) * 31;
            if (!(this.zzbpQ == null || this.zzbpQ.isEmpty())) {
                i = this.zzbpQ.hashCode();
            }
            return hashCode + i;
        }

        public /* synthetic */ zztk mergeFrom(zztc x0) throws IOException {
            return zzr(x0);
        }

        public void writeTo(zztd output) throws IOException {
            if (!this.type.equals("")) {
                output.zzb(1, this.type);
            }
            if (this.zzaJG != null && this.zzaJG.length > 0) {
                for (zztk com_google_android_gms_internal_zztk : this.zzaJG) {
                    if (com_google_android_gms_internal_zztk != null) {
                        output.zza(2, com_google_android_gms_internal_zztk);
                    }
                }
            }
            super.writeTo(output);
        }

        public zzc zzr(zztc com_google_android_gms_internal_zztc) throws IOException {
            while (true) {
                int zzHi = com_google_android_gms_internal_zztc.zzHi();
                switch (zzHi) {
                    case 0:
                        break;
                    case 10:
                        this.type = com_google_android_gms_internal_zztc.readString();
                        continue;
                    case 18:
                        int zzc = zztn.zzc(com_google_android_gms_internal_zztc, 18);
                        zzHi = this.zzaJG == null ? 0 : this.zzaJG.length;
                        Object obj = new zzb[(zzc + zzHi)];
                        if (zzHi != 0) {
                            System.arraycopy(this.zzaJG, 0, obj, 0, zzHi);
                        }
                        while (zzHi < obj.length - 1) {
                            obj[zzHi] = new zzb();
                            com_google_android_gms_internal_zztc.zza(obj[zzHi]);
                            com_google_android_gms_internal_zztc.zzHi();
                            zzHi++;
                        }
                        obj[zzHi] = new zzb();
                        com_google_android_gms_internal_zztc.zza(obj[zzHi]);
                        this.zzaJG = obj;
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

        public zzc zzxI() {
            this.type = "";
            this.zzaJG = zzb.zzxG();
            this.zzbpQ = null;
            this.zzbqb = -1;
            return this;
        }

        protected int zzz() {
            int zzz = super.zzz();
            if (!this.type.equals("")) {
                zzz += zztd.zzp(1, this.type);
            }
            if (this.zzaJG == null || this.zzaJG.length <= 0) {
                return zzz;
            }
            int i = zzz;
            for (zztk com_google_android_gms_internal_zztk : this.zzaJG) {
                if (com_google_android_gms_internal_zztk != null) {
                    i += zztd.zzc(2, com_google_android_gms_internal_zztk);
                }
            }
            return i;
        }
    }

    public static final class zzd extends zzte<zzd> {
        public boolean zzaJH;
        public long zzaJI;
        public double zzaJJ;
        public zzc zzaJK;
        public String zzakS;

        public zzd() {
            zzxJ();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzd)) {
                return false;
            }
            zzd com_google_android_gms_internal_zzqd_zzd = (zzd) o;
            if (this.zzaJH != com_google_android_gms_internal_zzqd_zzd.zzaJH) {
                return false;
            }
            if (this.zzakS == null) {
                if (com_google_android_gms_internal_zzqd_zzd.zzakS != null) {
                    return false;
                }
            } else if (!this.zzakS.equals(com_google_android_gms_internal_zzqd_zzd.zzakS)) {
                return false;
            }
            if (this.zzaJI != com_google_android_gms_internal_zzqd_zzd.zzaJI || Double.doubleToLongBits(this.zzaJJ) != Double.doubleToLongBits(com_google_android_gms_internal_zzqd_zzd.zzaJJ)) {
                return false;
            }
            if (this.zzaJK == null) {
                if (com_google_android_gms_internal_zzqd_zzd.zzaJK != null) {
                    return false;
                }
            } else if (!this.zzaJK.equals(com_google_android_gms_internal_zzqd_zzd.zzaJK)) {
                return false;
            }
            if (this.zzbpQ == null || this.zzbpQ.isEmpty()) {
                return com_google_android_gms_internal_zzqd_zzd.zzbpQ == null || com_google_android_gms_internal_zzqd_zzd.zzbpQ.isEmpty();
            } else {
                return this.zzbpQ.equals(com_google_android_gms_internal_zzqd_zzd.zzbpQ);
            }
        }

        public int hashCode() {
            int i = 0;
            int hashCode = (((this.zzakS == null ? 0 : this.zzakS.hashCode()) + (((this.zzaJH ? 1231 : 1237) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31) + ((int) (this.zzaJI ^ (this.zzaJI >>> 32)));
            long doubleToLongBits = Double.doubleToLongBits(this.zzaJJ);
            hashCode = ((this.zzaJK == null ? 0 : this.zzaJK.hashCode()) + (((hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31)) * 31;
            if (!(this.zzbpQ == null || this.zzbpQ.isEmpty())) {
                i = this.zzbpQ.hashCode();
            }
            return hashCode + i;
        }

        public /* synthetic */ zztk mergeFrom(zztc x0) throws IOException {
            return zzs(x0);
        }

        public void writeTo(zztd output) throws IOException {
            if (this.zzaJH) {
                output.zzb(1, this.zzaJH);
            }
            if (!this.zzakS.equals("")) {
                output.zzb(2, this.zzakS);
            }
            if (this.zzaJI != 0) {
                output.zzb(3, this.zzaJI);
            }
            if (Double.doubleToLongBits(this.zzaJJ) != Double.doubleToLongBits(0.0d)) {
                output.zza(4, this.zzaJJ);
            }
            if (this.zzaJK != null) {
                output.zza(5, this.zzaJK);
            }
            super.writeTo(output);
        }

        public zzd zzs(zztc com_google_android_gms_internal_zztc) throws IOException {
            while (true) {
                int zzHi = com_google_android_gms_internal_zztc.zzHi();
                switch (zzHi) {
                    case 0:
                        break;
                    case 8:
                        this.zzaJH = com_google_android_gms_internal_zztc.zzHm();
                        continue;
                    case 18:
                        this.zzakS = com_google_android_gms_internal_zztc.readString();
                        continue;
                    case 24:
                        this.zzaJI = com_google_android_gms_internal_zztc.zzHk();
                        continue;
                    case 33:
                        this.zzaJJ = com_google_android_gms_internal_zztc.readDouble();
                        continue;
                    case 42:
                        if (this.zzaJK == null) {
                            this.zzaJK = new zzc();
                        }
                        com_google_android_gms_internal_zztc.zza(this.zzaJK);
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

        public zzd zzxJ() {
            this.zzaJH = false;
            this.zzakS = "";
            this.zzaJI = 0;
            this.zzaJJ = 0.0d;
            this.zzaJK = null;
            this.zzbpQ = null;
            this.zzbqb = -1;
            return this;
        }

        protected int zzz() {
            int zzz = super.zzz();
            if (this.zzaJH) {
                zzz += zztd.zzc(1, this.zzaJH);
            }
            if (!this.zzakS.equals("")) {
                zzz += zztd.zzp(2, this.zzakS);
            }
            if (this.zzaJI != 0) {
                zzz += zztd.zzd(3, this.zzaJI);
            }
            if (Double.doubleToLongBits(this.zzaJJ) != Double.doubleToLongBits(0.0d)) {
                zzz += zztd.zzb(4, this.zzaJJ);
            }
            return this.zzaJK != null ? zzz + zztd.zzc(5, this.zzaJK) : zzz;
        }
    }
}
