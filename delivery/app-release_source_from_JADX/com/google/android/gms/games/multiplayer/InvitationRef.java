package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import java.util.ArrayList;

public final class InvitationRef extends zzc implements Invitation {
    private final ArrayList<Participant> zzaGY;
    private final Game zzaGs;
    private final ParticipantRef zzaHb;

    InvitationRef(DataHolder holder, int dataRow, int numChildren) {
        super(holder, dataRow);
        this.zzaGs = new GameRef(holder, dataRow);
        this.zzaGY = new ArrayList(numChildren);
        String string = getString("external_inviter_id");
        Object obj = null;
        for (int i = 0; i < numChildren; i++) {
            ParticipantRef participantRef = new ParticipantRef(this.zzafC, this.zzahw + i);
            if (participantRef.getParticipantId().equals(string)) {
                obj = participantRef;
            }
            this.zzaGY.add(participantRef);
        }
        this.zzaHb = (ParticipantRef) zzx.zzb(obj, (Object) "Must have a valid inviter!");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return InvitationEntity.zza(this, obj);
    }

    public Invitation freeze() {
        return new InvitationEntity(this);
    }

    public int getAvailableAutoMatchSlots() {
        return !getBoolean("has_automatch_criteria") ? 0 : getInteger("automatch_max_players");
    }

    public long getCreationTimestamp() {
        return Math.max(getLong("creation_timestamp"), getLong("last_modified_timestamp"));
    }

    public Game getGame() {
        return this.zzaGs;
    }

    public String getInvitationId() {
        return getString("external_invitation_id");
    }

    public int getInvitationType() {
        return getInteger("type");
    }

    public Participant getInviter() {
        return this.zzaHb;
    }

    public ArrayList<Participant> getParticipants() {
        return this.zzaGY;
    }

    public int getVariant() {
        return getInteger("variant");
    }

    public int hashCode() {
        return InvitationEntity.zza(this);
    }

    public String toString() {
        return InvitationEntity.zzb(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((InvitationEntity) freeze()).writeToParcel(dest, flags);
    }
}