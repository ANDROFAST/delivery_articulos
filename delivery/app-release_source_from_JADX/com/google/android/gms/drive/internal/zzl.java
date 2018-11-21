package com.google.android.gms.drive.internal;

import android.content.IntentSender;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;

public class zzl {
    private String zzank;
    private DriveId zzann;
    protected MetadataChangeSet zzaoq;
    private Integer zzaor;
    private final int zzaos;

    public zzl(int i) {
        this.zzaos = i;
    }

    public IntentSender build(GoogleApiClient apiClient) {
        zzx.zzb(this.zzaoq, (Object) "Must provide initial metadata to CreateFileActivityBuilder.");
        zzx.zza(apiClient.isConnected(), (Object) "Client must be connected");
        zzu com_google_android_gms_drive_internal_zzu = (zzu) apiClient.zza(Drive.zzTo);
        this.zzaoq.zzsp().setContext(com_google_android_gms_drive_internal_zzu.getContext());
        try {
            return com_google_android_gms_drive_internal_zzu.zzsF().zza(new CreateFileIntentSenderRequest(this.zzaoq.zzsp(), this.zzaor == null ? 0 : this.zzaor.intValue(), this.zzank, this.zzann, this.zzaos));
        } catch (Throwable e) {
            throw new RuntimeException("Unable to connect Drive Play Service", e);
        }
    }

    public void zza(DriveId driveId) {
        this.zzann = (DriveId) zzx.zzy(driveId);
    }

    public void zza(MetadataChangeSet metadataChangeSet) {
        this.zzaoq = (MetadataChangeSet) zzx.zzy(metadataChangeSet);
    }

    public void zzcT(String str) {
        this.zzank = (String) zzx.zzy(str);
    }

    public void zzcW(int i) {
        this.zzaor = Integer.valueOf(i);
    }
}
