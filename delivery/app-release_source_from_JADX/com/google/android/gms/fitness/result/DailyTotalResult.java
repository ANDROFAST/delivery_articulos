package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource.Builder;
import com.google.android.gms.fitness.data.DataType;

public class DailyTotalResult implements Result, SafeParcelable {
    public static final Creator<DailyTotalResult> CREATOR = new zzb();
    private final int mVersionCode;
    private final Status zzTA;
    private final DataSet zzave;

    DailyTotalResult(int versionCode, Status status, DataSet dataSet) {
        this.mVersionCode = versionCode;
        this.zzTA = status;
        this.zzave = dataSet;
    }

    public DailyTotalResult(DataSet dataSet, Status status) {
        this.mVersionCode = 1;
        this.zzTA = status;
        this.zzave = dataSet;
    }

    public static DailyTotalResult zza(Status status, DataType dataType) {
        return new DailyTotalResult(DataSet.create(new Builder().setDataType(dataType).setType(1).build()), status);
    }

    private boolean zzb(DailyTotalResult dailyTotalResult) {
        return this.zzTA.equals(dailyTotalResult.zzTA) && zzw.equal(this.zzave, dailyTotalResult.zzave);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof DailyTotalResult) && zzb((DailyTotalResult) that));
    }

    public Status getStatus() {
        return this.zzTA;
    }

    public DataSet getTotal() {
        return this.zzave;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzTA, this.zzave);
    }

    public String toString() {
        return zzw.zzx(this).zzg("status", this.zzTA).zzg("dataPoint", this.zzave).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzb.zza(this, dest, flags);
    }
}
