package com.google.android.gms.nearby.messages.devices;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class NearbyDeviceFilter implements SafeParcelable {
    public static final Creator<NearbyDeviceFilter> CREATOR = new zzg();
    final int mVersionCode;
    final int zzaXg;
    final byte[] zzaXh;
    final boolean zzaXi;

    NearbyDeviceFilter(int versionCode, int idPrefixType, byte[] idPrefix, boolean shouldMatchUrls) {
        this.mVersionCode = versionCode;
        this.zzaXg = idPrefixType;
        this.zzaXh = idPrefix;
        this.zzaXi = shouldMatchUrls;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzg.zza(this, out, flags);
    }
}
