package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.DowngradeableSafeParcel;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;

public final class GameBadgeEntity extends GamesDowngradeableSafeParcel implements GameBadge {
    public static final GameBadgeEntityCreator CREATOR = new GameBadgeEntityCreatorCompat();
    private final int mVersionCode;
    private int zzZU;
    private String zzank;
    private String zzavc;
    private Uri zzazC;

    static final class GameBadgeEntityCreatorCompat extends GameBadgeEntityCreator {
        GameBadgeEntityCreatorCompat() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return zzef(x0);
        }

        public GameBadgeEntity zzef(Parcel parcel) {
            if (GamesDowngradeableSafeParcel.zzd(DowngradeableSafeParcel.zzqj()) || DowngradeableSafeParcel.zzcz(GameBadgeEntity.class.getCanonicalName())) {
                return super.zzef(parcel);
            }
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            return new GameBadgeEntity(1, readInt, readString, readString2, readString3 == null ? null : Uri.parse(readString3));
        }
    }

    GameBadgeEntity(int versionCode, int type, String title, String description, Uri iconImageUri) {
        this.mVersionCode = versionCode;
        this.zzZU = type;
        this.zzank = title;
        this.zzavc = description;
        this.zzazC = iconImageUri;
    }

    public GameBadgeEntity(GameBadge gameBadge) {
        this.mVersionCode = 1;
        this.zzZU = gameBadge.getType();
        this.zzank = gameBadge.getTitle();
        this.zzavc = gameBadge.getDescription();
        this.zzazC = gameBadge.getIconImageUri();
    }

    static int zza(GameBadge gameBadge) {
        return zzw.hashCode(Integer.valueOf(gameBadge.getType()), gameBadge.getTitle(), gameBadge.getDescription(), gameBadge.getIconImageUri());
    }

    static boolean zza(GameBadge gameBadge, Object obj) {
        if (!(obj instanceof GameBadge)) {
            return false;
        }
        if (gameBadge == obj) {
            return true;
        }
        GameBadge gameBadge2 = (GameBadge) obj;
        return zzw.equal(Integer.valueOf(gameBadge2.getType()), gameBadge.getTitle()) && zzw.equal(gameBadge2.getDescription(), gameBadge.getIconImageUri());
    }

    static String zzb(GameBadge gameBadge) {
        return zzw.zzx(gameBadge).zzg("Type", Integer.valueOf(gameBadge.getType())).zzg("Title", gameBadge.getTitle()).zzg("Description", gameBadge.getDescription()).zzg("IconImageUri", gameBadge.getIconImageUri()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzwF();
    }

    public String getDescription() {
        return this.zzavc;
    }

    public Uri getIconImageUri() {
        return this.zzazC;
    }

    public String getTitle() {
        return this.zzank;
    }

    public int getType() {
        return this.zzZU;
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
            dest.writeInt(this.zzZU);
            dest.writeString(this.zzank);
            dest.writeString(this.zzavc);
            dest.writeString(this.zzazC == null ? null : this.zzazC.toString());
            return;
        }
        GameBadgeEntityCreator.zza(this, dest, flags);
    }

    public GameBadge zzwF() {
        return this;
    }
}
