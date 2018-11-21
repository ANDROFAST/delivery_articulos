package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public final class MostRecentGameInfoEntity implements SafeParcelable, MostRecentGameInfo {
    public static final MostRecentGameInfoEntityCreator CREATOR = new MostRecentGameInfoEntityCreator();
    private final int mVersionCode;
    private final String zzaFC;
    private final String zzaFD;
    private final long zzaFE;
    private final Uri zzaFF;
    private final Uri zzaFG;
    private final Uri zzaFH;

    MostRecentGameInfoEntity(int versionCode, String gameId, String gameName, long activityTimestampMillis, Uri gameIconImageUri, Uri gameHiResIconImageUri, Uri gameFeaturedImageUri) {
        this.mVersionCode = versionCode;
        this.zzaFC = gameId;
        this.zzaFD = gameName;
        this.zzaFE = activityTimestampMillis;
        this.zzaFF = gameIconImageUri;
        this.zzaFG = gameHiResIconImageUri;
        this.zzaFH = gameFeaturedImageUri;
    }

    public MostRecentGameInfoEntity(MostRecentGameInfo info) {
        this.mVersionCode = 2;
        this.zzaFC = info.zzwR();
        this.zzaFD = info.zzwS();
        this.zzaFE = info.zzwT();
        this.zzaFF = info.zzwU();
        this.zzaFG = info.zzwV();
        this.zzaFH = info.zzwW();
    }

    static int zza(MostRecentGameInfo mostRecentGameInfo) {
        return zzw.hashCode(mostRecentGameInfo.zzwR(), mostRecentGameInfo.zzwS(), Long.valueOf(mostRecentGameInfo.zzwT()), mostRecentGameInfo.zzwU(), mostRecentGameInfo.zzwV(), mostRecentGameInfo.zzwW());
    }

    static boolean zza(MostRecentGameInfo mostRecentGameInfo, Object obj) {
        if (!(obj instanceof MostRecentGameInfo)) {
            return false;
        }
        if (mostRecentGameInfo == obj) {
            return true;
        }
        MostRecentGameInfo mostRecentGameInfo2 = (MostRecentGameInfo) obj;
        return zzw.equal(mostRecentGameInfo2.zzwR(), mostRecentGameInfo.zzwR()) && zzw.equal(mostRecentGameInfo2.zzwS(), mostRecentGameInfo.zzwS()) && zzw.equal(Long.valueOf(mostRecentGameInfo2.zzwT()), Long.valueOf(mostRecentGameInfo.zzwT())) && zzw.equal(mostRecentGameInfo2.zzwU(), mostRecentGameInfo.zzwU()) && zzw.equal(mostRecentGameInfo2.zzwV(), mostRecentGameInfo.zzwV()) && zzw.equal(mostRecentGameInfo2.zzwW(), mostRecentGameInfo.zzwW());
    }

    static String zzb(MostRecentGameInfo mostRecentGameInfo) {
        return zzw.zzx(mostRecentGameInfo).zzg("GameId", mostRecentGameInfo.zzwR()).zzg("GameName", mostRecentGameInfo.zzwS()).zzg("ActivityTimestampMillis", Long.valueOf(mostRecentGameInfo.zzwT())).zzg("GameIconUri", mostRecentGameInfo.zzwU()).zzg("GameHiResUri", mostRecentGameInfo.zzwV()).zzg("GameFeaturedUri", mostRecentGameInfo.zzwW()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzwX();
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

    public void writeToParcel(Parcel out, int flags) {
        MostRecentGameInfoEntityCreator.zza(this, out, flags);
    }

    public String zzwR() {
        return this.zzaFC;
    }

    public String zzwS() {
        return this.zzaFD;
    }

    public long zzwT() {
        return this.zzaFE;
    }

    public Uri zzwU() {
        return this.zzaFF;
    }

    public Uri zzwV() {
        return this.zzaFG;
    }

    public Uri zzwW() {
        return this.zzaFH;
    }

    public MostRecentGameInfo zzwX() {
        return this;
    }
}
