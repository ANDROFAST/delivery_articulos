package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.zznn;

public final class LeaderboardScoreEntity implements LeaderboardScore {
    private final Uri zzaGA;
    private final Uri zzaGB;
    private final PlayerEntity zzaGC;
    private final String zzaGD;
    private final String zzaGE;
    private final String zzaGF;
    private final long zzaGu;
    private final String zzaGv;
    private final String zzaGw;
    private final long zzaGx;
    private final long zzaGy;
    private final String zzaGz;

    public LeaderboardScoreEntity(LeaderboardScore score) {
        this.zzaGu = score.getRank();
        this.zzaGv = (String) zzx.zzy(score.getDisplayRank());
        this.zzaGw = (String) zzx.zzy(score.getDisplayScore());
        this.zzaGx = score.getRawScore();
        this.zzaGy = score.getTimestampMillis();
        this.zzaGz = score.getScoreHolderDisplayName();
        this.zzaGA = score.getScoreHolderIconImageUri();
        this.zzaGB = score.getScoreHolderHiResImageUri();
        Player scoreHolder = score.getScoreHolder();
        this.zzaGC = scoreHolder == null ? null : (PlayerEntity) scoreHolder.freeze();
        this.zzaGD = score.getScoreTag();
        this.zzaGE = score.getScoreHolderIconImageUrl();
        this.zzaGF = score.getScoreHolderHiResImageUrl();
    }

    static int zza(LeaderboardScore leaderboardScore) {
        return zzw.hashCode(Long.valueOf(leaderboardScore.getRank()), leaderboardScore.getDisplayRank(), Long.valueOf(leaderboardScore.getRawScore()), leaderboardScore.getDisplayScore(), Long.valueOf(leaderboardScore.getTimestampMillis()), leaderboardScore.getScoreHolderDisplayName(), leaderboardScore.getScoreHolderIconImageUri(), leaderboardScore.getScoreHolderHiResImageUri(), leaderboardScore.getScoreHolder());
    }

    static boolean zza(LeaderboardScore leaderboardScore, Object obj) {
        if (!(obj instanceof LeaderboardScore)) {
            return false;
        }
        if (leaderboardScore == obj) {
            return true;
        }
        LeaderboardScore leaderboardScore2 = (LeaderboardScore) obj;
        return zzw.equal(Long.valueOf(leaderboardScore2.getRank()), Long.valueOf(leaderboardScore.getRank())) && zzw.equal(leaderboardScore2.getDisplayRank(), leaderboardScore.getDisplayRank()) && zzw.equal(Long.valueOf(leaderboardScore2.getRawScore()), Long.valueOf(leaderboardScore.getRawScore())) && zzw.equal(leaderboardScore2.getDisplayScore(), leaderboardScore.getDisplayScore()) && zzw.equal(Long.valueOf(leaderboardScore2.getTimestampMillis()), Long.valueOf(leaderboardScore.getTimestampMillis())) && zzw.equal(leaderboardScore2.getScoreHolderDisplayName(), leaderboardScore.getScoreHolderDisplayName()) && zzw.equal(leaderboardScore2.getScoreHolderIconImageUri(), leaderboardScore.getScoreHolderIconImageUri()) && zzw.equal(leaderboardScore2.getScoreHolderHiResImageUri(), leaderboardScore.getScoreHolderHiResImageUri()) && zzw.equal(leaderboardScore2.getScoreHolder(), leaderboardScore.getScoreHolder()) && zzw.equal(leaderboardScore2.getScoreTag(), leaderboardScore.getScoreTag());
    }

    static String zzb(LeaderboardScore leaderboardScore) {
        return zzw.zzx(leaderboardScore).zzg("Rank", Long.valueOf(leaderboardScore.getRank())).zzg("DisplayRank", leaderboardScore.getDisplayRank()).zzg("Score", Long.valueOf(leaderboardScore.getRawScore())).zzg("DisplayScore", leaderboardScore.getDisplayScore()).zzg("Timestamp", Long.valueOf(leaderboardScore.getTimestampMillis())).zzg("DisplayName", leaderboardScore.getScoreHolderDisplayName()).zzg("IconImageUri", leaderboardScore.getScoreHolderIconImageUri()).zzg("IconImageUrl", leaderboardScore.getScoreHolderIconImageUrl()).zzg("HiResImageUri", leaderboardScore.getScoreHolderHiResImageUri()).zzg("HiResImageUrl", leaderboardScore.getScoreHolderHiResImageUrl()).zzg("Player", leaderboardScore.getScoreHolder() == null ? null : leaderboardScore.getScoreHolder()).zzg("ScoreTag", leaderboardScore.getScoreTag()).toString();
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzxd();
    }

    public String getDisplayRank() {
        return this.zzaGv;
    }

    public void getDisplayRank(CharArrayBuffer dataOut) {
        zznn.zzb(this.zzaGv, dataOut);
    }

    public String getDisplayScore() {
        return this.zzaGw;
    }

    public void getDisplayScore(CharArrayBuffer dataOut) {
        zznn.zzb(this.zzaGw, dataOut);
    }

    public long getRank() {
        return this.zzaGu;
    }

    public long getRawScore() {
        return this.zzaGx;
    }

    public Player getScoreHolder() {
        return this.zzaGC;
    }

    public String getScoreHolderDisplayName() {
        return this.zzaGC == null ? this.zzaGz : this.zzaGC.getDisplayName();
    }

    public void getScoreHolderDisplayName(CharArrayBuffer dataOut) {
        if (this.zzaGC == null) {
            zznn.zzb(this.zzaGz, dataOut);
        } else {
            this.zzaGC.getDisplayName(dataOut);
        }
    }

    public Uri getScoreHolderHiResImageUri() {
        return this.zzaGC == null ? this.zzaGB : this.zzaGC.getHiResImageUri();
    }

    public String getScoreHolderHiResImageUrl() {
        return this.zzaGC == null ? this.zzaGF : this.zzaGC.getHiResImageUrl();
    }

    public Uri getScoreHolderIconImageUri() {
        return this.zzaGC == null ? this.zzaGA : this.zzaGC.getIconImageUri();
    }

    public String getScoreHolderIconImageUrl() {
        return this.zzaGC == null ? this.zzaGE : this.zzaGC.getIconImageUrl();
    }

    public String getScoreTag() {
        return this.zzaGD;
    }

    public long getTimestampMillis() {
        return this.zzaGy;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzb(this);
    }

    public LeaderboardScore zzxd() {
        return this;
    }
}
