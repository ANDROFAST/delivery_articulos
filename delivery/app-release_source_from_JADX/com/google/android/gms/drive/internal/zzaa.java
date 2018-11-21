package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DrivePreferencesApi;
import com.google.android.gms.drive.DrivePreferencesApi.FileUploadPreferencesResult;
import com.google.android.gms.drive.FileUploadPreferences;

public class zzaa implements DrivePreferencesApi {

    private class zzb implements FileUploadPreferencesResult {
        private final Status zzTA;
        final /* synthetic */ zzaa zzapq;
        private final FileUploadPreferences zzaps;

        private zzb(zzaa com_google_android_gms_drive_internal_zzaa, Status status, FileUploadPreferences fileUploadPreferences) {
            this.zzapq = com_google_android_gms_drive_internal_zzaa;
            this.zzTA = status;
            this.zzaps = fileUploadPreferences;
        }

        public FileUploadPreferences getFileUploadPreferences() {
            return this.zzaps;
        }

        public Status getStatus() {
            return this.zzTA;
        }
    }

    private class zza extends zzd {
        private final com.google.android.gms.internal.zzlx.zzb<FileUploadPreferencesResult> zzakL;
        final /* synthetic */ zzaa zzapq;

        private zza(zzaa com_google_android_gms_drive_internal_zzaa, com.google.android.gms.internal.zzlx.zzb<FileUploadPreferencesResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_drive_DrivePreferencesApi_FileUploadPreferencesResult) {
            this.zzapq = com_google_android_gms_drive_internal_zzaa;
            this.zzakL = com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_drive_DrivePreferencesApi_FileUploadPreferencesResult;
        }

        public void zzA(Status status) throws RemoteException {
            this.zzakL.zzr(new zzb(status, null));
        }

        public void zza(OnDeviceUsagePreferenceResponse onDeviceUsagePreferenceResponse) throws RemoteException {
            this.zzakL.zzr(new zzb(Status.zzaeX, onDeviceUsagePreferenceResponse.zzsQ()));
        }
    }

    private abstract class zzc extends zzt<FileUploadPreferencesResult> {
        final /* synthetic */ zzaa zzapq;

        public zzc(zzaa com_google_android_gms_drive_internal_zzaa, GoogleApiClient googleApiClient) {
            this.zzapq = com_google_android_gms_drive_internal_zzaa;
            super(googleApiClient);
        }

        protected FileUploadPreferencesResult zzH(Status status) {
            return new zzb(status, null);
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzH(status);
        }
    }

    public PendingResult<FileUploadPreferencesResult> getFileUploadPreferences(GoogleApiClient apiClient) {
        return apiClient.zza(new zzc(this, apiClient) {
            final /* synthetic */ zzaa zzapq;

            protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                com_google_android_gms_drive_internal_zzu.zzsF().zzd(new zza(this));
            }
        });
    }

    public PendingResult<Status> setFileUploadPreferences(GoogleApiClient apiClient, FileUploadPreferences fileUploadPreferences) {
        if (fileUploadPreferences instanceof FileUploadPreferencesImpl) {
            final FileUploadPreferencesImpl fileUploadPreferencesImpl = (FileUploadPreferencesImpl) fileUploadPreferences;
            return apiClient.zzb(new com.google.android.gms.drive.internal.zzt.zza(this, apiClient) {
                final /* synthetic */ zzaa zzapq;

                protected void zza(zzu com_google_android_gms_drive_internal_zzu) throws RemoteException {
                    com_google_android_gms_drive_internal_zzu.zzsF().zza(new SetFileUploadPreferencesRequest(fileUploadPreferencesImpl), new zzbt(this));
                }
            });
        }
        throw new IllegalArgumentException("Invalid preference value");
    }
}
