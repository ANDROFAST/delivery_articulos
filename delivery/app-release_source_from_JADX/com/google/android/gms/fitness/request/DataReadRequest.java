package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Device;
import com.google.android.gms.internal.zzpa;
import com.google.android.gms.internal.zzpa.zza;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DataReadRequest implements SafeParcelable {
    public static final Creator<DataReadRequest> CREATOR = new zzf();
    public static final int NO_LIMIT = 0;
    private final int mVersionCode;
    private final long zzQj;
    private final long zzatQ;
    private final List<DataType> zzatZ;
    private final int zzauc;
    private final List<DataSource> zzayl;
    private final List<DataType> zzayq;
    private final List<DataSource> zzayr;
    private final long zzays;
    private final DataSource zzayt;
    private final int zzayu;
    private final boolean zzayv;
    private final boolean zzayw;
    private final zzpa zzayx;
    private final List<Device> zzayy;

    public static class Builder {
        private long zzQj;
        private long zzatQ;
        private List<DataType> zzatZ = new ArrayList();
        private int zzauc = 0;
        private List<DataSource> zzayl = new ArrayList();
        private List<DataType> zzayq = new ArrayList();
        private List<DataSource> zzayr = new ArrayList();
        private long zzays = 0;
        private DataSource zzayt;
        private int zzayu = 0;
        private boolean zzayv = false;
        private boolean zzayw = false;
        private List<Device> zzayy = new ArrayList();

        public Builder aggregate(DataSource dataSource, DataType outputDataType) {
            zzx.zzb((Object) dataSource, (Object) "Attempting to add a null data source");
            zzx.zza(!this.zzayl.contains(dataSource), (Object) "Cannot add the same data source for aggregated and detailed");
            DataType dataType = dataSource.getDataType();
            zzx.zzb(DataType.AGGREGATE_INPUT_TYPES.contains(dataType), "Unsupported input data type specified for aggregation: %s", dataType);
            zzx.zzb(DataType.getAggregatesForInput(dataType).contains(outputDataType), "Invalid output aggregate data type specified: %s -> %s", dataType, outputDataType);
            if (!this.zzayr.contains(dataSource)) {
                this.zzayr.add(dataSource);
            }
            return this;
        }

        public Builder aggregate(DataType inputDataType, DataType outputDataType) {
            zzx.zzb((Object) inputDataType, (Object) "Attempting to use a null data type");
            zzx.zza(!this.zzatZ.contains(inputDataType), (Object) "Cannot add the same data type as aggregated and detailed");
            zzx.zzb(DataType.AGGREGATE_INPUT_TYPES.contains(inputDataType), "Unsupported input data type specified for aggregation: %s", inputDataType);
            zzx.zzb(DataType.getAggregatesForInput(inputDataType).contains(outputDataType), "Invalid output aggregate data type specified: %s -> %s", inputDataType, outputDataType);
            if (!this.zzayq.contains(inputDataType)) {
                this.zzayq.add(inputDataType);
            }
            return this;
        }

        public Builder bucketByActivitySegment(int minDuration, TimeUnit timeUnit) {
            zzx.zzb(this.zzauc == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzauc));
            zzx.zzb(minDuration > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(minDuration));
            this.zzauc = 4;
            this.zzays = timeUnit.toMillis((long) minDuration);
            return this;
        }

        public Builder bucketByActivitySegment(int minDuration, TimeUnit timeUnit, DataSource activityDataSource) {
            zzx.zzb(this.zzauc == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzauc));
            zzx.zzb(minDuration > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(minDuration));
            zzx.zzb(activityDataSource != null, (Object) "Invalid activity data source specified");
            zzx.zzb(activityDataSource.getDataType().equals(DataType.TYPE_ACTIVITY_SEGMENT), "Invalid activity data source specified: %s", activityDataSource);
            this.zzayt = activityDataSource;
            this.zzauc = 4;
            this.zzays = timeUnit.toMillis((long) minDuration);
            return this;
        }

        public Builder bucketByActivityType(int minDuration, TimeUnit timeUnit) {
            zzx.zzb(this.zzauc == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzauc));
            zzx.zzb(minDuration > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(minDuration));
            this.zzauc = 3;
            this.zzays = timeUnit.toMillis((long) minDuration);
            return this;
        }

        public Builder bucketByActivityType(int minDuration, TimeUnit timeUnit, DataSource activityDataSource) {
            zzx.zzb(this.zzauc == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzauc));
            zzx.zzb(minDuration > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(minDuration));
            zzx.zzb(activityDataSource != null, (Object) "Invalid activity data source specified");
            zzx.zzb(activityDataSource.getDataType().equals(DataType.TYPE_ACTIVITY_SEGMENT), "Invalid activity data source specified: %s", activityDataSource);
            this.zzayt = activityDataSource;
            this.zzauc = 3;
            this.zzays = timeUnit.toMillis((long) minDuration);
            return this;
        }

        public Builder bucketBySession(int minDuration, TimeUnit timeUnit) {
            zzx.zzb(this.zzauc == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzauc));
            zzx.zzb(minDuration > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(minDuration));
            this.zzauc = 2;
            this.zzays = timeUnit.toMillis((long) minDuration);
            return this;
        }

        public Builder bucketByTime(int duration, TimeUnit timeUnit) {
            zzx.zzb(this.zzauc == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzauc));
            zzx.zzb(duration > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(duration));
            this.zzauc = 1;
            this.zzays = timeUnit.toMillis((long) duration);
            return this;
        }

        public DataReadRequest build() {
            boolean z = true;
            boolean z2 = (this.zzayl.isEmpty() && this.zzatZ.isEmpty() && this.zzayr.isEmpty() && this.zzayq.isEmpty()) ? false : true;
            zzx.zza(z2, (Object) "Must add at least one data source (aggregated or detailed)");
            zzx.zza(this.zzQj > 0, "Invalid start time: %s", Long.valueOf(this.zzQj));
            z2 = this.zzatQ > 0 && this.zzatQ > this.zzQj;
            zzx.zza(z2, "Invalid end time: %s", Long.valueOf(this.zzatQ));
            z2 = this.zzayr.isEmpty() && this.zzayq.isEmpty();
            if (!(z2 && this.zzauc == 0) && (z2 || this.zzauc == 0)) {
                z = false;
            }
            zzx.zza(z, (Object) "Must specify a valid bucketing strategy while requesting aggregation");
            return new DataReadRequest();
        }

        public Builder enableServerQueries() {
            this.zzayw = true;
            return this;
        }

        public Builder read(DataSource dataSource) {
            zzx.zzb((Object) dataSource, (Object) "Attempting to add a null data source");
            zzx.zzb(!this.zzayr.contains(dataSource), (Object) "Cannot add the same data source as aggregated and detailed");
            if (!this.zzayl.contains(dataSource)) {
                this.zzayl.add(dataSource);
            }
            return this;
        }

        public Builder read(DataType dataType) {
            zzx.zzb((Object) dataType, (Object) "Attempting to use a null data type");
            zzx.zza(!this.zzayq.contains(dataType), (Object) "Cannot add the same data type as aggregated and detailed");
            if (!this.zzatZ.contains(dataType)) {
                this.zzatZ.add(dataType);
            }
            return this;
        }

        public Builder setLimit(int limit) {
            zzx.zzb(limit > 0, "Invalid limit %d is specified", Integer.valueOf(limit));
            this.zzayu = limit;
            return this;
        }

        public Builder setTimeRange(long start, long end, TimeUnit timeUnit) {
            this.zzQj = timeUnit.toMillis(start);
            this.zzatQ = timeUnit.toMillis(end);
            return this;
        }
    }

    DataReadRequest(int versionCode, List<DataType> dataTypes, List<DataSource> dataSources, long startTimeMillis, long endTimeMillis, List<DataType> aggregatedDataTypes, List<DataSource> aggregatedDataSources, int bucketType, long bucketDurationMillis, DataSource activityDataSource, int limit, boolean flushBeforeRead, boolean serverQueriesEnabled, IBinder callback, List<Device> filteredDevices) {
        this.mVersionCode = versionCode;
        this.zzatZ = dataTypes;
        this.zzayl = dataSources;
        this.zzQj = startTimeMillis;
        this.zzatQ = endTimeMillis;
        this.zzayq = aggregatedDataTypes;
        this.zzayr = aggregatedDataSources;
        this.zzauc = bucketType;
        this.zzays = bucketDurationMillis;
        this.zzayt = activityDataSource;
        this.zzayu = limit;
        this.zzayv = flushBeforeRead;
        this.zzayw = serverQueriesEnabled;
        this.zzayx = callback == null ? null : zza.zzbC(callback);
        if (filteredDevices == null) {
            filteredDevices = Collections.emptyList();
        }
        this.zzayy = filteredDevices;
    }

    private DataReadRequest(Builder builder) {
        this(builder.zzatZ, builder.zzayl, builder.zzQj, builder.zzatQ, builder.zzayq, builder.zzayr, builder.zzauc, builder.zzays, builder.zzayt, builder.zzayu, builder.zzayv, builder.zzayw, null, builder.zzayy);
    }

    public DataReadRequest(DataReadRequest request, zzpa callback) {
        this(request.zzatZ, request.zzayl, request.zzQj, request.zzatQ, request.zzayq, request.zzayr, request.zzauc, request.zzays, request.zzayt, request.zzayu, request.zzayv, request.zzayw, callback, request.zzayy);
    }

    public DataReadRequest(List<DataType> dataTypes, List<DataSource> dataSources, long startTimeMillis, long endTimeMillis, List<DataType> aggregatedDataTypes, List<DataSource> aggregatedDataSources, int bucketType, long bucketDurationMillis, DataSource activityDataSource, int limit, boolean flushBeforeRead, boolean serverQueriesEnabled, zzpa callback, List<Device> filteredDevices) {
        this(5, dataTypes, dataSources, startTimeMillis, endTimeMillis, aggregatedDataTypes, aggregatedDataSources, bucketType, bucketDurationMillis, activityDataSource, limit, flushBeforeRead, serverQueriesEnabled, callback == null ? null : callback.asBinder(), filteredDevices);
    }

    private boolean zzb(DataReadRequest dataReadRequest) {
        return this.zzatZ.equals(dataReadRequest.zzatZ) && this.zzayl.equals(dataReadRequest.zzayl) && this.zzQj == dataReadRequest.zzQj && this.zzatQ == dataReadRequest.zzatQ && this.zzauc == dataReadRequest.zzauc && this.zzayr.equals(dataReadRequest.zzayr) && this.zzayq.equals(dataReadRequest.zzayq) && zzw.equal(this.zzayt, dataReadRequest.zzayt) && this.zzays == dataReadRequest.zzays && this.zzayw == dataReadRequest.zzayw;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof DataReadRequest) && zzb((DataReadRequest) that));
    }

    public DataSource getActivityDataSource() {
        return this.zzayt;
    }

    public List<DataSource> getAggregatedDataSources() {
        return this.zzayr;
    }

    public List<DataType> getAggregatedDataTypes() {
        return this.zzayq;
    }

    public long getBucketDuration(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzays, TimeUnit.MILLISECONDS);
    }

    public int getBucketType() {
        return this.zzauc;
    }

    public List<DataSource> getDataSources() {
        return this.zzayl;
    }

    public List<DataType> getDataTypes() {
        return this.zzatZ;
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzatQ, TimeUnit.MILLISECONDS);
    }

    public int getLimit() {
        return this.zzayu;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzQj, TimeUnit.MILLISECONDS);
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzauc), Long.valueOf(this.zzQj), Long.valueOf(this.zzatQ));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DataReadRequest{");
        if (!this.zzatZ.isEmpty()) {
            for (DataType zztM : this.zzatZ) {
                stringBuilder.append(zztM.zztM()).append(" ");
            }
        }
        if (!this.zzayl.isEmpty()) {
            for (DataSource toDebugString : this.zzayl) {
                stringBuilder.append(toDebugString.toDebugString()).append(" ");
            }
        }
        if (this.zzauc != 0) {
            stringBuilder.append("bucket by ").append(Bucket.zzeI(this.zzauc));
            if (this.zzays > 0) {
                stringBuilder.append(" >").append(this.zzays).append("ms");
            }
            stringBuilder.append(": ");
        }
        if (!this.zzayq.isEmpty()) {
            for (DataType zztM2 : this.zzayq) {
                stringBuilder.append(zztM2.zztM()).append(" ");
            }
        }
        if (!this.zzayr.isEmpty()) {
            for (DataSource toDebugString2 : this.zzayr) {
                stringBuilder.append(toDebugString2.toDebugString()).append(" ");
            }
        }
        stringBuilder.append(String.format("(%tF %tT - %tF %tT)", new Object[]{Long.valueOf(this.zzQj), Long.valueOf(this.zzQj), Long.valueOf(this.zzatQ), Long.valueOf(this.zzatQ)}));
        if (this.zzayt != null) {
            stringBuilder.append("activities: ").append(this.zzayt.toDebugString());
        }
        if (this.zzayw) {
            stringBuilder.append(" +server");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzf.zza(this, dest, flags);
    }

    public long zzlx() {
        return this.zzQj;
    }

    public long zztB() {
        return this.zzatQ;
    }

    public IBinder zzui() {
        return this.zzayx == null ? null : this.zzayx.asBinder();
    }

    public boolean zzun() {
        return this.zzayw;
    }

    public boolean zzuo() {
        return this.zzayv;
    }

    public long zzup() {
        return this.zzays;
    }

    public List<Device> zzuq() {
        return this.zzayy;
    }
}
