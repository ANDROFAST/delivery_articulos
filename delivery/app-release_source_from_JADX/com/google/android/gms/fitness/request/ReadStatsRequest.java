package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzpm;
import com.google.android.gms.internal.zzpm.zza;

public class ReadStatsRequest implements SafeParcelable {
    public static final Creator<ReadStatsRequest> CREATOR = new zzr();
    private final int mVersionCode;
    private final zzpm zzayM;

    ReadStatsRequest(int versionCode, IBinder callback) {
        this.mVersionCode = versionCode;
        this.zzayM = zza.zzbO(callback);
    }

    public int describeContents() {
        return 0;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        return String.format("ReadStatsRequest", new Object[0]);
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzr.zza(this, parcel, flags);
    }

    public IBinder zzui() {
        return this.zzayM.asBinder();
    }
}
