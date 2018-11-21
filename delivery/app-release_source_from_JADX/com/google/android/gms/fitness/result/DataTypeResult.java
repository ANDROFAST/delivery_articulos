package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataType;

public class DataTypeResult implements Result, SafeParcelable {
    public static final Creator<DataTypeResult> CREATOR = new zzg();
    private final int mVersionCode;
    private final Status zzTA;
    private final DataType zzatO;

    DataTypeResult(int versionCode, Status status, DataType dataType) {
        this.mVersionCode = versionCode;
        this.zzTA = status;
        this.zzatO = dataType;
    }

    public DataTypeResult(Status status, DataType dataType) {
        this.mVersionCode = 2;
        this.zzTA = status;
        this.zzatO = dataType;
    }

    public static DataTypeResult zzT(Status status) {
        return new DataTypeResult(status, null);
    }

    private boolean zzb(DataTypeResult dataTypeResult) {
        return this.zzTA.equals(dataTypeResult.zzTA) && zzw.equal(this.zzatO, dataTypeResult.zzatO);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof DataTypeResult) && zzb((DataTypeResult) that));
    }

    public DataType getDataType() {
        return this.zzatO;
    }

    public Status getStatus() {
        return this.zzTA;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzTA, this.zzatO);
    }

    public String toString() {
        return zzw.zzx(this).zzg("status", this.zzTA).zzg("dataType", this.zzatO).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzg.zza(this, dest, flags);
    }
}
