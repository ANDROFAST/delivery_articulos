package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BooleanResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.CreateFileActivityBuilder;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveApi.DriveIdResult;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.OpenFileActivityBuilder;
import com.google.android.gms.drive.query.Query;
import java.util.List;

public class zzs implements DriveApi {

    static class zzb implements Releasable, DriveContentsResult {
        private final Status zzTA;
        private final DriveContents zzamI;

        public zzb(Status status, DriveContents driveContents) {
            this.zzTA = status;
            this.zzamI = driveContents;
        }

        public DriveContents getDriveContents() {
            return this.zzamI;
        }

        public Status getStatus() {
            return this.zzTA;
        }

        public void release() {
            if (this.zzamI != null) {
                this.zzamI.zzsi();
            }
        }
    }

    private static class zze implements DriveIdResult {
        private final Status zzTA;
        private final DriveId zzamF;

        public zze(Status status, DriveId driveId) {
            this.zzTA = status;
            this.zzamF = driveId;
        }

        public DriveId getDriveId() {
            return this.zzamF;
        }

        public Status getStatus() {
            return this.zzTA;
        }
    }

    static class zzg implements MetadataBufferResult {
        private final Status zzTA;
        private final MetadataBuffer zzaoF;
        private final boolean zzaoG;

        public zzg(Status status, MetadataBuffer metadataBuffer, boolean z) {
            this.zzTA = status;
            this.zzaoF = metadataBuffer;
            this.zzaoG = z;
        }

        public MetadataBuffer getMetadataBuffer() {
            return this.zzaoF;
        }

        public Status getStatus() {
            return this.zzTA;
        }

        public void release() {
            if (this.zzaoF != null) {
                this.zzaoF.release();
            }
        }
    }

    private static class zza extends zzd {
        private final com.google.android.gms.internal.zzlx.zzb<DriveContentsResult> zzakL;

        public zza(com.google.android.gms.internal.zzlx.zzb<DriveContentsResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_drive_DriveApi_DriveContentsResult) {
            this.zzakL = com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_drive_DriveApi_DriveContentsResult;
        }

        public void zzA(Status status) throws RemoteException {
            this.zzakL.zzr(new zzb(status, null));
        }

        public void zza(OnContentsResponse onContentsResponse) throws RemoteException {
            this.zzakL.zzr(new zzb(Status.zzaeX, new zzv(onContentsResponse.zzsO())));
        }
    }

    static class zzd extends zzd {
        private final com.google.android.gms.internal.zzlx.zzb<DriveIdResult> zzakL;

        public zzd(com.google.android.gms.internal.zzlx.zzb<DriveIdResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_drive_DriveApi_DriveIdResult) {
            this.zzakL = com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_drive_DriveApi_DriveIdResult;
        }

        public void zzA(Status status) throws RemoteException {
            this.zzakL.zzr(new zze(status, null));
        }

        public void zza(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
            this.zzakL.zzr(new zze(Status.zzaeX, onDriveIdResponse.getDriveId()));
        }

        public void zza(OnMetadataResponse onMetadataResponse) throws RemoteException {
            this.zzakL.zzr(new zze(Status.zzaeX, new zzp(onMetadataResponse.zzsX()).getDriveId()));
        }
    }

    private static class zzi extends zzd {
        private final com.google.android.gms.internal.zzlx.zzb<MetadataBufferResult> zzakL;

        public zzi(com.google.android.gms.internal.zzlx.zzb<MetadataBufferResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_drive_DriveApi_MetadataBufferResult) {
            this.zzakL = com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_drive_DriveApi_MetadataBufferResult;
        }

        public void zzA(Status status) throws RemoteException {
            this.zzakL.zzr(new zzg(status, null, false));
        }

        public void zza(OnListEntriesResponse onListEntriesResponse) throws RemoteException {
            this.zzakL.zzr(new zzg(Status.zzaeX, new MetadataBuffer(onListEntriesResponse.zzsU()), onListEntriesResponse.zzsV()));
        }
    }

    static abstract class zzc extends zzt<DriveContentsResult> {
        zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public DriveContentsResult zzC(Status status) {
            return new zzb(status, null);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzC(status);
        }
    }

    static abstract class zzf extends zzt<DriveIdResult> {
        zzf(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public DriveIdResult zzD(Status status) {
            return new zze(status, null);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzD(status);
        }
    }

    static abstract class zzh extends zzt<MetadataBufferResult> {
        zzh(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public MetadataBufferResult zzE(Status status) {
            return new zzg(status, null, false);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzE(status);
        }
    }

    static class zzj extends com.google.android.gms.drive.internal.zzt.zza {
        zzj(GoogleApiClient googleApiClient, Status status) {
            super(googleApiClient);
            zzb(status);
        }

        protected void zza(zzu com_google_android_gms_drive_internal_zzu) {
        }
    }

    public PendingResult<Status> cancelPendingActions(GoogleApiClient apiClient, List<String> trackingTags) {
        return ((zzu) apiClient.zza(Drive.zzTo)).cancelPendingActions(apiClient, trackingTags);
    }

    public PendingResult<DriveIdResult> fetchDriveId(GoogleApiClient apiClient, final String resourceId) {
        return apiClient.zza(new zzf(this, apiClient) {
            final /* synthetic */ zzs zzaoA;

            protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                com_google_android_gms_drive_internal_zzu.zzsF().zza(new GetMetadataRequest(DriveId.zzcQ(resourceId), false), new zzd(this));
            }
        });
    }

    public DriveFolder getAppFolder(GoogleApiClient apiClient) {
        zzu com_google_android_gms_drive_internal_zzu = (zzu) apiClient.zza(Drive.zzTo);
        if (com_google_android_gms_drive_internal_zzu.zzsI()) {
            DriveId zzsH = com_google_android_gms_drive_internal_zzu.zzsH();
            return zzsH != null ? new zzy(zzsH) : null;
        } else {
            throw new IllegalStateException("Client is not yet connected");
        }
    }

    public DriveFile getFile(GoogleApiClient apiClient, DriveId driveId) {
        if (driveId == null) {
            throw new IllegalArgumentException("Id must be provided.");
        } else if (apiClient.isConnected()) {
            return new zzw(driveId);
        } else {
            throw new IllegalStateException("Client must be connected");
        }
    }

    public DriveFolder getFolder(GoogleApiClient apiClient, DriveId driveId) {
        if (driveId == null) {
            throw new IllegalArgumentException("Id must be provided.");
        } else if (apiClient.isConnected()) {
            return new zzy(driveId);
        } else {
            throw new IllegalStateException("Client must be connected");
        }
    }

    public DriveFolder getRootFolder(GoogleApiClient apiClient) {
        zzu com_google_android_gms_drive_internal_zzu = (zzu) apiClient.zza(Drive.zzTo);
        if (com_google_android_gms_drive_internal_zzu.zzsI()) {
            DriveId zzsG = com_google_android_gms_drive_internal_zzu.zzsG();
            return zzsG != null ? new zzy(zzsG) : null;
        } else {
            throw new IllegalStateException("Client is not yet connected");
        }
    }

    public PendingResult<BooleanResult> isAutobackupEnabled(GoogleApiClient apiClient) {
        return apiClient.zza(new zzt<BooleanResult>(this, apiClient) {
            final /* synthetic */ zzs zzaoA;

            protected BooleanResult zzB(Status status) {
                return new BooleanResult(status, false);
            }

            protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                com_google_android_gms_drive_internal_zzu.zzsF().zze(new zzd(this) {
                    final /* synthetic */ C12065 zzaoE;

                    public void zzac(boolean z) {
                        this.zzb(new BooleanResult(Status.zzaeX, z));
                    }
                });
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzB(status);
            }
        });
    }

    public CreateFileActivityBuilder newCreateFileActivityBuilder() {
        return new CreateFileActivityBuilder();
    }

    public PendingResult<DriveContentsResult> newDriveContents(GoogleApiClient apiClient) {
        return zza(apiClient, DriveFile.MODE_WRITE_ONLY);
    }

    public OpenFileActivityBuilder newOpenFileActivityBuilder() {
        return new OpenFileActivityBuilder();
    }

    public PendingResult<MetadataBufferResult> query(GoogleApiClient apiClient, final Query query) {
        if (query != null) {
            return apiClient.zza(new zzh(this, apiClient) {
                final /* synthetic */ zzs zzaoA;

                protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                    com_google_android_gms_drive_internal_zzu.zzsF().zza(new QueryRequest(query), new zzi(this));
                }
            });
        }
        throw new IllegalArgumentException("Query must be provided.");
    }

    public PendingResult<Status> requestSync(GoogleApiClient apiClient) {
        return apiClient.zzb(new com.google.android.gms.drive.internal.zzt.zza(this, apiClient) {
            final /* synthetic */ zzs zzaoA;

            protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                com_google_android_gms_drive_internal_zzu.zzsF().zza(new zzbt(this));
            }
        });
    }

    public PendingResult<DriveContentsResult> zza(GoogleApiClient googleApiClient, final int i) {
        return googleApiClient.zza(new zzc(this, googleApiClient) {
            final /* synthetic */ zzs zzaoA;

            protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                com_google_android_gms_drive_internal_zzu.zzsF().zza(new CreateContentsRequest(i), new zza(this));
            }
        });
    }
}
