package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetCapabilityResponse implements SafeParcelable {
    public static final Creator<GetCapabilityResponse> CREATOR = new zzaj();
    public final int statusCode;
    public final int versionCode;
    public final CapabilityInfoParcelable zzbnx;

    GetCapabilityResponse(int versionCode, int statusCode, CapabilityInfoParcelable capability) {
        this.versionCode = versionCode;
        this.statusCode = statusCode;
        this.zzbnx = capability;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzaj.zza(this, dest, flags);
    }
}
