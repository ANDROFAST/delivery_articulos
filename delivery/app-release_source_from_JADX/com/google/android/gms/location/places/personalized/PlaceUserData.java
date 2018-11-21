package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.List;

public class PlaceUserData implements SafeParcelable {
    public static final zze CREATOR = new zze();
    final int mVersionCode;
    private final String zzTD;
    private final String zzaMO;
    private final List<PlaceAlias> zzaOv;

    PlaceUserData(int versionCode, String accountName, String placeId, List<PlaceAlias> placeAliases) {
        this.mVersionCode = versionCode;
        this.zzTD = accountName;
        this.zzaMO = placeId;
        this.zzaOv = placeAliases;
    }

    public int describeContents() {
        zze com_google_android_gms_location_places_personalized_zze = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof PlaceUserData)) {
            return false;
        }
        PlaceUserData placeUserData = (PlaceUserData) object;
        return this.zzTD.equals(placeUserData.zzTD) && this.zzaMO.equals(placeUserData.zzaMO) && this.zzaOv.equals(placeUserData.zzaOv);
    }

    public String getPlaceId() {
        return this.zzaMO;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzTD, this.zzaMO, this.zzaOv);
    }

    public String toString() {
        return zzw.zzx(this).zzg("accountName", this.zzTD).zzg("placeId", this.zzaMO).zzg("placeAliases", this.zzaOv).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zze com_google_android_gms_location_places_personalized_zze = CREATOR;
        zze.zza(this, parcel, flags);
    }

    public String zzyQ() {
        return this.zzTD;
    }

    public List<PlaceAlias> zzyR() {
        return this.zzaOv;
    }
}
