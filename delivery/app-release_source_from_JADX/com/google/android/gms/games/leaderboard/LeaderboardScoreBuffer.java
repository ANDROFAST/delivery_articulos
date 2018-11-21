package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class LeaderboardScoreBuffer extends AbstractDataBuffer<LeaderboardScore> {
    private final LeaderboardScoreBufferHeader zzaGt;

    public LeaderboardScoreBuffer(DataHolder dataHolder) {
        super(dataHolder);
        this.zzaGt = new LeaderboardScoreBufferHeader(dataHolder.zzpH());
    }

    public LeaderboardScore get(int position) {
        return new LeaderboardScoreRef(this.zzafC, position);
    }

    public LeaderboardScoreBufferHeader zzxc() {
        return this.zzaGt;
    }
}
