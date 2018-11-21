package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig.Builder;

public final class TurnBasedMatchConfigImpl extends TurnBasedMatchConfig {
    private final int zzaGZ;
    private final Bundle zzaHp;
    private final String[] zzaHq;
    private final int zzaHy;

    TurnBasedMatchConfigImpl(Builder builder) {
        this.zzaGZ = builder.zzaGZ;
        this.zzaHy = builder.zzaHy;
        this.zzaHp = builder.zzaHp;
        this.zzaHq = (String[]) builder.zzaHo.toArray(new String[builder.zzaHo.size()]);
    }

    public Bundle getAutoMatchCriteria() {
        return this.zzaHp;
    }

    public String[] getInvitedPlayerIds() {
        return this.zzaHq;
    }

    public int getVariant() {
        return this.zzaGZ;
    }

    public int zzxi() {
        return this.zzaHy;
    }
}
