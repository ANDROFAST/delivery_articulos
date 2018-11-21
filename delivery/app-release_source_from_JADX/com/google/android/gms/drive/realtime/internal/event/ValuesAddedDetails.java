package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ValuesAddedDetails implements SafeParcelable {
    public static final Creator<ValuesAddedDetails> CREATOR = new zzi();
    final int mIndex;
    final int mVersionCode;
    final int zzasJ;
    final int zzasK;
    final String zzati;
    final int zzatj;

    ValuesAddedDetails(int versionCode, int index, int valueIndex, int valueCount, String movedFromId, int movedFromIndex) {
        this.mVersionCode = versionCode;
        this.mIndex = index;
        this.zzasJ = valueIndex;
        this.zzasK = valueCount;
        this.zzati = movedFromId;
        this.zzatj = movedFromIndex;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzi.zza(this, dest, flags);
    }
}
