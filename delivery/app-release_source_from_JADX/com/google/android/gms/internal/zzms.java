package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzb;
import com.google.android.gms.common.api.zze;
import com.google.android.gms.common.internal.zzx;

public class zzms<R extends Result> extends zze<R> implements ResultCallback<R> {
    private final Object zzafd;
    private zzb<? super R, ? extends Result> zzahj;
    private zzms<? extends Result> zzahk;
    private ResultCallbacks<? super R> zzahl;
    private PendingResult<R> zzahm;

    private void zzd(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (Throwable e) {
                Log.w("TransformedResultImpl", "Unable to release " + result, e);
            }
        }
    }

    private void zzpD() {
        if (this.zzahm == null) {
            return;
        }
        if (this.zzahj != null || this.zzahl != null) {
            this.zzahm.setResultCallback(this);
        }
    }

    public void onResult(R result) {
        synchronized (this.zzafd) {
            if (!result.getStatus().isSuccess()) {
                zzz(result.getStatus());
                zzd(result);
            } else if (this.zzahj != null) {
                PendingResult zza = this.zzahj.zza(result);
                if (zza == null) {
                    zzz(new Status(13, "Transform returned null"));
                } else {
                    this.zzahk.zza(zza);
                }
                zzd(result);
            } else if (this.zzahl != null) {
                this.zzahl.onSuccess(result);
            }
        }
    }

    public void zza(PendingResult<?> pendingResult) {
        synchronized (this.zzafd) {
            this.zzahm = pendingResult;
            zzpD();
        }
    }

    public void zzz(Status status) {
        synchronized (this.zzafd) {
            if (this.zzahj != null) {
                Object zzw = this.zzahj.zzw(status);
                zzx.zzb(zzw, (Object) "onFailure must not return null");
                this.zzahk.zzz(zzw);
            } else if (this.zzahl != null) {
                this.zzahl.onFailure(status);
            }
        }
    }
}
