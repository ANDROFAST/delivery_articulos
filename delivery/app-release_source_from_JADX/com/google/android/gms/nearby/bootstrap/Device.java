package com.google.android.gms.nearby.bootstrap;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public class Device implements SafeParcelable {
    public static final Creator<Device> CREATOR = new zzb();
    private final String description;
    private final String name;
    final int versionCode;
    private final String zzaVT;
    private final byte zzaVU;

    Device(int versionCode, String name, String description, String deviceId, byte deviceType) {
        this.versionCode = versionCode;
        this.name = zzx.zzcG(name);
        this.description = (String) zzx.zzy(description);
        this.zzaVT = (String) zzx.zzy(deviceId);
        zzx.zzb(deviceType <= (byte) 4, (Object) "Unknown device type");
        this.zzaVU = deviceType;
    }

    public int describeContents() {
        return 0;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDeviceId() {
        return this.zzaVT;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return this.name + ": " + this.description + "[" + this.zzaVU + "]";
    }

    public void writeToParcel(Parcel out, int flags) {
        zzb.zza(this, out, flags);
    }

    public byte zzCk() {
        return this.zzaVU;
    }
}
