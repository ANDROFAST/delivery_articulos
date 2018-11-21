package com.google.android.gms.internal;

import java.io.IOException;

public final class zzta extends zzte<zzta> {
    public String[] zzbpA;
    public int[] zzbpB;
    public byte[][] zzbpC;

    public zzta() {
        zzHh();
    }

    public static zzta zzA(byte[] bArr) throws zztj {
        return (zzta) zztk.mergeFrom(new zzta(), bArr);
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzta)) {
            return false;
        }
        zzta com_google_android_gms_internal_zzta = (zzta) o;
        if (!zzti.equals(this.zzbpA, com_google_android_gms_internal_zzta.zzbpA) || !zzti.equals(this.zzbpB, com_google_android_gms_internal_zzta.zzbpB) || !zzti.zza(this.zzbpC, com_google_android_gms_internal_zzta.zzbpC)) {
            return false;
        }
        if (this.zzbpQ == null || this.zzbpQ.isEmpty()) {
            return com_google_android_gms_internal_zzta.zzbpQ == null || com_google_android_gms_internal_zzta.zzbpQ.isEmpty();
        } else {
            return this.zzbpQ.equals(com_google_android_gms_internal_zzta.zzbpQ);
        }
    }

    public int hashCode() {
        int hashCode = (((((((getClass().getName().hashCode() + 527) * 31) + zzti.hashCode(this.zzbpA)) * 31) + zzti.hashCode(this.zzbpB)) * 31) + zzti.zza(this.zzbpC)) * 31;
        int hashCode2 = (this.zzbpQ == null || this.zzbpQ.isEmpty()) ? 0 : this.zzbpQ.hashCode();
        return hashCode2 + hashCode;
    }

    public /* synthetic */ zztk mergeFrom(zztc x0) throws IOException {
        return zzD(x0);
    }

    public void writeTo(zztd output) throws IOException {
        int i = 0;
        if (this.zzbpA != null && this.zzbpA.length > 0) {
            for (String str : this.zzbpA) {
                if (str != null) {
                    output.zzb(1, str);
                }
            }
        }
        if (this.zzbpB != null && this.zzbpB.length > 0) {
            for (int zzG : this.zzbpB) {
                output.zzG(2, zzG);
            }
        }
        if (this.zzbpC != null && this.zzbpC.length > 0) {
            while (i < this.zzbpC.length) {
                byte[] bArr = this.zzbpC[i];
                if (bArr != null) {
                    output.zza(3, bArr);
                }
                i++;
            }
        }
        super.writeTo(output);
    }

    public zzta zzD(zztc com_google_android_gms_internal_zztc) throws IOException {
        while (true) {
            int zzHi = com_google_android_gms_internal_zztc.zzHi();
            int zzc;
            Object obj;
            switch (zzHi) {
                case 0:
                    break;
                case 10:
                    zzc = zztn.zzc(com_google_android_gms_internal_zztc, 10);
                    zzHi = this.zzbpA == null ? 0 : this.zzbpA.length;
                    obj = new String[(zzc + zzHi)];
                    if (zzHi != 0) {
                        System.arraycopy(this.zzbpA, 0, obj, 0, zzHi);
                    }
                    while (zzHi < obj.length - 1) {
                        obj[zzHi] = com_google_android_gms_internal_zztc.readString();
                        com_google_android_gms_internal_zztc.zzHi();
                        zzHi++;
                    }
                    obj[zzHi] = com_google_android_gms_internal_zztc.readString();
                    this.zzbpA = obj;
                    continue;
                case 16:
                    zzc = zztn.zzc(com_google_android_gms_internal_zztc, 16);
                    zzHi = this.zzbpB == null ? 0 : this.zzbpB.length;
                    obj = new int[(zzc + zzHi)];
                    if (zzHi != 0) {
                        System.arraycopy(this.zzbpB, 0, obj, 0, zzHi);
                    }
                    while (zzHi < obj.length - 1) {
                        obj[zzHi] = com_google_android_gms_internal_zztc.zzHl();
                        com_google_android_gms_internal_zztc.zzHi();
                        zzHi++;
                    }
                    obj[zzHi] = com_google_android_gms_internal_zztc.zzHl();
                    this.zzbpB = obj;
                    continue;
                case 18:
                    int zzmn = com_google_android_gms_internal_zztc.zzmn(com_google_android_gms_internal_zztc.zzHp());
                    zzc = com_google_android_gms_internal_zztc.getPosition();
                    zzHi = 0;
                    while (com_google_android_gms_internal_zztc.zzHu() > 0) {
                        com_google_android_gms_internal_zztc.zzHl();
                        zzHi++;
                    }
                    com_google_android_gms_internal_zztc.zzmp(zzc);
                    zzc = this.zzbpB == null ? 0 : this.zzbpB.length;
                    Object obj2 = new int[(zzHi + zzc)];
                    if (zzc != 0) {
                        System.arraycopy(this.zzbpB, 0, obj2, 0, zzc);
                    }
                    while (zzc < obj2.length) {
                        obj2[zzc] = com_google_android_gms_internal_zztc.zzHl();
                        zzc++;
                    }
                    this.zzbpB = obj2;
                    com_google_android_gms_internal_zztc.zzmo(zzmn);
                    continue;
                case 26:
                    zzc = zztn.zzc(com_google_android_gms_internal_zztc, 26);
                    zzHi = this.zzbpC == null ? 0 : this.zzbpC.length;
                    obj = new byte[(zzc + zzHi)][];
                    if (zzHi != 0) {
                        System.arraycopy(this.zzbpC, 0, obj, 0, zzHi);
                    }
                    while (zzHi < obj.length - 1) {
                        obj[zzHi] = com_google_android_gms_internal_zztc.readBytes();
                        com_google_android_gms_internal_zztc.zzHi();
                        zzHi++;
                    }
                    obj[zzHi] = com_google_android_gms_internal_zztc.readBytes();
                    this.zzbpC = obj;
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

    public zzta zzHh() {
        this.zzbpA = zztn.zzbqg;
        this.zzbpB = zztn.zzboD;
        this.zzbpC = zztn.zzbqh;
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
        if (this.zzbpA == null || this.zzbpA.length <= 0) {
            i = zzz;
        } else {
            i2 = 0;
            i3 = 0;
            for (String str : this.zzbpA) {
                if (str != null) {
                    i3++;
                    i2 += zztd.zzga(str);
                }
            }
            i = (zzz + i2) + (i3 * 1);
        }
        if (this.zzbpB != null && this.zzbpB.length > 0) {
            i3 = 0;
            for (int zzz2 : this.zzbpB) {
                i3 += zztd.zzmu(zzz2);
            }
            i = (i + i3) + (this.zzbpB.length * 1);
        }
        if (this.zzbpC == null || this.zzbpC.length <= 0) {
            return i;
        }
        i2 = 0;
        i3 = 0;
        while (i4 < this.zzbpC.length) {
            byte[] bArr = this.zzbpC[i4];
            if (bArr != null) {
                i3++;
                i2 += zztd.zzF(bArr);
            }
            i4++;
        }
        return (i + i2) + (i3 * 1);
    }
}
