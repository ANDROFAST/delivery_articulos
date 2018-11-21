package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.DowngradeableSafeParcel;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import java.util.ArrayList;

public final class InvitationEntity extends GamesDowngradeableSafeParcel implements Invitation {
    public static final Creator<InvitationEntity> CREATOR = new InvitationEntityCreatorCompat();
    private final int mVersionCode;
    private final String zzTr;
    private final GameEntity zzaGU;
    private final long zzaGV;
    private final int zzaGW;
    private final ParticipantEntity zzaGX;
    private final ArrayList<ParticipantEntity> zzaGY;
    private final int zzaGZ;
    private final int zzaHa;

    static final class InvitationEntityCreatorCompat extends InvitationEntityCreator {
        InvitationEntityCreatorCompat() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return zzej(x0);
        }

        public InvitationEntity zzej(Parcel parcel) {
            if (GamesDowngradeableSafeParcel.zzd(DowngradeableSafeParcel.zzqj()) || DowngradeableSafeParcel.zzcz(InvitationEntity.class.getCanonicalName())) {
                return super.zzej(parcel);
            }
            GameEntity gameEntity = (GameEntity) GameEntity.CREATOR.createFromParcel(parcel);
            String readString = parcel.readString();
            long readLong = parcel.readLong();
            int readInt = parcel.readInt();
            ParticipantEntity participantEntity = (ParticipantEntity) ParticipantEntity.CREATOR.createFromParcel(parcel);
            int readInt2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt2);
            for (int i = 0; i < readInt2; i++) {
                arrayList.add(ParticipantEntity.CREATOR.createFromParcel(parcel));
            }
            return new InvitationEntity(2, gameEntity, readString, readLong, readInt, participantEntity, arrayList, -1, 0);
        }
    }

    InvitationEntity(int versionCode, GameEntity game, String invitationId, long creationTimestamp, int invitationType, ParticipantEntity inviter, ArrayList<ParticipantEntity> participants, int variant, int availableAutoMatchSlots) {
        this.mVersionCode = versionCode;
        this.zzaGU = game;
        this.zzTr = invitationId;
        this.zzaGV = creationTimestamp;
        this.zzaGW = invitationType;
        this.zzaGX = inviter;
        this.zzaGY = participants;
        this.zzaGZ = variant;
        this.zzaHa = availableAutoMatchSlots;
    }

    InvitationEntity(Invitation invitation) {
        this.mVersionCode = 2;
        this.zzaGU = new GameEntity(invitation.getGame());
        this.zzTr = invitation.getInvitationId();
        this.zzaGV = invitation.getCreationTimestamp();
        this.zzaGW = invitation.getInvitationType();
        this.zzaGZ = invitation.getVariant();
        this.zzaHa = invitation.getAvailableAutoMatchSlots();
        String participantId = invitation.getInviter().getParticipantId();
        Object obj = null;
        ArrayList participants = invitation.getParticipants();
        int size = participants.size();
        this.zzaGY = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            if (participant.getParticipantId().equals(participantId)) {
                obj = participant;
            }
            this.zzaGY.add((ParticipantEntity) participant.freeze());
        }
        zzx.zzb(obj, (Object) "Must have a valid inviter!");
        this.zzaGX = (ParticipantEntity) obj.freeze();
    }

    static int zza(Invitation invitation) {
        return zzw.hashCode(invitation.getGame(), invitation.getInvitationId(), Long.valueOf(invitation.getCreationTimestamp()), Integer.valueOf(invitation.getInvitationType()), invitation.getInviter(), invitation.getParticipants(), Integer.valueOf(invitation.getVariant()), Integer.valueOf(invitation.getAvailableAutoMatchSlots()));
    }

    static boolean zza(Invitation invitation, Object obj) {
        if (!(obj instanceof Invitation)) {
            return false;
        }
        if (invitation == obj) {
            return true;
        }
        Invitation invitation2 = (Invitation) obj;
        return zzw.equal(invitation2.getGame(), invitation.getGame()) && zzw.equal(invitation2.getInvitationId(), invitation.getInvitationId()) && zzw.equal(Long.valueOf(invitation2.getCreationTimestamp()), Long.valueOf(invitation.getCreationTimestamp())) && zzw.equal(Integer.valueOf(invitation2.getInvitationType()), Integer.valueOf(invitation.getInvitationType())) && zzw.equal(invitation2.getInviter(), invitation.getInviter()) && zzw.equal(invitation2.getParticipants(), invitation.getParticipants()) && zzw.equal(Integer.valueOf(invitation2.getVariant()), Integer.valueOf(invitation.getVariant())) && zzw.equal(Integer.valueOf(invitation2.getAvailableAutoMatchSlots()), Integer.valueOf(invitation.getAvailableAutoMatchSlots()));
    }

    static String zzb(Invitation invitation) {
        return zzw.zzx(invitation).zzg("Game", invitation.getGame()).zzg("InvitationId", invitation.getInvitationId()).zzg("CreationTimestamp", Long.valueOf(invitation.getCreationTimestamp())).zzg("InvitationType", Integer.valueOf(invitation.getInvitationType())).zzg("Inviter", invitation.getInviter()).zzg("Participants", invitation.getParticipants()).zzg("Variant", Integer.valueOf(invitation.getVariant())).zzg("AvailableAutoMatchSlots", Integer.valueOf(invitation.getAvailableAutoMatchSlots())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public Invitation freeze() {
        return this;
    }

    public int getAvailableAutoMatchSlots() {
        return this.zzaHa;
    }

    public long getCreationTimestamp() {
        return this.zzaGV;
    }

    public Game getGame() {
        return this.zzaGU;
    }

    public String getInvitationId() {
        return this.zzTr;
    }

    public int getInvitationType() {
        return this.zzaGW;
    }

    public Participant getInviter() {
        return this.zzaGX;
    }

    public ArrayList<Participant> getParticipants() {
        return new ArrayList(this.zzaGY);
    }

    public int getVariant() {
        return this.zzaGZ;
    }

    public int getVersionCode() {
        return this.mVersionCode;
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

    public void writeToParcel(Parcel dest, int flags) {
        if (zzqk()) {
            this.zzaGU.writeToParcel(dest, flags);
            dest.writeString(this.zzTr);
            dest.writeLong(this.zzaGV);
            dest.writeInt(this.zzaGW);
            this.zzaGX.writeToParcel(dest, flags);
            int size = this.zzaGY.size();
            dest.writeInt(size);
            for (int i = 0; i < size; i++) {
                ((ParticipantEntity) this.zzaGY.get(i)).writeToParcel(dest, flags);
            }
            return;
        }
        InvitationEntityCreator.zza(this, dest, flags);
    }
}
