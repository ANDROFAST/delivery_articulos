package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

public final class LeaderboardScoreRef extends zzc implements LeaderboardScore {
    private final PlayerRef zzaGG;

    LeaderboardScoreRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
        this.zzaGG = new PlayerRef(holder, dataRow);
    }

    public boolean equals(Object obj) {
        return LeaderboardScoreEntity.zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzxd();
    }

    public String getDisplayRank() {
        return getString("display_rank");
    }

    public void getDisplayRank(CharArrayBuffer dataOut) {
        zza("display_rank", dataOut);
    }

    public String getDisplayScore() {
        return getString("display_score");
    }

    public void getDisplayScore(CharArrayBuffer dataOut) {
        zza("display_score", dataOut);
    }

    public long getRank() {
        return getLong("rank");
    }

    public long getRawScore() {
        return getLong("raw_score");
    }

    public Player getScoreHolder() {
        return zzcv("external_player_id") ? null : this.zzaGG;
    }

    public String getScoreHolderDisplayName() {
        return zzcv("external_player_id") ? getString("default_display_name") : this.zzaGG.getDisplayName();
    }

    public void getScoreHolderDisplayName(CharArrayBuffer dataOut) {
        if (zzcv("external_player_id")) {
            zza("default_display_name", dataOut);
        } else {
            this.zzaGG.getDisplayName(dataOut);
        }
    }

    public Uri getScoreHolderHiResImageUri() {
        return zzcv("external_player_id") ? null : this.zzaGG.getHiResImageUri();
    }

    public String getScoreHolderHiResImageUrl() {
        return zzcv("external_player_id") ? null : this.zzaGG.getHiResImageUrl();
    }

    public Uri getScoreHolderIconImageUri() {
        return zzcv("external_player_id") ? zzcu("default_display_image_uri") : this.zzaGG.getIconImageUri();
    }

    public String getScoreHolderIconImageUrl() {
        return zzcv("external_player_id") ? getString("default_display_image_url") : this.zzaGG.getIconImageUrl();
    }

    public String getScoreTag() {
        return getString("score_tag");
    }

    public long getTimestampMillis() {
        return getLong("achieved_timestamp");
    }

    public int hashCode() {
        return LeaderboardScoreEntity.zza(this);
    }

    public String toString() {
        return LeaderboardScoreEntity.zzb(this);
    }

    public LeaderboardScore zzxd() {
        return new LeaderboardScoreEntity(this);
    }
}
