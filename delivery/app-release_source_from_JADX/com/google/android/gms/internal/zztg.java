package com.google.android.gms.internal;

public final class zztg implements Cloneable {
    private static final zzth zzbpT = new zzth();
    private int mSize;
    private boolean zzbpU;
    private int[] zzbpV;
    private zzth[] zzbpW;

    zztg() {
        this(10);
    }

    zztg(int i) {
        this.zzbpU = false;
        int idealIntArraySize = idealIntArraySize(i);
        this.zzbpV = new int[idealIntArraySize];
        this.zzbpW = new zzth[idealIntArraySize];
        this.mSize = 0;
    }

    private void gc() {
        int i = this.mSize;
        int[] iArr = this.zzbpV;
        zzth[] com_google_android_gms_internal_zzthArr = this.zzbpW;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            zzth com_google_android_gms_internal_zzth = com_google_android_gms_internal_zzthArr[i3];
            if (com_google_android_gms_internal_zzth != zzbpT) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    com_google_android_gms_internal_zzthArr[i2] = com_google_android_gms_internal_zzth;
                    com_google_android_gms_internal_zzthArr[i3] = null;
                }
                i2++;
            }
        }
        this.zzbpU = false;
        this.mSize = i2;
    }

    private int idealByteArraySize(int need) {
        for (int i = 4; i < 32; i++) {
            if (need <= (1 << i) - 12) {
                return (1 << i) - 12;
            }
        }
        return need;
    }

    private int idealIntArraySize(int need) {
        return idealByteArraySize(need * 4) / 4;
    }

    private boolean zza(int[] iArr, int[] iArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private boolean zza(zzth[] com_google_android_gms_internal_zzthArr, zzth[] com_google_android_gms_internal_zzthArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (!com_google_android_gms_internal_zzthArr[i2].equals(com_google_android_gms_internal_zzthArr2[i2])) {
                return false;
            }
        }
        return true;
    }

    private int zzmE(int i) {
        int i2 = 0;
        int i3 = this.mSize - 1;
        while (i2 <= i3) {
            int i4 = (i2 + i3) >>> 1;
            int i5 = this.zzbpV[i4];
            if (i5 < i) {
                i2 = i4 + 1;
            } else if (i5 <= i) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return i2 ^ -1;
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return zzHA();
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zztg)) {
            return false;
        }
        zztg com_google_android_gms_internal_zztg = (zztg) o;
        if (size() != com_google_android_gms_internal_zztg.size()) {
            return false;
        }
        return zza(this.zzbpV, com_google_android_gms_internal_zztg.zzbpV, this.mSize) && zza(this.zzbpW, com_google_android_gms_internal_zztg.zzbpW, this.mSize);
    }

    public int hashCode() {
        if (this.zzbpU) {
            gc();
        }
        int i = 17;
        for (int i2 = 0; i2 < this.mSize; i2++) {
            i = (((i * 31) + this.zzbpV[i2]) * 31) + this.zzbpW[i2].hashCode();
        }
        return i;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    int size() {
        if (this.zzbpU) {
            gc();
        }
        return this.mSize;
    }

    public final zztg zzHA() {
        int i = 0;
        int size = size();
        zztg com_google_android_gms_internal_zztg = new zztg(size);
        System.arraycopy(this.zzbpV, 0, com_google_android_gms_internal_zztg.zzbpV, 0, size);
        while (i < size) {
            if (this.zzbpW[i] != null) {
                com_google_android_gms_internal_zztg.zzbpW[i] = this.zzbpW[i].zzHB();
            }
            i++;
        }
        com_google_android_gms_internal_zztg.mSize = size;
        return com_google_android_gms_internal_zztg;
    }

    void zza(int i, zzth com_google_android_gms_internal_zzth) {
        int zzmE = zzmE(i);
        if (zzmE >= 0) {
            this.zzbpW[zzmE] = com_google_android_gms_internal_zzth;
            return;
        }
        zzmE ^= -1;
        if (zzmE >= this.mSize || this.zzbpW[zzmE] != zzbpT) {
            if (this.zzbpU && this.mSize >= this.zzbpV.length) {
                gc();
                zzmE = zzmE(i) ^ -1;
            }
            if (this.mSize >= this.zzbpV.length) {
                int idealIntArraySize = idealIntArraySize(this.mSize + 1);
                Object obj = new int[idealIntArraySize];
                Object obj2 = new zzth[idealIntArraySize];
                System.arraycopy(this.zzbpV, 0, obj, 0, this.zzbpV.length);
                System.arraycopy(this.zzbpW, 0, obj2, 0, this.zzbpW.length);
                this.zzbpV = obj;
                this.zzbpW = obj2;
            }
            if (this.mSize - zzmE != 0) {
                System.arraycopy(this.zzbpV, zzmE, this.zzbpV, zzmE + 1, this.mSize - zzmE);
                System.arraycopy(this.zzbpW, zzmE, this.zzbpW, zzmE + 1, this.mSize - zzmE);
            }
            this.zzbpV[zzmE] = i;
            this.zzbpW[zzmE] = com_google_android_gms_internal_zzth;
            this.mSize++;
            return;
        }
        this.zzbpV[zzmE] = i;
        this.zzbpW[zzmE] = com_google_android_gms_internal_zzth;
    }

    zzth zzmC(int i) {
        int zzmE = zzmE(i);
        return (zzmE < 0 || this.zzbpW[zzmE] == zzbpT) ? null : this.zzbpW[zzmE];
    }

    zzth zzmD(int i) {
        if (this.zzbpU) {
            gc();
        }
        return this.zzbpW[i];
    }
}
