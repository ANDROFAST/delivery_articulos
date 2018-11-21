package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class NearbyAlertFilter extends zza implements SafeParcelable {
    public static final zzd CREATOR = new zzd();
    final int mVersionCode;
    final List<Integer> zzaMt;
    private final Set<Integer> zzaMu;
    final List<String> zzaMv;
    final List<UserDataType> zzaMw;
    private final Set<String> zzaMx;
    private final Set<UserDataType> zzaMy;

    NearbyAlertFilter(int versionCode, List<String> placeIdsList, List<Integer> placeTypesList, List<UserDataType> requestedUserDataTypesList) {
        this.mVersionCode = versionCode;
        this.zzaMt = placeTypesList == null ? Collections.emptyList() : Collections.unmodifiableList(placeTypesList);
        this.zzaMw = requestedUserDataTypesList == null ? Collections.emptyList() : Collections.unmodifiableList(requestedUserDataTypesList);
        this.zzaMv = placeIdsList == null ? Collections.emptyList() : Collections.unmodifiableList(placeIdsList);
        this.zzaMu = zza.zzu(this.zzaMt);
        this.zzaMy = zza.zzu(this.zzaMw);
        this.zzaMx = zza.zzu(this.zzaMv);
    }

    public static NearbyAlertFilter zzg(Collection<String> collection) {
        if (collection != null && !collection.isEmpty()) {
            return new NearbyAlertFilter(0, zza.zzf(collection), null, null);
        }
        throw new IllegalArgumentException("NearbyAlertFilters must contain at least oneplace ID to match results with.");
    }

    public static NearbyAlertFilter zzh(Collection<Integer> collection) {
        if (collection != null && !collection.isEmpty()) {
            return new NearbyAlertFilter(0, null, zza.zzf(collection), null);
        }
        throw new IllegalArgumentException("NearbyAlertFilters must contain at least oneplace type to match results with.");
    }

    public int describeContents() {
        zzd com_google_android_gms_location_places_zzd = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof NearbyAlertFilter)) {
            return false;
        }
        NearbyAlertFilter nearbyAlertFilter = (NearbyAlertFilter) object;
        return this.zzaMu.equals(nearbyAlertFilter.zzaMu) && this.zzaMy.equals(nearbyAlertFilter.zzaMy) && this.zzaMx.equals(nearbyAlertFilter.zzaMx);
    }

    public Set<String> getPlaceIds() {
        return this.zzaMx;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaMu, this.zzaMy, this.zzaMx);
    }

    public String toString() {
        zza zzx = zzw.zzx(this);
        if (!this.zzaMu.isEmpty()) {
            zzx.zzg("types", this.zzaMu);
        }
        if (!this.zzaMx.isEmpty()) {
            zzx.zzg("placeIds", this.zzaMx);
        }
        if (!this.zzaMy.isEmpty()) {
            zzx.zzg("requestedUserDataTypes", this.zzaMy);
        }
        return zzx.toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzd com_google_android_gms_location_places_zzd = CREATOR;
        zzd.zza(this, parcel, flags);
    }
}
