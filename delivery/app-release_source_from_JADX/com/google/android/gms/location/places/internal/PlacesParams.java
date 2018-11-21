package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Locale;

public class PlacesParams implements SafeParcelable {
    public static final zzt CREATOR = new zzt();
    public static final PlacesParams zzaOl = new PlacesParams("com.google.android.gms", Locale.getDefault(), null);
    public final int versionCode;
    public final String zzaNb;
    public final String zzaOm;
    public final String zzaOn;
    public final String zzaOo;
    public final int zzaOp;
    public final int zzaOq;

    public PlacesParams(int versionCode, String clientPackageName, String localeString, String accountName, String gCoreClientName, int gCoreClientJarVersion, int requestSource) {
        this.versionCode = versionCode;
        this.zzaOm = clientPackageName;
        this.zzaOn = localeString;
        this.zzaOo = accountName;
        this.zzaNb = gCoreClientName;
        this.zzaOp = gCoreClientJarVersion;
        this.zzaOq = requestSource;
    }

    public PlacesParams(String clientPackageName, Locale locale, String accountName) {
        this(3, clientPackageName, locale.toString(), accountName, null, GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE, 0);
    }

    public PlacesParams(String clientPackageName, Locale locale, String accountName, String gCoreClientName, int requestSource) {
        this(3, clientPackageName, locale.toString(), accountName, gCoreClientName, GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE, requestSource);
    }

    public int describeContents() {
        zzt com_google_android_gms_location_places_internal_zzt = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || !(object instanceof PlacesParams)) {
            return false;
        }
        PlacesParams placesParams = (PlacesParams) object;
        return this.zzaOp == placesParams.zzaOp && this.zzaOq == placesParams.zzaOq && this.zzaOn.equals(placesParams.zzaOn) && this.zzaOm.equals(placesParams.zzaOm) && zzw.equal(this.zzaOo, placesParams.zzaOo) && zzw.equal(this.zzaNb, placesParams.zzaNb);
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaOm, this.zzaOn, this.zzaOo, this.zzaNb, Integer.valueOf(this.zzaOp), Integer.valueOf(this.zzaOq));
    }

    public String toString() {
        return zzw.zzx(this).zzg("clientPackageName", this.zzaOm).zzg("locale", this.zzaOn).zzg("accountName", this.zzaOo).zzg("gCoreClientName", this.zzaNb).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zzt com_google_android_gms_location_places_internal_zzt = CREATOR;
        zzt.zza(this, out, flags);
    }
}
