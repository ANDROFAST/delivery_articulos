package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CloseContentsAndUpdateMetadataRequest implements SafeParcelable {
    public static final Creator<CloseContentsAndUpdateMetadataRequest> CREATOR = new zzh();
    final int mVersionCode;
    final String zzanc;
    final boolean zzand;
    final DriveId zzaoh;
    final MetadataBundle zzaoi;
    final Contents zzaoj;
    final int zzaok;
    final int zzaol;
    final boolean zzaom;

    CloseContentsAndUpdateMetadataRequest(int versionCode, DriveId id, MetadataBundle metadataChangeSet, Contents contentsReference, boolean notifyOnCompletion, String trackingTag, int commitStrategy, int contentsRequestId, boolean isContentsValidForConflictDetection) {
        this.mVersionCode = versionCode;
        this.zzaoh = id;
        this.zzaoi = metadataChangeSet;
        this.zzaoj = contentsReference;
        this.zzand = notifyOnCompletion;
        this.zzanc = trackingTag;
        this.zzaok = commitStrategy;
        this.zzaol = contentsRequestId;
        this.zzaom = isContentsValidForConflictDetection;
    }

    public CloseContentsAndUpdateMetadataRequest(DriveId id, MetadataBundle metadataChangeSet, int contentsRequestId, boolean isContentsValidForConflictDetection, ExecutionOptions executionOptions) {
        this(1, id, metadataChangeSet, null, executionOptions.zzsm(), executionOptions.zzsl(), executionOptions.zzsn(), contentsRequestId, isContentsValidForConflictDetection);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzh.zza(this, dest, flags);
    }
}
