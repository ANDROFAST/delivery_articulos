package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataSource.Builder;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.RawBucket;
import com.google.android.gms.fitness.data.RawDataSet;
import com.google.android.gms.fitness.request.DataReadRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataReadResult implements Result, SafeParcelable {
    public static final Creator<DataReadResult> CREATOR = new zzc();
    private final int mVersionCode;
    private final Status zzTA;
    private final List<DataSet> zzaub;
    private final List<DataSource> zzaul;
    private final List<Bucket> zzazl;
    private int zzazm;
    private final List<DataType> zzazn;

    DataReadResult(int versionCode, List<RawDataSet> dataSets, Status status, List<RawBucket> buckets, int batchCount, List<DataSource> uniqueDataSources, List<DataType> uniqueDataTypes) {
        this.mVersionCode = versionCode;
        this.zzTA = status;
        this.zzazm = batchCount;
        this.zzaul = uniqueDataSources;
        this.zzazn = uniqueDataTypes;
        this.zzaub = new ArrayList(dataSets.size());
        for (RawDataSet dataSet : dataSets) {
            this.zzaub.add(new DataSet(dataSet, uniqueDataSources));
        }
        this.zzazl = new ArrayList(buckets.size());
        for (RawBucket bucket : buckets) {
            this.zzazl.add(new Bucket(bucket, uniqueDataSources));
        }
    }

    public DataReadResult(List<DataSet> dataSets, List<Bucket> buckets, Status status) {
        this.mVersionCode = 5;
        this.zzaub = dataSets;
        this.zzTA = status;
        this.zzazl = buckets;
        this.zzazm = 1;
        this.zzaul = new ArrayList();
        this.zzazn = new ArrayList();
    }

    public static DataReadResult zza(Status status, DataReadRequest dataReadRequest) {
        List arrayList = new ArrayList();
        for (DataSource create : dataReadRequest.getDataSources()) {
            arrayList.add(DataSet.create(create));
        }
        for (DataType dataType : dataReadRequest.getDataTypes()) {
            arrayList.add(DataSet.create(new Builder().setDataType(dataType).setType(1).setName("Default").build()));
        }
        return new DataReadResult(arrayList, Collections.emptyList(), status);
    }

    private void zza(Bucket bucket, List<Bucket> list) {
        for (Bucket bucket2 : list) {
            if (bucket2.zzb(bucket)) {
                for (DataSet zza : bucket.getDataSets()) {
                    zza(zza, bucket2.getDataSets());
                }
                return;
            }
        }
        this.zzazl.add(bucket);
    }

    private void zza(DataSet dataSet, List<DataSet> list) {
        for (DataSet dataSet2 : list) {
            if (dataSet2.getDataSource().equals(dataSet.getDataSource())) {
                dataSet2.zzb(dataSet.getDataPoints());
                return;
            }
        }
        list.add(dataSet);
    }

    private boolean zzc(DataReadResult dataReadResult) {
        return this.zzTA.equals(dataReadResult.zzTA) && zzw.equal(this.zzaub, dataReadResult.zzaub) && zzw.equal(this.zzazl, dataReadResult.zzazl);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof DataReadResult) && zzc((DataReadResult) that));
    }

    public List<Bucket> getBuckets() {
        return this.zzazl;
    }

    public DataSet getDataSet(DataSource dataSource) {
        for (DataSet dataSet : this.zzaub) {
            if (dataSource.equals(dataSet.getDataSource())) {
                return dataSet;
            }
        }
        return DataSet.create(dataSource);
    }

    public DataSet getDataSet(DataType dataType) {
        for (DataSet dataSet : this.zzaub) {
            if (dataType.equals(dataSet.getDataType())) {
                return dataSet;
            }
        }
        return DataSet.create(new Builder().setDataType(dataType).setType(1).build());
    }

    public List<DataSet> getDataSets() {
        return this.zzaub;
    }

    public Status getStatus() {
        return this.zzTA;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzTA, this.zzaub, this.zzazl);
    }

    public String toString() {
        return zzw.zzx(this).zzg("status", this.zzTA).zzg("dataSets", this.zzaub.size() > 5 ? this.zzaub.size() + " data sets" : this.zzaub).zzg("buckets", this.zzazl.size() > 5 ? this.zzazl.size() + " buckets" : this.zzazl).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzc.zza(this, dest, flags);
    }

    public void zzb(DataReadResult dataReadResult) {
        for (DataSet zza : dataReadResult.getDataSets()) {
            zza(zza, this.zzaub);
        }
        for (Bucket zza2 : dataReadResult.getBuckets()) {
            zza(zza2, this.zzazl);
        }
    }

    List<DataSource> zztJ() {
        return this.zzaul;
    }

    public int zzuH() {
        return this.zzazm;
    }

    List<RawBucket> zzuI() {
        List<RawBucket> arrayList = new ArrayList(this.zzazl.size());
        for (Bucket rawBucket : this.zzazl) {
            arrayList.add(new RawBucket(rawBucket, this.zzaul, this.zzazn));
        }
        return arrayList;
    }

    List<RawDataSet> zzuJ() {
        List<RawDataSet> arrayList = new ArrayList(this.zzaub.size());
        for (DataSet rawDataSet : this.zzaub) {
            arrayList.add(new RawDataSet(rawDataSet, this.zzaul, this.zzazn));
        }
        return arrayList;
    }

    List<DataType> zzuK() {
        return this.zzazn;
    }
}
