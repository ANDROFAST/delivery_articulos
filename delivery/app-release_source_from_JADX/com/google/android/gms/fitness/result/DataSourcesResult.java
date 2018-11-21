package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataSourcesResult implements Result, SafeParcelable {
    public static final Creator<DataSourcesResult> CREATOR = new zze();
    private final int mVersionCode;
    private final Status zzTA;
    private final List<DataSource> zzayl;

    DataSourcesResult(int versionCode, List<DataSource> dataSources, Status status) {
        this.mVersionCode = versionCode;
        this.zzayl = Collections.unmodifiableList(dataSources);
        this.zzTA = status;
    }

    public DataSourcesResult(List<DataSource> dataSources, Status status) {
        this.mVersionCode = 3;
        this.zzayl = Collections.unmodifiableList(dataSources);
        this.zzTA = status;
    }

    public static DataSourcesResult zzS(Status status) {
        return new DataSourcesResult(Collections.emptyList(), status);
    }

    private boolean zzb(DataSourcesResult dataSourcesResult) {
        return this.zzTA.equals(dataSourcesResult.zzTA) && zzw.equal(this.zzayl, dataSourcesResult.zzayl);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof DataSourcesResult) && zzb((DataSourcesResult) that));
    }

    public List<DataSource> getDataSources() {
        return this.zzayl;
    }

    public List<DataSource> getDataSources(DataType dataType) {
        List arrayList = new ArrayList();
        for (DataSource dataSource : this.zzayl) {
            if (dataSource.getDataType().equals(dataType)) {
                arrayList.add(dataSource);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Status getStatus() {
        return this.zzTA;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzTA, this.zzayl);
    }

    public String toString() {
        return zzw.zzx(this).zzg("status", this.zzTA).zzg("dataSets", this.zzayl).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zze.zza(this, dest, flags);
    }
}
