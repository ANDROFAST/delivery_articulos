package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.measurement.internal.zzae;
import com.google.android.gms.measurement.internal.zzo;
import com.google.android.gms.measurement.internal.zzt;

public final class AppMeasurementReceiver extends BroadcastReceiver {
    static Boolean zzNt;
    static WakeLock zzaQY;
    static final Object zzqf = new Object();

    public static boolean zzX(Context context) {
        zzx.zzy(context);
        if (zzNt != null) {
            return zzNt.booleanValue();
        }
        boolean zza = zzae.zza(context, AppMeasurementReceiver.class, false);
        zzNt = Boolean.valueOf(zza);
        return zza;
    }

    public void onReceive(Context context, Intent intent) {
        zzt zzaU = zzt.zzaU(context);
        zzo zzzz = zzaU.zzzz();
        String action = intent.getAction();
        if (zzaU.zzAX().zzka()) {
            zzzz.zzBr().zzj("Device AppMeasurementReceiver got", action);
        } else {
            zzzz.zzBr().zzj("Local AppMeasurementReceiver got", action);
        }
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            boolean zzY = AppMeasurementService.zzY(context);
            Intent intent2 = new Intent(context, AppMeasurementService.class);
            intent2.setAction("com.google.android.gms.measurement.UPLOAD");
            synchronized (zzqf) {
                context.startService(intent2);
                if (zzY) {
                    try {
                        PowerManager powerManager = (PowerManager) context.getSystemService("power");
                        if (zzaQY == null) {
                            zzaQY = powerManager.newWakeLock(1, "AppMeasurement WakeLock");
                            zzaQY.setReferenceCounted(false);
                        }
                        zzaQY.acquire(1000);
                    } catch (SecurityException e) {
                        zzzz.zzBm().zzez("AppMeasurementService at risk of not starting. For more reliable app measurements, add the WAKE_LOCK permission to your manifest.");
                    }
                    return;
                }
            }
        }
    }
}
