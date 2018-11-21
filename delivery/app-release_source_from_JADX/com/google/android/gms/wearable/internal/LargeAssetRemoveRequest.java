package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

public final class LargeAssetRemoveRequest implements SafeParcelable {
    public static final Creator<LargeAssetRemoveRequest> CREATOR = new zzbi();
    private static final LargeAssetRemoveRequest zzboe = new LargeAssetRemoveRequest(1, null);
    final int mVersionCode;
    public final long[] zzbof;

    LargeAssetRemoveRequest(int versionCode, long[] transferIdsToRemove) {
        this.mVersionCode = versionCode;
        this.zzbof = transferIdsToRemove;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "LargeAssetRemoveRequest{transferIdsToRemove=" + Arrays.toString(this.zzbof) + "}";
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbi.zza(this, dest, flags);
    }
}
