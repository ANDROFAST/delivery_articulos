package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzmp;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class zzb extends AsyncTaskLoader<Void> implements zzmp {
    private Semaphore zzVR = new Semaphore(0);
    private Set<GoogleApiClient> zzVS;

    public zzb(Context context, Set<GoogleApiClient> set) {
        super(context);
        this.zzVS = set;
    }

    public /* synthetic */ Object loadInBackground() {
        return zzmH();
    }

    protected void onStartLoading() {
        this.zzVR.drainPermits();
        forceLoad();
    }

    public Void zzmH() {
        int i = 0;
        for (GoogleApiClient zza : this.zzVS) {
            i = zza.zza((zzmp) this) ? i + 1 : i;
        }
        try {
            this.zzVR.tryAcquire(i, 5, TimeUnit.SECONDS);
        } catch (Throwable e) {
            Log.i("GACSignInLoader", "Unexpected InterruptedException", e);
            Thread.currentThread().interrupt();
        }
        return null;
    }

    public void zzmI() {
        this.zzVR.release();
    }
}
