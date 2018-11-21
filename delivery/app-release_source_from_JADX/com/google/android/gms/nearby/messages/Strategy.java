package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.List;

public class Strategy implements SafeParcelable {
    public static final Strategy BLE_ONLY = new Builder().zziU(2).setTtlSeconds(Integer.MAX_VALUE).build();
    public static final Creator<Strategy> CREATOR = new zzd();
    public static final Strategy DEFAULT = new Builder().build();
    public static final int DISCOVERY_MODE_BROADCAST = 1;
    public static final int DISCOVERY_MODE_DEFAULT = 3;
    public static final int DISCOVERY_MODE_SCAN = 2;
    public static final int DISTANCE_TYPE_DEFAULT = 0;
    public static final int DISTANCE_TYPE_EARSHOT = 1;
    public static final int TTL_SECONDS_DEFAULT = 300;
    public static final int TTL_SECONDS_INFINITE = Integer.MAX_VALUE;
    public static final int TTL_SECONDS_MAX = 86400;
    @Deprecated
    public static final Strategy zzaWN = BLE_ONLY;
    final int mVersionCode;
    @Deprecated
    final int zzaWO;
    final int zzaWP;
    final int zzaWQ;
    @Deprecated
    final boolean zzaWR;
    final int zzaWS;
    final int zzaWT;

    public static class Builder {
        private int zzaWU = 3;
        private int zzaWV = Strategy.TTL_SECONDS_DEFAULT;
        private int zzaWW = 0;
        private int zzaWX = 6;

        public Strategy build() {
            if (this.zzaWX == 2 && this.zzaWW == 1) {
                throw new IllegalStateException("Cannot set EARSHOT with BLE only mode.");
            }
            return new Strategy(2, 0, this.zzaWV, this.zzaWW, false, this.zzaWX, this.zzaWU);
        }

        public Builder setDiscoveryMode(int discoveryMode) {
            this.zzaWU = discoveryMode;
            return this;
        }

        public Builder setDistanceType(int distanceType) {
            this.zzaWW = distanceType;
            return this;
        }

        public Builder setTtlSeconds(int ttlSeconds) {
            boolean z = ttlSeconds == Integer.MAX_VALUE || (ttlSeconds > 0 && ttlSeconds <= Strategy.TTL_SECONDS_MAX);
            zzx.zzb(z, "mTtlSeconds(%d) must either be TTL_SECONDS_INFINITE, or it must be between 1 and TTL_SECONDS_MAX(%d) inclusive", Integer.valueOf(ttlSeconds), Integer.valueOf(Strategy.TTL_SECONDS_MAX));
            this.zzaWV = ttlSeconds;
            return this;
        }

        public Builder zziU(int i) {
            this.zzaWX = i;
            return this;
        }
    }

    Strategy(int versionCode, int broadcastScanStrategy, int ttlSeconds, int distanceType, boolean isBleBeaconStrategy, int discoveryMedium, int discoveryMode) {
        this.mVersionCode = versionCode;
        this.zzaWO = broadcastScanStrategy;
        if (broadcastScanStrategy != 0) {
            switch (broadcastScanStrategy) {
                case 2:
                    this.zzaWT = 1;
                    break;
                case 3:
                    this.zzaWT = 2;
                    break;
                default:
                    this.zzaWT = 3;
                    break;
            }
        }
        this.zzaWT = discoveryMode;
        this.zzaWQ = distanceType;
        this.zzaWR = isBleBeaconStrategy;
        if (isBleBeaconStrategy) {
            this.zzaWS = 2;
            this.zzaWP = Integer.MAX_VALUE;
        } else if (discoveryMedium == 0) {
            this.zzaWS = 6;
            this.zzaWP = ttlSeconds;
        } else {
            this.zzaWS = discoveryMedium;
            this.zzaWP = ttlSeconds;
        }
    }

    private static String zziR(int i) {
        switch (i) {
            case 0:
                return "DEFAULT";
            case 1:
                return "EARSHOT";
            default:
                return "UNKNOWN";
        }
    }

    private static String zziS(int i) {
        if (i == 6) {
            return "DEFAULT";
        }
        List arrayList = new ArrayList();
        if ((i & 4) > 0) {
            arrayList.add("AUDIO");
        }
        if ((i & 2) > 0) {
            arrayList.add("BLE");
        }
        return arrayList.toString();
    }

    private static String zziT(int i) {
        if (i == 3) {
            return "DEFAULT";
        }
        List arrayList = new ArrayList();
        if ((i & 1) > 0) {
            arrayList.add("BROADCAST");
        }
        if ((i & 2) > 0) {
            arrayList.add("SCAN");
        }
        return arrayList.toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Strategy)) {
            return false;
        }
        Strategy strategy = (Strategy) other;
        return this.mVersionCode == strategy.mVersionCode && this.zzaWT == strategy.zzaWT && this.zzaWP == strategy.zzaWP && this.zzaWQ == strategy.zzaWQ && this.zzaWS == strategy.zzaWS;
    }

    public int hashCode() {
        return (((((((this.mVersionCode * 31) + this.zzaWT) * 31) + this.zzaWP) * 31) + this.zzaWQ) * 31) + this.zzaWS;
    }

    public String toString() {
        return "Strategy{ttlSeconds=" + this.zzaWP + ", distanceType=" + zziR(this.zzaWQ) + ", discoveryMedium=" + zziS(this.zzaWS) + ", discoveryMode=" + zziT(this.zzaWT) + '}';
    }

    public void writeToParcel(Parcel out, int flags) {
        zzd.zza(this, out, flags);
    }

    public int zzCA() {
        return this.zzaWS;
    }

    public int zzCB() {
        return this.zzaWT;
    }
}
