package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.DowngradeableSafeParcel;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.zznn;

public final class ParticipantEntity extends GamesDowngradeableSafeParcel implements Participant {
    public static final Creator<ParticipantEntity> CREATOR = new ParticipantEntityCreatorCompat();
    private final int mVersionCode;
    private final int zzAk;
    private final String zzVu;
    private final int zzYv;
    private final PlayerEntity zzaAL;
    private final String zzaBt;
    private final String zzaCu;
    private final boolean zzaHc;
    private final ParticipantResult zzaHd;
    private final Uri zzazC;
    private final Uri zzazD;
    private final String zzazN;
    private final String zzazO;

    static final class ParticipantEntityCreatorCompat extends ParticipantEntityCreator {
        ParticipantEntityCreatorCompat() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return zzek(x0);
        }

        public ParticipantEntity zzek(Parcel parcel) {
            Object obj = 1;
            if (GamesDowngradeableSafeParcel.zzd(DowngradeableSafeParcel.zzqj()) || DowngradeableSafeParcel.zzcz(ParticipantEntity.class.getCanonicalName())) {
                return super.zzek(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            Uri parse = readString3 == null ? null : Uri.parse(readString3);
            String readString4 = parcel.readString();
            Uri parse2 = readString4 == null ? null : Uri.parse(readString4);
            int readInt = parcel.readInt();
            String readString5 = parcel.readString();
            boolean z = parcel.readInt() > 0;
            if (parcel.readInt() <= 0) {
                obj = null;
            }
            return new ParticipantEntity(3, readString, readString2, parse, parse2, readInt, readString5, z, obj != null ? (PlayerEntity) PlayerEntity.CREATOR.createFromParcel(parcel) : null, 7, null, null, null);
        }
    }

    ParticipantEntity(int versionCode, String participantId, String displayName, Uri iconImageUri, Uri hiResImageUri, int status, String clientAddress, boolean connectedToRoom, PlayerEntity player, int capabilities, ParticipantResult result, String iconImageUrl, String hiResImageUrl) {
        this.mVersionCode = versionCode;
        this.zzaCu = participantId;
        this.zzVu = displayName;
        this.zzazC = iconImageUri;
        this.zzazD = hiResImageUri;
        this.zzAk = status;
        this.zzaBt = clientAddress;
        this.zzaHc = connectedToRoom;
        this.zzaAL = player;
        this.zzYv = capabilities;
        this.zzaHd = result;
        this.zzazN = iconImageUrl;
        this.zzazO = hiResImageUrl;
    }

    public ParticipantEntity(Participant participant) {
        this.mVersionCode = 3;
        this.zzaCu = participant.getParticipantId();
        this.zzVu = participant.getDisplayName();
        this.zzazC = participant.getIconImageUri();
        this.zzazD = participant.getHiResImageUri();
        this.zzAk = participant.getStatus();
        this.zzaBt = participant.zzvN();
        this.zzaHc = participant.isConnectedToRoom();
        Player player = participant.getPlayer();
        this.zzaAL = player == null ? null : new PlayerEntity(player);
        this.zzYv = participant.getCapabilities();
        this.zzaHd = participant.getResult();
        this.zzazN = participant.getIconImageUrl();
        this.zzazO = participant.getHiResImageUrl();
    }

    static int zza(Participant participant) {
        return zzw.hashCode(participant.getPlayer(), Integer.valueOf(participant.getStatus()), participant.zzvN(), Boolean.valueOf(participant.isConnectedToRoom()), participant.getDisplayName(), participant.getIconImageUri(), participant.getHiResImageUri(), Integer.valueOf(participant.getCapabilities()), participant.getResult(), participant.getParticipantId());
    }

    static boolean zza(Participant participant, Object obj) {
        if (!(obj instanceof Participant)) {
            return false;
        }
        if (participant == obj) {
            return true;
        }
        Participant participant2 = (Participant) obj;
        return zzw.equal(participant2.getPlayer(), participant.getPlayer()) && zzw.equal(Integer.valueOf(participant2.getStatus()), Integer.valueOf(participant.getStatus())) && zzw.equal(participant2.zzvN(), participant.zzvN()) && zzw.equal(Boolean.valueOf(participant2.isConnectedToRoom()), Boolean.valueOf(participant.isConnectedToRoom())) && zzw.equal(participant2.getDisplayName(), participant.getDisplayName()) && zzw.equal(participant2.getIconImageUri(), participant.getIconImageUri()) && zzw.equal(participant2.getHiResImageUri(), participant.getHiResImageUri()) && zzw.equal(Integer.valueOf(participant2.getCapabilities()), Integer.valueOf(participant.getCapabilities())) && zzw.equal(participant2.getResult(), participant.getResult()) && zzw.equal(participant2.getParticipantId(), participant.getParticipantId());
    }

    static String zzb(Participant participant) {
        return zzw.zzx(participant).zzg("ParticipantId", participant.getParticipantId()).zzg("Player", participant.getPlayer()).zzg("Status", Integer.valueOf(participant.getStatus())).zzg("ClientAddress", participant.zzvN()).zzg("ConnectedToRoom", Boolean.valueOf(participant.isConnectedToRoom())).zzg("DisplayName", participant.getDisplayName()).zzg("IconImage", participant.getIconImageUri()).zzg("IconImageUrl", participant.getIconImageUrl()).zzg("HiResImage", participant.getHiResImageUri()).zzg("HiResImageUrl", participant.getHiResImageUrl()).zzg("Capabilities", Integer.valueOf(participant.getCapabilities())).zzg("Result", participant.getResult()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public Participant freeze() {
        return this;
    }

    public int getCapabilities() {
        return this.zzYv;
    }

    public String getDisplayName() {
        return this.zzaAL == null ? this.zzVu : this.zzaAL.getDisplayName();
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        if (this.zzaAL == null) {
            zznn.zzb(this.zzVu, dataOut);
        } else {
            this.zzaAL.getDisplayName(dataOut);
        }
    }

    public Uri getHiResImageUri() {
        return this.zzaAL == null ? this.zzazD : this.zzaAL.getHiResImageUri();
    }

    public String getHiResImageUrl() {
        return this.zzaAL == null ? this.zzazO : this.zzaAL.getHiResImageUrl();
    }

    public Uri getIconImageUri() {
        return this.zzaAL == null ? this.zzazC : this.zzaAL.getIconImageUri();
    }

    public String getIconImageUrl() {
        return this.zzaAL == null ? this.zzazN : this.zzaAL.getIconImageUrl();
    }

    public String getParticipantId() {
        return this.zzaCu;
    }

    public Player getPlayer() {
        return this.zzaAL;
    }

    public ParticipantResult getResult() {
        return this.zzaHd;
    }

    public int getStatus() {
        return this.zzAk;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isConnectedToRoom() {
        return this.zzaHc;
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        String str = null;
        int i = 0;
        if (zzqk()) {
            dest.writeString(this.zzaCu);
            dest.writeString(this.zzVu);
            dest.writeString(this.zzazC == null ? null : this.zzazC.toString());
            if (this.zzazD != null) {
                str = this.zzazD.toString();
            }
            dest.writeString(str);
            dest.writeInt(this.zzAk);
            dest.writeString(this.zzaBt);
            dest.writeInt(this.zzaHc ? 1 : 0);
            if (this.zzaAL != null) {
                i = 1;
            }
            dest.writeInt(i);
            if (this.zzaAL != null) {
                this.zzaAL.writeToParcel(dest, flags);
                return;
            }
            return;
        }
        ParticipantEntityCreator.zza(this, dest, flags);
    }

    public String zzvN() {
        return this.zzaBt;
    }
}
