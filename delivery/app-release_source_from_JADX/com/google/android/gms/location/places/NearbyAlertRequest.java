package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public final class NearbyAlertRequest implements SafeParcelable {
    public static final zze CREATOR = new zze();
    private final int mVersionCode;
    private final int zzaKO;
    @Deprecated
    private final PlaceFilter zzaMA;
    private final NearbyAlertFilter zzaMB;
    private final boolean zzaMC;
    private final int zzaMD;
    private final int zzaMz;

    NearbyAlertRequest(int versionCode, int transitionTypes, int loiteringTimeMillis, PlaceFilter placeFilter, NearbyAlertFilter nearbyAlertFilter, boolean isDebugInfoRequested, int radiusType) {
        this.mVersionCode = versionCode;
        this.zzaKO = transitionTypes;
        this.zzaMz = loiteringTimeMillis;
        this.zzaMC = isDebugInfoRequested;
        if (nearbyAlertFilter != null) {
            this.zzaMB = nearbyAlertFilter;
        } else if (placeFilter == null) {
            this.zzaMB = null;
        } else if (placeFilter.getPlaceIds() != null && !placeFilter.getPlaceIds().isEmpty()) {
            this.zzaMB = NearbyAlertFilter.zzg(placeFilter.getPlaceIds());
        } else if (placeFilter.getPlaceTypes() == null || placeFilter.getPlaceTypes().isEmpty()) {
            this.zzaMB = null;
        } else {
            this.zzaMB = NearbyAlertFilter.zzh(placeFilter.getPlaceTypes());
        }
        this.zzaMA = null;
        this.zzaMD = radiusType;
    }

    public int describeContents() {
        zze com_google_android_gms_location_places_zze = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof NearbyAlertRequest)) {
            return false;
        }
        NearbyAlertRequest nearbyAlertRequest = (NearbyAlertRequest) object;
        return this.zzaKO == nearbyAlertRequest.zzaKO && this.zzaMz == nearbyAlertRequest.zzaMz && zzw.equal(this.zzaMA, nearbyAlertRequest.zzaMA) && zzw.equal(this.zzaMB, nearbyAlertRequest.zzaMB);
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzaKO), Integer.valueOf(this.zzaMz));
    }

    public String toString() {
        return zzw.zzx(this).zzg("transitionTypes", Integer.valueOf(this.zzaKO)).zzg("loiteringTimeMillis", Integer.valueOf(this.zzaMz)).zzg("nearbyAlertFilter", this.zzaMB).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zze com_google_android_gms_location_places_zze = CREATOR;
        zze.zza(this, parcel, flags);
    }

    public int zzyj() {
        return this.zzaKO;
    }

    public int zzym() {
        return this.zzaMz;
    }

    @Deprecated
    public PlaceFilter zzyn() {
        return null;
    }

    public NearbyAlertFilter zzyo() {
        return this.zzaMB;
    }

    public boolean zzyp() {
        return this.zzaMC;
    }

    public int zzyq() {
        return this.zzaMD;
    }
}
