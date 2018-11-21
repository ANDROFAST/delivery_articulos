package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.DataItemAsset;

public class DataItemAssetParcelable implements SafeParcelable, DataItemAsset {
    public static final Creator<DataItemAssetParcelable> CREATOR = new zzab();
    final int mVersionCode;
    private final String zzuX;
    private final String zzxX;

    DataItemAssetParcelable(int versionCode, String id, String key) {
        this.mVersionCode = versionCode;
        this.zzxX = id;
        this.zzuX = key;
    }

    public DataItemAssetParcelable(DataItemAsset value) {
        this.mVersionCode = 1;
        this.zzxX = (String) zzx.zzy(value.getId());
        this.zzuX = (String) zzx.zzy(value.getDataItemKey());
    }

    public int describeContents() {
        return 0;
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
        stringBuilder.append("DataItemAssetParcelable[");
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

    public void writeToParcel(Parcel dest, int flags) {
        zzab.zza(this, dest, flags);
    }

    public DataItemAsset zzGN() {
        return this;
    }
}
