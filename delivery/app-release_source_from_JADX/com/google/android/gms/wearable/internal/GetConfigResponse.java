package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.ConnectionConfiguration;

@Deprecated
public class GetConfigResponse implements SafeParcelable {
    public static final Creator<GetConfigResponse> CREATOR = new zzap();
    public final int statusCode;
    public final int versionCode;
    public final ConnectionConfiguration zzbnC;

    GetConfigResponse(int versionCode, int statusCode, ConnectionConfiguration config) {
        this.versionCode = versionCode;
        this.statusCode = statusCode;
        this.zzbnC = config;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzap.zza(this, dest, flags);
    }
}
