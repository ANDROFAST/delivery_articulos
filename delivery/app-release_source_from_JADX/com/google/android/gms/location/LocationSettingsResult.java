package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LocationSettingsResult implements Result, SafeParcelable {
    public static final Creator<LocationSettingsResult> CREATOR = new zzg();
    private final int mVersionCode;
    private final Status zzTA;
    private final LocationSettingsStates zzaLu;

    LocationSettingsResult(int version, Status status, LocationSettingsStates states) {
        this.mVersionCode = version;
        this.zzTA = status;
        this.zzaLu = states;
    }

    public LocationSettingsResult(Status status) {
        this(1, status, null);
    }

    public int describeContents() {
        return 0;
    }

    public LocationSettingsStates getLocationSettingsStates() {
        return this.zzaLu;
    }

    public Status getStatus() {
        return this.zzTA;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzg.zza(this, dest, flags);
    }
}
