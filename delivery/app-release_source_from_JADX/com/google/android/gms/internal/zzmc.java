package com.google.android.gms.internal;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

public abstract class zzmc implements Releasable, Result {
    protected final Status zzTA;
    protected final DataHolder zzafC;

    protected zzmc(DataHolder dataHolder, Status status) {
        this.zzTA = status;
        this.zzafC = dataHolder;
    }

    public Status getStatus() {
        return this.zzTA;
    }

    public void release() {
        if (this.zzafC != null) {
            this.zzafC.close();
        }
    }
}
