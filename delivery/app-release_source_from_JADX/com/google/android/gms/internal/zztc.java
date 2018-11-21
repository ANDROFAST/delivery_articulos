package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import android.support.v4.view.MotionEventCompat;
import java.io.IOException;

public final class zztc {
    private final byte[] buffer;
    private int zzbpG;
    private int zzbpH;
    private int zzbpI;
    private int zzbpJ;
    private int zzbpK;
    private int zzbpL = Integer.MAX_VALUE;
    private int zzbpM;
    private int zzbpN = 64;
    private int zzbpO = 67108864;

    private zztc(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.zzbpG = i;
        this.zzbpH = i + i2;
        this.zzbpJ = i;
    }

    public static zztc zzC(byte[] bArr) {
        return zza(bArr, 0, bArr.length);
    }

    private void zzHt() {
        this.zzbpH += this.zzbpI;
        int i = this.zzbpH;
        if (i > this.zzbpL) {
            this.zzbpI = i - this.zzbpL;
            this.zzbpH -= this.zzbpI;
            return;
        }
        this.zzbpI = 0;
    }

    public static zztc zza(byte[] bArr, int i, int i2) {
        return new zztc(bArr, i, i2);
    }

    public static long zzaa(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }

    public static int zzmm(int i) {
        return (i >>> 1) ^ (-(i & 1));
    }

    public int getPosition() {
        return this.zzbpJ - this.zzbpG;
    }

    public byte[] readBytes() throws IOException {
        int zzHp = zzHp();
        if (zzHp > this.zzbpH - this.zzbpJ || zzHp <= 0) {
            return zzHp == 0 ? zztn.zzbqi : zzmq(zzHp);
        } else {
            Object obj = new byte[zzHp];
            System.arraycopy(this.buffer, this.zzbpJ, obj, 0, zzHp);
            this.zzbpJ = zzHp + this.zzbpJ;
            return obj;
        }
    }

    public double readDouble() throws IOException {
        return Double.longBitsToDouble(zzHs());
    }

    public float readFloat() throws IOException {
        return Float.intBitsToFloat(zzHr());
    }

    public String readString() throws IOException {
        int zzHp = zzHp();
        if (zzHp > this.zzbpH - this.zzbpJ || zzHp <= 0) {
            return new String(zzmq(zzHp), "UTF-8");
        }
        String str = new String(this.buffer, this.zzbpJ, zzHp, "UTF-8");
        this.zzbpJ = zzHp + this.zzbpJ;
        return str;
    }

    public byte[] zzF(int i, int i2) {
        if (i2 == 0) {
            return zztn.zzbqi;
        }
        Object obj = new byte[i2];
        System.arraycopy(this.buffer, this.zzbpG + i, obj, 0, i2);
        return obj;
    }

    public int zzHi() throws IOException {
        if (zzHv()) {
            this.zzbpK = 0;
            return 0;
        }
        this.zzbpK = zzHp();
        if (this.zzbpK != 0) {
            return this.zzbpK;
        }
        throw zztj.zzHF();
    }

    public void zzHj() throws IOException {
        int zzHi;
        do {
            zzHi = zzHi();
            if (zzHi == 0) {
                return;
            }
        } while (zzml(zzHi));
    }

    public long zzHk() throws IOException {
        return zzHq();
    }

    public int zzHl() throws IOException {
        return zzHp();
    }

    public boolean zzHm() throws IOException {
        return zzHp() != 0;
    }

    public int zzHn() throws IOException {
        return zzmm(zzHp());
    }

    public long zzHo() throws IOException {
        return zzaa(zzHq());
    }

    public int zzHp() throws IOException {
        byte zzHw = zzHw();
        if (zzHw >= (byte) 0) {
            return zzHw;
        }
        int i = zzHw & TransportMediator.KEYCODE_MEDIA_PAUSE;
        byte zzHw2 = zzHw();
        if (zzHw2 >= (byte) 0) {
            return i | (zzHw2 << 7);
        }
        i |= (zzHw2 & TransportMediator.KEYCODE_MEDIA_PAUSE) << 7;
        zzHw2 = zzHw();
        if (zzHw2 >= (byte) 0) {
            return i | (zzHw2 << 14);
        }
        i |= (zzHw2 & TransportMediator.KEYCODE_MEDIA_PAUSE) << 14;
        zzHw2 = zzHw();
        if (zzHw2 >= (byte) 0) {
            return i | (zzHw2 << 21);
        }
        i |= (zzHw2 & TransportMediator.KEYCODE_MEDIA_PAUSE) << 21;
        zzHw2 = zzHw();
        i |= zzHw2 << 28;
        if (zzHw2 >= (byte) 0) {
            return i;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            if (zzHw() >= (byte) 0) {
                return i;
            }
        }
        throw zztj.zzHE();
    }

    public long zzHq() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzHw = zzHw();
            j |= ((long) (zzHw & TransportMediator.KEYCODE_MEDIA_PAUSE)) << i;
            if ((zzHw & 128) == 0) {
                return j;
            }
        }
        throw zztj.zzHE();
    }

    public int zzHr() throws IOException {
        return (((zzHw() & MotionEventCompat.ACTION_MASK) | ((zzHw() & MotionEventCompat.ACTION_MASK) << 8)) | ((zzHw() & MotionEventCompat.ACTION_MASK) << 16)) | ((zzHw() & MotionEventCompat.ACTION_MASK) << 24);
    }

    public long zzHs() throws IOException {
        byte zzHw = zzHw();
        byte zzHw2 = zzHw();
        return ((((((((((long) zzHw2) & 255) << 8) | (((long) zzHw) & 255)) | ((((long) zzHw()) & 255) << 16)) | ((((long) zzHw()) & 255) << 24)) | ((((long) zzHw()) & 255) << 32)) | ((((long) zzHw()) & 255) << 40)) | ((((long) zzHw()) & 255) << 48)) | ((((long) zzHw()) & 255) << 56);
    }

    public int zzHu() {
        if (this.zzbpL == Integer.MAX_VALUE) {
            return -1;
        }
        return this.zzbpL - this.zzbpJ;
    }

    public boolean zzHv() {
        return this.zzbpJ == this.zzbpH;
    }

    public byte zzHw() throws IOException {
        if (this.zzbpJ == this.zzbpH) {
            throw zztj.zzHC();
        }
        byte[] bArr = this.buffer;
        int i = this.zzbpJ;
        this.zzbpJ = i + 1;
        return bArr[i];
    }

    public void zza(zztk com_google_android_gms_internal_zztk) throws IOException {
        int zzHp = zzHp();
        if (this.zzbpM >= this.zzbpN) {
            throw zztj.zzHI();
        }
        zzHp = zzmn(zzHp);
        this.zzbpM++;
        com_google_android_gms_internal_zztk.mergeFrom(this);
        zzmk(0);
        this.zzbpM--;
        zzmo(zzHp);
    }

    public void zza(zztk com_google_android_gms_internal_zztk, int i) throws IOException {
        if (this.zzbpM >= this.zzbpN) {
            throw zztj.zzHI();
        }
        this.zzbpM++;
        com_google_android_gms_internal_zztk.mergeFrom(this);
        zzmk(zztn.zzL(i, 4));
        this.zzbpM--;
    }

    public void zzmk(int i) throws zztj {
        if (this.zzbpK != i) {
            throw zztj.zzHG();
        }
    }

    public boolean zzml(int i) throws IOException {
        switch (zztn.zzmF(i)) {
            case 0:
                zzHl();
                return true;
            case 1:
                zzHs();
                return true;
            case 2:
                zzmr(zzHp());
                return true;
            case 3:
                zzHj();
                zzmk(zztn.zzL(zztn.zzmG(i), 4));
                return true;
            case 4:
                return false;
            case 5:
                zzHr();
                return true;
            default:
                throw zztj.zzHH();
        }
    }

    public int zzmn(int i) throws zztj {
        if (i < 0) {
            throw zztj.zzHD();
        }
        int i2 = this.zzbpJ + i;
        int i3 = this.zzbpL;
        if (i2 > i3) {
            throw zztj.zzHC();
        }
        this.zzbpL = i2;
        zzHt();
        return i3;
    }

    public void zzmo(int i) {
        this.zzbpL = i;
        zzHt();
    }

    public void zzmp(int i) {
        if (i > this.zzbpJ - this.zzbpG) {
            throw new IllegalArgumentException("Position " + i + " is beyond current " + (this.zzbpJ - this.zzbpG));
        } else if (i < 0) {
            throw new IllegalArgumentException("Bad position " + i);
        } else {
            this.zzbpJ = this.zzbpG + i;
        }
    }

    public byte[] zzmq(int i) throws IOException {
        if (i < 0) {
            throw zztj.zzHD();
        } else if (this.zzbpJ + i > this.zzbpL) {
            zzmr(this.zzbpL - this.zzbpJ);
            throw zztj.zzHC();
        } else if (i <= this.zzbpH - this.zzbpJ) {
            Object obj = new byte[i];
            System.arraycopy(this.buffer, this.zzbpJ, obj, 0, i);
            this.zzbpJ += i;
            return obj;
        } else {
            throw zztj.zzHC();
        }
    }

    public void zzmr(int i) throws IOException {
        if (i < 0) {
            throw zztj.zzHD();
        } else if (this.zzbpJ + i > this.zzbpL) {
            zzmr(this.zzbpL - this.zzbpJ);
            throw zztj.zzHC();
        } else if (i <= this.zzbpH - this.zzbpJ) {
            this.zzbpJ += i;
        } else {
            throw zztj.zzHC();
        }
    }
}
