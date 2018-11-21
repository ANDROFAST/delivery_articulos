package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.internal.zzaf;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzse;

public final class AnalyticsReceiver extends BroadcastReceiver {
    static zzse zzNs;
    static Boolean zzNt;
    static Object zzqf = new Object();

    public static boolean zzX(Context context) {
        zzx.zzy(context);
        if (zzNt != null) {
            return zzNt.booleanValue();
        }
        boolean zza = zzam.zza(context, AnalyticsReceiver.class, false);
        zzNt = Boolean.valueOf(zza);
        return zza;
    }

    public void onReceive(Context context, Intent intent) {
        zzf zzZ = zzf.zzZ(context);
        zzaf zziU = zzZ.zziU();
        String action = intent.getAction();
        if (zzZ.zziV().zzka()) {
            zziU.zza("Device AnalyticsReceiver got", action);
        } else {
            zziU.zza("Local AnalyticsReceiver got", action);
        }
        if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
            boolean zzY = AnalyticsService.zzY(context);
            Intent intent2 = new Intent(context, AnalyticsService.class);
            intent2.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            synchronized (zzqf) {
                context.startService(intent2);
                if (zzY) {
                    try {
                        if (zzNs == null) {
                            zzNs = new zzse(context, 1, "Analytics WakeLock");
                            zzNs.setReferenceCounted(false);
                        }
                        zzNs.acquire(1000);
                    } catch (SecurityException e) {
                        zziU.zzbd("Analytics service at risk of not starting. For more reliable analytics, add the WAKE_LOCK permission to your manifest. See http://goo.gl/8Rd3yj for instructions.");
                    }
                    return;
                }
            }
        }
    }
}
