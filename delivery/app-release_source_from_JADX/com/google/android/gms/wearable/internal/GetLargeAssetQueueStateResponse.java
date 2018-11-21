package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class GetLargeAssetQueueStateResponse implements SafeParcelable {
    public static final Creator<GetLargeAssetQueueStateResponse> CREATOR = new zzau();
    final int mVersionCode;
    public final Status zzSE;
    public final LargeAssetQueueStateParcelable zzbnH;

    GetLargeAssetQueueStateResponse(int versionCode, Status status, LargeAssetQueueStateParcelable queueState) {
        this.mVersionCode = versionCode;
        this.zzSE = status;
        if (status.isSuccess()) {
            zzx.zzy(queueState);
        }
        this.zzbnH = queueState;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzau.zza(this, dest, flags);
    }
}
