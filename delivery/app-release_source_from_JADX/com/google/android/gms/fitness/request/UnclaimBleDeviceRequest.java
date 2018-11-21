package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzpp;
import com.google.android.gms.internal.zzpp.zza;

public class UnclaimBleDeviceRequest implements SafeParcelable {
    public static final Creator<UnclaimBleDeviceRequest> CREATOR = new zzad();
    private final int mVersionCode;
    private final String zzayh;
    private final zzpp zzayj;

    UnclaimBleDeviceRequest(int versionCode, String deviceAddress, IBinder callback) {
        this.mVersionCode = versionCode;
        this.zzayh = deviceAddress;
        this.zzayj = zza.zzbR(callback);
    }

    public UnclaimBleDeviceRequest(String deviceAddress, zzpp callback) {
        this.mVersionCode = 5;
        this.zzayh = deviceAddress;
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
        return String.format("UnclaimBleDeviceRequest{%s}", new Object[]{this.zzayh});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzad.zza(this, parcel, flags);
    }

    public IBinder zzui() {
        return this.zzayj == null ? null : this.zzayj.asBinder();
    }
}
