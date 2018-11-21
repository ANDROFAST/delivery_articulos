package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.SensorsApi;
import com.google.android.gms.fitness.data.zzj;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.OnDataPointListener;
import com.google.android.gms.fitness.request.SensorRegistrationRequest;
import com.google.android.gms.fitness.request.SensorRequest;
import com.google.android.gms.fitness.request.SensorUnregistrationRequest;
import com.google.android.gms.fitness.result.DataSourcesResult;

public class zzpy implements SensorsApi {

    private interface zza {
        void zzuf();
    }

    private static class zzb extends com.google.android.gms.internal.zzpb.zza {
        private final com.google.android.gms.internal.zzlx.zzb<DataSourcesResult> zzakL;

        private zzb(com.google.android.gms.internal.zzlx.zzb<DataSourcesResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_fitness_result_DataSourcesResult) {
            this.zzakL = com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_fitness_result_DataSourcesResult;
        }

        public void zza(DataSourcesResult dataSourcesResult) {
            this.zzakL.zzr(dataSourcesResult);
        }
    }

    private static class zzc extends com.google.android.gms.internal.zzpp.zza {
        private final com.google.android.gms.internal.zzlx.zzb<Status> zzakL;
        private final zza zzaxW;

        private zzc(com.google.android.gms.internal.zzlx.zzb<Status> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status, zza com_google_android_gms_internal_zzpy_zza) {
            this.zzakL = com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status;
            this.zzaxW = com_google_android_gms_internal_zzpy_zza;
        }

        public void zzp(Status status) {
            if (this.zzaxW != null && status.isSuccess()) {
                this.zzaxW.zzuf();
            }
            this.zzakL.zzr(status);
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, zzj com_google_android_gms_fitness_data_zzj, PendingIntent pendingIntent, zza com_google_android_gms_internal_zzpy_zza) {
        final zza com_google_android_gms_internal_zzpy_zza2 = com_google_android_gms_internal_zzpy_zza;
        final zzj com_google_android_gms_fitness_data_zzj2 = com_google_android_gms_fitness_data_zzj;
        final PendingIntent pendingIntent2 = pendingIntent;
        return googleApiClient.zzb(new zzc(this, googleApiClient) {
            final /* synthetic */ zzpy zzaxO;

            protected void zza(zzox com_google_android_gms_internal_zzox) throws RemoteException {
                ((zzpi) com_google_android_gms_internal_zzox.zzqs()).zza(new SensorUnregistrationRequest(com_google_android_gms_fitness_data_zzj2, pendingIntent2, new zzc(this, com_google_android_gms_internal_zzpy_zza2)));
            }

            protected Status zzb(Status status) {
                return status;
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzb(status);
            }
        });
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, SensorRequest sensorRequest, zzj com_google_android_gms_fitness_data_zzj, PendingIntent pendingIntent) {
        final SensorRequest sensorRequest2 = sensorRequest;
        final zzj com_google_android_gms_fitness_data_zzj2 = com_google_android_gms_fitness_data_zzj;
        final PendingIntent pendingIntent2 = pendingIntent;
        return googleApiClient.zza(new zzc(this, googleApiClient) {
            final /* synthetic */ zzpy zzaxO;

            protected void zza(zzox com_google_android_gms_internal_zzox) throws RemoteException {
                ((zzpi) com_google_android_gms_internal_zzox.zzqs()).zza(new SensorRegistrationRequest(sensorRequest2, com_google_android_gms_fitness_data_zzj2, pendingIntent2, new zzqa(this)));
            }

            protected Status zzb(Status status) {
                return status;
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzb(status);
            }
        });
    }

    public PendingResult<Status> add(GoogleApiClient client, SensorRequest request, PendingIntent intent) {
        return zza(client, request, null, intent);
    }

    public PendingResult<Status> add(GoogleApiClient client, SensorRequest request, OnDataPointListener listener) {
        return zza(client, request, com.google.android.gms.fitness.data.zzk.zza.zztQ().zza(listener), null);
    }

    public PendingResult<DataSourcesResult> findDataSources(GoogleApiClient client, final DataSourcesRequest request) {
        return client.zza(new zza<DataSourcesResult>(this, client) {
            final /* synthetic */ zzpy zzaxO;

            protected DataSourcesResult zzO(Status status) {
                return DataSourcesResult.zzS(status);
            }

            protected void zza(zzox com_google_android_gms_internal_zzox) throws RemoteException {
                ((zzpi) com_google_android_gms_internal_zzox.zzqs()).zza(new DataSourcesRequest(request, new zzb(this)));
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzO(status);
            }
        });
    }

    public PendingResult<Status> remove(GoogleApiClient client, PendingIntent pendingIntent) {
        return zza(client, null, pendingIntent, null);
    }

    public PendingResult<Status> remove(GoogleApiClient client, final OnDataPointListener listener) {
        zzj zzb = com.google.android.gms.fitness.data.zzk.zza.zztQ().zzb(listener);
        return zzb == null ? PendingResults.zza(Status.zzaeX, client) : zza(client, zzb, null, new zza(this) {
            final /* synthetic */ zzpy zzaxO;

            public void zzuf() {
                com.google.android.gms.fitness.data.zzk.zza.zztQ().zzc(listener);
            }
        });
    }
}
