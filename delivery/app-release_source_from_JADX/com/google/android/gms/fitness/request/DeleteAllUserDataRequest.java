package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzpp;
import com.google.android.gms.internal.zzpp.zza;

public class DeleteAllUserDataRequest implements SafeParcelable {
    public static final Creator<DeleteAllUserDataRequest> CREATOR = new zzk();
    private final int mVersionCode;
    private final zzpp zzayj;

    DeleteAllUserDataRequest(int versionCode, IBinder callback) {
        this.mVersionCode = versionCode;
        this.zzayj = zza.zzbR(callback);
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
        zzk.zza(this, parcel, flags);
    }

    public IBinder zzui() {
        return this.zzayj.asBinder();
    }
}
