package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class UnsubscribeResourceRequest implements SafeParcelable {
    public static final Creator<UnsubscribeResourceRequest> CREATOR = new zzbx();
    final int mVersionCode;
    final DriveId zzaoh;

    UnsubscribeResourceRequest(int versionCode, DriveId id) {
        this.mVersionCode = versionCode;
        this.zzaoh = id;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbx.zza(this, dest, flags);
    }
}
