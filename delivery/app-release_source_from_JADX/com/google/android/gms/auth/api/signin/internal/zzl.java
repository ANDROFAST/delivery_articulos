package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.internal.zzg.zza;
import com.google.android.gms.auth.api.signin.zzh;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;

public class zzl extends zzj<zzg> {
    private final zzh zzWg;

    public zzl(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, zzh com_google_android_gms_auth_api_signin_zzh, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 87, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        this.zzWg = (zzh) zzx.zzy(com_google_android_gms_auth_api_signin_zzh);
    }

    protected /* synthetic */ IInterface zzW(IBinder iBinder) {
        return zzaB(iBinder);
    }

    protected zzg zzaB(IBinder iBinder) {
        return zza.zzaD(iBinder);
    }

    protected String zzgh() {
        return "com.google.android.gms.auth.api.signin.service.START";
    }

    protected String zzgi() {
        return "com.google.android.gms.auth.api.signin.internal.ISignInService";
    }
}
