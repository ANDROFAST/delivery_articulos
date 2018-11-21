package com.google.android.gms.games.internal.api;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.Notifications.ContactSettingLoadResult;
import com.google.android.gms.games.Notifications.GameMuteStatusChangeResult;
import com.google.android.gms.games.Notifications.GameMuteStatusLoadResult;
import com.google.android.gms.games.Notifications.InboxCountResult;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.internal.zzlx.zzb;

public final class NotificationsImpl implements Notifications {

    class C12071 extends BaseGamesApiMethodImpl<GameMuteStatusChangeResult> {
        final /* synthetic */ String zzaDU;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd((zzb) this, this.zzaDU, true);
        }

        public GameMuteStatusChangeResult zzan(final Status status) {
            return new GameMuteStatusChangeResult(this) {
                final /* synthetic */ C12071 zzaDV;

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzan(status);
        }
    }

    class C12082 extends BaseGamesApiMethodImpl<GameMuteStatusChangeResult> {
        final /* synthetic */ String zzaDU;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd((zzb) this, this.zzaDU, false);
        }

        public GameMuteStatusChangeResult zzan(final Status status) {
            return new GameMuteStatusChangeResult(this) {
                final /* synthetic */ C12082 zzaDW;

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzan(status);
        }
    }

    class C12093 extends BaseGamesApiMethodImpl<GameMuteStatusLoadResult> {
        final /* synthetic */ String zzaDU;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzo(this, this.zzaDU);
        }

        public GameMuteStatusLoadResult zzao(final Status status) {
            return new GameMuteStatusLoadResult(this) {
                final /* synthetic */ C12093 zzaDX;

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzao(status);
        }
    }

    private static abstract class ContactSettingLoadImpl extends BaseGamesApiMethodImpl<ContactSettingLoadResult> {
        public ContactSettingLoadResult zzap(final Status status) {
            return new ContactSettingLoadResult(this) {
                final /* synthetic */ ContactSettingLoadImpl zzaEa;

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzap(status);
        }
    }

    private static abstract class ContactSettingUpdateImpl extends BaseGamesApiMethodImpl<Status> {
        public Status zzb(Status status) {
            return status;
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    private static abstract class InboxCountImpl extends BaseGamesApiMethodImpl<InboxCountResult> {
        public InboxCountResult zzaq(final Status status) {
            return new InboxCountResult(this) {
                final /* synthetic */ InboxCountImpl zzaEb;

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaq(status);
        }
    }

    class C13284 extends ContactSettingLoadImpl {
        final /* synthetic */ boolean zzaDg;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzi((zzb) this, this.zzaDg);
        }
    }

    class C13295 extends ContactSettingUpdateImpl {
        final /* synthetic */ boolean zzaDY;
        final /* synthetic */ Bundle zzaDZ;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, this.zzaDY, this.zzaDZ);
        }
    }

    class C13306 extends InboxCountImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzi(this);
        }
    }

    public void clear(GoogleApiClient apiClient, int notificationTypes) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzgl(notificationTypes);
        }
    }

    public void clearAll(GoogleApiClient apiClient) {
        clear(apiClient, 31);
    }
}
