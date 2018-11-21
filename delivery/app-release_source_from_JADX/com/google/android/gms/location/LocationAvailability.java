package com.google.android.gms.location;

import android.content.Intent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public final class LocationAvailability implements SafeParcelable {
    public static final LocationAvailabilityCreator CREATOR = new LocationAvailabilityCreator();
    private final int mVersionCode;
    int zzaLg;
    int zzaLh;
    long zzaLi;
    int zzaLj;

    LocationAvailability(int versionCode, int locationStatus, int cellStatus, int wifiStatus, long elapsedRealtimeNs) {
        this.mVersionCode = versionCode;
        this.zzaLj = locationStatus;
        this.zzaLg = cellStatus;
        this.zzaLh = wifiStatus;
        this.zzaLi = elapsedRealtimeNs;
    }

    public static LocationAvailability extractLocationAvailability(Intent intent) {
        return !hasLocationAvailability(intent) ? null : (LocationAvailability) intent.getExtras().getParcelable("com.google.android.gms.location.EXTRA_LOCATION_AVAILABILITY");
    }

    public static boolean hasLocationAvailability(Intent intent) {
        return intent == null ? false : intent.hasExtra("com.google.android.gms.location.EXTRA_LOCATION_AVAILABILITY");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (!(other instanceof LocationAvailability)) {
            return false;
        }
        LocationAvailability locationAvailability = (LocationAvailability) other;
        return this.zzaLj == locationAvailability.zzaLj && this.zzaLg == locationAvailability.zzaLg && this.zzaLh == locationAvailability.zzaLh && this.zzaLi == locationAvailability.zzaLi;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzaLj), Integer.valueOf(this.zzaLg), Integer.valueOf(this.zzaLh), Long.valueOf(this.zzaLi));
    }

    public boolean isLocationAvailable() {
        return this.zzaLj < 1000;
    }

    public String toString() {
        return "LocationAvailability[isLocationAvailable: " + isLocationAvailable() + "]";
    }

    public void writeToParcel(Parcel parcel, int flags) {
        LocationAvailabilityCreator.zza(this, parcel, flags);
    }
}
