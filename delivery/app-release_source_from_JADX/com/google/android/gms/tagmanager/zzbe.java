package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zznl;

class zzbe implements zzcd {
    private final String zzRA;
    private final long zzRv;
    private final int zzRw;
    private double zzRx;
    private long zzRy;
    private final Object zzRz = new Object();
    private final long zzbem;
    private final zznl zzqD;

    public zzbe(int i, long j, long j2, String str, zznl com_google_android_gms_internal_zznl) {
        this.zzRw = i;
        this.zzRx = (double) this.zzRw;
        this.zzRv = j;
        this.zzbem = j2;
        this.zzRA = str;
        this.zzqD = com_google_android_gms_internal_zznl;
    }

    public boolean zzlf() {
        boolean z = false;
        synchronized (this.zzRz) {
            long currentTimeMillis = this.zzqD.currentTimeMillis();
            if (currentTimeMillis - this.zzRy < this.zzbem) {
                zzbg.zzaH("Excessive " + this.zzRA + " detected; call ignored.");
            } else {
                if (this.zzRx < ((double) this.zzRw)) {
                    double d = ((double) (currentTimeMillis - this.zzRy)) / ((double) this.zzRv);
                    if (d > 0.0d) {
                        this.zzRx = Math.min((double) this.zzRw, d + this.zzRx);
                    }
                }
                this.zzRy = currentTimeMillis;
                if (this.zzRx >= 1.0d) {
                    this.zzRx -= 1.0d;
                    z = true;
                } else {
                    zzbg.zzaH("Excessive " + this.zzRA + " detected; call ignored.");
                }
            }
        }
        return z;
    }
}
