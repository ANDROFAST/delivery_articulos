package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class zzaf extends zzc implements DataItem {
    private final int zzaBl;

    public zzaf(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.zzaBl = i2;
    }

    public /* synthetic */ Object freeze() {
        return zzGO();
    }

    public Map<String, DataItemAsset> getAssets() {
        Map<String, DataItemAsset> hashMap = new HashMap(this.zzaBl);
        for (int i = 0; i < this.zzaBl; i++) {
            zzac com_google_android_gms_wearable_internal_zzac = new zzac(this.zzafC, this.zzahw + i);
            if (com_google_android_gms_wearable_internal_zzac.getDataItemKey() != null) {
                hashMap.put(com_google_android_gms_wearable_internal_zzac.getDataItemKey(), com_google_android_gms_wearable_internal_zzac);
            }
        }
        return hashMap;
    }

    public byte[] getData() {
        return getByteArray("data");
    }

    public Uri getUri() {
        return Uri.parse(getString("path"));
    }

    public DataItem setData(byte[] data) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return toString(Log.isLoggable("DataItem", 3));
    }

    public String toString(boolean verbose) {
        byte[] data = getData();
        Map assets = getAssets();
        StringBuilder stringBuilder = new StringBuilder("DataItemInternal{ ");
        stringBuilder.append("uri=" + getUri());
        stringBuilder.append(", dataSz=" + (data == null ? "null" : Integer.valueOf(data.length)));
        stringBuilder.append(", numAssets=" + assets.size());
        if (verbose && !assets.isEmpty()) {
            stringBuilder.append(", assets=[");
            String str = "";
            for (Entry entry : assets.entrySet()) {
                stringBuilder.append(str + ((String) entry.getKey()) + ": " + ((DataItemAsset) entry.getValue()).getId());
                str = ", ";
            }
            stringBuilder.append("]");
        }
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }

    public DataItem zzGO() {
        return new zzad(this);
    }
}
