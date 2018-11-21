package com.google.android.gms.common.api;

import com.google.android.gms.internal.zzly;

public abstract class ResultCallbacks<R extends Result> implements ResultCallback<R> {
    public abstract void onFailure(Status status);

    public final void onResult(R result) {
        Status status = result.getStatus();
        if (status.isSuccess()) {
            onSuccess(result);
            return;
        }
        onFailure(status);
        zzly.zzd(result);
    }

    public abstract void onSuccess(R r);
}
