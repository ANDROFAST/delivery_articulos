package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public final class PlayerLevelInfo implements SafeParcelable {
    public static final Creator<PlayerLevelInfo> CREATOR = new PlayerLevelInfoCreator();
    private final int mVersionCode;
    private final PlayerLevel zzaAA;
    private final PlayerLevel zzaAB;
    private final long zzaAy;
    private final long zzaAz;

    PlayerLevelInfo(int versionCode, long currentXpTotal, long lastLevelUpTimestamp, PlayerLevel currentLevel, PlayerLevel nextLevel) {
        zzx.zzaa(currentXpTotal != -1);
        zzx.zzy(currentLevel);
        zzx.zzy(nextLevel);
        this.mVersionCode = versionCode;
        this.zzaAy = currentXpTotal;
        this.zzaAz = lastLevelUpTimestamp;
        this.zzaAA = currentLevel;
        this.zzaAB = nextLevel;
    }

    public PlayerLevelInfo(long currentXpTotal, long lastLevelUpTimestamp, PlayerLevel currentLevel, PlayerLevel nextLevel) {
        this(1, currentXpTotal, lastLevelUpTimestamp, currentLevel, nextLevel);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlayerLevelInfo)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        PlayerLevelInfo playerLevelInfo = (PlayerLevelInfo) obj;
        return zzw.equal(Long.valueOf(this.zzaAy), Long.valueOf(playerLevelInfo.zzaAy)) && zzw.equal(Long.valueOf(this.zzaAz), Long.valueOf(playerLevelInfo.zzaAz)) && zzw.equal(this.zzaAA, playerLevelInfo.zzaAA) && zzw.equal(this.zzaAB, playerLevelInfo.zzaAB);
    }

    public PlayerLevel getCurrentLevel() {
        return this.zzaAA;
    }

    public long getCurrentXpTotal() {
        return this.zzaAy;
    }

    public long getLastLevelUpTimestamp() {
        return this.zzaAz;
    }

    public PlayerLevel getNextLevel() {
        return this.zzaAB;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Long.valueOf(this.zzaAy), Long.valueOf(this.zzaAz), this.zzaAA, this.zzaAB);
    }

    public boolean isMaxLevel() {
        return this.zzaAA.equals(this.zzaAB);
    }

    public void writeToParcel(Parcel out, int flags) {
        PlayerLevelInfoCreator.zza(this, out, flags);
    }
}
