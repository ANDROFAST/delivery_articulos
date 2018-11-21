package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.Players;
import com.google.android.gms.games.Players.LoadPlayersResult;
import com.google.android.gms.games.Players.LoadProfileSettingsResult;
import com.google.android.gms.games.Players.LoadXpForGameCategoriesResult;
import com.google.android.gms.games.Players.LoadXpStreamResult;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.internal.zzlx.zzb;

public final class PlayersImpl implements Players {

    private static abstract class LoadPlayersImpl extends BaseGamesApiMethodImpl<LoadPlayersResult> {
        private LoadPlayersImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadPlayersResult zzar(final Status status) {
            return new LoadPlayersResult(this) {
                final /* synthetic */ LoadPlayersImpl zzaEj;

                public PlayerBuffer getPlayers() {
                    return new PlayerBuffer(DataHolder.zzbJ(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzar(status);
        }
    }

    private static abstract class LoadProfileSettingsResultImpl extends BaseGamesApiMethodImpl<LoadProfileSettingsResult> {
        protected LoadProfileSettingsResult zzas(final Status status) {
            return new LoadProfileSettingsResult(this) {
                final /* synthetic */ LoadProfileSettingsResultImpl zzaEk;

                public Status getStatus() {
                    return status;
                }
            };
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzas(status);
        }
    }

    private static abstract class LoadXpForGameCategoriesResultImpl extends BaseGamesApiMethodImpl<LoadXpForGameCategoriesResult> {
        public LoadXpForGameCategoriesResult zzat(final Status status) {
            return new LoadXpForGameCategoriesResult(this) {
                final /* synthetic */ LoadXpForGameCategoriesResultImpl zzaEl;

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzat(status);
        }
    }

    private static abstract class LoadXpStreamResultImpl extends BaseGamesApiMethodImpl<LoadXpStreamResult> {
        public LoadXpStreamResult zzau(final Status status) {
            return new LoadXpStreamResult(this) {
                final /* synthetic */ LoadXpStreamResultImpl zzaEm;

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzau(status);
        }
    }

    private static abstract class UpdateProfileSettingsResultImpl extends BaseGamesApiMethodImpl<Status> {
        protected Status zzb(Status status) {
            return status;
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    class AnonymousClass10 extends LoadPlayersImpl {
        final /* synthetic */ String zzaDi;
        final /* synthetic */ int zzaEd;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, "nearby", this.zzaDi, this.zzaEd, true, false);
        }
    }

    class AnonymousClass11 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzaDg;
        final /* synthetic */ String zzaDi;
        final /* synthetic */ int zzaEd;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, "played_with", this.zzaDi, this.zzaEd, false, this.zzaDg);
        }
    }

    class AnonymousClass12 extends LoadPlayersImpl {
        final /* synthetic */ String zzaDi;
        final /* synthetic */ int zzaEd;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, "played_with", this.zzaDi, this.zzaEd, true, false);
        }
    }

    class AnonymousClass13 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzaDg;
        final /* synthetic */ int zzaEd;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb) this, this.zzaEd, false, this.zzaDg);
        }
    }

    class AnonymousClass14 extends LoadPlayersImpl {
        final /* synthetic */ int zzaEd;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb) this, this.zzaEd, true, false);
        }
    }

    class AnonymousClass15 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzaDg;
        final /* synthetic */ int zzaEd;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zzb) this, this.zzaEd, false, this.zzaDg);
        }
    }

    class AnonymousClass16 extends LoadPlayersImpl {
        final /* synthetic */ int zzaEd;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zzb) this, this.zzaEd, true, false);
        }
    }

    class AnonymousClass17 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzaDg;
        final /* synthetic */ int zzaEd;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd(this, this.zzaEd, false, this.zzaDg);
        }
    }

    class AnonymousClass18 extends LoadPlayersImpl {
        final /* synthetic */ int zzaEd;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd(this, this.zzaEd, true, false);
        }
    }

    class AnonymousClass19 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzaDg;
        final /* synthetic */ String zzaDz;
        final /* synthetic */ int zzaEd;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb(this, this.zzaDz, this.zzaEd, false, this.zzaDg);
        }
    }

    class AnonymousClass20 extends LoadPlayersImpl {
        final /* synthetic */ String zzaDz;
        final /* synthetic */ int zzaEd;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb(this, this.zzaDz, this.zzaEd, true, false);
        }
    }

    class AnonymousClass21 extends LoadPlayersImpl {
        final /* synthetic */ String zzaDU;
        final /* synthetic */ boolean zzaDg;
        final /* synthetic */ int zzaEd;
        final /* synthetic */ String zzaEe;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb) this, this.zzaEe, this.zzaDU, this.zzaEd, false, this.zzaDg);
        }
    }

    class AnonymousClass22 extends LoadPlayersImpl {
        final /* synthetic */ String zzaDU;
        final /* synthetic */ int zzaEd;
        final /* synthetic */ String zzaEe;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb) this, this.zzaEe, this.zzaDU, this.zzaEd, true, false);
        }
    }

    class AnonymousClass23 extends LoadXpForGameCategoriesResultImpl {
        final /* synthetic */ String zzaEf;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzl(this, this.zzaEf);
        }
    }

    class AnonymousClass24 extends LoadXpStreamResultImpl {
        final /* synthetic */ String zzaEf;
        final /* synthetic */ int zzaEg;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zzb) this, this.zzaEf, this.zzaEg);
        }
    }

    class AnonymousClass25 extends LoadXpStreamResultImpl {
        final /* synthetic */ String zzaEf;
        final /* synthetic */ int zzaEg;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd((zzb) this, this.zzaEf, this.zzaEg);
        }
    }

    class AnonymousClass26 extends LoadProfileSettingsResultImpl {
        final /* synthetic */ boolean zzaDg;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzg((zzb) this, this.zzaDg);
        }
    }

    class AnonymousClass27 extends UpdateProfileSettingsResultImpl {
        final /* synthetic */ boolean zzaEh;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzh((zzb) this, this.zzaEh);
        }
    }

    class C13333 extends LoadPlayersImpl {
        final /* synthetic */ String[] zzaEi;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzaEi);
        }
    }

    class C13399 extends LoadPlayersImpl {
        final /* synthetic */ String zzaDi;
        final /* synthetic */ int zzaEd;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, "nearby", this.zzaDi, this.zzaEd, false, false);
        }
    }

    public Intent getCompareProfileIntent(GoogleApiClient apiClient, Player player) {
        return Games.zzf(apiClient).zza(new PlayerEntity(player));
    }

    public Player getCurrentPlayer(GoogleApiClient apiClient) {
        return Games.zzf(apiClient).zzvT();
    }

    public String getCurrentPlayerId(GoogleApiClient apiClient) {
        return Games.zzf(apiClient).zzvS();
    }

    public Intent getPlayerSearchIntent(GoogleApiClient apiClient) {
        return Games.zzf(apiClient).zzwd();
    }

    public PendingResult<LoadPlayersResult> loadConnectedPlayers(GoogleApiClient apiClient, final boolean forceReload) {
        return apiClient.zza(new LoadPlayersImpl(this, apiClient) {
            final /* synthetic */ PlayersImpl zzaEc;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, forceReload);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadInvitablePlayers(GoogleApiClient apiClient, final int pageSize, final boolean forceReload) {
        return apiClient.zza(new LoadPlayersImpl(this, apiClient) {
            final /* synthetic */ PlayersImpl zzaEc;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, pageSize, false, forceReload);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadMoreInvitablePlayers(GoogleApiClient apiClient, final int pageSize) {
        return apiClient.zza(new LoadPlayersImpl(this, apiClient) {
            final /* synthetic */ PlayersImpl zzaEc;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, pageSize, true, false);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadMoreRecentlyPlayedWithPlayers(GoogleApiClient apiClient, final int pageSize) {
        return apiClient.zza(new LoadPlayersImpl(this, apiClient) {
            final /* synthetic */ PlayersImpl zzaEc;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, "played_with", pageSize, true, false);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadPlayer(GoogleApiClient apiClient, final String playerId) {
        return apiClient.zza(new LoadPlayersImpl(this, apiClient) {
            final /* synthetic */ PlayersImpl zzaEc;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, playerId, false);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadPlayer(GoogleApiClient apiClient, final String playerId, final boolean forceReload) {
        return apiClient.zza(new LoadPlayersImpl(this, apiClient) {
            final /* synthetic */ PlayersImpl zzaEc;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, playerId, forceReload);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadRecentlyPlayedWithPlayers(GoogleApiClient apiClient, final int pageSize, final boolean forceReload) {
        return apiClient.zza(new LoadPlayersImpl(this, apiClient) {
            final /* synthetic */ PlayersImpl zzaEc;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, "played_with", pageSize, false, forceReload);
            }
        });
    }
}
