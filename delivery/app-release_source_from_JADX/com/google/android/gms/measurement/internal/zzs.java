package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznl;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

public class zzs extends zzw {
    private zzc zzaTT;
    private zzc zzaTU;
    private final BlockingQueue<FutureTask<?>> zzaTV = new LinkedBlockingQueue();
    private final BlockingQueue<FutureTask<?>> zzaTW = new LinkedBlockingQueue();
    private final UncaughtExceptionHandler zzaTX = new zzb(this, "Thread death: Uncaught exception on worker thread");
    private final UncaughtExceptionHandler zzaTY = new zzb(this, "Thread death: Uncaught exception on network thread");
    private final Object zzaTZ = new Object();
    private final Semaphore zzaUa = new Semaphore(2);
    private volatile boolean zzaUb;

    private final class zza<V> extends FutureTask<V> {
        private final String zzaUc;
        final /* synthetic */ zzs zzaUd;

        zza(zzs com_google_android_gms_measurement_internal_zzs, Runnable runnable, String str) {
            this.zzaUd = com_google_android_gms_measurement_internal_zzs;
            super(runnable, null);
            zzx.zzy(str);
            this.zzaUc = str;
        }

        protected void setException(Throwable error) {
            this.zzaUd.zzzz().zzBl().zzj(this.zzaUc, error);
            super.setException(error);
        }
    }

    private final class zzb implements UncaughtExceptionHandler {
        private final String zzaUc;
        final /* synthetic */ zzs zzaUd;

        public zzb(zzs com_google_android_gms_measurement_internal_zzs, String str) {
            this.zzaUd = com_google_android_gms_measurement_internal_zzs;
            zzx.zzy(str);
            this.zzaUc = str;
        }

        public synchronized void uncaughtException(Thread thread, Throwable error) {
            this.zzaUd.zzzz().zzBl().zzj(this.zzaUc, error);
        }
    }

    private final class zzc extends Thread {
        final /* synthetic */ zzs zzaUd;
        private final Object zzaUe = new Object();
        private final BlockingQueue<FutureTask<?>> zzaUf;

        public zzc(zzs com_google_android_gms_measurement_internal_zzs, String str, BlockingQueue<FutureTask<?>> blockingQueue) {
            this.zzaUd = com_google_android_gms_measurement_internal_zzs;
            zzx.zzy(str);
            this.zzaUf = blockingQueue;
            setName(str);
        }

        private void zza(InterruptedException interruptedException) {
            this.zzaUd.zzzz().zzBm().zzj(getName() + " was interrupted", interruptedException);
        }

        public void run() {
            while (true) {
                FutureTask futureTask = (FutureTask) this.zzaUf.poll();
                if (futureTask == null) {
                    synchronized (this.zzaUe) {
                        if (this.zzaUf.peek() == null && !this.zzaUd.zzaUb) {
                            try {
                                this.zzaUe.wait(30000);
                            } catch (InterruptedException e) {
                                zza(e);
                            }
                        }
                    }
                    synchronized (this.zzaUd.zzaTZ) {
                        if (this.zzaUf.peek() == null) {
                            break;
                        }
                    }
                }
                futureTask.run();
            }
            this.zzaUd.zzaUa.release();
            this.zzaUd.zzaTZ.notifyAll();
            if (this == this.zzaUd.zzaTT) {
                this.zzaUd.zzaTT = null;
            } else if (this == this.zzaUd.zzaTU) {
                this.zzaUd.zzaTU = null;
            } else {
                this.zzaUd.zzzz().zzBl().zzez("Current scheduler thread is neither worker nor network");
            }
        }

        public void zzeQ() {
            synchronized (this.zzaUe) {
                this.zzaUe.notifyAll();
            }
        }
    }

    zzs(zzt com_google_android_gms_measurement_internal_zzt) {
        super(com_google_android_gms_measurement_internal_zzt);
    }

    private void zza(FutureTask<?> futureTask) {
        synchronized (this.zzaTZ) {
            this.zzaTV.add(futureTask);
            if (this.zzaTT == null) {
                this.zzaTT = new zzc(this, "Measurement Worker", this.zzaTV);
                this.zzaTT.setUncaughtExceptionHandler(this.zzaTX);
                this.zzaTT.start();
            } else {
                this.zzaTT.zzeQ();
            }
        }
    }

    private void zzb(FutureTask<?> futureTask) {
        synchronized (this.zzaTZ) {
            this.zzaTW.add(futureTask);
            if (this.zzaTU == null) {
                this.zzaTU = new zzc(this, "Measurement Network", this.zzaTW);
                this.zzaTU.setUncaughtExceptionHandler(this.zzaTY);
                this.zzaTU.start();
            } else {
                this.zzaTU.zzeQ();
            }
        }
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public void zzAR() {
        if (Thread.currentThread() != this.zzaTU) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    public /* bridge */ /* synthetic */ zzm zzAS() {
        return super.zzAS();
    }

    public /* bridge */ /* synthetic */ zzz zzAT() {
        return super.zzAT();
    }

    public /* bridge */ /* synthetic */ zzae zzAU() {
        return super.zzAU();
    }

    public /* bridge */ /* synthetic */ zzs zzAV() {
        return super.zzAV();
    }

    public /* bridge */ /* synthetic */ zzr zzAW() {
        return super.zzAW();
    }

    public /* bridge */ /* synthetic */ zzc zzAX() {
        return super.zzAX();
    }

    public void zzg(Runnable runnable) throws IllegalStateException {
        zzje();
        zzx.zzy(runnable);
        zza(new zza(this, runnable, "Task exception on worker thread"));
    }

    public void zzh(Runnable runnable) throws IllegalStateException {
        zzje();
        zzx.zzy(runnable);
        zzb(new zza(this, runnable, "Task exception on network thread"));
    }

    public /* bridge */ /* synthetic */ void zziR() {
        super.zziR();
    }

    public void zziS() {
        if (Thread.currentThread() != this.zzaTT) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public /* bridge */ /* synthetic */ zznl zziT() {
        return super.zziT();
    }

    protected void zzir() {
    }

    public /* bridge */ /* synthetic */ zzo zzzz() {
        return super.zzzz();
    }
}
