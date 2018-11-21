package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class DrivePreferences implements SafeParcelable {
    public static final Creator<DrivePreferences> CREATOR = new zzf();
    final int mVersionCode;
    final boolean zzamV;

    DrivePreferences(int versionCode, boolean syncOverWifiOnly) {
        this.mVersionCode = versionCode;
        this.zzamV = syncOverWifiOnly;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzf.zza(this, parcel, flags);
    }
}
