package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetCloudSyncOptInStatusResponse implements SafeParcelable {
    public static final Creator<GetCloudSyncOptInStatusResponse> CREATOR = new zzan();
    public final int statusCode;
    public final int versionCode;
    public final boolean zzbnA;
    public final boolean zzbnB;

    GetCloudSyncOptInStatusResponse(int versionCode, int statusCode, boolean isOptInOrOutDone, boolean isOptedIn) {
        this.versionCode = versionCode;
        this.statusCode = statusCode;
        this.zzbnA = isOptInOrOutDone;
        this.zzbnB = isOptedIn;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzan.zza(this, dest, flags);
    }
}
