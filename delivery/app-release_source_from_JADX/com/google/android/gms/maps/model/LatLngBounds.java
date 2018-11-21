package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public final class LatLngBounds implements SafeParcelable {
    public static final zzd CREATOR = new zzd();
    private final int mVersionCode;
    public final LatLng northeast;
    public final LatLng southwest;

    public static final class Builder {
        private double zzaQw = MediaQueueItem.DEFAULT_PLAYBACK_DURATION;
        private double zzaQx = Double.NEGATIVE_INFINITY;
        private double zzaQy = Double.NaN;
        private double zzaQz = Double.NaN;

        private boolean zzj(double d) {
            boolean z = false;
            if (this.zzaQy <= this.zzaQz) {
                return this.zzaQy <= d && d <= this.zzaQz;
            } else {
                if (this.zzaQy <= d || d <= this.zzaQz) {
                    z = true;
                }
                return z;
            }
        }

        public LatLngBounds build() {
            zzx.zza(!Double.isNaN(this.zzaQy), (Object) "no included points");
            return new LatLngBounds(new LatLng(this.zzaQw, this.zzaQy), new LatLng(this.zzaQx, this.zzaQz));
        }

        public Builder include(LatLng point) {
            this.zzaQw = Math.min(this.zzaQw, point.latitude);
            this.zzaQx = Math.max(this.zzaQx, point.latitude);
            double d = point.longitude;
            if (Double.isNaN(this.zzaQy)) {
                this.zzaQy = d;
                this.zzaQz = d;
            } else if (!zzj(d)) {
                if (LatLngBounds.zzb(this.zzaQy, d) < LatLngBounds.zzc(this.zzaQz, d)) {
                    this.zzaQy = d;
                } else {
                    this.zzaQz = d;
                }
            }
            return this;
        }
    }

    LatLngBounds(int versionCode, LatLng southwest, LatLng northeast) {
        zzx.zzb((Object) southwest, (Object) "null southwest");
        zzx.zzb((Object) northeast, (Object) "null northeast");
        zzx.zzb(northeast.latitude >= southwest.latitude, "southern latitude exceeds northern latitude (%s > %s)", Double.valueOf(southwest.latitude), Double.valueOf(northeast.latitude));
        this.mVersionCode = versionCode;
        this.southwest = southwest;
        this.northeast = northeast;
    }

    public LatLngBounds(LatLng southwest, LatLng northeast) {
        this(1, southwest, northeast);
    }

    public static Builder builder() {
        return new Builder();
    }

    private static double zzb(double d, double d2) {
        return ((d - d2) + 360.0d) % 360.0d;
    }

    private static double zzc(double d, double d2) {
        return ((d2 - d) + 360.0d) % 360.0d;
    }

    private boolean zzi(double d) {
        return this.southwest.latitude <= d && d <= this.northeast.latitude;
    }

    private boolean zzj(double d) {
        boolean z = false;
        if (this.southwest.longitude <= this.northeast.longitude) {
            return this.southwest.longitude <= d && d <= this.northeast.longitude;
        } else {
            if (this.southwest.longitude <= d || d <= this.northeast.longitude) {
                z = true;
            }
            return z;
        }
    }

    public boolean contains(LatLng point) {
        return zzi(point.latitude) && zzj(point.longitude);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) o;
        return this.southwest.equals(latLngBounds.southwest) && this.northeast.equals(latLngBounds.northeast);
    }

    public LatLng getCenter() {
        double d = (this.southwest.latitude + this.northeast.latitude) / 2.0d;
        double d2 = this.northeast.longitude;
        double d3 = this.southwest.longitude;
        return new LatLng(d, d3 <= d2 ? (d2 + d3) / 2.0d : ((d2 + 360.0d) + d3) / 2.0d);
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.southwest, this.northeast);
    }

    public LatLngBounds including(LatLng point) {
        double min = Math.min(this.southwest.latitude, point.latitude);
        double max = Math.max(this.northeast.latitude, point.latitude);
        double d = this.northeast.longitude;
        double d2 = this.southwest.longitude;
        double d3 = point.longitude;
        if (zzj(d3)) {
            d3 = d2;
            d2 = d;
        } else if (zzb(d2, d3) < zzc(d, d3)) {
            d2 = d;
        } else {
            double d4 = d2;
            d2 = d3;
            d3 = d4;
        }
        return new LatLngBounds(new LatLng(min, d3), new LatLng(max, d2));
    }

    public String toString() {
        return zzw.zzx(this).zzg("southwest", this.southwest).zzg("northeast", this.northeast).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zzd.zza(this, out, flags);
    }
}
