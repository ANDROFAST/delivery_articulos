package com.google.android.gms.common.api;

public abstract class zzb<R extends Result, S extends Result> {
    public abstract PendingResult<S> zza(R r);

    public Status zzw(Status status) {
        return status;
    }
}
