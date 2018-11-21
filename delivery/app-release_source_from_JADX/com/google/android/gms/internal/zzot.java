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

public class zzot extends zzor<zzpe> {

    public static class zzb extends com.google.android.gms.common.api.Api.zza<zzot, NoOptions> {
        public /* synthetic */ com.google.android.gms.common.api.Api.zzb zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzh(context, looper, com_google_android_gms_common_internal_zzf, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzot zzh(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzot(context, looper, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
        }
    }

    static abstract class zza<R extends Result> extends com.google.android.gms.internal.zzlx.zza<R, zzot> {
        public zza(GoogleApiClient googleApiClient) {
            super(Fitness.zzatG, googleApiClient);
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

    public zzot(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 60, connectionCallbacks, onConnectionFailedListener, com_google_android_gms_common_internal_zzf);
    }

    protected /* synthetic */ IInterface zzW(IBinder iBinder) {
        return zzbv(iBinder);
    }

    protected zzpe zzbv(IBinder iBinder) {
        return com.google.android.gms.internal.zzpe.zza.zzbG(iBinder);
    }

    protected String zzgh() {
        return "com.google.android.gms.fitness.ConfigApi";
    }

    protected String zzgi() {
        return "com.google.android.gms.fitness.internal.IGoogleFitConfigApi";
    }
}
