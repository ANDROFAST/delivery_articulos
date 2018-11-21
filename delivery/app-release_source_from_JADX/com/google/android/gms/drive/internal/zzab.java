package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.drive.DriveResource.MetadataResult;
import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.events.ChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class zzab implements DriveResource {
    protected final DriveId zzamF;

    private static class zzc implements MetadataResult {
        private final Status zzTA;
        private final Metadata zzapw;

        public zzc(Status status, Metadata metadata) {
            this.zzTA = status;
            this.zzapw = metadata;
        }

        public Metadata getMetadata() {
            return this.zzapw;
        }

        public Status getStatus() {
            return this.zzTA;
        }
    }

    private static class zza extends zzd {
        private final com.google.android.gms.internal.zzlx.zzb<MetadataBufferResult> zzakL;

        public zza(com.google.android.gms.internal.zzlx.zzb<MetadataBufferResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_drive_DriveApi_MetadataBufferResult) {
            this.zzakL = com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_drive_DriveApi_MetadataBufferResult;
        }

        public void zzA(Status status) throws RemoteException {
            this.zzakL.zzr(new zzg(status, null, false));
        }

        public void zza(OnListParentsResponse onListParentsResponse) throws RemoteException {
            this.zzakL.zzr(new zzg(Status.zzaeX, new MetadataBuffer(onListParentsResponse.zzsW()), false));
        }
    }

    private static class zzb extends zzd {
        private final com.google.android.gms.internal.zzlx.zzb<MetadataResult> zzakL;

        public zzb(com.google.android.gms.internal.zzlx.zzb<MetadataResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_drive_DriveResource_MetadataResult) {
            this.zzakL = com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_drive_DriveResource_MetadataResult;
        }

        public void zzA(Status status) throws RemoteException {
            this.zzakL.zzr(new zzc(status, null));
        }

        public void zza(OnMetadataResponse onMetadataResponse) throws RemoteException {
            this.zzakL.zzr(new zzc(Status.zzaeX, new zzp(onMetadataResponse.zzsX())));
        }
    }

    private abstract class zzd extends zzt<MetadataResult> {
        final /* synthetic */ zzab zzapu;

        private zzd(zzab com_google_android_gms_drive_internal_zzab, GoogleApiClient googleApiClient) {
            this.zzapu = com_google_android_gms_drive_internal_zzab;
            super(googleApiClient);
        }

        public MetadataResult zzI(Status status) {
            return new zzc(status, null);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzI(status);
        }
    }

    public zzab(DriveId driveId) {
        this.zzamF = driveId;
    }

    private PendingResult<MetadataResult> zza(GoogleApiClient googleApiClient, final boolean z) {
        return googleApiClient.zza(new zzd(this, googleApiClient) {
            final /* synthetic */ zzab zzapu;

            protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                com_google_android_gms_drive_internal_zzu.zzsF().zza(new GetMetadataRequest(this.zzapu.zzamF, z), new zzb(this));
            }
        });
    }

    public PendingResult<Status> addChangeListener(GoogleApiClient apiClient, ChangeListener listener) {
        return ((zzu) apiClient.zza(Drive.zzTo)).zza(apiClient, this.zzamF, listener);
    }

    public PendingResult<Status> addChangeSubscription(GoogleApiClient apiClient) {
        return ((zzu) apiClient.zza(Drive.zzTo)).zza(apiClient, this.zzamF);
    }

    public PendingResult<Status> delete(GoogleApiClient apiClient) {
        return apiClient.zzb(new com.google.android.gms.drive.internal.zzt.zza(this, apiClient) {
            final /* synthetic */ zzab zzapu;

            protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                com_google_android_gms_drive_internal_zzu.zzsF().zza(new DeleteResourceRequest(this.zzapu.zzamF), new zzbt(this));
            }
        });
    }

    public DriveId getDriveId() {
        return this.zzamF;
    }

    public PendingResult<MetadataResult> getMetadata(GoogleApiClient apiClient) {
        return zza(apiClient, false);
    }

    public PendingResult<MetadataBufferResult> listParents(GoogleApiClient apiClient) {
        return apiClient.zza(new zzh(this, apiClient) {
            final /* synthetic */ zzab zzapu;

            protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                com_google_android_gms_drive_internal_zzu.zzsF().zza(new ListParentsRequest(this.zzapu.zzamF), new zza(this));
            }
        });
    }

    public PendingResult<Status> removeChangeListener(GoogleApiClient apiClient, ChangeListener listener) {
        return ((zzu) apiClient.zza(Drive.zzTo)).zzb(apiClient, this.zzamF, listener);
    }

    public PendingResult<Status> removeChangeSubscription(GoogleApiClient apiClient) {
        return ((zzu) apiClient.zza(Drive.zzTo)).zzb(apiClient, this.zzamF);
    }

    public PendingResult<Status> setParents(GoogleApiClient apiClient, Set<DriveId> parentIds) {
        if (parentIds == null) {
            throw new IllegalArgumentException("ParentIds must be provided.");
        }
        final List arrayList = new ArrayList(parentIds);
        return apiClient.zzb(new com.google.android.gms.drive.internal.zzt.zza(this, apiClient) {
            final /* synthetic */ zzab zzapu;

            protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                com_google_android_gms_drive_internal_zzu.zzsF().zza(new SetResourceParentsRequest(this.zzapu.zzamF, arrayList), new zzbt(this));
            }
        });
    }

    public PendingResult<Status> trash(GoogleApiClient apiClient) {
        return apiClient.zzb(new com.google.android.gms.drive.internal.zzt.zza(this, apiClient) {
            final /* synthetic */ zzab zzapu;

            protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                com_google_android_gms_drive_internal_zzu.zzsF().zza(new TrashResourceRequest(this.zzapu.zzamF), new zzbt(this));
            }
        });
    }

    public PendingResult<Status> untrash(GoogleApiClient apiClient) {
        return apiClient.zzb(new com.google.android.gms.drive.internal.zzt.zza(this, apiClient) {
            final /* synthetic */ zzab zzapu;

            protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                com_google_android_gms_drive_internal_zzu.zzsF().zza(new UntrashResourceRequest(this.zzapu.zzamF), new zzbt(this));
            }
        });
    }

    public PendingResult<MetadataResult> updateMetadata(GoogleApiClient apiClient, final MetadataChangeSet changeSet) {
        if (changeSet != null) {
            return apiClient.zzb(new zzd(this, apiClient) {
                final /* synthetic */ zzab zzapu;

                protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                    changeSet.zzsp().setContext(com_google_android_gms_drive_internal_zzu.getContext());
                    com_google_android_gms_drive_internal_zzu.zzsF().zza(new UpdateMetadataRequest(this.zzapu.zzamF, changeSet.zzsp()), new zzb(this));
                }
            });
        }
        throw new IllegalArgumentException("ChangeSet must be provided.");
    }
}
