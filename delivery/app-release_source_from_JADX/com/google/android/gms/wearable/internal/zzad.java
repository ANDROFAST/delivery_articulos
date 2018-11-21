package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class zzad implements DataItem {
    private Uri mUri;
    private byte[] zzaHC;
    private Map<String, DataItemAsset> zzbnt;

    public zzad(DataItem dataItem) {
        this.mUri = dataItem.getUri();
        this.zzaHC = dataItem.getData();
        Map hashMap = new HashMap();
        for (Entry entry : dataItem.getAssets().entrySet()) {
            if (entry.getKey() != null) {
                hashMap.put(entry.getKey(), ((DataItemAsset) entry.getValue()).freeze());
            }
        }
        this.zzbnt = Collections.unmodifiableMap(hashMap);
    }

    public /* synthetic */ Object freeze() {
        return zzGO();
    }

    public Map<String, DataItemAsset> getAssets() {
        return this.zzbnt;
    }

    public byte[] getData() {
        return this.zzaHC;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public boolean isDataValid() {
        return true;
    }

    public DataItem setData(byte[] data) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return toString(Log.isLoggable("DataItem", 3));
    }

    public String toString(boolean verbose) {
        StringBuilder stringBuilder = new StringBuilder("DataItemEntity{ ");
        stringBuilder.append("uri=" + this.mUri);
        stringBuilder.append(", dataSz=" + (this.zzaHC == null ? "null" : Integer.valueOf(this.zzaHC.length)));
        stringBuilder.append(", numAssets=" + this.zzbnt.size());
        if (verbose && !this.zzbnt.isEmpty()) {
            stringBuilder.append(", assets=[");
            String str = "";
            for (Entry entry : this.zzbnt.entrySet()) {
                stringBuilder.append(str + ((String) entry.getKey()) + ": " + ((DataItemAsset) entry.getValue()).getId());
                str = ", ";
            }
            stringBuilder.append("]");
        }
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }

    public DataItem zzGO() {
        return this;
    }
}
