package com.google.android.gms.analytics.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import com.google.android.gms.common.internal.zzx;

class zzag extends BroadcastReceiver {
    static final String zzRF = zzag.class.getName();
    private final zzf zzOP;
    private boolean zzRG;
    private boolean zzRH;

    zzag(zzf com_google_android_gms_analytics_internal_zzf) {
        zzx.zzy(com_google_android_gms_analytics_internal_zzf);
        this.zzOP = com_google_android_gms_analytics_internal_zzf;
    }

    private Context getContext() {
        return this.zzOP.getContext();
    }

    private zzaf zziU() {
        return this.zzOP.zziU();
    }

    private zzb zzip() {
        return this.zzOP.zzip();
    }

    private void zzli() {
        zziU();
        zzip();
    }

    public boolean isConnected() {
        if (!this.zzRG) {
            this.zzOP.zziU().zzbd("Connectivity unknown. Receiver not registered");
        }
        return this.zzRH;
    }

    public boolean isRegistered() {
        return this.zzRG;
    }

    public void onReceive(Context ctx, Intent intent) {
        zzli();
        String action = intent.getAction();
        this.zzOP.zziU().zza("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean zzlk = zzlk();
            if (this.zzRH != zzlk) {
                this.zzRH = zzlk;
                zzip().zzJ(zzlk);
            }
        } else if (!"com.google.analytics.RADIO_POWERED".equals(action)) {
            this.zzOP.zziU().zzd("NetworkBroadcastReceiver received unknown action", action);
        } else if (!intent.hasExtra(zzRF)) {
            zzip().zziO();
        }
    }

    public void unregister() {
        if (isRegistered()) {
            this.zzOP.zziU().zzba("Unregistering connectivity change receiver");
            this.zzRG = false;
            this.zzRH = false;
            try {
                getContext().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                zziU().zze("Failed to unregister the network broadcast receiver", e);
            }
        }
    }

    public void zzlh() {
        zzli();
        if (!this.zzRG) {
            Context context = getContext();
            context.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            IntentFilter intentFilter = new IntentFilter("com.google.analytics.RADIO_POWERED");
            intentFilter.addCategory(context.getPackageName());
            context.registerReceiver(this, intentFilter);
            this.zzRH = zzlk();
            this.zzOP.zziU().zza("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.zzRH));
            this.zzRG = true;
        }
    }

    public void zzlj() {
        if (VERSION.SDK_INT > 10) {
            Context context = getContext();
            Intent intent = new Intent("com.google.analytics.RADIO_POWERED");
            intent.addCategory(context.getPackageName());
            intent.putExtra(zzRF, true);
            context.sendOrderedBroadcast(intent, null);
        }
    }

    protected boolean zzlk() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) getContext().getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (SecurityException e) {
            return false;
        }
    }
}
