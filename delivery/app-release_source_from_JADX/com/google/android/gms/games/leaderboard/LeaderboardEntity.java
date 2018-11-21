package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.internal.zznn;
import java.util.ArrayList;

public final class LeaderboardEntity implements Leaderboard {
    private final String zzVu;
    private final String zzaGp;
    private final int zzaGq;
    private final ArrayList<LeaderboardVariantEntity> zzaGr;
    private final Game zzaGs;
    private final Uri zzazC;
    private final String zzazN;

    public LeaderboardEntity(Leaderboard leaderboard) {
        this.zzaGp = leaderboard.getLeaderboardId();
        this.zzVu = leaderboard.getDisplayName();
        this.zzazC = leaderboard.getIconImageUri();
        this.zzazN = leaderboard.getIconImageUrl();
        this.zzaGq = leaderboard.getScoreOrder();
        Game game = leaderboard.getGame();
        this.zzaGs = game == null ? null : new GameEntity(game);
        ArrayList variants = leaderboard.getVariants();
        int size = variants.size();
        this.zzaGr = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.zzaGr.add((LeaderboardVariantEntity) ((LeaderboardVariant) variants.get(i)).freeze());
        }
    }

    static int zza(Leaderboard leaderboard) {
        return zzw.hashCode(leaderboard.getLeaderboardId(), leaderboard.getDisplayName(), leaderboard.getIconImageUri(), Integer.valueOf(leaderboard.getScoreOrder()), leaderboard.getVariants());
    }

    static boolean zza(Leaderboard leaderboard, Object obj) {
        if (!(obj instanceof Leaderboard)) {
            return false;
        }
        if (leaderboard == obj) {
            return true;
        }
        Leaderboard leaderboard2 = (Leaderboard) obj;
        return zzw.equal(leaderboard2.getLeaderboardId(), leaderboard.getLeaderboardId()) && zzw.equal(leaderboard2.getDisplayName(), leaderboard.getDisplayName()) && zzw.equal(leaderboard2.getIconImageUri(), leaderboard.getIconImageUri()) && zzw.equal(Integer.valueOf(leaderboard2.getScoreOrder()), Integer.valueOf(leaderboard.getScoreOrder())) && zzw.equal(leaderboard2.getVariants(), leaderboard.getVariants());
    }

    static String zzb(Leaderboard leaderboard) {
        return zzw.zzx(leaderboard).zzg("LeaderboardId", leaderboard.getLeaderboardId()).zzg("DisplayName", leaderboard.getDisplayName()).zzg("IconImageUri", leaderboard.getIconImageUri()).zzg("IconImageUrl", leaderboard.getIconImageUrl()).zzg("ScoreOrder", Integer.valueOf(leaderboard.getScoreOrder())).zzg("Variants", leaderboard.getVariants()).toString();
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzxb();
    }

    public String getDisplayName() {
        return this.zzVu;
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        zznn.zzb(this.zzVu, dataOut);
    }

    public Game getGame() {
        return this.zzaGs;
    }

    public Uri getIconImageUri() {
        return this.zzazC;
    }

    public String getIconImageUrl() {
        return this.zzazN;
    }

    public String getLeaderboardId() {
        return this.zzaGp;
    }

    public int getScoreOrder() {
        return this.zzaGq;
    }

    public ArrayList<LeaderboardVariant> getVariants() {
        return new ArrayList(this.zzaGr);
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

    public Leaderboard zzxb() {
        return this;
    }
}
