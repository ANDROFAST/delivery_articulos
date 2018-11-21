package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.DriveSpace;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GetChangesRequest implements SafeParcelable {
    public static final Creator<GetChangesRequest> CREATOR = new zzah();
    final int mVersionCode;
    final List<DriveSpace> zzanF;
    private final Set<DriveSpace> zzanG;
    final ChangeSequenceNumber zzapF;
    final int zzapG;
    final boolean zzapH;

    private GetChangesRequest(int versionCode, ChangeSequenceNumber fromSequenceNumber, int maxResults, List<DriveSpace> spacesList, Set<DriveSpace> spaces, boolean includeUnsubscribed) {
        this.mVersionCode = versionCode;
        this.zzapF = fromSequenceNumber;
        this.zzapG = maxResults;
        this.zzanF = spacesList;
        this.zzanG = spaces;
        this.zzapH = includeUnsubscribed;
    }

    GetChangesRequest(int versionCode, ChangeSequenceNumber fromSequenceNumber, int maxResults, List<DriveSpace> spacesList, boolean includeUnsubscribed) {
        this(versionCode, fromSequenceNumber, maxResults, spacesList, spacesList == null ? null : new HashSet(spacesList), includeUnsubscribed);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzah.zza(this, dest, flags);
    }
}
