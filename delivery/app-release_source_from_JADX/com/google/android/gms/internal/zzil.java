package com.google.android.gms.internal;

import java.util.concurrent.Future;

@zzha
public abstract class zzil implements zzir<Future> {
    private volatile Thread zzKt;
    private boolean zzKu;
    private final Runnable zzx;

    class C03301 implements Runnable {
        final /* synthetic */ zzil zzKv;

        C03301(zzil com_google_android_gms_internal_zzil) {
            this.zzKv = com_google_android_gms_internal_zzil;
        }

        public final void run() {
            this.zzKv.zzKt = Thread.currentThread();
            this.zzKv.zzbp();
        }
    }

    public zzil() {
        this.zzx = new C03301(this);
        this.zzKu = false;
    }

    public zzil(boolean z) {
        this.zzx = new C03301(this);
        this.zzKu = z;
    }

    public final void cancel() {
        onStop();
        if (this.zzKt != null) {
            this.zzKt.interrupt();
        }
    }

    public abstract void onStop();

    public abstract void zzbp();

    public /* synthetic */ Object zzfR() {
        return zzgX();
    }

    public final Future zzgX() {
        return this.zzKu ? zzio.zza(1, this.zzx) : zzio.zza(this.zzx);
    }
}
