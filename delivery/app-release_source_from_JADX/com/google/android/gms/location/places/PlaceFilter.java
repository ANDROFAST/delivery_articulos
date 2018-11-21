package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class PlaceFilter extends zza implements SafeParcelable {
    public static final zzg CREATOR = new zzg();
    final int mVersionCode;
    final boolean zzaMH;
    final List<Integer> zzaMt;
    private final Set<Integer> zzaMu;
    final List<String> zzaMv;
    final List<UserDataType> zzaMw;
    private final Set<String> zzaMx;
    private final Set<UserDataType> zzaMy;

    @Deprecated
    public static final class zza {
        private boolean zzaMH;
        private Collection<Integer> zzaMI;
        private Collection<UserDataType> zzaMJ;
        private String[] zzaMK;

        private zza() {
            this.zzaMI = null;
            this.zzaMH = false;
            this.zzaMJ = null;
            this.zzaMK = null;
        }

        public PlaceFilter zzys() {
            Collection collection = null;
            Collection arrayList = this.zzaMI != null ? new ArrayList(this.zzaMI) : null;
            Collection arrayList2 = this.zzaMJ != null ? new ArrayList(this.zzaMJ) : null;
            if (this.zzaMK != null) {
                collection = Arrays.asList(this.zzaMK);
            }
            return new PlaceFilter(arrayList, this.zzaMH, collection, arrayList2);
        }
    }

    public PlaceFilter() {
        this(false, null);
    }

    PlaceFilter(int versionCode, List<Integer> placeTypesList, boolean requireOpenNow, List<String> placeIdsList, List<UserDataType> requestedUserDataTypesList) {
        this.mVersionCode = versionCode;
        this.zzaMt = placeTypesList == null ? Collections.emptyList() : Collections.unmodifiableList(placeTypesList);
        this.zzaMH = requireOpenNow;
        this.zzaMw = requestedUserDataTypesList == null ? Collections.emptyList() : Collections.unmodifiableList(requestedUserDataTypesList);
        this.zzaMv = placeIdsList == null ? Collections.emptyList() : Collections.unmodifiableList(placeIdsList);
        this.zzaMu = zza.zzu(this.zzaMt);
        this.zzaMy = zza.zzu(this.zzaMw);
        this.zzaMx = zza.zzu(this.zzaMv);
    }

    public PlaceFilter(Collection<Integer> restrictToPlaceTypes, boolean requireOpenNow, Collection<String> restrictToPlaceIds, Collection<UserDataType> requestedUserDataTypes) {
        this(0, zza.zzf(restrictToPlaceTypes), requireOpenNow, zza.zzf(restrictToPlaceIds), zza.zzf(requestedUserDataTypes));
    }

    public PlaceFilter(boolean requireOpenNow, Collection<String> restrictToPlaceIds) {
        this(null, requireOpenNow, restrictToPlaceIds, null);
    }

    @Deprecated
    public static PlaceFilter zzyr() {
        return new zza().zzys();
    }

    public int describeContents() {
        zzg com_google_android_gms_location_places_zzg = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof PlaceFilter)) {
            return false;
        }
        PlaceFilter placeFilter = (PlaceFilter) object;
        return this.zzaMu.equals(placeFilter.zzaMu) && this.zzaMH == placeFilter.zzaMH && this.zzaMy.equals(placeFilter.zzaMy) && this.zzaMx.equals(placeFilter.zzaMx);
    }

    public Set<String> getPlaceIds() {
        return this.zzaMx;
    }

    public Set<Integer> getPlaceTypes() {
        return this.zzaMu;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaMu, Boolean.valueOf(this.zzaMH), this.zzaMy, this.zzaMx);
    }

    public boolean isRestrictedToPlacesOpenNow() {
        return this.zzaMH;
    }

    public String toString() {
        com.google.android.gms.common.internal.zzw.zza zzx = zzw.zzx(this);
        if (!this.zzaMu.isEmpty()) {
            zzx.zzg("types", this.zzaMu);
        }
        zzx.zzg("requireOpenNow", Boolean.valueOf(this.zzaMH));
        if (!this.zzaMx.isEmpty()) {
            zzx.zzg("placeIds", this.zzaMx);
        }
        if (!this.zzaMy.isEmpty()) {
            zzx.zzg("requestedUserDataTypes", this.zzaMy);
        }
        return zzx.toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzg com_google_android_gms_location_places_zzg = CREATOR;
        zzg.zza(this, parcel, flags);
    }
}
