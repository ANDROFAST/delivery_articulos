package com.google.android.gms.measurement;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzqh;
import com.google.android.gms.internal.zzqj;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzg {
    private static volatile zzg zzaRx;
    private final Context mContext;
    private volatile zzqh zzPD;
    private final zza zzaRA = new zza(this);
    private UncaughtExceptionHandler zzaRB;
    private final List<zzh> zzaRy = new CopyOnWriteArrayList();
    private final zzb zzaRz = new zzb();

    private class zza extends ThreadPoolExecutor {
        final /* synthetic */ zzg zzaRD;

        public zza(zzg com_google_android_gms_measurement_zzg) {
            this.zzaRD = com_google_android_gms_measurement_zzg;
            super(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
            setThreadFactory(new zzb());
        }

        protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T value) {
            return new FutureTask<T>(this, runnable, value) {
                final /* synthetic */ zza zzaRE;

                protected void setException(Throwable error) {
                    UncaughtExceptionHandler zzb = this.zzaRE.zzaRD.zzaRB;
                    if (zzb != null) {
                        zzb.uncaughtException(Thread.currentThread(), error);
                    } else if (Log.isLoggable("GAv4", 6)) {
                        Log.e("GAv4", "MeasurementExecutor: job failed with " + error);
                    }
                    super.setException(error);
                }
            };
        }
    }

    private static class zzb implements ThreadFactory {
        private static final AtomicInteger zzaRF = new AtomicInteger();

        private zzb() {
        }

        public Thread newThread(Runnable target) {
            return new zzc(target, "measurement-" + zzaRF.incrementAndGet());
        }
    }

    private static class zzc extends Thread {
        zzc(Runnable runnable, String str) {
            super(runnable, str);
        }

        public void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    zzg(Context context) {
        Context applicationContext = context.getApplicationContext();
        zzx.zzy(applicationContext);
        this.mContext = applicationContext;
    }

    public static zzg zzaT(Context context) {
        zzx.zzy(context);
        if (zzaRx == null) {
            synchronized (zzg.class) {
                if (zzaRx == null) {
                    zzaRx = new zzg(context);
                }
            }
        }
        return zzaRx;
    }

    private void zzb(zzc com_google_android_gms_measurement_zzc) {
        zzx.zzcy("deliver should be called from worker thread");
        zzx.zzb(com_google_android_gms_measurement_zzc.zzzJ(), (Object) "Measurement must be submitted");
        List<zzi> zzzG = com_google_android_gms_measurement_zzc.zzzG();
        if (!zzzG.isEmpty()) {
            Set hashSet = new HashSet();
            for (zzi com_google_android_gms_measurement_zzi : zzzG) {
                Uri zzii = com_google_android_gms_measurement_zzi.zzii();
                if (!hashSet.contains(zzii)) {
                    hashSet.add(zzii);
                    com_google_android_gms_measurement_zzi.zzb(com_google_android_gms_measurement_zzc);
                }
            }
        }
    }

    public static void zziS() {
        if (!(Thread.currentThread() instanceof zzc)) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public void zza(UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.zzaRB = uncaughtExceptionHandler;
    }

    public <V> Future<V> zzc(Callable<V> callable) {
        zzx.zzy(callable);
        if (!(Thread.currentThread() instanceof zzc)) {
            return this.zzaRA.submit(callable);
        }
        Future futureTask = new FutureTask(callable);
        futureTask.run();
        return futureTask;
    }

    void zze(zzc com_google_android_gms_measurement_zzc) {
        if (com_google_android_gms_measurement_zzc.zzzN()) {
            throw new IllegalStateException("Measurement prototype can't be submitted");
        } else if (com_google_android_gms_measurement_zzc.zzzJ()) {
            throw new IllegalStateException("Measurement can only be submitted once");
        } else {
            final zzc zzzE = com_google_android_gms_measurement_zzc.zzzE();
            zzzE.zzzK();
            this.zzaRA.execute(new Runnable(this) {
                final /* synthetic */ zzg zzaRD;

                public void run() {
                    zzzE.zzzL().zza(zzzE);
                    for (zzh zza : this.zzaRD.zzaRy) {
                        zza.zza(zzzE);
                    }
                    this.zzaRD.zzb(zzzE);
                }
            });
        }
    }

    public void zzf(Runnable runnable) {
        zzx.zzy(runnable);
        this.zzaRA.submit(runnable);
    }

    public zzqh zzzR() {
        if (this.zzPD == null) {
            synchronized (this) {
                if (this.zzPD == null) {
                    zzqh com_google_android_gms_internal_zzqh = new zzqh();
                    PackageManager packageManager = this.mContext.getPackageManager();
                    String packageName = this.mContext.getPackageName();
                    com_google_android_gms_internal_zzqh.setAppId(packageName);
                    com_google_android_gms_internal_zzqh.setAppInstallerId(packageManager.getInstallerPackageName(packageName));
                    String str = null;
                    try {
                        PackageInfo packageInfo = packageManager.getPackageInfo(this.mContext.getPackageName(), 0);
                        if (packageInfo != null) {
                            CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                            if (!TextUtils.isEmpty(applicationLabel)) {
                                packageName = applicationLabel.toString();
                            }
                            str = packageInfo.versionName;
                        }
                    } catch (NameNotFoundException e) {
                        Log.e("GAv4", "Error retrieving package info: appName set to " + packageName);
                    }
                    com_google_android_gms_internal_zzqh.setAppName(packageName);
                    com_google_android_gms_internal_zzqh.setAppVersion(str);
                    this.zzPD = com_google_android_gms_internal_zzqh;
                }
            }
        }
        return this.zzPD;
    }

    public zzqj zzzS() {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        zzqj com_google_android_gms_internal_zzqj = new zzqj();
        com_google_android_gms_internal_zzqj.setLanguage(zzam.zza(Locale.getDefault()));
        com_google_android_gms_internal_zzqj.zzip(displayMetrics.widthPixels);
        com_google_android_gms_internal_zzqj.zziq(displayMetrics.heightPixels);
        return com_google_android_gms_internal_zzqj;
    }
}
