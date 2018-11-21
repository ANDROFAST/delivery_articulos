package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LargeAssetQuery implements SafeParcelable {
    public static final Creator<LargeAssetQuery> CREATOR = new zzbe();
    final int mVersionCode;
    public final Uri zzaXR;
    public final int zzbnP;

    LargeAssetQuery(int versionCode, int stateFlags, Uri destinationUri) {
        this.mVersionCode = versionCode;
        this.zzbnP = stateFlags;
        this.zzaXR = destinationUri;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "LargeAssetQuery{stateFlags=" + this.zzbnP + ", destinationUri=" + this.zzaXR + "}";
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbe.zza(this, dest, flags);
    }
}
