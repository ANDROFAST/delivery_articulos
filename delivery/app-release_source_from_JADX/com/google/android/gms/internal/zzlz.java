package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzx;

public class zzlz implements ConnectionCallbacks, OnConnectionFailedListener {
    public final Api<?> zzafm;
    private final int zzafn;
    private zzmi zzafo;

    public zzlz(Api<?> api, int i) {
        this.zzafm = api;
        this.zzafn = i;
    }

    private void zzoT() {
        zzx.zzb(this.zzafo, (Object) "Callbacks must be attached to a GoogleApiClient instance before connecting the client.");
    }

    public void onConnected(Bundle connectionHint) {
        zzoT();
        this.zzafo.onConnected(connectionHint);
    }

    public void onConnectionFailed(ConnectionResult result) {
        zzoT();
        this.zzafo.zza(result, this.zzafm, this.zzafn);
    }

    public void onConnectionSuspended(int cause) {
        zzoT();
        this.zzafo.onConnectionSuspended(cause);
    }

    public void zza(zzmi com_google_android_gms_internal_zzmi) {
        this.zzafo = com_google_android_gms_internal_zzmi;
    }
}
