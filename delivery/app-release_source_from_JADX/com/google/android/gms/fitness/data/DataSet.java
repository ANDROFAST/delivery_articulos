package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzop;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DataSet implements SafeParcelable {
    public static final Creator<DataSet> CREATOR = new zze();
    private final int mVersionCode;
    private final DataType zzatO;
    private final DataSource zzatP;
    private boolean zzaud;
    private final List<DataPoint> zzauk;
    private final List<DataSource> zzaul;

    DataSet(int versionCode, DataSource dataSource, DataType dataType, List<RawDataPoint> dataPoints, List<DataSource> uniqueDataSources, boolean serverHasMoreData) {
        this.zzaud = false;
        this.mVersionCode = versionCode;
        this.zzatP = dataSource;
        this.zzatO = dataSource.getDataType();
        this.zzaud = serverHasMoreData;
        this.zzauk = new ArrayList(dataPoints.size());
        if (versionCode < 2) {
            uniqueDataSources = Collections.singletonList(dataSource);
        }
        this.zzaul = uniqueDataSources;
        for (RawDataPoint dataPoint : dataPoints) {
            this.zzauk.add(new DataPoint(this.zzaul, dataPoint));
        }
    }

    public DataSet(DataSource dataSource) {
        this.zzaud = false;
        this.mVersionCode = 3;
        this.zzatP = (DataSource) zzx.zzy(dataSource);
        this.zzatO = dataSource.getDataType();
        this.zzauk = new ArrayList();
        this.zzaul = new ArrayList();
        this.zzaul.add(this.zzatP);
    }

    public DataSet(RawDataSet dataSet, List<DataSource> uniqueDataSources) {
        this.zzaud = false;
        this.mVersionCode = 3;
        this.zzatP = (DataSource) zzb(uniqueDataSources, dataSet.zzauX);
        this.zzatO = this.zzatP.getDataType();
        this.zzaul = uniqueDataSources;
        this.zzaud = dataSet.zzaud;
        List<RawDataPoint> list = dataSet.zzava;
        this.zzauk = new ArrayList(list.size());
        for (RawDataPoint dataPoint : list) {
            this.zzauk.add(new DataPoint(this.zzaul, dataPoint));
        }
    }

    public static DataSet create(DataSource dataSource) {
        zzx.zzb((Object) dataSource, (Object) "DataSource should be specified");
        return new DataSet(dataSource);
    }

    private boolean zza(DataSet dataSet) {
        return zzw.equal(getDataType(), dataSet.getDataType()) && zzw.equal(this.zzatP, dataSet.zzatP) && zzw.equal(this.zzauk, dataSet.zzauk) && this.zzaud == dataSet.zzaud;
    }

    private static <T> T zzb(List<T> list, int i) {
        return (i < 0 || i >= list.size()) ? null : list.get(i);
    }

    public void add(DataPoint dataPoint) {
        Object[] objArr = new Object[]{dataPoint.getDataSource(), this.zzatP};
        zzx.zzb(dataPoint.getDataSource().getStreamIdentifier().equals(this.zzatP.getStreamIdentifier()), "Conflicting data sources found %s vs %s", objArr);
        dataPoint.zztG();
        String zzd = zzop.zzd(dataPoint);
        if (zzd == null) {
            zzb(dataPoint);
        } else {
            Log.w("Fitness", "Ignoring invalid datapoint (Will be an exception in the next release): " + dataPoint, new IllegalArgumentException(zzd));
        }
    }

    public void addAll(Iterable<DataPoint> dataPoints) {
        for (DataPoint add : dataPoints) {
            add(add);
        }
    }

    public DataPoint createDataPoint() {
        return DataPoint.create(this.zzatP);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof DataSet) && zza((DataSet) o));
    }

    public List<DataPoint> getDataPoints() {
        return Collections.unmodifiableList(this.zzauk);
    }

    public DataSource getDataSource() {
        return this.zzatP;
    }

    public DataType getDataType() {
        return this.zzatP.getDataType();
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzatP);
    }

    public boolean isEmpty() {
        return this.zzauk.isEmpty();
    }

    public String toString() {
        List zztI = zztI();
        String str = "DataSet{%s %s}";
        Object[] objArr = new Object[2];
        objArr[0] = this.zzatP.toDebugString();
        if (this.zzauk.size() >= 10) {
            zztI = String.format("%d data points, first 5: %s", new Object[]{Integer.valueOf(this.zzauk.size()), zztI.subList(0, 5)});
        }
        objArr[1] = zztI;
        return String.format(str, objArr);
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zze.zza(this, parcel, flags);
    }

    public void zzb(DataPoint dataPoint) {
        this.zzauk.add(dataPoint);
        DataSource originalDataSource = dataPoint.getOriginalDataSource();
        if (originalDataSource != null && !this.zzaul.contains(originalDataSource)) {
            this.zzaul.add(originalDataSource);
        }
    }

    public void zzb(Iterable<DataPoint> iterable) {
        for (DataPoint zzb : iterable) {
            zzb(zzb);
        }
    }

    List<RawDataPoint> zzt(List<DataSource> list) {
        List<RawDataPoint> arrayList = new ArrayList(this.zzauk.size());
        for (DataPoint rawDataPoint : this.zzauk) {
            arrayList.add(new RawDataPoint(rawDataPoint, list));
        }
        return arrayList;
    }

    public boolean zztA() {
        return this.zzaud;
    }

    List<RawDataPoint> zztI() {
        return zzt(this.zzaul);
    }

    List<DataSource> zztJ() {
        return this.zzaul;
    }
}
