package com.google.android.gms.analytics.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.internal.zzx;

abstract class zzt {
    private static volatile Handler zzQi;
    private final zzf zzOP;
    private volatile long zzQj;
    private boolean zzQk;
    private final Runnable zzx = new C01991(this);

    class C01991 implements Runnable {
        final /* synthetic */ zzt zzQl;

        C01991(zzt com_google_android_gms_analytics_internal_zzt) {
            this.zzQl = com_google_android_gms_analytics_internal_zzt;
        }

        public void run() {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                this.zzQl.zzOP.zziW().zzf(this);
                return;
            }
            boolean zzbr = this.zzQl.zzbr();
            this.zzQl.zzQj = 0;
            if (zzbr && !this.zzQl.zzQk) {
                this.zzQl.run();
            }
        }
    }

    zzt(zzf com_google_android_gms_analytics_internal_zzf) {
        zzx.zzy(com_google_android_gms_analytics_internal_zzf);
        this.zzOP = com_google_android_gms_analytics_internal_zzf;
    }

    private Handler getHandler() {
        if (zzQi != null) {
            return zzQi;
        }
        Handler handler;
        synchronized (zzt.class) {
            if (zzQi == null) {
                zzQi = new Handler(this.zzOP.getContext().getMainLooper());
            }
            handler = zzQi;
        }
        return handler;
    }

    public void cancel() {
        this.zzQj = 0;
        getHandler().removeCallbacks(this.zzx);
    }

    public abstract void run();

    public boolean zzbr() {
        return this.zzQj != 0;
    }

    public long zzkH() {
        return this.zzQj == 0 ? 0 : Math.abs(this.zzOP.zziT().currentTimeMillis() - this.zzQj);
    }

    public void zzt(long j) {
        cancel();
        if (j >= 0) {
            this.zzQj = this.zzOP.zziT().currentTimeMillis();
            if (!getHandler().postDelayed(this.zzx, j)) {
                this.zzOP.zziU().zze("Failed to schedule delayed post. time", Long.valueOf(j));
            }
        }
    }

    public void zzu(long j) {
        long j2 = 0;
        if (!zzbr()) {
            return;
        }
        if (j < 0) {
            cancel();
            return;
        }
        long abs = j - Math.abs(this.zzOP.zziT().currentTimeMillis() - this.zzQj);
        if (abs >= 0) {
            j2 = abs;
        }
        getHandler().removeCallbacks(this.zzx);
        if (!getHandler().postDelayed(this.zzx, j2)) {
            this.zzOP.zziU().zze("Failed to adjust delayed post. time", Long.valueOf(j2));
        }
    }
}
