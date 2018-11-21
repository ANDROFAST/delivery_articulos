package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataItem;

public final class zzz extends zzc implements DataEvent {
    private final int zzaBl;

    public zzz(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.zzaBl = i2;
    }

    public /* synthetic */ Object freeze() {
        return zzGM();
    }

    public DataItem getDataItem() {
        return new zzaf(this.zzafC, this.zzahw, this.zzaBl);
    }

    public int getType() {
        return getInteger("event_type");
    }

    public String toString() {
        String str = getType() == 1 ? "changed" : getType() == 2 ? "deleted" : "unknown";
        return "DataEventRef{ type=" + str + ", dataitem=" + getDataItem() + " }";
    }

    public DataEvent zzGM() {
        return new zzy(this);
    }
}
