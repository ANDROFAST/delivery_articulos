package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OpenChannelResponse implements SafeParcelable {
    public static final Creator<OpenChannelResponse> CREATOR = new zzbq();
    public final int statusCode;
    public final int versionCode;
    public final ChannelImpl zzbmX;

    OpenChannelResponse(int versionCode, int statusCode, ChannelImpl channel) {
        this.versionCode = versionCode;
        this.statusCode = statusCode;
        this.zzbmX = channel;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbq.zza(this, dest, flags);
    }
}
