package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.games.request.Requests.LoadRequestSummariesResult;
import com.google.android.gms.games.request.Requests.LoadRequestsResult;
import com.google.android.gms.games.request.Requests.SendRequestResult;
import com.google.android.gms.games.request.Requests.UpdateRequestsResult;
import com.google.android.gms.internal.zzlx.zzb;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class RequestsImpl implements Requests {

    private static abstract class LoadRequestSummariesImpl extends BaseGamesApiMethodImpl<LoadRequestSummariesResult> {
        public LoadRequestSummariesResult zzay(final Status status) {
            return new LoadRequestSummariesResult(this) {
                final /* synthetic */ LoadRequestSummariesImpl zzaEE;

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzay(status);
        }
    }

    private static abstract class LoadRequestsImpl extends BaseGamesApiMethodImpl<LoadRequestsResult> {
        private LoadRequestsImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadRequestsResult zzaz(final Status status) {
            return new LoadRequestsResult(this) {
                final /* synthetic */ LoadRequestsImpl zzaEF;

                public GameRequestBuffer getRequests(int type) {
                    return new GameRequestBuffer(DataHolder.zzbJ(status.getStatusCode()));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaz(status);
        }
    }

    private static abstract class SendRequestImpl extends BaseGamesApiMethodImpl<SendRequestResult> {
        public SendRequestResult zzaA(final Status status) {
            return new SendRequestResult(this) {
                final /* synthetic */ SendRequestImpl zzaEG;

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaA(status);
        }
    }

    private static abstract class UpdateRequestsImpl extends BaseGamesApiMethodImpl<UpdateRequestsResult> {
        private UpdateRequestsImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public UpdateRequestsResult zzaB(final Status status) {
            return new UpdateRequestsResult(this) {
                final /* synthetic */ UpdateRequestsImpl zzaEH;

                public Set<String> getRequestIds() {
                    return null;
                }

                public int getRequestOutcome(String requestId) {
                    throw new IllegalArgumentException("Unknown request ID " + requestId);
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaB(status);
        }
    }

    class C13494 extends SendRequestImpl {
        final /* synthetic */ String zzaDi;
        final /* synthetic */ String[] zzaEA;
        final /* synthetic */ int zzaEB;
        final /* synthetic */ byte[] zzaEC;
        final /* synthetic */ int zzaED;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzaDi, this.zzaEA, this.zzaEB, this.zzaEC, this.zzaED);
        }
    }

    class C13505 extends SendRequestImpl {
        final /* synthetic */ String zzaDi;
        final /* synthetic */ String[] zzaEA;
        final /* synthetic */ int zzaEB;
        final /* synthetic */ byte[] zzaEC;
        final /* synthetic */ int zzaED;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzaDi, this.zzaEA, this.zzaEB, this.zzaEC, this.zzaED);
        }
    }

    class C13516 extends UpdateRequestsImpl {
        final /* synthetic */ String zzaDi;
        final /* synthetic */ String zzaEs;
        final /* synthetic */ String[] zzaEw;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzaDi, this.zzaEs, this.zzaEw);
        }
    }

    class C13527 extends LoadRequestsImpl {
        final /* synthetic */ int zzaDD;
        final /* synthetic */ String zzaDi;
        final /* synthetic */ String zzaEs;
        final /* synthetic */ int zzaEy;
        final /* synthetic */ int zzaEz;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzaDi, this.zzaEs, this.zzaEy, this.zzaEz, this.zzaDD);
        }
    }

    class C13538 extends LoadRequestSummariesImpl {
        final /* synthetic */ String zzaEs;
        final /* synthetic */ int zzaEz;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzf(this, this.zzaEs, this.zzaEz);
        }
    }

    public PendingResult<UpdateRequestsResult> acceptRequest(GoogleApiClient apiClient, String requestId) {
        List arrayList = new ArrayList();
        arrayList.add(requestId);
        return acceptRequests(apiClient, arrayList);
    }

    public PendingResult<UpdateRequestsResult> acceptRequests(GoogleApiClient apiClient, List<String> requestIds) {
        final String[] strArr = requestIds == null ? null : (String[]) requestIds.toArray(new String[requestIds.size()]);
        return apiClient.zzb(new UpdateRequestsImpl(this, apiClient) {
            final /* synthetic */ RequestsImpl zzaEx;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb((zzb) this, strArr);
            }
        });
    }

    public PendingResult<UpdateRequestsResult> dismissRequest(GoogleApiClient apiClient, String requestId) {
        List arrayList = new ArrayList();
        arrayList.add(requestId);
        return dismissRequests(apiClient, arrayList);
    }

    public PendingResult<UpdateRequestsResult> dismissRequests(GoogleApiClient apiClient, List<String> requestIds) {
        final String[] strArr = requestIds == null ? null : (String[]) requestIds.toArray(new String[requestIds.size()]);
        return apiClient.zzb(new UpdateRequestsImpl(this, apiClient) {
            final /* synthetic */ RequestsImpl zzaEx;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzc((zzb) this, strArr);
            }
        });
    }

    public ArrayList<GameRequest> getGameRequestsFromBundle(Bundle extras) {
        if (extras == null || !extras.containsKey(Requests.EXTRA_REQUESTS)) {
            return new ArrayList();
        }
        ArrayList arrayList = (ArrayList) extras.get(Requests.EXTRA_REQUESTS);
        ArrayList<GameRequest> arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList2.add((GameRequest) arrayList.get(i));
        }
        return arrayList2;
    }

    public ArrayList<GameRequest> getGameRequestsFromInboxResponse(Intent response) {
        return response == null ? new ArrayList() : getGameRequestsFromBundle(response.getExtras());
    }

    public Intent getInboxIntent(GoogleApiClient apiClient) {
        return Games.zzf(apiClient).zzwi();
    }

    public int getMaxLifetimeDays(GoogleApiClient apiClient) {
        return Games.zzf(apiClient).zzwk();
    }

    public int getMaxPayloadSize(GoogleApiClient apiClient) {
        return Games.zzf(apiClient).zzwj();
    }

    public Intent getSendIntent(GoogleApiClient apiClient, int type, byte[] payload, int requestLifetimeDays, Bitmap icon, String description) {
        return Games.zzf(apiClient).zza(type, payload, requestLifetimeDays, icon, description);
    }

    public PendingResult<LoadRequestsResult> loadRequests(GoogleApiClient apiClient, int requestDirection, int types, int sortOrder) {
        final int i = requestDirection;
        final int i2 = types;
        final int i3 = sortOrder;
        return apiClient.zza(new LoadRequestsImpl(this, apiClient) {
            final /* synthetic */ RequestsImpl zzaEx;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, i, i2, i3);
            }
        });
    }

    public void registerRequestListener(GoogleApiClient apiClient, OnRequestReceivedListener listener) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzd(apiClient.zzq(listener));
        }
    }

    public void unregisterRequestListener(GoogleApiClient apiClient) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzwc();
        }
    }
}
