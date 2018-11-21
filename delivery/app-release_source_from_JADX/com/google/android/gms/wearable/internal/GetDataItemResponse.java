package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetDataItemResponse implements SafeParcelable {
    public static final Creator<GetDataItemResponse> CREATOR = new zzas();
    public final int statusCode;
    public final int versionCode;
    public final DataItemParcelable zzbnF;

    GetDataItemResponse(int versionCode, int statusCode, DataItemParcelable dataItem) {
        this.versionCode = versionCode;
        this.statusCode = statusCode;
        this.zzbnF = dataItem;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzas.zza(this, dest, flags);
    }
}
