package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class CountrySpecification implements SafeParcelable {
    public static final Creator<CountrySpecification> CREATOR = new zza();
    private final int mVersionCode;
    String zzIE;

    CountrySpecification(int versionCode, String countryCode) {
        this.mVersionCode = versionCode;
        this.zzIE = countryCode;
    }

    public CountrySpecification(String countryCode) {
        this.mVersionCode = 1;
        this.zzIE = countryCode;
    }

    public int describeContents() {
        return 0;
    }

    public String getCountryCode() {
        return this.zzIE;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zza.zza(this, dest, flags);
    }
}
