package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;

public class OnContentsResponse implements SafeParcelable {
    public static final Creator<OnContentsResponse> CREATOR = new zzaw();
    final int mVersionCode;
    final Contents zzaoW;
    final boolean zzaqc;

    OnContentsResponse(int versionCode, Contents contents, boolean outOfDate) {
        this.mVersionCode = versionCode;
        this.zzaoW = contents;
        this.zzaqc = outOfDate;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzaw.zza(this, dest, flags);
    }

    public Contents zzsO() {
        return this.zzaoW;
    }

    public boolean zzsP() {
        return this.zzaqc;
    }
}
