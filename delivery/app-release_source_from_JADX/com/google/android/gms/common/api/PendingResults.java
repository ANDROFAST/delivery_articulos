package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzly;
import com.google.android.gms.internal.zzmo;
import com.google.android.gms.internal.zzmq;

public final class PendingResults {

    private static final class zza<R extends Result> extends zzly<R> {
        private final R zzaeS;

        public zza(R r) {
            super(Looper.getMainLooper());
            this.zzaeS = r;
        }

        protected R zzc(Status status) {
            if (status.getStatusCode() == this.zzaeS.getStatus().getStatusCode()) {
                return this.zzaeS;
            }
            throw new UnsupportedOperationException("Creating failed results is not supported");
        }
    }

    private static final class zzb<R extends Result> extends zzly<R> {
        private final R zzaeT;

        public zzb(GoogleApiClient googleApiClient, R r) {
            super(googleApiClient);
            this.zzaeT = r;
        }

        protected R zzc(Status status) {
            return this.zzaeT;
        }
    }

    private static final class zzc<R extends Result> extends zzly<R> {
        public zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected R zzc(Status status) {
            throw new UnsupportedOperationException("Creating failed results is not supported");
        }
    }

    private PendingResults() {
    }

    public static PendingResult<Status> canceledPendingResult() {
        PendingResult com_google_android_gms_internal_zzmq = new zzmq(Looper.getMainLooper());
        com_google_android_gms_internal_zzmq.cancel();
        return com_google_android_gms_internal_zzmq;
    }

    public static <R extends Result> PendingResult<R> canceledPendingResult(R result) {
        zzx.zzb((Object) result, (Object) "Result must not be null");
        zzx.zzb(result.getStatus().getStatusCode() == 16, (Object) "Status code must be CommonStatusCodes.CANCELED");
        PendingResult com_google_android_gms_common_api_PendingResults_zza = new zza(result);
        com_google_android_gms_common_api_PendingResults_zza.cancel();
        return com_google_android_gms_common_api_PendingResults_zza;
    }

    public static <R extends Result> OptionalPendingResult<R> immediatePendingResult(R result) {
        zzx.zzb((Object) result, (Object) "Result must not be null");
        PendingResult com_google_android_gms_common_api_PendingResults_zzc = new zzc(null);
        com_google_android_gms_common_api_PendingResults_zzc.zzb(result);
        return new zzmo(com_google_android_gms_common_api_PendingResults_zzc);
    }

    public static PendingResult<Status> immediatePendingResult(Status result) {
        zzx.zzb((Object) result, (Object) "Result must not be null");
        PendingResult com_google_android_gms_internal_zzmq = new zzmq(Looper.getMainLooper());
        com_google_android_gms_internal_zzmq.zzb(result);
        return com_google_android_gms_internal_zzmq;
    }

    public static <R extends Result> PendingResult<R> zza(R r, GoogleApiClient googleApiClient) {
        zzx.zzb((Object) r, (Object) "Result must not be null");
        zzx.zzb(!r.getStatus().isSuccess(), (Object) "Status code must not be SUCCESS");
        PendingResult com_google_android_gms_common_api_PendingResults_zzb = new zzb(googleApiClient, r);
        com_google_android_gms_common_api_PendingResults_zzb.zzb(r);
        return com_google_android_gms_common_api_PendingResults_zzb;
    }

    public static PendingResult<Status> zza(Status status, GoogleApiClient googleApiClient) {
        zzx.zzb((Object) status, (Object) "Result must not be null");
        PendingResult com_google_android_gms_internal_zzmq = new zzmq(googleApiClient);
        com_google_android_gms_internal_zzmq.zzb(status);
        return com_google_android_gms_internal_zzmq;
    }

    public static <R extends Result> OptionalPendingResult<R> zzb(R r, GoogleApiClient googleApiClient) {
        zzx.zzb((Object) r, (Object) "Result must not be null");
        PendingResult com_google_android_gms_common_api_PendingResults_zzc = new zzc(googleApiClient);
        com_google_android_gms_common_api_PendingResults_zzc.zzb(r);
        return new zzmo(com_google_android_gms_common_api_PendingResults_zzc);
    }
}
