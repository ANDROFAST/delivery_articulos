package com.google.android.gms.cast.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlx.zza;

public abstract class zzb<R extends Result> extends zza<R, zze> {
    public zzb(GoogleApiClient googleApiClient) {
        super(zzk.zzTo, googleApiClient);
    }

    public void zzbj(int i) {
        zzb(zzc(new Status(i)));
    }

    public void zzg(int i, String str) {
        zzb(zzc(new Status(i, str, null)));
    }
}
