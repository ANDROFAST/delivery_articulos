package com.google.android.gms.measurement.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.internal.zzx;

abstract class zze {
    private static volatile Handler zzQi;
    private volatile long zzQj;
    private final zzt zzaQX;
    private boolean zzaSy = true;
    private final Runnable zzx = new C03781(this);

    class C03781 implements Runnable {
        final /* synthetic */ zze zzaSz;

        C03781(zze com_google_android_gms_measurement_internal_zze) {
            this.zzaSz = com_google_android_gms_measurement_internal_zze;
        }

        public void run() {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                this.zzaSz.zzaQX.zzAV().zzg(this);
                return;
            }
            boolean zzbr = this.zzaSz.zzbr();
            this.zzaSz.zzQj = 0;
            if (zzbr && this.zzaSz.zzaSy) {
                this.zzaSz.run();
            }
        }
    }

    zze(zzt com_google_android_gms_measurement_internal_zzt) {
        zzx.zzy(com_google_android_gms_measurement_internal_zzt);
        this.zzaQX = com_google_android_gms_measurement_internal_zzt;
    }

    private Handler getHandler() {
        if (zzQi != null) {
            return zzQi;
        }
        Handler handler;
        synchronized (zze.class) {
            if (zzQi == null) {
                zzQi = new Handler(this.zzaQX.getContext().getMainLooper());
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

    public void zzt(long j) {
        cancel();
        if (j >= 0) {
            this.zzQj = this.zzaQX.zziT().currentTimeMillis();
            if (!getHandler().postDelayed(this.zzx, j)) {
                this.zzaQX.zzzz().zzBl().zzj("Failed to schedule delayed post. time", Long.valueOf(j));
            }
        }
    }
}
