package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class ControlProgressRequest implements SafeParcelable {
    public static final Creator<ControlProgressRequest> CREATOR = new zzj();
    final int mVersionCode;
    final DriveId zzamF;
    final int zzaoo;
    final int zzaop;

    ControlProgressRequest(int versionCode, int controllerType, int methodCode, DriveId driveId) {
        this.mVersionCode = versionCode;
        this.zzaoo = controllerType;
        this.zzaop = methodCode;
        this.zzamF = driveId;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzj.zza(this, dest, flags);
    }
}
