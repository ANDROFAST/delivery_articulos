package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.Fitness;

public class zzos extends zzor<zzpd> {

    public static class zzb extends com.google.android.gms.common.api.Api.zza<zzos, NoOptions> {
        public /* synthetic */ com.google.android.gms.common.api.Api.zzb zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzg(context, looper, com_google_android_gms_common_internal_zzf, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzos zzg(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzos(context, looper, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        }
    }

    static abstract class zza<R extends Result> extends com.google.android.gms.internal.zzlx.zza<R, zzos> {
        public zza(GoogleApiClient googleApiClient) {
            super(Fitness.zzatF, googleApiClient);
        }
    }

    static abstract class zzc extends zza<Status> {
        zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected Status zzb(Status status) {
            zzx.zzab(!status.isSuccess());
            return status;
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    public zzos(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 59, connectionCallbacks, onConnectionFailedListener, com_google_android_gms_common_internal_zzf);
    }

    protected /* synthetic */ IInterface zzW(IBinder iBinder) {
        return zzbu(iBinder);
    }

    protected zzpd zzbu(IBinder iBinder) {
        return com.google.android.gms.internal.zzpd.zza.zzbF(iBinder);
    }

    protected String zzgh() {
        return "com.google.android.gms.fitness.BleApi";
    }

    protected String zzgi() {
        return "com.google.android.gms.fitness.internal.IGoogleFitBleApi";
    }
}
