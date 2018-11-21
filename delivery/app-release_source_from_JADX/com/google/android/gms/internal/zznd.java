package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.internal.zznf.zza;

public class zznd extends zzj<zznf> {
    public zznd(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 39, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
    }

    protected /* synthetic */ IInterface zzW(IBinder iBinder) {
        return zzaW(iBinder);
    }

    protected zznf zzaW(IBinder iBinder) {
        return zza.zzaY(iBinder);
    }

    public String zzgh() {
        return "com.google.android.gms.common.service.START";
    }

    protected String zzgi() {
        return "com.google.android.gms.common.internal.service.ICommonService";
    }
}
