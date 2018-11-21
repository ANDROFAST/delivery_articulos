package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DrivePreferences;

public class SetDrivePreferencesRequest implements SafeParcelable {
    public static final Creator<SetDrivePreferencesRequest> CREATOR = new zzbq();
    final int mVersionCode;
    final DrivePreferences zzaqi;

    SetDrivePreferencesRequest(int versionCode, DrivePreferences prefs) {
        this.mVersionCode = versionCode;
        this.zzaqi = prefs;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbq.zza(this, dest, flags);
    }
}
