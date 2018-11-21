package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

abstract class zznc<R extends Result> extends com.google.android.gms.internal.zzlx.zza<R, zznd> {

    static abstract class zza extends zznc<Status> {
        public zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public Status zzb(Status status) {
            return status;
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    public zznc(GoogleApiClient googleApiClient) {
        super(zzmz.zzTo, googleApiClient);
    }
}
