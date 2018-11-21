package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.internal.zzqw.zza;

public class zzqr extends zzj<zzqw> {
    public zzqr(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, zzf com_google_android_gms_common_internal_zzf) {
        super(context, looper, 69, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
    }

    protected /* synthetic */ IInterface zzW(IBinder iBinder) {
        return zzdk(iBinder);
    }

    protected zzqw zzdk(IBinder iBinder) {
        return zza.zzdo(iBinder);
    }

    protected String zzgh() {
        return "com.google.android.gms.nearby.bootstrap.service.NearbyBootstrapService.START";
    }

    protected String zzgi() {
        return "com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService";
    }
}
