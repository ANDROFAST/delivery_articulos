package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ValuesRemovedDetails implements SafeParcelable {
    public static final Creator<ValuesRemovedDetails> CREATOR = new zzj();
    final int mIndex;
    final int mVersionCode;
    final int zzasJ;
    final int zzasK;
    final String zzatk;
    final int zzatl;

    ValuesRemovedDetails(int versionCode, int index, int valueIndex, int valueCount, String movedToId, int movedToIndex) {
        this.mVersionCode = versionCode;
        this.mIndex = index;
        this.zzasJ = valueIndex;
        this.zzasK = valueCount;
        this.zzatk = movedToId;
        this.zzatl = movedToIndex;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzj.zza(this, dest, flags);
    }
}
