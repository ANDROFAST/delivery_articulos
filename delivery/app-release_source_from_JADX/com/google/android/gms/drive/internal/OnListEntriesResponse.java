package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.WriteAwareParcelable;

public class OnListEntriesResponse extends WriteAwareParcelable implements SafeParcelable {
    public static final Creator<OnListEntriesResponse> CREATOR = new zzbd();
    final int mVersionCode;
    final boolean zzaoG;
    final DataHolder zzaqp;

    OnListEntriesResponse(int versionCode, DataHolder entries, boolean moreEntriesMayExist) {
        this.mVersionCode = versionCode;
        this.zzaqp = entries;
        this.zzaoG = moreEntriesMayExist;
    }

    public int describeContents() {
        return 0;
    }

    protected void zzJ(Parcel parcel, int i) {
        zzbd.zza(this, parcel, i);
    }

    public DataHolder zzsU() {
        return this.zzaqp;
    }

    public boolean zzsV() {
        return this.zzaoG;
    }
}
