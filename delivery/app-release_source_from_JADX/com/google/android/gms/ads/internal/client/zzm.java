package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.internal.client.zzv.zza;
import com.google.android.gms.internal.zzha;
import java.util.Random;

@zzha
public class zzm extends zza {
    private Object zzpK = new Object();
    private final Random zzuj = new Random();
    private long zzuk;

    public zzm() {
        zzcS();
    }

    public long getValue() {
        return this.zzuk;
    }

    public void zzcS() {
        synchronized (this.zzpK) {
            int i = 3;
            long j = 0;
            while (true) {
                i--;
                if (i <= 0) {
                    break;
                }
                j = ((long) this.zzuj.nextInt()) + 2147483648L;
                if (j != this.zzuk && j != 0) {
                    break;
                }
            }
            this.zzuk = j;
        }
    }
}
