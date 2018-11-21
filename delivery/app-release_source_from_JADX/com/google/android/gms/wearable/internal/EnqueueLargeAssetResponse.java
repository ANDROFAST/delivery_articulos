package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class EnqueueLargeAssetResponse implements SafeParcelable {
    public static final Creator<EnqueueLargeAssetResponse> CREATOR = new zzah();
    final int mVersionCode;
    public final int statusCode;
    public final LargeAssetQueueEntryParcelable zzbnv;

    EnqueueLargeAssetResponse(int versionCode, int statusCode, LargeAssetQueueEntryParcelable queueEntry) {
        boolean z = true;
        this.mVersionCode = versionCode;
        this.statusCode = statusCode;
        if (statusCode == 0) {
            if (queueEntry == null) {
                z = false;
            }
            zzx.zzb(z, (Object) "Expecting non-null queueEntry");
        } else {
            zzx.zzb(queueEntry == null, "Expecting null queueEntry: %s", queueEntry);
        }
        this.zzbnv = queueEntry;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzah.zza(this, dest, flags);
    }
}
