package com.google.android.gms.games.request;

import com.google.android.gms.common.data.AbstractDataBuffer;

public final class GameRequestSummaryBuffer extends AbstractDataBuffer<GameRequestSummary> {
    public /* synthetic */ Object get(int x0) {
        return zzgI(x0);
    }

    public GameRequestSummary zzgI(int i) {
        return new GameRequestSummaryRef(this.zzafC, i);
    }
}
