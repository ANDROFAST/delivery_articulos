package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;
import com.google.android.gms.wearable.internal.zzaf;

public class DataItemBuffer extends zzf<DataItem> implements Result {
    private final Status zzTA;

    public DataItemBuffer(DataHolder dataHolder) {
        super(dataHolder);
        this.zzTA = new Status(dataHolder.getStatusCode());
    }

    public Status getStatus() {
        return this.zzTA;
    }

    protected /* synthetic */ Object zzk(int i, int i2) {
        return zzw(i, i2);
    }

    protected String zzpO() {
        return "path";
    }

    protected DataItem zzw(int i, int i2) {
        return new zzaf(this.zzafC, i, i2);
    }
}
