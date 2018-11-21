package com.google.android.gms.location.places;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AddPlaceRequest implements SafeParcelable {
    public static final Creator<AddPlaceRequest> CREATOR = new zzb();
    private final String mName;
    final int mVersionCode;
    private final LatLng zzaMo;
    private final List<Integer> zzaMp;
    private final String zzaMq;
    private final Uri zzaMr;
    private final String zzatX;

    AddPlaceRequest(int versionCode, String name, LatLng latLng, String address, List<Integer> placeTypes, String phoneNumber, Uri websiteUri) {
        boolean z = false;
        this.mVersionCode = versionCode;
        this.mName = zzx.zzcG(name);
        this.zzaMo = (LatLng) zzx.zzy(latLng);
        this.zzatX = zzx.zzcG(address);
        this.zzaMp = new ArrayList((Collection) zzx.zzy(placeTypes));
        zzx.zzb(!this.zzaMp.isEmpty(), (Object) "At least one place type should be provided.");
        if (!(TextUtils.isEmpty(phoneNumber) && websiteUri == null)) {
            z = true;
        }
        zzx.zzb(z, (Object) "One of phone number or URI should be provided.");
        this.zzaMq = phoneNumber;
        this.zzaMr = websiteUri;
    }

    public AddPlaceRequest(String name, LatLng latLng, String address, List<Integer> placeTypes, Uri uri) {
        this(name, latLng, address, placeTypes, null, (Uri) zzx.zzy(uri));
    }

    public AddPlaceRequest(String name, LatLng latLng, String address, List<Integer> placeTypes, String phoneNumber) {
        this(name, latLng, address, placeTypes, zzx.zzcG(phoneNumber), null);
    }

    public AddPlaceRequest(String name, LatLng latLng, String address, List<Integer> placeTypes, String phoneNumber, Uri uri) {
        this(0, name, latLng, address, placeTypes, phoneNumber, uri);
    }

    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.zzatX;
    }

    public LatLng getLatLng() {
        return this.zzaMo;
    }

    public String getName() {
        return this.mName;
    }

    public String getPhoneNumber() {
        return this.zzaMq;
    }

    public List<Integer> getPlaceTypes() {
        return this.zzaMp;
    }

    public Uri getWebsiteUri() {
        return this.zzaMr;
    }

    public String toString() {
        return zzw.zzx(this).zzg("name", this.mName).zzg("latLng", this.zzaMo).zzg("address", this.zzatX).zzg("placeTypes", this.zzaMp).zzg("phoneNumer", this.zzaMq).zzg("websiteUri", this.zzaMr).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzb.zza(this, parcel, flags);
    }
}
