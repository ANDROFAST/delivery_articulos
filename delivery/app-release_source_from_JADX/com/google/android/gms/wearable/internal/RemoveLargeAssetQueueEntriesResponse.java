package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class RemoveLargeAssetQueueEntriesResponse implements SafeParcelable {
    public static final Creator<RemoveLargeAssetQueueEntriesResponse> CREATOR = new zzbu();
    public final int versionCode;
    public final Status zzSE;
    public final int zzbnu;

    RemoveLargeAssetQueueEntriesResponse(int versionCode, Status status, int numDeleted) {
        this.versionCode = versionCode;
        this.zzSE = (Status) zzx.zzb((Object) status, (Object) "status");
        this.zzbnu = numDeleted;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbu.zza(this, dest, flags);
    }
}
