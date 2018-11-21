package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzx;
import java.util.concurrent.TimeUnit;

public final class BatchResult implements Result {
    private final Status zzTA;
    private final PendingResult<?>[] zzaev;

    BatchResult(Status status, PendingResult<?>[] pendingResults) {
        this.zzTA = status;
        this.zzaev = pendingResults;
    }

    public Status getStatus() {
        return this.zzTA;
    }

    public <R extends Result> R take(BatchResultToken<R> resultToken) {
        zzx.zzb(resultToken.mId < this.zzaev.length, (Object) "The result token does not belong to this batch");
        return this.zzaev[resultToken.mId].await(0, TimeUnit.MILLISECONDS);
    }
}
