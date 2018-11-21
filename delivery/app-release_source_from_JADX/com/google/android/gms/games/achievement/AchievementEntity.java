package com.google.android.gms.games.achievement;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.zznn;

public final class AchievementEntity implements SafeParcelable, Achievement {
    public static final Creator<AchievementEntity> CREATOR = new AchievementEntityCreator();
    private final String mName;
    private final int mState;
    private final int mVersionCode;
    private final int zzZU;
    private final String zzaAE;
    private final Uri zzaAF;
    private final String zzaAG;
    private final Uri zzaAH;
    private final String zzaAI;
    private final int zzaAJ;
    private final String zzaAK;
    private final PlayerEntity zzaAL;
    private final int zzaAM;
    private final String zzaAN;
    private final long zzaAO;
    private final long zzaAP;
    private final String zzavc;

    AchievementEntity(int versionCode, String achievementId, int type, String name, String description, Uri unlockedImageUri, String unlockedImageUrl, Uri revealedImageUri, String revealedImageUrl, int totalSteps, String formattedTotalSteps, PlayerEntity player, int state, int currentSteps, String formattedCurrentSteps, long lastUpdatedTimestamp, long xpValue) {
        this.mVersionCode = versionCode;
        this.zzaAE = achievementId;
        this.zzZU = type;
        this.mName = name;
        this.zzavc = description;
        this.zzaAF = unlockedImageUri;
        this.zzaAG = unlockedImageUrl;
        this.zzaAH = revealedImageUri;
        this.zzaAI = revealedImageUrl;
        this.zzaAJ = totalSteps;
        this.zzaAK = formattedTotalSteps;
        this.zzaAL = player;
        this.mState = state;
        this.zzaAM = currentSteps;
        this.zzaAN = formattedCurrentSteps;
        this.zzaAO = lastUpdatedTimestamp;
        this.zzaAP = xpValue;
    }

    public AchievementEntity(Achievement achievement) {
        this.mVersionCode = 1;
        this.zzaAE = achievement.getAchievementId();
        this.zzZU = achievement.getType();
        this.mName = achievement.getName();
        this.zzavc = achievement.getDescription();
        this.zzaAF = achievement.getUnlockedImageUri();
        this.zzaAG = achievement.getUnlockedImageUrl();
        this.zzaAH = achievement.getRevealedImageUri();
        this.zzaAI = achievement.getRevealedImageUrl();
        this.zzaAL = (PlayerEntity) achievement.getPlayer().freeze();
        this.mState = achievement.getState();
        this.zzaAO = achievement.getLastUpdatedTimestamp();
        this.zzaAP = achievement.getXpValue();
        if (achievement.getType() == 1) {
            this.zzaAJ = achievement.getTotalSteps();
            this.zzaAK = achievement.getFormattedTotalSteps();
            this.zzaAM = achievement.getCurrentSteps();
            this.zzaAN = achievement.getFormattedCurrentSteps();
        } else {
            this.zzaAJ = 0;
            this.zzaAK = null;
            this.zzaAM = 0;
            this.zzaAN = null;
        }
        zzb.zzu(this.zzaAE);
        zzb.zzu(this.zzavc);
    }

    static int zza(Achievement achievement) {
        int currentSteps;
        int totalSteps;
        if (achievement.getType() == 1) {
            currentSteps = achievement.getCurrentSteps();
            totalSteps = achievement.getTotalSteps();
        } else {
            totalSteps = 0;
            currentSteps = 0;
        }
        return zzw.hashCode(achievement.getAchievementId(), achievement.getName(), Integer.valueOf(achievement.getType()), achievement.getDescription(), Long.valueOf(achievement.getXpValue()), Integer.valueOf(achievement.getState()), Long.valueOf(achievement.getLastUpdatedTimestamp()), achievement.getPlayer(), Integer.valueOf(currentSteps), Integer.valueOf(totalSteps));
    }

    static boolean zza(Achievement achievement, Object obj) {
        if (!(obj instanceof Achievement)) {
            return false;
        }
        if (achievement == obj) {
            return true;
        }
        boolean equal;
        boolean equal2;
        Achievement achievement2 = (Achievement) obj;
        if (achievement.getType() == 1) {
            equal = zzw.equal(Integer.valueOf(achievement2.getCurrentSteps()), Integer.valueOf(achievement.getCurrentSteps()));
            equal2 = zzw.equal(Integer.valueOf(achievement2.getTotalSteps()), Integer.valueOf(achievement.getTotalSteps()));
        } else {
            equal2 = true;
            equal = true;
        }
        return zzw.equal(achievement2.getAchievementId(), achievement.getAchievementId()) && zzw.equal(achievement2.getName(), achievement.getName()) && zzw.equal(Integer.valueOf(achievement2.getType()), Integer.valueOf(achievement.getType())) && zzw.equal(achievement2.getDescription(), achievement.getDescription()) && zzw.equal(Long.valueOf(achievement2.getXpValue()), Long.valueOf(achievement.getXpValue())) && zzw.equal(Integer.valueOf(achievement2.getState()), Integer.valueOf(achievement.getState())) && zzw.equal(Long.valueOf(achievement2.getLastUpdatedTimestamp()), Long.valueOf(achievement.getLastUpdatedTimestamp())) && zzw.equal(achievement2.getPlayer(), achievement.getPlayer()) && equal && equal2;
    }

    static String zzb(Achievement achievement) {
        zza zzg = zzw.zzx(achievement).zzg("Id", achievement.getAchievementId()).zzg("Type", Integer.valueOf(achievement.getType())).zzg("Name", achievement.getName()).zzg("Description", achievement.getDescription()).zzg("Player", achievement.getPlayer()).zzg("State", Integer.valueOf(achievement.getState()));
        if (achievement.getType() == 1) {
            zzg.zzg("CurrentSteps", Integer.valueOf(achievement.getCurrentSteps()));
            zzg.zzg("TotalSteps", Integer.valueOf(achievement.getTotalSteps()));
        }
        return zzg.toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public Achievement freeze() {
        return this;
    }

    public String getAchievementId() {
        return this.zzaAE;
    }

    public int getCurrentSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        zzb.zzaa(z);
        return zzvg();
    }

    public String getDescription() {
        return this.zzavc;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        zznn.zzb(this.zzavc, dataOut);
    }

    public String getFormattedCurrentSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        zzb.zzaa(z);
        return zzvh();
    }

    public void getFormattedCurrentSteps(CharArrayBuffer dataOut) {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        zzb.zzaa(z);
        zznn.zzb(this.zzaAN, dataOut);
    }

    public String getFormattedTotalSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        zzb.zzaa(z);
        return zzvf();
    }

    public void getFormattedTotalSteps(CharArrayBuffer dataOut) {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        zzb.zzaa(z);
        zznn.zzb(this.zzaAK, dataOut);
    }

    public long getLastUpdatedTimestamp() {
        return this.zzaAO;
    }

    public String getName() {
        return this.mName;
    }

    public void getName(CharArrayBuffer dataOut) {
        zznn.zzb(this.mName, dataOut);
    }

    public Player getPlayer() {
        return this.zzaAL;
    }

    public Uri getRevealedImageUri() {
        return this.zzaAH;
    }

    public String getRevealedImageUrl() {
        return this.zzaAI;
    }

    public int getState() {
        return this.mState;
    }

    public int getTotalSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        zzb.zzaa(z);
        return zzve();
    }

    public int getType() {
        return this.zzZU;
    }

    public Uri getUnlockedImageUri() {
        return this.zzaAF;
    }

    public String getUnlockedImageUrl() {
        return this.zzaAG;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public long getXpValue() {
        return this.zzaAP;
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
        AchievementEntityCreator.zza(this, dest, flags);
    }

    public int zzve() {
        return this.zzaAJ;
    }

    public String zzvf() {
        return this.zzaAK;
    }

    public int zzvg() {
        return this.zzaAM;
    }

    public String zzvh() {
        return this.zzaAN;
    }
}
