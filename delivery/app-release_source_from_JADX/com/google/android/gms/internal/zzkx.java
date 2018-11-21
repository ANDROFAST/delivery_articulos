package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.Auth.zza;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;

public final class zzkx extends zzj<zzkz> {
    private final Bundle zzUq;

    public zzkx(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, zza com_google_android_gms_auth_api_Auth_zza, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 16, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        this.zzUq = com_google_android_gms_auth_api_Auth_zza == null ? new Bundle() : com_google_android_gms_auth_api_Auth_zza.zzmb();
    }

    protected /* synthetic */ IInterface zzW(IBinder iBinder) {
        return zzay(iBinder);
    }

    protected zzkz zzay(IBinder iBinder) {
        return zzkz.zza.zzaA(iBinder);
    }

    protected String zzgh() {
        return "com.google.android.gms.auth.service.START";
    }

    protected String zzgi() {
        return "com.google.android.gms.auth.api.internal.IAuthService";
    }

    protected Bundle zzlU() {
        return this.zzUq;
    }

    public boolean zzmn() {
        zzf zzqq = zzqq();
        return (TextUtils.isEmpty(zzqq.getAccountName()) || zzqq.zzb(Auth.PROXY_API).isEmpty()) ? false : true;
    }
}
