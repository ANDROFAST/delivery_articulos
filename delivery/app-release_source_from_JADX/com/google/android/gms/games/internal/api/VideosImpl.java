package com.google.android.gms.games.internal.api;

import android.os.RemoteException;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.video.VideoConfiguration;
import com.google.android.gms.games.video.Videos;
import com.google.android.gms.games.video.Videos.ListVideosResult;

public final class VideosImpl implements Videos {

    class C12101 extends BaseGamesApiMethodImpl<Status> {
        final /* synthetic */ String zzaDi;
        final /* synthetic */ String zzaFm;
        final /* synthetic */ VideoConfiguration zzaFn;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((BaseGamesApiMethodImpl) this, this.zzaDi, this.zzaFm, this.zzaFn);
        }

        public Status zzb(Status status) {
            return status;
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    private static abstract class ListImpl extends BaseGamesApiMethodImpl<ListVideosResult> {
        public ListVideosResult zzaN(final Status status) {
            return new ListVideosResult(this) {
                final /* synthetic */ ListImpl zzaFo;

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaN(status);
        }
    }

    class C13702 extends ListImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzg(this);
        }
    }
}
