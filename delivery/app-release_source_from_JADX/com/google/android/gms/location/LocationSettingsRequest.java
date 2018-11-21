package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class LocationSettingsRequest implements SafeParcelable {
    public static final Creator<LocationSettingsRequest> CREATOR = new zzf();
    private final int mVersionCode;
    private final boolean zzaLr;
    private final boolean zzaLs;
    private final List<LocationRequest> zzayS;

    public static final class Builder {
        private boolean zzaLr = false;
        private boolean zzaLs = false;
        private final ArrayList<LocationRequest> zzaLt = new ArrayList();

        public Builder addAllLocationRequests(Collection<LocationRequest> requests) {
            this.zzaLt.addAll(requests);
            return this;
        }

        public Builder addLocationRequest(LocationRequest request) {
            this.zzaLt.add(request);
            return this;
        }

        public LocationSettingsRequest build() {
            return new LocationSettingsRequest(this.zzaLt, this.zzaLr, this.zzaLs);
        }

        public Builder setAlwaysShow(boolean show) {
            this.zzaLr = show;
            return this;
        }

        public Builder setNeedBle(boolean needBle) {
            this.zzaLs = needBle;
            return this;
        }
    }

    LocationSettingsRequest(int version, List<LocationRequest> locationRequests, boolean alwaysShow, boolean needBle) {
        this.mVersionCode = version;
        this.zzayS = locationRequests;
        this.zzaLr = alwaysShow;
        this.zzaLs = needBle;
    }

    private LocationSettingsRequest(List<LocationRequest> locationRequests, boolean alwaysShow, boolean needBle) {
        this(3, (List) locationRequests, alwaysShow, needBle);
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzf.zza(this, dest, flags);
    }

    public List<LocationRequest> zzux() {
        return Collections.unmodifiableList(this.zzayS);
    }

    public boolean zzxY() {
        return this.zzaLr;
    }

    public boolean zzxZ() {
        return this.zzaLs;
    }
}
