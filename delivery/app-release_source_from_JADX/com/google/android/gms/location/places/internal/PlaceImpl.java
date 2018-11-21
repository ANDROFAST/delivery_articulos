package com.google.android.gms.location.places.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public final class PlaceImpl implements SafeParcelable, Place {
    public static final zzl CREATOR = new zzl();
    private final String mName;
    final int mVersionCode;
    private final LatLng zzaMo;
    private final List<Integer> zzaMp;
    private final String zzaMq;
    private final Uri zzaMr;
    private final Bundle zzaND;
    @Deprecated
    private final PlaceLocalization zzaNE;
    private final float zzaNF;
    private final LatLngBounds zzaNG;
    private final String zzaNH;
    private final boolean zzaNI;
    private final float zzaNJ;
    private final int zzaNK;
    private final long zzaNL;
    private final List<Integer> zzaNM;
    private final String zzaNN;
    private final List<String> zzaNO;
    final boolean zzaNP;
    private final Map<Integer, String> zzaNQ;
    private final TimeZone zzaNR;
    private zzp zzaNS;
    private Locale zzaNy;
    private final String zzatX;
    private final String zzxX;

    public static class zza {
        private String mName;
        private int mVersionCode = 0;
        private LatLng zzaMo;
        private String zzaMq;
        private Uri zzaMr;
        private float zzaNF;
        private LatLngBounds zzaNG;
        private String zzaNH;
        private boolean zzaNI;
        private float zzaNJ;
        private int zzaNK;
        private long zzaNL;
        private String zzaNN;
        private List<String> zzaNO;
        private boolean zzaNP;
        private Bundle zzaNT;
        private List<Integer> zzaNU;
        private String zzatX;
        private String zzxX;

        public zza zza(LatLng latLng) {
            this.zzaMo = latLng;
            return this;
        }

        public zza zza(LatLngBounds latLngBounds) {
            this.zzaNG = latLngBounds;
            return this;
        }

        public zza zzaj(boolean z) {
            this.zzaNI = z;
            return this;
        }

        public zza zzak(boolean z) {
            this.zzaNP = z;
            return this;
        }

        public zza zzdX(String str) {
            this.zzxX = str;
            return this;
        }

        public zza zzdY(String str) {
            this.mName = str;
            return this;
        }

        public zza zzdZ(String str) {
            this.zzatX = str;
            return this;
        }

        public zza zzea(String str) {
            this.zzaMq = str;
            return this;
        }

        public zza zzf(float f) {
            this.zzaNF = f;
            return this;
        }

        public zza zzg(float f) {
            this.zzaNJ = f;
            return this;
        }

        public zza zzhM(int i) {
            this.zzaNK = i;
            return this;
        }

        public zza zzo(Uri uri) {
            this.zzaMr = uri;
            return this;
        }

        public zza zzv(List<Integer> list) {
            this.zzaNU = list;
            return this;
        }

        public zza zzw(List<String> list) {
            this.zzaNO = list;
            return this;
        }

        public PlaceImpl zzyL() {
            return new PlaceImpl(this.mVersionCode, this.zzxX, this.zzaNU, Collections.emptyList(), this.zzaNT, this.mName, this.zzatX, this.zzaMq, this.zzaNN, this.zzaNO, this.zzaMo, this.zzaNF, this.zzaNG, this.zzaNH, this.zzaMr, this.zzaNI, this.zzaNJ, this.zzaNK, this.zzaNL, this.zzaNP, PlaceLocalization.zza(this.mName, this.zzatX, this.zzaMq, this.zzaNN, this.zzaNO));
        }
    }

    PlaceImpl(int versionCode, String id, List<Integer> placeTypes, List<Integer> typesDeprecated, Bundle addressComponents, String name, String address, String phoneNumber, String regularOpenHours, List<String> attributions, LatLng latlng, float levelNumber, LatLngBounds viewport, String timeZoneId, Uri websiteUri, boolean isPermanentlyClosed, float rating, int priceLevel, long timestampSecs, boolean isLoggingEnabled, PlaceLocalization localization) {
        this.mVersionCode = versionCode;
        this.zzxX = id;
        this.zzaMp = Collections.unmodifiableList(placeTypes);
        this.zzaNM = typesDeprecated;
        if (addressComponents == null) {
            addressComponents = new Bundle();
        }
        this.zzaND = addressComponents;
        this.mName = name;
        this.zzatX = address;
        this.zzaMq = phoneNumber;
        this.zzaNN = regularOpenHours;
        if (attributions == null) {
            attributions = Collections.emptyList();
        }
        this.zzaNO = attributions;
        this.zzaMo = latlng;
        this.zzaNF = levelNumber;
        this.zzaNG = viewport;
        if (timeZoneId == null) {
            timeZoneId = "UTC";
        }
        this.zzaNH = timeZoneId;
        this.zzaMr = websiteUri;
        this.zzaNI = isPermanentlyClosed;
        this.zzaNJ = rating;
        this.zzaNK = priceLevel;
        this.zzaNL = timestampSecs;
        this.zzaNQ = Collections.unmodifiableMap(new HashMap());
        this.zzaNR = null;
        this.zzaNy = null;
        this.zzaNP = isLoggingEnabled;
        this.zzaNE = localization;
    }

    private void zzdW(String str) {
        if (this.zzaNP && this.zzaNS != null) {
            this.zzaNS.zzH(this.zzxX, str);
        }
    }

    public int describeContents() {
        zzl com_google_android_gms_location_places_internal_zzl = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof PlaceImpl)) {
            return false;
        }
        PlaceImpl placeImpl = (PlaceImpl) object;
        return this.zzxX.equals(placeImpl.zzxX) && zzw.equal(this.zzaNy, placeImpl.zzaNy) && this.zzaNL == placeImpl.zzaNL;
    }

    public /* synthetic */ Object freeze() {
        return zzyK();
    }

    public String getAddress() {
        zzdW("getAddress");
        return this.zzatX;
    }

    public String getId() {
        zzdW("getId");
        return this.zzxX;
    }

    public LatLng getLatLng() {
        zzdW("getLatLng");
        return this.zzaMo;
    }

    public Locale getLocale() {
        zzdW("getLocale");
        return this.zzaNy;
    }

    public String getName() {
        zzdW("getName");
        return this.mName;
    }

    public String getPhoneNumber() {
        zzdW("getPhoneNumber");
        return this.zzaMq;
    }

    public List<Integer> getPlaceTypes() {
        zzdW("getPlaceTypes");
        return this.zzaMp;
    }

    public int getPriceLevel() {
        zzdW("getPriceLevel");
        return this.zzaNK;
    }

    public float getRating() {
        zzdW("getRating");
        return this.zzaNJ;
    }

    public LatLngBounds getViewport() {
        zzdW("getViewport");
        return this.zzaNG;
    }

    public Uri getWebsiteUri() {
        zzdW("getWebsiteUri");
        return this.zzaMr;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzxX, this.zzaNy, Long.valueOf(this.zzaNL));
    }

    public boolean isDataValid() {
        return true;
    }

    public void setLocale(Locale locale) {
        this.zzaNy = locale;
    }

    public String toString() {
        return zzw.zzx(this).zzg("id", this.zzxX).zzg("placeTypes", this.zzaMp).zzg("locale", this.zzaNy).zzg("name", this.mName).zzg("address", this.zzatX).zzg("phoneNumber", this.zzaMq).zzg("latlng", this.zzaMo).zzg("viewport", this.zzaNG).zzg("websiteUri", this.zzaMr).zzg("isPermanentlyClosed", Boolean.valueOf(this.zzaNI)).zzg("priceLevel", Integer.valueOf(this.zzaNK)).zzg("timestampSecs", Long.valueOf(this.zzaNL)).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzl com_google_android_gms_location_places_internal_zzl = CREATOR;
        zzl.zza(this, parcel, flags);
    }

    public void zza(zzp com_google_android_gms_location_places_internal_zzp) {
        this.zzaNS = com_google_android_gms_location_places_internal_zzp;
    }

    public List<Integer> zzyB() {
        zzdW("getTypesDeprecated");
        return this.zzaNM;
    }

    public float zzyC() {
        zzdW("getLevelNumber");
        return this.zzaNF;
    }

    public String zzyD() {
        zzdW("getRegularOpenHours");
        return this.zzaNN;
    }

    public List<String> zzyE() {
        zzdW("getAttributions");
        return this.zzaNO;
    }

    public boolean zzyF() {
        zzdW("isPermanentlyClosed");
        return this.zzaNI;
    }

    public long zzyG() {
        return this.zzaNL;
    }

    public Bundle zzyH() {
        return this.zzaND;
    }

    public String zzyI() {
        return this.zzaNH;
    }

    @Deprecated
    public PlaceLocalization zzyJ() {
        zzdW("getLocalization");
        return this.zzaNE;
    }

    public Place zzyK() {
        return this;
    }
}
