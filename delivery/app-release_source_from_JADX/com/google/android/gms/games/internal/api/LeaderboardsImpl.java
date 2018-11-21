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
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.internal.GamesLog;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult;
import com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import com.google.android.gms.internal.zzlx.zzb;

public final class LeaderboardsImpl implements Leaderboards {

    private static abstract class LoadMetadataImpl extends BaseGamesApiMethodImpl<LeaderboardMetadataResult> {
        private LoadMetadataImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LeaderboardMetadataResult zzaj(final Status status) {
            return new LeaderboardMetadataResult(this) {
                final /* synthetic */ LoadMetadataImpl zzaDQ;

                public LeaderboardBuffer getLeaderboards() {
                    return new LeaderboardBuffer(DataHolder.zzbJ(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaj(status);
        }
    }

    private static abstract class LoadPlayerScoreImpl extends BaseGamesApiMethodImpl<LoadPlayerScoreResult> {
        private LoadPlayerScoreImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadPlayerScoreResult zzak(final Status status) {
            return new LoadPlayerScoreResult(this) {
                final /* synthetic */ LoadPlayerScoreImpl zzaDR;

                public LeaderboardScore getScore() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzak(status);
        }
    }

    private static abstract class LoadScoresImpl extends BaseGamesApiMethodImpl<LoadScoresResult> {
        private LoadScoresImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadScoresResult zzal(final Status status) {
            return new LoadScoresResult(this) {
                final /* synthetic */ LoadScoresImpl zzaDS;

                public Leaderboard getLeaderboard() {
                    return null;
                }

                public LeaderboardScoreBuffer getScores() {
                    return new LeaderboardScoreBuffer(DataHolder.zzbJ(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzal(status);
        }
    }

    protected static abstract class SubmitScoreImpl extends BaseGamesApiMethodImpl<SubmitScoreResult> {
        protected SubmitScoreImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public SubmitScoreResult zzam(final Status status) {
            return new SubmitScoreResult(this) {
                final /* synthetic */ SubmitScoreImpl zzaDT;

                public ScoreSubmissionData getScoreData() {
                    return new ScoreSubmissionData(DataHolder.zzbJ(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzam(status);
        }
    }

    class AnonymousClass10 extends LoadScoresImpl {
        final /* synthetic */ String zzaDI;
        final /* synthetic */ int zzaDJ;
        final /* synthetic */ int zzaDK;
        final /* synthetic */ int zzaDL;
        final /* synthetic */ boolean zzaDg;
        final /* synthetic */ String zzaDi;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza(this, this.zzaDi, this.zzaDI, this.zzaDJ, this.zzaDK, this.zzaDL, this.zzaDg);
        }
    }

    class AnonymousClass11 extends LoadScoresImpl {
        final /* synthetic */ String zzaDI;
        final /* synthetic */ int zzaDJ;
        final /* synthetic */ int zzaDK;
        final /* synthetic */ int zzaDL;
        final /* synthetic */ boolean zzaDg;
        final /* synthetic */ String zzaDi;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb(this, this.zzaDi, this.zzaDI, this.zzaDJ, this.zzaDK, this.zzaDL, this.zzaDg);
        }
    }

    class C13268 extends LoadMetadataImpl {
        final /* synthetic */ boolean zzaDg;
        final /* synthetic */ String zzaDi;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zzb) this, this.zzaDi, this.zzaDg);
        }
    }

    class C13279 extends LoadMetadataImpl {
        final /* synthetic */ String zzaDI;
        final /* synthetic */ boolean zzaDg;
        final /* synthetic */ String zzaDi;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzaDi, this.zzaDI, this.zzaDg);
        }
    }

    public Intent getAllLeaderboardsIntent(GoogleApiClient apiClient) {
        return Games.zzf(apiClient).zzvV();
    }

    public Intent getLeaderboardIntent(GoogleApiClient apiClient, String leaderboardId) {
        return getLeaderboardIntent(apiClient, leaderboardId, -1);
    }

    public Intent getLeaderboardIntent(GoogleApiClient apiClient, String leaderboardId, int timeSpan) {
        return getLeaderboardIntent(apiClient, leaderboardId, timeSpan, -1);
    }

    public Intent getLeaderboardIntent(GoogleApiClient apiClient, String leaderboardId, int timeSpan, int collection) {
        return Games.zzf(apiClient).zzl(leaderboardId, timeSpan, collection);
    }

    public PendingResult<LoadPlayerScoreResult> loadCurrentPlayerLeaderboardScore(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection) {
        final String str = leaderboardId;
        final int i = span;
        final int i2 = leaderboardCollection;
        return apiClient.zza(new LoadPlayerScoreImpl(this, apiClient) {
            final /* synthetic */ LeaderboardsImpl zzaDH;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, null, str, i, i2);
            }
        });
    }

    public PendingResult<LeaderboardMetadataResult> loadLeaderboardMetadata(GoogleApiClient apiClient, final String leaderboardId, final boolean forceReload) {
        return apiClient.zza(new LoadMetadataImpl(this, apiClient) {
            final /* synthetic */ LeaderboardsImpl zzaDH;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb((zzb) this, leaderboardId, forceReload);
            }
        });
    }

    public PendingResult<LeaderboardMetadataResult> loadLeaderboardMetadata(GoogleApiClient apiClient, final boolean forceReload) {
        return apiClient.zza(new LoadMetadataImpl(this, apiClient) {
            final /* synthetic */ LeaderboardsImpl zzaDH;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb((zzb) this, forceReload);
            }
        });
    }

    public PendingResult<LoadScoresResult> loadMoreScores(GoogleApiClient apiClient, LeaderboardScoreBuffer buffer, int maxResults, int pageDirection) {
        final LeaderboardScoreBuffer leaderboardScoreBuffer = buffer;
        final int i = maxResults;
        final int i2 = pageDirection;
        return apiClient.zza(new LoadScoresImpl(this, apiClient) {
            final /* synthetic */ LeaderboardsImpl zzaDH;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, leaderboardScoreBuffer, i, i2);
            }
        });
    }

    public PendingResult<LoadScoresResult> loadPlayerCenteredScores(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection, int maxResults) {
        return loadPlayerCenteredScores(apiClient, leaderboardId, span, leaderboardCollection, maxResults, false);
    }

    public PendingResult<LoadScoresResult> loadPlayerCenteredScores(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection, int maxResults, boolean forceReload) {
        final String str = leaderboardId;
        final int i = span;
        final int i2 = leaderboardCollection;
        final int i3 = maxResults;
        final boolean z = forceReload;
        return apiClient.zza(new LoadScoresImpl(this, apiClient) {
            final /* synthetic */ LeaderboardsImpl zzaDH;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb((zzb) this, str, i, i2, i3, z);
            }
        });
    }

    public PendingResult<LoadScoresResult> loadTopScores(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection, int maxResults) {
        return loadTopScores(apiClient, leaderboardId, span, leaderboardCollection, maxResults, false);
    }

    public PendingResult<LoadScoresResult> loadTopScores(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection, int maxResults, boolean forceReload) {
        final String str = leaderboardId;
        final int i = span;
        final int i2 = leaderboardCollection;
        final int i3 = maxResults;
        final boolean z = forceReload;
        return apiClient.zza(new LoadScoresImpl(this, apiClient) {
            final /* synthetic */ LeaderboardsImpl zzaDH;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, str, i, i2, i3, z);
            }
        });
    }

    public void submitScore(GoogleApiClient apiClient, String leaderboardId, long score) {
        submitScore(apiClient, leaderboardId, score, null);
    }

    public void submitScore(GoogleApiClient apiClient, String leaderboardId, long score, String scoreTag) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            try {
                zzb.zza(null, leaderboardId, score, scoreTag);
            } catch (RemoteException e) {
                GamesLog.zzA("LeaderboardsImpl", "service died");
            }
        }
    }

    public PendingResult<SubmitScoreResult> submitScoreImmediate(GoogleApiClient apiClient, String leaderboardId, long score) {
        return submitScoreImmediate(apiClient, leaderboardId, score, null);
    }

    public PendingResult<SubmitScoreResult> submitScoreImmediate(GoogleApiClient apiClient, String leaderboardId, long score, String scoreTag) {
        final String str = leaderboardId;
        final long j = score;
        final String str2 = scoreTag;
        return apiClient.zzb(new SubmitScoreImpl(this, apiClient) {
            final /* synthetic */ LeaderboardsImpl zzaDH;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, str, j, str2);
            }
        });
    }
}
