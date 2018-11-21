package com.google.android.gms.internal;

import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import java.security.MessageDigest;

@zzha
public class zzbp extends zzbm {
    private MessageDigest zztl;

    byte[] zza(String[] strArr) {
        byte[] bArr = new byte[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            bArr[i] = zzk(zzbo.zzC(strArr[i]));
        }
        return bArr;
    }

    byte zzk(int i) {
        return (byte) ((((i & MotionEventCompat.ACTION_MASK) ^ ((MotionEventCompat.ACTION_POINTER_INDEX_MASK & i) >> 8)) ^ ((16711680 & i) >> 16)) ^ ((ViewCompat.MEASURED_STATE_MASK & i) >> 24));
    }

    public byte[] zzz(String str) {
        byte[] zza = zza(str.split(" "));
        this.zztl = zzcG();
        synchronized (this.zzpK) {
            if (this.zztl == null) {
                zza = new byte[0];
            } else {
                this.zztl.reset();
                this.zztl.update(zza);
                Object digest = this.zztl.digest();
                int i = 4;
                if (digest.length <= 4) {
                    i = digest.length;
                }
                zza = new byte[i];
                System.arraycopy(digest, 0, zza, 0, zza.length);
            }
        }
        return zza;
    }
}
