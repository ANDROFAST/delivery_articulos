package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ParcelableCollaborator implements SafeParcelable {
    public static final Creator<ParcelableCollaborator> CREATOR = new zzq();
    final int mVersionCode;
    final String zzJX;
    final String zzJg;
    final String zzVu;
    final boolean zzadn;
    final boolean zzasC;
    final String zzasD;
    final String zzasE;

    ParcelableCollaborator(int versionCode, boolean isMe, boolean isAnonymous, String sessionId, String userId, String displayName, String color, String photoUrl) {
        this.mVersionCode = versionCode;
        this.zzasC = isMe;
        this.zzadn = isAnonymous;
        this.zzJX = sessionId;
        this.zzJg = userId;
        this.zzVu = displayName;
        this.zzasD = color;
        this.zzasE = photoUrl;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ParcelableCollaborator)) {
            return false;
        }
        return this.zzJX.equals(((ParcelableCollaborator) obj).zzJX);
    }

    public int hashCode() {
        return this.zzJX.hashCode();
    }

    public String toString() {
        return "Collaborator [isMe=" + this.zzasC + ", isAnonymous=" + this.zzadn + ", sessionId=" + this.zzJX + ", userId=" + this.zzJg + ", displayName=" + this.zzVu + ", color=" + this.zzasD + ", photoUrl=" + this.zzasE + "]";
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzq.zza(this, dest, flags);
    }
}
