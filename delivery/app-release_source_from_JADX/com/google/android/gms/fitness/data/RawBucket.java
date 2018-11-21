package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class RawBucket implements SafeParcelable {
    public static final Creator<RawBucket> CREATOR = new zzm();
    final int mVersionCode;
    public final long zzQj;
    public final long zzatQ;
    public final Session zzatS;
    public final int zzauW;
    public final List<RawDataSet> zzaub;
    public final int zzauc;
    public final boolean zzaud;

    public RawBucket(int versionCode, long startTimeMillis, long endTimeMillis, Session session, int activity, List<RawDataSet> dataSets, int bucketType, boolean serverHasMoreData) {
        this.mVersionCode = versionCode;
        this.zzQj = startTimeMillis;
        this.zzatQ = endTimeMillis;
        this.zzatS = session;
        this.zzauW = activity;
        this.zzaub = dataSets;
        this.zzauc = bucketType;
        this.zzaud = serverHasMoreData;
    }

    public RawBucket(Bucket bucket, List<DataSource> uniqueDataSources, List<DataType> uniqueDataTypes) {
        this.mVersionCode = 2;
        this.zzQj = bucket.getStartTime(TimeUnit.MILLISECONDS);
        this.zzatQ = bucket.getEndTime(TimeUnit.MILLISECONDS);
        this.zzatS = bucket.getSession();
        this.zzauW = bucket.zztz();
        this.zzauc = bucket.getBucketType();
        this.zzaud = bucket.zztA();
        List<DataSet> dataSets = bucket.getDataSets();
        this.zzaub = new ArrayList(dataSets.size());
        for (DataSet rawDataSet : dataSets) {
            this.zzaub.add(new RawDataSet(rawDataSet, uniqueDataSources, uniqueDataTypes));
        }
    }

    private boolean zza(RawBucket rawBucket) {
        return this.zzQj == rawBucket.zzQj && this.zzatQ == rawBucket.zzatQ && this.zzauW == rawBucket.zzauW && zzw.equal(this.zzaub, rawBucket.zzaub) && this.zzauc == rawBucket.zzauc && this.zzaud == rawBucket.zzaud;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return this == o || ((o instanceof RawBucket) && zza((RawBucket) o));
    }

    public int hashCode() {
        return zzw.hashCode(Long.valueOf(this.zzQj), Long.valueOf(this.zzatQ), Integer.valueOf(this.zzauc));
    }

    public String toString() {
        return zzw.zzx(this).zzg("startTime", Long.valueOf(this.zzQj)).zzg("endTime", Long.valueOf(this.zzatQ)).zzg("activity", Integer.valueOf(this.zzauW)).zzg("dataSets", this.zzaub).zzg("bucketType", Integer.valueOf(this.zzauc)).zzg("serverHasMoreData", Boolean.valueOf(this.zzaud)).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzm.zza(this, parcel, flags);
    }
}
