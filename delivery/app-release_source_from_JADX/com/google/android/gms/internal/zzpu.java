package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.ConfigApi;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;
import com.google.android.gms.fitness.request.DataTypeReadRequest;
import com.google.android.gms.fitness.request.DisableFitRequest;
import com.google.android.gms.fitness.result.DataTypeResult;
import com.google.android.gms.internal.zzlx.zzb;

public class zzpu implements ConfigApi {

    private static class zza extends com.google.android.gms.internal.zzpc.zza {
        private final zzb<DataTypeResult> zzakL;

        private zza(zzb<DataTypeResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_fitness_result_DataTypeResult) {
            this.zzakL = com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_fitness_result_DataTypeResult;
        }

        public void zza(DataTypeResult dataTypeResult) {
            this.zzakL.zzr(dataTypeResult);
        }
    }

    public PendingResult<DataTypeResult> createCustomDataType(GoogleApiClient client, final DataTypeCreateRequest request) {
        return client.zzb(new zza<DataTypeResult>(this, client) {
            final /* synthetic */ zzpu zzaxz;

            protected DataTypeResult zzK(Status status) {
                return DataTypeResult.zzT(status);
            }

            protected void zza(zzot com_google_android_gms_internal_zzot) throws RemoteException {
                ((zzpe) com_google_android_gms_internal_zzot.zzqs()).zza(new DataTypeCreateRequest(request, new zza(this)));
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzK(status);
            }
        });
    }

    public PendingResult<Status> disableFit(GoogleApiClient client) {
        return client.zzb(new zzc(this, client) {
            final /* synthetic */ zzpu zzaxz;

            protected void zza(zzot com_google_android_gms_internal_zzot) throws RemoteException {
                ((zzpe) com_google_android_gms_internal_zzot.zzqs()).zza(new DisableFitRequest(new zzqa(this)));
            }
        });
    }

    public PendingResult<DataTypeResult> readDataType(GoogleApiClient client, final String dataTypeName) {
        return client.zza(new zza<DataTypeResult>(this, client) {
            final /* synthetic */ zzpu zzaxz;

            protected DataTypeResult zzK(Status status) {
                return DataTypeResult.zzT(status);
            }

            protected void zza(zzot com_google_android_gms_internal_zzot) throws RemoteException {
                ((zzpe) com_google_android_gms_internal_zzot.zzqs()).zza(new DataTypeReadRequest(dataTypeName, new zza(this)));
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzK(status);
            }
        });
    }
}
