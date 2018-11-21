package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.Permission;

public class AddPermissionRequest implements SafeParcelable {
    public static final Creator<AddPermissionRequest> CREATOR = new zzb();
    final int mVersionCode;
    final DriveId zzamF;
    final Permission zzanY;
    final boolean zzanZ;
    final String zzanc;
    final String zzaoa;
    final boolean zzaob;

    AddPermissionRequest(int versionCode, DriveId driveId, Permission permission, boolean sendNotificationEmail, String emailMessage, boolean sendEventOnCompletion, String trackingTag) {
        this.mVersionCode = versionCode;
        this.zzamF = driveId;
        this.zzanY = permission;
        this.zzanZ = sendNotificationEmail;
        this.zzaoa = emailMessage;
        this.zzaob = sendEventOnCompletion;
        this.zzanc = trackingTag;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzb.zza(this, dest, flags);
    }
}
