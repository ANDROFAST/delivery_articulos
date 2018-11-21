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
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;
import com.google.android.gms.internal.zzlx.zzb;

public final class InvitationsImpl implements Invitations {

    private static abstract class LoadInvitationsImpl extends BaseGamesApiMethodImpl<LoadInvitationsResult> {
        private LoadInvitationsImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadInvitationsResult zzai(final Status status) {
            return new LoadInvitationsResult(this) {
                final /* synthetic */ LoadInvitationsImpl zzaDG;

                public InvitationBuffer getInvitations() {
                    return new InvitationBuffer(DataHolder.zzbJ(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzai(status);
        }
    }

    class C13172 extends LoadInvitationsImpl {
        final /* synthetic */ int zzaDD;
        final /* synthetic */ String zzaDi;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zze(this, this.zzaDi, this.zzaDD);
        }
    }

    class C13183 extends LoadInvitationsImpl {
        final /* synthetic */ String zzaDF;

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzm(this, this.zzaDF);
        }
    }

    public Intent getInvitationInboxIntent(GoogleApiClient apiClient) {
        return Games.zzf(apiClient).zzvY();
    }

    public PendingResult<LoadInvitationsResult> loadInvitations(GoogleApiClient apiClient) {
        return loadInvitations(apiClient, 0);
    }

    public PendingResult<LoadInvitationsResult> loadInvitations(GoogleApiClient apiClient, final int sortOrder) {
        return apiClient.zza(new LoadInvitationsImpl(this, apiClient) {
            final /* synthetic */ InvitationsImpl zzaDE;

            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, sortOrder);
            }
        });
    }

    public void registerInvitationListener(GoogleApiClient apiClient, OnInvitationReceivedListener listener) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zza(apiClient.zzq(listener));
        }
    }

    public void unregisterInvitationListener(GoogleApiClient apiClient) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzvZ();
        }
    }
}
