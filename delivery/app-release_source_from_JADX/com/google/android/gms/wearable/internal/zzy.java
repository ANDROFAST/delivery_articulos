package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataItem;

public class zzy implements DataEvent {
    private int zzZU;
    private DataItem zzbnq;

    public zzy(DataEvent dataEvent) {
        this.zzZU = dataEvent.getType();
        this.zzbnq = (DataItem) dataEvent.getDataItem().freeze();
    }

    public /* synthetic */ Object freeze() {
        return zzGM();
    }

    public DataItem getDataItem() {
        return this.zzbnq;
    }

    public int getType() {
        return this.zzZU;
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        String str = getType() == 1 ? "changed" : getType() == 2 ? "deleted" : "unknown";
        return "DataEventEntity{ type=" + str + ", dataitem=" + getDataItem() + " }";
    }

    public DataEvent zzGM() {
        return this;
    }
}
