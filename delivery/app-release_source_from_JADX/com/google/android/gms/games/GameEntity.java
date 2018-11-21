package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.DowngradeableSafeParcel;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.zznn;

public final class GameEntity extends GamesDowngradeableSafeParcel implements Game {
    public static final Creator<GameEntity> CREATOR = new GameEntityCreatorCompat();
    private final int mVersionCode;
    private final boolean zzCZ;
    private final String zzVu;
    private final String zzXW;
    private final String zzavc;
    private final String zzazA;
    private final String zzazB;
    private final Uri zzazC;
    private final Uri zzazD;
    private final Uri zzazE;
    private final boolean zzazF;
    private final boolean zzazG;
    private final String zzazH;
    private final int zzazI;
    private final int zzazJ;
    private final int zzazK;
    private final boolean zzazL;
    private final boolean zzazM;
    private final String zzazN;
    private final String zzazO;
    private final String zzazP;
    private final boolean zzazQ;
    private final boolean zzazR;
    private final String zzazS;
    private final boolean zzazT;
    private final String zzazz;

    static final class GameEntityCreatorCompat extends GameEntityCreator {
        GameEntityCreatorCompat() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return zzdS(x0);
        }

        public GameEntity zzdS(Parcel parcel) {
            if (GamesDowngradeableSafeParcel.zzd(DowngradeableSafeParcel.zzqj()) || DowngradeableSafeParcel.zzcz(GameEntity.class.getCanonicalName())) {
                return super.zzdS(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            Uri parse = readString7 == null ? null : Uri.parse(readString7);
            readString7 = parcel.readString();
            Uri parse2 = readString7 == null ? null : Uri.parse(readString7);
            readString7 = parcel.readString();
            return new GameEntity(7, readString, readString2, readString3, readString4, readString5, readString6, parse, parse2, readString7 == null ? null : Uri.parse(readString7), parcel.readInt() > 0, parcel.readInt() > 0, parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), false, false, null, null, null, false, false, false, null, false);
        }
    }

    GameEntity(int versionCode, String applicationId, String displayName, String primaryCategory, String secondaryCategory, String description, String developerName, Uri iconImageUri, Uri hiResImageUri, Uri featuredImageUri, boolean playEnabledGame, boolean instanceInstalled, String instancePackageName, int gameplayAclStatus, int achievementTotalCount, int leaderboardCount, boolean realTimeEnabled, boolean turnBasedEnabled, String iconImageUrl, String hiResImageUrl, String featuredImageUrl, boolean muted, boolean identitySharingConfirmed, boolean snapshotsEnabled, String themeColor, boolean hasGamepadSupport) {
        this.mVersionCode = versionCode;
        this.zzXW = applicationId;
        this.zzVu = displayName;
        this.zzazz = primaryCategory;
        this.zzazA = secondaryCategory;
        this.zzavc = description;
        this.zzazB = developerName;
        this.zzazC = iconImageUri;
        this.zzazN = iconImageUrl;
        this.zzazD = hiResImageUri;
        this.zzazO = hiResImageUrl;
        this.zzazE = featuredImageUri;
        this.zzazP = featuredImageUrl;
        this.zzazF = playEnabledGame;
        this.zzazG = instanceInstalled;
        this.zzazH = instancePackageName;
        this.zzazI = gameplayAclStatus;
        this.zzazJ = achievementTotalCount;
        this.zzazK = leaderboardCount;
        this.zzazL = realTimeEnabled;
        this.zzazM = turnBasedEnabled;
        this.zzCZ = muted;
        this.zzazQ = identitySharingConfirmed;
        this.zzazR = snapshotsEnabled;
        this.zzazS = themeColor;
        this.zzazT = hasGamepadSupport;
    }

    public GameEntity(Game game) {
        this.mVersionCode = 7;
        this.zzXW = game.getApplicationId();
        this.zzazz = game.getPrimaryCategory();
        this.zzazA = game.getSecondaryCategory();
        this.zzavc = game.getDescription();
        this.zzazB = game.getDeveloperName();
        this.zzVu = game.getDisplayName();
        this.zzazC = game.getIconImageUri();
        this.zzazN = game.getIconImageUrl();
        this.zzazD = game.getHiResImageUri();
        this.zzazO = game.getHiResImageUrl();
        this.zzazE = game.getFeaturedImageUri();
        this.zzazP = game.getFeaturedImageUrl();
        this.zzazF = game.zzuR();
        this.zzazG = game.zzuT();
        this.zzazH = game.zzuU();
        this.zzazI = game.zzuV();
        this.zzazJ = game.getAchievementTotalCount();
        this.zzazK = game.getLeaderboardCount();
        this.zzazL = game.isRealTimeMultiplayerEnabled();
        this.zzazM = game.isTurnBasedMultiplayerEnabled();
        this.zzCZ = game.isMuted();
        this.zzazQ = game.zzuS();
        this.zzazR = game.areSnapshotsEnabled();
        this.zzazS = game.getThemeColor();
        this.zzazT = game.hasGamepadSupport();
    }

    static int zza(Game game) {
        return zzw.hashCode(game.getApplicationId(), game.getDisplayName(), game.getPrimaryCategory(), game.getSecondaryCategory(), game.getDescription(), game.getDeveloperName(), game.getIconImageUri(), game.getHiResImageUri(), game.getFeaturedImageUri(), Boolean.valueOf(game.zzuR()), Boolean.valueOf(game.zzuT()), game.zzuU(), Integer.valueOf(game.zzuV()), Integer.valueOf(game.getAchievementTotalCount()), Integer.valueOf(game.getLeaderboardCount()), Boolean.valueOf(game.isRealTimeMultiplayerEnabled()), Boolean.valueOf(game.isTurnBasedMultiplayerEnabled()), Boolean.valueOf(game.isMuted()), Boolean.valueOf(game.zzuS()), Boolean.valueOf(game.areSnapshotsEnabled()), game.getThemeColor(), Boolean.valueOf(game.hasGamepadSupport()));
    }

    static boolean zza(Game game, Object obj) {
        if (!(obj instanceof Game)) {
            return false;
        }
        if (game == obj) {
            return true;
        }
        Game game2 = (Game) obj;
        if (zzw.equal(game2.getApplicationId(), game.getApplicationId()) && zzw.equal(game2.getDisplayName(), game.getDisplayName()) && zzw.equal(game2.getPrimaryCategory(), game.getPrimaryCategory()) && zzw.equal(game2.getSecondaryCategory(), game.getSecondaryCategory()) && zzw.equal(game2.getDescription(), game.getDescription()) && zzw.equal(game2.getDeveloperName(), game.getDeveloperName()) && zzw.equal(game2.getIconImageUri(), game.getIconImageUri()) && zzw.equal(game2.getHiResImageUri(), game.getHiResImageUri()) && zzw.equal(game2.getFeaturedImageUri(), game.getFeaturedImageUri()) && zzw.equal(Boolean.valueOf(game2.zzuR()), Boolean.valueOf(game.zzuR())) && zzw.equal(Boolean.valueOf(game2.zzuT()), Boolean.valueOf(game.zzuT())) && zzw.equal(game2.zzuU(), game.zzuU()) && zzw.equal(Integer.valueOf(game2.zzuV()), Integer.valueOf(game.zzuV())) && zzw.equal(Integer.valueOf(game2.getAchievementTotalCount()), Integer.valueOf(game.getAchievementTotalCount())) && zzw.equal(Integer.valueOf(game2.getLeaderboardCount()), Integer.valueOf(game.getLeaderboardCount())) && zzw.equal(Boolean.valueOf(game2.isRealTimeMultiplayerEnabled()), Boolean.valueOf(game.isRealTimeMultiplayerEnabled()))) {
            Boolean valueOf = Boolean.valueOf(game2.isTurnBasedMultiplayerEnabled());
            boolean z = game.isTurnBasedMultiplayerEnabled() && zzw.equal(Boolean.valueOf(game2.isMuted()), Boolean.valueOf(game.isMuted())) && zzw.equal(Boolean.valueOf(game2.zzuS()), Boolean.valueOf(game.zzuS()));
            if (zzw.equal(valueOf, Boolean.valueOf(z)) && zzw.equal(Boolean.valueOf(game2.areSnapshotsEnabled()), Boolean.valueOf(game.areSnapshotsEnabled())) && zzw.equal(game2.getThemeColor(), game.getThemeColor()) && zzw.equal(Boolean.valueOf(game2.hasGamepadSupport()), Boolean.valueOf(game.hasGamepadSupport()))) {
                return true;
            }
        }
        return false;
    }

    static String zzb(Game game) {
        return zzw.zzx(game).zzg("ApplicationId", game.getApplicationId()).zzg("DisplayName", game.getDisplayName()).zzg("PrimaryCategory", game.getPrimaryCategory()).zzg("SecondaryCategory", game.getSecondaryCategory()).zzg("Description", game.getDescription()).zzg("DeveloperName", game.getDeveloperName()).zzg("IconImageUri", game.getIconImageUri()).zzg("IconImageUrl", game.getIconImageUrl()).zzg("HiResImageUri", game.getHiResImageUri()).zzg("HiResImageUrl", game.getHiResImageUrl()).zzg("FeaturedImageUri", game.getFeaturedImageUri()).zzg("FeaturedImageUrl", game.getFeaturedImageUrl()).zzg("PlayEnabledGame", Boolean.valueOf(game.zzuR())).zzg("InstanceInstalled", Boolean.valueOf(game.zzuT())).zzg("InstancePackageName", game.zzuU()).zzg("AchievementTotalCount", Integer.valueOf(game.getAchievementTotalCount())).zzg("LeaderboardCount", Integer.valueOf(game.getLeaderboardCount())).zzg("RealTimeMultiplayerEnabled", Boolean.valueOf(game.isRealTimeMultiplayerEnabled())).zzg("TurnBasedMultiplayerEnabled", Boolean.valueOf(game.isTurnBasedMultiplayerEnabled())).zzg("AreSnapshotsEnabled", Boolean.valueOf(game.areSnapshotsEnabled())).zzg("ThemeColor", game.getThemeColor()).zzg("HasGamepadSupport", Boolean.valueOf(game.hasGamepadSupport())).toString();
    }

    public boolean areSnapshotsEnabled() {
        return this.zzazR;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public Game freeze() {
        return this;
    }

    public int getAchievementTotalCount() {
        return this.zzazJ;
    }

    public String getApplicationId() {
        return this.zzXW;
    }

    public String getDescription() {
        return this.zzavc;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        zznn.zzb(this.zzavc, dataOut);
    }

    public String getDeveloperName() {
        return this.zzazB;
    }

    public void getDeveloperName(CharArrayBuffer dataOut) {
        zznn.zzb(this.zzazB, dataOut);
    }

    public String getDisplayName() {
        return this.zzVu;
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        zznn.zzb(this.zzVu, dataOut);
    }

    public Uri getFeaturedImageUri() {
        return this.zzazE;
    }

    public String getFeaturedImageUrl() {
        return this.zzazP;
    }

    public Uri getHiResImageUri() {
        return this.zzazD;
    }

    public String getHiResImageUrl() {
        return this.zzazO;
    }

    public Uri getIconImageUri() {
        return this.zzazC;
    }

    public String getIconImageUrl() {
        return this.zzazN;
    }

    public int getLeaderboardCount() {
        return this.zzazK;
    }

    public String getPrimaryCategory() {
        return this.zzazz;
    }

    public String getSecondaryCategory() {
        return this.zzazA;
    }

    public String getThemeColor() {
        return this.zzazS;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean hasGamepadSupport() {
        return this.zzazT;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isMuted() {
        return this.zzCZ;
    }

    public boolean isRealTimeMultiplayerEnabled() {
        return this.zzazL;
    }

    public boolean isTurnBasedMultiplayerEnabled() {
        return this.zzazM;
    }

    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        int i = 1;
        String str = null;
        if (zzqk()) {
            dest.writeString(this.zzXW);
            dest.writeString(this.zzVu);
            dest.writeString(this.zzazz);
            dest.writeString(this.zzazA);
            dest.writeString(this.zzavc);
            dest.writeString(this.zzazB);
            dest.writeString(this.zzazC == null ? null : this.zzazC.toString());
            dest.writeString(this.zzazD == null ? null : this.zzazD.toString());
            if (this.zzazE != null) {
                str = this.zzazE.toString();
            }
            dest.writeString(str);
            dest.writeInt(this.zzazF ? 1 : 0);
            if (!this.zzazG) {
                i = 0;
            }
            dest.writeInt(i);
            dest.writeString(this.zzazH);
            dest.writeInt(this.zzazI);
            dest.writeInt(this.zzazJ);
            dest.writeInt(this.zzazK);
            return;
        }
        GameEntityCreator.zza(this, dest, flags);
    }

    public boolean zzuR() {
        return this.zzazF;
    }

    public boolean zzuS() {
        return this.zzazQ;
    }

    public boolean zzuT() {
        return this.zzazG;
    }

    public String zzuU() {
        return this.zzazH;
    }

    public int zzuV() {
        return this.zzazI;
    }
}
