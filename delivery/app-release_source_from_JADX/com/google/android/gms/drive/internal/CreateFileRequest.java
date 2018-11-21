package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CreateFileRequest implements SafeParcelable {
    public static final Creator<CreateFileRequest> CREATOR = new zzn();
    final int mVersionCode;
    final String zzanc;
    final boolean zzaob;
    final Contents zzaoj;
    final MetadataBundle zzaot;
    final Integer zzaou;
    final DriveId zzaov;
    final int zzaow;
    final int zzaox;

    CreateFileRequest(int versionCode, DriveId parentDriveId, MetadataBundle metadata, Contents contentsReference, Integer fileType, boolean sendEventOnCompletion, String trackingTag, int createStrategy, int openContentsRequestId) {
        if (!(contentsReference == null || openContentsRequestId == 0)) {
            zzx.zzb(contentsReference.getRequestId() == openContentsRequestId, (Object) "inconsistent contents reference");
        }
        if ((fileType == null || fileType.intValue() == 0) && contentsReference == null && openContentsRequestId == 0) {
            throw new IllegalArgumentException("Need a valid contents");
        }
        this.mVersionCode = versionCode;
        this.zzaov = (DriveId) zzx.zzy(parentDriveId);
        this.zzaot = (MetadataBundle) zzx.zzy(metadata);
        this.zzaoj = contentsReference;
        this.zzaou = fileType;
        this.zzanc = trackingTag;
        this.zzaow = createStrategy;
        this.zzaob = sendEventOnCompletion;
        this.zzaox = openContentsRequestId;
    }

    public CreateFileRequest(DriveId parentDriveId, MetadataBundle metadata, int openContentsRequestId, int fileType, ExecutionOptions executionOptions) {
        this(2, parentDriveId, metadata, null, Integer.valueOf(fileType), executionOptions.zzsm(), executionOptions.zzsl(), executionOptions.zzsn(), openContentsRequestId);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzn.zza(this, dest, flags);
    }
}
