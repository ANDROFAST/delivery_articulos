package com.google.android.gms.nearby.messages.devices;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class NearbyDevice implements SafeParcelable {
    public static final Creator<NearbyDevice> CREATOR = new zzf();
    public static final NearbyDevice zzaXe = new NearbyDevice(NearbyDeviceId.zzaXj);
    final int mVersionCode;
    private final String zzF;
    private final NearbyDeviceId zzaXf;

    NearbyDevice(int versionCode, NearbyDeviceId id, String url) {
        this.mVersionCode = versionCode;
        this.zzaXf = id;
        this.zzF = url;
    }

    public NearbyDevice(NearbyDeviceId id) {
        this(1, id, null);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NearbyDevice)) {
            return false;
        }
        NearbyDevice nearbyDevice = (NearbyDevice) o;
        return zzw.equal(this.zzaXf, nearbyDevice.zzaXf) && zzw.equal(this.zzF, nearbyDevice.zzF);
    }

    public String getUrl() {
        return this.zzF;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaXf, this.zzF);
    }

    public String toString() {
        return "NearbyDevice{id=" + this.zzaXf + "url=" + this.zzF + "}";
    }

    public void writeToParcel(Parcel out, int flags) {
        zzf.zza(this, out, flags);
    }

    public NearbyDeviceId zzCI() {
        return this.zzaXf;
    }
}
