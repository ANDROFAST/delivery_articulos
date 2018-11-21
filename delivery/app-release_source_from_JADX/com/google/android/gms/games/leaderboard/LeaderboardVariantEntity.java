package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.internal.constants.LeaderboardCollection;
import com.google.android.gms.games.internal.constants.TimeSpan;

public final class LeaderboardVariantEntity implements LeaderboardVariant {
    private final int zzaGH;
    private final int zzaGI;
    private final boolean zzaGJ;
    private final long zzaGK;
    private final String zzaGL;
    private final long zzaGM;
    private final String zzaGN;
    private final String zzaGO;
    private final long zzaGP;
    private final String zzaGQ;
    private final String zzaGR;
    private final String zzaGS;

    public LeaderboardVariantEntity(LeaderboardVariant variant) {
        this.zzaGH = variant.getTimeSpan();
        this.zzaGI = variant.getCollection();
        this.zzaGJ = variant.hasPlayerInfo();
        this.zzaGK = variant.getRawPlayerScore();
        this.zzaGL = variant.getDisplayPlayerScore();
        this.zzaGM = variant.getPlayerRank();
        this.zzaGN = variant.getDisplayPlayerRank();
        this.zzaGO = variant.getPlayerScoreTag();
        this.zzaGP = variant.getNumScores();
        this.zzaGQ = variant.zzxe();
        this.zzaGR = variant.zzxf();
        this.zzaGS = variant.zzxg();
    }

    static int zza(LeaderboardVariant leaderboardVariant) {
        return zzw.hashCode(Integer.valueOf(leaderboardVariant.getTimeSpan()), Integer.valueOf(leaderboardVariant.getCollection()), Boolean.valueOf(leaderboardVariant.hasPlayerInfo()), Long.valueOf(leaderboardVariant.getRawPlayerScore()), leaderboardVariant.getDisplayPlayerScore(), Long.valueOf(leaderboardVariant.getPlayerRank()), leaderboardVariant.getDisplayPlayerRank(), Long.valueOf(leaderboardVariant.getNumScores()), leaderboardVariant.zzxe(), leaderboardVariant.zzxg(), leaderboardVariant.zzxf());
    }

    static boolean zza(LeaderboardVariant leaderboardVariant, Object obj) {
        if (!(obj instanceof LeaderboardVariant)) {
            return false;
        }
        if (leaderboardVariant == obj) {
            return true;
        }
        LeaderboardVariant leaderboardVariant2 = (LeaderboardVariant) obj;
        return zzw.equal(Integer.valueOf(leaderboardVariant2.getTimeSpan()), Integer.valueOf(leaderboardVariant.getTimeSpan())) && zzw.equal(Integer.valueOf(leaderboardVariant2.getCollection()), Integer.valueOf(leaderboardVariant.getCollection())) && zzw.equal(Boolean.valueOf(leaderboardVariant2.hasPlayerInfo()), Boolean.valueOf(leaderboardVariant.hasPlayerInfo())) && zzw.equal(Long.valueOf(leaderboardVariant2.getRawPlayerScore()), Long.valueOf(leaderboardVariant.getRawPlayerScore())) && zzw.equal(leaderboardVariant2.getDisplayPlayerScore(), leaderboardVariant.getDisplayPlayerScore()) && zzw.equal(Long.valueOf(leaderboardVariant2.getPlayerRank()), Long.valueOf(leaderboardVariant.getPlayerRank())) && zzw.equal(leaderboardVariant2.getDisplayPlayerRank(), leaderboardVariant.getDisplayPlayerRank()) && zzw.equal(Long.valueOf(leaderboardVariant2.getNumScores()), Long.valueOf(leaderboardVariant.getNumScores())) && zzw.equal(leaderboardVariant2.zzxe(), leaderboardVariant.zzxe()) && zzw.equal(leaderboardVariant2.zzxg(), leaderboardVariant.zzxg()) && zzw.equal(leaderboardVariant2.zzxf(), leaderboardVariant.zzxf());
    }

    static String zzb(LeaderboardVariant leaderboardVariant) {
        return zzw.zzx(leaderboardVariant).zzg("TimeSpan", TimeSpan.zzgo(leaderboardVariant.getTimeSpan())).zzg("Collection", LeaderboardCollection.zzgo(leaderboardVariant.getCollection())).zzg("RawPlayerScore", leaderboardVariant.hasPlayerInfo() ? Long.valueOf(leaderboardVariant.getRawPlayerScore()) : "none").zzg("DisplayPlayerScore", leaderboardVariant.hasPlayerInfo() ? leaderboardVariant.getDisplayPlayerScore() : "none").zzg("PlayerRank", leaderboardVariant.hasPlayerInfo() ? Long.valueOf(leaderboardVariant.getPlayerRank()) : "none").zzg("DisplayPlayerRank", leaderboardVariant.hasPlayerInfo() ? leaderboardVariant.getDisplayPlayerRank() : "none").zzg("NumScores", Long.valueOf(leaderboardVariant.getNumScores())).zzg("TopPageNextToken", leaderboardVariant.zzxe()).zzg("WindowPageNextToken", leaderboardVariant.zzxg()).zzg("WindowPagePrevToken", leaderboardVariant.zzxf()).toString();
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzxh();
    }

    public int getCollection() {
        return this.zzaGI;
    }

    public String getDisplayPlayerRank() {
        return this.zzaGN;
    }

    public String getDisplayPlayerScore() {
        return this.zzaGL;
    }

    public long getNumScores() {
        return this.zzaGP;
    }

    public long getPlayerRank() {
        return this.zzaGM;
    }

    public String getPlayerScoreTag() {
        return this.zzaGO;
    }

    public long getRawPlayerScore() {
        return this.zzaGK;
    }

    public int getTimeSpan() {
        return this.zzaGH;
    }

    public boolean hasPlayerInfo() {
        return this.zzaGJ;
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

    public String zzxe() {
        return this.zzaGQ;
    }

    public String zzxf() {
        return this.zzaGR;
    }

    public String zzxg() {
        return this.zzaGS;
    }

    public LeaderboardVariant zzxh() {
        return this;
    }
}
