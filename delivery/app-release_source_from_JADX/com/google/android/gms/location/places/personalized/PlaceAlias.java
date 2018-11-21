package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class PlaceAlias implements SafeParcelable {
    public static final zzb CREATOR = new zzb();
    public static final PlaceAlias zzaOr = new PlaceAlias(0, "Home");
    public static final PlaceAlias zzaOs = new PlaceAlias(0, "Work");
    final int mVersionCode;
    private final String zzaOt;

    PlaceAlias(int versionCode, String alias) {
        this.mVersionCode = versionCode;
        this.zzaOt = alias;
    }

    public int describeContents() {
        zzb com_google_android_gms_location_places_personalized_zzb = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof PlaceAlias)) {
            return false;
        }
        return zzw.equal(this.zzaOt, ((PlaceAlias) object).zzaOt);
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaOt);
    }

    public String toString() {
        return zzw.zzx(this).zzg("alias", this.zzaOt).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzb com_google_android_gms_location_places_personalized_zzb = CREATOR;
        zzb.zza(this, parcel, flags);
    }

    public String zzyO() {
        return this.zzaOt;
    }
}
