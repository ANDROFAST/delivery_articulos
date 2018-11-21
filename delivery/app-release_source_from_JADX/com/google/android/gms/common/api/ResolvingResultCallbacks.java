package com.google.android.gms.common.api;

import android.app.Activity;
import android.util.Log;
import com.google.android.gms.common.internal.zzx;

public abstract class ResolvingResultCallbacks<R extends Result> extends ResultCallbacks<R> {
    private final Activity mActivity;
    private final int zzaeU;

    protected ResolvingResultCallbacks(Activity activity, int requestCode) {
        this.mActivity = (Activity) zzx.zzb((Object) activity, (Object) "Activity must not be null");
        this.zzaeU = requestCode;
    }

    public final void onFailure(Status result) {
        if (result.hasResolution()) {
            try {
                result.startResolutionForResult(this.mActivity, this.zzaeU);
                return;
            } catch (Throwable e) {
                Log.e("ResolvingResultCallback", "Failed to start resolution", e);
                onUnresolvableFailure(new Status(8));
                return;
            }
        }
        onUnresolvableFailure(result);
    }

    public abstract void onSuccess(R r);

    public abstract void onUnresolvableFailure(Status status);
}
