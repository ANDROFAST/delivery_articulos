package com.google.android.gms.games;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.appcontent.AppContents;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.internal.api.AchievementsImpl;
import com.google.android.gms.games.internal.api.AclsImpl;
import com.google.android.gms.games.internal.api.AppContentsImpl;
import com.google.android.gms.games.internal.api.EventsImpl;
import com.google.android.gms.games.internal.api.GamesMetadataImpl;
import com.google.android.gms.games.internal.api.InvitationsImpl;
import com.google.android.gms.games.internal.api.LeaderboardsImpl;
import com.google.android.gms.games.internal.api.MultiplayerImpl;
import com.google.android.gms.games.internal.api.NotificationsImpl;
import com.google.android.gms.games.internal.api.PlayersImpl;
import com.google.android.gms.games.internal.api.QuestsImpl;
import com.google.android.gms.games.internal.api.RealTimeMultiplayerImpl;
import com.google.android.gms.games.internal.api.RequestsImpl;
import com.google.android.gms.games.internal.api.SnapshotsImpl;
import com.google.android.gms.games.internal.api.StatsImpl;
import com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl;
import com.google.android.gms.games.internal.api.VideosImpl;
import com.google.android.gms.games.internal.game.Acls;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.games.snapshot.Snapshots;
import com.google.android.gms.games.stats.Stats;
import com.google.android.gms.games.video.Videos;
import com.google.android.gms.internal.zzlx;
import com.google.android.gms.internal.zzlx.zzb;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Games {
    public static final Api<GamesOptions> API = new Api("Games.API", zzTp, zzTo);
    public static final Achievements Achievements = new AchievementsImpl();
    public static final String EXTRA_PLAYER_IDS = "players";
    public static final String EXTRA_STATUS = "status";
    public static final Events Events = new EventsImpl();
    public static final GamesMetadata GamesMetadata = new GamesMetadataImpl();
    public static final Invitations Invitations = new InvitationsImpl();
    public static final Leaderboards Leaderboards = new LeaderboardsImpl();
    public static final Notifications Notifications = new NotificationsImpl();
    public static final Players Players = new PlayersImpl();
    public static final Quests Quests = new QuestsImpl();
    public static final RealTimeMultiplayer RealTimeMultiplayer = new RealTimeMultiplayerImpl();
    public static final Requests Requests = new RequestsImpl();
    public static final Scope SCOPE_GAMES = new Scope(Scopes.GAMES);
    public static final Snapshots Snapshots = new SnapshotsImpl();
    public static final Stats Stats = new StatsImpl();
    public static final TurnBasedMultiplayer TurnBasedMultiplayer = new TurnBasedMultiplayerImpl();
    static final zzc<GamesClientImpl> zzTo = new zzc();
    private static final zza<GamesClientImpl, GamesOptions> zzTp = new C10931();
    public static final Acls zzaAa = new AclsImpl();
    private static final zza<GamesClientImpl, GamesOptions> zzazU = new C10942();
    public static final Scope zzazV = new Scope("https://www.googleapis.com/auth/games.firstparty");
    public static final Api<GamesOptions> zzazW = new Api("Games.API_1P", zzazU, zzTo);
    public static final AppContents zzazX = new AppContentsImpl();
    public static final Multiplayer zzazY = new MultiplayerImpl();
    public static final Videos zzazZ = new VideosImpl();

    private static abstract class GamesClientBuilder extends zza<GamesClientImpl, GamesOptions> {
        private GamesClientBuilder() {
        }

        public int getPriority() {
            return 1;
        }

        public GamesClientImpl zza(Context context, Looper looper, zzf com_google_android_gms_common_internal_zzf, GamesOptions gamesOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new GamesClientImpl(context, looper, com_google_android_gms_common_internal_zzf, gamesOptions == null ? new GamesOptions() : gamesOptions, connectionCallbacks, onConnectionFailedListener);
        }
    }

    public interface GetTokenResult extends Result {
    }

    static class C10931 extends GamesClientBuilder {
        C10931() {
            super();
        }

        public List<Scope> zza(GamesOptions gamesOptions) {
            return Collections.singletonList(Games.SCOPE_GAMES);
        }

        public /* synthetic */ List zzn(Object obj) {
            return zza((GamesOptions) obj);
        }
    }

    static class C10942 extends GamesClientBuilder {
        C10942() {
            super();
        }

        public List<Scope> zza(GamesOptions gamesOptions) {
            return Collections.singletonList(Games.zzazV);
        }

        public /* synthetic */ List zzn(Object obj) {
            return zza((GamesOptions) obj);
        }
    }

    public static abstract class BaseGamesApiMethodImpl<R extends Result> extends zzlx.zza<R, GamesClientImpl> {
        public BaseGamesApiMethodImpl(GoogleApiClient googleApiClient) {
            super(Games.zzTo, googleApiClient);
        }
    }

    public static final class GamesOptions implements Optional {
        public final boolean zzaAb;
        public final boolean zzaAc;
        public final int zzaAd;
        public final boolean zzaAe;
        public final int zzaAf;
        public final String zzaAg;
        public final ArrayList<String> zzaAh;

        public static final class Builder {
            boolean zzaAb;
            boolean zzaAc;
            int zzaAd;
            boolean zzaAe;
            int zzaAf;
            String zzaAg;
            ArrayList<String> zzaAh;

            private Builder() {
                this.zzaAb = false;
                this.zzaAc = true;
                this.zzaAd = 17;
                this.zzaAe = false;
                this.zzaAf = 4368;
                this.zzaAg = null;
                this.zzaAh = new ArrayList();
            }

            public GamesOptions build() {
                return new GamesOptions();
            }

            public Builder setSdkVariant(int variant) {
                this.zzaAf = variant;
                return this;
            }

            public Builder setShowConnectingPopup(boolean showConnectingPopup) {
                this.zzaAc = showConnectingPopup;
                this.zzaAd = 17;
                return this;
            }

            public Builder setShowConnectingPopup(boolean showConnectingPopup, int gravity) {
                this.zzaAc = showConnectingPopup;
                this.zzaAd = gravity;
                return this;
            }
        }

        private GamesOptions() {
            this.zzaAb = false;
            this.zzaAc = true;
            this.zzaAd = 17;
            this.zzaAe = false;
            this.zzaAf = 4368;
            this.zzaAg = null;
            this.zzaAh = new ArrayList();
        }

        private GamesOptions(Builder builder) {
            this.zzaAb = builder.zzaAb;
            this.zzaAc = builder.zzaAc;
            this.zzaAd = builder.zzaAd;
            this.zzaAe = builder.zzaAe;
            this.zzaAf = builder.zzaAf;
            this.zzaAg = builder.zzaAg;
            this.zzaAh = builder.zzaAh;
        }

        public static Builder builder() {
            return new Builder();
        }

        public Bundle zzuX() {
            Bundle bundle = new Bundle();
            bundle.putBoolean("com.google.android.gms.games.key.isHeadless", this.zzaAb);
            bundle.putBoolean("com.google.android.gms.games.key.showConnectingPopup", this.zzaAc);
            bundle.putInt("com.google.android.gms.games.key.connectingPopupGravity", this.zzaAd);
            bundle.putBoolean("com.google.android.gms.games.key.retryingSignIn", this.zzaAe);
            bundle.putInt("com.google.android.gms.games.key.sdkVariant", this.zzaAf);
            bundle.putString("com.google.android.gms.games.key.forceResolveAccountKey", this.zzaAg);
            bundle.putStringArrayList("com.google.android.gms.games.key.proxyApis", this.zzaAh);
            return bundle;
        }
    }

    private static abstract class GetTokenImpl extends BaseGamesApiMethodImpl<GetTokenResult> {
        public GetTokenResult zzX(final Status status) {
            return new GetTokenResult(this) {
                final /* synthetic */ GetTokenImpl zzaAi;

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzX(status);
        }
    }

    private static abstract class SignOutImpl extends BaseGamesApiMethodImpl<Status> {
        private SignOutImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public Status zzb(Status status) {
            return status;
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    static class C12963 extends GetTokenImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd((zzb) this);
        }
    }

    private Games() {
    }

    public static String getAppId(GoogleApiClient apiClient) {
        return zzf(apiClient).zzwg();
    }

    public static String getCurrentAccountName(GoogleApiClient apiClient) {
        return zzf(apiClient).zzvR();
    }

    public static int getSdkVariant(GoogleApiClient apiClient) {
        return zzf(apiClient).zzwf();
    }

    public static Intent getSettingsIntent(GoogleApiClient apiClient) {
        return zzf(apiClient).zzwe();
    }

    public static void setGravityForPopups(GoogleApiClient apiClient, int gravity) {
        GamesClientImpl zzb = zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzgk(gravity);
        }
    }

    public static void setViewForPopups(GoogleApiClient apiClient, View gamesContentView) {
        zzx.zzy(gamesContentView);
        GamesClientImpl zzb = zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzo(gamesContentView);
        }
    }

    public static PendingResult<Status> signOut(GoogleApiClient apiClient) {
        return apiClient.zzb(new SignOutImpl(apiClient) {
            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzf(this);
            }
        });
    }

    public static GamesClientImpl zzb(GoogleApiClient googleApiClient, boolean z) {
        zzx.zzb(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        zzx.zza(googleApiClient.isConnected(), (Object) "GoogleApiClient must be connected.");
        return zzc(googleApiClient, z);
    }

    public static GamesClientImpl zzc(GoogleApiClient googleApiClient, boolean z) {
        zzx.zza(googleApiClient.zza(API), (Object) "GoogleApiClient is not configured to use the Games Api. Pass Games.API into GoogleApiClient.Builder#addApi() to use this feature.");
        boolean hasConnectedApi = googleApiClient.hasConnectedApi(API);
        if (!z || hasConnectedApi) {
            return hasConnectedApi ? (GamesClientImpl) googleApiClient.zza(zzTo) : null;
        } else {
            throw new IllegalStateException("GoogleApiClient has an optional Games.API and is not connected to Games. Use GoogleApiClient.hasConnectedApi(Games.API) to guard this call.");
        }
    }

    public static GamesClientImpl zzf(GoogleApiClient googleApiClient) {
        return zzb(googleApiClient, true);
    }
}
