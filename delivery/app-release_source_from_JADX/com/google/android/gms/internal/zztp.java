package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import com.google.android.gms.location.places.Place;
import java.io.IOException;
import java.util.Arrays;

public interface zztp {

    public static final class zza extends zzte<zza> {
        public String[] zzbqn;
        public String[] zzbqo;
        public int[] zzbqp;
        public long[] zzbqq;

        public zza() {
            zzHM();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zztp_zza = (zza) o;
            if (!zzti.equals(this.zzbqn, com_google_android_gms_internal_zztp_zza.zzbqn) || !zzti.equals(this.zzbqo, com_google_android_gms_internal_zztp_zza.zzbqo) || !zzti.equals(this.zzbqp, com_google_android_gms_internal_zztp_zza.zzbqp) || !zzti.equals(this.zzbqq, com_google_android_gms_internal_zztp_zza.zzbqq)) {
                return false;
            }
            if (this.zzbpQ == null || this.zzbpQ.isEmpty()) {
                return com_google_android_gms_internal_zztp_zza.zzbpQ == null || com_google_android_gms_internal_zztp_zza.zzbpQ.isEmpty();
            } else {
                return this.zzbpQ.equals(com_google_android_gms_internal_zztp_zza.zzbpQ);
            }
        }

        public int hashCode() {
            int hashCode = (((((((((getClass().getName().hashCode() + 527) * 31) + zzti.hashCode(this.zzbqn)) * 31) + zzti.hashCode(this.zzbqo)) * 31) + zzti.hashCode(this.zzbqp)) * 31) + zzti.hashCode(this.zzbqq)) * 31;
            int hashCode2 = (this.zzbpQ == null || this.zzbpQ.isEmpty()) ? 0 : this.zzbpQ.hashCode();
            return hashCode2 + hashCode;
        }

        public /* synthetic */ zztk mergeFrom(zztc x0) throws IOException {
            return zzH(x0);
        }

        public void writeTo(zztd output) throws IOException {
            int i = 0;
            if (this.zzbqn != null && this.zzbqn.length > 0) {
                for (String str : this.zzbqn) {
                    if (str != null) {
                        output.zzb(1, str);
                    }
                }
            }
            if (this.zzbqo != null && this.zzbqo.length > 0) {
                for (String str2 : this.zzbqo) {
                    if (str2 != null) {
                        output.zzb(2, str2);
                    }
                }
            }
            if (this.zzbqp != null && this.zzbqp.length > 0) {
                for (int zzG : this.zzbqp) {
                    output.zzG(3, zzG);
                }
            }
            if (this.zzbqq != null && this.zzbqq.length > 0) {
                while (i < this.zzbqq.length) {
                    output.zzb(4, this.zzbqq[i]);
                    i++;
                }
            }
            super.writeTo(output);
        }

        public zza zzH(zztc com_google_android_gms_internal_zztc) throws IOException {
            while (true) {
                int zzHi = com_google_android_gms_internal_zztc.zzHi();
                int zzc;
                Object obj;
                int zzmn;
                Object obj2;
                switch (zzHi) {
                    case 0:
                        break;
                    case 10:
                        zzc = zztn.zzc(com_google_android_gms_internal_zztc, 10);
                        zzHi = this.zzbqn == null ? 0 : this.zzbqn.length;
                        obj = new String[(zzc + zzHi)];
                        if (zzHi != 0) {
                            System.arraycopy(this.zzbqn, 0, obj, 0, zzHi);
                        }
                        while (zzHi < obj.length - 1) {
                            obj[zzHi] = com_google_android_gms_internal_zztc.readString();
                            com_google_android_gms_internal_zztc.zzHi();
                            zzHi++;
                        }
                        obj[zzHi] = com_google_android_gms_internal_zztc.readString();
                        this.zzbqn = obj;
                        continue;
                    case 18:
                        zzc = zztn.zzc(com_google_android_gms_internal_zztc, 18);
                        zzHi = this.zzbqo == null ? 0 : this.zzbqo.length;
                        obj = new String[(zzc + zzHi)];
                        if (zzHi != 0) {
                            System.arraycopy(this.zzbqo, 0, obj, 0, zzHi);
                        }
                        while (zzHi < obj.length - 1) {
                            obj[zzHi] = com_google_android_gms_internal_zztc.readString();
                            com_google_android_gms_internal_zztc.zzHi();
                            zzHi++;
                        }
                        obj[zzHi] = com_google_android_gms_internal_zztc.readString();
                        this.zzbqo = obj;
                        continue;
                    case 24:
                        zzc = zztn.zzc(com_google_android_gms_internal_zztc, 24);
                        zzHi = this.zzbqp == null ? 0 : this.zzbqp.length;
                        obj = new int[(zzc + zzHi)];
                        if (zzHi != 0) {
                            System.arraycopy(this.zzbqp, 0, obj, 0, zzHi);
                        }
                        while (zzHi < obj.length - 1) {
                            obj[zzHi] = com_google_android_gms_internal_zztc.zzHl();
                            com_google_android_gms_internal_zztc.zzHi();
                            zzHi++;
                        }
                        obj[zzHi] = com_google_android_gms_internal_zztc.zzHl();
                        this.zzbqp = obj;
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
                        zzc = this.zzbqp == null ? 0 : this.zzbqp.length;
                        obj2 = new int[(zzHi + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzbqp, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zztc.zzHl();
                            zzc++;
                        }
                        this.zzbqp = obj2;
                        com_google_android_gms_internal_zztc.zzmo(zzmn);
                        continue;
                    case 32:
                        zzc = zztn.zzc(com_google_android_gms_internal_zztc, 32);
                        zzHi = this.zzbqq == null ? 0 : this.zzbqq.length;
                        obj = new long[(zzc + zzHi)];
                        if (zzHi != 0) {
                            System.arraycopy(this.zzbqq, 0, obj, 0, zzHi);
                        }
                        while (zzHi < obj.length - 1) {
                            obj[zzHi] = com_google_android_gms_internal_zztc.zzHk();
                            com_google_android_gms_internal_zztc.zzHi();
                            zzHi++;
                        }
                        obj[zzHi] = com_google_android_gms_internal_zztc.zzHk();
                        this.zzbqq = obj;
                        continue;
                    case 34:
                        zzmn = com_google_android_gms_internal_zztc.zzmn(com_google_android_gms_internal_zztc.zzHp());
                        zzc = com_google_android_gms_internal_zztc.getPosition();
                        zzHi = 0;
                        while (com_google_android_gms_internal_zztc.zzHu() > 0) {
                            com_google_android_gms_internal_zztc.zzHk();
                            zzHi++;
                        }
                        com_google_android_gms_internal_zztc.zzmp(zzc);
                        zzc = this.zzbqq == null ? 0 : this.zzbqq.length;
                        obj2 = new long[(zzHi + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzbqq, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zztc.zzHk();
                            zzc++;
                        }
                        this.zzbqq = obj2;
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

        public zza zzHM() {
            this.zzbqn = zztn.zzbqg;
            this.zzbqo = zztn.zzbqg;
            this.zzbqp = zztn.zzboD;
            this.zzbqq = zztn.zzboC;
            this.zzbpQ = null;
            this.zzbqb = -1;
            return this;
        }

        protected int zzz() {
            int i;
            int i2;
            int i3;
            int i4 = 0;
            int zzz = super.zzz();
            if (this.zzbqn == null || this.zzbqn.length <= 0) {
                i = zzz;
            } else {
                i2 = 0;
                i3 = 0;
                for (String str : this.zzbqn) {
                    if (str != null) {
                        i3++;
                        i2 += zztd.zzga(str);
                    }
                }
                i = (zzz + i2) + (i3 * 1);
            }
            if (this.zzbqo != null && this.zzbqo.length > 0) {
                i3 = 0;
                zzz = 0;
                for (String str2 : this.zzbqo) {
                    if (str2 != null) {
                        zzz++;
                        i3 += zztd.zzga(str2);
                    }
                }
                i = (i + i3) + (zzz * 1);
            }
            if (this.zzbqp != null && this.zzbqp.length > 0) {
                i3 = 0;
                for (int zzz2 : this.zzbqp) {
                    i3 += zztd.zzmu(zzz2);
                }
                i = (i + i3) + (this.zzbqp.length * 1);
            }
            if (this.zzbqq == null || this.zzbqq.length <= 0) {
                return i;
            }
            i2 = 0;
            while (i4 < this.zzbqq.length) {
                i2 += zztd.zzad(this.zzbqq[i4]);
                i4++;
            }
            return (i + i2) + (this.zzbqq.length * 1);
        }
    }

    public static final class zzb extends zzte<zzb> {
        public String version;
        public int zzbqr;
        public String zzbqs;

        public zzb() {
            zzHN();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzb)) {
                return false;
            }
            zzb com_google_android_gms_internal_zztp_zzb = (zzb) o;
            if (this.zzbqr != com_google_android_gms_internal_zztp_zzb.zzbqr) {
                return false;
            }
            if (this.zzbqs == null) {
                if (com_google_android_gms_internal_zztp_zzb.zzbqs != null) {
                    return false;
                }
            } else if (!this.zzbqs.equals(com_google_android_gms_internal_zztp_zzb.zzbqs)) {
                return false;
            }
            if (this.version == null) {
                if (com_google_android_gms_internal_zztp_zzb.version != null) {
                    return false;
                }
            } else if (!this.version.equals(com_google_android_gms_internal_zztp_zzb.version)) {
                return false;
            }
            if (this.zzbpQ == null || this.zzbpQ.isEmpty()) {
                return com_google_android_gms_internal_zztp_zzb.zzbpQ == null || com_google_android_gms_internal_zztp_zzb.zzbpQ.isEmpty();
            } else {
                return this.zzbpQ.equals(com_google_android_gms_internal_zztp_zzb.zzbpQ);
            }
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.version == null ? 0 : this.version.hashCode()) + (((this.zzbqs == null ? 0 : this.zzbqs.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + this.zzbqr) * 31)) * 31)) * 31;
            if (!(this.zzbpQ == null || this.zzbpQ.isEmpty())) {
                i = this.zzbpQ.hashCode();
            }
            return hashCode + i;
        }

        public /* synthetic */ zztk mergeFrom(zztc x0) throws IOException {
            return zzI(x0);
        }

        public void writeTo(zztd output) throws IOException {
            if (this.zzbqr != 0) {
                output.zzG(1, this.zzbqr);
            }
            if (!this.zzbqs.equals("")) {
                output.zzb(2, this.zzbqs);
            }
            if (!this.version.equals("")) {
                output.zzb(3, this.version);
            }
            super.writeTo(output);
        }

        public zzb zzHN() {
            this.zzbqr = 0;
            this.zzbqs = "";
            this.version = "";
            this.zzbpQ = null;
            this.zzbqb = -1;
            return this;
        }

        public zzb zzI(zztc com_google_android_gms_internal_zztc) throws IOException {
            while (true) {
                int zzHi = com_google_android_gms_internal_zztc.zzHi();
                switch (zzHi) {
                    case 0:
                        break;
                    case 8:
                        zzHi = com_google_android_gms_internal_zztc.zzHl();
                        switch (zzHi) {
                            case 0:
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
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                                this.zzbqr = zzHi;
                                break;
                            default:
                                continue;
                        }
                    case 18:
                        this.zzbqs = com_google_android_gms_internal_zztc.readString();
                        continue;
                    case 26:
                        this.version = com_google_android_gms_internal_zztc.readString();
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
            if (this.zzbqr != 0) {
                zzz += zztd.zzI(1, this.zzbqr);
            }
            if (!this.zzbqs.equals("")) {
                zzz += zztd.zzp(2, this.zzbqs);
            }
            return !this.version.equals("") ? zzz + zztd.zzp(3, this.version) : zzz;
        }
    }

    public static final class zzc extends zzte<zzc> {
        public byte[] zzbqt;
        public byte[][] zzbqu;
        public boolean zzbqv;

        public zzc() {
            zzHO();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzc)) {
                return false;
            }
            zzc com_google_android_gms_internal_zztp_zzc = (zzc) o;
            if (!Arrays.equals(this.zzbqt, com_google_android_gms_internal_zztp_zzc.zzbqt) || !zzti.zza(this.zzbqu, com_google_android_gms_internal_zztp_zzc.zzbqu) || this.zzbqv != com_google_android_gms_internal_zztp_zzc.zzbqv) {
                return false;
            }
            if (this.zzbpQ == null || this.zzbpQ.isEmpty()) {
                return com_google_android_gms_internal_zztp_zzc.zzbpQ == null || com_google_android_gms_internal_zztp_zzc.zzbpQ.isEmpty();
            } else {
                return this.zzbpQ.equals(com_google_android_gms_internal_zztp_zzc.zzbpQ);
            }
        }

        public int hashCode() {
            int hashCode = ((this.zzbqv ? 1231 : 1237) + ((((((getClass().getName().hashCode() + 527) * 31) + Arrays.hashCode(this.zzbqt)) * 31) + zzti.zza(this.zzbqu)) * 31)) * 31;
            int hashCode2 = (this.zzbpQ == null || this.zzbpQ.isEmpty()) ? 0 : this.zzbpQ.hashCode();
            return hashCode2 + hashCode;
        }

        public /* synthetic */ zztk mergeFrom(zztc x0) throws IOException {
            return zzJ(x0);
        }

        public void writeTo(zztd output) throws IOException {
            if (!Arrays.equals(this.zzbqt, zztn.zzbqi)) {
                output.zza(1, this.zzbqt);
            }
            if (this.zzbqu != null && this.zzbqu.length > 0) {
                for (byte[] bArr : this.zzbqu) {
                    if (bArr != null) {
                        output.zza(2, bArr);
                    }
                }
            }
            if (this.zzbqv) {
                output.zzb(3, this.zzbqv);
            }
            super.writeTo(output);
        }

        public zzc zzHO() {
            this.zzbqt = zztn.zzbqi;
            this.zzbqu = zztn.zzbqh;
            this.zzbqv = false;
            this.zzbpQ = null;
            this.zzbqb = -1;
            return this;
        }

        public zzc zzJ(zztc com_google_android_gms_internal_zztc) throws IOException {
            while (true) {
                int zzHi = com_google_android_gms_internal_zztc.zzHi();
                switch (zzHi) {
                    case 0:
                        break;
                    case 10:
                        this.zzbqt = com_google_android_gms_internal_zztc.readBytes();
                        continue;
                    case 18:
                        int zzc = zztn.zzc(com_google_android_gms_internal_zztc, 18);
                        zzHi = this.zzbqu == null ? 0 : this.zzbqu.length;
                        Object obj = new byte[(zzc + zzHi)][];
                        if (zzHi != 0) {
                            System.arraycopy(this.zzbqu, 0, obj, 0, zzHi);
                        }
                        while (zzHi < obj.length - 1) {
                            obj[zzHi] = com_google_android_gms_internal_zztc.readBytes();
                            com_google_android_gms_internal_zztc.zzHi();
                            zzHi++;
                        }
                        obj[zzHi] = com_google_android_gms_internal_zztc.readBytes();
                        this.zzbqu = obj;
                        continue;
                    case 24:
                        this.zzbqv = com_google_android_gms_internal_zztc.zzHm();
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
            if (!Arrays.equals(this.zzbqt, zztn.zzbqi)) {
                zzz += zztd.zzb(1, this.zzbqt);
            }
            if (this.zzbqu != null && this.zzbqu.length > 0) {
                int i2 = 0;
                int i3 = 0;
                while (i < this.zzbqu.length) {
                    byte[] bArr = this.zzbqu[i];
                    if (bArr != null) {
                        i3++;
                        i2 += zztd.zzF(bArr);
                    }
                    i++;
                }
                zzz = (zzz + i2) + (i3 * 1);
            }
            return this.zzbqv ? zzz + zztd.zzc(3, this.zzbqv) : zzz;
        }
    }

    public static final class zzd extends zzte<zzd> {
        public String tag;
        public boolean zzbqA;
        public zze[] zzbqB;
        public zzb zzbqC;
        public byte[] zzbqD;
        public byte[] zzbqE;
        public byte[] zzbqF;
        public zza zzbqG;
        public String zzbqH;
        public long zzbqI;
        public zzc zzbqJ;
        public byte[] zzbqK;
        public int zzbqL;
        public int[] zzbqM;
        public long zzbqw;
        public long zzbqx;
        public long zzbqy;
        public int zzbqz;
        public int zznN;

        public zzd() {
            zzHP();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzd)) {
                return false;
            }
            zzd com_google_android_gms_internal_zztp_zzd = (zzd) o;
            if (this.zzbqw != com_google_android_gms_internal_zztp_zzd.zzbqw || this.zzbqx != com_google_android_gms_internal_zztp_zzd.zzbqx || this.zzbqy != com_google_android_gms_internal_zztp_zzd.zzbqy) {
                return false;
            }
            if (this.tag == null) {
                if (com_google_android_gms_internal_zztp_zzd.tag != null) {
                    return false;
                }
            } else if (!this.tag.equals(com_google_android_gms_internal_zztp_zzd.tag)) {
                return false;
            }
            if (this.zzbqz != com_google_android_gms_internal_zztp_zzd.zzbqz || this.zznN != com_google_android_gms_internal_zztp_zzd.zznN || this.zzbqA != com_google_android_gms_internal_zztp_zzd.zzbqA || !zzti.equals(this.zzbqB, com_google_android_gms_internal_zztp_zzd.zzbqB)) {
                return false;
            }
            if (this.zzbqC == null) {
                if (com_google_android_gms_internal_zztp_zzd.zzbqC != null) {
                    return false;
                }
            } else if (!this.zzbqC.equals(com_google_android_gms_internal_zztp_zzd.zzbqC)) {
                return false;
            }
            if (!Arrays.equals(this.zzbqD, com_google_android_gms_internal_zztp_zzd.zzbqD) || !Arrays.equals(this.zzbqE, com_google_android_gms_internal_zztp_zzd.zzbqE) || !Arrays.equals(this.zzbqF, com_google_android_gms_internal_zztp_zzd.zzbqF)) {
                return false;
            }
            if (this.zzbqG == null) {
                if (com_google_android_gms_internal_zztp_zzd.zzbqG != null) {
                    return false;
                }
            } else if (!this.zzbqG.equals(com_google_android_gms_internal_zztp_zzd.zzbqG)) {
                return false;
            }
            if (this.zzbqH == null) {
                if (com_google_android_gms_internal_zztp_zzd.zzbqH != null) {
                    return false;
                }
            } else if (!this.zzbqH.equals(com_google_android_gms_internal_zztp_zzd.zzbqH)) {
                return false;
            }
            if (this.zzbqI != com_google_android_gms_internal_zztp_zzd.zzbqI) {
                return false;
            }
            if (this.zzbqJ == null) {
                if (com_google_android_gms_internal_zztp_zzd.zzbqJ != null) {
                    return false;
                }
            } else if (!this.zzbqJ.equals(com_google_android_gms_internal_zztp_zzd.zzbqJ)) {
                return false;
            }
            if (!Arrays.equals(this.zzbqK, com_google_android_gms_internal_zztp_zzd.zzbqK) || this.zzbqL != com_google_android_gms_internal_zztp_zzd.zzbqL || !zzti.equals(this.zzbqM, com_google_android_gms_internal_zztp_zzd.zzbqM)) {
                return false;
            }
            if (this.zzbpQ == null || this.zzbpQ.isEmpty()) {
                return com_google_android_gms_internal_zztp_zzd.zzbpQ == null || com_google_android_gms_internal_zztp_zzd.zzbpQ.isEmpty();
            } else {
                return this.zzbpQ.equals(com_google_android_gms_internal_zztp_zzd.zzbpQ);
            }
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((((((this.zzbqJ == null ? 0 : this.zzbqJ.hashCode()) + (((((this.zzbqH == null ? 0 : this.zzbqH.hashCode()) + (((this.zzbqG == null ? 0 : this.zzbqG.hashCode()) + (((((((((this.zzbqC == null ? 0 : this.zzbqC.hashCode()) + (((((this.zzbqA ? 1231 : 1237) + (((((((this.tag == null ? 0 : this.tag.hashCode()) + ((((((((getClass().getName().hashCode() + 527) * 31) + ((int) (this.zzbqw ^ (this.zzbqw >>> 32)))) * 31) + ((int) (this.zzbqx ^ (this.zzbqx >>> 32)))) * 31) + ((int) (this.zzbqy ^ (this.zzbqy >>> 32)))) * 31)) * 31) + this.zzbqz) * 31) + this.zznN) * 31)) * 31) + zzti.hashCode(this.zzbqB)) * 31)) * 31) + Arrays.hashCode(this.zzbqD)) * 31) + Arrays.hashCode(this.zzbqE)) * 31) + Arrays.hashCode(this.zzbqF)) * 31)) * 31)) * 31) + ((int) (this.zzbqI ^ (this.zzbqI >>> 32)))) * 31)) * 31) + Arrays.hashCode(this.zzbqK)) * 31) + this.zzbqL) * 31) + zzti.hashCode(this.zzbqM)) * 31;
            if (!(this.zzbpQ == null || this.zzbpQ.isEmpty())) {
                i = this.zzbpQ.hashCode();
            }
            return hashCode + i;
        }

        public /* synthetic */ zztk mergeFrom(zztc x0) throws IOException {
            return zzK(x0);
        }

        public void writeTo(zztd output) throws IOException {
            int i = 0;
            if (this.zzbqw != 0) {
                output.zzb(1, this.zzbqw);
            }
            if (!this.tag.equals("")) {
                output.zzb(2, this.tag);
            }
            if (this.zzbqB != null && this.zzbqB.length > 0) {
                for (zztk com_google_android_gms_internal_zztk : this.zzbqB) {
                    if (com_google_android_gms_internal_zztk != null) {
                        output.zza(3, com_google_android_gms_internal_zztk);
                    }
                }
            }
            if (!Arrays.equals(this.zzbqD, zztn.zzbqi)) {
                output.zza(6, this.zzbqD);
            }
            if (this.zzbqG != null) {
                output.zza(7, this.zzbqG);
            }
            if (!Arrays.equals(this.zzbqE, zztn.zzbqi)) {
                output.zza(8, this.zzbqE);
            }
            if (this.zzbqC != null) {
                output.zza(9, this.zzbqC);
            }
            if (this.zzbqA) {
                output.zzb(10, this.zzbqA);
            }
            if (this.zzbqz != 0) {
                output.zzG(11, this.zzbqz);
            }
            if (this.zznN != 0) {
                output.zzG(12, this.zznN);
            }
            if (!Arrays.equals(this.zzbqF, zztn.zzbqi)) {
                output.zza(13, this.zzbqF);
            }
            if (!this.zzbqH.equals("")) {
                output.zzb(14, this.zzbqH);
            }
            if (this.zzbqI != 180000) {
                output.zzc(15, this.zzbqI);
            }
            if (this.zzbqJ != null) {
                output.zza(16, this.zzbqJ);
            }
            if (this.zzbqx != 0) {
                output.zzb(17, this.zzbqx);
            }
            if (!Arrays.equals(this.zzbqK, zztn.zzbqi)) {
                output.zza(18, this.zzbqK);
            }
            if (this.zzbqL != 0) {
                output.zzG(19, this.zzbqL);
            }
            if (this.zzbqM != null && this.zzbqM.length > 0) {
                while (i < this.zzbqM.length) {
                    output.zzG(20, this.zzbqM[i]);
                    i++;
                }
            }
            if (this.zzbqy != 0) {
                output.zzb(21, this.zzbqy);
            }
            super.writeTo(output);
        }

        public zzd zzHP() {
            this.zzbqw = 0;
            this.zzbqx = 0;
            this.zzbqy = 0;
            this.tag = "";
            this.zzbqz = 0;
            this.zznN = 0;
            this.zzbqA = false;
            this.zzbqB = zze.zzHQ();
            this.zzbqC = null;
            this.zzbqD = zztn.zzbqi;
            this.zzbqE = zztn.zzbqi;
            this.zzbqF = zztn.zzbqi;
            this.zzbqG = null;
            this.zzbqH = "";
            this.zzbqI = 180000;
            this.zzbqJ = null;
            this.zzbqK = zztn.zzbqi;
            this.zzbqL = 0;
            this.zzbqM = zztn.zzboD;
            this.zzbpQ = null;
            this.zzbqb = -1;
            return this;
        }

        public zzd zzK(zztc com_google_android_gms_internal_zztc) throws IOException {
            while (true) {
                int zzHi = com_google_android_gms_internal_zztc.zzHi();
                int zzc;
                Object obj;
                switch (zzHi) {
                    case 0:
                        break;
                    case 8:
                        this.zzbqw = com_google_android_gms_internal_zztc.zzHk();
                        continue;
                    case 18:
                        this.tag = com_google_android_gms_internal_zztc.readString();
                        continue;
                    case 26:
                        zzc = zztn.zzc(com_google_android_gms_internal_zztc, 26);
                        zzHi = this.zzbqB == null ? 0 : this.zzbqB.length;
                        obj = new zze[(zzc + zzHi)];
                        if (zzHi != 0) {
                            System.arraycopy(this.zzbqB, 0, obj, 0, zzHi);
                        }
                        while (zzHi < obj.length - 1) {
                            obj[zzHi] = new zze();
                            com_google_android_gms_internal_zztc.zza(obj[zzHi]);
                            com_google_android_gms_internal_zztc.zzHi();
                            zzHi++;
                        }
                        obj[zzHi] = new zze();
                        com_google_android_gms_internal_zztc.zza(obj[zzHi]);
                        this.zzbqB = obj;
                        continue;
                    case 50:
                        this.zzbqD = com_google_android_gms_internal_zztc.readBytes();
                        continue;
                    case 58:
                        if (this.zzbqG == null) {
                            this.zzbqG = new zza();
                        }
                        com_google_android_gms_internal_zztc.zza(this.zzbqG);
                        continue;
                    case 66:
                        this.zzbqE = com_google_android_gms_internal_zztc.readBytes();
                        continue;
                    case 74:
                        if (this.zzbqC == null) {
                            this.zzbqC = new zzb();
                        }
                        com_google_android_gms_internal_zztc.zza(this.zzbqC);
                        continue;
                    case 80:
                        this.zzbqA = com_google_android_gms_internal_zztc.zzHm();
                        continue;
                    case Place.TYPE_STORE /*88*/:
                        this.zzbqz = com_google_android_gms_internal_zztc.zzHl();
                        continue;
                    case Place.TYPE_ZOO /*96*/:
                        this.zznN = com_google_android_gms_internal_zztc.zzHl();
                        continue;
                    case 106:
                        this.zzbqF = com_google_android_gms_internal_zztc.readBytes();
                        continue;
                    case 114:
                        this.zzbqH = com_google_android_gms_internal_zztc.readString();
                        continue;
                    case 120:
                        this.zzbqI = com_google_android_gms_internal_zztc.zzHo();
                        continue;
                    case TransportMediator.KEYCODE_MEDIA_RECORD /*130*/:
                        if (this.zzbqJ == null) {
                            this.zzbqJ = new zzc();
                        }
                        com_google_android_gms_internal_zztc.zza(this.zzbqJ);
                        continue;
                    case 136:
                        this.zzbqx = com_google_android_gms_internal_zztc.zzHk();
                        continue;
                    case 146:
                        this.zzbqK = com_google_android_gms_internal_zztc.readBytes();
                        continue;
                    case 152:
                        zzHi = com_google_android_gms_internal_zztc.zzHl();
                        switch (zzHi) {
                            case 0:
                            case 1:
                            case 2:
                                this.zzbqL = zzHi;
                                break;
                            default:
                                continue;
                        }
                    case 160:
                        zzc = zztn.zzc(com_google_android_gms_internal_zztc, 160);
                        zzHi = this.zzbqM == null ? 0 : this.zzbqM.length;
                        obj = new int[(zzc + zzHi)];
                        if (zzHi != 0) {
                            System.arraycopy(this.zzbqM, 0, obj, 0, zzHi);
                        }
                        while (zzHi < obj.length - 1) {
                            obj[zzHi] = com_google_android_gms_internal_zztc.zzHl();
                            com_google_android_gms_internal_zztc.zzHi();
                            zzHi++;
                        }
                        obj[zzHi] = com_google_android_gms_internal_zztc.zzHl();
                        this.zzbqM = obj;
                        continue;
                    case 162:
                        int zzmn = com_google_android_gms_internal_zztc.zzmn(com_google_android_gms_internal_zztc.zzHp());
                        zzc = com_google_android_gms_internal_zztc.getPosition();
                        zzHi = 0;
                        while (com_google_android_gms_internal_zztc.zzHu() > 0) {
                            com_google_android_gms_internal_zztc.zzHl();
                            zzHi++;
                        }
                        com_google_android_gms_internal_zztc.zzmp(zzc);
                        zzc = this.zzbqM == null ? 0 : this.zzbqM.length;
                        Object obj2 = new int[(zzHi + zzc)];
                        if (zzc != 0) {
                            System.arraycopy(this.zzbqM, 0, obj2, 0, zzc);
                        }
                        while (zzc < obj2.length) {
                            obj2[zzc] = com_google_android_gms_internal_zztc.zzHl();
                            zzc++;
                        }
                        this.zzbqM = obj2;
                        com_google_android_gms_internal_zztc.zzmo(zzmn);
                        continue;
                    case 168:
                        this.zzbqy = com_google_android_gms_internal_zztc.zzHk();
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
            if (this.zzbqw != 0) {
                zzz += zztd.zzd(1, this.zzbqw);
            }
            if (!this.tag.equals("")) {
                zzz += zztd.zzp(2, this.tag);
            }
            if (this.zzbqB != null && this.zzbqB.length > 0) {
                i = zzz;
                for (zztk com_google_android_gms_internal_zztk : this.zzbqB) {
                    if (com_google_android_gms_internal_zztk != null) {
                        i += zztd.zzc(3, com_google_android_gms_internal_zztk);
                    }
                }
                zzz = i;
            }
            if (!Arrays.equals(this.zzbqD, zztn.zzbqi)) {
                zzz += zztd.zzb(6, this.zzbqD);
            }
            if (this.zzbqG != null) {
                zzz += zztd.zzc(7, this.zzbqG);
            }
            if (!Arrays.equals(this.zzbqE, zztn.zzbqi)) {
                zzz += zztd.zzb(8, this.zzbqE);
            }
            if (this.zzbqC != null) {
                zzz += zztd.zzc(9, this.zzbqC);
            }
            if (this.zzbqA) {
                zzz += zztd.zzc(10, this.zzbqA);
            }
            if (this.zzbqz != 0) {
                zzz += zztd.zzI(11, this.zzbqz);
            }
            if (this.zznN != 0) {
                zzz += zztd.zzI(12, this.zznN);
            }
            if (!Arrays.equals(this.zzbqF, zztn.zzbqi)) {
                zzz += zztd.zzb(13, this.zzbqF);
            }
            if (!this.zzbqH.equals("")) {
                zzz += zztd.zzp(14, this.zzbqH);
            }
            if (this.zzbqI != 180000) {
                zzz += zztd.zze(15, this.zzbqI);
            }
            if (this.zzbqJ != null) {
                zzz += zztd.zzc(16, this.zzbqJ);
            }
            if (this.zzbqx != 0) {
                zzz += zztd.zzd(17, this.zzbqx);
            }
            if (!Arrays.equals(this.zzbqK, zztn.zzbqi)) {
                zzz += zztd.zzb(18, this.zzbqK);
            }
            if (this.zzbqL != 0) {
                zzz += zztd.zzI(19, this.zzbqL);
            }
            if (this.zzbqM != null && this.zzbqM.length > 0) {
                i = 0;
                while (i2 < this.zzbqM.length) {
                    i += zztd.zzmu(this.zzbqM[i2]);
                    i2++;
                }
                zzz = (zzz + i) + (this.zzbqM.length * 2);
            }
            return this.zzbqy != 0 ? zzz + zztd.zzd(21, this.zzbqy) : zzz;
        }
    }

    public static final class zze extends zzte<zze> {
        private static volatile zze[] zzbqN;
        public String key;
        public String value;

        public zze() {
            zzHR();
        }

        public static zze[] zzHQ() {
            if (zzbqN == null) {
                synchronized (zzti.zzbqa) {
                    if (zzbqN == null) {
                        zzbqN = new zze[0];
                    }
                }
            }
            return zzbqN;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zze)) {
                return false;
            }
            zze com_google_android_gms_internal_zztp_zze = (zze) o;
            if (this.key == null) {
                if (com_google_android_gms_internal_zztp_zze.key != null) {
                    return false;
                }
            } else if (!this.key.equals(com_google_android_gms_internal_zztp_zze.key)) {
                return false;
            }
            if (this.value == null) {
                if (com_google_android_gms_internal_zztp_zze.value != null) {
                    return false;
                }
            } else if (!this.value.equals(com_google_android_gms_internal_zztp_zze.value)) {
                return false;
            }
            if (this.zzbpQ == null || this.zzbpQ.isEmpty()) {
                return com_google_android_gms_internal_zztp_zze.zzbpQ == null || com_google_android_gms_internal_zztp_zze.zzbpQ.isEmpty();
            } else {
                return this.zzbpQ.equals(com_google_android_gms_internal_zztp_zze.zzbpQ);
            }
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.value == null ? 0 : this.value.hashCode()) + (((this.key == null ? 0 : this.key.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
            if (!(this.zzbpQ == null || this.zzbpQ.isEmpty())) {
                i = this.zzbpQ.hashCode();
            }
            return hashCode + i;
        }

        public /* synthetic */ zztk mergeFrom(zztc x0) throws IOException {
            return zzL(x0);
        }

        public void writeTo(zztd output) throws IOException {
            if (!this.key.equals("")) {
                output.zzb(1, this.key);
            }
            if (!this.value.equals("")) {
                output.zzb(2, this.value);
            }
            super.writeTo(output);
        }

        public zze zzHR() {
            this.key = "";
            this.value = "";
            this.zzbpQ = null;
            this.zzbqb = -1;
            return this;
        }

        public zze zzL(zztc com_google_android_gms_internal_zztc) throws IOException {
            while (true) {
                int zzHi = com_google_android_gms_internal_zztc.zzHi();
                switch (zzHi) {
                    case 0:
                        break;
                    case 10:
                        this.key = com_google_android_gms_internal_zztc.readString();
                        continue;
                    case 18:
                        this.value = com_google_android_gms_internal_zztc.readString();
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
            return !this.value.equals("") ? zzz + zztd.zzp(2, this.value) : zzz;
        }
    }
}
