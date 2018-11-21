package com.google.android.gms.drive;

import android.content.IntentSender;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.internal.zzl;
import com.google.android.gms.drive.internal.zzv;

public class CreateFileActivityBuilder {
    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
    private final zzl zzamH = new zzl(0);
    private DriveContents zzamI;
    private boolean zzamJ;

    public IntentSender build(GoogleApiClient apiClient) {
        zzx.zzb(Boolean.valueOf(this.zzamJ), (Object) "Must call setInitialDriveContents to CreateFileActivityBuilder.");
        zzx.zza(apiClient.isConnected(), (Object) "Client must be connected");
        if (this.zzamI != null) {
            this.zzamI.zzsi();
        }
        return this.zzamH.build(apiClient);
    }

    public CreateFileActivityBuilder setActivityStartFolder(DriveId folder) {
        this.zzamH.zza(folder);
        return this;
    }

    public CreateFileActivityBuilder setActivityTitle(String title) {
        this.zzamH.zzcT(title);
        return this;
    }

    public CreateFileActivityBuilder setInitialDriveContents(DriveContents driveContents) {
        if (driveContents == null) {
            this.zzamH.zzcW(1);
        } else if (!(driveContents instanceof zzv)) {
            throw new IllegalArgumentException("Only DriveContents obtained from the Drive API are accepted.");
        } else if (driveContents.getDriveId() != null) {
            throw new IllegalArgumentException("Only DriveContents obtained through DriveApi.newDriveContents are accepted for file creation.");
        } else if (driveContents.zzsj()) {
            throw new IllegalArgumentException("DriveContents are already closed.");
        } else {
            this.zzamH.zzcW(driveContents.zzsh().getRequestId());
            this.zzamI = driveContents;
        }
        this.zzamJ = true;
        return this;
    }

    public CreateFileActivityBuilder setInitialMetadata(MetadataChangeSet metadataChangeSet) {
        this.zzamH.zza(metadataChangeSet);
        return this;
    }
}
