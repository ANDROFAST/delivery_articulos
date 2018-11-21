package com.google.android.gms.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzx;

@zzha
public class zziv {
    private Handler mHandler = null;
    private HandlerThread zzLs = null;
    private int zzLt = 0;
    private final Object zzpK = new Object();

    class C03421 implements Runnable {
        final /* synthetic */ zziv zzLu;

        C03421(zziv com_google_android_gms_internal_zziv) {
            this.zzLu = com_google_android_gms_internal_zziv;
        }

        public void run() {
            synchronized (this.zzLu.zzpK) {
                zzb.m7v("Suspending the looper thread");
                while (this.zzLu.zzLt == 0) {
                    try {
                        this.zzLu.zzpK.wait();
                        zzb.m7v("Looper thread resumed");
                    } catch (InterruptedException e) {
                        zzb.m7v("Looper thread interrupted.");
                    }
                }
            }
        }
    }

    public Looper zzhk() {
        Looper looper;
        synchronized (this.zzpK) {
            if (this.zzLt != 0) {
                zzx.zzb(this.zzLs, (Object) "Invalid state: mHandlerThread should already been initialized.");
            } else if (this.zzLs == null) {
                zzb.m7v("Starting the looper thread.");
                this.zzLs = new HandlerThread("LooperProvider");
                this.zzLs.start();
                this.mHandler = new Handler(this.zzLs.getLooper());
                zzb.m7v("Looper thread started.");
            } else {
                zzb.m7v("Resuming the looper thread");
                this.zzpK.notifyAll();
            }
            this.zzLt++;
            looper = this.zzLs.getLooper();
        }
        return looper;
    }

    public void zzhl() {
        synchronized (this.zzpK) {
            zzx.zzb(this.zzLt > 0, (Object) "Invalid state: release() called more times than expected.");
            int i = this.zzLt - 1;
            this.zzLt = i;
            if (i == 0) {
                this.mHandler.post(new C03421(this));
            }
        }
    }
}
