package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzqc;
import com.google.android.gms.internal.zzqc.zza;

public class ListClaimedBleDevicesRequest implements SafeParcelable {
    public static final Creator<ListClaimedBleDevicesRequest> CREATOR = new zzo();
    private final int mVersionCode;
    private final zzqc zzayI;

    ListClaimedBleDevicesRequest(int versionCode, IBinder callback) {
        this.mVersionCode = versionCode;
        this.zzayI = zza.zzbT(callback);
    }

    public ListClaimedBleDevicesRequest(zzqc callback) {
        this.mVersionCode = 2;
        this.zzayI = callback;
    }

    public int describeContents() {
        return 0;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzo.zza(this, parcel, flags);
    }

    public IBinder zzui() {
        return this.zzayI.asBinder();
    }
}
