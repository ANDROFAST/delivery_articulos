package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.constants.TurnBasedMatchTurnStatus;
import com.google.android.gms.games.multiplayer.InvitationBuffer;

public final class LoadMatchesResponse {
    private final InvitationBuffer zzaHu;
    private final TurnBasedMatchBuffer zzaHv;
    private final TurnBasedMatchBuffer zzaHw;
    private final TurnBasedMatchBuffer zzaHx;

    public LoadMatchesResponse(Bundle matchData) {
        DataHolder zza = zza(matchData, 0);
        if (zza != null) {
            this.zzaHu = new InvitationBuffer(zza);
        } else {
            this.zzaHu = null;
        }
        zza = zza(matchData, 1);
        if (zza != null) {
            this.zzaHv = new TurnBasedMatchBuffer(zza);
        } else {
            this.zzaHv = null;
        }
        zza = zza(matchData, 2);
        if (zza != null) {
            this.zzaHw = new TurnBasedMatchBuffer(zza);
        } else {
            this.zzaHw = null;
        }
        zza = zza(matchData, 3);
        if (zza != null) {
            this.zzaHx = new TurnBasedMatchBuffer(zza);
        } else {
            this.zzaHx = null;
        }
    }

    private static DataHolder zza(Bundle bundle, int i) {
        String zzgo = TurnBasedMatchTurnStatus.zzgo(i);
        return !bundle.containsKey(zzgo) ? null : (DataHolder) bundle.getParcelable(zzgo);
    }

    @Deprecated
    public void close() {
        release();
    }

    public TurnBasedMatchBuffer getCompletedMatches() {
        return this.zzaHx;
    }

    public InvitationBuffer getInvitations() {
        return this.zzaHu;
    }

    public TurnBasedMatchBuffer getMyTurnMatches() {
        return this.zzaHv;
    }

    public TurnBasedMatchBuffer getTheirTurnMatches() {
        return this.zzaHw;
    }

    public boolean hasData() {
        return (this.zzaHu == null || this.zzaHu.getCount() <= 0) ? (this.zzaHv == null || this.zzaHv.getCount() <= 0) ? (this.zzaHw == null || this.zzaHw.getCount() <= 0) ? this.zzaHx != null && this.zzaHx.getCount() > 0 : true : true : true;
    }

    public void release() {
        if (this.zzaHu != null) {
            this.zzaHu.release();
        }
        if (this.zzaHv != null) {
            this.zzaHv.release();
        }
        if (this.zzaHw != null) {
            this.zzaHw.release();
        }
        if (this.zzaHx != null) {
            this.zzaHx.release();
        }
    }
}
