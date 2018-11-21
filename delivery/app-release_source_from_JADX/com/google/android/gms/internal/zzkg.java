package com.google.android.gms.internal;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.internal.zzkd.zza;

public class zzkg extends zzj<zzkd> {
    public zzkg(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 19, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
    }

    protected /* synthetic */ IInterface zzW(IBinder iBinder) {
        return zzai(iBinder);
    }

    protected zzkd zzai(IBinder iBinder) {
        return zza.zzag(iBinder);
    }

    protected String zzgh() {
        return "com.google.android.gms.icing.LIGHTWEIGHT_INDEX_SERVICE";
    }

    protected String zzgi() {
        return "com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch";
    }

    public zzkd zzlS() throws DeadObjectException {
        return (zzkd) zzqs();
    }
}
