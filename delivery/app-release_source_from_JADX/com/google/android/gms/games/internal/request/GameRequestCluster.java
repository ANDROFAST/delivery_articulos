package com.google.android.gms.games.internal.request;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestEntity;
import java.util.ArrayList;
import java.util.List;

public final class GameRequestCluster implements SafeParcelable, GameRequest {
    public static final GameRequestClusterCreator CREATOR = new GameRequestClusterCreator();
    private final int mVersionCode;
    private final ArrayList<GameRequestEntity> zzaGm;

    GameRequestCluster(int versionCode, ArrayList<GameRequestEntity> requestList) {
        this.mVersionCode = versionCode;
        this.zzaGm = requestList;
        zzwK();
    }

    private void zzwK() {
        zzb.zzaa(!this.zzaGm.isEmpty());
        GameRequest gameRequest = (GameRequest) this.zzaGm.get(0);
        int size = this.zzaGm.size();
        for (int i = 1; i < size; i++) {
            GameRequest gameRequest2 = (GameRequest) this.zzaGm.get(i);
            zzb.zza(gameRequest.getType() == gameRequest2.getType(), "All the requests must be of the same type");
            zzb.zza(gameRequest.getSender().equals(gameRequest2.getSender()), "All the requests must be from the same sender");
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GameRequestCluster)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        GameRequestCluster gameRequestCluster = (GameRequestCluster) obj;
        if (gameRequestCluster.zzaGm.size() != this.zzaGm.size()) {
            return false;
        }
        int size = this.zzaGm.size();
        for (int i = 0; i < size; i++) {
            if (!((GameRequest) this.zzaGm.get(i)).equals((GameRequest) gameRequestCluster.zzaGm.get(i))) {
                return false;
            }
        }
        return true;
    }

    public GameRequest freeze() {
        return this;
    }

    public long getCreationTimestamp() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public byte[] getData() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public long getExpirationTimestamp() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public Game getGame() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public int getRecipientStatus(String playerId) {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public /* synthetic */ List getRecipients() {
        return zzwZ();
    }

    public String getRequestId() {
        return ((GameRequestEntity) this.zzaGm.get(0)).getRequestId();
    }

    public Player getSender() {
        return ((GameRequestEntity) this.zzaGm.get(0)).getSender();
    }

    public int getStatus() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public int getType() {
        return ((GameRequestEntity) this.zzaGm.get(0)).getType();
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaGm.toArray());
    }

    public boolean isConsumed(String playerId) {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public boolean isDataValid() {
        return true;
    }

    public void writeToParcel(Parcel dest, int flags) {
        GameRequestClusterCreator.zza(this, dest, flags);
    }

    public ArrayList<GameRequest> zzwY() {
        return new ArrayList(this.zzaGm);
    }

    public ArrayList<Player> zzwZ() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }
}
