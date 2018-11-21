package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.List;

public final class RawDataSet implements SafeParcelable {
    public static final Creator<RawDataSet> CREATOR = new zzo();
    final int mVersionCode;
    public final int zzauX;
    public final int zzauZ;
    public final boolean zzaud;
    public final List<RawDataPoint> zzava;

    public RawDataSet(int versionCode, int dataSourceIndex, int dataTypeIndex, List<RawDataPoint> rawDataPoints, boolean serverHasMoreData) {
        this.mVersionCode = versionCode;
        this.zzauX = dataSourceIndex;
        this.zzauZ = dataTypeIndex;
        this.zzava = rawDataPoints;
        this.zzaud = serverHasMoreData;
    }

    public RawDataSet(DataSet dataSet, List<DataSource> uniqueDataSources, List<DataType> uniqueDataTypes) {
        this.mVersionCode = 3;
        this.zzava = dataSet.zzt(uniqueDataSources);
        this.zzaud = dataSet.zztA();
        this.zzauX = zzs.zza(dataSet.getDataSource(), uniqueDataSources);
        this.zzauZ = zzs.zza(dataSet.getDataType(), uniqueDataTypes);
    }

    private boolean zza(RawDataSet rawDataSet) {
        return this.zzauX == rawDataSet.zzauX && this.zzaud == rawDataSet.zzaud && zzw.equal(this.zzava, rawDataSet.zzava);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return this == o || ((o instanceof RawDataSet) && zza((RawDataSet) o));
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzauX));
    }

    public String toString() {
        return String.format("RawDataSet{%s@[%s]}", new Object[]{Integer.valueOf(this.zzauX), this.zzava});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzo.zza(this, parcel, flags);
    }
}
