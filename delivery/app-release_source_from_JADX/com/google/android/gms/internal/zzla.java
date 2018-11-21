package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.proxy.ProxyApi.ProxyResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlx.zza;

abstract class zzla extends zza<ProxyResult, zzkx> {
    public zzla(GoogleApiClient googleApiClient) {
        super(Auth.zzTW, googleApiClient);
    }

    protected abstract void zza(Context context, zzkz com_google_android_gms_internal_zzkz) throws RemoteException;

    protected final void zza(zzkx com_google_android_gms_internal_zzkx) throws RemoteException {
        zza(com_google_android_gms_internal_zzkx.getContext(), (zzkz) com_google_android_gms_internal_zzkx.zzqs());
    }

    protected /* synthetic */ Result zzc(Status status) {
        return zzj(status);
    }

    protected ProxyResult zzj(Status status) {
        return new zzlc(status);
    }
}
