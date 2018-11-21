package com.google.android.gms.games.request;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;
import java.util.ArrayList;
import java.util.List;

public final class GameRequestRef extends zzc implements GameRequest {
    private final int zzaBl;

    public GameRequestRef(DataHolder holder, int dataRow, int numChildren) {
        super(holder, dataRow);
        this.zzaBl = numChildren;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return GameRequestEntity.zza(this, obj);
    }

    public GameRequest freeze() {
        return new GameRequestEntity(this);
    }

    public long getCreationTimestamp() {
        return getLong("creation_timestamp");
    }

    public byte[] getData() {
        return getByteArray("data");
    }

    public long getExpirationTimestamp() {
        return getLong("expiration_timestamp");
    }

    public Game getGame() {
        return new GameRef(this.zzafC, this.zzahw);
    }

    public int getRecipientStatus(String playerId) {
        for (int i = this.zzahw; i < this.zzahw + this.zzaBl; i++) {
            int zzbI = this.zzafC.zzbI(i);
            if (this.zzafC.zzd("recipient_external_player_id", i, zzbI).equals(playerId)) {
                return this.zzafC.zzc("recipient_status", i, zzbI);
            }
        }
        return -1;
    }

    public List<Player> getRecipients() {
        List arrayList = new ArrayList(this.zzaBl);
        for (int i = 0; i < this.zzaBl; i++) {
            arrayList.add(new PlayerRef(this.zzafC, this.zzahw + i, "recipient_"));
        }
        return arrayList;
    }

    public String getRequestId() {
        return getString("external_request_id");
    }

    public Player getSender() {
        return new PlayerRef(this.zzafC, zzpK(), "sender_");
    }

    public int getStatus() {
        return getInteger("status");
    }

    public int getType() {
        return getInteger("type");
    }

    public int hashCode() {
        return GameRequestEntity.zza(this);
    }

    public boolean isConsumed(String playerId) {
        return getRecipientStatus(playerId) == 1;
    }

    public String toString() {
        return GameRequestEntity.zzc(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((GameRequestEntity) freeze()).writeToParcel(dest, flags);
    }
}
