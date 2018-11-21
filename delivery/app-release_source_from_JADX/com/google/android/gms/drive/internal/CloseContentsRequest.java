package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;

public class CloseContentsRequest implements SafeParcelable {
    public static final Creator<CloseContentsRequest> CREATOR = new zzi();
    final int mVersionCode;
    final Contents zzaoj;
    final int zzaol;
    final Boolean zzaon;

    CloseContentsRequest(int versionCode, Contents contentsReference, Boolean saveResults, int contentsRequestId) {
        this.mVersionCode = versionCode;
        this.zzaoj = contentsReference;
        this.zzaon = saveResults;
        this.zzaol = contentsRequestId;
    }

    public CloseContentsRequest(int contentsRequestId, boolean saveResults) {
        this(1, null, Boolean.valueOf(saveResults), contentsRequestId);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzi.zza(this, dest, flags);
    }
}
