package com.google.android.gms.playlog.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.zzrj.zza;

public class zzd implements ConnectionCallbacks, OnConnectionFailedListener {
    private zzf zzaYl = null;
    private final zza zzaYw;
    private boolean zzaYx = true;

    public zzd(zza com_google_android_gms_internal_zzrj_zza) {
        this.zzaYw = com_google_android_gms_internal_zzrj_zza;
    }

    public void onConnected(Bundle connectionHint) {
        this.zzaYl.zzas(false);
        if (this.zzaYx && this.zzaYw != null) {
            this.zzaYw.zzCX();
        }
        this.zzaYx = false;
    }

    public void onConnectionFailed(ConnectionResult result) {
        this.zzaYl.zzas(true);
        if (this.zzaYx && this.zzaYw != null) {
            if (result.hasResolution()) {
                this.zzaYw.zze(result.getResolution());
            } else {
                this.zzaYw.zzCY();
            }
        }
        this.zzaYx = false;
    }

    public void onConnectionSuspended(int cause) {
        this.zzaYl.zzas(true);
    }

    public void zza(zzf com_google_android_gms_playlog_internal_zzf) {
        this.zzaYl = com_google_android_gms_playlog_internal_zzf;
    }

    public void zzar(boolean z) {
        this.zzaYx = z;
    }
}
