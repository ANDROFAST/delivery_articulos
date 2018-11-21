package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.internal.constants.TimeSpan;
import java.util.HashMap;

public final class ScoreSubmissionData {
    private static final String[] zzaGn = new String[]{"leaderboardId", "playerId", "timeSpan", "hasResult", "rawScore", "formattedScore", "newBest", "scoreTag"};
    private HashMap<Integer, Result> zzaGT = new HashMap();
    private String zzaGp;
    private String zzabq;
    private int zzabx;

    public static final class Result {
        public final String formattedScore;
        public final boolean newBest;
        public final long rawScore;
        public final String scoreTag;

        public Result(long rawScore, String formattedScore, String scoreTag, boolean newBest) {
            this.rawScore = rawScore;
            this.formattedScore = formattedScore;
            this.scoreTag = scoreTag;
            this.newBest = newBest;
        }

        public String toString() {
            return zzw.zzx(this).zzg("RawScore", Long.valueOf(this.rawScore)).zzg("FormattedScore", this.formattedScore).zzg("ScoreTag", this.scoreTag).zzg("NewBest", Boolean.valueOf(this.newBest)).toString();
        }
    }

    public ScoreSubmissionData(DataHolder dataHolder) {
        this.zzabx = dataHolder.getStatusCode();
        int count = dataHolder.getCount();
        zzx.zzab(count == 3);
        for (int i = 0; i < count; i++) {
            int zzbI = dataHolder.zzbI(i);
            if (i == 0) {
                this.zzaGp = dataHolder.zzd("leaderboardId", i, zzbI);
                this.zzabq = dataHolder.zzd("playerId", i, zzbI);
            }
            if (dataHolder.zze("hasResult", i, zzbI)) {
                zza(new Result(dataHolder.zzb("rawScore", i, zzbI), dataHolder.zzd("formattedScore", i, zzbI), dataHolder.zzd("scoreTag", i, zzbI), dataHolder.zze("newBest", i, zzbI)), dataHolder.zzc("timeSpan", i, zzbI));
            }
        }
    }

    private void zza(Result result, int i) {
        this.zzaGT.put(Integer.valueOf(i), result);
    }

    public String getLeaderboardId() {
        return this.zzaGp;
    }

    public String getPlayerId() {
        return this.zzabq;
    }

    public Result getScoreResult(int timeSpan) {
        return (Result) this.zzaGT.get(Integer.valueOf(timeSpan));
    }

    public String toString() {
        zza zzg = zzw.zzx(this).zzg("PlayerId", this.zzabq).zzg("StatusCode", Integer.valueOf(this.zzabx));
        for (int i = 0; i < 3; i++) {
            Result result = (Result) this.zzaGT.get(Integer.valueOf(i));
            zzg.zzg("TimesSpan", TimeSpan.zzgo(i));
            zzg.zzg("Result", result == null ? "null" : result.toString());
        }
        return zzg.toString();
    }
}
