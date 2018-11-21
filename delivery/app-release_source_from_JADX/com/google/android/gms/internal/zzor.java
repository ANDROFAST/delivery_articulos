package com.google.android.gms.internal;

import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.fitness.zza;
import java.util.Set;

public abstract class zzor<T extends IInterface> extends zzj<T> {
    protected zzor(Context context, Looper looper, int i, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, zzf com_google_android_gms_common_internal_zzf) {
        super(context, looper, i, com_google_android_gms_common_internal_zzf, connectionCallbacks, onConnectionFailedListener);
    }

    protected Set<Scope> zzb(Set<Scope> set) {
        return zza.zze(set);
    }

    public boolean zzmn() {
        return !zzoo.zzaC(getContext());
    }

    public boolean zzqu() {
        return true;
    }
}
