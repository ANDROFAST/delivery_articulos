package com.google.android.gms.games.internal.api;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.stats.PlayerStats;
import com.google.android.gms.games.stats.Stats;
import com.google.android.gms.games.stats.Stats.LoadPlayerStatsResult;
import com.google.android.gms.internal.zzlx.zzb;

public final class StatsImpl implements Stats {

    private static abstract class LoadsImpl extends BaseGamesApiMethodImpl<LoadPlayerStatsResult> {
        private LoadsImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadPlayerStatsResult zzaG(final Status status) {
            return new LoadPlayerStatsResult(this) {
                final /* synthetic */ LoadsImpl zzaEX;

                public PlayerStats getPlayerStats() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaG(status);
        }
    }

    public PendingResult<LoadPlayerStatsResult> loadPlayerStats(GoogleApiClient apiClient, final boolean forceReload) {
        return apiClient.zza(new LoadsImpl(this, apiClient) {
            final /* synthetic */ StatsImpl zzaEW;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zze((zzb) this, forceReload);
            }
        });
    }
}
