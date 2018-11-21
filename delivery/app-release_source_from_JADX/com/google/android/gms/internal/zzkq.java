package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.internal.zzks.zza;

public class zzkq extends zzj<zzks> {
    public zzkq(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 74, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
    }

    protected /* synthetic */ IInterface zzW(IBinder iBinder) {
        return zzaq(iBinder);
    }

    protected zzks zzaq(IBinder iBinder) {
        return zza.zzas(iBinder);
    }

    protected String zzgh() {
        return "com.google.android.gms.auth.api.accountstatus.START";
    }

    protected String zzgi() {
        return "com.google.android.gms.auth.api.accountstatus.internal.IAccountStatusService";
    }
}
