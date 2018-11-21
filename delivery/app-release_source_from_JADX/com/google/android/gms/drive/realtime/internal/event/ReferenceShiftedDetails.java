package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ReferenceShiftedDetails implements SafeParcelable {
    public static final Creator<ReferenceShiftedDetails> CREATOR = new zze();
    final int mVersionCode;
    final String zzatd;
    final String zzate;
    final int zzatf;
    final int zzatg;

    ReferenceShiftedDetails(int versionCode, String oldObjectId, String newObjectId, int oldIndex, int newIndex) {
        this.mVersionCode = versionCode;
        this.zzatd = oldObjectId;
        this.zzate = newObjectId;
        this.zzatf = oldIndex;
        this.zzatg = newIndex;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zze.zza(this, dest, flags);
    }
}
