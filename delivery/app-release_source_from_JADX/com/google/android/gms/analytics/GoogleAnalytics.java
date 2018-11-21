package com.google.android.gms.analytics;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.analytics.internal.zzae;
import com.google.android.gms.analytics.internal.zzak;
import com.google.android.gms.analytics.internal.zzal;
import com.google.android.gms.analytics.internal.zzan;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzy;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class GoogleAnalytics extends zza {
    private static List<Runnable> zzNK = new ArrayList();
    private boolean zzNL;
    private Set<zza> zzNM = new HashSet();
    private boolean zzNN;
    private boolean zzNO;
    private volatile boolean zzNP;
    private boolean zzNQ;
    private boolean zzqh;

    interface zza {
        void zzn(Activity activity);

        void zzo(Activity activity);
    }

    class zzb implements ActivityLifecycleCallbacks {
        final /* synthetic */ GoogleAnalytics zzNR;

        zzb(GoogleAnalytics googleAnalytics) {
            this.zzNR = googleAnalytics;
        }

        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        }

        public void onActivityStarted(Activity activity) {
            this.zzNR.zzl(activity);
        }

        public void onActivityStopped(Activity activity) {
            this.zzNR.zzm(activity);
        }
    }

    public GoogleAnalytics(zzf context) {
        super(context);
    }

    public static GoogleAnalytics getInstance(Context context) {
        return zzf.zzZ(context).zzji();
    }

    public static void zzin() {
        synchronized (GoogleAnalytics.class) {
            if (zzNK != null) {
                for (Runnable run : zzNK) {
                    run.run();
                }
                zzNK = null;
            }
        }
    }

    private com.google.android.gms.analytics.internal.zzb zzip() {
        return zzif().zzip();
    }

    private zzan zziq() {
        return zzif().zziq();
    }

    public void dispatchLocalHits() {
        zzip().zziL();
    }

    public void enableAutoActivityReports(Application application) {
        if (VERSION.SDK_INT >= 14 && !this.zzNN) {
            application.registerActivityLifecycleCallbacks(new zzb(this));
            this.zzNN = true;
        }
    }

    public boolean getAppOptOut() {
        return this.zzNP;
    }

    public String getClientId() {
        zzx.zzcy("getClientId can not be called from the main thread");
        return zzif().zzjl().zzjT();
    }

    @Deprecated
    public Logger getLogger() {
        return zzae.getLogger();
    }

    public boolean isDryRunEnabled() {
        return this.zzNO;
    }

    public boolean isInitialized() {
        return this.zzqh && !this.zzNL;
    }

    public Tracker newTracker(int configResId) {
        Tracker tracker;
        synchronized (this) {
            tracker = new Tracker(zzif(), null, null);
            if (configResId > 0) {
                zzal com_google_android_gms_analytics_internal_zzal = (zzal) new zzak(zzif()).zzah(configResId);
                if (com_google_android_gms_analytics_internal_zzal != null) {
                    tracker.zza(com_google_android_gms_analytics_internal_zzal);
                }
            }
            tracker.zza();
        }
        return tracker;
    }

    public Tracker newTracker(String trackingId) {
        Tracker tracker;
        synchronized (this) {
            tracker = new Tracker(zzif(), trackingId, null);
            tracker.zza();
        }
        return tracker;
    }

    public void reportActivityStart(Activity activity) {
        if (!this.zzNN) {
            zzl(activity);
        }
    }

    public void reportActivityStop(Activity activity) {
        if (!this.zzNN) {
            zzm(activity);
        }
    }

    public void setAppOptOut(boolean optOut) {
        this.zzNP = optOut;
        if (this.zzNP) {
            zzip().zziK();
        }
    }

    public void setDryRun(boolean dryRun) {
        this.zzNO = dryRun;
    }

    public void setLocalDispatchPeriod(int dispatchPeriodInSeconds) {
        zzip().setLocalDispatchPeriod(dispatchPeriodInSeconds);
    }

    @Deprecated
    public void setLogger(Logger logger) {
        zzae.setLogger(logger);
        if (!this.zzNQ) {
            Log.i((String) zzy.zzQr.get(), "GoogleAnalytics.setLogger() is deprecated. To enable debug logging, please run:\nadb shell setprop log.tag." + ((String) zzy.zzQr.get()) + " DEBUG");
            this.zzNQ = true;
        }
    }

    public void zza() {
        zzim();
        this.zzqh = true;
    }

    void zza(zza com_google_android_gms_analytics_GoogleAnalytics_zza) {
        this.zzNM.add(com_google_android_gms_analytics_GoogleAnalytics_zza);
        Context context = zzif().getContext();
        if (context instanceof Application) {
            enableAutoActivityReports((Application) context);
        }
    }

    void zzb(zza com_google_android_gms_analytics_GoogleAnalytics_zza) {
        this.zzNM.remove(com_google_android_gms_analytics_GoogleAnalytics_zza);
    }

    void zzim() {
        zzan zziq = zziq();
        if (zziq.zzkS()) {
            getLogger().setLogLevel(zziq.getLogLevel());
        }
        if (zziq.zzkW()) {
            setDryRun(zziq.zzkX());
        }
        if (zziq.zzkS()) {
            Logger logger = zzae.getLogger();
            if (logger != null) {
                logger.setLogLevel(zziq.getLogLevel());
            }
        }
    }

    void zzio() {
        zzip().zziM();
    }

    void zzl(Activity activity) {
        for (zza zzn : this.zzNM) {
            zzn.zzn(activity);
        }
    }

    void zzm(Activity activity) {
        for (zza zzo : this.zzNM) {
            zzo.zzo(activity);
        }
    }
}
