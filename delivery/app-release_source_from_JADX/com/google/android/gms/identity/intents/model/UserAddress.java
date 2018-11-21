package com.google.android.gms.identity.intents.model;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.AddressConstants.Extras;

public final class UserAddress implements SafeParcelable {
    public static final Creator<UserAddress> CREATOR = new zzb();
    private final int mVersionCode;
    String name;
    String phoneNumber;
    String zzIE;
    String zzaJQ;
    String zzaJR;
    String zzaJS;
    String zzaJT;
    String zzaJU;
    String zzaJV;
    String zzaJW;
    String zzaJX;
    String zzaJY;
    boolean zzaJZ;
    String zzaKa;
    String zzaKb;

    UserAddress() {
        this.mVersionCode = 1;
    }

    UserAddress(int versionCode, String name, String address1, String address2, String address3, String address4, String address5, String administrativeArea, String locality, String countryCode, String postalCode, String sortingCode, String phoneNumber, boolean isPostBox, String companyName, String emailAddress) {
        this.mVersionCode = versionCode;
        this.name = name;
        this.zzaJQ = address1;
        this.zzaJR = address2;
        this.zzaJS = address3;
        this.zzaJT = address4;
        this.zzaJU = address5;
        this.zzaJV = administrativeArea;
        this.zzaJW = locality;
        this.zzIE = countryCode;
        this.zzaJX = postalCode;
        this.zzaJY = sortingCode;
        this.phoneNumber = phoneNumber;
        this.zzaJZ = isPostBox;
        this.zzaKa = companyName;
        this.zzaKb = emailAddress;
    }

    public static UserAddress fromIntent(Intent data) {
        return (data == null || !data.hasExtra(Extras.EXTRA_ADDRESS)) ? null : (UserAddress) data.getParcelableExtra(Extras.EXTRA_ADDRESS);
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

    public String getAddress4() {
        return this.zzaJT;
    }

    public String getAddress5() {
        return this.zzaJU;
    }

    public String getAdministrativeArea() {
        return this.zzaJV;
    }

    public String getCompanyName() {
        return this.zzaKa;
    }

    public String getCountryCode() {
        return this.zzIE;
    }

    public String getEmailAddress() {
        return this.zzaKb;
    }

    public String getLocality() {
        return this.zzaJW;
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

    public String getSortingCode() {
        return this.zzaJY;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean isPostBox() {
        return this.zzaJZ;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzb.zza(this, out, flags);
    }
}
