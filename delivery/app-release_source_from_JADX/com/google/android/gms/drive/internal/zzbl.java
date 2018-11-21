package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveFile.DownloadProgressListener;
import com.google.android.gms.internal.zzlx.zzb;

class zzbl extends zzd {
    private final zzb<DriveContentsResult> zzakL;
    private final DownloadProgressListener zzaqu;

    zzbl(zzb<DriveContentsResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_drive_DriveApi_DriveContentsResult, DownloadProgressListener downloadProgressListener) {
        this.zzakL = com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_drive_DriveApi_DriveContentsResult;
        this.zzaqu = downloadProgressListener;
    }

    public void zzA(Status status) throws RemoteException {
        this.zzakL.zzr(new zzb(status, null));
    }

    public void zza(OnContentsResponse onContentsResponse) throws RemoteException {
        this.zzakL.zzr(new zzb(onContentsResponse.zzsP() ? new Status(-1) : Status.zzaeX, new zzv(onContentsResponse.zzsO())));
    }

    public void zza(OnDownloadProgressResponse onDownloadProgressResponse) throws RemoteException {
        if (this.zzaqu != null) {
            this.zzaqu.onProgress(onDownloadProgressResponse.zzsR(), onDownloadProgressResponse.zzsS());
        }
    }
}
