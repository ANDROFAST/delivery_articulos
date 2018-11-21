package com.google.android.gms.tagmanager;

class zzcs implements zzcd {
    private final long zzRv;
    private final int zzRw;
    private double zzRx;
    private final Object zzRz;
    private long zzbfH;

    public zzcs() {
        this(60, 2000);
    }

    public zzcs(int i, long j) {
        this.zzRz = new Object();
        this.zzRw = i;
        this.zzRx = (double) this.zzRw;
        this.zzRv = j;
    }

    public boolean zzlf() {
        boolean z;
        synchronized (this.zzRz) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.zzRx < ((double) this.zzRw)) {
                double d = ((double) (currentTimeMillis - this.zzbfH)) / ((double) this.zzRv);
                if (d > 0.0d) {
                    this.zzRx = Math.min((double) this.zzRw, d + this.zzRx);
                }
            }
            this.zzbfH = currentTimeMillis;
            if (this.zzRx >= 1.0d) {
                this.zzRx -= 1.0d;
                z = true;
            } else {
                zzbg.zzaH("No more tokens available.");
                z = false;
            }
        }
        return z;
    }
}
