package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.internal.zzlx.zza;
import java.util.Collections;

public class zzmf implements zzmh {
    private final zzmi zzafD;

    public zzmf(zzmi com_google_android_gms_internal_zzmi) {
        this.zzafD = com_google_android_gms_internal_zzmi;
    }

    public void begin() {
        this.zzafD.zzpy();
        this.zzafD.zzafp.zzagq = Collections.emptySet();
    }

    public void connect() {
        this.zzafD.zzpw();
    }

    public void disconnect() {
        this.zzafD.zzafp.zzpn();
    }

    public void onConnected(Bundle connectionHint) {
    }

    public void onConnectionSuspended(int cause) {
    }

    public <A extends zzb, R extends Result, T extends zza<R, A>> T zza(T t) {
        this.zzafD.zzafp.zzagj.add(t);
        return t;
    }

    public void zza(ConnectionResult connectionResult, Api<?> api, int i) {
    }

    public <A extends zzb, T extends zza<? extends Result, A>> T zzb(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }
}
