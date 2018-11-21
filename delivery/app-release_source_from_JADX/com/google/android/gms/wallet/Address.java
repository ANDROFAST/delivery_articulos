package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@Deprecated
public final class Address implements SafeParcelable {
    public static final Creator<Address> CREATOR = new zza();
    private final int mVersionCode;
    String name;
    String phoneNumber;
    String zzIE;
    String zzaJQ;
    String zzaJR;
    String zzaJS;
    String zzaJX;
    boolean zzaJZ;
    String zzaKa;
    String zzbiX;
    String zzbiY;

    Address() {
        this.mVersionCode = 1;
    }

    Address(int versionCode, String name, String address1, String address2, String address3, String countryCode, String city, String state, String postalCode, String phoneNumber, boolean isPostBox, String companyName) {
        this.mVersionCode = versionCode;
        this.name = name;
        this.zzaJQ = address1;
        this.zzaJR = address2;
        this.zzaJS = address3;
        this.zzIE = countryCode;
        this.zzbiX = city;
        this.zzbiY = state;
        this.zzaJX = postalCode;
        this.phoneNumber = phoneNumber;
        this.zzaJZ = isPostBox;
        this.zzaKa = companyName;
    }

    public int describeContents() {
        return 0;
    }

    public String getAddress1() {
        return this.zzaJQ;
    }

    public String getAddress2() {
        return this.zzaJR;
    }

    public String getAddress3() {
        return this.zzaJS;
    }

    public String getCity() {
        return this.zzbiX;
    }

    public String getCompanyName() {
        return this.zzaKa;
    }

    public String getCountryCode() {
        return this.zzIE;
    }

    public String getName() {
        return this.name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getPostalCode() {
        return this.zzaJX;
    }

    public String getState() {
        return this.zzbiY;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean isPostBox() {
        return this.zzaJZ;
    }

    public void writeToParcel(Parcel out, int flags) {
        zza.zza(this, out, flags);
    }
}
