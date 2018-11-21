package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult;
import com.google.android.gms.internal.zzlx.zzb;
import java.util.List;

public final class TurnBasedMultiplayerImpl implements TurnBasedMultiplayer {

    private static abstract class CancelMatchImpl extends BaseGamesApiMethodImpl<CancelMatchResult> {
        private final String zzxX;

        public CancelMatchImpl(String id, GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.zzxX = id;
        }

        public CancelMatchResult zzaH(final Status status) {
            return new CancelMatchResult(this) {
                final /* synthetic */ CancelMatchImpl zzaFg;

                public String getMatchId() {
                    return this.zzaFg.zzxX;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaH(status);
        }
    }

    private static abstract class InitiateMatchImpl extends BaseGamesApiMethodImpl<InitiateMatchResult> {
        private InitiateMatchImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public InitiateMatchResult zzaI(final Status status) {
            return new InitiateMatchResult(this) {
                final /* synthetic */ InitiateMatchImpl zzaFh;

                public TurnBasedMatch getMatch() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaI(status);
        }
    }

    private static abstract class LeaveMatchImpl extends BaseGamesApiMethodImpl<LeaveMatchResult> {
        private LeaveMatchImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LeaveMatchResult zzaJ(final Status status) {
            return new LeaveMatchResult(this) {
                final /* synthetic */ LeaveMatchImpl zzaFi;

                public TurnBasedMatch getMatch() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaJ(status);
        }
    }

    private static abstract class LoadMatchImpl extends BaseGamesApiMethodImpl<LoadMatchResult> {
        private LoadMatchImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadMatchResult zzaK(final Status status) {
            return new LoadMatchResult(this) {
                final /* synthetic */ LoadMatchImpl zzaFj;

                public TurnBasedMatch getMatch() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaK(status);
        }
    }

    private static abstract class LoadMatchesImpl extends BaseGamesApiMethodImpl<LoadMatchesResult> {
        private LoadMatchesImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadMatchesResult zzaL(final Status status) {
            return new LoadMatchesResult(this) {
                final /* synthetic */ LoadMatchesImpl zzaFk;

                public LoadMatchesResponse getMatches() {
                    return new LoadMatchesResponse(new Bundle());
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaL(status);
        }
    }

    private static abstract class UpdateMatchImpl extends BaseGamesApiMethodImpl<UpdateMatchResult> {
        private UpdateMatchImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public UpdateMatchResult zzaM(final Status status) {
            return new UpdateMatchResult(this) {
                final /* synthetic */ UpdateMatchImpl zzaFl;

                public TurnBasedMatch getMatch() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaM(status);
        }
    }

    class AnonymousClass11 extends InitiateMatchImpl {
        final /* synthetic */ String zzaDi;
        final /* synthetic */ String zzaFa;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zzb) this, this.zzaDi, this.zzaFa);
        }
    }

    class AnonymousClass12 extends InitiateMatchImpl {
        final /* synthetic */ String zzaDi;
        final /* synthetic */ String zzaFa;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd((zzb) this, this.zzaDi, this.zzaFa);
        }
    }

    class AnonymousClass13 extends LoadMatchesImpl {
        final /* synthetic */ String zzaDi;
        final /* synthetic */ int zzaFb;
        final /* synthetic */ int[] zzaFc;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzaDi, this.zzaFb, this.zzaFc);
        }
    }

    public PendingResult<InitiateMatchResult> acceptInvitation(GoogleApiClient apiClient, final String invitationId) {
        return apiClient.zzb(new InitiateMatchImpl(this, apiClient) {
            final /* synthetic */ TurnBasedMultiplayerImpl zzaEZ;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzd((zzb) this, invitationId);
            }
        });
    }

    public PendingResult<CancelMatchResult> cancelMatch(GoogleApiClient apiClient, final String matchId) {
        return apiClient.zzb(new CancelMatchImpl(this, apiClient, matchId) {
            final /* synthetic */ TurnBasedMultiplayerImpl zzaEZ;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzf((zzb) this, matchId);
            }
        });
    }

    public PendingResult<InitiateMatchResult> createMatch(GoogleApiClient apiClient, final TurnBasedMatchConfig config) {
        return apiClient.zzb(new InitiateMatchImpl(this, apiClient) {
            final /* synthetic */ TurnBasedMultiplayerImpl zzaEZ;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, config);
            }
        });
    }

    public void declineInvitation(GoogleApiClient apiClient, String invitationId) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzr(invitationId, 1);
        }
    }

    public void dismissInvitation(GoogleApiClient apiClient, String invitationId) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzq(invitationId, 1);
        }
    }

    public void dismissMatch(GoogleApiClient apiClient, String matchId) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzdt(matchId);
        }
    }

    public PendingResult<UpdateMatchResult> finishMatch(GoogleApiClient apiClient, String matchId) {
        return finishMatch(apiClient, matchId, null, (ParticipantResult[]) null);
    }

    public PendingResult<UpdateMatchResult> finishMatch(GoogleApiClient apiClient, String matchId, byte[] matchData, List<ParticipantResult> results) {
        return finishMatch(apiClient, matchId, matchData, results == null ? null : (ParticipantResult[]) results.toArray(new ParticipantResult[results.size()]));
    }

    public PendingResult<UpdateMatchResult> finishMatch(GoogleApiClient apiClient, String matchId, byte[] matchData, ParticipantResult... results) {
        final String str = matchId;
        final byte[] bArr = matchData;
        final ParticipantResult[] participantResultArr = results;
        return apiClient.zzb(new UpdateMatchImpl(this, apiClient) {
            final /* synthetic */ TurnBasedMultiplayerImpl zzaEZ;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, str, bArr, participantResultArr);
            }
        });
    }

    public Intent getInboxIntent(GoogleApiClient apiClient) {
        return Games.zzf(apiClient).zzvX();
    }

    public int getMaxMatchDataSize(GoogleApiClient apiClient) {
        return Games.zzf(apiClient).zzwh();
    }

    public Intent getSelectOpponentsIntent(GoogleApiClient apiClient, int minPlayers, int maxPlayers) {
        return Games.zzf(apiClient).zzb(minPlayers, maxPlayers, true);
    }

    public Intent getSelectOpponentsIntent(GoogleApiClient apiClient, int minPlayers, int maxPlayers, boolean allowAutomatch) {
        return Games.zzf(apiClient).zzb(minPlayers, maxPlayers, allowAutomatch);
    }

    public PendingResult<LeaveMatchResult> leaveMatch(GoogleApiClient apiClient, final String matchId) {
        return apiClient.zzb(new LeaveMatchImpl(this, apiClient) {
            final /* synthetic */ TurnBasedMultiplayerImpl zzaEZ;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zze((zzb) this, matchId);
            }
        });
    }

    public PendingResult<LeaveMatchResult> leaveMatchDuringTurn(GoogleApiClient apiClient, final String matchId, final String pendingParticipantId) {
        return apiClient.zzb(new LeaveMatchImpl(this, apiClient) {
            final /* synthetic */ TurnBasedMultiplayerImpl zzaEZ;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, matchId, pendingParticipantId);
            }
        });
    }

    public PendingResult<LoadMatchResult> loadMatch(GoogleApiClient apiClient, final String matchId) {
        return apiClient.zza(new LoadMatchImpl(this, apiClient) {
            final /* synthetic */ TurnBasedMultiplayerImpl zzaEZ;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzg((zzb) this, matchId);
            }
        });
    }

    public PendingResult<LoadMatchesResult> loadMatchesByStatus(GoogleApiClient apiClient, final int invitationSortOrder, final int[] matchTurnStatuses) {
        return apiClient.zza(new LoadMatchesImpl(this, apiClient) {
            final /* synthetic */ TurnBasedMultiplayerImpl zzaEZ;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, invitationSortOrder, matchTurnStatuses);
            }
        });
    }

    public PendingResult<LoadMatchesResult> loadMatchesByStatus(GoogleApiClient apiClient, int[] matchTurnStatuses) {
        return loadMatchesByStatus(apiClient, 0, matchTurnStatuses);
    }

    public void registerMatchUpdateListener(GoogleApiClient apiClient, OnTurnBasedMatchUpdateReceivedListener listener) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzb(apiClient.zzq(listener));
        }
    }

    public PendingResult<InitiateMatchResult> rematch(GoogleApiClient apiClient, final String matchId) {
        return apiClient.zzb(new InitiateMatchImpl(this, apiClient) {
            final /* synthetic */ TurnBasedMultiplayerImpl zzaEZ;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzc((zzb) this, matchId);
            }
        });
    }

    public PendingResult<UpdateMatchResult> takeTurn(GoogleApiClient apiClient, String matchId, byte[] matchData, String pendingParticipantId) {
        return takeTurn(apiClient, matchId, matchData, pendingParticipantId, (ParticipantResult[]) null);
    }

    public PendingResult<UpdateMatchResult> takeTurn(GoogleApiClient apiClient, String matchId, byte[] matchData, String pendingParticipantId, List<ParticipantResult> results) {
        return takeTurn(apiClient, matchId, matchData, pendingParticipantId, results == null ? null : (ParticipantResult[]) results.toArray(new ParticipantResult[results.size()]));
    }

    public PendingResult<UpdateMatchResult> takeTurn(GoogleApiClient apiClient, String matchId, byte[] matchData, String pendingParticipantId, ParticipantResult... results) {
        final String str = matchId;
        final byte[] bArr = matchData;
        final String str2 = pendingParticipantId;
        final ParticipantResult[] participantResultArr = results;
        return apiClient.zzb(new UpdateMatchImpl(this, apiClient) {
            final /* synthetic */ TurnBasedMultiplayerImpl zzaEZ;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, str, bArr, str2, participantResultArr);
            }
        });
    }

    public void unregisterMatchUpdateListener(GoogleApiClient apiClient) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzwa();
        }
    }
}
