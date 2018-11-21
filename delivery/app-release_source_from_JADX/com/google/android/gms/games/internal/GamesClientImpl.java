package com.google.android.gms.games.internal;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.GoogleApiClient.zza;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.Games.GamesOptions;
import com.google.android.gms.games.Games.GetTokenResult;
import com.google.android.gms.games.GamesMetadata.LoadGameInstancesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameSearchSuggestionsResult;
import com.google.android.gms.games.GamesMetadata.LoadGamesResult;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Notifications.ContactSettingLoadResult;
import com.google.android.gms.games.Notifications.GameMuteStatusChangeResult;
import com.google.android.gms.games.Notifications.GameMuteStatusLoadResult;
import com.google.android.gms.games.Notifications.InboxCountResult;
import com.google.android.gms.games.OnNearbyPlayerDetectedListener;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.Players.LoadPlayersResult;
import com.google.android.gms.games.Players.LoadProfileSettingsResult;
import com.google.android.gms.games.Players.LoadXpForGameCategoriesResult;
import com.google.android.gms.games.Players.LoadXpStreamResult;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult;
import com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult;
import com.google.android.gms.games.appcontent.AppContents.LoadAppContentResult;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events.LoadEventsResult;
import com.google.android.gms.games.internal.IGamesService.Stub;
import com.google.android.gms.games.internal.constants.RequestType;
import com.google.android.gms.games.internal.events.EventIncrementCache;
import com.google.android.gms.games.internal.events.EventIncrementManager;
import com.google.android.gms.games.internal.experience.ExperienceEventBuffer;
import com.google.android.gms.games.internal.game.Acls.LoadAclResult;
import com.google.android.gms.games.internal.game.GameInstanceBuffer;
import com.google.android.gms.games.internal.game.GameSearchSuggestionBuffer;
import com.google.android.gms.games.internal.request.RequestUpdateOutcomes;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardEntity;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScoreEntity;
import com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult;
import com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer.ReliableMessageSentCallback;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomBuffer;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchBuffer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.QuestEntity;
import com.google.android.gms.games.quest.QuestUpdateListener;
import com.google.android.gms.games.quest.Quests.AcceptQuestResult;
import com.google.android.gms.games.quest.Quests.ClaimMilestoneResult;
import com.google.android.gms.games.quest.Quests.LoadQuestsResult;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests.LoadRequestSummariesResult;
import com.google.android.gms.games.request.Requests.LoadRequestsResult;
import com.google.android.gms.games.request.Requests.SendRequestResult;
import com.google.android.gms.games.request.Requests.UpdateRequestsResult;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotContentsEntity;
import com.google.android.gms.games.snapshot.SnapshotEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import com.google.android.gms.games.snapshot.Snapshots.CommitSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.LoadSnapshotsResult;
import com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult;
import com.google.android.gms.games.stats.PlayerStats;
import com.google.android.gms.games.stats.PlayerStatsBuffer;
import com.google.android.gms.games.stats.PlayerStatsEntity;
import com.google.android.gms.games.stats.Stats.LoadPlayerStatsResult;
import com.google.android.gms.games.video.VideoBuffer;
import com.google.android.gms.games.video.VideoConfiguration;
import com.google.android.gms.games.video.Videos.ListVideosResult;
import com.google.android.gms.internal.zzlx;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzmc;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.internal.zzmn.zzb;
import com.google.android.gms.signin.internal.zzi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;

public final class GamesClientImpl extends zzj<IGamesService> {
    private boolean zzaBA = false;
    private final Binder zzaBB;
    private final long zzaBC;
    private final GamesOptions zzaBD;
    EventIncrementManager zzaBv = new C06681(this);
    private final String zzaBw;
    private PlayerEntity zzaBx;
    private GameEntity zzaBy;
    private final PopupManager zzaBz;

    class C06681 extends EventIncrementManager {
        final /* synthetic */ GamesClientImpl zzaBE;

        C06681(GamesClientImpl gamesClientImpl) {
            this.zzaBE = gamesClientImpl;
        }

        public EventIncrementCache zzwo() {
            return new GameClientEventIncrementCache(this.zzaBE);
        }
    }

    private class GameClientEventIncrementCache extends EventIncrementCache {
        final /* synthetic */ GamesClientImpl zzaBE;

        public GameClientEventIncrementCache(GamesClientImpl gamesClientImpl) {
            this.zzaBE = gamesClientImpl;
            super(gamesClientImpl.getContext().getMainLooper(), 1000);
        }

        protected void zzs(String str, int i) {
            try {
                if (this.zzaBE.isConnected()) {
                    ((IGamesService) this.zzaBE.zzqs()).zzp(str, i);
                } else {
                    GamesLog.zzB("GamesClientImpl", "Unable to increment event " + str + " by " + i + " because the games client is no longer connected");
                }
            } catch (RemoteException e) {
                this.zzaBE.zzb(e);
            }
        }
    }

    private static final class InvitationReceivedNotifier implements zzb<OnInvitationReceivedListener> {
        private final Invitation zzaBP;

        InvitationReceivedNotifier(Invitation invitation) {
            this.zzaBP = invitation;
        }

        public void zza(OnInvitationReceivedListener onInvitationReceivedListener) {
            onInvitationReceivedListener.onInvitationReceived(this.zzaBP);
        }

        public void zzpb() {
        }

        public /* synthetic */ void zzs(Object obj) {
            zza((OnInvitationReceivedListener) obj);
        }
    }

    private static final class InvitationRemovedNotifier implements zzb<OnInvitationReceivedListener> {
        private final String zzTr;

        InvitationRemovedNotifier(String invitationId) {
            this.zzTr = invitationId;
        }

        public void zza(OnInvitationReceivedListener onInvitationReceivedListener) {
            onInvitationReceivedListener.onInvitationRemoved(this.zzTr);
        }

        public void zzpb() {
        }

        public /* synthetic */ void zzs(Object obj) {
            zza((OnInvitationReceivedListener) obj);
        }
    }

    private static final class LeftRoomNotifier implements zzb<RoomUpdateListener> {
        private final String zzaBR;
        private final int zzabx;

        LeftRoomNotifier(int statusCode, String roomId) {
            this.zzabx = statusCode;
            this.zzaBR = roomId;
        }

        public void zza(RoomUpdateListener roomUpdateListener) {
            roomUpdateListener.onLeftRoom(this.zzabx, this.zzaBR);
        }

        public void zzpb() {
        }

        public /* synthetic */ void zzs(Object obj) {
            zza((RoomUpdateListener) obj);
        }
    }

    private static final class MatchRemovedNotifier implements zzb<OnTurnBasedMatchUpdateReceivedListener> {
        private final String zzaCl;

        MatchRemovedNotifier(String matchId) {
            this.zzaCl = matchId;
        }

        public void zza(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
            onTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchRemoved(this.zzaCl);
        }

        public void zzpb() {
        }

        public /* synthetic */ void zzs(Object obj) {
            zza((OnTurnBasedMatchUpdateReceivedListener) obj);
        }
    }

    private static final class MatchUpdateReceivedNotifier implements zzb<OnTurnBasedMatchUpdateReceivedListener> {
        private final TurnBasedMatch zzaCm;

        MatchUpdateReceivedNotifier(TurnBasedMatch match) {
            this.zzaCm = match;
        }

        public void zza(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
            onTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchReceived(this.zzaCm);
        }

        public void zzpb() {
        }

        public /* synthetic */ void zzs(Object obj) {
            zza((OnTurnBasedMatchUpdateReceivedListener) obj);
        }
    }

    private static final class MessageReceivedNotifier implements zzb<RealTimeMessageReceivedListener> {
        private final RealTimeMessage zzaCn;

        MessageReceivedNotifier(RealTimeMessage message) {
            this.zzaCn = message;
        }

        public void zza(RealTimeMessageReceivedListener realTimeMessageReceivedListener) {
            realTimeMessageReceivedListener.onRealTimeMessageReceived(this.zzaCn);
        }

        public void zzpb() {
        }

        public /* synthetic */ void zzs(Object obj) {
            zza((RealTimeMessageReceivedListener) obj);
        }
    }

    private static final class NearbyPlayerDetectedNotifier implements zzb<OnNearbyPlayerDetectedListener> {
        private final Player zzaCo;

        public void zza(OnNearbyPlayerDetectedListener onNearbyPlayerDetectedListener) {
            onNearbyPlayerDetectedListener.zza(this.zzaCo);
        }

        public void zzpb() {
        }

        public /* synthetic */ void zzs(Object obj) {
            zza((OnNearbyPlayerDetectedListener) obj);
        }
    }

    private static final class P2PConnectedNotifier implements zzb<RoomStatusUpdateListener> {
        private final String zzaCu;

        P2PConnectedNotifier(String participantId) {
            this.zzaCu = participantId;
        }

        public void zza(RoomStatusUpdateListener roomStatusUpdateListener) {
            roomStatusUpdateListener.onP2PConnected(this.zzaCu);
        }

        public void zzpb() {
        }

        public /* synthetic */ void zzs(Object obj) {
            zza((RoomStatusUpdateListener) obj);
        }
    }

    private static final class P2PDisconnectedNotifier implements zzb<RoomStatusUpdateListener> {
        private final String zzaCu;

        P2PDisconnectedNotifier(String participantId) {
            this.zzaCu = participantId;
        }

        public void zza(RoomStatusUpdateListener roomStatusUpdateListener) {
            roomStatusUpdateListener.onP2PDisconnected(this.zzaCu);
        }

        public void zzpb() {
        }

        public /* synthetic */ void zzs(Object obj) {
            zza((RoomStatusUpdateListener) obj);
        }
    }

    private static final class QuestCompletedNotifier implements zzb<QuestUpdateListener> {
        private final Quest zzaBG;

        QuestCompletedNotifier(Quest quest) {
            this.zzaBG = quest;
        }

        public void zza(QuestUpdateListener questUpdateListener) {
            questUpdateListener.onQuestCompleted(this.zzaBG);
        }

        public void zzpb() {
        }

        public /* synthetic */ void zzs(Object obj) {
            zza((QuestUpdateListener) obj);
        }
    }

    private static final class RealTimeMessageSentNotifier implements zzb<ReliableMessageSentCallback> {
        private final int zzaCA;
        private final String zzaCz;
        private final int zzabx;

        RealTimeMessageSentNotifier(int statusCode, int token, String recipientParticipantId) {
            this.zzabx = statusCode;
            this.zzaCA = token;
            this.zzaCz = recipientParticipantId;
        }

        public void zza(ReliableMessageSentCallback reliableMessageSentCallback) {
            if (reliableMessageSentCallback != null) {
                reliableMessageSentCallback.onRealTimeMessageSent(this.zzabx, this.zzaCA, this.zzaCz);
            }
        }

        public void zzpb() {
        }

        public /* synthetic */ void zzs(Object obj) {
            zza((ReliableMessageSentCallback) obj);
        }
    }

    private static final class RequestReceivedNotifier implements zzb<OnRequestReceivedListener> {
        private final GameRequest zzaCC;

        RequestReceivedNotifier(GameRequest request) {
            this.zzaCC = request;
        }

        public void zza(OnRequestReceivedListener onRequestReceivedListener) {
            onRequestReceivedListener.onRequestReceived(this.zzaCC);
        }

        public void zzpb() {
        }

        public /* synthetic */ void zzs(Object obj) {
            zza((OnRequestReceivedListener) obj);
        }
    }

    private static final class RequestRemovedNotifier implements zzb<OnRequestReceivedListener> {
        private final String zzDX;

        RequestRemovedNotifier(String requestId) {
            this.zzDX = requestId;
        }

        public void zza(OnRequestReceivedListener onRequestReceivedListener) {
            onRequestReceivedListener.onRequestRemoved(this.zzDX);
        }

        public void zzpb() {
        }

        public /* synthetic */ void zzs(Object obj) {
            zza((OnRequestReceivedListener) obj);
        }
    }

    private static abstract class AbstractRoomNotifier extends zzmb<RoomUpdateListener> {
        AbstractRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        protected void zza(RoomUpdateListener roomUpdateListener, DataHolder dataHolder) {
            zza(roomUpdateListener, GamesClientImpl.zzY(dataHolder), dataHolder.getStatusCode());
        }

        protected abstract void zza(RoomUpdateListener roomUpdateListener, Room room, int i);
    }

    private static abstract class AbstractRoomStatusNotifier extends zzmb<RoomStatusUpdateListener> {
        AbstractRoomStatusNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder) {
            zza(roomStatusUpdateListener, GamesClientImpl.zzY(dataHolder));
        }

        protected abstract void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room);
    }

    private static final class CancelMatchResultImpl implements CancelMatchResult {
        private final Status zzTA;
        private final String zzaBI;

        CancelMatchResultImpl(Status status, String externalMatchId) {
            this.zzTA = status;
            this.zzaBI = externalMatchId;
        }

        public String getMatchId() {
            return this.zzaBI;
        }

        public Status getStatus() {
            return this.zzTA;
        }
    }

    private static final class DeleteSnapshotResultImpl implements DeleteSnapshotResult {
        private final Status zzTA;
        private final String zzaBL;

        DeleteSnapshotResultImpl(int statusCode, String snapshotId) {
            this.zzTA = GamesStatusCodes.zzfU(statusCode);
            this.zzaBL = snapshotId;
        }

        public String getSnapshotId() {
            return this.zzaBL;
        }

        public Status getStatus() {
            return this.zzTA;
        }
    }

    private static final class GameMuteStatusChangeResultImpl implements GameMuteStatusChangeResult {
        private final Status zzTA;
        private final String zzaBM;
        private final boolean zzaBN;

        public GameMuteStatusChangeResultImpl(int statusCode, String externalGameId, boolean isMuted) {
            this.zzTA = GamesStatusCodes.zzfU(statusCode);
            this.zzaBM = externalGameId;
            this.zzaBN = isMuted;
        }

        public Status getStatus() {
            return this.zzTA;
        }
    }

    private static final class GameMuteStatusLoadResultImpl implements GameMuteStatusLoadResult {
        private final Status zzTA;
        private final String zzaBM;
        private final boolean zzaBN;

        public GameMuteStatusLoadResultImpl(DataHolder dataHolder) {
            try {
                this.zzTA = GamesStatusCodes.zzfU(dataHolder.getStatusCode());
                if (dataHolder.getCount() > 0) {
                    this.zzaBM = dataHolder.zzd("external_game_id", 0, 0);
                    this.zzaBN = dataHolder.zze("muted", 0, 0);
                } else {
                    this.zzaBM = null;
                    this.zzaBN = false;
                }
                dataHolder.close();
            } catch (Throwable th) {
                dataHolder.close();
            }
        }

        public Status getStatus() {
            return this.zzTA;
        }
    }

    private static abstract class GamesDataHolderResult extends zzmc {
        protected GamesDataHolderResult(DataHolder dataHolder) {
            super(dataHolder, GamesStatusCodes.zzfU(dataHolder.getStatusCode()));
        }
    }

    private static final class GetTokenResultImpl implements GetTokenResult {
        private final Status zzTA;
        private final String zzTR;

        GetTokenResultImpl(Status status, String token) {
            this.zzTA = status;
            this.zzTR = token;
        }

        public Status getStatus() {
            return this.zzTA;
        }
    }

    private static final class InboxCountResultImpl implements InboxCountResult {
        private final Status zzTA;
        private final Bundle zzaBO;

        InboxCountResultImpl(Status status, Bundle inboxCounts) {
            this.zzTA = status;
            this.zzaBO = inboxCounts;
        }

        public Status getStatus() {
            return this.zzTA;
        }
    }

    private static final class LoadMatchesResultImpl implements LoadMatchesResult {
        private final Status zzTA;
        private final LoadMatchesResponse zzaCa;

        LoadMatchesResultImpl(Status status, Bundle matchData) {
            this.zzTA = status;
            this.zzaCa = new LoadMatchesResponse(matchData);
        }

        public LoadMatchesResponse getMatches() {
            return this.zzaCa;
        }

        public Status getStatus() {
            return this.zzTA;
        }

        public void release() {
            this.zzaCa.release();
        }
    }

    private static final class LoadRequestsResultImpl implements LoadRequestsResult {
        private final Status zzTA;
        private final Bundle zzaCf;

        LoadRequestsResultImpl(Status status, Bundle requestData) {
            this.zzTA = status;
            this.zzaCf = requestData;
        }

        public GameRequestBuffer getRequests(int requestType) {
            String zzgo = RequestType.zzgo(requestType);
            return !this.zzaCf.containsKey(zzgo) ? null : new GameRequestBuffer((DataHolder) this.zzaCf.get(zzgo));
        }

        public Status getStatus() {
            return this.zzTA;
        }

        public void release() {
            for (String parcelable : this.zzaCf.keySet()) {
                DataHolder dataHolder = (DataHolder) this.zzaCf.getParcelable(parcelable);
                if (dataHolder != null) {
                    dataHolder.close();
                }
            }
        }
    }

    private static final class LoadXpForGameCategoriesResultImpl implements LoadXpForGameCategoriesResult {
        private final Status zzTA;
        private final List<String> zzaCi;
        private final Bundle zzaCj;

        LoadXpForGameCategoriesResultImpl(Status status, Bundle xpData) {
            this.zzTA = status;
            this.zzaCi = xpData.getStringArrayList("game_category_list");
            this.zzaCj = xpData;
        }

        public Status getStatus() {
            return this.zzTA;
        }
    }

    private static final class UpdateAchievementResultImpl implements UpdateAchievementResult {
        private final Status zzTA;
        private final String zzaAE;

        UpdateAchievementResultImpl(int statusCode, String achievementId) {
            this.zzTA = GamesStatusCodes.zzfU(statusCode);
            this.zzaAE = achievementId;
        }

        public String getAchievementId() {
            return this.zzaAE;
        }

        public Status getStatus() {
            return this.zzTA;
        }
    }

    private static abstract class AbstractPeerStatusNotifier extends AbstractRoomStatusNotifier {
        private final ArrayList<String> zzaBF = new ArrayList();

        AbstractPeerStatusNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder);
            for (Object add : participantIds) {
                this.zzaBF.add(add);
            }
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            zza(roomStatusUpdateListener, room, this.zzaBF);
        }

        protected abstract void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList);
    }

    private static final class AcceptQuestResultImpl extends GamesDataHolderResult implements AcceptQuestResult {
        private final Quest zzaBG;

        AcceptQuestResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            try {
                if (questBuffer.getCount() > 0) {
                    this.zzaBG = new QuestEntity((Quest) questBuffer.get(0));
                } else {
                    this.zzaBG = null;
                }
                questBuffer.release();
            } catch (Throwable th) {
                questBuffer.release();
            }
        }

        public Quest getQuest() {
            return this.zzaBG;
        }
    }

    private static final class AchievementUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final zzlx.zzb<UpdateAchievementResult> zzakL;

        AchievementUpdatedBinderCallback(zzlx.zzb<UpdateAchievementResult> resultHolder) {
            this.zzakL = (zzlx.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzj(int i, String str) {
            this.zzakL.zzr(new UpdateAchievementResultImpl(i, str));
        }
    }

    private static final class AchievementsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzlx.zzb<LoadAchievementsResult> zzakL;

        AchievementsLoadedBinderCallback(zzlx.zzb<LoadAchievementsResult> resultHolder) {
            this.zzakL = (zzlx.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzh(DataHolder dataHolder) {
            this.zzakL.zzr(new LoadAchievementsResultImpl(dataHolder));
        }
    }

    private static final class AppContentLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzlx.zzb<LoadAppContentResult> zzaBH;

        public AppContentLoadedBinderCallbacks(zzlx.zzb<LoadAppContentResult> resultHolder) {
            this.zzaBH = (zzlx.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zza(DataHolder[] dataHolderArr) {
            this.zzaBH.zzr(new LoadAppContentsResultImpl(dataHolderArr));
        }
    }

    private static final class ClaimMilestoneResultImpl extends GamesDataHolderResult implements ClaimMilestoneResult {
        private final Quest zzaBG;
        private final Milestone zzaBJ;

        ClaimMilestoneResultImpl(DataHolder dataHolder, String milestoneId) {
            super(dataHolder);
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            try {
                if (questBuffer.getCount() > 0) {
                    this.zzaBG = new QuestEntity((Quest) questBuffer.get(0));
                    List zzxk = this.zzaBG.zzxk();
                    int size = zzxk.size();
                    for (int i = 0; i < size; i++) {
                        if (((Milestone) zzxk.get(i)).getMilestoneId().equals(milestoneId)) {
                            this.zzaBJ = (Milestone) zzxk.get(i);
                            return;
                        }
                    }
                    this.zzaBJ = null;
                } else {
                    this.zzaBJ = null;
                    this.zzaBG = null;
                }
                questBuffer.release();
            } finally {
                questBuffer.release();
            }
        }

        public Milestone getMilestone() {
            return this.zzaBJ;
        }

        public Quest getQuest() {
            return this.zzaBG;
        }
    }

    private static final class CommitSnapshotResultImpl extends GamesDataHolderResult implements CommitSnapshotResult {
        private final SnapshotMetadata zzaBK;

        CommitSnapshotResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            SnapshotMetadataBuffer snapshotMetadataBuffer = new SnapshotMetadataBuffer(dataHolder);
            try {
                if (snapshotMetadataBuffer.getCount() > 0) {
                    this.zzaBK = new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0));
                } else {
                    this.zzaBK = null;
                }
                snapshotMetadataBuffer.release();
            } catch (Throwable th) {
                snapshotMetadataBuffer.release();
            }
        }

        public SnapshotMetadata getSnapshotMetadata() {
            return this.zzaBK;
        }
    }

    private static final class ConnectedToRoomNotifier extends AbstractRoomStatusNotifier {
        ConnectedToRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onConnectedToRoom(room);
        }
    }

    private static final class ContactSettingLoadResultImpl extends GamesDataHolderResult implements ContactSettingLoadResult {
        ContactSettingLoadResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class ContactSettingsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzlx.zzb<ContactSettingLoadResult> zzakL;

        ContactSettingsLoadedBinderCallback(zzlx.zzb<ContactSettingLoadResult> holder) {
            this.zzakL = (zzlx.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzI(DataHolder dataHolder) {
            this.zzakL.zzr(new ContactSettingLoadResultImpl(dataHolder));
        }
    }

    private static final class ContactSettingsUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final zzlx.zzb<Status> zzakL;

        ContactSettingsUpdatedBinderCallback(zzlx.zzb<Status> holder) {
            this.zzakL = (zzlx.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzgg(int i) {
            this.zzakL.zzr(GamesStatusCodes.zzfU(i));
        }
    }

    private static final class DisconnectedFromRoomNotifier extends AbstractRoomStatusNotifier {
        DisconnectedFromRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onDisconnectedFromRoom(room);
        }
    }

    private static final class EventsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzlx.zzb<LoadEventsResult> zzakL;

        EventsLoadedBinderCallback(zzlx.zzb<LoadEventsResult> resultHolder) {
            this.zzakL = (zzlx.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzi(DataHolder dataHolder) {
            this.zzakL.zzr(new LoadEventResultImpl(dataHolder));
        }
    }

    private static final class GameInstancesLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzlx.zzb<LoadGameInstancesResult> zzakL;

        GameInstancesLoadedBinderCallback(zzlx.zzb<LoadGameInstancesResult> holder) {
            this.zzakL = (zzlx.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzp(DataHolder dataHolder) {
            this.zzakL.zzr(new LoadGameInstancesResultImpl(dataHolder));
        }
    }

    private static final class GameMuteStatusChangedBinderCallback extends AbstractGamesCallbacks {
        private final zzlx.zzb<GameMuteStatusChangeResult> zzakL;

        GameMuteStatusChangedBinderCallback(zzlx.zzb<GameMuteStatusChangeResult> holder) {
            this.zzakL = (zzlx.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zza(int i, String str, boolean z) {
            this.zzakL.zzr(new GameMuteStatusChangeResultImpl(i, str, z));
        }
    }

    private static final class GameMuteStatusLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzlx.zzb<GameMuteStatusLoadResult> zzakL;

        GameMuteStatusLoadedBinderCallback(zzlx.zzb<GameMuteStatusLoadResult> holder) {
            this.zzakL = (zzlx.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzG(DataHolder dataHolder) {
            this.zzakL.zzr(new GameMuteStatusLoadResultImpl(dataHolder));
        }
    }

    private static final class GameSearchSuggestionsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzlx.zzb<LoadGameSearchSuggestionsResult> zzakL;

        GameSearchSuggestionsLoadedBinderCallback(zzlx.zzb<LoadGameSearchSuggestionsResult> holder) {
            this.zzakL = (zzlx.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzq(DataHolder dataHolder) {
            this.zzakL.zzr(new LoadGameSearchSuggestionsResultImpl(dataHolder));
        }
    }

    private static final class GamesLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzlx.zzb<LoadGamesResult> zzakL;

        GamesLoadedBinderCallback(zzlx.zzb<LoadGamesResult> holder) {
            this.zzakL = (zzlx.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzn(DataHolder dataHolder) {
            this.zzakL.zzr(new LoadGamesResultImpl(dataHolder));
        }
    }

    private static final class GetAuthTokenBinderCallbacks extends AbstractGamesCallbacks {
        private final zzlx.zzb<GetTokenResult> zzakL;

        public GetAuthTokenBinderCallbacks(zzlx.zzb<GetTokenResult> resultHolder) {
            this.zzakL = (zzlx.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzi(int i, String str) {
            this.zzakL.zzr(new GetTokenResultImpl(GamesStatusCodes.zzfU(i), str));
        }
    }

    private static final class InboxCountsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzlx.zzb<InboxCountResult> zzakL;

        InboxCountsLoadedBinderCallback(zzlx.zzb<InboxCountResult> holder) {
            this.zzakL = (zzlx.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzg(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzakL.zzr(new InboxCountResultImpl(GamesStatusCodes.zzfU(i), bundle));
        }
    }

    private static final class InvitationReceivedBinderCallback extends AbstractGamesCallbacks {
        private final zzmn<OnInvitationReceivedListener> zzape;

        InvitationReceivedBinderCallback(zzmn<OnInvitationReceivedListener> listener) {
            this.zzape = listener;
        }

        public void onInvitationRemoved(String invitationId) {
            this.zzape.zza(new InvitationRemovedNotifier(invitationId));
        }

        public void zzs(DataHolder dataHolder) {
            InvitationBuffer invitationBuffer = new InvitationBuffer(dataHolder);
            Invitation invitation = null;
            try {
                if (invitationBuffer.getCount() > 0) {
                    invitation = (Invitation) ((Invitation) invitationBuffer.get(0)).freeze();
                }
                invitationBuffer.release();
                if (invitation != null) {
                    this.zzape.zza(new InvitationReceivedNotifier(invitation));
                }
            } catch (Throwable th) {
                invitationBuffer.release();
            }
        }
    }

    private static final class InvitationsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzlx.zzb<LoadInvitationsResult> zzakL;

        InvitationsLoadedBinderCallback(zzlx.zzb<LoadInvitationsResult> resultHolder) {
            this.zzakL = (zzlx.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzr(DataHolder dataHolder) {
            this.zzakL.zzr(new LoadInvitationsResultImpl(dataHolder));
        }
    }

    private static final class JoinedRoomNotifier extends AbstractRoomNotifier {
        public JoinedRoomNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onJoinedRoom(i, room);
        }
    }

    private static final class LeaderboardMetadataResultImpl extends GamesDataHolderResult implements LeaderboardMetadataResult {
        private final LeaderboardBuffer zzaBQ;

        LeaderboardMetadataResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaBQ = new LeaderboardBuffer(dataHolder);
        }

        public LeaderboardBuffer getLeaderboards() {
            return this.zzaBQ;
        }
    }

    private static final class LeaderboardScoresLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzlx.zzb<LoadScoresResult> zzakL;

        LeaderboardScoresLoadedBinderCallback(zzlx.zzb<LoadScoresResult> resultHolder) {
            this.zzakL = (zzlx.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zza(DataHolder dataHolder, DataHolder dataHolder2) {
            this.zzakL.zzr(new LoadScoresResultImpl(dataHolder, dataHolder2));
        }
    }

    private static final class LeaderboardsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzlx.zzb<LeaderboardMetadataResult> zzakL;

        LeaderboardsLoadedBinderCallback(zzlx.zzb<LeaderboardMetadataResult> resultHolder) {
            this.zzakL = (zzlx.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzj(DataHolder dataHolder) {
            this.zzakL.zzr(new LeaderboardMetadataResultImpl(dataHolder));
        }
    }

    private static final class ListVideosBinderCallback extends AbstractGamesCallbacks {
        private final zzlx.zzb<ListVideosResult> zzakL;

        ListVideosBinderCallback(zzlx.zzb<ListVideosResult> holder) {
            this.zzakL = (zzlx.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzX(DataHolder dataHolder) {
            this.zzakL.zzr(new ListVideosResultImpl(dataHolder));
        }
    }

    public static final class ListVideosResultImpl extends GamesDataHolderResult implements ListVideosResult {
        private final VideoBuffer zzaBS;

        public ListVideosResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaBS = new VideoBuffer(dataHolder);
        }
    }

    private static final class LoadAchievementsResultImpl extends GamesDataHolderResult implements LoadAchievementsResult {
        private final AchievementBuffer zzaBT;

        LoadAchievementsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaBT = new AchievementBuffer(dataHolder);
        }

        public AchievementBuffer getAchievements() {
            return this.zzaBT;
        }
    }

    private static final class LoadAclResultImpl extends GamesDataHolderResult implements LoadAclResult {
        LoadAclResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LoadAppContentsResultImpl extends GamesDataHolderResult implements LoadAppContentResult {
        private final ArrayList<DataHolder> zzaBU;

        LoadAppContentsResultImpl(DataHolder[] appContentData) {
            super(appContentData[0]);
            this.zzaBU = new ArrayList(Arrays.asList(appContentData));
        }
    }

    private static final class LoadEventResultImpl extends GamesDataHolderResult implements LoadEventsResult {
        private final EventBuffer zzaBV;

        LoadEventResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaBV = new EventBuffer(dataHolder);
        }

        public EventBuffer getEvents() {
            return this.zzaBV;
        }
    }

    private static final class LoadGameInstancesResultImpl extends GamesDataHolderResult implements LoadGameInstancesResult {
        private final GameInstanceBuffer zzaBW;

        LoadGameInstancesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaBW = new GameInstanceBuffer(dataHolder);
        }
    }

    private static final class LoadGameSearchSuggestionsResultImpl extends GamesDataHolderResult implements LoadGameSearchSuggestionsResult {
        private final GameSearchSuggestionBuffer zzaBX;

        LoadGameSearchSuggestionsResultImpl(DataHolder data) {
            super(data);
            this.zzaBX = new GameSearchSuggestionBuffer(data);
        }
    }

    private static final class LoadGamesResultImpl extends GamesDataHolderResult implements LoadGamesResult {
        private final GameBuffer zzaBY;

        LoadGamesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaBY = new GameBuffer(dataHolder);
        }

        public GameBuffer getGames() {
            return this.zzaBY;
        }
    }

    private static final class LoadInvitationsResultImpl extends GamesDataHolderResult implements LoadInvitationsResult {
        private final InvitationBuffer zzaBZ;

        LoadInvitationsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaBZ = new InvitationBuffer(dataHolder);
        }

        public InvitationBuffer getInvitations() {
            return this.zzaBZ;
        }
    }

    private static final class LoadPlayerScoreResultImpl extends GamesDataHolderResult implements LoadPlayerScoreResult {
        private final LeaderboardScoreEntity zzaCb;

        LoadPlayerScoreResultImpl(DataHolder scoreHolder) {
            super(scoreHolder);
            LeaderboardScoreBuffer leaderboardScoreBuffer = new LeaderboardScoreBuffer(scoreHolder);
            try {
                if (leaderboardScoreBuffer.getCount() > 0) {
                    this.zzaCb = (LeaderboardScoreEntity) leaderboardScoreBuffer.get(0).freeze();
                } else {
                    this.zzaCb = null;
                }
                leaderboardScoreBuffer.release();
            } catch (Throwable th) {
                leaderboardScoreBuffer.release();
            }
        }

        public LeaderboardScore getScore() {
            return this.zzaCb;
        }
    }

    private static final class LoadPlayerStatsResultImpl extends GamesDataHolderResult implements LoadPlayerStatsResult {
        private final PlayerStats zzaCc;

        LoadPlayerStatsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            PlayerStatsBuffer playerStatsBuffer = new PlayerStatsBuffer(dataHolder);
            try {
                if (playerStatsBuffer.getCount() > 0) {
                    this.zzaCc = new PlayerStatsEntity(playerStatsBuffer.zzgN(0));
                } else {
                    this.zzaCc = null;
                }
                playerStatsBuffer.release();
            } catch (Throwable th) {
                playerStatsBuffer.release();
            }
        }

        public PlayerStats getPlayerStats() {
            return this.zzaCc;
        }
    }

    private static final class LoadPlayersResultImpl extends GamesDataHolderResult implements LoadPlayersResult {
        private final PlayerBuffer zzaCd;

        LoadPlayersResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaCd = new PlayerBuffer(dataHolder);
        }

        public PlayerBuffer getPlayers() {
            return this.zzaCd;
        }
    }

    private static final class LoadProfileSettingsResultImpl extends GamesDataHolderResult implements LoadProfileSettingsResult {
        private final boolean zzaBs;
        private final boolean zzaCe;

        LoadProfileSettingsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            try {
                if (dataHolder.getCount() > 0) {
                    int zzbI = dataHolder.zzbI(0);
                    this.zzaBs = dataHolder.zze("profile_visible", 0, zzbI);
                    this.zzaCe = dataHolder.zze("profile_visibility_explicitly_set", 0, zzbI);
                } else {
                    this.zzaBs = true;
                    this.zzaCe = false;
                }
                dataHolder.close();
            } catch (Throwable th) {
                dataHolder.close();
            }
        }

        public Status getStatus() {
            return this.zzTA;
        }
    }

    private static final class LoadQuestsResultImpl extends GamesDataHolderResult implements LoadQuestsResult {
        private final DataHolder zzafC;

        LoadQuestsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzafC = dataHolder;
        }

        public QuestBuffer getQuests() {
            return new QuestBuffer(this.zzafC);
        }
    }

    private static final class LoadRequestSummariesResultImpl extends GamesDataHolderResult implements LoadRequestSummariesResult {
        LoadRequestSummariesResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LoadScoresResultImpl extends GamesDataHolderResult implements LoadScoresResult {
        private final LeaderboardEntity zzaCg;
        private final LeaderboardScoreBuffer zzaCh;

        LoadScoresResultImpl(DataHolder leaderboard, DataHolder scores) {
            super(scores);
            LeaderboardBuffer leaderboardBuffer = new LeaderboardBuffer(leaderboard);
            try {
                if (leaderboardBuffer.getCount() > 0) {
                    this.zzaCg = (LeaderboardEntity) ((Leaderboard) leaderboardBuffer.get(0)).freeze();
                } else {
                    this.zzaCg = null;
                }
                leaderboardBuffer.release();
                this.zzaCh = new LeaderboardScoreBuffer(scores);
            } catch (Throwable th) {
                leaderboardBuffer.release();
            }
        }

        public Leaderboard getLeaderboard() {
            return this.zzaCg;
        }

        public LeaderboardScoreBuffer getScores() {
            return this.zzaCh;
        }
    }

    private static final class LoadSnapshotsResultImpl extends GamesDataHolderResult implements LoadSnapshotsResult {
        LoadSnapshotsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }

        public SnapshotMetadataBuffer getSnapshots() {
            return new SnapshotMetadataBuffer(this.zzafC);
        }
    }

    private static final class LoadXpStreamResultImpl extends GamesDataHolderResult implements LoadXpStreamResult {
        private final ExperienceEventBuffer zzaCk;

        LoadXpStreamResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaCk = new ExperienceEventBuffer(dataHolder);
        }
    }

    private static final class MatchUpdateReceivedBinderCallback extends AbstractGamesCallbacks {
        private final zzmn<OnTurnBasedMatchUpdateReceivedListener> zzape;

        MatchUpdateReceivedBinderCallback(zzmn<OnTurnBasedMatchUpdateReceivedListener> listener) {
            this.zzape = listener;
        }

        public void onTurnBasedMatchRemoved(String matchId) {
            this.zzape.zza(new MatchRemovedNotifier(matchId));
        }

        public void zzy(DataHolder dataHolder) {
            TurnBasedMatchBuffer turnBasedMatchBuffer = new TurnBasedMatchBuffer(dataHolder);
            TurnBasedMatch turnBasedMatch = null;
            try {
                if (turnBasedMatchBuffer.getCount() > 0) {
                    turnBasedMatch = (TurnBasedMatch) ((TurnBasedMatch) turnBasedMatchBuffer.get(0)).freeze();
                }
                turnBasedMatchBuffer.release();
                if (turnBasedMatch != null) {
                    this.zzape.zza(new MatchUpdateReceivedNotifier(turnBasedMatch));
                }
            } catch (Throwable th) {
                turnBasedMatchBuffer.release();
            }
        }
    }

    private static final class NotifyAclLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzlx.zzb<LoadAclResult> zzakL;

        NotifyAclLoadedBinderCallback(zzlx.zzb<LoadAclResult> resultHolder) {
            this.zzakL = (zzlx.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzH(DataHolder dataHolder) {
            this.zzakL.zzr(new LoadAclResultImpl(dataHolder));
        }
    }

    private static final class NotifyAclUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final zzlx.zzb<Status> zzakL;

        NotifyAclUpdatedBinderCallback(zzlx.zzb<Status> resultHolder) {
            this.zzakL = (zzlx.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzgf(int i) {
            this.zzakL.zzr(GamesStatusCodes.zzfU(i));
        }
    }

    private static final class OpenSnapshotResultImpl extends GamesDataHolderResult implements OpenSnapshotResult {
        private final Snapshot zzaCp;
        private final String zzaCq;
        private final Snapshot zzaCr;
        private final Contents zzaCs;
        private final SnapshotContents zzaCt;

        OpenSnapshotResultImpl(DataHolder dataHolder, Contents currentContents) {
            this(dataHolder, null, currentContents, null, null);
        }

        OpenSnapshotResultImpl(DataHolder metadataHolder, String conflictId, Contents currentContents, Contents conflictContents, Contents resolutionContents) {
            boolean z = true;
            super(metadataHolder);
            SnapshotMetadataBuffer snapshotMetadataBuffer = new SnapshotMetadataBuffer(metadataHolder);
            try {
                if (snapshotMetadataBuffer.getCount() == 0) {
                    this.zzaCp = null;
                    this.zzaCr = null;
                } else if (snapshotMetadataBuffer.getCount() == 1) {
                    if (metadataHolder.getStatusCode() == 4004) {
                        z = false;
                    }
                    com.google.android.gms.common.internal.zzb.zzaa(z);
                    this.zzaCp = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0)), new SnapshotContentsEntity(currentContents));
                    this.zzaCr = null;
                } else {
                    this.zzaCp = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(0)), new SnapshotContentsEntity(currentContents));
                    this.zzaCr = new SnapshotEntity(new SnapshotMetadataEntity(snapshotMetadataBuffer.get(1)), new SnapshotContentsEntity(conflictContents));
                }
                snapshotMetadataBuffer.release();
                this.zzaCq = conflictId;
                this.zzaCs = resolutionContents;
                this.zzaCt = new SnapshotContentsEntity(resolutionContents);
            } catch (Throwable th) {
                snapshotMetadataBuffer.release();
            }
        }

        public String getConflictId() {
            return this.zzaCq;
        }

        public Snapshot getConflictingSnapshot() {
            return this.zzaCr;
        }

        public SnapshotContents getResolutionSnapshotContents() {
            return this.zzaCt;
        }

        public Snapshot getSnapshot() {
            return this.zzaCp;
        }
    }

    private static final class PlayerLeaderboardScoreLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzlx.zzb<LoadPlayerScoreResult> zzakL;

        PlayerLeaderboardScoreLoadedBinderCallback(zzlx.zzb<LoadPlayerScoreResult> resultHolder) {
            this.zzakL = (zzlx.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzJ(DataHolder dataHolder) {
            this.zzakL.zzr(new LoadPlayerScoreResultImpl(dataHolder));
        }
    }

    private static final class PlayerStatsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzlx.zzb<LoadPlayerStatsResult> zzakL;

        public PlayerStatsLoadedBinderCallbacks(zzlx.zzb<LoadPlayerStatsResult> resultHolder) {
            this.zzakL = (zzlx.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzW(DataHolder dataHolder) {
            this.zzakL.zzr(new LoadPlayerStatsResultImpl(dataHolder));
        }
    }

    private static final class PlayerXpForGameCategoriesLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzlx.zzb<LoadXpForGameCategoriesResult> zzakL;

        PlayerXpForGameCategoriesLoadedBinderCallback(zzlx.zzb<LoadXpForGameCategoriesResult> holder) {
            this.zzakL = (zzlx.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzf(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzakL.zzr(new LoadXpForGameCategoriesResultImpl(GamesStatusCodes.zzfU(i), bundle));
        }
    }

    static final class PlayerXpStreamLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzlx.zzb<LoadXpStreamResult> zzakL;

        PlayerXpStreamLoadedBinderCallback(zzlx.zzb<LoadXpStreamResult> holder) {
            this.zzakL = (zzlx.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzU(DataHolder dataHolder) {
            this.zzakL.zzr(new LoadXpStreamResultImpl(dataHolder));
        }
    }

    private static final class PlayersLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzlx.zzb<LoadPlayersResult> zzakL;

        PlayersLoadedBinderCallback(zzlx.zzb<LoadPlayersResult> holder) {
            this.zzakL = (zzlx.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzl(DataHolder dataHolder) {
            this.zzakL.zzr(new LoadPlayersResultImpl(dataHolder));
        }

        public void zzm(DataHolder dataHolder) {
            this.zzakL.zzr(new LoadPlayersResultImpl(dataHolder));
        }
    }

    private static final class PopupLocationInfoBinderCallbacks extends AbstractGamesClient {
        private final PopupManager zzaBz;

        public PopupLocationInfoBinderCallbacks(PopupManager popupManager) {
            this.zzaBz = popupManager;
        }

        public PopupLocationInfoParcelable zzvM() {
            return new PopupLocationInfoParcelable(this.zzaBz.zzwD());
        }
    }

    static final class ProfileSettingsLoadedBinderCallback extends AbstractGamesCallbacks {
        private final zzlx.zzb<LoadProfileSettingsResult> zzakL;

        ProfileSettingsLoadedBinderCallback(zzlx.zzb<LoadProfileSettingsResult> holder) {
            this.zzakL = (zzlx.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzV(DataHolder dataHolder) {
            this.zzakL.zzr(new LoadProfileSettingsResultImpl(dataHolder));
        }
    }

    private static final class ProfileSettingsUpdatedBinderCallback extends AbstractGamesCallbacks {
        private final zzlx.zzb<Status> zzakL;

        ProfileSettingsUpdatedBinderCallback(zzlx.zzb<Status> holder) {
            this.zzakL = (zzlx.zzb) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzgh(int i) {
            this.zzakL.zzr(GamesStatusCodes.zzfU(i));
        }
    }

    private static final class QuestAcceptedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzlx.zzb<AcceptQuestResult> zzaCv;

        public QuestAcceptedBinderCallbacks(zzlx.zzb<AcceptQuestResult> resultHolder) {
            this.zzaCv = (zzlx.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzQ(DataHolder dataHolder) {
            this.zzaCv.zzr(new AcceptQuestResultImpl(dataHolder));
        }
    }

    private static final class QuestMilestoneClaimBinderCallbacks extends AbstractGamesCallbacks {
        private final zzlx.zzb<ClaimMilestoneResult> zzaCw;
        private final String zzaCx;

        public QuestMilestoneClaimBinderCallbacks(zzlx.zzb<ClaimMilestoneResult> resultHolder, String milestoneId) {
            this.zzaCw = (zzlx.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
            this.zzaCx = (String) zzx.zzb((Object) milestoneId, (Object) "MilestoneId must not be null");
        }

        public void zzP(DataHolder dataHolder) {
            this.zzaCw.zzr(new ClaimMilestoneResultImpl(dataHolder, this.zzaCx));
        }
    }

    private static final class QuestUpdateBinderCallback extends AbstractGamesCallbacks {
        private final zzmn<QuestUpdateListener> zzape;

        QuestUpdateBinderCallback(zzmn<QuestUpdateListener> listener) {
            this.zzape = listener;
        }

        private Quest zzaa(DataHolder dataHolder) {
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            Quest quest = null;
            try {
                if (questBuffer.getCount() > 0) {
                    quest = (Quest) ((Quest) questBuffer.get(0)).freeze();
                }
                questBuffer.release();
                return quest;
            } catch (Throwable th) {
                questBuffer.release();
            }
        }

        public void zzR(DataHolder dataHolder) {
            Quest zzaa = zzaa(dataHolder);
            if (zzaa != null) {
                this.zzape.zza(new QuestCompletedNotifier(zzaa));
            }
        }
    }

    private static final class QuestsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzlx.zzb<LoadQuestsResult> zzaCy;

        public QuestsLoadedBinderCallbacks(zzlx.zzb<LoadQuestsResult> resultHolder) {
            this.zzaCy = (zzlx.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzT(DataHolder dataHolder) {
            this.zzaCy.zzr(new LoadQuestsResultImpl(dataHolder));
        }
    }

    private static final class RealTimeReliableMessageBinderCallbacks extends AbstractGamesCallbacks {
        final zzmn<ReliableMessageSentCallback> zzaCB;

        public RealTimeReliableMessageBinderCallbacks(zzmn<ReliableMessageSentCallback> messageSentCallbacks) {
            this.zzaCB = messageSentCallbacks;
        }

        public void zzb(int i, int i2, String str) {
            if (this.zzaCB != null) {
                this.zzaCB.zza(new RealTimeMessageSentNotifier(i, i2, str));
            }
        }
    }

    private static final class RequestReceivedBinderCallback extends AbstractGamesCallbacks {
        private final zzmn<OnRequestReceivedListener> zzape;

        RequestReceivedBinderCallback(zzmn<OnRequestReceivedListener> listener) {
            this.zzape = listener;
        }

        public void onRequestRemoved(String requestId) {
            this.zzape.zza(new RequestRemovedNotifier(requestId));
        }

        public void zzt(DataHolder dataHolder) {
            GameRequestBuffer gameRequestBuffer = new GameRequestBuffer(dataHolder);
            GameRequest gameRequest = null;
            try {
                if (gameRequestBuffer.getCount() > 0) {
                    gameRequest = (GameRequest) ((GameRequest) gameRequestBuffer.get(0)).freeze();
                }
                gameRequestBuffer.release();
                if (gameRequest != null) {
                    this.zzape.zza(new RequestReceivedNotifier(gameRequest));
                }
            } catch (Throwable th) {
                gameRequestBuffer.release();
            }
        }
    }

    private static final class RequestSentBinderCallbacks extends AbstractGamesCallbacks {
        private final zzlx.zzb<SendRequestResult> zzaCD;

        public RequestSentBinderCallbacks(zzlx.zzb<SendRequestResult> resultHolder) {
            this.zzaCD = (zzlx.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzL(DataHolder dataHolder) {
            this.zzaCD.zzr(new SendRequestResultImpl(dataHolder));
        }
    }

    private static final class RequestSummariesLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzlx.zzb<LoadRequestSummariesResult> zzaCE;

        public RequestSummariesLoadedBinderCallbacks(zzlx.zzb<LoadRequestSummariesResult> resultHolder) {
            this.zzaCE = (zzlx.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzM(DataHolder dataHolder) {
            this.zzaCE.zzr(new LoadRequestSummariesResultImpl(dataHolder));
        }
    }

    private static final class RequestsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzlx.zzb<LoadRequestsResult> zzaCF;

        public RequestsLoadedBinderCallbacks(zzlx.zzb<LoadRequestsResult> resultHolder) {
            this.zzaCF = (zzlx.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzd(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzaCF.zzr(new LoadRequestsResultImpl(GamesStatusCodes.zzfU(i), bundle));
        }
    }

    private static final class RequestsUpdatedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzlx.zzb<UpdateRequestsResult> zzaCG;

        public RequestsUpdatedBinderCallbacks(zzlx.zzb<UpdateRequestsResult> resultHolder) {
            this.zzaCG = (zzlx.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzK(DataHolder dataHolder) {
            this.zzaCG.zzr(new UpdateRequestsResultImpl(dataHolder));
        }
    }

    private static final class RoomAutoMatchingNotifier extends AbstractRoomStatusNotifier {
        RoomAutoMatchingNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onRoomAutoMatching(room);
        }
    }

    private static final class RoomBinderCallbacks extends AbstractGamesCallbacks {
        private final zzmn<? extends RoomUpdateListener> zzaCH;
        private final zzmn<? extends RoomStatusUpdateListener> zzaCI;
        private final zzmn<RealTimeMessageReceivedListener> zzaCJ;

        public RoomBinderCallbacks(zzmn<RoomUpdateListener> roomCallbacks) {
            this.zzaCH = (zzmn) zzx.zzb((Object) roomCallbacks, (Object) "Callbacks must not be null");
            this.zzaCI = null;
            this.zzaCJ = null;
        }

        public RoomBinderCallbacks(zzmn<? extends RoomUpdateListener> roomCallbacks, zzmn<? extends RoomStatusUpdateListener> roomStatusCallbacks, zzmn<RealTimeMessageReceivedListener> realTimeMessageReceivedCallbacks) {
            this.zzaCH = (zzmn) zzx.zzb((Object) roomCallbacks, (Object) "Callbacks must not be null");
            this.zzaCI = roomStatusCallbacks;
            this.zzaCJ = realTimeMessageReceivedCallbacks;
        }

        public void onLeftRoom(int statusCode, String externalRoomId) {
            this.zzaCH.zza(new LeftRoomNotifier(statusCode, externalRoomId));
        }

        public void onP2PConnected(String participantId) {
            if (this.zzaCI != null) {
                this.zzaCI.zza(new P2PConnectedNotifier(participantId));
            }
        }

        public void onP2PDisconnected(String participantId) {
            if (this.zzaCI != null) {
                this.zzaCI.zza(new P2PDisconnectedNotifier(participantId));
            }
        }

        public void onRealTimeMessageReceived(RealTimeMessage message) {
            if (this.zzaCJ != null) {
                this.zzaCJ.zza(new MessageReceivedNotifier(message));
            }
        }

        public void zzA(DataHolder dataHolder) {
            this.zzaCH.zza(new JoinedRoomNotifier(dataHolder));
        }

        public void zzB(DataHolder dataHolder) {
            if (this.zzaCI != null) {
                this.zzaCI.zza(new RoomConnectingNotifier(dataHolder));
            }
        }

        public void zzC(DataHolder dataHolder) {
            if (this.zzaCI != null) {
                this.zzaCI.zza(new RoomAutoMatchingNotifier(dataHolder));
            }
        }

        public void zzD(DataHolder dataHolder) {
            this.zzaCH.zza(new RoomConnectedNotifier(dataHolder));
        }

        public void zzE(DataHolder dataHolder) {
            if (this.zzaCI != null) {
                this.zzaCI.zza(new ConnectedToRoomNotifier(dataHolder));
            }
        }

        public void zzF(DataHolder dataHolder) {
            if (this.zzaCI != null) {
                this.zzaCI.zza(new DisconnectedFromRoomNotifier(dataHolder));
            }
        }

        public void zza(DataHolder dataHolder, String[] strArr) {
            if (this.zzaCI != null) {
                this.zzaCI.zza(new PeerInvitedToRoomNotifier(dataHolder, strArr));
            }
        }

        public void zzb(DataHolder dataHolder, String[] strArr) {
            if (this.zzaCI != null) {
                this.zzaCI.zza(new PeerJoinedRoomNotifier(dataHolder, strArr));
            }
        }

        public void zzc(DataHolder dataHolder, String[] strArr) {
            if (this.zzaCI != null) {
                this.zzaCI.zza(new PeerLeftRoomNotifier(dataHolder, strArr));
            }
        }

        public void zzd(DataHolder dataHolder, String[] strArr) {
            if (this.zzaCI != null) {
                this.zzaCI.zza(new PeerDeclinedNotifier(dataHolder, strArr));
            }
        }

        public void zze(DataHolder dataHolder, String[] strArr) {
            if (this.zzaCI != null) {
                this.zzaCI.zza(new PeerConnectedNotifier(dataHolder, strArr));
            }
        }

        public void zzf(DataHolder dataHolder, String[] strArr) {
            if (this.zzaCI != null) {
                this.zzaCI.zza(new PeerDisconnectedNotifier(dataHolder, strArr));
            }
        }

        public void zzz(DataHolder dataHolder) {
            this.zzaCH.zza(new RoomCreatedNotifier(dataHolder));
        }
    }

    private static final class RoomConnectedNotifier extends AbstractRoomNotifier {
        RoomConnectedNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onRoomConnected(i, room);
        }
    }

    private static final class RoomConnectingNotifier extends AbstractRoomStatusNotifier {
        RoomConnectingNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onRoomConnecting(room);
        }
    }

    private static final class RoomCreatedNotifier extends AbstractRoomNotifier {
        public RoomCreatedNotifier(DataHolder dataHolder) {
            super(dataHolder);
        }

        public void zza(RoomUpdateListener roomUpdateListener, Room room, int i) {
            roomUpdateListener.onRoomCreated(i, room);
        }
    }

    private static final class SendRequestResultImpl extends GamesDataHolderResult implements SendRequestResult {
        private final GameRequest zzaCC;

        SendRequestResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            GameRequestBuffer gameRequestBuffer = new GameRequestBuffer(dataHolder);
            try {
                if (gameRequestBuffer.getCount() > 0) {
                    this.zzaCC = (GameRequest) ((GameRequest) gameRequestBuffer.get(0)).freeze();
                } else {
                    this.zzaCC = null;
                }
                gameRequestBuffer.release();
            } catch (Throwable th) {
                gameRequestBuffer.release();
            }
        }
    }

    private static final class SignOutCompleteBinderCallbacks extends AbstractGamesCallbacks {
        private final zzlx.zzb<Status> zzakL;

        public SignOutCompleteBinderCallbacks(zzlx.zzb<Status> resultHolder) {
            this.zzakL = (zzlx.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzvL() {
            this.zzakL.zzr(GamesStatusCodes.zzfU(0));
        }
    }

    private static final class SnapshotCommittedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzlx.zzb<CommitSnapshotResult> zzaCK;

        public SnapshotCommittedBinderCallbacks(zzlx.zzb<CommitSnapshotResult> resultHolder) {
            this.zzaCK = (zzlx.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzO(DataHolder dataHolder) {
            this.zzaCK.zzr(new CommitSnapshotResultImpl(dataHolder));
        }
    }

    static final class SnapshotDeletedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzlx.zzb<DeleteSnapshotResult> zzakL;

        public SnapshotDeletedBinderCallbacks(zzlx.zzb<DeleteSnapshotResult> resultHolder) {
            this.zzakL = (zzlx.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzl(int i, String str) {
            this.zzakL.zzr(new DeleteSnapshotResultImpl(i, str));
        }
    }

    private static final class SnapshotOpenedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzlx.zzb<OpenSnapshotResult> zzaCL;

        public SnapshotOpenedBinderCallbacks(zzlx.zzb<OpenSnapshotResult> resultHolder) {
            this.zzaCL = (zzlx.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zza(DataHolder dataHolder, Contents contents) {
            this.zzaCL.zzr(new OpenSnapshotResultImpl(dataHolder, contents));
        }

        public void zza(DataHolder dataHolder, String str, Contents contents, Contents contents2, Contents contents3) {
            this.zzaCL.zzr(new OpenSnapshotResultImpl(dataHolder, str, contents, contents2, contents3));
        }
    }

    private static final class SnapshotsLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzlx.zzb<LoadSnapshotsResult> zzaCM;

        public SnapshotsLoadedBinderCallbacks(zzlx.zzb<LoadSnapshotsResult> resultHolder) {
            this.zzaCM = (zzlx.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzN(DataHolder dataHolder) {
            this.zzaCM.zzr(new LoadSnapshotsResultImpl(dataHolder));
        }
    }

    private static final class StartRecordingBinderCallback extends AbstractGamesCallbacks {
        private final BaseGamesApiMethodImpl<Status> zzaCN;

        StartRecordingBinderCallback(BaseGamesApiMethodImpl<Status> holder) {
            this.zzaCN = (BaseGamesApiMethodImpl) zzx.zzb((Object) holder, (Object) "Holder must not be null");
        }

        public void zzgi(int i) {
            this.zzaCN.zzb(new Status(i));
        }
    }

    private static final class SubmitScoreBinderCallbacks extends AbstractGamesCallbacks {
        private final zzlx.zzb<SubmitScoreResult> zzakL;

        public SubmitScoreBinderCallbacks(zzlx.zzb<SubmitScoreResult> resultHolder) {
            this.zzakL = (zzlx.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzk(DataHolder dataHolder) {
            this.zzakL.zzr(new SubmitScoreResultImpl(dataHolder));
        }
    }

    private static final class SubmitScoreResultImpl extends GamesDataHolderResult implements SubmitScoreResult {
        private final ScoreSubmissionData zzaCO;

        public SubmitScoreResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            try {
                this.zzaCO = new ScoreSubmissionData(dataHolder);
            } finally {
                dataHolder.close();
            }
        }

        public ScoreSubmissionData getScoreData() {
            return this.zzaCO;
        }
    }

    private static final class TurnBasedMatchCanceledBinderCallbacks extends AbstractGamesCallbacks {
        private final zzlx.zzb<CancelMatchResult> zzaCP;

        public TurnBasedMatchCanceledBinderCallbacks(zzlx.zzb<CancelMatchResult> resultHolder) {
            this.zzaCP = (zzlx.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzk(int i, String str) {
            this.zzaCP.zzr(new CancelMatchResultImpl(GamesStatusCodes.zzfU(i), str));
        }
    }

    private static final class TurnBasedMatchInitiatedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzlx.zzb<InitiateMatchResult> zzaCQ;

        public TurnBasedMatchInitiatedBinderCallbacks(zzlx.zzb<InitiateMatchResult> resultHolder) {
            this.zzaCQ = (zzlx.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzv(DataHolder dataHolder) {
            this.zzaCQ.zzr(new InitiateMatchResultImpl(dataHolder));
        }
    }

    private static final class TurnBasedMatchLeftBinderCallbacks extends AbstractGamesCallbacks {
        private final zzlx.zzb<LeaveMatchResult> zzaCR;

        public TurnBasedMatchLeftBinderCallbacks(zzlx.zzb<LeaveMatchResult> resultHolder) {
            this.zzaCR = (zzlx.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzx(DataHolder dataHolder) {
            this.zzaCR.zzr(new LeaveMatchResultImpl(dataHolder));
        }
    }

    private static final class TurnBasedMatchLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzlx.zzb<LoadMatchResult> zzaCS;

        public TurnBasedMatchLoadedBinderCallbacks(zzlx.zzb<LoadMatchResult> resultHolder) {
            this.zzaCS = (zzlx.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzu(DataHolder dataHolder) {
            this.zzaCS.zzr(new LoadMatchResultImpl(dataHolder));
        }
    }

    private static abstract class TurnBasedMatchResult extends GamesDataHolderResult {
        final TurnBasedMatch zzaCm;

        TurnBasedMatchResult(DataHolder dataHolder) {
            super(dataHolder);
            TurnBasedMatchBuffer turnBasedMatchBuffer = new TurnBasedMatchBuffer(dataHolder);
            try {
                if (turnBasedMatchBuffer.getCount() > 0) {
                    this.zzaCm = (TurnBasedMatch) ((TurnBasedMatch) turnBasedMatchBuffer.get(0)).freeze();
                } else {
                    this.zzaCm = null;
                }
                turnBasedMatchBuffer.release();
            } catch (Throwable th) {
                turnBasedMatchBuffer.release();
            }
        }

        public TurnBasedMatch getMatch() {
            return this.zzaCm;
        }
    }

    private static final class TurnBasedMatchUpdatedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzlx.zzb<UpdateMatchResult> zzaCT;

        public TurnBasedMatchUpdatedBinderCallbacks(zzlx.zzb<UpdateMatchResult> resultHolder) {
            this.zzaCT = (zzlx.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzw(DataHolder dataHolder) {
            this.zzaCT.zzr(new UpdateMatchResultImpl(dataHolder));
        }
    }

    private static final class TurnBasedMatchesLoadedBinderCallbacks extends AbstractGamesCallbacks {
        private final zzlx.zzb<LoadMatchesResult> zzaCU;

        public TurnBasedMatchesLoadedBinderCallbacks(zzlx.zzb<LoadMatchesResult> resultHolder) {
            this.zzaCU = (zzlx.zzb) zzx.zzb((Object) resultHolder, (Object) "Holder must not be null");
        }

        public void zzc(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzaCU.zzr(new LoadMatchesResultImpl(GamesStatusCodes.zzfU(i), bundle));
        }
    }

    private static final class UpdateRequestsResultImpl extends GamesDataHolderResult implements UpdateRequestsResult {
        private final RequestUpdateOutcomes zzaCV;

        UpdateRequestsResultImpl(DataHolder dataHolder) {
            super(dataHolder);
            this.zzaCV = RequestUpdateOutcomes.zzab(dataHolder);
        }

        public Set<String> getRequestIds() {
            return this.zzaCV.getRequestIds();
        }

        public int getRequestOutcome(String requestId) {
            return this.zzaCV.getRequestOutcome(requestId);
        }
    }

    private static final class InitiateMatchResultImpl extends TurnBasedMatchResult implements InitiateMatchResult {
        InitiateMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LeaveMatchResultImpl extends TurnBasedMatchResult implements LeaveMatchResult {
        LeaveMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class LoadMatchResultImpl extends TurnBasedMatchResult implements LoadMatchResult {
        LoadMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    private static final class PeerConnectedNotifier extends AbstractPeerStatusNotifier {
        PeerConnectedNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder, participantIds);
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeersConnected(room, arrayList);
        }
    }

    private static final class PeerDeclinedNotifier extends AbstractPeerStatusNotifier {
        PeerDeclinedNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder, participantIds);
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerDeclined(room, arrayList);
        }
    }

    private static final class PeerDisconnectedNotifier extends AbstractPeerStatusNotifier {
        PeerDisconnectedNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder, participantIds);
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeersDisconnected(room, arrayList);
        }
    }

    private static final class PeerInvitedToRoomNotifier extends AbstractPeerStatusNotifier {
        PeerInvitedToRoomNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder, participantIds);
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerInvitedToRoom(room, arrayList);
        }
    }

    private static final class PeerJoinedRoomNotifier extends AbstractPeerStatusNotifier {
        PeerJoinedRoomNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder, participantIds);
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerJoined(room, arrayList);
        }
    }

    private static final class PeerLeftRoomNotifier extends AbstractPeerStatusNotifier {
        PeerLeftRoomNotifier(DataHolder dataHolder, String[] participantIds) {
            super(dataHolder, participantIds);
        }

        protected void zza(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerLeft(room, arrayList);
        }
    }

    private static final class UpdateMatchResultImpl extends TurnBasedMatchResult implements UpdateMatchResult {
        UpdateMatchResultImpl(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    public GamesClientImpl(Context context, Looper looper, zzf clientSettings, GamesOptions options, ConnectionCallbacks connectedListener, OnConnectionFailedListener connectionFailedListener) {
        super(context, looper, 1, clientSettings, connectedListener, connectionFailedListener);
        this.zzaBw = clientSettings.zzqd();
        this.zzaBB = new Binder();
        this.zzaBz = PopupManager.zza(this, clientSettings.zzpZ());
        zzo(clientSettings.zzqf());
        this.zzaBC = (long) hashCode();
        this.zzaBD = options;
    }

    private static Room zzY(DataHolder dataHolder) {
        RoomBuffer roomBuffer = new RoomBuffer(dataHolder);
        Room room = null;
        try {
            if (roomBuffer.getCount() > 0) {
                room = (Room) ((Room) roomBuffer.get(0)).freeze();
            }
            roomBuffer.release();
            return room;
        } catch (Throwable th) {
            roomBuffer.release();
        }
    }

    private void zzb(RemoteException remoteException) {
        GamesLog.zzb("GamesClientImpl", "service died", remoteException);
    }

    private void zzvP() {
        this.zzaBx = null;
        this.zzaBy = null;
    }

    public void disconnect() {
        this.zzaBA = false;
        if (isConnected()) {
            try {
                IGamesService iGamesService = (IGamesService) zzqs();
                iGamesService.zzwn();
                this.zzaBv.flush();
                iGamesService.zzF(this.zzaBC);
            } catch (RemoteException e) {
                GamesLog.zzA("GamesClientImpl", "Failed to notify client disconnect.");
            }
        }
        super.disconnect();
    }

    public void onConnectionFailed(ConnectionResult result) {
        super.onConnectionFailed(result);
        this.zzaBA = false;
    }

    protected /* synthetic */ IInterface zzW(IBinder iBinder) {
        return zzbV(iBinder);
    }

    public int zza(zzmn<ReliableMessageSentCallback> com_google_android_gms_internal_zzmn_com_google_android_gms_games_multiplayer_realtime_RealTimeMultiplayer_ReliableMessageSentCallback, byte[] bArr, String str, String str2) {
        try {
            return ((IGamesService) zzqs()).zza(new RealTimeReliableMessageBinderCallbacks(com_google_android_gms_internal_zzmn_com_google_android_gms_games_multiplayer_realtime_RealTimeMultiplayer_ReliableMessageSentCallback), bArr, str, str2);
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public int zza(byte[] bArr, String str, String[] strArr) {
        zzx.zzb((Object) strArr, (Object) "Participant IDs must not be null");
        try {
            return ((IGamesService) zzqs()).zzb(bArr, str, strArr);
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public Intent zza(int i, byte[] bArr, int i2, Bitmap bitmap, String str) {
        try {
            Intent zza = ((IGamesService) zzqs()).zza(i, bArr, i2, str);
            zzx.zzb((Object) bitmap, (Object) "Must provide a non null icon");
            zza.putExtra("com.google.android.gms.games.REQUEST_ITEM_ICON", bitmap);
            return zza;
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zza(PlayerEntity playerEntity) {
        try {
            return ((IGamesService) zzqs()).zza(playerEntity);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zza(Room room, int i) {
        try {
            return ((IGamesService) zzqs()).zza((RoomEntity) room.freeze(), i);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zza(String str, boolean z, boolean z2, int i) {
        try {
            return ((IGamesService) zzqs()).zza(str, z, z2, i);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    protected void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (i == 0 && bundle != null) {
            bundle.setClassLoader(GamesClientImpl.class.getClassLoader());
            this.zzaBA = bundle.getBoolean("show_welcome_popup");
            this.zzaBx = (PlayerEntity) bundle.getParcelable("com.google.android.gms.games.current_player");
            this.zzaBy = (GameEntity) bundle.getParcelable("com.google.android.gms.games.current_game");
        }
        super.zza(i, iBinder, bundle, i2);
    }

    public void zza(IBinder iBinder, Bundle bundle) {
        if (isConnected()) {
            try {
                ((IGamesService) zzqs()).zza(iBinder, bundle);
            } catch (RemoteException e) {
                zzb(e);
            }
        }
    }

    public void zza(zza com_google_android_gms_common_api_GoogleApiClient_zza) {
        zzvP();
        super.zza(com_google_android_gms_common_api_GoogleApiClient_zza);
    }

    public void zza(BaseGamesApiMethodImpl<Status> baseGamesApiMethodImpl, String str, String str2, VideoConfiguration videoConfiguration) throws RemoteException {
        ((IGamesService) zzqs()).zza(new StartRecordingBinderCallback(baseGamesApiMethodImpl), str, str2, videoConfiguration);
    }

    public void zza(Snapshot snapshot) {
        SnapshotContents snapshotContents = snapshot.getSnapshotContents();
        zzx.zza(!snapshotContents.isClosed(), (Object) "Snapshot already closed");
        Contents zzsh = snapshotContents.zzsh();
        snapshotContents.close();
        try {
            ((IGamesService) zzqs()).zza(zzsh);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zza(zzlx.zzb<LoadInvitationsResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_multiplayer_Invitations_LoadInvitationsResult, int i) throws RemoteException {
        ((IGamesService) zzqs()).zza(new InvitationsLoadedBinderCallback(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_multiplayer_Invitations_LoadInvitationsResult), i);
    }

    public void zza(zzlx.zzb<LoadRequestsResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_request_Requests_LoadRequestsResult, int i, int i2, int i3) throws RemoteException {
        ((IGamesService) zzqs()).zza(new RequestsLoadedBinderCallbacks(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_request_Requests_LoadRequestsResult), i, i2, i3);
    }

    public void zza(zzlx.zzb<LoadAppContentResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_appcontent_AppContents_LoadAppContentResult, int i, String str, String[] strArr, boolean z) throws RemoteException {
        ((IGamesService) zzqs()).zza(new AppContentLoadedBinderCallbacks(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_appcontent_AppContents_LoadAppContentResult), i, str, strArr, z);
    }

    public void zza(zzlx.zzb<LoadPlayersResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_Players_LoadPlayersResult, int i, boolean z, boolean z2) throws RemoteException {
        ((IGamesService) zzqs()).zza(new PlayersLoadedBinderCallback(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_Players_LoadPlayersResult), i, z, z2);
    }

    public void zza(zzlx.zzb<LoadMatchesResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LoadMatchesResult, int i, int[] iArr) throws RemoteException {
        ((IGamesService) zzqs()).zza(new TurnBasedMatchesLoadedBinderCallbacks(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LoadMatchesResult), i, iArr);
    }

    public void zza(zzlx.zzb<LoadScoresResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult, LeaderboardScoreBuffer leaderboardScoreBuffer, int i, int i2) throws RemoteException {
        ((IGamesService) zzqs()).zza(new LeaderboardScoresLoadedBinderCallback(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult), leaderboardScoreBuffer.zzxc().asBundle(), i, i2);
    }

    public void zza(zzlx.zzb<InitiateMatchResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult, TurnBasedMatchConfig turnBasedMatchConfig) throws RemoteException {
        ((IGamesService) zzqs()).zza(new TurnBasedMatchInitiatedBinderCallbacks(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult), turnBasedMatchConfig.getVariant(), turnBasedMatchConfig.zzxi(), turnBasedMatchConfig.getInvitedPlayerIds(), turnBasedMatchConfig.getAutoMatchCriteria());
    }

    public void zza(zzlx.zzb<CommitSnapshotResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_snapshot_Snapshots_CommitSnapshotResult, Snapshot snapshot, SnapshotMetadataChange snapshotMetadataChange) throws RemoteException {
        SnapshotContents snapshotContents = snapshot.getSnapshotContents();
        zzx.zza(!snapshotContents.isClosed(), (Object) "Snapshot already closed");
        BitmapTeleporter zzxn = snapshotMetadataChange.zzxn();
        if (zzxn != null) {
            zzxn.zzc(getContext().getCacheDir());
        }
        Contents zzsh = snapshotContents.zzsh();
        snapshotContents.close();
        ((IGamesService) zzqs()).zza(new SnapshotCommittedBinderCallbacks(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_snapshot_Snapshots_CommitSnapshotResult), snapshot.getMetadata().getSnapshotId(), (SnapshotMetadataChangeEntity) snapshotMetadataChange, zzsh);
    }

    public void zza(zzlx.zzb<UpdateAchievementResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult, String str) throws RemoteException {
        IGamesCallbacks iGamesCallbacks;
        if (com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult == null) {
            iGamesCallbacks = null;
        } else {
            Object achievementUpdatedBinderCallback = new AchievementUpdatedBinderCallback(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult);
        }
        ((IGamesService) zzqs()).zza(iGamesCallbacks, str, this.zzaBz.zzwC(), this.zzaBz.zzwB());
    }

    public void zza(zzlx.zzb<UpdateAchievementResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult, String str, int i) throws RemoteException {
        ((IGamesService) zzqs()).zza(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult == null ? null : new AchievementUpdatedBinderCallback(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult), str, i, this.zzaBz.zzwC(), this.zzaBz.zzwB());
    }

    public void zza(zzlx.zzb<LoadScoresResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult, String str, int i, int i2, int i3, boolean z) throws RemoteException {
        ((IGamesService) zzqs()).zza(new LeaderboardScoresLoadedBinderCallback(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult), str, i, i2, i3, z);
    }

    public void zza(zzlx.zzb<LoadPlayersResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_Players_LoadPlayersResult, String str, int i, boolean z, boolean z2) throws RemoteException {
        Object obj = -1;
        switch (str.hashCode()) {
            case 156408498:
                if (str.equals("played_with")) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                ((IGamesService) zzqs()).zzd(new PlayersLoadedBinderCallback(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_Players_LoadPlayersResult), str, i, z, z2);
                return;
            default:
                throw new IllegalArgumentException("Invalid player collection: " + str);
        }
    }

    public void zza(zzlx.zzb<LoadMatchesResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LoadMatchesResult, String str, int i, int[] iArr) throws RemoteException {
        ((IGamesService) zzqs()).zza(new TurnBasedMatchesLoadedBinderCallbacks(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LoadMatchesResult), str, i, iArr);
    }

    public void zza(zzlx.zzb<SubmitScoreResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_leaderboard_Leaderboards_SubmitScoreResult, String str, long j, String str2) throws RemoteException {
        ((IGamesService) zzqs()).zza(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_leaderboard_Leaderboards_SubmitScoreResult == null ? null : new SubmitScoreBinderCallbacks(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_leaderboard_Leaderboards_SubmitScoreResult), str, j, str2);
    }

    public void zza(zzlx.zzb<LeaveMatchResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LeaveMatchResult, String str, String str2) throws RemoteException {
        ((IGamesService) zzqs()).zzc(new TurnBasedMatchLeftBinderCallbacks(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LeaveMatchResult), str, str2);
    }

    public void zza(zzlx.zzb<LoadPlayerScoreResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadPlayerScoreResult, String str, String str2, int i, int i2) throws RemoteException {
        ((IGamesService) zzqs()).zza(new PlayerLeaderboardScoreLoadedBinderCallback(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadPlayerScoreResult), str, str2, i, i2);
    }

    public void zza(zzlx.zzb<LoadRequestsResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_request_Requests_LoadRequestsResult, String str, String str2, int i, int i2, int i3) throws RemoteException {
        ((IGamesService) zzqs()).zza(new RequestsLoadedBinderCallbacks(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_request_Requests_LoadRequestsResult), str, str2, i, i2, i3);
    }

    public void zza(zzlx.zzb<LoadScoresResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult, String str, String str2, int i, int i2, int i3, boolean z) throws RemoteException {
        ((IGamesService) zzqs()).zza(new LeaderboardScoresLoadedBinderCallback(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult), str, str2, i, i2, i3, z);
    }

    public void zza(zzlx.zzb<LoadPlayersResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_Players_LoadPlayersResult, String str, String str2, int i, boolean z, boolean z2) throws RemoteException {
        Object obj = -1;
        switch (str.hashCode()) {
            case -1049482625:
                if (str.equals("nearby")) {
                    obj = 2;
                    break;
                }
                break;
            case 156408498:
                if (str.equals("played_with")) {
                    obj = 1;
                    break;
                }
                break;
            case 782949780:
                if (str.equals("circled")) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
            case 1:
            case 2:
                ((IGamesService) zzqs()).zza(new PlayersLoadedBinderCallback(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_Players_LoadPlayersResult), str, str2, i, z, z2);
                return;
            default:
                throw new IllegalArgumentException("Invalid player collection: " + str);
        }
    }

    public void zza(zzlx.zzb<OpenSnapshotResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_snapshot_Snapshots_OpenSnapshotResult, String str, String str2, SnapshotMetadataChange snapshotMetadataChange, SnapshotContents snapshotContents) throws RemoteException {
        zzx.zza(!snapshotContents.isClosed(), (Object) "SnapshotContents already closed");
        BitmapTeleporter zzxn = snapshotMetadataChange.zzxn();
        if (zzxn != null) {
            zzxn.zzc(getContext().getCacheDir());
        }
        Contents zzsh = snapshotContents.zzsh();
        snapshotContents.close();
        ((IGamesService) zzqs()).zza(new SnapshotOpenedBinderCallbacks(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_snapshot_Snapshots_OpenSnapshotResult), str, str2, (SnapshotMetadataChangeEntity) snapshotMetadataChange, zzsh);
    }

    public void zza(zzlx.zzb<LeaderboardMetadataResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult, String str, String str2, boolean z) throws RemoteException {
        ((IGamesService) zzqs()).zzb(new LeaderboardsLoadedBinderCallback(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult), str, str2, z);
    }

    public void zza(zzlx.zzb<LoadQuestsResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult, String str, String str2, boolean z, String[] strArr) throws RemoteException {
        this.zzaBv.flush();
        ((IGamesService) zzqs()).zza(new QuestsLoadedBinderCallbacks(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult), str, str2, strArr, z);
    }

    public void zza(zzlx.zzb<LoadQuestsResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult, String str, String str2, int[] iArr, int i, boolean z) throws RemoteException {
        this.zzaBv.flush();
        ((IGamesService) zzqs()).zza(new QuestsLoadedBinderCallbacks(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult), str, str2, iArr, i, z);
    }

    public void zza(zzlx.zzb<UpdateRequestsResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_request_Requests_UpdateRequestsResult, String str, String str2, String[] strArr) throws RemoteException {
        ((IGamesService) zzqs()).zza(new RequestsUpdatedBinderCallbacks(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_request_Requests_UpdateRequestsResult), str, str2, strArr);
    }

    public void zza(zzlx.zzb<LoadPlayersResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_Players_LoadPlayersResult, String str, boolean z) throws RemoteException {
        ((IGamesService) zzqs()).zzf(new PlayersLoadedBinderCallback(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_Players_LoadPlayersResult), str, z);
    }

    public void zza(zzlx.zzb<OpenSnapshotResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_snapshot_Snapshots_OpenSnapshotResult, String str, boolean z, int i) throws RemoteException {
        ((IGamesService) zzqs()).zza(new SnapshotOpenedBinderCallbacks(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_snapshot_Snapshots_OpenSnapshotResult), str, z, i);
    }

    public void zza(zzlx.zzb<UpdateMatchResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_UpdateMatchResult, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr) throws RemoteException {
        ((IGamesService) zzqs()).zza(new TurnBasedMatchUpdatedBinderCallbacks(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_UpdateMatchResult), str, bArr, str2, participantResultArr);
    }

    public void zza(zzlx.zzb<UpdateMatchResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_UpdateMatchResult, String str, byte[] bArr, ParticipantResult[] participantResultArr) throws RemoteException {
        ((IGamesService) zzqs()).zza(new TurnBasedMatchUpdatedBinderCallbacks(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_UpdateMatchResult), str, bArr, participantResultArr);
    }

    public void zza(zzlx.zzb<SendRequestResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_request_Requests_SendRequestResult, String str, String[] strArr, int i, byte[] bArr, int i2) throws RemoteException {
        ((IGamesService) zzqs()).zza(new RequestSentBinderCallbacks(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_request_Requests_SendRequestResult), str, strArr, i, bArr, i2);
    }

    public void zza(zzlx.zzb<LoadPlayersResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_Players_LoadPlayersResult, boolean z) throws RemoteException {
        ((IGamesService) zzqs()).zzc(new PlayersLoadedBinderCallback(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_Players_LoadPlayersResult), z);
    }

    public void zza(zzlx.zzb<Status> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status, boolean z, Bundle bundle) throws RemoteException {
        ((IGamesService) zzqs()).zza(new ContactSettingsUpdatedBinderCallback(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status), z, bundle);
    }

    public void zza(zzlx.zzb<LoadEventsResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_event_Events_LoadEventsResult, boolean z, String... strArr) throws RemoteException {
        this.zzaBv.flush();
        ((IGamesService) zzqs()).zza(new EventsLoadedBinderCallback(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_event_Events_LoadEventsResult), z, strArr);
    }

    public void zza(zzlx.zzb<LoadQuestsResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult, int[] iArr, int i, boolean z) throws RemoteException {
        this.zzaBv.flush();
        ((IGamesService) zzqs()).zza(new QuestsLoadedBinderCallbacks(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult), iArr, i, z);
    }

    public void zza(zzlx.zzb<LoadPlayersResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_Players_LoadPlayersResult, String[] strArr) throws RemoteException {
        ((IGamesService) zzqs()).zzc(new PlayersLoadedBinderCallback(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_Players_LoadPlayersResult), strArr);
    }

    public void zza(zzmn<OnInvitationReceivedListener> com_google_android_gms_internal_zzmn_com_google_android_gms_games_multiplayer_OnInvitationReceivedListener) {
        try {
            ((IGamesService) zzqs()).zza(new InvitationReceivedBinderCallback(com_google_android_gms_internal_zzmn_com_google_android_gms_games_multiplayer_OnInvitationReceivedListener), this.zzaBC);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zza(zzmn<RoomUpdateListener> com_google_android_gms_internal_zzmn_com_google_android_gms_games_multiplayer_realtime_RoomUpdateListener, zzmn<RoomStatusUpdateListener> com_google_android_gms_internal_zzmn_com_google_android_gms_games_multiplayer_realtime_RoomStatusUpdateListener, zzmn<RealTimeMessageReceivedListener> com_google_android_gms_internal_zzmn_com_google_android_gms_games_multiplayer_realtime_RealTimeMessageReceivedListener, RoomConfig roomConfig) {
        try {
            ((IGamesService) zzqs()).zza(new RoomBinderCallbacks(com_google_android_gms_internal_zzmn_com_google_android_gms_games_multiplayer_realtime_RoomUpdateListener, com_google_android_gms_internal_zzmn_com_google_android_gms_games_multiplayer_realtime_RoomStatusUpdateListener, com_google_android_gms_internal_zzmn_com_google_android_gms_games_multiplayer_realtime_RealTimeMessageReceivedListener), this.zzaBB, roomConfig.getVariant(), roomConfig.getInvitedPlayerIds(), roomConfig.getAutoMatchCriteria(), false, this.zzaBC);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zza(zzmn<RoomUpdateListener> com_google_android_gms_internal_zzmn_com_google_android_gms_games_multiplayer_realtime_RoomUpdateListener, String str) {
        try {
            ((IGamesService) zzqs()).zzc(new RoomBinderCallbacks(com_google_android_gms_internal_zzmn_com_google_android_gms_games_multiplayer_realtime_RoomUpdateListener), str);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public Intent zzb(int i, int i2, boolean z) {
        try {
            return ((IGamesService) zzqs()).zzb(i, i2, z);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zzb(int[] iArr) {
        try {
            return ((IGamesService) zzqs()).zzb(iArr);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    protected Set<Scope> zzb(Set<Scope> set) {
        Scope scope = new Scope(Scopes.GAMES);
        Scope scope2 = new Scope("https://www.googleapis.com/auth/games.firstparty");
        int i = 0;
        boolean z = false;
        for (Scope scope3 : set) {
            int i2;
            boolean z2;
            if (scope3.equals(scope)) {
                i2 = i;
                z2 = true;
            } else if (scope3.equals(scope2)) {
                i2 = 1;
                z2 = z;
            } else {
                i2 = i;
                z2 = z;
            }
            z = z2;
            i = i2;
        }
        if (i != 0) {
            zzx.zza(!z, "Cannot have both %s and %s!", Scopes.GAMES, "https://www.googleapis.com/auth/games.firstparty");
        } else {
            zzx.zza(z, "Games APIs requires %s to function.", Scopes.GAMES);
        }
        return set;
    }

    public void zzb(zzlx.zzb<LoadPlayersResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_Players_LoadPlayersResult, int i, boolean z, boolean z2) throws RemoteException {
        ((IGamesService) zzqs()).zzb(new PlayersLoadedBinderCallback(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_Players_LoadPlayersResult), i, z, z2);
    }

    public void zzb(zzlx.zzb<UpdateAchievementResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult, String str) throws RemoteException {
        IGamesCallbacks iGamesCallbacks;
        if (com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult == null) {
            iGamesCallbacks = null;
        } else {
            Object achievementUpdatedBinderCallback = new AchievementUpdatedBinderCallback(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult);
        }
        ((IGamesService) zzqs()).zzb(iGamesCallbacks, str, this.zzaBz.zzwC(), this.zzaBz.zzwB());
    }

    public void zzb(zzlx.zzb<UpdateAchievementResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult, String str, int i) throws RemoteException {
        ((IGamesService) zzqs()).zzb(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult == null ? null : new AchievementUpdatedBinderCallback(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_achievement_Achievements_UpdateAchievementResult), str, i, this.zzaBz.zzwC(), this.zzaBz.zzwB());
    }

    public void zzb(zzlx.zzb<LoadScoresResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult, String str, int i, int i2, int i3, boolean z) throws RemoteException {
        ((IGamesService) zzqs()).zzb(new LeaderboardScoresLoadedBinderCallback(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult), str, i, i2, i3, z);
    }

    public void zzb(zzlx.zzb<LoadPlayersResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_Players_LoadPlayersResult, String str, int i, boolean z, boolean z2) throws RemoteException {
        ((IGamesService) zzqs()).zzb(new PlayersLoadedBinderCallback(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_Players_LoadPlayersResult), str, i, z, z2);
    }

    public void zzb(zzlx.zzb<ClaimMilestoneResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_quest_Quests_ClaimMilestoneResult, String str, String str2) throws RemoteException {
        this.zzaBv.flush();
        ((IGamesService) zzqs()).zzf(new QuestMilestoneClaimBinderCallbacks(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_quest_Quests_ClaimMilestoneResult, str2), str, str2);
    }

    public void zzb(zzlx.zzb<LoadScoresResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult, String str, String str2, int i, int i2, int i3, boolean z) throws RemoteException {
        ((IGamesService) zzqs()).zzb(new LeaderboardScoresLoadedBinderCallback(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LoadScoresResult), str, str2, i, i2, i3, z);
    }

    public void zzb(zzlx.zzb<LoadPlayersResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_Players_LoadPlayersResult, String str, String str2, int i, boolean z, boolean z2) throws RemoteException {
        ((IGamesService) zzqs()).zzb(new PlayersLoadedBinderCallback(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_Players_LoadPlayersResult), str, str2, i, z, z2);
    }

    public void zzb(zzlx.zzb<LoadAchievementsResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_achievement_Achievements_LoadAchievementsResult, String str, String str2, boolean z) throws RemoteException {
        ((IGamesService) zzqs()).zza(new AchievementsLoadedBinderCallback(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_achievement_Achievements_LoadAchievementsResult), str, str2, z);
    }

    public void zzb(zzlx.zzb<LeaderboardMetadataResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult, String str, boolean z) throws RemoteException {
        ((IGamesService) zzqs()).zzc(new LeaderboardsLoadedBinderCallback(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult), str, z);
    }

    public void zzb(zzlx.zzb<LeaderboardMetadataResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult, boolean z) throws RemoteException {
        ((IGamesService) zzqs()).zzb(new LeaderboardsLoadedBinderCallback(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult), z);
    }

    public void zzb(zzlx.zzb<LoadQuestsResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult, boolean z, String[] strArr) throws RemoteException {
        this.zzaBv.flush();
        ((IGamesService) zzqs()).zza(new QuestsLoadedBinderCallbacks(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_quest_Quests_LoadQuestsResult), strArr, z);
    }

    public void zzb(zzlx.zzb<UpdateRequestsResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_request_Requests_UpdateRequestsResult, String[] strArr) throws RemoteException {
        ((IGamesService) zzqs()).zza(new RequestsUpdatedBinderCallbacks(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_request_Requests_UpdateRequestsResult), strArr);
    }

    public void zzb(zzmn<OnTurnBasedMatchUpdateReceivedListener> com_google_android_gms_internal_zzmn_com_google_android_gms_games_multiplayer_turnbased_OnTurnBasedMatchUpdateReceivedListener) {
        try {
            ((IGamesService) zzqs()).zzb(new MatchUpdateReceivedBinderCallback(com_google_android_gms_internal_zzmn_com_google_android_gms_games_multiplayer_turnbased_OnTurnBasedMatchUpdateReceivedListener), this.zzaBC);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zzb(zzmn<RoomUpdateListener> com_google_android_gms_internal_zzmn_com_google_android_gms_games_multiplayer_realtime_RoomUpdateListener, zzmn<RoomStatusUpdateListener> com_google_android_gms_internal_zzmn_com_google_android_gms_games_multiplayer_realtime_RoomStatusUpdateListener, zzmn<RealTimeMessageReceivedListener> com_google_android_gms_internal_zzmn_com_google_android_gms_games_multiplayer_realtime_RealTimeMessageReceivedListener, RoomConfig roomConfig) {
        try {
            ((IGamesService) zzqs()).zza(new RoomBinderCallbacks(com_google_android_gms_internal_zzmn_com_google_android_gms_games_multiplayer_realtime_RoomUpdateListener, com_google_android_gms_internal_zzmn_com_google_android_gms_games_multiplayer_realtime_RoomStatusUpdateListener, com_google_android_gms_internal_zzmn_com_google_android_gms_games_multiplayer_realtime_RealTimeMessageReceivedListener), this.zzaBB, roomConfig.getInvitationId(), false, this.zzaBC);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    protected IGamesService zzbV(IBinder iBinder) {
        return Stub.zzbY(iBinder);
    }

    public Intent zzc(int i, int i2, boolean z) {
        try {
            return ((IGamesService) zzqs()).zzc(i, i2, z);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public void zzc(zzlx.zzb<LoadPlayersResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_Players_LoadPlayersResult, int i, boolean z, boolean z2) throws RemoteException {
        ((IGamesService) zzqs()).zzc(new PlayersLoadedBinderCallback(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_Players_LoadPlayersResult), i, z, z2);
    }

    public void zzc(zzlx.zzb<InitiateMatchResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult, String str) throws RemoteException {
        ((IGamesService) zzqs()).zzl(new TurnBasedMatchInitiatedBinderCallbacks(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult), str);
    }

    public void zzc(zzlx.zzb<LoadXpStreamResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_Players_LoadXpStreamResult, String str, int i) throws RemoteException {
        ((IGamesService) zzqs()).zzb(new PlayerXpStreamLoadedBinderCallback(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_Players_LoadXpStreamResult), str, i);
    }

    public void zzc(zzlx.zzb<InitiateMatchResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult, String str, String str2) throws RemoteException {
        ((IGamesService) zzqs()).zzd(new TurnBasedMatchInitiatedBinderCallbacks(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult), str, str2);
    }

    public void zzc(zzlx.zzb<LoadSnapshotsResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_snapshot_Snapshots_LoadSnapshotsResult, String str, String str2, boolean z) throws RemoteException {
        ((IGamesService) zzqs()).zzc(new SnapshotsLoadedBinderCallbacks(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_snapshot_Snapshots_LoadSnapshotsResult), str, str2, z);
    }

    public void zzc(zzlx.zzb<LeaderboardMetadataResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult, String str, boolean z) throws RemoteException {
        ((IGamesService) zzqs()).zzd(new LeaderboardsLoadedBinderCallback(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_leaderboard_Leaderboards_LeaderboardMetadataResult), str, z);
    }

    public void zzc(zzlx.zzb<LoadAchievementsResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_achievement_Achievements_LoadAchievementsResult, boolean z) throws RemoteException {
        ((IGamesService) zzqs()).zza(new AchievementsLoadedBinderCallback(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_achievement_Achievements_LoadAchievementsResult), z);
    }

    public void zzc(zzlx.zzb<UpdateRequestsResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_request_Requests_UpdateRequestsResult, String[] strArr) throws RemoteException {
        ((IGamesService) zzqs()).zzb(new RequestsUpdatedBinderCallbacks(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_request_Requests_UpdateRequestsResult), strArr);
    }

    public void zzc(zzmn<QuestUpdateListener> com_google_android_gms_internal_zzmn_com_google_android_gms_games_quest_QuestUpdateListener) {
        try {
            ((IGamesService) zzqs()).zzd(new QuestUpdateBinderCallback(com_google_android_gms_internal_zzmn_com_google_android_gms_games_quest_QuestUpdateListener), this.zzaBC);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public int zzd(byte[] bArr, String str) {
        try {
            return ((IGamesService) zzqs()).zzb(bArr, str, null);
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public void zzd(zzlx.zzb<GetTokenResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_Games_GetTokenResult) throws RemoteException {
        ((IGamesService) zzqs()).zzk(new GetAuthTokenBinderCallbacks(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_Games_GetTokenResult));
    }

    public void zzd(zzlx.zzb<LoadPlayersResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_Players_LoadPlayersResult, int i, boolean z, boolean z2) throws RemoteException {
        ((IGamesService) zzqs()).zze(new PlayersLoadedBinderCallback(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_Players_LoadPlayersResult), i, z, z2);
    }

    public void zzd(zzlx.zzb<InitiateMatchResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult, String str) throws RemoteException {
        ((IGamesService) zzqs()).zzm(new TurnBasedMatchInitiatedBinderCallbacks(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult), str);
    }

    public void zzd(zzlx.zzb<LoadXpStreamResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_Players_LoadXpStreamResult, String str, int i) throws RemoteException {
        ((IGamesService) zzqs()).zzc(new PlayerXpStreamLoadedBinderCallback(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_Players_LoadXpStreamResult), str, i);
    }

    public void zzd(zzlx.zzb<InitiateMatchResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult, String str, String str2) throws RemoteException {
        ((IGamesService) zzqs()).zze(new TurnBasedMatchInitiatedBinderCallbacks(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_InitiateMatchResult), str, str2);
    }

    public void zzd(zzlx.zzb<GameMuteStatusChangeResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_Notifications_GameMuteStatusChangeResult, String str, boolean z) throws RemoteException {
        ((IGamesService) zzqs()).zza(new GameMuteStatusChangedBinderCallback(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_Notifications_GameMuteStatusChangeResult), str, z);
    }

    public void zzd(zzlx.zzb<LoadEventsResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_event_Events_LoadEventsResult, boolean z) throws RemoteException {
        this.zzaBv.flush();
        ((IGamesService) zzqs()).zzf(new EventsLoadedBinderCallback(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_event_Events_LoadEventsResult), z);
    }

    public void zzd(zzmn<OnRequestReceivedListener> com_google_android_gms_internal_zzmn_com_google_android_gms_games_request_OnRequestReceivedListener) {
        try {
            ((IGamesService) zzqs()).zzc(new RequestReceivedBinderCallback(com_google_android_gms_internal_zzmn_com_google_android_gms_games_request_OnRequestReceivedListener), this.zzaBC);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zzdt(String str) {
        try {
            ((IGamesService) zzqs()).zzdB(str);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public Intent zzdu(String str) {
        try {
            return ((IGamesService) zzqs()).zzdu(str);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public void zzdv(String str) {
        try {
            ((IGamesService) zzqs()).zza(str, this.zzaBz.zzwC(), this.zzaBz.zzwB());
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zze(zzlx.zzb<LoadGamesResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_GamesMetadata_LoadGamesResult) throws RemoteException {
        ((IGamesService) zzqs()).zzd(new GamesLoadedBinderCallback(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_GamesMetadata_LoadGamesResult));
    }

    public void zze(zzlx.zzb<LeaveMatchResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LeaveMatchResult, String str) throws RemoteException {
        ((IGamesService) zzqs()).zzo(new TurnBasedMatchLeftBinderCallbacks(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LeaveMatchResult), str);
    }

    public void zze(zzlx.zzb<LoadInvitationsResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_multiplayer_Invitations_LoadInvitationsResult, String str, int i) throws RemoteException {
        ((IGamesService) zzqs()).zzb(new InvitationsLoadedBinderCallback(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_multiplayer_Invitations_LoadInvitationsResult), str, i, false);
    }

    public void zze(zzlx.zzb<LoadPlayerStatsResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_stats_Stats_LoadPlayerStatsResult, boolean z) throws RemoteException {
        ((IGamesService) zzqs()).zzi(new PlayerStatsLoadedBinderCallbacks(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_stats_Stats_LoadPlayerStatsResult), z);
    }

    public void zzf(zzlx.zzb<Status> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status) throws RemoteException {
        this.zzaBv.flush();
        ((IGamesService) zzqs()).zza(new SignOutCompleteBinderCallbacks(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status));
    }

    public void zzf(zzlx.zzb<CancelMatchResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_CancelMatchResult, String str) throws RemoteException {
        ((IGamesService) zzqs()).zzn(new TurnBasedMatchCanceledBinderCallbacks(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_CancelMatchResult), str);
    }

    public void zzf(zzlx.zzb<LoadRequestSummariesResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_request_Requests_LoadRequestSummariesResult, String str, int i) throws RemoteException {
        ((IGamesService) zzqs()).zza(new RequestSummariesLoadedBinderCallbacks(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_request_Requests_LoadRequestSummariesResult), str, i);
    }

    public void zzf(zzlx.zzb<LoadSnapshotsResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_snapshot_Snapshots_LoadSnapshotsResult, boolean z) throws RemoteException {
        ((IGamesService) zzqs()).zzd(new SnapshotsLoadedBinderCallbacks(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_snapshot_Snapshots_LoadSnapshotsResult), z);
    }

    public void zzg(zzlx.zzb<ListVideosResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_video_Videos_ListVideosResult) throws RemoteException {
        ((IGamesService) zzqs()).zzl(new ListVideosBinderCallback(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_video_Videos_ListVideosResult));
    }

    public void zzg(zzlx.zzb<LoadMatchResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LoadMatchResult, String str) throws RemoteException {
        ((IGamesService) zzqs()).zzp(new TurnBasedMatchLoadedBinderCallbacks(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_multiplayer_turnbased_TurnBasedMultiplayer_LoadMatchResult), str);
    }

    public void zzg(zzlx.zzb<LoadProfileSettingsResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_Players_LoadProfileSettingsResult, boolean z) throws RemoteException {
        ((IGamesService) zzqs()).zzg(new ProfileSettingsLoadedBinderCallback(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_Players_LoadProfileSettingsResult), z);
    }

    protected String zzgh() {
        return "com.google.android.gms.games.service.START";
    }

    protected String zzgi() {
        return "com.google.android.gms.games.internal.IGamesService";
    }

    public void zzgk(int i) {
        this.zzaBz.setGravity(i);
    }

    public void zzgl(int i) {
        try {
            ((IGamesService) zzqs()).zzgl(i);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zzh(zzlx.zzb<LoadAclResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_internal_game_Acls_LoadAclResult) throws RemoteException {
        ((IGamesService) zzqs()).zzh(new NotifyAclLoadedBinderCallback(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_internal_game_Acls_LoadAclResult));
    }

    public void zzh(zzlx.zzb<AcceptQuestResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_quest_Quests_AcceptQuestResult, String str) throws RemoteException {
        this.zzaBv.flush();
        ((IGamesService) zzqs()).zzu(new QuestAcceptedBinderCallbacks(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_quest_Quests_AcceptQuestResult), str);
    }

    public void zzh(zzlx.zzb<Status> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status, boolean z) throws RemoteException {
        ((IGamesService) zzqs()).zzh(new ProfileSettingsUpdatedBinderCallback(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status), z);
    }

    public void zzi(zzlx.zzb<InboxCountResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_Notifications_InboxCountResult) throws RemoteException {
        ((IGamesService) zzqs()).zzt(new InboxCountsLoadedBinderCallback(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_Notifications_InboxCountResult), null);
    }

    public void zzi(zzlx.zzb<DeleteSnapshotResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_snapshot_Snapshots_DeleteSnapshotResult, String str) throws RemoteException {
        ((IGamesService) zzqs()).zzr(new SnapshotDeletedBinderCallbacks(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_snapshot_Snapshots_DeleteSnapshotResult), str);
    }

    public void zzi(zzlx.zzb<ContactSettingLoadResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_Notifications_ContactSettingLoadResult, boolean z) throws RemoteException {
        ((IGamesService) zzqs()).zze(new ContactSettingsLoadedBinderCallback(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_Notifications_ContactSettingLoadResult), z);
    }

    public void zzj(zzlx.zzb<LoadGameInstancesResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_GamesMetadata_LoadGameInstancesResult, String str) throws RemoteException {
        ((IGamesService) zzqs()).zzf(new GameInstancesLoadedBinderCallback(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_GamesMetadata_LoadGameInstancesResult), str);
    }

    public void zzk(zzlx.zzb<LoadGameSearchSuggestionsResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_GamesMetadata_LoadGameSearchSuggestionsResult, String str) throws RemoteException {
        ((IGamesService) zzqs()).zzq(new GameSearchSuggestionsLoadedBinderCallback(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_GamesMetadata_LoadGameSearchSuggestionsResult), str);
    }

    public Intent zzl(String str, int i, int i2) {
        try {
            return ((IGamesService) zzqs()).zzm(str, i, i2);
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public void zzl(zzlx.zzb<LoadXpForGameCategoriesResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_Players_LoadXpForGameCategoriesResult, String str) throws RemoteException {
        ((IGamesService) zzqs()).zzs(new PlayerXpForGameCategoriesLoadedBinderCallback(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_Players_LoadXpForGameCategoriesResult), str);
    }

    protected Bundle zzlU() {
        String locale = getContext().getResources().getConfiguration().locale.toString();
        Bundle zzuX = this.zzaBD.zzuX();
        zzuX.putString("com.google.android.gms.games.key.gamePackageName", this.zzaBw);
        zzuX.putString("com.google.android.gms.games.key.desiredLocale", locale);
        zzuX.putParcelable("com.google.android.gms.games.key.popupWindowToken", new BinderWrapper(this.zzaBz.zzwC()));
        zzuX.putInt("com.google.android.gms.games.key.API_VERSION", 2);
        zzf zzqq = zzqq();
        if (zzqq.zzqg() != null) {
            zzuX.putBundle("com.google.android.gms.games.key.signInOptions", zzi.zza(zzqq.zzqg(), zzqq.zzqh(), Executors.newSingleThreadExecutor()));
        }
        return zzuX;
    }

    public void zzm(zzlx.zzb<LoadInvitationsResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_multiplayer_Invitations_LoadInvitationsResult, String str) throws RemoteException {
        ((IGamesService) zzqs()).zzk(new InvitationsLoadedBinderCallback(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_multiplayer_Invitations_LoadInvitationsResult), str);
    }

    public boolean zzmn() {
        return true;
    }

    public void zzn(zzlx.zzb<Status> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status, String str) throws RemoteException {
        ((IGamesService) zzqs()).zzj(new NotifyAclUpdatedBinderCallback(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_common_api_Status), str);
    }

    public Bundle zznQ() {
        try {
            Bundle zznQ = ((IGamesService) zzqs()).zznQ();
            if (zznQ == null) {
                return zznQ;
            }
            zznQ.setClassLoader(GamesClientImpl.class.getClassLoader());
            return zznQ;
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public void zzo(View view) {
        this.zzaBz.zzp(view);
    }

    public void zzo(zzlx.zzb<GameMuteStatusLoadResult> com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_Notifications_GameMuteStatusLoadResult, String str) throws RemoteException {
        ((IGamesService) zzqs()).zzi(new GameMuteStatusLoadedBinderCallback(com_google_android_gms_internal_zzlx_zzb_com_google_android_gms_games_Notifications_GameMuteStatusLoadResult), str);
    }

    public void zzp(String str, int i) {
        this.zzaBv.zzp(str, i);
    }

    public void zzq(String str, int i) {
        try {
            ((IGamesService) zzqs()).zzq(str, i);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zzqm() {
        super.zzqm();
        if (this.zzaBA) {
            this.zzaBz.zzwA();
            this.zzaBA = false;
        }
        if (!this.zzaBD.zzaAb) {
            zzvQ();
        }
    }

    public void zzr(String str, int i) {
        try {
            ((IGamesService) zzqs()).zzr(str, i);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zzvQ() {
        try {
            ((IGamesService) zzqs()).zza(new PopupLocationInfoBinderCallbacks(this.zzaBz), this.zzaBC);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public String zzvR() {
        try {
            return ((IGamesService) zzqs()).zzvR();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public String zzvS() {
        if (this.zzaBx != null) {
            return this.zzaBx.getPlayerId();
        }
        try {
            return ((IGamesService) zzqs()).zzvS();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Player zzvT() {
        zzqr();
        synchronized (this) {
            if (this.zzaBx == null) {
                PlayerBuffer playerBuffer;
                try {
                    playerBuffer = new PlayerBuffer(((IGamesService) zzqs()).zzwp());
                    if (playerBuffer.getCount() > 0) {
                        this.zzaBx = (PlayerEntity) playerBuffer.get(0).freeze();
                    }
                    playerBuffer.release();
                } catch (RemoteException e) {
                    zzb(e);
                } catch (Throwable th) {
                    playerBuffer.release();
                }
            }
        }
        return this.zzaBx;
    }

    public Game zzvU() {
        zzqr();
        synchronized (this) {
            if (this.zzaBy == null) {
                GameBuffer gameBuffer;
                try {
                    gameBuffer = new GameBuffer(((IGamesService) zzqs()).zzwr());
                    if (gameBuffer.getCount() > 0) {
                        this.zzaBy = (GameEntity) gameBuffer.get(0).freeze();
                    }
                    gameBuffer.release();
                } catch (RemoteException e) {
                    zzb(e);
                } catch (Throwable th) {
                    gameBuffer.release();
                }
            }
        }
        return this.zzaBy;
    }

    public Intent zzvV() {
        try {
            return ((IGamesService) zzqs()).zzvV();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zzvW() {
        try {
            return ((IGamesService) zzqs()).zzvW();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zzvX() {
        try {
            return ((IGamesService) zzqs()).zzvX();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zzvY() {
        try {
            return ((IGamesService) zzqs()).zzvY();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public void zzvZ() {
        try {
            ((IGamesService) zzqs()).zzG(this.zzaBC);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zzwa() {
        try {
            ((IGamesService) zzqs()).zzH(this.zzaBC);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zzwb() {
        try {
            ((IGamesService) zzqs()).zzJ(this.zzaBC);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public void zzwc() {
        try {
            ((IGamesService) zzqs()).zzI(this.zzaBC);
        } catch (RemoteException e) {
            zzb(e);
        }
    }

    public Intent zzwd() {
        try {
            return ((IGamesService) zzqs()).zzwd();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public Intent zzwe() {
        try {
            return ((IGamesService) zzqs()).zzwe();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public int zzwf() {
        try {
            return ((IGamesService) zzqs()).zzwf();
        } catch (RemoteException e) {
            zzb(e);
            return 4368;
        }
    }

    public String zzwg() {
        try {
            return ((IGamesService) zzqs()).zzwg();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public int zzwh() {
        try {
            return ((IGamesService) zzqs()).zzwh();
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public Intent zzwi() {
        try {
            return ((IGamesService) zzqs()).zzwi();
        } catch (RemoteException e) {
            zzb(e);
            return null;
        }
    }

    public int zzwj() {
        try {
            return ((IGamesService) zzqs()).zzwj();
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public int zzwk() {
        try {
            return ((IGamesService) zzqs()).zzwk();
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public int zzwl() {
        try {
            return ((IGamesService) zzqs()).zzwl();
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public int zzwm() {
        try {
            return ((IGamesService) zzqs()).zzwm();
        } catch (RemoteException e) {
            zzb(e);
            return -1;
        }
    }

    public void zzwn() {
        if (isConnected()) {
            try {
                ((IGamesService) zzqs()).zzwn();
            } catch (RemoteException e) {
                zzb(e);
            }
        }
    }
}
