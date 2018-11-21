package com.google.android.gms.games.internal.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationEntity;
import com.google.android.gms.games.multiplayer.Participant;
import java.util.ArrayList;

public final class ZInvitationCluster implements SafeParcelable, Invitation {
    public static final InvitationClusterCreator CREATOR = new InvitationClusterCreator();
    private final int mVersionCode;
    private final ArrayList<InvitationEntity> zzaFB;

    ZInvitationCluster(int versionCode, ArrayList<InvitationEntity> invitationList) {
        this.mVersionCode = versionCode;
        this.zzaFB = invitationList;
        zzwK();
    }

    private void zzwK() {
        zzb.zzaa(!this.zzaFB.isEmpty());
        Invitation invitation = (Invitation) this.zzaFB.get(0);
        int size = this.zzaFB.size();
        for (int i = 1; i < size; i++) {
            zzb.zza(invitation.getInviter().equals(((Invitation) this.zzaFB.get(i)).getInviter()), "All the invitations must be from the same inviter");
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ZInvitationCluster)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ZInvitationCluster zInvitationCluster = (ZInvitationCluster) obj;
        if (zInvitationCluster.zzaFB.size() != this.zzaFB.size()) {
            return false;
        }
        int size = this.zzaFB.size();
        for (int i = 0; i < size; i++) {
            if (!((Invitation) this.zzaFB.get(i)).equals((Invitation) zInvitationCluster.zzaFB.get(i))) {
                return false;
            }
        }
        return true;
    }

    public Invitation freeze() {
        return this;
    }

    public int getAvailableAutoMatchSlots() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public long getCreationTimestamp() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public Game getGame() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public String getInvitationId() {
        return ((InvitationEntity) this.zzaFB.get(0)).getInvitationId();
    }

    public int getInvitationType() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public Participant getInviter() {
        return ((InvitationEntity) this.zzaFB.get(0)).getInviter();
    }

    public ArrayList<Participant> getParticipants() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public int getVariant() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaFB.toArray());
    }

    public boolean isDataValid() {
        return true;
    }

    public void writeToParcel(Parcel dest, int flags) {
        InvitationClusterCreator.zza(this, dest, flags);
    }

    public ArrayList<Invitation> zzwL() {
        return new ArrayList(this.zzaFB);
    }
}
