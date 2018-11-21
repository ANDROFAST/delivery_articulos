package com.google.android.gms.cast.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

public abstract class zzc extends zzd {
    protected final Handler mHandler;
    protected final long zzabJ;
    protected final Runnable zzabK;
    protected boolean zzabL;

    private class zza implements Runnable {
        final /* synthetic */ zzc zzabM;

        private zza(zzc com_google_android_gms_cast_internal_zzc) {
            this.zzabM = com_google_android_gms_cast_internal_zzc;
        }

        public void run() {
            this.zzabM.zzabL = false;
            this.zzabM.zzW(this.zzabM.zzz(SystemClock.elapsedRealtime()));
        }
    }

    public zzc(String str, String str2, String str3) {
        this(str, str2, str3, 1000);
    }

    public zzc(String str, String str2, String str3, long j) {
        super(str, str2, str3);
        this.mHandler = new Handler(Looper.getMainLooper());
        this.zzabK = new zza();
        this.zzabJ = j;
        zzW(false);
    }

    protected final void zzW(boolean z) {
        if (this.zzabL != z) {
            this.zzabL = z;
            if (z) {
                this.mHandler.postDelayed(this.zzabK, this.zzabJ);
            } else {
                this.mHandler.removeCallbacks(this.zzabK);
            }
        }
    }

    public void zznN() {
        zzW(false);
    }

    protected abstract boolean zzz(long j);
}
