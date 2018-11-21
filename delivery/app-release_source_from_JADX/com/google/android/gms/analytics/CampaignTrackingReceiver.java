package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.zzaf;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzse;

public class CampaignTrackingReceiver extends BroadcastReceiver {
    static zzse zzNs;
    static Boolean zzNt;
    static Object zzqf = new Object();

    public static boolean zzX(Context context) {
        zzx.zzy(context);
        if (zzNt != null) {
            return zzNt.booleanValue();
        }
        boolean zza = zzam.zza(context, CampaignTrackingReceiver.class, true);
        zzNt = Boolean.valueOf(zza);
        return zza;
    }

    public void onReceive(Context context, Intent intent) {
        zzf zzZ = zzf.zzZ(context);
        zzaf zziU = zzZ.zziU();
        String stringExtra = intent.getStringExtra("referrer");
        String action = intent.getAction();
        zziU.zza("CampaignTrackingReceiver received", action);
        if (!"com.android.vending.INSTALL_REFERRER".equals(action) || TextUtils.isEmpty(stringExtra)) {
            zziU.zzbd("CampaignTrackingReceiver received unexpected intent without referrer extra");
            return;
        }
        boolean zzY = CampaignTrackingService.zzY(context);
        if (!zzY) {
            zziU.zzbd("CampaignTrackingService not registered or disabled. Installation tracking not possible. See http://goo.gl/8Rd3yj for instructions.");
        }
        zzaS(stringExtra);
        if (zzZ.zziV().zzka()) {
            zziU.zzbe("Received unexpected installation campaign on package side");
            return;
        }
        Class zzij = zzij();
        zzx.zzy(zzij);
        Intent intent2 = new Intent(context, zzij);
        intent2.putExtra("referrer", stringExtra);
        synchronized (zzqf) {
            context.startService(intent2);
            if (zzY) {
                try {
                    if (zzNs == null) {
                        zzNs = new zzse(context, 1, "Analytics campaign WakeLock");
                        zzNs.setReferenceCounted(false);
                    }
                    zzNs.acquire(1000);
                } catch (SecurityException e) {
                    zziU.zzbd("CampaignTrackingService service at risk of not starting. For more reliable installation campaign reports, add the WAKE_LOCK permission to your manifest. See http://goo.gl/8Rd3yj for instructions.");
                }
                return;
            }
        }
    }

    protected void zzaS(String str) {
    }

    protected Class<? extends CampaignTrackingService> zzij() {
        return CampaignTrackingService.class;
    }
}
