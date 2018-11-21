package com.google.android.gms.internal;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.HistoryApi;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.DailyTotalRequest;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataInsertRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.result.DailyTotalResult;
import com.google.android.gms.fitness.result.DataReadResult;
import com.google.android.gms.internal.zzlx.zzb;

public class zzpv implements HistoryApi {

    private static class zza extends com.google.android.gms.internal.zzpa.zza {
        private final zzb<DataReadResult> zzakL;
        private int zzaxI;
        private DataReadResult zzaxJ;

        private zza(zzb<DataReadResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_fitness_result_DataReadResult) {
            this.zzaxI = 0;
            this.zzaxJ = null;
            this.zzakL = com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_fitness_result_DataReadResult;
        }

        public void zza(DataReadResult dataReadResult) {
            synchronized (this) {
                if (Log.isLoggable("Fitness", 2)) {
                    Log.v("Fitness", "Received batch result " + this.zzaxI);
                }
                if (this.zzaxJ == null) {
                    this.zzaxJ = dataReadResult;
                } else {
                    this.zzaxJ.zzb(dataReadResult);
                }
                this.zzaxI++;
                if (this.zzaxI == this.zzaxJ.zzuH()) {
                    this.zzakL.zzr(this.zzaxJ);
                }
            }
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, final DataSet dataSet, final boolean z) {
        zzx.zzb((Object) dataSet, (Object) "Must set the data set");
        zzx.zza(!dataSet.getDataPoints().isEmpty(), (Object) "Cannot use an empty data set");
        zzx.zzb(dataSet.getDataSource().zztK(), (Object) "Must set the app package name for the data source");
        return googleApiClient.zza(new zzc(this, googleApiClient) {
            final /* synthetic */ zzpv zzaxD;

            protected void zza(zzou com_google_android_gms_internal_zzou) throws RemoteException {
                ((zzpf) com_google_android_gms_internal_zzou.zzqs()).zza(new DataInsertRequest(dataSet, new zzqa(this), z));
            }
        });
    }

    public PendingResult<Status> deleteData(GoogleApiClient client, final DataDeleteRequest request) {
        return client.zza(new zzc(this, client) {
            final /* synthetic */ zzpv zzaxD;

            protected void zza(zzou com_google_android_gms_internal_zzou) throws RemoteException {
                ((zzpf) com_google_android_gms_internal_zzou.zzqs()).zza(new DataDeleteRequest(request, new zzqa(this)));
            }
        });
    }

    public PendingResult<Status> insertData(GoogleApiClient client, DataSet dataSet) {
        return zza(client, dataSet, false);
    }

    public PendingResult<DailyTotalResult> readDailyTotal(GoogleApiClient client, final DataType dataType) {
        return client.zza(new zza<DailyTotalResult>(this, client) {
            final /* synthetic */ zzpv zzaxD;

            class C11471 extends com.google.android.gms.internal.zzoz.zza {
                final /* synthetic */ C12194 zzaxH;

                C11471(C12194 c12194) {
                    this.zzaxH = c12194;
                }

                public void zza(DailyTotalResult dailyTotalResult) throws RemoteException {
                    this.zzaxH.zzb(dailyTotalResult);
                }
            }

            protected DailyTotalResult zzM(Status status) {
                return DailyTotalResult.zza(status, dataType);
            }

            protected void zza(zzou com_google_android_gms_internal_zzou) throws RemoteException {
                ((zzpf) com_google_android_gms_internal_zzou.zzqs()).zza(new DailyTotalRequest(new C11471(this), dataType));
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzM(status);
            }
        });
    }

    public PendingResult<DataReadResult> readData(GoogleApiClient client, final DataReadRequest request) {
        return client.zza(new zza<DataReadResult>(this, client) {
            final /* synthetic */ zzpv zzaxD;

            protected DataReadResult zzL(Status status) {
                return DataReadResult.zza(status, request);
            }

            protected void zza(zzou com_google_android_gms_internal_zzou) throws RemoteException {
                ((zzpf) com_google_android_gms_internal_zzou.zzqs()).zza(new DataReadRequest(request, new zza(this)));
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzL(status);
            }
        });
    }
}
