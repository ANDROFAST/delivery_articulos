package com.google.android.gms.analytics;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.google.android.gms.analytics.internal.zzaf;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzse;

public final class AnalyticsService extends Service {
    private static Boolean zzNu;
    private final Handler mHandler = new Handler();

    public static boolean zzY(Context context) {
        zzx.zzy(context);
        if (zzNu != null) {
            return zzNu.booleanValue();
        }
        boolean zza = zzam.zza(context, AnalyticsService.class);
        zzNu = Boolean.valueOf(zza);
        return zza;
    }

    private void zzih() {
        try {
            synchronized (AnalyticsReceiver.zzqf) {
                zzse com_google_android_gms_internal_zzse = AnalyticsReceiver.zzNs;
                if (com_google_android_gms_internal_zzse != null && com_google_android_gms_internal_zzse.isHeld()) {
                    com_google_android_gms_internal_zzse.release();
                }
            }
        } catch (SecurityException e) {
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        zzf zzZ = zzf.zzZ(this);
        zzaf zziU = zzZ.zziU();
        if (zzZ.zziV().zzka()) {
            zziU.zzba("Device AnalyticsService is starting up");
        } else {
            zziU.zzba("Local AnalyticsService is starting up");
        }
    }

    public void onDestroy() {
        zzf zzZ = zzf.zzZ(this);
        zzaf zziU = zzZ.zziU();
        if (zzZ.zziV().zzka()) {
            zziU.zzba("Device AnalyticsService is shutting down");
        } else {
            zziU.zzba("Local AnalyticsService is shutting down");
        }
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int flags, final int startId) {
        zzih();
        final zzf zzZ = zzf.zzZ(this);
        final zzaf zziU = zzZ.zziU();
        String action = intent.getAction();
        if (zzZ.zziV().zzka()) {
            zziU.zza("Device AnalyticsService called. startId, action", Integer.valueOf(startId), action);
        } else {
            zziU.zza("Local AnalyticsService called. startId, action", Integer.valueOf(startId), action);
        }
        if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
            zzZ.zzip().zza(new zzw(this) {
                final /* synthetic */ AnalyticsService zzNy;

                class C01781 implements Runnable {
                    final /* synthetic */ C06181 zzNz;

                    C01781(C06181 c06181) {
                        this.zzNz = c06181;
                    }

                    public void run() {
                        if (!this.zzNz.zzNy.stopSelfResult(startId)) {
                            return;
                        }
                        if (zzZ.zziV().zzka()) {
                            zziU.zzba("Device AnalyticsService processed last dispatch request");
                        } else {
                            zziU.zzba("Local AnalyticsService processed last dispatch request");
                        }
                    }
                }

                public void zzc(Throwable th) {
                    this.zzNy.mHandler.post(new C01781(this));
                }
            });
        }
        return 2;
    }
}
