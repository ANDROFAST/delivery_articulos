package com.google.android.gms.location;

import android.os.SystemClock;
import com.google.android.gms.location.internal.ParcelableGeofence;

public interface Geofence {
    public static final int GEOFENCE_TRANSITION_DWELL = 4;
    public static final int GEOFENCE_TRANSITION_ENTER = 1;
    public static final int GEOFENCE_TRANSITION_EXIT = 2;
    public static final long NEVER_EXPIRE = -1;

    public static final class Builder {
        private String zzDX = null;
        private int zzaKO = 0;
        private long zzaKP = Long.MIN_VALUE;
        private short zzaKQ = (short) -1;
        private double zzaKR;
        private double zzaKS;
        private float zzaKT;
        private int zzaKU = 0;
        private int zzaKV = -1;

        public Geofence build() {
            if (this.zzDX == null) {
                throw new IllegalArgumentException("Request ID not set.");
            } else if (this.zzaKO == 0) {
                throw new IllegalArgumentException("Transitions types not set.");
            } else if ((this.zzaKO & 4) != 0 && this.zzaKV < 0) {
                throw new IllegalArgumentException("Non-negative loitering delay needs to be set when transition types include GEOFENCE_TRANSITION_DWELLING.");
            } else if (this.zzaKP == Long.MIN_VALUE) {
                throw new IllegalArgumentException("Expiration not set.");
            } else if (this.zzaKQ == (short) -1) {
                throw new IllegalArgumentException("Geofence region not set.");
            } else if (this.zzaKU >= 0) {
                return new ParcelableGeofence(this.zzDX, this.zzaKO, (short) 1, this.zzaKR, this.zzaKS, this.zzaKT, this.zzaKP, this.zzaKU, this.zzaKV);
            } else {
                throw new IllegalArgumentException("Notification responsiveness should be nonnegative.");
            }
        }

        public Builder setCircularRegion(double latitude, double longitude, float radius) {
            this.zzaKQ = (short) 1;
            this.zzaKR = latitude;
            this.zzaKS = longitude;
            this.zzaKT = radius;
            return this;
        }

        public Builder setExpirationDuration(long durationMillis) {
            if (durationMillis < 0) {
                this.zzaKP = -1;
            } else {
                this.zzaKP = SystemClock.elapsedRealtime() + durationMillis;
            }
            return this;
        }

        public Builder setLoiteringDelay(int loiteringDelayMs) {
            this.zzaKV = loiteringDelayMs;
            return this;
        }

        public Builder setNotificationResponsiveness(int notificationResponsivenessMs) {
            this.zzaKU = notificationResponsivenessMs;
            return this;
        }

        public Builder setRequestId(String requestId) {
            this.zzDX = requestId;
            return this;
        }

        public Builder setTransitionTypes(int transitionTypes) {
            this.zzaKO = transitionTypes;
            return this;
        }
    }

    String getRequestId();
}
