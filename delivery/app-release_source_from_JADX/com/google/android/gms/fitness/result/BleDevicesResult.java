package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BleDevicesResult implements Result, SafeParcelable {
    public static final Creator<BleDevicesResult> CREATOR = new zza();
    private final int mVersionCode;
    private final Status zzTA;
    private final List<BleDevice> zzazk;

    BleDevicesResult(int versionCode, List<BleDevice> bleDevices, Status status) {
        this.mVersionCode = versionCode;
        this.zzazk = Collections.unmodifiableList(bleDevices);
        this.zzTA = status;
    }

    public BleDevicesResult(List<BleDevice> bleDevices, Status status) {
        this.mVersionCode = 3;
        this.zzazk = Collections.unmodifiableList(bleDevices);
        this.zzTA = status;
    }

    public static BleDevicesResult zzR(Status status) {
        return new BleDevicesResult(Collections.emptyList(), status);
    }

    private boolean zzb(BleDevicesResult bleDevicesResult) {
        return this.zzTA.equals(bleDevicesResult.zzTA) && zzw.equal(this.zzazk, bleDevicesResult.zzazk);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof BleDevicesResult) && zzb((BleDevicesResult) that));
    }

    public List<BleDevice> getClaimedBleDevices() {
        return this.zzazk;
    }

    public List<BleDevice> getClaimedBleDevices(DataType dataType) {
        List arrayList = new ArrayList();
        for (BleDevice bleDevice : this.zzazk) {
            if (bleDevice.getDataTypes().contains(dataType)) {
                arrayList.add(bleDevice);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Status getStatus() {
        return this.zzTA;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzTA, this.zzazk);
    }

    public String toString() {
        return zzw.zzx(this).zzg("status", this.zzTA).zzg("bleDevices", this.zzazk).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zza.zza(this, dest, flags);
    }
}
