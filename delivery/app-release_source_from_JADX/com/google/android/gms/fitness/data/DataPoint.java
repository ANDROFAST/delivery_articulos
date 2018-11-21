package com.google.android.gms.fitness.data;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzol;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class DataPoint implements SafeParcelable {
    public static final Creator<DataPoint> CREATOR = new zzd();
    private final int mVersionCode;
    private final DataSource zzatP;
    private long zzaue;
    private long zzauf;
    private final Value[] zzaug;
    private DataSource zzauh;
    private long zzaui;
    private long zzauj;

    DataPoint(int versionCode, DataSource dataSource, long timestampNanos, long startTimeNanos, Value[] values, DataSource originalDataSource, long rawTimestamp, long insertionTimeMillis) {
        this.mVersionCode = versionCode;
        this.zzatP = dataSource;
        this.zzauh = originalDataSource;
        this.zzaue = timestampNanos;
        this.zzauf = startTimeNanos;
        this.zzaug = values;
        this.zzaui = rawTimestamp;
        this.zzauj = insertionTimeMillis;
    }

    private DataPoint(DataSource dataSource) {
        this.mVersionCode = 4;
        this.zzatP = (DataSource) zzx.zzb((Object) dataSource, (Object) "Data source cannot be null");
        List<Field> fields = dataSource.getDataType().getFields();
        this.zzaug = new Value[fields.size()];
        int i = 0;
        for (Field format : fields) {
            this.zzaug[i] = new Value(format.getFormat());
            i++;
        }
    }

    public DataPoint(DataSource dataSource, DataSource originalDataSource, RawDataPoint rawDataPoint) {
        this(4, dataSource, zza(Long.valueOf(rawDataPoint.zzaue), 0), zza(Long.valueOf(rawDataPoint.zzauf), 0), rawDataPoint.zzaug, originalDataSource, zza(Long.valueOf(rawDataPoint.zzaui), 0), zza(Long.valueOf(rawDataPoint.zzauj), 0));
    }

    DataPoint(List<DataSource> dataSources, RawDataPoint rawDataPoint) {
        this(zza((List) dataSources, rawDataPoint.zzauX), zza((List) dataSources, rawDataPoint.zzauY), rawDataPoint);
    }

    public static DataPoint create(DataSource dataSource) {
        return new DataPoint(dataSource);
    }

    public static DataPoint extract(Intent intent) {
        return intent == null ? null : (DataPoint) zzc.zza(intent, "com.google.android.gms.fitness.EXTRA_DATA_POINT", CREATOR);
    }

    private static long zza(Long l, long j) {
        return l != null ? l.longValue() : j;
    }

    private static DataSource zza(List<DataSource> list, int i) {
        return (i < 0 || i >= list.size()) ? null : (DataSource) list.get(i);
    }

    private boolean zza(DataPoint dataPoint) {
        return zzw.equal(this.zzatP, dataPoint.zzatP) && this.zzaue == dataPoint.zzaue && this.zzauf == dataPoint.zzauf && Arrays.equals(this.zzaug, dataPoint.zzaug) && zzw.equal(this.zzauh, dataPoint.zzauh);
    }

    private void zzeK(int i) {
        zzx.zzb(i == getDataType().getFields().size(), "Attempting to insert %s values, but needed %s: %s", Integer.valueOf(i), Integer.valueOf(getDataType().getFields().size()), getDataType().getFields());
    }

    private boolean zztC() {
        return getDataType() == DataType.TYPE_LOCATION_SAMPLE;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return this == o || ((o instanceof DataPoint) && zza((DataPoint) o));
    }

    public DataSource getDataSource() {
        return this.zzatP;
    }

    public DataType getDataType() {
        return this.zzatP.getDataType();
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzaue, TimeUnit.NANOSECONDS);
    }

    public DataSource getOriginalDataSource() {
        return this.zzauh;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzauf, TimeUnit.NANOSECONDS);
    }

    public long getTimestamp(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzaue, TimeUnit.NANOSECONDS);
    }

    public long getTimestampNanos() {
        return this.zzaue;
    }

    public Value getValue(Field field) {
        return this.zzaug[getDataType().indexOf(field)];
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzatP, Long.valueOf(this.zzaue), Long.valueOf(this.zzauf));
    }

    public DataPoint setFloatValues(float... values) {
        zzeK(values.length);
        for (int i = 0; i < values.length; i++) {
            this.zzaug[i].setFloat(values[i]);
        }
        return this;
    }

    public DataPoint setIntValues(int... values) {
        zzeK(values.length);
        for (int i = 0; i < values.length; i++) {
            this.zzaug[i].setInt(values[i]);
        }
        return this;
    }

    public DataPoint setTimeInterval(long startTime, long endTime, TimeUnit timeUnit) {
        this.zzauf = timeUnit.toNanos(startTime);
        this.zzaue = timeUnit.toNanos(endTime);
        return this;
    }

    public DataPoint setTimestamp(long timestamp, TimeUnit timeUnit) {
        this.zzaue = timeUnit.toNanos(timestamp);
        if (zztC() && zzol.zza(timeUnit)) {
            Log.w("Fitness", "Storing location at more than millisecond granularity is not supported. Extra precision is lost as the value is converted to milliseconds.");
            this.zzaue = zzol.zza(this.zzaue, TimeUnit.NANOSECONDS, TimeUnit.MILLISECONDS);
        }
        return this;
    }

    public String toString() {
        String str = "DataPoint{%s@[%s, %s,raw=%s,insert=%s](%s %s)}";
        Object[] objArr = new Object[7];
        objArr[0] = Arrays.toString(this.zzaug);
        objArr[1] = Long.valueOf(this.zzauf);
        objArr[2] = Long.valueOf(this.zzaue);
        objArr[3] = Long.valueOf(this.zzaui);
        objArr[4] = Long.valueOf(this.zzauj);
        objArr[5] = this.zzatP.toDebugString();
        objArr[6] = this.zzauh != null ? this.zzauh.toDebugString() : "N/A";
        return String.format(str, objArr);
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzd.zza(this, parcel, flags);
    }

    public Value[] zztD() {
        return this.zzaug;
    }

    public long zztE() {
        return this.zzaui;
    }

    public long zztF() {
        return this.zzauj;
    }

    public void zztG() {
        zzx.zzb(getDataType().getName().equals(getDataSource().getDataType().getName()), "Conflicting data types found %s vs %s", getDataType(), getDataType());
        zzx.zzb(this.zzaue > 0, "Data point does not have the timestamp set: %s", this);
        zzx.zzb(this.zzauf <= this.zzaue, "Data point with start time greater than end time found: %s", this);
    }

    public long zztH() {
        return this.zzauf;
    }
}
