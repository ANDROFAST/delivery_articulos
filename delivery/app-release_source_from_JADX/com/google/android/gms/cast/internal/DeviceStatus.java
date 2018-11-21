package com.google.android.gms.cast.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class DeviceStatus implements SafeParcelable {
    public static final Creator<DeviceStatus> CREATOR = new zzg();
    private final int mVersionCode;
    private double zzZL;
    private boolean zzZM;
    private int zzabZ;
    private int zzaca;
    private ApplicationMetadata zzack;

    public DeviceStatus() {
        this(3, Double.NaN, false, -1, null, -1);
    }

    DeviceStatus(int versionCode, double volume, boolean muteState, int activeInputState, ApplicationMetadata applicationMetadata, int standbyState) {
        this.mVersionCode = versionCode;
        this.zzZL = volume;
        this.zzZM = muteState;
        this.zzabZ = activeInputState;
        this.zzack = applicationMetadata;
        this.zzaca = standbyState;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DeviceStatus)) {
            return false;
        }
        DeviceStatus deviceStatus = (DeviceStatus) obj;
        return this.zzZL == deviceStatus.zzZL && this.zzZM == deviceStatus.zzZM && this.zzabZ == deviceStatus.zzabZ && zzf.zza(this.zzack, deviceStatus.zzack) && this.zzaca == deviceStatus.zzaca;
    }

    public ApplicationMetadata getApplicationMetadata() {
        return this.zzack;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Double.valueOf(this.zzZL), Boolean.valueOf(this.zzZM), Integer.valueOf(this.zzabZ), this.zzack, Integer.valueOf(this.zzaca));
    }

    public void writeToParcel(Parcel out, int flags) {
        zzg.zza(this, out, flags);
    }

    public double zznS() {
        return this.zzZL;
    }

    public int zznT() {
        return this.zzabZ;
    }

    public int zznU() {
        return this.zzaca;
    }

    public boolean zzob() {
        return this.zzZM;
    }
}
