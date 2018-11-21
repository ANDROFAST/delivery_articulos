package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class RawDataPoint implements SafeParcelable {
    public static final Creator<RawDataPoint> CREATOR = new zzn();
    final int mVersionCode;
    public final int zzauX;
    public final int zzauY;
    public final long zzaue;
    public final long zzauf;
    public final Value[] zzaug;
    public final long zzaui;
    public final long zzauj;

    public RawDataPoint(int versionCode, long timestampNanos, long startTimeNanos, Value[] values, int dataSourceIndex, int originalDataSourceIndex, long rawTimestamp, long insertionTimeMillis) {
        this.mVersionCode = versionCode;
        this.zzaue = timestampNanos;
        this.zzauf = startTimeNanos;
        this.zzauX = dataSourceIndex;
        this.zzauY = originalDataSourceIndex;
        this.zzaui = rawTimestamp;
        this.zzauj = insertionTimeMillis;
        this.zzaug = values;
    }

    RawDataPoint(DataPoint dataPoint, List<DataSource> dataSources) {
        this.mVersionCode = 4;
        this.zzaue = dataPoint.getTimestamp(TimeUnit.NANOSECONDS);
        this.zzauf = dataPoint.getStartTime(TimeUnit.NANOSECONDS);
        this.zzaug = dataPoint.zztD();
        this.zzauX = zzs.zza(dataPoint.getDataSource(), dataSources);
        this.zzauY = zzs.zza(dataPoint.getOriginalDataSource(), dataSources);
        this.zzaui = dataPoint.zztE();
        this.zzauj = dataPoint.zztF();
    }

    private boolean zza(RawDataPoint rawDataPoint) {
        return this.zzaue == rawDataPoint.zzaue && this.zzauf == rawDataPoint.zzauf && Arrays.equals(this.zzaug, rawDataPoint.zzaug) && this.zzauX == rawDataPoint.zzauX && this.zzauY == rawDataPoint.zzauY && this.zzaui == rawDataPoint.zzaui;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return this == o || ((o instanceof RawDataPoint) && zza((RawDataPoint) o));
    }

    public int hashCode() {
        return zzw.hashCode(Long.valueOf(this.zzaue), Long.valueOf(this.zzauf));
    }

    public String toString() {
        return String.format("RawDataPoint{%s@[%s, %s](%d,%d)}", new Object[]{Arrays.toString(this.zzaug), Long.valueOf(this.zzauf), Long.valueOf(this.zzaue), Integer.valueOf(this.zzauX), Integer.valueOf(this.zzauY)});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzn.zza(this, parcel, flags);
    }
}
