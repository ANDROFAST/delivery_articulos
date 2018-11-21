package com.google.android.gms.games.internal.api;

import android.os.RemoteException;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.appcontent.AppContents;
import com.google.android.gms.games.appcontent.AppContents.LoadAppContentResult;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.internal.zzlx.zzb;

public final class AppContentsImpl implements AppContents {

    private static abstract class LoadsImpl extends BaseGamesApiMethodImpl<LoadAppContentResult> {
        public LoadAppContentResult zzad(final Status status) {
            return new LoadAppContentResult(this) {
                final /* synthetic */ LoadsImpl zzaDr;

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzad(status);
        }
    }

    class C13091 extends LoadsImpl {
        final /* synthetic */ boolean zzaDg;
        final /* synthetic */ int zzaDo;
        final /* synthetic */ String zzaDp;
        final /* synthetic */ String[] zzaDq;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzaDo, this.zzaDp, this.zzaDq, this.zzaDg);
        }
    }
}
