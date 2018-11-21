package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig.Builder;

public final class RoomConfigImpl extends RoomConfig {
    private final String zzTr;
    private final int zzaGZ;
    private final RoomUpdateListener zzaHk;
    private final RoomStatusUpdateListener zzaHl;
    private final RealTimeMessageReceivedListener zzaHm;
    private final Bundle zzaHp;
    private final String[] zzaHq;

    RoomConfigImpl(Builder builder) {
        this.zzaHk = builder.zzaHk;
        this.zzaHl = builder.zzaHl;
        this.zzaHm = builder.zzaHm;
        this.zzTr = builder.zzaHn;
        this.zzaGZ = builder.zzaGZ;
        this.zzaHp = builder.zzaHp;
        this.zzaHq = (String[]) builder.zzaHo.toArray(new String[builder.zzaHo.size()]);
        zzx.zzb(this.zzaHm, (Object) "Must specify a message listener");
    }

    public Bundle getAutoMatchCriteria() {
        return this.zzaHp;
    }

    public String getInvitationId() {
        return this.zzTr;
    }

    public String[] getInvitedPlayerIds() {
        return this.zzaHq;
    }

    public RealTimeMessageReceivedListener getMessageReceivedListener() {
        return this.zzaHm;
    }

    public RoomStatusUpdateListener getRoomStatusUpdateListener() {
        return this.zzaHl;
    }

    public RoomUpdateListener getRoomUpdateListener() {
        return this.zzaHk;
    }

    public int getVariant() {
        return this.zzaGZ;
    }
}
