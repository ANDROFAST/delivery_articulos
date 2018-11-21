package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AutocompleteFilter implements SafeParcelable {
    public static final zzc CREATOR = new zzc();
    final int mVersionCode;
    final boolean zzaMs;
    final List<Integer> zzaMt;
    private final Set<Integer> zzaMu;

    AutocompleteFilter(int versionCode, boolean restrictToPlaces, Collection<Integer> placeTypes) {
        this.mVersionCode = versionCode;
        this.zzaMs = restrictToPlaces;
        this.zzaMt = placeTypes == null ? Collections.emptyList() : new ArrayList(placeTypes);
        if (this.zzaMt.isEmpty()) {
            this.zzaMu = Collections.emptySet();
        } else {
            this.zzaMu = Collections.unmodifiableSet(new HashSet(this.zzaMt));
        }
    }

    public static AutocompleteFilter create(Collection<Integer> placeTypes) {
        return zza(true, placeTypes);
    }

    public static AutocompleteFilter zza(boolean z, Collection<Integer> collection) {
        return new AutocompleteFilter(0, z, collection);
    }

    public int describeContents() {
        zzc com_google_android_gms_location_places_zzc = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof AutocompleteFilter)) {
            return false;
        }
        AutocompleteFilter autocompleteFilter = (AutocompleteFilter) object;
        return this.zzaMu.equals(autocompleteFilter.zzaMu) && this.zzaMs == autocompleteFilter.zzaMs;
    }

    public Set<Integer> getPlaceTypes() {
        return this.zzaMu;
    }

    public int hashCode() {
        return zzw.hashCode(Boolean.valueOf(this.zzaMs), this.zzaMu);
    }

    public String toString() {
        zza zzx = zzw.zzx(this);
        if (!this.zzaMs) {
            zzx.zzg("restrictedToPlaces", Boolean.valueOf(this.zzaMs));
        }
        zzx.zzg("placeTypes", this.zzaMu);
        return zzx.toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzc com_google_android_gms_location_places_zzc = CREATOR;
        zzc.zza(this, parcel, flags);
    }

    public boolean zzyl() {
        return this.zzaMs;
    }
}
