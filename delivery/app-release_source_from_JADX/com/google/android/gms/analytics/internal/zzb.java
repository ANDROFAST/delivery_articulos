package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.AnalyticsReceiver;
import com.google.android.gms.analytics.AnalyticsService;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.measurement.zzg;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class zzb extends zzd {
    private final zzl zzOH;

    class C01895 implements Runnable {
        final /* synthetic */ zzb zzOJ;

        C01895(zzb com_google_android_gms_analytics_internal_zzb) {
            this.zzOJ = com_google_android_gms_analytics_internal_zzb;
        }

        public void run() {
            this.zzOJ.zzOH.zziK();
        }
    }

    class C01917 implements Callable<Void> {
        final /* synthetic */ zzb zzOJ;

        C01917(zzb com_google_android_gms_analytics_internal_zzb) {
            this.zzOJ = com_google_android_gms_analytics_internal_zzb;
        }

        public /* synthetic */ Object call() throws Exception {
            return zzdm();
        }

        public Void zzdm() throws Exception {
            this.zzOJ.zzOH.zzjJ();
            return null;
        }
    }

    public zzb(zzf com_google_android_gms_analytics_internal_zzf, zzg com_google_android_gms_analytics_internal_zzg) {
        super(com_google_android_gms_analytics_internal_zzf);
        zzx.zzy(com_google_android_gms_analytics_internal_zzg);
        this.zzOH = com_google_android_gms_analytics_internal_zzg.zzj(com_google_android_gms_analytics_internal_zzf);
    }

    void onServiceConnected() {
        zziS();
        this.zzOH.onServiceConnected();
    }

    public void setLocalDispatchPeriod(final int dispatchPeriodInSeconds) {
        zzje();
        zzb("setLocalDispatchPeriod (sec)", Integer.valueOf(dispatchPeriodInSeconds));
        zziW().zzf(new Runnable(this) {
            final /* synthetic */ zzb zzOJ;

            public void run() {
                this.zzOJ.zzOH.zzs(((long) dispatchPeriodInSeconds) * 1000);
            }
        });
    }

    public void start() {
        this.zzOH.start();
    }

    public void zzJ(final boolean z) {
        zza("Network connectivity status changed", Boolean.valueOf(z));
        zziW().zzf(new Runnable(this) {
            final /* synthetic */ zzb zzOJ;

            public void run() {
                this.zzOJ.zzOH.zzJ(z);
            }
        });
    }

    public long zza(zzh com_google_android_gms_analytics_internal_zzh) {
        zzje();
        zzx.zzy(com_google_android_gms_analytics_internal_zzh);
        zziS();
        long zza = this.zzOH.zza(com_google_android_gms_analytics_internal_zzh, true);
        if (zza == 0) {
            this.zzOH.zzc(com_google_android_gms_analytics_internal_zzh);
        }
        return zza;
    }

    public void zza(final zzab com_google_android_gms_analytics_internal_zzab) {
        zzx.zzy(com_google_android_gms_analytics_internal_zzab);
        zzje();
        zzb("Hit delivery requested", com_google_android_gms_analytics_internal_zzab);
        zziW().zzf(new Runnable(this) {
            final /* synthetic */ zzb zzOJ;

            public void run() {
                this.zzOJ.zzOH.zza(com_google_android_gms_analytics_internal_zzab);
            }
        });
    }

    public void zza(final zzw com_google_android_gms_analytics_internal_zzw) {
        zzje();
        zziW().zzf(new Runnable(this) {
            final /* synthetic */ zzb zzOJ;

            public void run() {
                this.zzOJ.zzOH.zzb(com_google_android_gms_analytics_internal_zzw);
            }
        });
    }

    public void zza(final String str, final Runnable runnable) {
        zzx.zzh(str, "campaign param can't be empty");
        zziW().zzf(new Runnable(this) {
            final /* synthetic */ zzb zzOJ;

            public void run() {
                this.zzOJ.zzOH.zzbi(str);
                if (runnable != null) {
                    runnable.run();
                }
            }
        });
    }

    public void zziK() {
        zzje();
        zziR();
        zziW().zzf(new C01895(this));
    }

    public void zziL() {
        zzje();
        Context context = getContext();
        if (AnalyticsReceiver.zzX(context) && AnalyticsService.zzY(context)) {
            Intent intent = new Intent(context, AnalyticsService.class);
            intent.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            context.startService(intent);
            return;
        }
        zza(null);
    }

    public boolean zziM() {
        zzje();
        try {
            zziW().zzc(new C01917(this)).get(4, TimeUnit.SECONDS);
            return true;
        } catch (InterruptedException e) {
            zzd("syncDispatchLocalHits interrupted", e);
            return false;
        } catch (ExecutionException e2) {
            zze("syncDispatchLocalHits failed", e2);
            return false;
        } catch (TimeoutException e3) {
            zzd("syncDispatchLocalHits timed out", e3);
            return false;
        }
    }

    public void zziN() {
        zzje();
        zzg.zziS();
        this.zzOH.zziN();
    }

    public void zziO() {
        zzba("Radio powered up");
        zziL();
    }

    void zziP() {
        zziS();
        this.zzOH.zziP();
    }

    protected void zzir() {
        this.zzOH.zza();
    }
}
