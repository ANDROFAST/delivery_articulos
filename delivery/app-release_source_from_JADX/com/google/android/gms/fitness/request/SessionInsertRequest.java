package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.zzol;
import com.google.android.gms.internal.zzpp;
import com.google.android.gms.internal.zzpp.zza;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SessionInsertRequest implements SafeParcelable {
    public static final Creator<SessionInsertRequest> CREATOR = new zzu();
    private final int mVersionCode;
    private final Session zzatS;
    private final List<DataSet> zzaub;
    private final List<DataPoint> zzayY;
    private final zzpp zzayj;

    public static class Builder {
        private Session zzatS;
        private List<DataSet> zzaub = new ArrayList();
        private List<DataPoint> zzayY = new ArrayList();
        private List<DataSource> zzayZ = new ArrayList();

        private void zze(DataPoint dataPoint) {
            zzg(dataPoint);
            zzf(dataPoint);
        }

        private void zzf(DataPoint dataPoint) {
            long startTime = this.zzatS.getStartTime(TimeUnit.NANOSECONDS);
            long endTime = this.zzatS.getEndTime(TimeUnit.NANOSECONDS);
            long startTime2 = dataPoint.getStartTime(TimeUnit.NANOSECONDS);
            long endTime2 = dataPoint.getEndTime(TimeUnit.NANOSECONDS);
            if (startTime2 != 0 && endTime2 != 0) {
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                if (endTime2 > endTime) {
                    endTime2 = zzol.zza(endTime2, TimeUnit.NANOSECONDS, timeUnit);
                }
                boolean z = startTime2 >= startTime && endTime2 <= endTime;
                zzx.zza(z, "Data point %s has start and end times outside session interval [%d, %d]", dataPoint, Long.valueOf(startTime), Long.valueOf(endTime));
                if (endTime2 != dataPoint.getEndTime(TimeUnit.NANOSECONDS)) {
                    Log.w("Fitness", String.format("Data point end time [%d] is truncated to [%d] to match the precision [%s] of the session start and end time", new Object[]{Long.valueOf(dataPoint.getEndTime(TimeUnit.NANOSECONDS)), Long.valueOf(endTime2), timeUnit}));
                    dataPoint.setTimeInterval(startTime2, endTime2, TimeUnit.NANOSECONDS);
                }
            }
        }

        private void zzg(DataPoint dataPoint) {
            long startTime = this.zzatS.getStartTime(TimeUnit.NANOSECONDS);
            long endTime = this.zzatS.getEndTime(TimeUnit.NANOSECONDS);
            long timestamp = dataPoint.getTimestamp(TimeUnit.NANOSECONDS);
            if (timestamp != 0) {
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                if (timestamp < startTime || timestamp > endTime) {
                    timestamp = zzol.zza(timestamp, TimeUnit.NANOSECONDS, timeUnit);
                }
                boolean z = timestamp >= startTime && timestamp <= endTime;
                zzx.zza(z, "Data point %s has time stamp outside session interval [%d, %d]", dataPoint, Long.valueOf(startTime), Long.valueOf(endTime));
                if (dataPoint.getTimestamp(TimeUnit.NANOSECONDS) != timestamp) {
                    Log.w("Fitness", String.format("Data point timestamp [%d] is truncated to [%d] to match the precision [%s] of the session start and end time", new Object[]{Long.valueOf(dataPoint.getTimestamp(TimeUnit.NANOSECONDS)), Long.valueOf(timestamp), timeUnit}));
                    dataPoint.setTimestamp(timestamp, TimeUnit.NANOSECONDS);
                }
            }
        }

        private void zzuB() {
            for (DataSet dataPoints : this.zzaub) {
                for (DataPoint zze : dataPoints.getDataPoints()) {
                    zze(zze);
                }
            }
            for (DataPoint zze2 : this.zzayY) {
                zze(zze2);
            }
        }

        public Builder addAggregateDataPoint(DataPoint aggregateDataPoint) {
            zzx.zzb(aggregateDataPoint != null, (Object) "Must specify a valid aggregate data point.");
            long startTime = aggregateDataPoint.getStartTime(TimeUnit.NANOSECONDS);
            boolean z = startTime > 0 && aggregateDataPoint.getEndTime(TimeUnit.NANOSECONDS) > startTime;
            zzx.zzb(z, "Aggregate data point should have valid start and end times: %s", aggregateDataPoint);
            DataSource dataSource = aggregateDataPoint.getDataSource();
            zzx.zza(!this.zzayZ.contains(dataSource), "Data set/Aggregate data point for this data source %s is already added.", dataSource);
            this.zzayZ.add(dataSource);
            this.zzayY.add(aggregateDataPoint);
            return this;
        }

        public Builder addDataSet(DataSet dataSet) {
            boolean z = true;
            zzx.zzb(dataSet != null, (Object) "Must specify a valid data set.");
            DataSource dataSource = dataSet.getDataSource();
            zzx.zza(!this.zzayZ.contains(dataSource), "Data set for this data source %s is already added.", dataSource);
            if (dataSet.getDataPoints().isEmpty()) {
                z = false;
            }
            zzx.zzb(z, (Object) "No data points specified in the input data set.");
            this.zzayZ.add(dataSource);
            this.zzaub.add(dataSet);
            return this;
        }

        public SessionInsertRequest build() {
            boolean z = true;
            zzx.zza(this.zzatS != null, (Object) "Must specify a valid session.");
            if (this.zzatS.getEndTime(TimeUnit.MILLISECONDS) == 0) {
                z = false;
            }
            zzx.zza(z, (Object) "Must specify a valid end time, cannot insert a continuing session.");
            zzuB();
            return new SessionInsertRequest();
        }

        public Builder setSession(Session session) {
            this.zzatS = session;
            return this;
        }
    }

    SessionInsertRequest(int versionCode, Session session, List<DataSet> dataSets, List<DataPoint> aggregateDataPoints, IBinder callback) {
        this.mVersionCode = versionCode;
        this.zzatS = session;
        this.zzaub = Collections.unmodifiableList(dataSets);
        this.zzayY = Collections.unmodifiableList(aggregateDataPoints);
        this.zzayj = zza.zzbR(callback);
    }

    public SessionInsertRequest(Session session, List<DataSet> dataSets, List<DataPoint> aggregateDataPoints, zzpp callback) {
        this.mVersionCode = 3;
        this.zzatS = session;
        this.zzaub = Collections.unmodifiableList(dataSets);
        this.zzayY = Collections.unmodifiableList(aggregateDataPoints);
        this.zzayj = callback;
    }

    private SessionInsertRequest(Builder builder) {
        this(builder.zzatS, builder.zzaub, builder.zzayY, null);
    }

    public SessionInsertRequest(SessionInsertRequest request, zzpp callback) {
        this(request.zzatS, request.zzaub, request.zzayY, callback);
    }

    private boolean zzb(SessionInsertRequest sessionInsertRequest) {
        return zzw.equal(this.zzatS, sessionInsertRequest.zzatS) && zzw.equal(this.zzaub, sessionInsertRequest.zzaub) && zzw.equal(this.zzayY, sessionInsertRequest.zzayY);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof SessionInsertRequest) && zzb((SessionInsertRequest) o));
    }

    public List<DataPoint> getAggregateDataPoints() {
        return this.zzayY;
    }

    public List<DataSet> getDataSets() {
        return this.zzaub;
    }

    public Session getSession() {
        return this.zzatS;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzatS, this.zzaub, this.zzayY);
    }

    public String toString() {
        return zzw.zzx(this).zzg("session", this.zzatS).zzg("dataSets", this.zzaub).zzg("aggregateDataPoints", this.zzayY).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzu.zza(this, dest, flags);
    }

    public IBinder zzui() {
        return this.zzayj == null ? null : this.zzayj.asBinder();
    }
}
