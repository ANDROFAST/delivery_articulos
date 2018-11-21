package com.google.android.gms.analytics.internal;

public class zzad {
    private final String zzRA;
    private final long zzRv;
    private final int zzRw;
    private double zzRx;
    private long zzRy;
    private final Object zzRz;

    public zzad(int i, long j, String str) {
        this.zzRz = new Object();
        this.zzRw = i;
        this.zzRx = (double) this.zzRw;
        this.zzRv = j;
        this.zzRA = str;
    }

    public zzad(String str) {
        this(60, 2000, str);
    }

    public boolean zzlf() {
        boolean z;
        synchronized (this.zzRz) {
            long currentTimeMillis = System.currentTimeMillis();
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
                zzae.zzaH("Excessive " + this.zzRA + " detected; call ignored.");
                z = false;
            }
        }
        return z;
    }
}
