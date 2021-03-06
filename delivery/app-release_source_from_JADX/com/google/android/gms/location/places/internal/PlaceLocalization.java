package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.List;

@Deprecated
public final class PlaceLocalization implements SafeParcelable {
    public static final zzo CREATOR = new zzo();
    public final String address;
    public final String name;
    public final int versionCode;
    public final String zzaNX;
    public final String zzaNY;
    public final List<String> zzaNZ;

    public PlaceLocalization(int versionCode, String name, String address, String internationalPhoneNumber, String regularOpenHours, List<String> attributions) {
        this.versionCode = versionCode;
        this.name = name;
        this.address = address;
        this.zzaNX = internationalPhoneNumber;
        this.zzaNY = regularOpenHours;
        this.zzaNZ = attributions;
    }

    public static PlaceLocalization zza(String str, String str2, String str3, String str4, List<String> list) {
        return new PlaceLocalization(0, str, str2, str3, str4, list);
    }

    public int describeContents() {
        zzo com_google_android_gms_location_places_internal_zzo = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof PlaceLocalization)) {
            return false;
        }
        PlaceLocalization placeLocalization = (PlaceLocalization) object;
        return zzw.equal(this.name, placeLocalization.name) && zzw.equal(this.address, placeLocalization.address) && zzw.equal(this.zzaNX, placeLocalization.zzaNX) && zzw.equal(this.zzaNY, placeLocalization.zzaNY) && zzw.equal(this.zzaNZ, placeLocalization.zzaNZ);
    }

    public int hashCode() {
        return zzw.hashCode(this.name, this.address, this.zzaNX, this.zzaNY);
    }

    public String toString() {
        return zzw.zzx(this).zzg("name", this.name).zzg("address", this.address).zzg("internationalPhoneNumber", this.zzaNX).zzg("regularOpenHours", this.zzaNY).zzg("attributions", this.zzaNZ).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzo com_google_android_gms_location_places_internal_zzo = CREATOR;
        zzo.zza(this, parcel, flags);
    }
}
