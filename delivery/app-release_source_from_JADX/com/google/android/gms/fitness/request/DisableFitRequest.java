package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzpp;
import com.google.android.gms.internal.zzpp.zza;

public class DisableFitRequest implements SafeParcelable {
    public static final Creator<DisableFitRequest> CREATOR = new zzl();
    private final int mVersionCode;
    private final zzpp zzayj;

    DisableFitRequest(int versionCode, IBinder callback) {
        this.mVersionCode = versionCode;
        this.zzayj = zza.zzbR(callback);
    }

    public DisableFitRequest(zzpp callback) {
        this.mVersionCode = 2;
        this.zzayj = callback;
    }

    public int describeContents() {
        return 0;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        return String.format("DisableFitRequest", new Object[0]);
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzl.zza(this, parcel, flags);
    }

    public IBinder zzui() {
        return this.zzayj.asBinder();
    }
}
