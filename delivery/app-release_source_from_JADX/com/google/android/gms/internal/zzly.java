package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class zzly<R extends Result> extends PendingResult<R> {
    private boolean zzL;
    private volatile R zzaeT;
    private final Object zzafd = new Object();
    protected final zza<R> zzafe;
    private final ArrayList<com.google.android.gms.common.api.PendingResult.zza> zzaff = new ArrayList();
    private ResultCallback<? super R> zzafg;
    private volatile boolean zzafh;
    private boolean zzafi;
    private zzq zzafj;
    private Integer zzafk;
    private volatile zzms<R> zzafl;
    private final CountDownLatch zzpy = new CountDownLatch(1);

    public static class zza<R extends Result> extends Handler {
        public zza() {
            this(Looper.getMainLooper());
        }

        public zza(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    Pair pair = (Pair) msg.obj;
                    zzb((ResultCallback) pair.first, (Result) pair.second);
                    return;
                case 2:
                    ((zzly) msg.obj).zzy(Status.zzafa);
                    return;
                default:
                    Log.wtf("BasePendingResult", "Don't know how to handle message: " + msg.what, new Exception());
                    return;
            }
        }

        public void zza(ResultCallback<? super R> resultCallback, R r) {
            sendMessage(obtainMessage(1, new Pair(resultCallback, r)));
        }

        public void zza(zzly<R> com_google_android_gms_internal_zzly_R, long j) {
            sendMessageDelayed(obtainMessage(2, com_google_android_gms_internal_zzly_R), j);
        }

        protected void zzb(ResultCallback<? super R> resultCallback, R r) {
            try {
                resultCallback.onResult(r);
            } catch (RuntimeException e) {
                zzly.zzd(r);
                throw e;
            }
        }

        public void zzoS() {
            removeMessages(2);
        }
    }

    @Deprecated
    protected zzly(Looper looper) {
        this.zzafe = new zza(looper);
    }

    protected zzly(GoogleApiClient googleApiClient) {
        this.zzafe = new zza(googleApiClient != null ? googleApiClient.getLooper() : Looper.getMainLooper());
    }

    private R get() {
        R r;
        boolean z = true;
        synchronized (this.zzafd) {
            if (this.zzafh) {
                z = false;
            }
            zzx.zza(z, (Object) "Result has already been consumed.");
            zzx.zza(isReady(), (Object) "Result is not ready.");
            r = this.zzaeT;
            this.zzaeT = null;
            this.zzafg = null;
            this.zzafh = true;
        }
        zzoR();
        return r;
    }

    private void zzc(R r) {
        this.zzaeT = r;
        this.zzafj = null;
        this.zzpy.countDown();
        Status status = this.zzaeT.getStatus();
        if (this.zzafg != null) {
            this.zzafe.zzoS();
            if (!this.zzL) {
                this.zzafe.zza(this.zzafg, get());
            }
        }
        Iterator it = this.zzaff.iterator();
        while (it.hasNext()) {
            ((com.google.android.gms.common.api.PendingResult.zza) it.next()).zzu(status);
        }
        this.zzaff.clear();
    }

    public static void zzd(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (Throwable e) {
                Log.w("BasePendingResult", "Unable to release " + result, e);
            }
        }
    }

    public final R await() {
        boolean z = true;
        zzx.zza(Looper.myLooper() != Looper.getMainLooper(), (Object) "await must not be called on the UI thread");
        zzx.zza(!this.zzafh, (Object) "Result has already been consumed");
        if (this.zzafl != null) {
            z = false;
        }
        zzx.zza(z, (Object) "Cannot await if then() has been called.");
        try {
            this.zzpy.await();
        } catch (InterruptedException e) {
            zzy(Status.zzaeY);
        }
        zzx.zza(isReady(), (Object) "Result is not ready.");
        return get();
    }

    public final R await(long time, TimeUnit units) {
        boolean z = true;
        boolean z2 = time <= 0 || Looper.myLooper() != Looper.getMainLooper();
        zzx.zza(z2, (Object) "await must not be called on the UI thread when time is greater than zero.");
        zzx.zza(!this.zzafh, (Object) "Result has already been consumed.");
        if (this.zzafl != null) {
            z = false;
        }
        zzx.zza(z, (Object) "Cannot await if then() has been called.");
        try {
            if (!this.zzpy.await(time, units)) {
                zzy(Status.zzafa);
            }
        } catch (InterruptedException e) {
            zzy(Status.zzaeY);
        }
        zzx.zza(isReady(), (Object) "Result is not ready.");
        return get();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void cancel() {
        /*
        r2 = this;
        r1 = r2.zzafd;
        monitor-enter(r1);
        r0 = r2.zzL;	 Catch:{ all -> 0x002c }
        if (r0 != 0) goto L_0x000b;
    L_0x0007:
        r0 = r2.zzafh;	 Catch:{ all -> 0x002c }
        if (r0 == 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r1);	 Catch:{ all -> 0x002c }
    L_0x000c:
        return;
    L_0x000d:
        r0 = r2.zzafj;	 Catch:{ all -> 0x002c }
        if (r0 == 0) goto L_0x0016;
    L_0x0011:
        r0 = r2.zzafj;	 Catch:{ RemoteException -> 0x002f }
        r0.cancel();	 Catch:{ RemoteException -> 0x002f }
    L_0x0016:
        r0 = r2.zzaeT;	 Catch:{ all -> 0x002c }
        zzd(r0);	 Catch:{ all -> 0x002c }
        r0 = 0;
        r2.zzafg = r0;	 Catch:{ all -> 0x002c }
        r0 = 1;
        r2.zzL = r0;	 Catch:{ all -> 0x002c }
        r0 = com.google.android.gms.common.api.Status.zzafb;	 Catch:{ all -> 0x002c }
        r0 = r2.zzc(r0);	 Catch:{ all -> 0x002c }
        r2.zzc(r0);	 Catch:{ all -> 0x002c }
        monitor-exit(r1);	 Catch:{ all -> 0x002c }
        goto L_0x000c;
    L_0x002c:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x002c }
        throw r0;
    L_0x002f:
        r0 = move-exception;
        goto L_0x0016;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzly.cancel():void");
    }

    public boolean isCanceled() {
        boolean z;
        synchronized (this.zzafd) {
            z = this.zzL;
        }
        return z;
    }

    public final boolean isReady() {
        return this.zzpy.getCount() == 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setResultCallback(com.google.android.gms.common.api.ResultCallback<? super R> r5) {
        /*
        r4 = this;
        r1 = 1;
        r2 = 0;
        r0 = r4.zzafh;
        if (r0 != 0) goto L_0x0020;
    L_0x0006:
        r0 = r1;
    L_0x0007:
        r3 = "Result has already been consumed.";
        com.google.android.gms.common.internal.zzx.zza(r0, r3);
        r3 = r4.zzafd;
        monitor-enter(r3);
        r0 = r4.zzafl;	 Catch:{ all -> 0x0035 }
        if (r0 != 0) goto L_0x0022;
    L_0x0013:
        r0 = "Cannot set callbacks if then() has been called.";
        com.google.android.gms.common.internal.zzx.zza(r1, r0);	 Catch:{ all -> 0x0035 }
        r0 = r4.isCanceled();	 Catch:{ all -> 0x0035 }
        if (r0 == 0) goto L_0x0024;
    L_0x001e:
        monitor-exit(r3);	 Catch:{ all -> 0x0035 }
    L_0x001f:
        return;
    L_0x0020:
        r0 = r2;
        goto L_0x0007;
    L_0x0022:
        r1 = r2;
        goto L_0x0013;
    L_0x0024:
        r0 = r4.isReady();	 Catch:{ all -> 0x0035 }
        if (r0 == 0) goto L_0x0038;
    L_0x002a:
        r0 = r4.zzafe;	 Catch:{ all -> 0x0035 }
        r1 = r4.get();	 Catch:{ all -> 0x0035 }
        r0.zza(r5, r1);	 Catch:{ all -> 0x0035 }
    L_0x0033:
        monitor-exit(r3);	 Catch:{ all -> 0x0035 }
        goto L_0x001f;
    L_0x0035:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0035 }
        throw r0;
    L_0x0038:
        r4.zzafg = r5;	 Catch:{ all -> 0x0035 }
        goto L_0x0033;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzly.setResultCallback(com.google.android.gms.common.api.ResultCallback):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setResultCallback(com.google.android.gms.common.api.ResultCallback<? super R> r7, long r8, java.util.concurrent.TimeUnit r10) {
        /*
        r6 = this;
        r1 = 1;
        r2 = 0;
        r0 = r6.zzafh;
        if (r0 != 0) goto L_0x0020;
    L_0x0006:
        r0 = r1;
    L_0x0007:
        r3 = "Result has already been consumed.";
        com.google.android.gms.common.internal.zzx.zza(r0, r3);
        r3 = r6.zzafd;
        monitor-enter(r3);
        r0 = r6.zzafl;	 Catch:{ all -> 0x0035 }
        if (r0 != 0) goto L_0x0022;
    L_0x0013:
        r0 = "Cannot set callbacks if then() has been called.";
        com.google.android.gms.common.internal.zzx.zza(r1, r0);	 Catch:{ all -> 0x0035 }
        r0 = r6.isCanceled();	 Catch:{ all -> 0x0035 }
        if (r0 == 0) goto L_0x0024;
    L_0x001e:
        monitor-exit(r3);	 Catch:{ all -> 0x0035 }
    L_0x001f:
        return;
    L_0x0020:
        r0 = r2;
        goto L_0x0007;
    L_0x0022:
        r1 = r2;
        goto L_0x0013;
    L_0x0024:
        r0 = r6.isReady();	 Catch:{ all -> 0x0035 }
        if (r0 == 0) goto L_0x0038;
    L_0x002a:
        r0 = r6.zzafe;	 Catch:{ all -> 0x0035 }
        r1 = r6.get();	 Catch:{ all -> 0x0035 }
        r0.zza(r7, r1);	 Catch:{ all -> 0x0035 }
    L_0x0033:
        monitor-exit(r3);	 Catch:{ all -> 0x0035 }
        goto L_0x001f;
    L_0x0035:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0035 }
        throw r0;
    L_0x0038:
        r6.zzafg = r7;	 Catch:{ all -> 0x0035 }
        r0 = r6.zzafe;	 Catch:{ all -> 0x0035 }
        r4 = r10.toMillis(r8);	 Catch:{ all -> 0x0035 }
        r0.zza(r6, r4);	 Catch:{ all -> 0x0035 }
        goto L_0x0033;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzly.setResultCallback(com.google.android.gms.common.api.ResultCallback, long, java.util.concurrent.TimeUnit):void");
    }

    public final void zza(com.google.android.gms.common.api.PendingResult.zza com_google_android_gms_common_api_PendingResult_zza) {
        boolean z = true;
        zzx.zza(!this.zzafh, (Object) "Result has already been consumed.");
        if (com_google_android_gms_common_api_PendingResult_zza == null) {
            z = false;
        }
        zzx.zzb(z, (Object) "Callback cannot be null.");
        synchronized (this.zzafd) {
            if (isReady()) {
                com_google_android_gms_common_api_PendingResult_zza.zzu(this.zzaeT.getStatus());
            } else {
                this.zzaff.add(com_google_android_gms_common_api_PendingResult_zza);
            }
        }
    }

    protected final void zza(zzq com_google_android_gms_common_internal_zzq) {
        synchronized (this.zzafd) {
            this.zzafj = com_google_android_gms_common_internal_zzq;
        }
    }

    public final void zzb(R r) {
        boolean z = true;
        synchronized (this.zzafd) {
            if (this.zzafi || this.zzL) {
                zzd(r);
                return;
            }
            zzx.zza(!isReady(), (Object) "Results have already been set");
            if (this.zzafh) {
                z = false;
            }
            zzx.zza(z, (Object) "Result has already been consumed");
            zzc((Result) r);
        }
    }

    protected abstract R zzc(Status status);

    public Integer zzoL() {
        return this.zzafk;
    }

    protected void zzoR() {
    }

    public final void zzy(Status status) {
        synchronized (this.zzafd) {
            if (!isReady()) {
                zzb(zzc(status));
                this.zzafi = true;
            }
        }
    }
}
