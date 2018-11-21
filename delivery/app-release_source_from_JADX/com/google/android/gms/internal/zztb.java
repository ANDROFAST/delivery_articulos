package com.google.android.gms.internal;

import android.support.v4.view.MotionEventCompat;

public class zztb {
    private final byte[] zzbpD = new byte[256];
    private int zzbpE;
    private int zzbpF;

    public zztb(byte[] bArr) {
        int i;
        for (i = 0; i < 256; i++) {
            this.zzbpD[i] = (byte) i;
        }
        i = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            i = ((i + this.zzbpD[i2]) + bArr[i2 % bArr.length]) & MotionEventCompat.ACTION_MASK;
            byte b = this.zzbpD[i2];
            this.zzbpD[i2] = this.zzbpD[i];
            this.zzbpD[i] = b;
        }
        this.zzbpE = 0;
        this.zzbpF = 0;
    }

    public void zzB(byte[] bArr) {
        int i = this.zzbpE;
        int i2 = this.zzbpF;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) & MotionEventCompat.ACTION_MASK;
            i2 = (i2 + this.zzbpD[i]) & MotionEventCompat.ACTION_MASK;
            byte b = this.zzbpD[i];
            this.zzbpD[i] = this.zzbpD[i2];
            this.zzbpD[i2] = b;
            bArr[i3] = (byte) (bArr[i3] ^ this.zzbpD[(this.zzbpD[i] + this.zzbpD[i2]) & MotionEventCompat.ACTION_MASK]);
        }
        this.zzbpE = i;
        this.zzbpF = i2;
    }
}
