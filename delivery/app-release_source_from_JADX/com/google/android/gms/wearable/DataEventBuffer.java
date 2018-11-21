package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;
import com.google.android.gms.wearable.internal.zzz;

public class DataEventBuffer extends zzf<DataEvent> implements Result {
    private final Status zzTA;

    public DataEventBuffer(DataHolder dataHolder) {
        super(dataHolder);
        this.zzTA = new Status(dataHolder.getStatusCode());
    }

    public Status getStatus() {
        return this.zzTA;
    }

    protected /* synthetic */ Object zzk(int i, int i2) {
        return zzv(i, i2);
    }

    protected String zzpO() {
        return "path";
    }

    protected DataEvent zzv(int i, int i2) {
        return new zzz(this.zzafC, i, i2);
    }
}
