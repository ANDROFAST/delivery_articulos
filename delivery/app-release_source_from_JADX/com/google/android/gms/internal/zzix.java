package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzp;

@zzha
public class zzix {
    private long zzLv;
    private long zzLw = Long.MIN_VALUE;
    private Object zzpK = new Object();

    public zzix(long j) {
        this.zzLv = j;
    }

    public boolean tryAcquire() {
        boolean z;
        synchronized (this.zzpK) {
            long elapsedRealtime = zzp.zzbB().elapsedRealtime();
            if (this.zzLw + this.zzLv > elapsedRealtime) {
                z = false;
            } else {
                this.zzLw = elapsedRealtime;
                z = true;
            }
        }
        return z;
    }
}
