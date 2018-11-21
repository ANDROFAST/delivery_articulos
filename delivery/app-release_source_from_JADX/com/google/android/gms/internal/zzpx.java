package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.RecordingApi;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.fitness.request.ListSubscriptionsRequest;
import com.google.android.gms.fitness.request.SubscribeRequest;
import com.google.android.gms.fitness.request.UnsubscribeRequest;
import com.google.android.gms.fitness.result.ListSubscriptionsResult;
import com.google.android.gms.internal.zzlx.zzb;

public class zzpx implements RecordingApi {

    private static class zza extends com.google.android.gms.internal.zzpk.zza {
        private final zzb<ListSubscriptionsResult> zzakL;

        private zza(zzb<ListSubscriptionsResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_fitness_result_ListSubscriptionsResult) {
            this.zzakL = com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_fitness_result_ListSubscriptionsResult;
        }

        public void zza(ListSubscriptionsResult listSubscriptionsResult) {
            this.zzakL.zzr(listSubscriptionsResult);
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, final Subscription subscription) {
        return googleApiClient.zza(new zzc(this, googleApiClient) {
            final /* synthetic */ zzpx zzaxK;

            protected void zza(zzow com_google_android_gms_internal_zzow) throws RemoteException {
                ((zzph) com_google_android_gms_internal_zzow.zzqs()).zza(new SubscribeRequest(subscription, false, new zzqa(this)));
            }
        });
    }

    public PendingResult<ListSubscriptionsResult> listSubscriptions(GoogleApiClient client) {
        return client.zza(new zza<ListSubscriptionsResult>(this, client) {
            final /* synthetic */ zzpx zzaxK;

            protected ListSubscriptionsResult zzN(Status status) {
                return ListSubscriptionsResult.zzU(status);
            }

            protected void zza(zzow com_google_android_gms_internal_zzow) throws RemoteException {
                ((zzph) com_google_android_gms_internal_zzow.zzqs()).zza(new ListSubscriptionsRequest(null, new zza(this)));
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzN(status);
            }
        });
    }

    public PendingResult<ListSubscriptionsResult> listSubscriptions(GoogleApiClient client, final DataType dataType) {
        return client.zza(new zza<ListSubscriptionsResult>(this, client) {
            final /* synthetic */ zzpx zzaxK;

            protected ListSubscriptionsResult zzN(Status status) {
                return ListSubscriptionsResult.zzU(status);
            }

            protected void zza(zzow com_google_android_gms_internal_zzow) throws RemoteException {
                ((zzph) com_google_android_gms_internal_zzow.zzqs()).zza(new ListSubscriptionsRequest(dataType, new zza(this)));
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzN(status);
            }
        });
    }

    public PendingResult<Status> subscribe(GoogleApiClient client, DataSource dataSource) {
        return zza(client, new com.google.android.gms.fitness.data.Subscription.zza().zzb(dataSource).zztW());
    }

    public PendingResult<Status> subscribe(GoogleApiClient client, DataType dataType) {
        return zza(client, new com.google.android.gms.fitness.data.Subscription.zza().zzb(dataType).zztW());
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient client, final DataSource dataSource) {
        return client.zzb(new zzc(this, client) {
            final /* synthetic */ zzpx zzaxK;

            protected void zza(zzow com_google_android_gms_internal_zzow) throws RemoteException {
                ((zzph) com_google_android_gms_internal_zzow.zzqs()).zza(new UnsubscribeRequest(null, dataSource, new zzqa(this)));
            }
        });
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient client, final DataType dataType) {
        return client.zzb(new zzc(this, client) {
            final /* synthetic */ zzpx zzaxK;

            protected void zza(zzow com_google_android_gms_internal_zzow) throws RemoteException {
                ((zzph) com_google_android_gms_internal_zzow.zzqs()).zza(new UnsubscribeRequest(dataType, null, new zzqa(this)));
            }
        });
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient client, Subscription subscription) {
        return subscription.getDataType() == null ? unsubscribe(client, subscription.getDataSource()) : unsubscribe(client, subscription.getDataType());
    }
}
