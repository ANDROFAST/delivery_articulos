package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.FitnessActivities;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Bucket implements SafeParcelable {
    public static final Creator<Bucket> CREATOR = new zzc();
    public static final int TYPE_ACTIVITY_SEGMENT = 4;
    public static final int TYPE_ACTIVITY_TYPE = 3;
    public static final int TYPE_SESSION = 2;
    public static final int TYPE_TIME = 1;
    private final int mVersionCode;
    private final long zzQj;
    private final long zzatQ;
    private final Session zzatS;
    private final int zzaua;
    private final List<DataSet> zzaub;
    private final int zzauc;
    private boolean zzaud;

    Bucket(int versionCode, long startTimeMillis, long endTimeMillis, Session session, int activityType, List<DataSet> dataSets, int bucketType, boolean serverHasMoreData) {
        this.zzaud = false;
        this.mVersionCode = versionCode;
        this.zzQj = startTimeMillis;
        this.zzatQ = endTimeMillis;
        this.zzatS = session;
        this.zzaua = activityType;
        this.zzaub = dataSets;
        this.zzauc = bucketType;
        this.zzaud = serverHasMoreData;
    }

    public Bucket(RawBucket bucket, List<DataSource> uniqueDataSources) {
        this(2, bucket.zzQj, bucket.zzatQ, bucket.zzatS, bucket.zzauW, zza(bucket.zzaub, uniqueDataSources), bucket.zzauc, bucket.zzaud);
    }

    private static List<DataSet> zza(Collection<RawDataSet> collection, List<DataSource> list) {
        List<DataSet> arrayList = new ArrayList(collection.size());
        for (RawDataSet dataSet : collection) {
            arrayList.add(new DataSet(dataSet, list));
        }
        return arrayList;
    }

    private boolean zza(Bucket bucket) {
        return this.zzQj == bucket.zzQj && this.zzatQ == bucket.zzatQ && this.zzaua == bucket.zzaua && zzw.equal(this.zzaub, bucket.zzaub) && this.zzauc == bucket.zzauc && this.zzaud == bucket.zzaud;
    }

    public static String zzeI(int i) {
        switch (i) {
            case 0:
                return "unknown";
            case 1:
                return "time";
            case 2:
                return "session";
            case 3:
                return "type";
            case 4:
                return "segment";
            default:
                return "bug";
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof Bucket) && zza((Bucket) o));
    }

    public String getActivity() {
        return FitnessActivities.getName(this.zzaua);
    }

    public int getBucketType() {
        return this.zzauc;
    }

    public DataSet getDataSet(DataType dataType) {
        for (DataSet dataSet : this.zzaub) {
            if (dataSet.getDataType().equals(dataType)) {
                return dataSet;
            }
        }
        return null;
    }

    public List<DataSet> getDataSets() {
        return this.zzaub;
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzatQ, TimeUnit.MILLISECONDS);
    }

    public Session getSession() {
        return this.zzatS;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzQj, TimeUnit.MILLISECONDS);
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Long.valueOf(this.zzQj), Long.valueOf(this.zzatQ), Integer.valueOf(this.zzaua), Integer.valueOf(this.zzauc));
    }

    public String toString() {
        return zzw.zzx(this).zzg("startTime", Long.valueOf(this.zzQj)).zzg("endTime", Long.valueOf(this.zzatQ)).zzg("activity", Integer.valueOf(this.zzaua)).zzg("dataSets", this.zzaub).zzg("bucketType", zzeI(this.zzauc)).zzg("serverHasMoreData", Boolean.valueOf(this.zzaud)).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzc.zza(this, dest, flags);
    }

    public boolean zzb(Bucket bucket) {
        return this.zzQj == bucket.zzQj && this.zzatQ == bucket.zzatQ && this.zzaua == bucket.zzaua && this.zzauc == bucket.zzauc;
    }

    public long zzlx() {
        return this.zzQj;
    }

    public boolean zztA() {
        if (this.zzaud) {
            return true;
        }
        for (DataSet zztA : this.zzaub) {
            if (zztA.zztA()) {
                return true;
            }
        }
        return false;
    }

    public long zztB() {
        return this.zzatQ;
    }

    public int zztz() {
        return this.zzaua;
    }
}
