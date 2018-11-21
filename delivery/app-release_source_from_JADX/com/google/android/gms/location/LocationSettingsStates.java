package com.google.android.gms.location;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzc;

public final class LocationSettingsStates implements SafeParcelable {
    public static final Creator<LocationSettingsStates> CREATOR = new zzh();
    private final int mVersionCode;
    private final boolean zzaLA;
    private final boolean zzaLv;
    private final boolean zzaLw;
    private final boolean zzaLx;
    private final boolean zzaLy;
    private final boolean zzaLz;

    LocationSettingsStates(int version, boolean gpsUsable, boolean nlpUsable, boolean bleUsable, boolean gpsPresent, boolean nlpPresent, boolean blePresent) {
        this.mVersionCode = version;
        this.zzaLv = gpsUsable;
        this.zzaLw = nlpUsable;
        this.zzaLx = bleUsable;
        this.zzaLy = gpsPresent;
        this.zzaLz = nlpPresent;
        this.zzaLA = blePresent;
    }

    public static LocationSettingsStates fromIntent(Intent intent) {
        return (LocationSettingsStates) zzc.zza(intent, "com.google.android.gms.location.LOCATION_SETTINGS_STATES", CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean isBlePresent() {
        return this.zzaLA;
    }

    public boolean isBleUsable() {
        return this.zzaLx;
    }

    public boolean isGpsPresent() {
        return this.zzaLy;
    }

    public boolean isGpsUsable() {
        return this.zzaLv;
    }

    public boolean isLocationPresent() {
        return this.zzaLy || this.zzaLz;
    }

    public boolean isLocationUsable() {
        return this.zzaLv || this.zzaLw;
    }

    public boolean isNetworkLocationPresent() {
        return this.zzaLz;
    }

    public boolean isNetworkLocationUsable() {
        return this.zzaLw;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzh.zza(this, dest, flags);
    }
}
