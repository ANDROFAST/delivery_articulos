package com.google.android.gms.analytics;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.zzaf;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzse;

public class CampaignTrackingService extends Service {
    private static Boolean zzNu;
    private Handler mHandler;

    private Handler getHandler() {
        Handler handler = this.mHandler;
        if (handler != null) {
            return handler;
        }
        handler = new Handler(getMainLooper());
        this.mHandler = handler;
        return handler;
    }

    public static boolean zzY(Context context) {
        zzx.zzy(context);
        if (zzNu != null) {
            return zzNu.booleanValue();
        }
        boolean zza = zzam.zza(context, CampaignTrackingService.class);
        zzNu = Boolean.valueOf(zza);
        return zza;
    }

    private void zzih() {
        try {
            synchronized (CampaignTrackingReceiver.zzqf) {
                zzse com_google_android_gms_internal_zzse = CampaignTrackingReceiver.zzNs;
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
        zzf.zzZ(this).zziU().zzba("CampaignTrackingService is starting up");
    }

    public void onDestroy() {
        zzf.zzZ(this).zziU().zzba("CampaignTrackingService is shutting down");
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int flags, final int startId) {
        zzih();
        zzf zzZ = zzf.zzZ(this);
        final zzaf zziU = zzZ.zziU();
        String str = null;
        if (zzZ.zziV().zzka()) {
            zziU.zzbe("Unexpected installation campaign (package side)");
        } else {
            str = intent.getStringExtra("referrer");
        }
        final Handler handler = getHandler();
        if (TextUtils.isEmpty(str)) {
            if (!zzZ.zziV().zzka()) {
                zziU.zzbd("No campaign found on com.android.vending.INSTALL_REFERRER \"referrer\" extra");
            }
            zzZ.zziW().zzf(new Runnable(this) {
                final /* synthetic */ CampaignTrackingService zzNF;

                public void run() {
                    this.zzNF.zza(zziU, handler, startId);
                }
            });
        } else {
            int zzke = zzZ.zziV().zzke();
            if (str.length() > zzke) {
                zziU.zzc("Campaign data exceed the maximum supported size and will be clipped. size, limit", Integer.valueOf(str.length()), Integer.valueOf(zzke));
                str = str.substring(0, zzke);
            }
            zziU.zza("CampaignTrackingService called. startId, campaign", Integer.valueOf(startId), str);
            zzZ.zzip().zza(str, new Runnable(this) {
                final /* synthetic */ CampaignTrackingService zzNF;

                public void run() {
                    this.zzNF.zza(zziU, handler, startId);
                }
            });
        }
        return 2;
    }

    protected void zza(final zzaf com_google_android_gms_analytics_internal_zzaf, Handler handler, final int i) {
        handler.post(new Runnable(this) {
            final /* synthetic */ CampaignTrackingService zzNF;

            public void run() {
                boolean stopSelfResult = this.zzNF.stopSelfResult(i);
                if (stopSelfResult) {
                    com_google_android_gms_analytics_internal_zzaf.zza("Install campaign broadcast processed", Boolean.valueOf(stopSelfResult));
                }
            }
        });
    }
}
