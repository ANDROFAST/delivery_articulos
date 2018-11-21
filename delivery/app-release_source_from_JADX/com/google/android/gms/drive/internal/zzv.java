package com.google.android.gms.drive.internal;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.ExecutionOptions.Builder;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.internal.zzt.zza;
import com.google.android.gms.internal.zznt;
import java.io.InputStream;
import java.io.OutputStream;

public class zzv implements DriveContents {
    private boolean mClosed = false;
    private final Contents zzaoW;
    private boolean zzaoX = false;
    private boolean zzaoY = false;

    class C06553 implements ResultCallback<Status> {
        final /* synthetic */ zzv zzaoZ;

        C06553(zzv com_google_android_gms_drive_internal_zzv) {
            this.zzaoZ = com_google_android_gms_drive_internal_zzv;
        }

        public /* synthetic */ void onResult(Result x0) {
            zzp((Status) x0);
        }

        public void zzp(Status status) {
            if (status.isSuccess()) {
                zzz.zzz("DriveContentsImpl", "Contents discarded");
            } else {
                zzz.zzB("DriveContentsImpl", "Error discarding contents");
            }
        }
    }

    public zzv(Contents contents) {
        this.zzaoW = (Contents) zzx.zzy(contents);
    }

    public PendingResult<Status> commit(GoogleApiClient apiClient, MetadataChangeSet changeSet) {
        return commit(apiClient, changeSet, null);
    }

    public PendingResult<Status> commit(GoogleApiClient apiClient, MetadataChangeSet changeSet, ExecutionOptions executionOptions) {
        if (executionOptions == null) {
            executionOptions = new Builder().build();
        }
        if (this.zzaoW.getMode() == DriveFile.MODE_READ_ONLY) {
            throw new IllegalStateException("Cannot commit contents opened with MODE_READ_ONLY");
        } else if (!ExecutionOptions.zzcy(executionOptions.zzsn()) || this.zzaoW.zzsf()) {
            ExecutionOptions.zza(apiClient, executionOptions);
            if (zzsj()) {
                throw new IllegalStateException("DriveContents already closed.");
            } else if (getDriveId() == null) {
                throw new IllegalStateException("Only DriveContents obtained through DriveFile.open can be committed.");
            } else {
                if (changeSet == null) {
                    changeSet = MetadataChangeSet.zzanh;
                }
                zzsi();
                return apiClient.zzb(new zza(this, apiClient) {
                    final /* synthetic */ zzv zzaoZ;

                    protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                        changeSet.zzsp().setContext(com_google_android_gms_drive_internal_zzu.getContext());
                        com_google_android_gms_drive_internal_zzu.zzsF().zza(new CloseContentsAndUpdateMetadataRequest(this.zzaoZ.zzaoW.getDriveId(), changeSet.zzsp(), this.zzaoZ.zzaoW.getRequestId(), this.zzaoZ.zzaoW.zzsf(), executionOptions), new zzbt(this));
                    }
                });
            }
        } else {
            throw new IllegalStateException("DriveContents must be valid for conflict detection.");
        }
    }

    public void discard(GoogleApiClient apiClient) {
        if (zzsj()) {
            throw new IllegalStateException("DriveContents already closed.");
        }
        zzsi();
        ((C12924) apiClient.zzb(new zza(this, apiClient) {
            final /* synthetic */ zzv zzaoZ;

            protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                com_google_android_gms_drive_internal_zzu.zzsF().zza(new CloseContentsRequest(this.zzaoZ.zzaoW.getRequestId(), false), new zzbt(this));
            }
        })).setResultCallback(new C06553(this));
    }

    public DriveId getDriveId() {
        return this.zzaoW.getDriveId();
    }

    public InputStream getInputStream() {
        if (zzsj()) {
            throw new IllegalStateException("Contents have been closed, cannot access the input stream.");
        } else if (this.zzaoW.getMode() != DriveFile.MODE_READ_ONLY) {
            throw new IllegalStateException("getInputStream() can only be used with contents opened with MODE_READ_ONLY.");
        } else if (this.zzaoX) {
            throw new IllegalStateException("getInputStream() can only be called once per Contents instance.");
        } else {
            this.zzaoX = true;
            return this.zzaoW.getInputStream();
        }
    }

    public int getMode() {
        return this.zzaoW.getMode();
    }

    public OutputStream getOutputStream() {
        if (zzsj()) {
            throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
        } else if (this.zzaoW.getMode() != DriveFile.MODE_WRITE_ONLY) {
            throw new IllegalStateException("getOutputStream() can only be used with contents opened with MODE_WRITE_ONLY.");
        } else if (this.zzaoY) {
            throw new IllegalStateException("getOutputStream() can only be called once per Contents instance.");
        } else {
            this.zzaoY = true;
            return this.zzaoW.getOutputStream();
        }
    }

    public ParcelFileDescriptor getParcelFileDescriptor() {
        if (!zzsj()) {
            return this.zzaoW.getParcelFileDescriptor();
        }
        throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
    }

    public PendingResult<DriveContentsResult> reopenForWrite(GoogleApiClient apiClient) {
        if (zzsj()) {
            throw new IllegalStateException("DriveContents already closed.");
        } else if (this.zzaoW.getMode() != DriveFile.MODE_READ_ONLY) {
            throw new IllegalStateException("reopenForWrite can only be used with DriveContents opened with MODE_READ_ONLY.");
        } else {
            zzsi();
            return apiClient.zza(new zzc(this, apiClient) {
                final /* synthetic */ zzv zzaoZ;

                protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                    com_google_android_gms_drive_internal_zzu.zzsF().zza(new OpenContentsRequest(this.zzaoZ.getDriveId(), DriveFile.MODE_WRITE_ONLY, this.zzaoZ.zzaoW.getRequestId()), new zzbl(this, null));
                }
            });
        }
    }

    public Contents zzsh() {
        return this.zzaoW;
    }

    public void zzsi() {
        zznt.zza(this.zzaoW.getParcelFileDescriptor());
        this.mClosed = true;
    }

    public boolean zzsj() {
        return this.mClosed;
    }
}
