package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class RemovePermissionRequest implements SafeParcelable {
    public static final Creator<RemovePermissionRequest> CREATOR = new zzbp();
    final int mVersionCode;
    final DriveId zzamF;
    final String zzanc;
    final String zzano;
    final boolean zzaob;

    RemovePermissionRequest(int versionCode, DriveId driveId, String accountIdentifier, boolean sendEventOnCompletion, String trackingTag) {
        this.mVersionCode = versionCode;
        this.zzamF = driveId;
        this.zzano = accountIdentifier;
        this.zzaob = sendEventOnCompletion;
        this.zzanc = trackingTag;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbp.zza(this, dest, flags);
    }
}
