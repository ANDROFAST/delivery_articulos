package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class SendMessageResponse implements SafeParcelable {
    public static final Creator<SendMessageResponse> CREATOR = new zzbx();
    public final int statusCode;
    public final int versionCode;
    public final int zzaKw;

    SendMessageResponse(int versionCode, int statusCode, int requestId) {
        this.versionCode = versionCode;
        this.statusCode = statusCode;
        this.zzaKw = requestId;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbx.zza(this, dest, flags);
    }
}