package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.zzx;

class zzq extends BroadcastReceiver {
    static final String zzRF = zzq.class.getName();
    private boolean zzRG;
    private boolean zzRH;
    private final zzt zzaQX;

    zzq(zzt com_google_android_gms_measurement_internal_zzt) {
        zzx.zzy(com_google_android_gms_measurement_internal_zzt);
        this.zzaQX = com_google_android_gms_measurement_internal_zzt;
    }

    private Context getContext() {
        return this.zzaQX.getContext();
    }

    private zzo zzzz() {
        return this.zzaQX.zzzz();
    }

    public boolean isRegistered() {
        this.zzaQX.zziS();
        return this.zzRG;
    }

    public void onReceive(Context context, Intent intent) {
        this.zzaQX.zzje();
        String action = intent.getAction();
        zzzz().zzBr().zzj("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            final boolean zzlk = this.zzaQX.zzBE().zzlk();
            if (this.zzRH != zzlk) {
                this.zzRH = zzlk;
                this.zzaQX.zzAV().zzg(new Runnable(this) {
                    final /* synthetic */ zzq zzaTC;

                    public void run() {
                        this.zzaTC.zzaQX.zzJ(zzlk);
                    }
                });
                return;
            }
            return;
        }
        zzzz().zzBm().zzj("NetworkBroadcastReceiver received unknown action", action);
    }

    public void unregister() {
        this.zzaQX.zzje();
        this.zzaQX.zziS();
        if (isRegistered()) {
            zzzz().zzBr().zzez("Unregistering connectivity change receiver");
            this.zzRG = false;
            this.zzRH = false;
            try {
                getContext().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                zzzz().zzBl().zzj("Failed to unregister the network broadcast receiver", e);
            }
        }
    }

    public void zzlh() {
        this.zzaQX.zzje();
        this.zzaQX.zziS();
        if (!this.zzRG) {
            getContext().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.zzRH = this.zzaQX.zzBE().zzlk();
            zzzz().zzBr().zzj("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.zzRH));
            this.zzRG = true;
        }
    }
}
