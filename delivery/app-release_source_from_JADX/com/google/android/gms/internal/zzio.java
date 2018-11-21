package com.google.android.gms.internal;

import android.os.Process;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@zzha
public final class zzio {
    private static final ExecutorService zzKA = Executors.newFixedThreadPool(10, zzay("Default"));
    private static final ExecutorService zzKB = Executors.newFixedThreadPool(5, zzay("Loader"));

    public static zzje<Void> zza(int i, final Runnable runnable) {
        return i == 1 ? zza(zzKB, new Callable<Void>() {
            public /* synthetic */ Object call() throws Exception {
                return zzdm();
            }

            public Void zzdm() {
                runnable.run();
                return null;
            }
        }) : zza(zzKA, new Callable<Void>() {
            public /* synthetic */ Object call() throws Exception {
                return zzdm();
            }

            public Void zzdm() {
                runnable.run();
                return null;
            }
        });
    }

    public static zzje<Void> zza(Runnable runnable) {
        return zza(0, runnable);
    }

    public static <T> zzje<T> zza(Callable<T> callable) {
        return zza(zzKA, (Callable) callable);
    }

    public static <T> zzje<T> zza(ExecutorService executorService, final Callable<T> callable) {
        final Object com_google_android_gms_internal_zzjb = new zzjb();
        try {
            final Future submit = executorService.submit(new Runnable() {
                public void run() {
                    try {
                        Process.setThreadPriority(10);
                        com_google_android_gms_internal_zzjb.zzf(callable.call());
                    } catch (Throwable e) {
                        zzp.zzbA().zzb(e, true);
                        com_google_android_gms_internal_zzjb.cancel(true);
                    }
                }
            });
            com_google_android_gms_internal_zzjb.zzc(new Runnable() {
                public void run() {
                    if (com_google_android_gms_internal_zzjb.isCancelled()) {
                        submit.cancel(true);
                    }
                }
            });
        } catch (Throwable e) {
            zzb.zzd("Thread execution is rejected.", e);
            com_google_android_gms_internal_zzjb.cancel(true);
        }
        return com_google_android_gms_internal_zzjb;
    }

    private static ThreadFactory zzay(final String str) {
        return new ThreadFactory() {
            private final AtomicInteger zzKG = new AtomicInteger(1);

            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "AdWorker(" + str + ") #" + this.zzKG.getAndIncrement());
            }
        };
    }
}
