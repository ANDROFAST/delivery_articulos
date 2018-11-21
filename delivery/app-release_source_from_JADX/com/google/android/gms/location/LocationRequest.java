package com.google.android.gms.location;

import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public final class LocationRequest implements SafeParcelable {
    public static final LocationRequestCreator CREATOR = new LocationRequestCreator();
    public static final int PRIORITY_BALANCED_POWER_ACCURACY = 102;
    public static final int PRIORITY_HIGH_ACCURACY = 100;
    public static final int PRIORITY_LOW_POWER = 104;
    public static final int PRIORITY_NO_POWER = 105;
    int mPriority;
    private final int mVersionCode;
    long zzaKP;
    long zzaLk;
    long zzaLl;
    int zzaLm;
    float zzaLn;
    long zzaLo;
    boolean zzayX;

    public LocationRequest() {
        this.mVersionCode = 1;
        this.mPriority = 102;
        this.zzaLk = 3600000;
        this.zzaLl = 600000;
        this.zzayX = false;
        this.zzaKP = Long.MAX_VALUE;
        this.zzaLm = Integer.MAX_VALUE;
        this.zzaLn = 0.0f;
        this.zzaLo = 0;
    }

    LocationRequest(int versionCode, int priority, long interval, long fastestInterval, boolean explicitFastestInterval, long expireAt, int numUpdates, float smallestDisplacement, long maxWaitTime) {
        this.mVersionCode = versionCode;
        this.mPriority = priority;
        this.zzaLk = interval;
        this.zzaLl = fastestInterval;
        this.zzayX = explicitFastestInterval;
        this.zzaKP = expireAt;
        this.zzaLm = numUpdates;
        this.zzaLn = smallestDisplacement;
        this.zzaLo = maxWaitTime;
    }

    public static LocationRequest create() {
        return new LocationRequest();
    }

    private static void zzL(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("invalid interval: " + j);
        }
    }

    private static void zzd(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("invalid displacement: " + f);
        }
    }

    private static void zzhj(int i) {
        switch (i) {
            case 100:
            case 102:
            case PRIORITY_LOW_POWER /*104*/:
            case PRIORITY_NO_POWER /*105*/:
                return;
            default:
                throw new IllegalArgumentException("invalid quality: " + i);
        }
    }

    public static String zzhk(int i) {
        switch (i) {
            case 100:
                return "PRIORITY_HIGH_ACCURACY";
            case 102:
                return "PRIORITY_BALANCED_POWER_ACCURACY";
            case PRIORITY_LOW_POWER /*104*/:
                return "PRIORITY_LOW_POWER";
            case PRIORITY_NO_POWER /*105*/:
                return "PRIORITY_NO_POWER";
            default:
                return "???";
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof LocationRequest)) {
            return false;
        }
        LocationRequest locationRequest = (LocationRequest) object;
        return this.mPriority == locationRequest.mPriority && this.zzaLk == locationRequest.zzaLk && this.zzaLl == locationRequest.zzaLl && this.zzayX == locationRequest.zzayX && this.zzaKP == locationRequest.zzaKP && this.zzaLm == locationRequest.zzaLm && this.zzaLn == locationRequest.zzaLn;
    }

    public long getExpirationTime() {
        return this.zzaKP;
    }

    public long getFastestInterval() {
        return this.zzaLl;
    }

    public long getInterval() {
        return this.zzaLk;
    }

    public long getMaxWaitTime() {
        long j = this.zzaLo;
        return j < this.zzaLk ? this.zzaLk : j;
    }

    public int getNumUpdates() {
        return this.zzaLm;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public float getSmallestDisplacement() {
        return this.zzaLn;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.mPriority), Long.valueOf(this.zzaLk), Long.valueOf(this.zzaLl), Boolean.valueOf(this.zzayX), Long.valueOf(this.zzaKP), Integer.valueOf(this.zzaLm), Float.valueOf(this.zzaLn));
    }

    public LocationRequest setExpirationDuration(long millis) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (millis > Long.MAX_VALUE - elapsedRealtime) {
            this.zzaKP = Long.MAX_VALUE;
        } else {
            this.zzaKP = elapsedRealtime + millis;
        }
        if (this.zzaKP < 0) {
            this.zzaKP = 0;
        }
        return this;
    }

    public LocationRequest setExpirationTime(long millis) {
        this.zzaKP = millis;
        if (this.zzaKP < 0) {
            this.zzaKP = 0;
        }
        return this;
    }

    public LocationRequest setFastestInterval(long millis) {
        zzL(millis);
        this.zzayX = true;
        this.zzaLl = millis;
        return this;
    }

    public LocationRequest setInterval(long millis) {
        zzL(millis);
        this.zzaLk = millis;
        if (!this.zzayX) {
            this.zzaLl = (long) (((double) this.zzaLk) / 6.0d);
        }
        return this;
    }

    public LocationRequest setMaxWaitTime(long millis) {
        zzL(millis);
        this.zzaLo = millis;
        return this;
    }

    public LocationRequest setNumUpdates(int numUpdates) {
        if (numUpdates <= 0) {
            throw new IllegalArgumentException("invalid numUpdates: " + numUpdates);
        }
        this.zzaLm = numUpdates;
        return this;
    }

    public LocationRequest setPriority(int priority) {
        zzhj(priority);
        this.mPriority = priority;
        return this;
    }

    public LocationRequest setSmallestDisplacement(float smallestDisplacementMeters) {
        zzd(smallestDisplacementMeters);
        this.zzaLn = smallestDisplacementMeters;
        return this;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Request[").append(zzhk(this.mPriority));
        if (this.mPriority != PRIORITY_NO_POWER) {
            stringBuilder.append(" requested=");
            stringBuilder.append(this.zzaLk).append("ms");
        }
        stringBuilder.append(" fastest=");
        stringBuilder.append(this.zzaLl).append("ms");
        if (this.zzaLo > this.zzaLk) {
            stringBuilder.append(" maxWait=");
            stringBuilder.append(this.zzaLo).append("ms");
        }
        if (this.zzaKP != Long.MAX_VALUE) {
            long elapsedRealtime = this.zzaKP - SystemClock.elapsedRealtime();
            stringBuilder.append(" expireIn=");
            stringBuilder.append(elapsedRealtime).append("ms");
        }
        if (this.zzaLm != Integer.MAX_VALUE) {
            stringBuilder.append(" num=").append(this.zzaLm);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        LocationRequestCreator.zza(this, parcel, flags);
    }
}
