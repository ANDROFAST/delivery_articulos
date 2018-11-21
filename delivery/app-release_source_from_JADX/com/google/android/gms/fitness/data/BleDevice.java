package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzok;
import java.util.Collections;
import java.util.List;

public class BleDevice implements SafeParcelable {
    public static final Creator<BleDevice> CREATOR = new zzb();
    private final String mName;
    private final int mVersionCode;
    private final String zzatX;
    private final List<String> zzatY;
    private final List<DataType> zzatZ;

    BleDevice(int versionCode, String address, String name, List<String> profiles, List<DataType> dataTypes) {
        this.mVersionCode = versionCode;
        this.zzatX = address;
        this.mName = name;
        this.zzatY = Collections.unmodifiableList(profiles);
        this.zzatZ = Collections.unmodifiableList(dataTypes);
    }

    private boolean zza(BleDevice bleDevice) {
        return this.mName.equals(bleDevice.mName) && this.zzatX.equals(bleDevice.zzatX) && zzok.zza(bleDevice.zzatY, this.zzatY) && zzok.zza(this.zzatZ, bleDevice.zzatZ);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof BleDevice) && zza((BleDevice) o));
    }

    public String getAddress() {
        return this.zzatX;
    }

    public List<DataType> getDataTypes() {
        return this.zzatZ;
    }

    public String getName() {
        return this.mName;
    }

    public List<String> getSupportedProfiles() {
        return this.zzatY;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.mName, this.zzatX, this.zzatY, this.zzatZ);
    }

    public String toString() {
        return zzw.zzx(this).zzg("name", this.mName).zzg("address", this.zzatX).zzg("dataTypes", this.zzatZ).zzg("supportedProfiles", this.zzatY).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzb.zza(this, parcel, flags);
    }
}
