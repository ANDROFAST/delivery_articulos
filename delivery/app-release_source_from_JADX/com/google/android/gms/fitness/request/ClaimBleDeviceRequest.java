package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.internal.zzpp;
import com.google.android.gms.internal.zzpp.zza;

public class ClaimBleDeviceRequest implements SafeParcelable {
    public static final Creator<ClaimBleDeviceRequest> CREATOR = new zzb();
    private final int mVersionCode;
    private final String zzayh;
    private final BleDevice zzayi;
    private final zzpp zzayj;

    ClaimBleDeviceRequest(int versionCode, String deviceAddress, BleDevice bleDevice, IBinder callback) {
        this.mVersionCode = versionCode;
        this.zzayh = deviceAddress;
        this.zzayi = bleDevice;
        this.zzayj = zza.zzbR(callback);
    }

    public ClaimBleDeviceRequest(String deviceAddress, BleDevice bleDevice, zzpp callback) {
        this.mVersionCode = 4;
        this.zzayh = deviceAddress;
        this.zzayi = bleDevice;
        this.zzayj = callback;
    }

    public int describeContents() {
        return 0;
    }

    public String getDeviceAddress() {
        return this.zzayh;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        return String.format("ClaimBleDeviceRequest{%s %s}", new Object[]{this.zzayh, this.zzayi});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzb.zza(this, parcel, flags);
    }

    public BleDevice zzuh() {
        return this.zzayi;
    }

    public IBinder zzui() {
        return this.zzayj == null ? null : this.zzayj.asBinder();
    }
}
