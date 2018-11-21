package com.google.android.gms.auth.api.credentials.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.Auth.AuthCredentialsOptions;
import com.google.android.gms.auth.api.credentials.internal.zzi.zza;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzj;

public final class zzf extends zzj<zzi> {
    private final AuthCredentialsOptions zzVd;

    public zzf(Context context, Looper looper, com.google.android.gms.common.internal.zzf com_google_android_gms_common_internal_zzf, AuthCredentialsOptions authCredentialsOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 68, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        this.zzVd = authCredentialsOptions;
    }

    protected /* synthetic */ IInterface zzW(IBinder iBinder) {
        return zzav(iBinder);
    }

    protected zzi zzav(IBinder iBinder) {
        return zza.zzax(iBinder);
    }

    protected String zzgh() {
        return "com.google.android.gms.auth.api.credentials.service.START";
    }

    protected String zzgi() {
        return "com.google.android.gms.auth.api.credentials.internal.ICredentialsService";
    }

    protected Bundle zzlU() {
        return this.zzVd == null ? new Bundle() : this.zzVd.zzlU();
    }

    AuthCredentialsOptions zzmm() {
        return this.zzVd;
    }
}
