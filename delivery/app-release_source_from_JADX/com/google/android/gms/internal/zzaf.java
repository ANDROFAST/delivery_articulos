package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import java.io.IOException;

public interface zzaf {

    public static final class zza extends zzte<zza> {
        public int level;
        public int zzih;
        public int zzii;

        public zza() {
            zzB();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zzaf_zza = (zza) o;
            if (this.level != com_google_android_gms_internal_zzaf_zza.level || this.zzih != com_google_android_gms_internal_zzaf_zza.zzih || this.zzii != com_google_android_gms_internal_zzaf_zza.zzii) {
                return false;
            }
            if (this.zzbpQ == null || this.zzbpQ.isEmpty()) {
                return com_google_android_gms_internal_zzaf_zza.zzbpQ == null || com_google_android_gms_internal_zzaf_zza.zzbpQ.isEmpty();
            } else {
                return this.zzbpQ.equals(com_google_android_gms_internal_zzaf_zza.zzbpQ);
            }
        }

        public int hashCode() {
            int hashCode = (((((((getClass().getName().hashCode() + 527) * 31) + this.level) * 31) + this.zzih) * 31) + this.zzii) * 31;
            int hashCode2 = (this.zzbpQ == null || this.zzbpQ.isEmpty()) ? 0 : this.zzbpQ.hashCode();
            return hashCode2 + hashCode;
        }

        public /* synthetic */ zztk mergeFrom(zztc x0) throws IOException {
            return zza(x0);
        }

        public void writeTo(zztd output) throws IOException {
            if (this.level != 1) {
                output.zzG(1, this.level);
            }
            if (this.zzih != 0) {
                output.zzG(2, this.zzih);
            }
            if (this.zzii != 0) {
                output.zzG(3, this.zzii);
            }
            super.writeTo(output);
        }

        public zza zzB() {
            this.level = 1;
            this.zzih = 0;
            this.zzii = 0;
            this.zzbpQ = null;
            this.zzbqb = -1;
            return this;
        }

        public zza zza(zztc com_google_android_gms_internal_zztc) throws IOException {
            while (true) {
                int zzHi = com_google_android_gms_internal_zztc.zzHi();
                switch (zzHi) {
                    case 0:
                        break;
                    case 8:
                        zzHi = com_google_android_gms_internal_zztc.zzHl();
                        switch (zzHi) {
                            case 1:
                            case 2:
                            case 3:
                                this.level = zzHi;
                                break;
                            default:
                                continue;
                        }
                    case 16:
                        this.zzih = com_google_android_gms_internal_zztc.zzHl();
                        continue;
                    case 24:
                        this.zzii = com_google_android_gms_internal_zztc.zzHl();
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
            int zzz = super.zzz();
            if (this.level != 1) {
                zzz += zztd.zzI(1, this.level);
            }
            if (this.zzih != 0) {
                zzz += zztd.zzI(2, this.zzih);
            }
            return this.zzii != 0 ? zzz + zztd.zzI(3, this.zzii) : zzz;
        }
    }

    public static final class zzb extends zzte<zzb> {
        private static volatile zzb[] zzij;
        public int name;
        public int[] zzik;
        public int zzil;
        public boolean zzim;
        public boolean zzin;

        public zzb() {
            zzD();
        }

        public static zzb[] zzC() {
            if (zzij == null) {
                synchronized (zzti.zzbqa) {
                    if (zzij == null) {
                        zzij = new zzb[0];
                    }
                }
            }
            return zzij;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzb)) {
                return false;
            }
            zzb com_google_android_gms_internal_zzaf_zzb = (zzb) o;
            if (!zzti.equals(this.zzik, com_google_android_gms_internal_zzaf_zzb.zzik) || this.zzil != com_google_android_gms_internal_zzaf_zzb.zzil || this.name != com_google_android_gms_internal_zzaf_zzb.name || this.zzim != com_google_android_gms_internal_zzaf_zzb.zzim || this.zzin != com_google_android_gms_internal_zzaf_zzb.zzin) {
                return false;
            }
            if (this.zzbpQ == null || this.zzbpQ.isEmpty()) {
                return com_google_android_gms_internal_zzaf_zzb.zzbpQ == null || com_google_android_gms_internal_zzaf_zzb.zzbpQ.isEmpty();
            } else {
                return this.zzbpQ.equals(com_google_android_gms_internal_zzaf_zzb.zzbpQ);
            }
        }

        public int hashCode() {
            int i = 1231;
            int hashCode = ((this.zzim ? 1231 : 1237) + ((((((((getClass().getName().hashCode() + 527) * 31) + zzti.hashCode(this.zzik)) * 31) + this.zzil) * 31) + this.name) * 31)) * 31;
            if (!this.zzin) {
                i = 1237;
            }
            i = (hashCode + i) * 31;
            hashCode = (this.zzbpQ == null || this.zzbpQ.isEmpty()) ? 0 : this.zzbpQ.hashCode();
            return hashCode + i;
        }

        public /* synthetic */ zztk mergeFrom(zztc x0) throws IOException {
            return zzb(x0);
        }

        public void writeTo(zztd output) throws IOException {
            if (this.zzin) {
                output.zzb(1, this.zzin);
            }
            output.zzG(2, this.zzil);
            if (this.zzik != null && this.zzik.length > 0) {
                for (int zzG : this.zzik) {
                    output.zzG(3, zzG);
                }
            }
            if (this.name != 0) {
                output.zzG(4, this.name);
            }
            if (this.zzim) {
                output.zzb(6, this.zzim);
            }
            super.writeTo(output);
        }

        public zzb zzD() {
            this.zzik = zztn.zzboD;
            this.zzil = 0;
            this.name = 0;
            this.zzim = false;
            this.zzin = false;
            this.zzbpQ = null;
            this.zzbqb = -1;
            return this;
        }

        public zzb zzb(zztc com_google_android_gms_internal_zztc) throws IOException {
            while (true) {
                int zzHi = com_google_android_gms_internal_zztc.zzHi();
                int zzc;
                switch (zzHi) {
                    case 0:
                        break;
                    case 8:
                        this.zzin = com_google_android_gms_internal_zztc.zzHm();
                        continue;
                    case 16:
                        this.zzil = com_google_android_gms_internal_zztc.zzHl();
                        continue;
                    case 24:
                        zzc = zztn.zzc(com_google_android_gms_internal_zztc, 24);
                        zzHi = this.zzik == null ? 0 : this.zzik.length;
                        Object obj = new int[(zzc + zzHi)];
                        if (zzHi != 0) {
                            System.arraycopy(this.zzik, 0, obj, 0, zzHi);
                        }
                        while (zzHi < obj.length - 1) {
                            obj[zzHi] = com_google_android_gms_internal_zztc.zzHl();
                            com_google_android_gms_internal_zztc.zzHi();
                            zzHi++;
                        }
                        obj[zzHi] = com_google_android_gms_internal_zztc.zzHl();
                        this.zzik = obj;
                        continue;
                    case 26:
                        int zzmn = com_google_android_gms_internal_zztc.zzmn(com_google_android_gms_internal_zztc.zzHp());
                        zzc = com_google_android_gms_internal_zztc.getPosition();
                        zzHi = 0;
                        while (com_google_android_gms_internal_zztc.zzHu() > 0) {
                            com_google_android_gms_internal_zztc.zzHl();
                            zzHi++;
                        }
                        com_google_android_gms_internal_zztc.zzmp(zzc);
                        zzc = this.zzik == null ? 0 : this.zzik.length;
                        Object obj2 = new int[(zzHi + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzik, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zztc.zzHl();
                            zzc++;
                        }
                        this.zzik = obj2;
                        com_google_android_gms_internal_zztc.zzmo(zzmn);
                        continue;
                    case 32:
                        this.name = com_google_android_gms_internal_zztc.zzHl();
                        continue;
                    case 48:
                        this.zzim = com_google_android_gms_internal_zztc.zzHm();
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
            int i = 0;
            int zzz = super.zzz();
            if (this.zzin) {
                zzz += zztd.zzc(1, this.zzin);
            }
            int zzI = zztd.zzI(2, this.zzil) + zzz;
            if (this.zzik == null || this.zzik.length <= 0) {
                zzz = zzI;
            } else {
                for (int zzmu : this.zzik) {
                    i += zztd.zzmu(zzmu);
                }
                zzz = (zzI + i) + (this.zzik.length * 1);
            }
            if (this.name != 0) {
                zzz += zztd.zzI(4, this.name);
            }
            return this.zzim ? zzz + zztd.zzc(6, this.zzim) : zzz;
        }
    }

    public static final class zzc extends zzte<zzc> {
        private static volatile zzc[] zzio;
        public String key;
        public long zzip;
        public long zziq;
        public boolean zzir;
        public long zzis;

        public zzc() {
            zzF();
        }

        public static zzc[] zzE() {
            if (zzio == null) {
                synchronized (zzti.zzbqa) {
                    if (zzio == null) {
                        zzio = new zzc[0];
                    }
                }
            }
            return zzio;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzc)) {
                return false;
            }
            zzc com_google_android_gms_internal_zzaf_zzc = (zzc) o;
            if (this.key == null) {
                if (com_google_android_gms_internal_zzaf_zzc.key != null) {
                    return false;
                }
            } else if (!this.key.equals(com_google_android_gms_internal_zzaf_zzc.key)) {
                return false;
            }
            if (this.zzip != com_google_android_gms_internal_zzaf_zzc.zzip || this.zziq != com_google_android_gms_internal_zzaf_zzc.zziq || this.zzir != com_google_android_gms_internal_zzaf_zzc.zzir || this.zzis != com_google_android_gms_internal_zzaf_zzc.zzis) {
                return false;
            }
            if (this.zzbpQ == null || this.zzbpQ.isEmpty()) {
                return com_google_android_gms_internal_zzaf_zzc.zzbpQ == null || com_google_android_gms_internal_zzaf_zzc.zzbpQ.isEmpty();
            } else {
                return this.zzbpQ.equals(com_google_android_gms_internal_zzaf_zzc.zzbpQ);
            }
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((this.zzir ? 1231 : 1237) + (((((((this.key == null ? 0 : this.key.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + ((int) (this.zzip ^ (this.zzip >>> 32)))) * 31) + ((int) (this.zziq ^ (this.zziq >>> 32)))) * 31)) * 31) + ((int) (this.zzis ^ (this.zzis >>> 32)))) * 31;
            if (!(this.zzbpQ == null || this.zzbpQ.isEmpty())) {
                i = this.zzbpQ.hashCode();
            }
            return hashCode + i;
        }

        public /* synthetic */ zztk mergeFrom(zztc x0) throws IOException {
            return zzc(x0);
        }

        public void writeTo(zztd output) throws IOException {
            if (!this.key.equals("")) {
                output.zzb(1, this.key);
            }
            if (this.zzip != 0) {
                output.zzb(2, this.zzip);
            }
            if (this.zziq != 2147483647L) {
                output.zzb(3, this.zziq);
            }
            if (this.zzir) {
                output.zzb(4, this.zzir);
            }
            if (this.zzis != 0) {
                output.zzb(5, this.zzis);
            }
            super.writeTo(output);
        }

        public zzc zzF() {
            this.key = "";
            this.zzip = 0;
            this.zziq = 2147483647L;
            this.zzir = false;
            this.zzis = 0;
            this.zzbpQ = null;
            this.zzbqb = -1;
            return this;
        }

        public zzc zzc(zztc com_google_android_gms_internal_zztc) throws IOException {
            while (true) {
                int zzHi = com_google_android_gms_internal_zztc.zzHi();
                switch (zzHi) {
                    case 0:
                        break;
                    case 10:
                        this.key = com_google_android_gms_internal_zztc.readString();
                        continue;
                    case 16:
                        this.zzip = com_google_android_gms_internal_zztc.zzHk();
                        continue;
                    case 24:
                        this.zziq = com_google_android_gms_internal_zztc.zzHk();
                        continue;
                    case 32:
                        this.zzir = com_google_android_gms_internal_zztc.zzHm();
                        continue;
                    case 40:
                        this.zzis = com_google_android_gms_internal_zztc.zzHk();
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
            int zzz = super.zzz();
            if (!this.key.equals("")) {
                zzz += zztd.zzp(1, this.key);
            }
            if (this.zzip != 0) {
                zzz += zztd.zzd(2, this.zzip);
            }
            if (this.zziq != 2147483647L) {
                zzz += zztd.zzd(3, this.zziq);
            }
            if (this.zzir) {
                zzz += zztd.zzc(4, this.zzir);
            }
            return this.zzis != 0 ? zzz + zztd.zzd(5, this.zzis) : zzz;
        }
    }

    public static final class zzd extends zzte<zzd> {
        public com.google.android.gms.internal.zzag.zza[] zzit;
        public com.google.android.gms.internal.zzag.zza[] zziu;
        public zzc[] zziv;

        public zzd() {
            zzG();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzd)) {
                return false;
            }
            zzd com_google_android_gms_internal_zzaf_zzd = (zzd) o;
            if (!zzti.equals(this.zzit, com_google_android_gms_internal_zzaf_zzd.zzit) || !zzti.equals(this.zziu, com_google_android_gms_internal_zzaf_zzd.zziu) || !zzti.equals(this.zziv, com_google_android_gms_internal_zzaf_zzd.zziv)) {
                return false;
            }
            if (this.zzbpQ == null || this.zzbpQ.isEmpty()) {
                return com_google_android_gms_internal_zzaf_zzd.zzbpQ == null || com_google_android_gms_internal_zzaf_zzd.zzbpQ.isEmpty();
            } else {
                return this.zzbpQ.equals(com_google_android_gms_internal_zzaf_zzd.zzbpQ);
            }
        }

        public int hashCode() {
            int hashCode = (((((((getClass().getName().hashCode() + 527) * 31) + zzti.hashCode(this.zzit)) * 31) + zzti.hashCode(this.zziu)) * 31) + zzti.hashCode(this.zziv)) * 31;
            int hashCode2 = (this.zzbpQ == null || this.zzbpQ.isEmpty()) ? 0 : this.zzbpQ.hashCode();
            return hashCode2 + hashCode;
        }

        public /* synthetic */ zztk mergeFrom(zztc x0) throws IOException {
            return zzd(x0);
        }

        public void writeTo(zztd output) throws IOException {
            int i = 0;
            if (this.zzit != null && this.zzit.length > 0) {
                for (zztk com_google_android_gms_internal_zztk : this.zzit) {
                    if (com_google_android_gms_internal_zztk != null) {
                        output.zza(1, com_google_android_gms_internal_zztk);
                    }
                }
            }
            if (this.zziu != null && this.zziu.length > 0) {
                for (zztk com_google_android_gms_internal_zztk2 : this.zziu) {
                    if (com_google_android_gms_internal_zztk2 != null) {
                        output.zza(2, com_google_android_gms_internal_zztk2);
                    }
                }
            }
            if (this.zziv != null && this.zziv.length > 0) {
                while (i < this.zziv.length) {
                    zztk com_google_android_gms_internal_zztk3 = this.zziv[i];
                    if (com_google_android_gms_internal_zztk3 != null) {
                        output.zza(3, com_google_android_gms_internal_zztk3);
                    }
                    i++;
                }
            }
            super.writeTo(output);
        }

        public zzd zzG() {
            this.zzit = com.google.android.gms.internal.zzag.zza.zzQ();
            this.zziu = com.google.android.gms.internal.zzag.zza.zzQ();
            this.zziv = zzc.zzE();
            this.zzbpQ = null;
            this.zzbqb = -1;
            return this;
        }

        public zzd zzd(zztc com_google_android_gms_internal_zztc) throws IOException {
            while (true) {
                int zzHi = com_google_android_gms_internal_zztc.zzHi();
                int zzc;
                Object obj;
                switch (zzHi) {
                    case 0:
                        break;
                    case 10:
                        zzc = zztn.zzc(com_google_android_gms_internal_zztc, 10);
                        zzHi = this.zzit == null ? 0 : this.zzit.length;
                        obj = new com.google.android.gms.internal.zzag.zza[(zzc + zzHi)];
                        if (zzHi != 0) {
                            System.arraycopy(this.zzit, 0, obj, 0, zzHi);
                        }
                        while (zzHi < obj.length - 1) {
                            obj[zzHi] = new com.google.android.gms.internal.zzag.zza();
                            com_google_android_gms_internal_zztc.zza(obj[zzHi]);
                            com_google_android_gms_internal_zztc.zzHi();
                            zzHi++;
                        }
                        obj[zzHi] = new com.google.android.gms.internal.zzag.zza();
                        com_google_android_gms_internal_zztc.zza(obj[zzHi]);
                        this.zzit = obj;
                        continue;
                    case 18:
                        zzc = zztn.zzc(com_google_android_gms_internal_zztc, 18);
                        zzHi = this.zziu == null ? 0 : this.zziu.length;
                        obj = new com.google.android.gms.internal.zzag.zza[(zzc + zzHi)];
                        if (zzHi != 0) {
                            System.arraycopy(this.zziu, 0, obj, 0, zzHi);
                        }
                        while (zzHi < obj.length - 1) {
                            obj[zzHi] = new com.google.android.gms.internal.zzag.zza();
                            com_google_android_gms_internal_zztc.zza(obj[zzHi]);
                            com_google_android_gms_internal_zztc.zzHi();
                            zzHi++;
                        }
                        obj[zzHi] = new com.google.android.gms.internal.zzag.zza();
                        com_google_android_gms_internal_zztc.zza(obj[zzHi]);
                        this.zziu = obj;
                        continue;
                    case 26:
                        zzc = zztn.zzc(com_google_android_gms_internal_zztc, 26);
                        zzHi = this.zziv == null ? 0 : this.zziv.length;
                        obj = new zzc[(zzc + zzHi)];
                        if (zzHi != 0) {
                            System.arraycopy(this.zziv, 0, obj, 0, zzHi);
                        }
                        while (zzHi < obj.length - 1) {
                            obj[zzHi] = new zzc();
                            com_google_android_gms_internal_zztc.zza(obj[zzHi]);
                            com_google_android_gms_internal_zztc.zzHi();
                            zzHi++;
                        }
                        obj[zzHi] = new zzc();
                        com_google_android_gms_internal_zztc.zza(obj[zzHi]);
                        this.zziv = obj;
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
            int zzz = super.zzz();
            if (this.zzit != null && this.zzit.length > 0) {
                i = zzz;
                for (zztk com_google_android_gms_internal_zztk : this.zzit) {
                    if (com_google_android_gms_internal_zztk != null) {
                        i += zztd.zzc(1, com_google_android_gms_internal_zztk);
                    }
                }
                zzz = i;
            }
            if (this.zziu != null && this.zziu.length > 0) {
                i = zzz;
                for (zztk com_google_android_gms_internal_zztk2 : this.zziu) {
                    if (com_google_android_gms_internal_zztk2 != null) {
                        i += zztd.zzc(2, com_google_android_gms_internal_zztk2);
                    }
                }
                zzz = i;
            }
            if (this.zziv != null && this.zziv.length > 0) {
                while (i2 < this.zziv.length) {
                    zztk com_google_android_gms_internal_zztk3 = this.zziv[i2];
                    if (com_google_android_gms_internal_zztk3 != null) {
                        zzz += zztd.zzc(3, com_google_android_gms_internal_zztk3);
                    }
                    i2++;
                }
            }
            return zzz;
        }
    }

    public static final class zze extends zzte<zze> {
        private static volatile zze[] zziw;
        public int key;
        public int value;

        public zze() {
            zzI();
        }

        public static zze[] zzH() {
            if (zziw == null) {
                synchronized (zzti.zzbqa) {
                    if (zziw == null) {
                        zziw = new zze[0];
                    }
                }
            }
            return zziw;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zze)) {
                return false;
            }
            zze com_google_android_gms_internal_zzaf_zze = (zze) o;
            if (this.key != com_google_android_gms_internal_zzaf_zze.key || this.value != com_google_android_gms_internal_zzaf_zze.value) {
                return false;
            }
            if (this.zzbpQ == null || this.zzbpQ.isEmpty()) {
                return com_google_android_gms_internal_zzaf_zze.zzbpQ == null || com_google_android_gms_internal_zzaf_zze.zzbpQ.isEmpty();
            } else {
                return this.zzbpQ.equals(com_google_android_gms_internal_zzaf_zze.zzbpQ);
            }
        }

        public int hashCode() {
            int hashCode = (((((getClass().getName().hashCode() + 527) * 31) + this.key) * 31) + this.value) * 31;
            int hashCode2 = (this.zzbpQ == null || this.zzbpQ.isEmpty()) ? 0 : this.zzbpQ.hashCode();
            return hashCode2 + hashCode;
        }

        public /* synthetic */ zztk mergeFrom(zztc x0) throws IOException {
            return zze(x0);
        }

        public void writeTo(zztd output) throws IOException {
            output.zzG(1, this.key);
            output.zzG(2, this.value);
            super.writeTo(output);
        }

        public zze zzI() {
            this.key = 0;
            this.value = 0;
            this.zzbpQ = null;
            this.zzbqb = -1;
            return this;
        }

        public zze zze(zztc com_google_android_gms_internal_zztc) throws IOException {
            while (true) {
                int zzHi = com_google_android_gms_internal_zztc.zzHi();
                switch (zzHi) {
                    case 0:
                        break;
                    case 8:
                        this.key = com_google_android_gms_internal_zztc.zzHl();
                        continue;
                    case 16:
                        this.value = com_google_android_gms_internal_zztc.zzHl();
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
            return (super.zzz() + zztd.zzI(1, this.key)) + zztd.zzI(2, this.value);
        }
    }

    public static final class zzf extends zzte<zzf> {
        public String version;
        public zze[] zziA;
        public zzb[] zziB;
        public zzb[] zziC;
        public zzb[] zziD;
        public zzg[] zziE;
        public String zziF;
        public String zziG;
        public String zziH;
        public zza zziI;
        public float zziJ;
        public boolean zziK;
        public String[] zziL;
        public int zziM;
        public String[] zzix;
        public String[] zziy;
        public com.google.android.gms.internal.zzag.zza[] zziz;

        public zzf() {
            zzJ();
        }

        public static zzf zzc(byte[] bArr) throws zztj {
            return (zzf) zztk.mergeFrom(new zzf(), bArr);
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzf)) {
                return false;
            }
            zzf com_google_android_gms_internal_zzaf_zzf = (zzf) o;
            if (!zzti.equals(this.zzix, com_google_android_gms_internal_zzaf_zzf.zzix) || !zzti.equals(this.zziy, com_google_android_gms_internal_zzaf_zzf.zziy) || !zzti.equals(this.zziz, com_google_android_gms_internal_zzaf_zzf.zziz) || !zzti.equals(this.zziA, com_google_android_gms_internal_zzaf_zzf.zziA) || !zzti.equals(this.zziB, com_google_android_gms_internal_zzaf_zzf.zziB) || !zzti.equals(this.zziC, com_google_android_gms_internal_zzaf_zzf.zziC) || !zzti.equals(this.zziD, com_google_android_gms_internal_zzaf_zzf.zziD) || !zzti.equals(this.zziE, com_google_android_gms_internal_zzaf_zzf.zziE)) {
                return false;
            }
            if (this.zziF == null) {
                if (com_google_android_gms_internal_zzaf_zzf.zziF != null) {
                    return false;
                }
            } else if (!this.zziF.equals(com_google_android_gms_internal_zzaf_zzf.zziF)) {
                return false;
            }
            if (this.zziG == null) {
                if (com_google_android_gms_internal_zzaf_zzf.zziG != null) {
                    return false;
                }
            } else if (!this.zziG.equals(com_google_android_gms_internal_zzaf_zzf.zziG)) {
                return false;
            }
            if (this.zziH == null) {
                if (com_google_android_gms_internal_zzaf_zzf.zziH != null) {
                    return false;
                }
            } else if (!this.zziH.equals(com_google_android_gms_internal_zzaf_zzf.zziH)) {
                return false;
            }
            if (this.version == null) {
                if (com_google_android_gms_internal_zzaf_zzf.version != null) {
                    return false;
                }
            } else if (!this.version.equals(com_google_android_gms_internal_zzaf_zzf.version)) {
                return false;
            }
            if (this.zziI == null) {
                if (com_google_android_gms_internal_zzaf_zzf.zziI != null) {
                    return false;
                }
            } else if (!this.zziI.equals(com_google_android_gms_internal_zzaf_zzf.zziI)) {
                return false;
            }
            if (Float.floatToIntBits(this.zziJ) != Float.floatToIntBits(com_google_android_gms_internal_zzaf_zzf.zziJ) || this.zziK != com_google_android_gms_internal_zzaf_zzf.zziK || !zzti.equals(this.zziL, com_google_android_gms_internal_zzaf_zzf.zziL) || this.zziM != com_google_android_gms_internal_zzaf_zzf.zziM) {
                return false;
            }
            if (this.zzbpQ == null || this.zzbpQ.isEmpty()) {
                return com_google_android_gms_internal_zzaf_zzf.zzbpQ == null || com_google_android_gms_internal_zzaf_zzf.zzbpQ.isEmpty();
            } else {
                return this.zzbpQ.equals(com_google_android_gms_internal_zzaf_zzf.zzbpQ);
            }
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((((this.zziK ? 1231 : 1237) + (((((this.zziI == null ? 0 : this.zziI.hashCode()) + (((this.version == null ? 0 : this.version.hashCode()) + (((this.zziH == null ? 0 : this.zziH.hashCode()) + (((this.zziG == null ? 0 : this.zziG.hashCode()) + (((this.zziF == null ? 0 : this.zziF.hashCode()) + ((((((((((((((((((getClass().getName().hashCode() + 527) * 31) + zzti.hashCode(this.zzix)) * 31) + zzti.hashCode(this.zziy)) * 31) + zzti.hashCode(this.zziz)) * 31) + zzti.hashCode(this.zziA)) * 31) + zzti.hashCode(this.zziB)) * 31) + zzti.hashCode(this.zziC)) * 31) + zzti.hashCode(this.zziD)) * 31) + zzti.hashCode(this.zziE)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + Float.floatToIntBits(this.zziJ)) * 31)) * 31) + zzti.hashCode(this.zziL)) * 31) + this.zziM) * 31;
            if (!(this.zzbpQ == null || this.zzbpQ.isEmpty())) {
                i = this.zzbpQ.hashCode();
            }
            return hashCode + i;
        }

        public /* synthetic */ zztk mergeFrom(zztc x0) throws IOException {
            return zzf(x0);
        }

        public void writeTo(zztd output) throws IOException {
            int i = 0;
            if (this.zziy != null && this.zziy.length > 0) {
                for (String str : this.zziy) {
                    if (str != null) {
                        output.zzb(1, str);
                    }
                }
            }
            if (this.zziz != null && this.zziz.length > 0) {
                for (zztk com_google_android_gms_internal_zztk : this.zziz) {
                    if (com_google_android_gms_internal_zztk != null) {
                        output.zza(2, com_google_android_gms_internal_zztk);
                    }
                }
            }
            if (this.zziA != null && this.zziA.length > 0) {
                for (zztk com_google_android_gms_internal_zztk2 : this.zziA) {
                    if (com_google_android_gms_internal_zztk2 != null) {
                        output.zza(3, com_google_android_gms_internal_zztk2);
                    }
                }
            }
            if (this.zziB != null && this.zziB.length > 0) {
                for (zztk com_google_android_gms_internal_zztk22 : this.zziB) {
                    if (com_google_android_gms_internal_zztk22 != null) {
                        output.zza(4, com_google_android_gms_internal_zztk22);
                    }
                }
            }
            if (this.zziC != null && this.zziC.length > 0) {
                for (zztk com_google_android_gms_internal_zztk222 : this.zziC) {
                    if (com_google_android_gms_internal_zztk222 != null) {
                        output.zza(5, com_google_android_gms_internal_zztk222);
                    }
                }
            }
            if (this.zziD != null && this.zziD.length > 0) {
                for (zztk com_google_android_gms_internal_zztk2222 : this.zziD) {
                    if (com_google_android_gms_internal_zztk2222 != null) {
                        output.zza(6, com_google_android_gms_internal_zztk2222);
                    }
                }
            }
            if (this.zziE != null && this.zziE.length > 0) {
                for (zztk com_google_android_gms_internal_zztk22222 : this.zziE) {
                    if (com_google_android_gms_internal_zztk22222 != null) {
                        output.zza(7, com_google_android_gms_internal_zztk22222);
                    }
                }
            }
            if (!this.zziF.equals("")) {
                output.zzb(9, this.zziF);
            }
            if (!this.zziG.equals("")) {
                output.zzb(10, this.zziG);
            }
            if (!this.zziH.equals("0")) {
                output.zzb(12, this.zziH);
            }
            if (!this.version.equals("")) {
                output.zzb(13, this.version);
            }
            if (this.zziI != null) {
                output.zza(14, this.zziI);
            }
            if (Float.floatToIntBits(this.zziJ) != Float.floatToIntBits(0.0f)) {
                output.zzb(15, this.zziJ);
            }
            if (this.zziL != null && this.zziL.length > 0) {
                for (String str2 : this.zziL) {
                    if (str2 != null) {
                        output.zzb(16, str2);
                    }
                }
            }
            if (this.zziM != 0) {
                output.zzG(17, this.zziM);
            }
            if (this.zziK) {
                output.zzb(18, this.zziK);
            }
            if (this.zzix != null && this.zzix.length > 0) {
                while (i < this.zzix.length) {
                    String str3 = this.zzix[i];
                    if (str3 != null) {
                        output.zzb(19, str3);
                    }
                    i++;
                }
            }
            super.writeTo(output);
        }

        public zzf zzJ() {
            this.zzix = zztn.zzbqg;
            this.zziy = zztn.zzbqg;
            this.zziz = com.google.android.gms.internal.zzag.zza.zzQ();
            this.zziA = zze.zzH();
            this.zziB = zzb.zzC();
            this.zziC = zzb.zzC();
            this.zziD = zzb.zzC();
            this.zziE = zzg.zzK();
            this.zziF = "";
            this.zziG = "";
            this.zziH = "0";
            this.version = "";
            this.zziI = null;
            this.zziJ = 0.0f;
            this.zziK = false;
            this.zziL = zztn.zzbqg;
            this.zziM = 0;
            this.zzbpQ = null;
            this.zzbqb = -1;
            return this;
        }

        public zzf zzf(zztc com_google_android_gms_internal_zztc) throws IOException {
            while (true) {
                int zzHi = com_google_android_gms_internal_zztc.zzHi();
                int zzc;
                Object obj;
                switch (zzHi) {
                    case 0:
                        break;
                    case 10:
                        zzc = zztn.zzc(com_google_android_gms_internal_zztc, 10);
                        zzHi = this.zziy == null ? 0 : this.zziy.length;
                        obj = new String[(zzc + zzHi)];
                        if (zzHi != 0) {
                            System.arraycopy(this.zziy, 0, obj, 0, zzHi);
                        }
                        while (zzHi < obj.length - 1) {
                            obj[zzHi] = com_google_android_gms_internal_zztc.readString();
                            com_google_android_gms_internal_zztc.zzHi();
                            zzHi++;
                        }
                        obj[zzHi] = com_google_android_gms_internal_zztc.readString();
                        this.zziy = obj;
                        continue;
                    case 18:
                        zzc = zztn.zzc(com_google_android_gms_internal_zztc, 18);
                        zzHi = this.zziz == null ? 0 : this.zziz.length;
                        obj = new com.google.android.gms.internal.zzag.zza[(zzc + zzHi)];
                        if (zzHi != 0) {
                            System.arraycopy(this.zziz, 0, obj, 0, zzHi);
                        }
                        while (zzHi < obj.length - 1) {
                            obj[zzHi] = new com.google.android.gms.internal.zzag.zza();
                            com_google_android_gms_internal_zztc.zza(obj[zzHi]);
                            com_google_android_gms_internal_zztc.zzHi();
                            zzHi++;
                        }
                        obj[zzHi] = new com.google.android.gms.internal.zzag.zza();
                        com_google_android_gms_internal_zztc.zza(obj[zzHi]);
                        this.zziz = obj;
                        continue;
                    case 26:
                        zzc = zztn.zzc(com_google_android_gms_internal_zztc, 26);
                        zzHi = this.zziA == null ? 0 : this.zziA.length;
                        obj = new zze[(zzc + zzHi)];
                        if (zzHi != 0) {
                            System.arraycopy(this.zziA, 0, obj, 0, zzHi);
                        }
                        while (zzHi < obj.length - 1) {
                            obj[zzHi] = new zze();
                            com_google_android_gms_internal_zztc.zza(obj[zzHi]);
                            com_google_android_gms_internal_zztc.zzHi();
                            zzHi++;
                        }
                        obj[zzHi] = new zze();
                        com_google_android_gms_internal_zztc.zza(obj[zzHi]);
                        this.zziA = obj;
                        continue;
                    case 34:
                        zzc = zztn.zzc(com_google_android_gms_internal_zztc, 34);
                        zzHi = this.zziB == null ? 0 : this.zziB.length;
                        obj = new zzb[(zzc + zzHi)];
                        if (zzHi != 0) {
                            System.arraycopy(this.zziB, 0, obj, 0, zzHi);
                        }
                        while (zzHi < obj.length - 1) {
                            obj[zzHi] = new zzb();
                            com_google_android_gms_internal_zztc.zza(obj[zzHi]);
                            com_google_android_gms_internal_zztc.zzHi();
                            zzHi++;
                        }
                        obj[zzHi] = new zzb();
                        com_google_android_gms_internal_zztc.zza(obj[zzHi]);
                        this.zziB = obj;
                        continue;
                    case 42:
                        zzc = zztn.zzc(com_google_android_gms_internal_zztc, 42);
                        zzHi = this.zziC == null ? 0 : this.zziC.length;
                        obj = new zzb[(zzc + zzHi)];
                        if (zzHi != 0) {
                            System.arraycopy(this.zziC, 0, obj, 0, zzHi);
                        }
                        while (zzHi < obj.length - 1) {
                            obj[zzHi] = new zzb();
                            com_google_android_gms_internal_zztc.zza(obj[zzHi]);
                            com_google_android_gms_internal_zztc.zzHi();
                            zzHi++;
                        }
                        obj[zzHi] = new zzb();
                        com_google_android_gms_internal_zztc.zza(obj[zzHi]);
                        this.zziC = obj;
                        continue;
                    case 50:
                        zzc = zztn.zzc(com_google_android_gms_internal_zztc, 50);
                        zzHi = this.zziD == null ? 0 : this.zziD.length;
                        obj = new zzb[(zzc + zzHi)];
                        if (zzHi != 0) {
                            System.arraycopy(this.zziD, 0, obj, 0, zzHi);
                        }
                        while (zzHi < obj.length - 1) {
                            obj[zzHi] = new zzb();
                            com_google_android_gms_internal_zztc.zza(obj[zzHi]);
                            com_google_android_gms_internal_zztc.zzHi();
                            zzHi++;
                        }
                        obj[zzHi] = new zzb();
                        com_google_android_gms_internal_zztc.zza(obj[zzHi]);
                        this.zziD = obj;
                        continue;
                    case 58:
                        zzc = zztn.zzc(com_google_android_gms_internal_zztc, 58);
                        zzHi = this.zziE == null ? 0 : this.zziE.length;
                        obj = new zzg[(zzc + zzHi)];
                        if (zzHi != 0) {
                            System.arraycopy(this.zziE, 0, obj, 0, zzHi);
                        }
                        while (zzHi < obj.length - 1) {
                            obj[zzHi] = new zzg();
                            com_google_android_gms_internal_zztc.zza(obj[zzHi]);
                            com_google_android_gms_internal_zztc.zzHi();
                            zzHi++;
                        }
                        obj[zzHi] = new zzg();
                        com_google_android_gms_internal_zztc.zza(obj[zzHi]);
                        this.zziE = obj;
                        continue;
                    case 74:
                        this.zziF = com_google_android_gms_internal_zztc.readString();
                        continue;
                    case 82:
                        this.zziG = com_google_android_gms_internal_zztc.readString();
                        continue;
                    case 98:
                        this.zziH = com_google_android_gms_internal_zztc.readString();
                        continue;
                    case 106:
                        this.version = com_google_android_gms_internal_zztc.readString();
                        continue;
                    case 114:
                        if (this.zziI == null) {
                            this.zziI = new zza();
                        }
                        com_google_android_gms_internal_zztc.zza(this.zziI);
                        continue;
                    case 125:
                        this.zziJ = com_google_android_gms_internal_zztc.readFloat();
                        continue;
                    case TransportMediator.KEYCODE_MEDIA_RECORD /*130*/:
                        zzc = zztn.zzc(com_google_android_gms_internal_zztc, TransportMediator.KEYCODE_MEDIA_RECORD);
                        zzHi = this.zziL == null ? 0 : this.zziL.length;
                        obj = new String[(zzc + zzHi)];
                        if (zzHi != 0) {
                            System.arraycopy(this.zziL, 0, obj, 0, zzHi);
                        }
                        while (zzHi < obj.length - 1) {
                            obj[zzHi] = com_google_android_gms_internal_zztc.readString();
                            com_google_android_gms_internal_zztc.zzHi();
                            zzHi++;
                        }
                        obj[zzHi] = com_google_android_gms_internal_zztc.readString();
                        this.zziL = obj;
                        continue;
                    case 136:
                        this.zziM = com_google_android_gms_internal_zztc.zzHl();
                        continue;
                    case 144:
                        this.zziK = com_google_android_gms_internal_zztc.zzHm();
                        continue;
                    case 154:
                        zzc = zztn.zzc(com_google_android_gms_internal_zztc, 154);
                        zzHi = this.zzix == null ? 0 : this.zzix.length;
                        obj = new String[(zzc + zzHi)];
                        if (zzHi != 0) {
                            System.arraycopy(this.zzix, 0, obj, 0, zzHi);
                        }
                        while (zzHi < obj.length - 1) {
                            obj[zzHi] = com_google_android_gms_internal_zztc.readString();
                            com_google_android_gms_internal_zztc.zzHi();
                            zzHi++;
                        }
                        obj[zzHi] = com_google_android_gms_internal_zztc.readString();
                        this.zzix = obj;
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
            int i2;
            int i3;
            int i4 = 0;
            int zzz = super.zzz();
            if (this.zziy == null || this.zziy.length <= 0) {
                i = zzz;
            } else {
                i2 = 0;
                i3 = 0;
                for (String str : this.zziy) {
                    if (str != null) {
                        i3++;
                        i2 += zztd.zzga(str);
                    }
                }
                i = (zzz + i2) + (i3 * 1);
            }
            if (this.zziz != null && this.zziz.length > 0) {
                i2 = i;
                for (zztk com_google_android_gms_internal_zztk : this.zziz) {
                    if (com_google_android_gms_internal_zztk != null) {
                        i2 += zztd.zzc(2, com_google_android_gms_internal_zztk);
                    }
                }
                i = i2;
            }
            if (this.zziA != null && this.zziA.length > 0) {
                i2 = i;
                for (zztk com_google_android_gms_internal_zztk2 : this.zziA) {
                    if (com_google_android_gms_internal_zztk2 != null) {
                        i2 += zztd.zzc(3, com_google_android_gms_internal_zztk2);
                    }
                }
                i = i2;
            }
            if (this.zziB != null && this.zziB.length > 0) {
                i2 = i;
                for (zztk com_google_android_gms_internal_zztk22 : this.zziB) {
                    if (com_google_android_gms_internal_zztk22 != null) {
                        i2 += zztd.zzc(4, com_google_android_gms_internal_zztk22);
                    }
                }
                i = i2;
            }
            if (this.zziC != null && this.zziC.length > 0) {
                i2 = i;
                for (zztk com_google_android_gms_internal_zztk222 : this.zziC) {
                    if (com_google_android_gms_internal_zztk222 != null) {
                        i2 += zztd.zzc(5, com_google_android_gms_internal_zztk222);
                    }
                }
                i = i2;
            }
            if (this.zziD != null && this.zziD.length > 0) {
                i2 = i;
                for (zztk com_google_android_gms_internal_zztk2222 : this.zziD) {
                    if (com_google_android_gms_internal_zztk2222 != null) {
                        i2 += zztd.zzc(6, com_google_android_gms_internal_zztk2222);
                    }
                }
                i = i2;
            }
            if (this.zziE != null && this.zziE.length > 0) {
                i2 = i;
                for (zztk com_google_android_gms_internal_zztk22222 : this.zziE) {
                    if (com_google_android_gms_internal_zztk22222 != null) {
                        i2 += zztd.zzc(7, com_google_android_gms_internal_zztk22222);
                    }
                }
                i = i2;
            }
            if (!this.zziF.equals("")) {
                i += zztd.zzp(9, this.zziF);
            }
            if (!this.zziG.equals("")) {
                i += zztd.zzp(10, this.zziG);
            }
            if (!this.zziH.equals("0")) {
                i += zztd.zzp(12, this.zziH);
            }
            if (!this.version.equals("")) {
                i += zztd.zzp(13, this.version);
            }
            if (this.zziI != null) {
                i += zztd.zzc(14, this.zziI);
            }
            if (Float.floatToIntBits(this.zziJ) != Float.floatToIntBits(0.0f)) {
                i += zztd.zzc(15, this.zziJ);
            }
            if (this.zziL != null && this.zziL.length > 0) {
                i3 = 0;
                zzz = 0;
                for (String str2 : this.zziL) {
                    if (str2 != null) {
                        zzz++;
                        i3 += zztd.zzga(str2);
                    }
                }
                i = (i + i3) + (zzz * 2);
            }
            if (this.zziM != 0) {
                i += zztd.zzI(17, this.zziM);
            }
            if (this.zziK) {
                i += zztd.zzc(18, this.zziK);
            }
            if (this.zzix == null || this.zzix.length <= 0) {
                return i;
            }
            i2 = 0;
            i3 = 0;
            while (i4 < this.zzix.length) {
                String str3 = this.zzix[i4];
                if (str3 != null) {
                    i3++;
                    i2 += zztd.zzga(str3);
                }
                i4++;
            }
            return (i + i2) + (i3 * 2);
        }
    }

    public static final class zzg extends zzte<zzg> {
        private static volatile zzg[] zziN;
        public int[] zziO;
        public int[] zziP;
        public int[] zziQ;
        public int[] zziR;
        public int[] zziS;
        public int[] zziT;
        public int[] zziU;
        public int[] zziV;
        public int[] zziW;
        public int[] zziX;

        public zzg() {
            zzL();
        }

        public static zzg[] zzK() {
            if (zziN == null) {
                synchronized (zzti.zzbqa) {
                    if (zziN == null) {
                        zziN = new zzg[0];
                    }
                }
            }
            return zziN;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzg)) {
                return false;
            }
            zzg com_google_android_gms_internal_zzaf_zzg = (zzg) o;
            if (!zzti.equals(this.zziO, com_google_android_gms_internal_zzaf_zzg.zziO) || !zzti.equals(this.zziP, com_google_android_gms_internal_zzaf_zzg.zziP) || !zzti.equals(this.zziQ, com_google_android_gms_internal_zzaf_zzg.zziQ) || !zzti.equals(this.zziR, com_google_android_gms_internal_zzaf_zzg.zziR) || !zzti.equals(this.zziS, com_google_android_gms_internal_zzaf_zzg.zziS) || !zzti.equals(this.zziT, com_google_android_gms_internal_zzaf_zzg.zziT) || !zzti.equals(this.zziU, com_google_android_gms_internal_zzaf_zzg.zziU) || !zzti.equals(this.zziV, com_google_android_gms_internal_zzaf_zzg.zziV) || !zzti.equals(this.zziW, com_google_android_gms_internal_zzaf_zzg.zziW) || !zzti.equals(this.zziX, com_google_android_gms_internal_zzaf_zzg.zziX)) {
                return false;
            }
            if (this.zzbpQ == null || this.zzbpQ.isEmpty()) {
                return com_google_android_gms_internal_zzaf_zzg.zzbpQ == null || com_google_android_gms_internal_zzaf_zzg.zzbpQ.isEmpty();
            } else {
                return this.zzbpQ.equals(com_google_android_gms_internal_zzaf_zzg.zzbpQ);
            }
        }

        public int hashCode() {
            int hashCode = (((((((((((((((((((((getClass().getName().hashCode() + 527) * 31) + zzti.hashCode(this.zziO)) * 31) + zzti.hashCode(this.zziP)) * 31) + zzti.hashCode(this.zziQ)) * 31) + zzti.hashCode(this.zziR)) * 31) + zzti.hashCode(this.zziS)) * 31) + zzti.hashCode(this.zziT)) * 31) + zzti.hashCode(this.zziU)) * 31) + zzti.hashCode(this.zziV)) * 31) + zzti.hashCode(this.zziW)) * 31) + zzti.hashCode(this.zziX)) * 31;
            int hashCode2 = (this.zzbpQ == null || this.zzbpQ.isEmpty()) ? 0 : this.zzbpQ.hashCode();
            return hashCode2 + hashCode;
        }

        public /* synthetic */ zztk mergeFrom(zztc x0) throws IOException {
            return zzg(x0);
        }

        public void writeTo(zztd output) throws IOException {
            int i = 0;
            if (this.zziO != null && this.zziO.length > 0) {
                for (int zzG : this.zziO) {
                    output.zzG(1, zzG);
                }
            }
            if (this.zziP != null && this.zziP.length > 0) {
                for (int zzG2 : this.zziP) {
                    output.zzG(2, zzG2);
                }
            }
            if (this.zziQ != null && this.zziQ.length > 0) {
                for (int zzG22 : this.zziQ) {
                    output.zzG(3, zzG22);
                }
            }
            if (this.zziR != null && this.zziR.length > 0) {
                for (int zzG222 : this.zziR) {
                    output.zzG(4, zzG222);
                }
            }
            if (this.zziS != null && this.zziS.length > 0) {
                for (int zzG2222 : this.zziS) {
                    output.zzG(5, zzG2222);
                }
            }
            if (this.zziT != null && this.zziT.length > 0) {
                for (int zzG22222 : this.zziT) {
                    output.zzG(6, zzG22222);
                }
            }
            if (this.zziU != null && this.zziU.length > 0) {
                for (int zzG222222 : this.zziU) {
                    output.zzG(7, zzG222222);
                }
            }
            if (this.zziV != null && this.zziV.length > 0) {
                for (int zzG2222222 : this.zziV) {
                    output.zzG(8, zzG2222222);
                }
            }
            if (this.zziW != null && this.zziW.length > 0) {
                for (int zzG22222222 : this.zziW) {
                    output.zzG(9, zzG22222222);
                }
            }
            if (this.zziX != null && this.zziX.length > 0) {
                while (i < this.zziX.length) {
                    output.zzG(10, this.zziX[i]);
                    i++;
                }
            }
            super.writeTo(output);
        }

        public zzg zzL() {
            this.zziO = zztn.zzboD;
            this.zziP = zztn.zzboD;
            this.zziQ = zztn.zzboD;
            this.zziR = zztn.zzboD;
            this.zziS = zztn.zzboD;
            this.zziT = zztn.zzboD;
            this.zziU = zztn.zzboD;
            this.zziV = zztn.zzboD;
            this.zziW = zztn.zzboD;
            this.zziX = zztn.zzboD;
            this.zzbpQ = null;
            this.zzbqb = -1;
            return this;
        }

        public zzg zzg(zztc com_google_android_gms_internal_zztc) throws IOException {
            while (true) {
                int zzHi = com_google_android_gms_internal_zztc.zzHi();
                int zzc;
                Object obj;
                int zzmn;
                Object obj2;
                switch (zzHi) {
                    case 0:
                        break;
                    case 8:
                        zzc = zztn.zzc(com_google_android_gms_internal_zztc, 8);
                        zzHi = this.zziO == null ? 0 : this.zziO.length;
                        obj = new int[(zzc + zzHi)];
                        if (zzHi != 0) {
                            System.arraycopy(this.zziO, 0, obj, 0, zzHi);
                        }
                        while (zzHi < obj.length - 1) {
                            obj[zzHi] = com_google_android_gms_internal_zztc.zzHl();
                            com_google_android_gms_internal_zztc.zzHi();
                            zzHi++;
                        }
                        obj[zzHi] = com_google_android_gms_internal_zztc.zzHl();
                        this.zziO = obj;
                        continue;
                    case 10:
                        zzmn = com_google_android_gms_internal_zztc.zzmn(com_google_android_gms_internal_zztc.zzHp());
                        zzc = com_google_android_gms_internal_zztc.getPosition();
                        zzHi = 0;
                        while (com_google_android_gms_internal_zztc.zzHu() > 0) {
                            com_google_android_gms_internal_zztc.zzHl();
                            zzHi++;
                        }
                        com_google_android_gms_internal_zztc.zzmp(zzc);
                        zzc = this.zziO == null ? 0 : this.zziO.length;
                        obj2 = new int[(zzHi + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zziO, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zztc.zzHl();
                            zzc++;
                        }
                        this.zziO = obj2;
                        com_google_android_gms_internal_zztc.zzmo(zzmn);
                        continue;
                    case 16:
                        zzc = zztn.zzc(com_google_android_gms_internal_zztc, 16);
                        zzHi = this.zziP == null ? 0 : this.zziP.length;
                        obj = new int[(zzc + zzHi)];
                        if (zzHi != 0) {
                            System.arraycopy(this.zziP, 0, obj, 0, zzHi);
                        }
                        while (zzHi < obj.length - 1) {
                            obj[zzHi] = com_google_android_gms_internal_zztc.zzHl();
                            com_google_android_gms_internal_zztc.zzHi();
                            zzHi++;
                        }
                        obj[zzHi] = com_google_android_gms_internal_zztc.zzHl();
                        this.zziP = obj;
                        continue;
                    case 18:
                        zzmn = com_google_android_gms_internal_zztc.zzmn(com_google_android_gms_internal_zztc.zzHp());
                        zzc = com_google_android_gms_internal_zztc.getPosition();
                        zzHi = 0;
                        while (com_google_android_gms_internal_zztc.zzHu() > 0) {
                            com_google_android_gms_internal_zztc.zzHl();
                            zzHi++;
                        }
                        com_google_android_gms_internal_zztc.zzmp(zzc);
                        zzc = this.zziP == null ? 0 : this.zziP.length;
                        obj2 = new int[(zzHi + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zziP, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zztc.zzHl();
                            zzc++;
                        }
                        this.zziP = obj2;
                        com_google_android_gms_internal_zztc.zzmo(zzmn);
                        continue;
                    case 24:
                        zzc = zztn.zzc(com_google_android_gms_internal_zztc, 24);
                        zzHi = this.zziQ == null ? 0 : this.zziQ.length;
                        obj = new int[(zzc + zzHi)];
                        if (zzHi != 0) {
                            System.arraycopy(this.zziQ, 0, obj, 0, zzHi);
                        }
                        while (zzHi < obj.length - 1) {
                            obj[zzHi] = com_google_android_gms_internal_zztc.zzHl();
                            com_google_android_gms_internal_zztc.zzHi();
                            zzHi++;
                        }
                        obj[zzHi] = com_google_android_gms_internal_zztc.zzHl();
                        this.zziQ = obj;
                        continue;
                    case 26:
                        zzmn = com_google_android_gms_internal_zztc.zzmn(com_google_android_gms_internal_zztc.zzHp());
                        zzc = com_google_android_gms_internal_zztc.getPosition();
                        zzHi = 0;
                        while (com_google_android_gms_internal_zztc.zzHu() > 0) {
                            com_google_android_gms_internal_zztc.zzHl();
                            zzHi++;
                        }
                        com_google_android_gms_internal_zztc.zzmp(zzc);
                        zzc = this.zziQ == null ? 0 : this.zziQ.length;
                        obj2 = new int[(zzHi + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zziQ, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zztc.zzHl();
                            zzc++;
                        }
                        this.zziQ = obj2;
                        com_google_android_gms_internal_zztc.zzmo(zzmn);
                        continue;
                    case 32:
                        zzc = zztn.zzc(com_google_android_gms_internal_zztc, 32);
                        zzHi = this.zziR == null ? 0 : this.zziR.length;
                        obj = new int[(zzc + zzHi)];
                        if (zzHi != 0) {
                            System.arraycopy(this.zziR, 0, obj, 0, zzHi);
                        }
                        while (zzHi < obj.length - 1) {
                            obj[zzHi] = com_google_android_gms_internal_zztc.zzHl();
                            com_google_android_gms_internal_zztc.zzHi();
                            zzHi++;
                        }
                        obj[zzHi] = com_google_android_gms_internal_zztc.zzHl();
                        this.zziR = obj;
                        continue;
                    case 34:
                        zzmn = com_google_android_gms_internal_zztc.zzmn(com_google_android_gms_internal_zztc.zzHp());
                        zzc = com_google_android_gms_internal_zztc.getPosition();
                        zzHi = 0;
                        while (com_google_android_gms_internal_zztc.zzHu() > 0) {
                            com_google_android_gms_internal_zztc.zzHl();
                            zzHi++;
                        }
                        com_google_android_gms_internal_zztc.zzmp(zzc);
                        zzc = this.zziR == null ? 0 : this.zziR.length;
                        obj2 = new int[(zzHi + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zziR, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zztc.zzHl();
                            zzc++;
                        }
                        this.zziR = obj2;
                        com_google_android_gms_internal_zztc.zzmo(zzmn);
                        continue;
                    case 40:
                        zzc = zztn.zzc(com_google_android_gms_internal_zztc, 40);
                        zzHi = this.zziS == null ? 0 : this.zziS.length;
                        obj = new int[(zzc + zzHi)];
                        if (zzHi != 0) {
                            System.arraycopy(this.zziS, 0, obj, 0, zzHi);
                        }
                        while (zzHi < obj.length - 1) {
                            obj[zzHi] = com_google_android_gms_internal_zztc.zzHl();
                            com_google_android_gms_internal_zztc.zzHi();
                            zzHi++;
                        }
                        obj[zzHi] = com_google_android_gms_internal_zztc.zzHl();
                        this.zziS = obj;
                        continue;
                    case 42:
                        zzmn = com_google_android_gms_internal_zztc.zzmn(com_google_android_gms_internal_zztc.zzHp());
                        zzc = com_google_android_gms_internal_zztc.getPosition();
                        zzHi = 0;
                        while (com_google_android_gms_internal_zztc.zzHu() > 0) {
                            com_google_android_gms_internal_zztc.zzHl();
                            zzHi++;
                        }
                        com_google_android_gms_internal_zztc.zzmp(zzc);
                        zzc = this.zziS == null ? 0 : this.zziS.length;
                        obj2 = new int[(zzHi + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zziS, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zztc.zzHl();
                            zzc++;
                        }
                        this.zziS = obj2;
                        com_google_android_gms_internal_zztc.zzmo(zzmn);
                        continue;
                    case 48:
                        zzc = zztn.zzc(com_google_android_gms_internal_zztc, 48);
                        zzHi = this.zziT == null ? 0 : this.zziT.length;
                        obj = new int[(zzc + zzHi)];
                        if (zzHi != 0) {
                            System.arraycopy(this.zziT, 0, obj, 0, zzHi);
                        }
                        while (zzHi < obj.length - 1) {
                            obj[zzHi] = com_google_android_gms_internal_zztc.zzHl();
                            com_google_android_gms_internal_zztc.zzHi();
                            zzHi++;
                        }
                        obj[zzHi] = com_google_android_gms_internal_zztc.zzHl();
                        this.zziT = obj;
                        continue;
                    case 50:
                        zzmn = com_google_android_gms_internal_zztc.zzmn(com_google_android_gms_internal_zztc.zzHp());
                        zzc = com_google_android_gms_internal_zztc.getPosition();
                        zzHi = 0;
                        while (com_google_android_gms_internal_zztc.zzHu() > 0) {
                            com_google_android_gms_internal_zztc.zzHl();
                            zzHi++;
                        }
                        com_google_android_gms_internal_zztc.zzmp(zzc);
                        zzc = this.zziT == null ? 0 : this.zziT.length;
                        obj2 = new int[(zzHi + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zziT, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zztc.zzHl();
                            zzc++;
                        }
                        this.zziT = obj2;
                        com_google_android_gms_internal_zztc.zzmo(zzmn);
                        continue;
                    case 56:
                        zzc = zztn.zzc(com_google_android_gms_internal_zztc, 56);
                        zzHi = this.zziU == null ? 0 : this.zziU.length;
                        obj = new int[(zzc + zzHi)];
                        if (zzHi != 0) {
                            System.arraycopy(this.zziU, 0, obj, 0, zzHi);
                        }
                        while (zzHi < obj.length - 1) {
                            obj[zzHi] = com_google_android_gms_internal_zztc.zzHl();
                            com_google_android_gms_internal_zztc.zzHi();
                            zzHi++;
                        }
                        obj[zzHi] = com_google_android_gms_internal_zztc.zzHl();
                        this.zziU = obj;
                        continue;
                    case 58:
                        zzmn = com_google_android_gms_internal_zztc.zzmn(com_google_android_gms_internal_zztc.zzHp());
                        zzc = com_google_android_gms_internal_zztc.getPosition();
                        zzHi = 0;
                        while (com_google_android_gms_internal_zztc.zzHu() > 0) {
                            com_google_android_gms_internal_zztc.zzHl();
                            zzHi++;
                        }
                        com_google_android_gms_internal_zztc.zzmp(zzc);
                        zzc = this.zziU == null ? 0 : this.zziU.length;
                        obj2 = new int[(zzHi + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zziU, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zztc.zzHl();
                            zzc++;
                        }
                        this.zziU = obj2;
                        com_google_android_gms_internal_zztc.zzmo(zzmn);
                        continue;
                    case 64:
                        zzc = zztn.zzc(com_google_android_gms_internal_zztc, 64);
                        zzHi = this.zziV == null ? 0 : this.zziV.length;
                        obj = new int[(zzc + zzHi)];
                        if (zzHi != 0) {
                            System.arraycopy(this.zziV, 0, obj, 0, zzHi);
                        }
                        while (zzHi < obj.length - 1) {
                            obj[zzHi] = com_google_android_gms_internal_zztc.zzHl();
                            com_google_android_gms_internal_zztc.zzHi();
                            zzHi++;
                        }
                        obj[zzHi] = com_google_android_gms_internal_zztc.zzHl();
                        this.zziV = obj;
                        continue;
                    case 66:
                        zzmn = com_google_android_gms_internal_zztc.zzmn(com_google_android_gms_internal_zztc.zzHp());
                        zzc = com_google_android_gms_internal_zztc.getPosition();
                        zzHi = 0;
                        while (com_google_android_gms_internal_zztc.zzHu() > 0) {
                            com_google_android_gms_internal_zztc.zzHl();
                            zzHi++;
                        }
                        com_google_android_gms_internal_zztc.zzmp(zzc);
                        zzc = this.zziV == null ? 0 : this.zziV.length;
                        obj2 = new int[(zzHi + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zziV, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zztc.zzHl();
                            zzc++;
                        }
                        this.zziV = obj2;
                        com_google_android_gms_internal_zztc.zzmo(zzmn);
                        continue;
                    case 72:
                        zzc = zztn.zzc(com_google_android_gms_internal_zztc, 72);
                        zzHi = this.zziW == null ? 0 : this.zziW.length;
                        obj = new int[(zzc + zzHi)];
                        if (zzHi != 0) {
                            System.arraycopy(this.zziW, 0, obj, 0, zzHi);
                        }
                        while (zzHi < obj.length - 1) {
                            obj[zzHi] = com_google_android_gms_internal_zztc.zzHl();
                            com_google_android_gms_internal_zztc.zzHi();
                            zzHi++;
                        }
                        obj[zzHi] = com_google_android_gms_internal_zztc.zzHl();
                        this.zziW = obj;
                        continue;
                    case 74:
                        zzmn = com_google_android_gms_internal_zztc.zzmn(com_google_android_gms_internal_zztc.zzHp());
                        zzc = com_google_android_gms_internal_zztc.getPosition();
                        zzHi = 0;
                        while (com_google_android_gms_internal_zztc.zzHu() > 0) {
                            com_google_android_gms_internal_zztc.zzHl();
                            zzHi++;
                        }
                        com_google_android_gms_internal_zztc.zzmp(zzc);
                        zzc = this.zziW == null ? 0 : this.zziW.length;
                        obj2 = new int[(zzHi + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zziW, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zztc.zzHl();
                            zzc++;
                        }
                        this.zziW = obj2;
                        com_google_android_gms_internal_zztc.zzmo(zzmn);
                        continue;
                    case 80:
                        zzc = zztn.zzc(com_google_android_gms_internal_zztc, 80);
                        zzHi = this.zziX == null ? 0 : this.zziX.length;
                        obj = new int[(zzc + zzHi)];
                        if (zzHi != 0) {
                            System.arraycopy(this.zziX, 0, obj, 0, zzHi);
                        }
                        while (zzHi < obj.length - 1) {
                            obj[zzHi] = com_google_android_gms_internal_zztc.zzHl();
                            com_google_android_gms_internal_zztc.zzHi();
                            zzHi++;
                        }
                        obj[zzHi] = com_google_android_gms_internal_zztc.zzHl();
                        this.zziX = obj;
                        continue;
                    case 82:
                        zzmn = com_google_android_gms_internal_zztc.zzmn(com_google_android_gms_internal_zztc.zzHp());
                        zzc = com_google_android_gms_internal_zztc.getPosition();
                        zzHi = 0;
                        while (com_google_android_gms_internal_zztc.zzHu() > 0) {
                            com_google_android_gms_internal_zztc.zzHl();
                            zzHi++;
                        }
                        com_google_android_gms_internal_zztc.zzmp(zzc);
                        zzc = this.zziX == null ? 0 : this.zziX.length;
                        obj2 = new int[(zzHi + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zziX, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zztc.zzHl();
                            zzc++;
                        }
                        this.zziX = obj2;
                        com_google_android_gms_internal_zztc.zzmo(zzmn);
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
            int i2;
            int i3 = 0;
            int zzz = super.zzz();
            if (this.zziO == null || this.zziO.length <= 0) {
                i = zzz;
            } else {
                i2 = 0;
                for (int zzmu : this.zziO) {
                    i2 += zztd.zzmu(zzmu);
                }
                i = (zzz + i2) + (this.zziO.length * 1);
            }
            if (this.zziP != null && this.zziP.length > 0) {
                zzz = 0;
                for (int zzmu2 : this.zziP) {
                    zzz += zztd.zzmu(zzmu2);
                }
                i = (i + zzz) + (this.zziP.length * 1);
            }
            if (this.zziQ != null && this.zziQ.length > 0) {
                zzz = 0;
                for (int zzmu22 : this.zziQ) {
                    zzz += zztd.zzmu(zzmu22);
                }
                i = (i + zzz) + (this.zziQ.length * 1);
            }
            if (this.zziR != null && this.zziR.length > 0) {
                zzz = 0;
                for (int zzmu222 : this.zziR) {
                    zzz += zztd.zzmu(zzmu222);
                }
                i = (i + zzz) + (this.zziR.length * 1);
            }
            if (this.zziS != null && this.zziS.length > 0) {
                zzz = 0;
                for (int zzmu2222 : this.zziS) {
                    zzz += zztd.zzmu(zzmu2222);
                }
                i = (i + zzz) + (this.zziS.length * 1);
            }
            if (this.zziT != null && this.zziT.length > 0) {
                zzz = 0;
                for (int zzmu22222 : this.zziT) {
                    zzz += zztd.zzmu(zzmu22222);
                }
                i = (i + zzz) + (this.zziT.length * 1);
            }
            if (this.zziU != null && this.zziU.length > 0) {
                zzz = 0;
                for (int zzmu222222 : this.zziU) {
                    zzz += zztd.zzmu(zzmu222222);
                }
                i = (i + zzz) + (this.zziU.length * 1);
            }
            if (this.zziV != null && this.zziV.length > 0) {
                zzz = 0;
                for (int zzmu2222222 : this.zziV) {
                    zzz += zztd.zzmu(zzmu2222222);
                }
                i = (i + zzz) + (this.zziV.length * 1);
            }
            if (this.zziW != null && this.zziW.length > 0) {
                zzz = 0;
                for (int zzmu22222222 : this.zziW) {
                    zzz += zztd.zzmu(zzmu22222222);
                }
                i = (i + zzz) + (this.zziW.length * 1);
            }
            if (this.zziX == null || this.zziX.length <= 0) {
                return i;
            }
            i2 = 0;
            while (i3 < this.zziX.length) {
                i2 += zztd.zzmu(this.zziX[i3]);
                i3++;
            }
            return (i + i2) + (this.zziX.length * 1);
        }
    }

    public static final class zzh extends zzte<zzh> {
        public static final zztf<com.google.android.gms.internal.zzag.zza, zzh> zziY = zztf.zza(11, zzh.class, 810);
        private static final zzh[] zziZ = new zzh[0];
        public int[] zzja;
        public int[] zzjb;
        public int[] zzjc;
        public int zzjd;
        public int[] zzje;
        public int zzjf;
        public int zzjg;

        public zzh() {
            zzM();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzh)) {
                return false;
            }
            zzh com_google_android_gms_internal_zzaf_zzh = (zzh) o;
            if (!zzti.equals(this.zzja, com_google_android_gms_internal_zzaf_zzh.zzja) || !zzti.equals(this.zzjb, com_google_android_gms_internal_zzaf_zzh.zzjb) || !zzti.equals(this.zzjc, com_google_android_gms_internal_zzaf_zzh.zzjc) || this.zzjd != com_google_android_gms_internal_zzaf_zzh.zzjd || !zzti.equals(this.zzje, com_google_android_gms_internal_zzaf_zzh.zzje) || this.zzjf != com_google_android_gms_internal_zzaf_zzh.zzjf || this.zzjg != com_google_android_gms_internal_zzaf_zzh.zzjg) {
                return false;
            }
            if (this.zzbpQ == null || this.zzbpQ.isEmpty()) {
                return com_google_android_gms_internal_zzaf_zzh.zzbpQ == null || com_google_android_gms_internal_zzaf_zzh.zzbpQ.isEmpty();
            } else {
                return this.zzbpQ.equals(com_google_android_gms_internal_zzaf_zzh.zzbpQ);
            }
        }

        public int hashCode() {
            int hashCode = (((((((((((((((getClass().getName().hashCode() + 527) * 31) + zzti.hashCode(this.zzja)) * 31) + zzti.hashCode(this.zzjb)) * 31) + zzti.hashCode(this.zzjc)) * 31) + this.zzjd) * 31) + zzti.hashCode(this.zzje)) * 31) + this.zzjf) * 31) + this.zzjg) * 31;
            int hashCode2 = (this.zzbpQ == null || this.zzbpQ.isEmpty()) ? 0 : this.zzbpQ.hashCode();
            return hashCode2 + hashCode;
        }

        public /* synthetic */ zztk mergeFrom(zztc x0) throws IOException {
            return zzh(x0);
        }

        public void writeTo(zztd output) throws IOException {
            int i = 0;
            if (this.zzja != null && this.zzja.length > 0) {
                for (int zzG : this.zzja) {
                    output.zzG(1, zzG);
                }
            }
            if (this.zzjb != null && this.zzjb.length > 0) {
                for (int zzG2 : this.zzjb) {
                    output.zzG(2, zzG2);
                }
            }
            if (this.zzjc != null && this.zzjc.length > 0) {
                for (int zzG22 : this.zzjc) {
                    output.zzG(3, zzG22);
                }
            }
            if (this.zzjd != 0) {
                output.zzG(4, this.zzjd);
            }
            if (this.zzje != null && this.zzje.length > 0) {
                while (i < this.zzje.length) {
                    output.zzG(5, this.zzje[i]);
                    i++;
                }
            }
            if (this.zzjf != 0) {
                output.zzG(6, this.zzjf);
            }
            if (this.zzjg != 0) {
                output.zzG(7, this.zzjg);
            }
            super.writeTo(output);
        }

        public zzh zzM() {
            this.zzja = zztn.zzboD;
            this.zzjb = zztn.zzboD;
            this.zzjc = zztn.zzboD;
            this.zzjd = 0;
            this.zzje = zztn.zzboD;
            this.zzjf = 0;
            this.zzjg = 0;
            this.zzbpQ = null;
            this.zzbqb = -1;
            return this;
        }

        public zzh zzh(zztc com_google_android_gms_internal_zztc) throws IOException {
            while (true) {
                int zzHi = com_google_android_gms_internal_zztc.zzHi();
                int zzc;
                Object obj;
                int zzmn;
                Object obj2;
                switch (zzHi) {
                    case 0:
                        break;
                    case 8:
                        zzc = zztn.zzc(com_google_android_gms_internal_zztc, 8);
                        zzHi = this.zzja == null ? 0 : this.zzja.length;
                        obj = new int[(zzc + zzHi)];
                        if (zzHi != 0) {
                            System.arraycopy(this.zzja, 0, obj, 0, zzHi);
                        }
                        while (zzHi < obj.length - 1) {
                            obj[zzHi] = com_google_android_gms_internal_zztc.zzHl();
                            com_google_android_gms_internal_zztc.zzHi();
                            zzHi++;
                        }
                        obj[zzHi] = com_google_android_gms_internal_zztc.zzHl();
                        this.zzja = obj;
                        continue;
                    case 10:
                        zzmn = com_google_android_gms_internal_zztc.zzmn(com_google_android_gms_internal_zztc.zzHp());
                        zzc = com_google_android_gms_internal_zztc.getPosition();
                        zzHi = 0;
                        while (com_google_android_gms_internal_zztc.zzHu() > 0) {
                            com_google_android_gms_internal_zztc.zzHl();
                            zzHi++;
                        }
                        com_google_android_gms_internal_zztc.zzmp(zzc);
                        zzc = this.zzja == null ? 0 : this.zzja.length;
                        obj2 = new int[(zzHi + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzja, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zztc.zzHl();
                            zzc++;
                        }
                        this.zzja = obj2;
                        com_google_android_gms_internal_zztc.zzmo(zzmn);
                        continue;
                    case 16:
                        zzc = zztn.zzc(com_google_android_gms_internal_zztc, 16);
                        zzHi = this.zzjb == null ? 0 : this.zzjb.length;
                        obj = new int[(zzc + zzHi)];
                        if (zzHi != 0) {
                            System.arraycopy(this.zzjb, 0, obj, 0, zzHi);
                        }
                        while (zzHi < obj.length - 1) {
                            obj[zzHi] = com_google_android_gms_internal_zztc.zzHl();
                            com_google_android_gms_internal_zztc.zzHi();
                            zzHi++;
                        }
                        obj[zzHi] = com_google_android_gms_internal_zztc.zzHl();
                        this.zzjb = obj;
                        continue;
                    case 18:
                        zzmn = com_google_android_gms_internal_zztc.zzmn(com_google_android_gms_internal_zztc.zzHp());
                        zzc = com_google_android_gms_internal_zztc.getPosition();
                        zzHi = 0;
                        while (com_google_android_gms_internal_zztc.zzHu() > 0) {
                            com_google_android_gms_internal_zztc.zzHl();
                            zzHi++;
                        }
                        com_google_android_gms_internal_zztc.zzmp(zzc);
                        zzc = this.zzjb == null ? 0 : this.zzjb.length;
                        obj2 = new int[(zzHi + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzjb, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zztc.zzHl();
                            zzc++;
                        }
                        this.zzjb = obj2;
                        com_google_android_gms_internal_zztc.zzmo(zzmn);
                        continue;
                    case 24:
                        zzc = zztn.zzc(com_google_android_gms_internal_zztc, 24);
                        zzHi = this.zzjc == null ? 0 : this.zzjc.length;
                        obj = new int[(zzc + zzHi)];
                        if (zzHi != 0) {
                            System.arraycopy(this.zzjc, 0, obj, 0, zzHi);
                        }
                        while (zzHi < obj.length - 1) {
                            obj[zzHi] = com_google_android_gms_internal_zztc.zzHl();
                            com_google_android_gms_internal_zztc.zzHi();
                            zzHi++;
                        }
                        obj[zzHi] = com_google_android_gms_internal_zztc.zzHl();
                        this.zzjc = obj;
                        continue;
                    case 26:
                        zzmn = com_google_android_gms_internal_zztc.zzmn(com_google_android_gms_internal_zztc.zzHp());
                        zzc = com_google_android_gms_internal_zztc.getPosition();
                        zzHi = 0;
                        while (com_google_android_gms_internal_zztc.zzHu() > 0) {
                            com_google_android_gms_internal_zztc.zzHl();
                            zzHi++;
                        }
                        com_google_android_gms_internal_zztc.zzmp(zzc);
                        zzc = this.zzjc == null ? 0 : this.zzjc.length;
                        obj2 = new int[(zzHi + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzjc, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zztc.zzHl();
                            zzc++;
                        }
                        this.zzjc = obj2;
                        com_google_android_gms_internal_zztc.zzmo(zzmn);
                        continue;
                    case 32:
                        this.zzjd = com_google_android_gms_internal_zztc.zzHl();
                        continue;
                    case 40:
                        zzc = zztn.zzc(com_google_android_gms_internal_zztc, 40);
                        zzHi = this.zzje == null ? 0 : this.zzje.length;
                        obj = new int[(zzc + zzHi)];
                        if (zzHi != 0) {
                            System.arraycopy(this.zzje, 0, obj, 0, zzHi);
                        }
                        while (zzHi < obj.length - 1) {
                            obj[zzHi] = com_google_android_gms_internal_zztc.zzHl();
                            com_google_android_gms_internal_zztc.zzHi();
                            zzHi++;
                        }
                        obj[zzHi] = com_google_android_gms_internal_zztc.zzHl();
                        this.zzje = obj;
                        continue;
                    case 42:
                        zzmn = com_google_android_gms_internal_zztc.zzmn(com_google_android_gms_internal_zztc.zzHp());
                        zzc = com_google_android_gms_internal_zztc.getPosition();
                        zzHi = 0;
                        while (com_google_android_gms_internal_zztc.zzHu() > 0) {
                            com_google_android_gms_internal_zztc.zzHl();
                            zzHi++;
                        }
                        com_google_android_gms_internal_zztc.zzmp(zzc);
                        zzc = this.zzje == null ? 0 : this.zzje.length;
                        obj2 = new int[(zzHi + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzje, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zztc.zzHl();
                            zzc++;
                        }
                        this.zzje = obj2;
                        com_google_android_gms_internal_zztc.zzmo(zzmn);
                        continue;
                    case 48:
                        this.zzjf = com_google_android_gms_internal_zztc.zzHl();
                        continue;
                    case 56:
                        this.zzjg = com_google_android_gms_internal_zztc.zzHl();
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
            int i2;
            int i3 = 0;
            int zzz = super.zzz();
            if (this.zzja == null || this.zzja.length <= 0) {
                i = zzz;
            } else {
                i2 = 0;
                for (int zzmu : this.zzja) {
                    i2 += zztd.zzmu(zzmu);
                }
                i = (zzz + i2) + (this.zzja.length * 1);
            }
            if (this.zzjb != null && this.zzjb.length > 0) {
                zzz = 0;
                for (int zzmu2 : this.zzjb) {
                    zzz += zztd.zzmu(zzmu2);
                }
                i = (i + zzz) + (this.zzjb.length * 1);
            }
            if (this.zzjc != null && this.zzjc.length > 0) {
                zzz = 0;
                for (int zzmu22 : this.zzjc) {
                    zzz += zztd.zzmu(zzmu22);
                }
                i = (i + zzz) + (this.zzjc.length * 1);
            }
            if (this.zzjd != 0) {
                i += zztd.zzI(4, this.zzjd);
            }
            if (this.zzje != null && this.zzje.length > 0) {
                i2 = 0;
                while (i3 < this.zzje.length) {
                    i2 += zztd.zzmu(this.zzje[i3]);
                    i3++;
                }
                i = (i + i2) + (this.zzje.length * 1);
            }
            if (this.zzjf != 0) {
                i += zztd.zzI(6, this.zzjf);
            }
            return this.zzjg != 0 ? i + zztd.zzI(7, this.zzjg) : i;
        }
    }

    public static final class zzi extends zzte<zzi> {
        private static volatile zzi[] zzjh;
        public String name;
        public com.google.android.gms.internal.zzag.zza zzji;
        public zzd zzjj;

        public zzi() {
            zzO();
        }

        public static zzi[] zzN() {
            if (zzjh == null) {
                synchronized (zzti.zzbqa) {
                    if (zzjh == null) {
                        zzjh = new zzi[0];
                    }
                }
            }
            return zzjh;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzi)) {
                return false;
            }
            zzi com_google_android_gms_internal_zzaf_zzi = (zzi) o;
            if (this.name == null) {
                if (com_google_android_gms_internal_zzaf_zzi.name != null) {
                    return false;
                }
            } else if (!this.name.equals(com_google_android_gms_internal_zzaf_zzi.name)) {
                return false;
            }
            if (this.zzji == null) {
                if (com_google_android_gms_internal_zzaf_zzi.zzji != null) {
                    return false;
                }
            } else if (!this.zzji.equals(com_google_android_gms_internal_zzaf_zzi.zzji)) {
                return false;
            }
            if (this.zzjj == null) {
                if (com_google_android_gms_internal_zzaf_zzi.zzjj != null) {
                    return false;
                }
            } else if (!this.zzjj.equals(com_google_android_gms_internal_zzaf_zzi.zzjj)) {
                return false;
            }
            if (this.zzbpQ == null || this.zzbpQ.isEmpty()) {
                return com_google_android_gms_internal_zzaf_zzi.zzbpQ == null || com_google_android_gms_internal_zzaf_zzi.zzbpQ.isEmpty();
            } else {
                return this.zzbpQ.equals(com_google_android_gms_internal_zzaf_zzi.zzbpQ);
            }
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzjj == null ? 0 : this.zzjj.hashCode()) + (((this.zzji == null ? 0 : this.zzji.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31;
            if (!(this.zzbpQ == null || this.zzbpQ.isEmpty())) {
                i = this.zzbpQ.hashCode();
            }
            return hashCode + i;
        }

        public /* synthetic */ zztk mergeFrom(zztc x0) throws IOException {
            return zzi(x0);
        }

        public void writeTo(zztd output) throws IOException {
            if (!this.name.equals("")) {
                output.zzb(1, this.name);
            }
            if (this.zzji != null) {
                output.zza(2, this.zzji);
            }
            if (this.zzjj != null) {
                output.zza(3, this.zzjj);
            }
            super.writeTo(output);
        }

        public zzi zzO() {
            this.name = "";
            this.zzji = null;
            this.zzjj = null;
            this.zzbpQ = null;
            this.zzbqb = -1;
            return this;
        }

        public zzi zzi(zztc com_google_android_gms_internal_zztc) throws IOException {
            while (true) {
                int zzHi = com_google_android_gms_internal_zztc.zzHi();
                switch (zzHi) {
                    case 0:
                        break;
                    case 10:
                        this.name = com_google_android_gms_internal_zztc.readString();
                        continue;
                    case 18:
                        if (this.zzji == null) {
                            this.zzji = new com.google.android.gms.internal.zzag.zza();
                        }
                        com_google_android_gms_internal_zztc.zza(this.zzji);
                        continue;
                    case 26:
                        if (this.zzjj == null) {
                            this.zzjj = new zzd();
                        }
                        com_google_android_gms_internal_zztc.zza(this.zzjj);
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
            int zzz = super.zzz();
            if (!this.name.equals("")) {
                zzz += zztd.zzp(1, this.name);
            }
            if (this.zzji != null) {
                zzz += zztd.zzc(2, this.zzji);
            }
            return this.zzjj != null ? zzz + zztd.zzc(3, this.zzjj) : zzz;
        }
    }

    public static final class zzj extends zzte<zzj> {
        public zzi[] zzjk;
        public zzf zzjl;
        public String zzjm;

        public zzj() {
            zzP();
        }

        public static zzj zzd(byte[] bArr) throws zztj {
            return (zzj) zztk.mergeFrom(new zzj(), bArr);
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzj)) {
                return false;
            }
            zzj com_google_android_gms_internal_zzaf_zzj = (zzj) o;
            if (!zzti.equals(this.zzjk, com_google_android_gms_internal_zzaf_zzj.zzjk)) {
                return false;
            }
            if (this.zzjl == null) {
                if (com_google_android_gms_internal_zzaf_zzj.zzjl != null) {
                    return false;
                }
            } else if (!this.zzjl.equals(com_google_android_gms_internal_zzaf_zzj.zzjl)) {
                return false;
            }
            if (this.zzjm == null) {
                if (com_google_android_gms_internal_zzaf_zzj.zzjm != null) {
                    return false;
                }
            } else if (!this.zzjm.equals(com_google_android_gms_internal_zzaf_zzj.zzjm)) {
                return false;
            }
            if (this.zzbpQ == null || this.zzbpQ.isEmpty()) {
                return com_google_android_gms_internal_zzaf_zzj.zzbpQ == null || com_google_android_gms_internal_zzaf_zzj.zzbpQ.isEmpty();
            } else {
                return this.zzbpQ.equals(com_google_android_gms_internal_zzaf_zzj.zzbpQ);
            }
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzjm == null ? 0 : this.zzjm.hashCode()) + (((this.zzjl == null ? 0 : this.zzjl.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + zzti.hashCode(this.zzjk)) * 31)) * 31)) * 31;
            if (!(this.zzbpQ == null || this.zzbpQ.isEmpty())) {
                i = this.zzbpQ.hashCode();
            }
            return hashCode + i;
        }

        public /* synthetic */ zztk mergeFrom(zztc x0) throws IOException {
            return zzj(x0);
        }

        public void writeTo(zztd output) throws IOException {
            if (this.zzjk != null && this.zzjk.length > 0) {
                for (zztk com_google_android_gms_internal_zztk : this.zzjk) {
                    if (com_google_android_gms_internal_zztk != null) {
                        output.zza(1, com_google_android_gms_internal_zztk);
                    }
                }
            }
            if (this.zzjl != null) {
                output.zza(2, this.zzjl);
            }
            if (!this.zzjm.equals("")) {
                output.zzb(3, this.zzjm);
            }
            super.writeTo(output);
        }

        public zzj zzP() {
            this.zzjk = zzi.zzN();
            this.zzjl = null;
            this.zzjm = "";
            this.zzbpQ = null;
            this.zzbqb = -1;
            return this;
        }

        public zzj zzj(zztc com_google_android_gms_internal_zztc) throws IOException {
            while (true) {
                int zzHi = com_google_android_gms_internal_zztc.zzHi();
                switch (zzHi) {
                    case 0:
                        break;
                    case 10:
                        int zzc = zztn.zzc(com_google_android_gms_internal_zztc, 10);
                        zzHi = this.zzjk == null ? 0 : this.zzjk.length;
                        Object obj = new zzi[(zzc + zzHi)];
                        if (zzHi != 0) {
                            System.arraycopy(this.zzjk, 0, obj, 0, zzHi);
                        }
                        while (zzHi < obj.length - 1) {
                            obj[zzHi] = new zzi();
                            com_google_android_gms_internal_zztc.zza(obj[zzHi]);
                            com_google_android_gms_internal_zztc.zzHi();
                            zzHi++;
                        }
                        obj[zzHi] = new zzi();
                        com_google_android_gms_internal_zztc.zza(obj[zzHi]);
                        this.zzjk = obj;
                        continue;
                    case 18:
                        if (this.zzjl == null) {
                            this.zzjl = new zzf();
                        }
                        com_google_android_gms_internal_zztc.zza(this.zzjl);
                        continue;
                    case 26:
                        this.zzjm = com_google_android_gms_internal_zztc.readString();
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
            int zzz = super.zzz();
            if (this.zzjk != null && this.zzjk.length > 0) {
                for (zztk com_google_android_gms_internal_zztk : this.zzjk) {
                    if (com_google_android_gms_internal_zztk != null) {
                        zzz += zztd.zzc(1, com_google_android_gms_internal_zztk);
                    }
                }
            }
            if (this.zzjl != null) {
                zzz += zztd.zzc(2, this.zzjl);
            }
            return !this.zzjm.equals("") ? zzz + zztd.zzp(3, this.zzjm) : zzz;
        }
    }
}
