package com.google.android.gms.nearby.messages.devices;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class NearbyDeviceId implements SafeParcelable {
    public static final Creator<NearbyDeviceId> CREATOR = new zzh();
    public static final NearbyDeviceId zzaXj = new NearbyDeviceId();
    final int mVersionCode;
    private final int zzZU;
    final byte[] zzaXb;
    private final zzb zzaXk;
    private final zzd zzaXl;

    private NearbyDeviceId() {
        this(1, 1, null);
    }

    NearbyDeviceId(int versionCode, int type, byte[] bytes) {
        zzd com_google_android_gms_nearby_messages_devices_zzd = null;
        this.mVersionCode = versionCode;
        this.zzZU = type;
        this.zzaXb = bytes;
        this.zzaXk = type == 2 ? new zzb(bytes) : null;
        if (type == 3) {
            com_google_android_gms_nearby_messages_devices_zzd = new zzd(bytes);
        }
        this.zzaXl = com_google_android_gms_nearby_messages_devices_zzd;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NearbyDeviceId)) {
            return false;
        }
        NearbyDeviceId nearbyDeviceId = (NearbyDeviceId) o;
        return zzw.equal(Integer.valueOf(this.zzZU), Integer.valueOf(nearbyDeviceId.zzZU)) && zzw.equal(this.zzaXb, nearbyDeviceId.zzaXb);
    }

    public int getType() {
        return this.zzZU;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzZU), this.zzaXb);
    }

    public String toString() {
        StringBuilder append = new StringBuilder().append("NearbyDeviceId{");
        switch (this.zzZU) {
            case 1:
                append.append("UNKNOWN");
                break;
            case 2:
                append.append("eddystoneUid=").append(this.zzaXk);
                break;
            case 3:
                append.append("iBeaconId=").append(this.zzaXl);
                break;
        }
        append.append("}");
        return append.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zzh.zza(this, out, flags);
    }
}
