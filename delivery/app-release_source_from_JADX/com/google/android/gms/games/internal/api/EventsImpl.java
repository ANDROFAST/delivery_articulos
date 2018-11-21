package com.google.android.gms.games.internal.api;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.event.Events.LoadEventsResult;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.internal.zzlx.zzb;

public final class EventsImpl implements Events {

    private static abstract class LoadImpl extends BaseGamesApiMethodImpl<LoadEventsResult> {
        private LoadImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadEventsResult zzae(final Status status) {
            return new LoadEventsResult(this) {
                final /* synthetic */ LoadImpl zzaDw;

                public EventBuffer getEvents() {
                    return new EventBuffer(DataHolder.zzbJ(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzae(status);
        }
    }

    private static abstract class UpdateImpl extends BaseGamesApiMethodImpl<Result> {
        private UpdateImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public Result zzc(final Status status) {
            return new Result(this) {
                final /* synthetic */ UpdateImpl zzaDx;

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    public void increment(GoogleApiClient apiClient, final String eventId, final int incrementAmount) {
        GamesClientImpl zzc = Games.zzc(apiClient, false);
        if (zzc != null) {
            if (zzc.isConnected()) {
                zzc.zzp(eventId, incrementAmount);
            } else {
                apiClient.zzb(new UpdateImpl(this, apiClient) {
                    final /* synthetic */ EventsImpl zzaDt;

                    public void zza(GamesClientImpl gamesClientImpl) {
                        gamesClientImpl.zzp(eventId, incrementAmount);
                    }
                });
            }
        }
    }

    public PendingResult<LoadEventsResult> load(GoogleApiClient apiClient, final boolean forceReload) {
        return apiClient.zza(new LoadImpl(this, apiClient) {
            final /* synthetic */ EventsImpl zzaDt;

            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzd((zzb) this, forceReload);
            }
        });
    }

    public PendingResult<LoadEventsResult> loadByIds(GoogleApiClient apiClient, final boolean forceReload, final String... eventIds) {
        return apiClient.zza(new LoadImpl(this, apiClient) {
            final /* synthetic */ EventsImpl zzaDt;

            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, forceReload, eventIds);
            }
        });
    }
}
