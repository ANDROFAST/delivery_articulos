package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;

public class DataSourceQueryParams implements SafeParcelable {
    public static final Creator<DataSourceQueryParams> CREATOR = new zzg();
    final int mVersionCode;
    public final long zzTC;
    public final DataSource zzatP;
    public final long zzauf;
    public final int zzayA;
    public final int zzayu;
    public final long zzayz;

    DataSourceQueryParams(int versionCode, DataSource dataSource, long id, long startTimeNanos, long endTimeNanos, int limit, int readBehind) {
        this.mVersionCode = versionCode;
        this.zzatP = dataSource;
        this.zzTC = id;
        this.zzauf = startTimeNanos;
        this.zzayz = endTimeNanos;
        this.zzayu = limit;
        this.zzayA = readBehind;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzg.zza(this, dest, flags);
    }
}
