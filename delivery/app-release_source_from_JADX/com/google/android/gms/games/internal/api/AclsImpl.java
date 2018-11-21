package com.google.android.gms.games.internal.api;

import android.os.RemoteException;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.internal.game.Acls;
import com.google.android.gms.games.internal.game.Acls.LoadAclResult;

public final class AclsImpl implements Acls {

    private static abstract class LoadNotifyAclImpl extends BaseGamesApiMethodImpl<LoadAclResult> {
        public LoadAclResult zzac(Status status) {
            return AclsImpl.zzaa(status);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzac(status);
        }
    }

    private static abstract class UpdateNotifyAclImpl extends BaseGamesApiMethodImpl<Status> {
        public Status zzb(Status status) {
            return status;
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    class C13072 extends LoadNotifyAclImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzh(this);
        }
    }

    class C13083 extends UpdateNotifyAclImpl {
        final /* synthetic */ String zzaDn;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzn(this, this.zzaDn);
        }
    }

    private static LoadAclResult zzaa(final Status status) {
        return new LoadAclResult() {
            public Status getStatus() {
                return status;
            }

            public void release() {
            }
        };
    }
}
