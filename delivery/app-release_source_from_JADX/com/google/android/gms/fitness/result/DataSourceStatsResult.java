package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;

public class DataSourceStatsResult implements SafeParcelable {
    public static final Creator<DataSourceStatsResult> CREATOR = new zzd();
    final int mVersionCode;
    public final long zzTC;
    public final DataSource zzatP;
    public final boolean zzazo;
    public final long zzazp;
    public final long zzazq;

    DataSourceStatsResult(int versionCode, DataSource dataSource, long id, boolean isRemote, long minEndTimeNanos, long maxEndTimeNanos) {
        this.mVersionCode = versionCode;
        this.zzatP = dataSource;
        this.zzTC = id;
        this.zzazo = isRemote;
        this.zzazp = minEndTimeNanos;
        this.zzazq = maxEndTimeNanos;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzd.zza(this, dest, flags);
    }
}
