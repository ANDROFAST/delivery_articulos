package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.zzmn.zzb;

public abstract class zzmb<L> implements zzb<L> {
    private final DataHolder zzafC;

    protected zzmb(DataHolder dataHolder) {
        this.zzafC = dataHolder;
    }

    protected abstract void zza(L l, DataHolder dataHolder);

    public void zzpb() {
        if (this.zzafC != null) {
            this.zzafC.close();
        }
    }

    public final void zzs(L l) {
        zza(l, this.zzafC);
    }
}
