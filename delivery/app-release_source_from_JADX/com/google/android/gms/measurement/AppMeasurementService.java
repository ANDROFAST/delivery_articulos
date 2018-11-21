package com.google.android.gms.measurement;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.PowerManager.WakeLock;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.measurement.internal.zzae;
import com.google.android.gms.measurement.internal.zzo;
import com.google.android.gms.measurement.internal.zzt;
import com.google.android.gms.measurement.internal.zzu;

public final class AppMeasurementService extends Service {
    private static Boolean zzNu;
    private final Handler mHandler = new Handler();

    public static boolean zzY(Context context) {
        zzx.zzy(context);
        if (zzNu != null) {
            return zzNu.booleanValue();
        }
        boolean zza = zzae.zza(context, AppMeasurementService.class);
        zzNu = Boolean.valueOf(zza);
        return zza;
    }

    private void zzih() {
        try {
            synchronized (AppMeasurementReceiver.zzqf) {
                WakeLock wakeLock = AppMeasurementReceiver.zzaQY;
                if (wakeLock != null && wakeLock.isHeld()) {
                    wakeLock.release();
                }
            }
        } catch (SecurityException e) {
        }
    }

    private zzo zzzz() {
        return zzt.zzaU(this).zzzz();
    }

    public IBinder onBind(Intent intent) {
        if (intent == null) {
            zzzz().zzBl().zzez("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new zzu(zzt.zzaU(this));
        }
        zzzz().zzBm().zzj("onBind received unknown action", action);
        return null;
    }

    public void onCreate() {
        super.onCreate();
        zzt zzaU = zzt.zzaU(this);
        zzo zzzz = zzaU.zzzz();
        if (zzaU.zzAX().zzka()) {
            zzzz.zzBr().zzez("Device AppMeasurementService is starting up");
        } else {
            zzzz.zzBr().zzez("Local AppMeasurementService is starting up");
        }
    }

    public void onDestroy() {
        zzt zzaU = zzt.zzaU(this);
        zzo zzzz = zzaU.zzzz();
        if (zzaU.zzAX().zzka()) {
            zzzz.zzBr().zzez("Device AppMeasurementService is shutting down");
        } else {
            zzzz.zzBr().zzez("Local AppMeasurementService is shutting down");
        }
        super.onDestroy();
    }

    public void onRebind(Intent intent) {
        if (intent == null) {
            zzzz().zzBl().zzez("onRebind called with null intent");
            return;
        }
        zzzz().zzBr().zzj("onRebind called. action", intent.getAction());
    }

    public int onStartCommand(Intent intent, int flags, final int startId) {
        zzih();
        final zzt zzaU = zzt.zzaU(this);
        final zzo zzzz = zzaU.zzzz();
        String action = intent.getAction();
        if (zzaU.zzAX().zzka()) {
            zzzz.zzBr().zze("Device AppMeasurementService called. startId, action", Integer.valueOf(startId), action);
        } else {
            zzzz.zzBr().zze("Local AppMeasurementService called. startId, action", Integer.valueOf(startId), action);
        }
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            zzaU.zzAV().zzg(new Runnable(this) {
                final /* synthetic */ AppMeasurementService zzaRb;

                class C03751 implements Runnable {
                    final /* synthetic */ C03761 zzaRc;

                    C03751(C03761 c03761) {
                        this.zzaRc = c03761;
                    }

                    public void run() {
                        if (!this.zzaRc.zzaRb.stopSelfResult(startId)) {
                            return;
                        }
                        if (zzaU.zzAX().zzka()) {
                            zzzz.zzBr().zzez("Device AppMeasurementService processed last upload request");
                        } else {
                            zzzz.zzBr().zzez("Local AppMeasurementService processed last upload request");
                        }
                    }
                }

                public void run() {
                    zzaU.zzBK();
                    this.zzaRb.mHandler.post(new C03751(this));
                }
            });
        }
        return 2;
    }

    public boolean onUnbind(Intent intent) {
        if (intent == null) {
            zzzz().zzBl().zzez("onUnbind called with null intent");
        } else {
            zzzz().zzBr().zzj("onUnbind called for intent. action", intent.getAction());
        }
        return true;
    }
}
