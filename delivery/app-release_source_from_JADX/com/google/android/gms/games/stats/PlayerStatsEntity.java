package com.google.android.gms.games.stats;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class PlayerStatsEntity implements SafeParcelable, PlayerStats {
    public static final Creator<PlayerStatsEntity> CREATOR = new PlayerStatsEntityCreator();
    private final int mVersionCode;
    private final Bundle zzaIA;
    private final float zzaIt;
    private final float zzaIu;
    private final int zzaIv;
    private final int zzaIw;
    private final int zzaIx;
    private final float zzaIy;
    private final float zzaIz;

    PlayerStatsEntity(int versionCode, float averageSessionLength, float churnProbability, int daysSinceLastPlayed, int numberOfPurchases, int numberOfSessions, float sessionPercentile, float spendPercentile, Bundle rawValues) {
        this.mVersionCode = versionCode;
        this.zzaIt = averageSessionLength;
        this.zzaIu = churnProbability;
        this.zzaIv = daysSinceLastPlayed;
        this.zzaIw = numberOfPurchases;
        this.zzaIx = numberOfSessions;
        this.zzaIy = sessionPercentile;
        this.zzaIz = spendPercentile;
        this.zzaIA = rawValues;
    }

    public PlayerStatsEntity(PlayerStats playerStats) {
        this.mVersionCode = 2;
        this.zzaIt = playerStats.getAverageSessionLength();
        this.zzaIu = playerStats.getChurnProbability();
        this.zzaIv = playerStats.getDaysSinceLastPlayed();
        this.zzaIw = playerStats.getNumberOfPurchases();
        this.zzaIx = playerStats.getNumberOfSessions();
        this.zzaIy = playerStats.getSessionPercentile();
        this.zzaIz = playerStats.getSpendPercentile();
        this.zzaIA = playerStats.zzxo();
    }

    static int zza(PlayerStats playerStats) {
        return zzw.hashCode(Float.valueOf(playerStats.getAverageSessionLength()), Float.valueOf(playerStats.getChurnProbability()), Integer.valueOf(playerStats.getDaysSinceLastPlayed()), Integer.valueOf(playerStats.getNumberOfPurchases()), Integer.valueOf(playerStats.getNumberOfSessions()), Float.valueOf(playerStats.getSessionPercentile()), Float.valueOf(playerStats.getSpendPercentile()));
    }

    static boolean zza(PlayerStats playerStats, Object obj) {
        if (!(obj instanceof PlayerStats)) {
            return false;
        }
        if (playerStats == obj) {
            return true;
        }
        PlayerStats playerStats2 = (PlayerStats) obj;
        return zzw.equal(Float.valueOf(playerStats2.getAverageSessionLength()), Float.valueOf(playerStats.getAverageSessionLength())) && zzw.equal(Float.valueOf(playerStats2.getChurnProbability()), Float.valueOf(playerStats.getChurnProbability())) && zzw.equal(Integer.valueOf(playerStats2.getDaysSinceLastPlayed()), Integer.valueOf(playerStats.getDaysSinceLastPlayed())) && zzw.equal(Integer.valueOf(playerStats2.getNumberOfPurchases()), Integer.valueOf(playerStats.getNumberOfPurchases())) && zzw.equal(Integer.valueOf(playerStats2.getNumberOfSessions()), Integer.valueOf(playerStats.getNumberOfSessions())) && zzw.equal(Float.valueOf(playerStats2.getSessionPercentile()), Float.valueOf(playerStats.getSessionPercentile())) && zzw.equal(Float.valueOf(playerStats2.getSpendPercentile()), Float.valueOf(playerStats.getSpendPercentile()));
    }

    static String zzb(PlayerStats playerStats) {
        return zzw.zzx(playerStats).zzg("AverageSessionLength", Float.valueOf(playerStats.getAverageSessionLength())).zzg("ChurnProbability", Float.valueOf(playerStats.getChurnProbability())).zzg("DaysSinceLastPlayed", Integer.valueOf(playerStats.getDaysSinceLastPlayed())).zzg("NumberOfPurchases", Integer.valueOf(playerStats.getNumberOfPurchases())).zzg("NumberOfSessions", Integer.valueOf(playerStats.getNumberOfSessions())).zzg("SessionPercentile", Float.valueOf(playerStats.getSessionPercentile())).zzg("SpendPercentile", Float.valueOf(playerStats.getSpendPercentile())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzxp();
    }

    public float getAverageSessionLength() {
        return this.zzaIt;
    }

    public float getChurnProbability() {
        return this.zzaIu;
    }

    public int getDaysSinceLastPlayed() {
        return this.zzaIv;
    }

    public int getNumberOfPurchases() {
        return this.zzaIw;
    }

    public int getNumberOfSessions() {
        return this.zzaIx;
    }

    public float getSessionPercentile() {
        return this.zzaIy;
    }

    public float getSpendPercentile() {
        return this.zzaIz;
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
        PlayerStatsEntityCreator.zza(this, out, flags);
    }

    public Bundle zzxo() {
        return this.zzaIA;
    }

    public PlayerStats zzxp() {
        return this;
    }
}
