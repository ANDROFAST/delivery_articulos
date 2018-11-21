package com.google.android.gms.games.internal.api;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.GamesMetadata;
import com.google.android.gms.games.GamesMetadata.LoadGameInstancesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameSearchSuggestionsResult;
import com.google.android.gms.games.GamesMetadata.LoadGamesResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class GamesMetadataImpl implements GamesMetadata {

    private static abstract class LoadGameInstancesImpl extends BaseGamesApiMethodImpl<LoadGameInstancesResult> {
        public LoadGameInstancesResult zzaf(final Status status) {
            return new LoadGameInstancesResult(this) {
                final /* synthetic */ LoadGameInstancesImpl zzaDA;

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaf(status);
        }
    }

    private static abstract class LoadGameSearchSuggestionsImpl extends BaseGamesApiMethodImpl<LoadGameSearchSuggestionsResult> {
        public LoadGameSearchSuggestionsResult zzag(final Status status) {
            return new LoadGameSearchSuggestionsResult(this) {
                final /* synthetic */ LoadGameSearchSuggestionsImpl zzaDB;

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzag(status);
        }
    }

    private static abstract class LoadGamesImpl extends BaseGamesApiMethodImpl<LoadGamesResult> {
        private LoadGamesImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadGamesResult zzah(final Status status) {
            return new LoadGamesResult(this) {
                final /* synthetic */ LoadGamesImpl zzaDC;

                public GameBuffer getGames() {
                    return new GameBuffer(DataHolder.zzbJ(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzah(status);
        }
    }

    class C13142 extends LoadGameInstancesImpl {
        final /* synthetic */ String zzaDi;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzj(this, this.zzaDi);
        }
    }

    class C13153 extends LoadGameSearchSuggestionsImpl {
        final /* synthetic */ String zzaDz;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzk(this, this.zzaDz);
        }
    }

    public Game getCurrentGame(GoogleApiClient apiClient) {
        return Games.zzf(apiClient).zzvU();
    }

    public PendingResult<LoadGamesResult> loadGame(GoogleApiClient apiClient) {
        return apiClient.zza(new LoadGamesImpl(this, apiClient) {
            final /* synthetic */ GamesMetadataImpl zzaDy;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zze(this);
            }
        });
    }
}
