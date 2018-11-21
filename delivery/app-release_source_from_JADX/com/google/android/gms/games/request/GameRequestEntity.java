package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class GameRequestEntity implements SafeParcelable, GameRequest {
    public static final Creator<GameRequestEntity> CREATOR = new GameRequestEntityCreator();
    private final int mVersionCode;
    private final int zzAk;
    private final String zzDX;
    private final int zzZU;
    private final GameEntity zzaGU;
    private final long zzaGV;
    private final byte[] zzaHC;
    private final PlayerEntity zzaHW;
    private final ArrayList<PlayerEntity> zzaHX;
    private final long zzaHY;
    private final Bundle zzaHZ;

    GameRequestEntity(int versionCode, GameEntity game, PlayerEntity sender, byte[] data, String requestId, ArrayList<PlayerEntity> recipients, int type, long creationTimestamp, long expirationTimestamp, Bundle recipientStatuses, int status) {
        this.mVersionCode = versionCode;
        this.zzaGU = game;
        this.zzaHW = sender;
        this.zzaHC = data;
        this.zzDX = requestId;
        this.zzaHX = recipients;
        this.zzZU = type;
        this.zzaGV = creationTimestamp;
        this.zzaHY = expirationTimestamp;
        this.zzaHZ = recipientStatuses;
        this.zzAk = status;
    }

    public GameRequestEntity(GameRequest request) {
        this.mVersionCode = 2;
        this.zzaGU = new GameEntity(request.getGame());
        this.zzaHW = new PlayerEntity(request.getSender());
        this.zzDX = request.getRequestId();
        this.zzZU = request.getType();
        this.zzaGV = request.getCreationTimestamp();
        this.zzaHY = request.getExpirationTimestamp();
        this.zzAk = request.getStatus();
        Object data = request.getData();
        if (data == null) {
            this.zzaHC = null;
        } else {
            this.zzaHC = new byte[data.length];
            System.arraycopy(data, 0, this.zzaHC, 0, data.length);
        }
        List recipients = request.getRecipients();
        int size = recipients.size();
        this.zzaHX = new ArrayList(size);
        this.zzaHZ = new Bundle();
        for (int i = 0; i < size; i++) {
            Player player = (Player) ((Player) recipients.get(i)).freeze();
            String playerId = player.getPlayerId();
            this.zzaHX.add((PlayerEntity) player);
            this.zzaHZ.putInt(playerId, request.getRecipientStatus(playerId));
        }
    }

    static int zza(GameRequest gameRequest) {
        return zzw.hashCode(gameRequest.getGame(), gameRequest.getRecipients(), gameRequest.getRequestId(), gameRequest.getSender(), zzb(gameRequest), Integer.valueOf(gameRequest.getType()), Long.valueOf(gameRequest.getCreationTimestamp()), Long.valueOf(gameRequest.getExpirationTimestamp()));
    }

    static boolean zza(GameRequest gameRequest, Object obj) {
        if (!(obj instanceof GameRequest)) {
            return false;
        }
        if (gameRequest == obj) {
            return true;
        }
        GameRequest gameRequest2 = (GameRequest) obj;
        return zzw.equal(gameRequest2.getGame(), gameRequest.getGame()) && zzw.equal(gameRequest2.getRecipients(), gameRequest.getRecipients()) && zzw.equal(gameRequest2.getRequestId(), gameRequest.getRequestId()) && zzw.equal(gameRequest2.getSender(), gameRequest.getSender()) && Arrays.equals(zzb(gameRequest2), zzb(gameRequest)) && zzw.equal(Integer.valueOf(gameRequest2.getType()), Integer.valueOf(gameRequest.getType())) && zzw.equal(Long.valueOf(gameRequest2.getCreationTimestamp()), Long.valueOf(gameRequest.getCreationTimestamp())) && zzw.equal(Long.valueOf(gameRequest2.getExpirationTimestamp()), Long.valueOf(gameRequest.getExpirationTimestamp()));
    }

    private static int[] zzb(GameRequest gameRequest) {
        List recipients = gameRequest.getRecipients();
        int size = recipients.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = gameRequest.getRecipientStatus(((Player) recipients.get(i)).getPlayerId());
        }
        return iArr;
    }

    static String zzc(GameRequest gameRequest) {
        return zzw.zzx(gameRequest).zzg("Game", gameRequest.getGame()).zzg("Sender", gameRequest.getSender()).zzg("Recipients", gameRequest.getRecipients()).zzg("Data", gameRequest.getData()).zzg("RequestId", gameRequest.getRequestId()).zzg("Type", Integer.valueOf(gameRequest.getType())).zzg("CreationTimestamp", Long.valueOf(gameRequest.getCreationTimestamp())).zzg("ExpirationTimestamp", Long.valueOf(gameRequest.getExpirationTimestamp())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public GameRequest freeze() {
        return this;
    }

    public long getCreationTimestamp() {
        return this.zzaGV;
    }

    public byte[] getData() {
        return this.zzaHC;
    }

    public long getExpirationTimestamp() {
        return this.zzaHY;
    }

    public Game getGame() {
        return this.zzaGU;
    }

    public int getRecipientStatus(String playerId) {
        return this.zzaHZ.getInt(playerId, 0);
    }

    public List<Player> getRecipients() {
        return new ArrayList(this.zzaHX);
    }

    public String getRequestId() {
        return this.zzDX;
    }

    public Player getSender() {
        return this.zzaHW;
    }

    public int getStatus() {
        return this.zzAk;
    }

    public int getType() {
        return this.zzZU;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isConsumed(String playerId) {
        return getRecipientStatus(playerId) == 1;
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzc(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        GameRequestEntityCreator.zza(this, dest, flags);
    }

    public Bundle zzxm() {
        return this.zzaHZ;
    }
}
