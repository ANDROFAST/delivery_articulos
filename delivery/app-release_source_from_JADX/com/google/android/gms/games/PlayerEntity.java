package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.DowngradeableSafeParcel;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;
import com.google.android.gms.internal.zznn;

public final class PlayerEntity extends GamesDowngradeableSafeParcel implements Player {
    public static final Creator<PlayerEntity> CREATOR = new PlayerEntityCreatorCompat();
    private final String mName;
    private final int mVersionCode;
    private final String zzVu;
    private final long zzaAj;
    private final int zzaAk;
    private final long zzaAl;
    private final MostRecentGameInfoEntity zzaAm;
    private final PlayerLevelInfo zzaAn;
    private final boolean zzaAo;
    private final boolean zzaAp;
    private final String zzaAq;
    private final Uri zzaAr;
    private final String zzaAs;
    private final Uri zzaAt;
    private final String zzaAu;
    private final String zzabq;
    private final String zzank;
    private final Uri zzazC;
    private final Uri zzazD;
    private final String zzazN;
    private final String zzazO;

    static final class PlayerEntityCreatorCompat extends PlayerEntityCreator {
        PlayerEntityCreatorCompat() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return zzdT(x0);
        }

        public PlayerEntity zzdT(Parcel parcel) {
            if (GamesDowngradeableSafeParcel.zzd(DowngradeableSafeParcel.zzqj()) || DowngradeableSafeParcel.zzcz(PlayerEntity.class.getCanonicalName())) {
                return super.zzdT(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            return new PlayerEntity(13, readString, readString2, readString3 == null ? null : Uri.parse(readString3), readString4 == null ? null : Uri.parse(readString4), parcel.readLong(), -1, -1, null, null, null, null, null, true, false, parcel.readString(), parcel.readString(), null, null, null, null);
        }
    }

    PlayerEntity(int versionCode, String playerId, String displayName, Uri iconImageUri, Uri hiResImageUri, long retrievedTimestamp, int isInCircles, long lastPlayedWithTimestamp, String iconImageUrl, String hiResImageUrl, String title, MostRecentGameInfoEntity mostRecentGameInfo, PlayerLevelInfo playerLevelInfo, boolean isProfileVisible, boolean hasDebugAccess, String gamerTag, String name, Uri bannerImageLandscapeUri, String bannerImageLandscapeUrl, Uri bannerImagePortraitUri, String bannerImagePortraitUrl) {
        this.mVersionCode = versionCode;
        this.zzabq = playerId;
        this.zzVu = displayName;
        this.zzazC = iconImageUri;
        this.zzazN = iconImageUrl;
        this.zzazD = hiResImageUri;
        this.zzazO = hiResImageUrl;
        this.zzaAj = retrievedTimestamp;
        this.zzaAk = isInCircles;
        this.zzaAl = lastPlayedWithTimestamp;
        this.zzank = title;
        this.zzaAo = isProfileVisible;
        this.zzaAm = mostRecentGameInfo;
        this.zzaAn = playerLevelInfo;
        this.zzaAp = hasDebugAccess;
        this.zzaAq = gamerTag;
        this.mName = name;
        this.zzaAr = bannerImageLandscapeUri;
        this.zzaAs = bannerImageLandscapeUrl;
        this.zzaAt = bannerImagePortraitUri;
        this.zzaAu = bannerImagePortraitUrl;
    }

    public PlayerEntity(Player player) {
        this(player, true);
    }

    public PlayerEntity(Player player, boolean isPlusEnabled) {
        MostRecentGameInfoEntity mostRecentGameInfoEntity = null;
        this.mVersionCode = 13;
        this.zzabq = isPlusEnabled ? player.getPlayerId() : null;
        this.zzVu = player.getDisplayName();
        this.zzazC = player.getIconImageUri();
        this.zzazN = player.getIconImageUrl();
        this.zzazD = player.getHiResImageUri();
        this.zzazO = player.getHiResImageUrl();
        this.zzaAj = player.getRetrievedTimestamp();
        this.zzaAk = player.zzva();
        this.zzaAl = player.getLastPlayedWithTimestamp();
        this.zzank = player.getTitle();
        this.zzaAo = player.zzvb();
        MostRecentGameInfo zzvc = player.zzvc();
        if (zzvc != null) {
            mostRecentGameInfoEntity = new MostRecentGameInfoEntity(zzvc);
        }
        this.zzaAm = mostRecentGameInfoEntity;
        this.zzaAn = player.getLevelInfo();
        this.zzaAp = player.zzuZ();
        this.zzaAq = player.zzuY();
        this.mName = player.getName();
        this.zzaAr = player.getBannerImageLandscapeUri();
        this.zzaAs = player.getBannerImageLandscapeUrl();
        this.zzaAt = player.getBannerImagePortraitUri();
        this.zzaAu = player.getBannerImagePortraitUrl();
        if (isPlusEnabled) {
            zzb.zzu(this.zzabq);
        }
        zzb.zzu(this.zzVu);
        zzb.zzaa(this.zzaAj > 0);
    }

    static boolean zza(Player player, Object obj) {
        if (!(obj instanceof Player)) {
            return false;
        }
        if (player == obj) {
            return true;
        }
        Player player2 = (Player) obj;
        return zzw.equal(player2.getPlayerId(), player.getPlayerId()) && zzw.equal(player2.getDisplayName(), player.getDisplayName()) && zzw.equal(Boolean.valueOf(player2.zzuZ()), Boolean.valueOf(player.zzuZ())) && zzw.equal(player2.getIconImageUri(), player.getIconImageUri()) && zzw.equal(player2.getHiResImageUri(), player.getHiResImageUri()) && zzw.equal(Long.valueOf(player2.getRetrievedTimestamp()), Long.valueOf(player.getRetrievedTimestamp())) && zzw.equal(player2.getTitle(), player.getTitle()) && zzw.equal(player2.getLevelInfo(), player.getLevelInfo()) && zzw.equal(player2.zzuY(), player.zzuY()) && zzw.equal(player2.getName(), player.getName()) && zzw.equal(player2.getBannerImageLandscapeUri(), player.getBannerImageLandscapeUri()) && zzw.equal(player2.getBannerImagePortraitUri(), player.getBannerImagePortraitUri());
    }

    static int zzb(Player player) {
        return zzw.hashCode(player.getPlayerId(), player.getDisplayName(), Boolean.valueOf(player.zzuZ()), player.getIconImageUri(), player.getHiResImageUri(), Long.valueOf(player.getRetrievedTimestamp()), player.getTitle(), player.getLevelInfo(), player.zzuY(), player.getName(), player.getBannerImageLandscapeUri(), player.getBannerImagePortraitUri());
    }

    static String zzc(Player player) {
        return zzw.zzx(player).zzg("PlayerId", player.getPlayerId()).zzg("DisplayName", player.getDisplayName()).zzg("HasDebugAccess", Boolean.valueOf(player.zzuZ())).zzg("IconImageUri", player.getIconImageUri()).zzg("IconImageUrl", player.getIconImageUrl()).zzg("HiResImageUri", player.getHiResImageUri()).zzg("HiResImageUrl", player.getHiResImageUrl()).zzg("RetrievedTimestamp", Long.valueOf(player.getRetrievedTimestamp())).zzg("Title", player.getTitle()).zzg("LevelInfo", player.getLevelInfo()).zzg("GamerTag", player.zzuY()).zzg("Name", player.getName()).zzg("BannerImageLandscapeUri", player.getBannerImageLandscapeUri()).zzg("BannerImageLandscapeUrl", player.getBannerImageLandscapeUrl()).zzg("BannerImagePortraitUri", player.getBannerImagePortraitUri()).zzg("BannerImagePortraitUrl", player.getBannerImagePortraitUrl()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public Player freeze() {
        return this;
    }

    public Uri getBannerImageLandscapeUri() {
        return this.zzaAr;
    }

    public String getBannerImageLandscapeUrl() {
        return this.zzaAs;
    }

    public Uri getBannerImagePortraitUri() {
        return this.zzaAt;
    }

    public String getBannerImagePortraitUrl() {
        return this.zzaAu;
    }

    public String getDisplayName() {
        return this.zzVu;
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        zznn.zzb(this.zzVu, dataOut);
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

    public long getLastPlayedWithTimestamp() {
        return this.zzaAl;
    }

    public PlayerLevelInfo getLevelInfo() {
        return this.zzaAn;
    }

    public String getName() {
        return this.mName;
    }

    public String getPlayerId() {
        return this.zzabq;
    }

    public long getRetrievedTimestamp() {
        return this.zzaAj;
    }

    public String getTitle() {
        return this.zzank;
    }

    public void getTitle(CharArrayBuffer dataOut) {
        zznn.zzb(this.zzank, dataOut);
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean hasHiResImage() {
        return getHiResImageUri() != null;
    }

    public boolean hasIconImage() {
        return getIconImageUri() != null;
    }

    public int hashCode() {
        return zzb(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzc((Player) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        String str = null;
        if (zzqk()) {
            dest.writeString(this.zzabq);
            dest.writeString(this.zzVu);
            dest.writeString(this.zzazC == null ? null : this.zzazC.toString());
            if (this.zzazD != null) {
                str = this.zzazD.toString();
            }
            dest.writeString(str);
            dest.writeLong(this.zzaAj);
            return;
        }
        PlayerEntityCreator.zza(this, dest, flags);
    }

    public String zzuY() {
        return this.zzaAq;
    }

    public boolean zzuZ() {
        return this.zzaAp;
    }

    public int zzva() {
        return this.zzaAk;
    }

    public boolean zzvb() {
        return this.zzaAo;
    }

    public MostRecentGameInfo zzvc() {
        return this.zzaAm;
    }
}
