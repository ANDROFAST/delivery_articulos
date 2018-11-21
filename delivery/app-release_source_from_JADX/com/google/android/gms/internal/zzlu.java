package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.clearcut.LogEventParcelable;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.internal.zzlw.zza;

public class zzlu extends zzj<zzlw> {
    public zzlu(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 40, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
    }

    protected /* synthetic */ IInterface zzW(IBinder iBinder) {
        return zzaK(iBinder);
    }

    public void zza(zzlv com_google_android_gms_internal_zzlv, LogEventParcelable logEventParcelable) throws RemoteException {
        ((zzlw) zzqs()).zza(com_google_android_gms_internal_zzlv, logEventParcelable);
    }

    protected zzlw zzaK(IBinder iBinder) {
        return zza.zzaM(iBinder);
    }

    protected String zzgh() {
        return "com.google.android.gms.clearcut.service.START";
    }

    protected String zzgi() {
        return "com.google.android.gms.clearcut.internal.IClearcutLoggerService";
    }
}
