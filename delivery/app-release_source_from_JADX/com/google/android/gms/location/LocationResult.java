package com.google.android.gms.location;

import android.content.Intent;
import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class LocationResult implements SafeParcelable {
    public static final Creator<LocationResult> CREATOR = new zze();
    static final List<Location> zzaLp = Collections.emptyList();
    private final int mVersionCode;
    private final List<Location> zzaLq;

    LocationResult(int versionCode, List<Location> locations) {
        this.mVersionCode = versionCode;
        this.zzaLq = locations;
    }

    public static LocationResult create(List<Location> locations) {
        if (locations == null) {
            locations = zzaLp;
        }
        return new LocationResult(2, locations);
    }

    public static LocationResult extractResult(Intent intent) {
        return !hasResult(intent) ? null : (LocationResult) intent.getExtras().getParcelable("com.google.android.gms.location.EXTRA_LOCATION_RESULT");
    }

    public static boolean hasResult(Intent intent) {
        return intent == null ? false : intent.hasExtra("com.google.android.gms.location.EXTRA_LOCATION_RESULT");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (!(other instanceof LocationResult)) {
            return false;
        }
        LocationResult locationResult = (LocationResult) other;
        if (locationResult.zzaLq.size() != this.zzaLq.size()) {
            return false;
        }
        Iterator it = this.zzaLq.iterator();
        for (Location time : locationResult.zzaLq) {
            if (((Location) it.next()).getTime() != time.getTime()) {
                return false;
            }
        }
        return true;
    }

    public Location getLastLocation() {
        int size = this.zzaLq.size();
        return size == 0 ? null : (Location) this.zzaLq.get(size - 1);
    }

    public List<Location> getLocations() {
        return this.zzaLq;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        int i = 17;
        for (Location time : this.zzaLq) {
            long time2 = time.getTime();
            i = ((int) (time2 ^ (time2 >>> 32))) + (i * 31);
        }
        return i;
    }

    public String toString() {
        return "LocationResult[locations: " + this.zzaLq + "]";
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zze.zza(this, parcel, flags);
    }
}
