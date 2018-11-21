package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class UserMetadata implements SafeParcelable {
    public static final Creator<UserMetadata> CREATOR = new zzk();
    final int mVersionCode;
    final String zzVu;
    final String zzanw;
    final String zzanx;
    final boolean zzany;
    final String zzanz;

    UserMetadata(int versionCode, String permissionId, String displayName, String pictureUrl, boolean isAuthenticatedUser, String emailAddress) {
        this.mVersionCode = versionCode;
        this.zzanw = permissionId;
        this.zzVu = displayName;
        this.zzanx = pictureUrl;
        this.zzany = isAuthenticatedUser;
        this.zzanz = emailAddress;
    }

    public UserMetadata(String permissionId, String displayName, String pictureUrl, boolean isAuthenticatedUser, String emailAddress) {
        this(1, permissionId, displayName, pictureUrl, isAuthenticatedUser, emailAddress);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format("Permission ID: '%s', Display Name: '%s', Picture URL: '%s', Authenticated User: %b, Email: '%s'", new Object[]{this.zzanw, this.zzVu, this.zzanx, Boolean.valueOf(this.zzany), this.zzanz});
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzk.zza(this, dest, flags);
    }
}
