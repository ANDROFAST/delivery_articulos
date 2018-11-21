package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzpc;
import com.google.android.gms.internal.zzpc.zza;

public class DataTypeReadRequest implements SafeParcelable {
    public static final Creator<DataTypeReadRequest> CREATOR = new zzj();
    private final String mName;
    private final int mVersionCode;
    private final zzpc zzayG;

    DataTypeReadRequest(int versionCode, String name, IBinder callback) {
        this.mVersionCode = versionCode;
        this.mName = name;
        this.zzayG = zza.zzbE(callback);
    }

    public DataTypeReadRequest(String name, zzpc callback) {
        this.mVersionCode = 3;
        this.mName = name;
        this.zzayG = callback;
    }

    private boolean zzb(DataTypeReadRequest dataTypeReadRequest) {
        return zzw.equal(this.mName, dataTypeReadRequest.mName);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof DataTypeReadRequest) && zzb((DataTypeReadRequest) o));
    }

    public String getName() {
        return this.mName;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.mName);
    }

    public String toString() {
        return zzw.zzx(this).zzg("name", this.mName).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzj.zza(this, dest, flags);
    }

    public IBinder zzui() {
        return this.zzayG.asBinder();
    }
}
