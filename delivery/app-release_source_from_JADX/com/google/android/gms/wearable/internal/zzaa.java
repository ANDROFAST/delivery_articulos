package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.DataItemAsset;

public class zzaa implements DataItemAsset {
    private final String zzuX;
    private final String zzxX;

    public zzaa(DataItemAsset dataItemAsset) {
        this.zzxX = dataItemAsset.getId();
        this.zzuX = dataItemAsset.getDataItemKey();
    }

    public /* synthetic */ Object freeze() {
        return zzGN();
    }

    public String getDataItemKey() {
        return this.zzuX;
    }

    public String getId() {
        return this.zzxX;
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DataItemAssetEntity[");
        stringBuilder.append("@");
        stringBuilder.append(Integer.toHexString(hashCode()));
        if (this.zzxX == null) {
            stringBuilder.append(",noid");
        } else {
            stringBuilder.append(",");
            stringBuilder.append(this.zzxX);
        }
        stringBuilder.append(", key=");
        stringBuilder.append(this.zzuX);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public DataItemAsset zzGN() {
        return this;
    }
}
