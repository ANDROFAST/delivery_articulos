package com.google.android.gms.analytics.internal;

import android.app.Application;
import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznl;
import com.google.android.gms.internal.zzno;
import com.google.android.gms.measurement.zzg;
import java.lang.Thread.UncaughtExceptionHandler;

public class zzf {
    private static zzf zzOT;
    private final Context mContext;
    private final Context zzOU;
    private final zzr zzOV;
    private final zzaf zzOW;
    private final zzg zzOX;
    private final zzb zzOY;
    private final zzv zzOZ;
    private final zzan zzPa;
    private final zzai zzPb;
    private final GoogleAnalytics zzPc;
    private final zzn zzPd;
    private final zza zzPe;
    private final zzk zzPf;
    private final zzu zzPg;
    private final zznl zzqD;

    class C01921 implements UncaughtExceptionHandler {
        final /* synthetic */ zzf zzPh;

        C01921(zzf com_google_android_gms_analytics_internal_zzf) {
            this.zzPh = com_google_android_gms_analytics_internal_zzf;
        }

        public void uncaughtException(Thread thread, Throwable error) {
            zzaf zzjh = this.zzPh.zzjh();
            if (zzjh != null) {
                zzjh.zze("Job execution failed", error);
            }
        }
    }

    protected zzf(zzg com_google_android_gms_analytics_internal_zzg) {
        Object applicationContext = com_google_android_gms_analytics_internal_zzg.getApplicationContext();
        zzx.zzb(applicationContext, (Object) "Application context can't be null");
        zzx.zzb(applicationContext instanceof Application, (Object) "getApplicationContext didn't return the application");
        Context zzjg = com_google_android_gms_analytics_internal_zzg.zzjg();
        zzx.zzy(zzjg);
        this.mContext = applicationContext;
        this.zzOU = zzjg;
        this.zzqD = com_google_android_gms_analytics_internal_zzg.zzh(this);
        this.zzOV = com_google_android_gms_analytics_internal_zzg.zzg(this);
        zzaf zzf = com_google_android_gms_analytics_internal_zzg.zzf(this);
        zzf.zza();
        this.zzOW = zzf;
        if (zziV().zzka()) {
            zziU().zzbc("Google Analytics " + zze.VERSION + " is starting up.");
        } else {
            zziU().zzbc("Google Analytics " + zze.VERSION + " is starting up. " + "To enable debug logging on a device run:\n" + "  adb shell setprop log.tag.GAv4 DEBUG\n" + "  adb logcat -s GAv4");
        }
        zzai zzq = com_google_android_gms_analytics_internal_zzg.zzq(this);
        zzq.zza();
        this.zzPb = zzq;
        zzan zze = com_google_android_gms_analytics_internal_zzg.zze(this);
        zze.zza();
        this.zzPa = zze;
        zzb zzl = com_google_android_gms_analytics_internal_zzg.zzl(this);
        zzn zzd = com_google_android_gms_analytics_internal_zzg.zzd(this);
        zza zzc = com_google_android_gms_analytics_internal_zzg.zzc(this);
        zzk zzb = com_google_android_gms_analytics_internal_zzg.zzb(this);
        zzu zza = com_google_android_gms_analytics_internal_zzg.zza(this);
        zzg zzaa = com_google_android_gms_analytics_internal_zzg.zzaa(applicationContext);
        zzaa.zza(zzjf());
        this.zzOX = zzaa;
        GoogleAnalytics zzi = com_google_android_gms_analytics_internal_zzg.zzi(this);
        zzd.zza();
        this.zzPd = zzd;
        zzc.zza();
        this.zzPe = zzc;
        zzb.zza();
        this.zzPf = zzb;
        zza.zza();
        this.zzPg = zza;
        zzv zzp = com_google_android_gms_analytics_internal_zzg.zzp(this);
        zzp.zza();
        this.zzOZ = zzp;
        zzl.zza();
        this.zzOY = zzl;
        if (zziV().zzka()) {
            zziU().zzb("Device AnalyticsService version", zze.VERSION);
        }
        zzi.zza();
        this.zzPc = zzi;
        zzl.start();
    }

    public static zzf zzZ(Context context) {
        zzx.zzy(context);
        if (zzOT == null) {
            synchronized (zzf.class) {
                if (zzOT == null) {
                    zznl zzrM = zzno.zzrM();
                    long elapsedRealtime = zzrM.elapsedRealtime();
                    zzf com_google_android_gms_analytics_internal_zzf = new zzf(new zzg(context.getApplicationContext()));
                    zzOT = com_google_android_gms_analytics_internal_zzf;
                    GoogleAnalytics.zzin();
                    elapsedRealtime = zzrM.elapsedRealtime() - elapsedRealtime;
                    long longValue = ((Long) zzy.zzRf.get()).longValue();
                    if (elapsedRealtime > longValue) {
                        com_google_android_gms_analytics_internal_zzf.zziU().zzc("Slow initialization (ms)", Long.valueOf(elapsedRealtime), Long.valueOf(longValue));
                    }
                }
            }
        }
        return zzOT;
    }

    private void zza(zzd com_google_android_gms_analytics_internal_zzd) {
        zzx.zzb((Object) com_google_android_gms_analytics_internal_zzd, (Object) "Analytics service not created/initialized");
        zzx.zzb(com_google_android_gms_analytics_internal_zzd.isInitialized(), (Object) "Analytics service not initialized");
    }

    public Context getContext() {
        return this.mContext;
    }

    public void zziS() {
        zzg.zziS();
    }

    public zznl zziT() {
        return this.zzqD;
    }

    public zzaf zziU() {
        zza(this.zzOW);
        return this.zzOW;
    }

    public zzr zziV() {
        return this.zzOV;
    }

    public zzg zziW() {
        zzx.zzy(this.zzOX);
        return this.zzOX;
    }

    public zzv zziX() {
        zza(this.zzOZ);
        return this.zzOZ;
    }

    public zzai zziY() {
        zza(this.zzPb);
        return this.zzPb;
    }

    public zzb zzip() {
        zza(this.zzOY);
        return this.zzOY;
    }

    public zzan zziq() {
        zza(this.zzPa);
        return this.zzPa;
    }

    public zzk zzjb() {
        zza(this.zzPf);
        return this.zzPf;
    }

    public zzu zzjc() {
        return this.zzPg;
    }

    protected UncaughtExceptionHandler zzjf() {
        return new C01921(this);
    }

    public Context zzjg() {
        return this.zzOU;
    }

    public zzaf zzjh() {
        return this.zzOW;
    }

    public GoogleAnalytics zzji() {
        zzx.zzy(this.zzPc);
        zzx.zzb(this.zzPc.isInitialized(), (Object) "Analytics instance not initialized");
        return this.zzPc;
    }

    public zzai zzjj() {
        return (this.zzPb == null || !this.zzPb.isInitialized()) ? null : this.zzPb;
    }

    public zza zzjk() {
        zza(this.zzPe);
        return this.zzPe;
    }

    public zzn zzjl() {
        zza(this.zzPd);
        return this.zzPd;
    }
}
