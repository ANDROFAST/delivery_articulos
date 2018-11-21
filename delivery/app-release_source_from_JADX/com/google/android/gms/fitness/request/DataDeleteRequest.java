package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.zzpp;
import com.google.android.gms.internal.zzpp.zza;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DataDeleteRequest implements SafeParcelable {
    public static final Creator<DataDeleteRequest> CREATOR = new zzd();
    private final int mVersionCode;
    private final long zzQj;
    private final long zzatQ;
    private final List<DataType> zzatZ;
    private final zzpp zzayj;
    private final List<DataSource> zzayl;
    private final List<Session> zzaym;
    private final boolean zzayn;
    private final boolean zzayo;

    public static class Builder {
        private long zzQj;
        private long zzatQ;
        private List<DataType> zzatZ = new ArrayList();
        private List<DataSource> zzayl = new ArrayList();
        private List<Session> zzaym = new ArrayList();
        private boolean zzayn = false;
        private boolean zzayo = false;

        private void zzul() {
            if (!this.zzaym.isEmpty()) {
                for (Session session : this.zzaym) {
                    boolean z = session.getStartTime(TimeUnit.MILLISECONDS) >= this.zzQj && session.getEndTime(TimeUnit.MILLISECONDS) <= this.zzatQ;
                    zzx.zza(z, "Session %s is outside the time interval [%d, %d]", session, Long.valueOf(this.zzQj), Long.valueOf(this.zzatQ));
                }
            }
        }

        public Builder addDataSource(DataSource dataSource) {
            boolean z = true;
            zzx.zzb(!this.zzayn, (Object) "All data is already marked for deletion.  addDataSource() cannot be combined with deleteAllData()");
            if (dataSource == null) {
                z = false;
            }
            zzx.zzb(z, (Object) "Must specify a valid data source");
            if (!this.zzayl.contains(dataSource)) {
                this.zzayl.add(dataSource);
            }
            return this;
        }

        public Builder addDataType(DataType dataType) {
            boolean z = true;
            zzx.zzb(!this.zzayn, (Object) "All data is already marked for deletion.  addDataType() cannot be combined with deleteAllData()");
            if (dataType == null) {
                z = false;
            }
            zzx.zzb(z, (Object) "Must specify a valid data type");
            if (!this.zzatZ.contains(dataType)) {
                this.zzatZ.add(dataType);
            }
            return this;
        }

        public Builder addSession(Session session) {
            boolean z = true;
            zzx.zzb(!this.zzayo, (Object) "All sessions already marked for deletion.  addSession() cannot be combined with deleteAllSessions()");
            zzx.zzb(session != null, (Object) "Must specify a valid session");
            if (session.getEndTime(TimeUnit.MILLISECONDS) <= 0) {
                z = false;
            }
            zzx.zzb(z, (Object) "Cannot delete an ongoing session. Please stop the session prior to deleting it");
            this.zzaym.add(session);
            return this;
        }

        public DataDeleteRequest build() {
            boolean z = false;
            boolean z2 = this.zzQj > 0 && this.zzatQ > this.zzQj;
            zzx.zza(z2, (Object) "Must specify a valid time interval");
            z2 = (!this.zzayn && this.zzayl.isEmpty() && this.zzatZ.isEmpty()) ? false : true;
            boolean z3 = this.zzayo || !this.zzaym.isEmpty();
            if (z2 || z3) {
                z = true;
            }
            zzx.zza(z, (Object) "No data or session marked for deletion");
            zzul();
            return new DataDeleteRequest();
        }

        public Builder deleteAllData() {
            zzx.zzb(this.zzatZ.isEmpty(), (Object) "Specific data type already added for deletion. deleteAllData() will delete all data types and cannot be combined with addDataType()");
            zzx.zzb(this.zzayl.isEmpty(), (Object) "Specific data source already added for deletion. deleteAllData() will delete all data sources and cannot be combined with addDataSource()");
            this.zzayn = true;
            return this;
        }

        public Builder deleteAllSessions() {
            zzx.zzb(this.zzaym.isEmpty(), (Object) "Specific session already added for deletion. deleteAllData() will delete all sessions and cannot be combined with addSession()");
            this.zzayo = true;
            return this;
        }

        public Builder setTimeInterval(long startTime, long endTime, TimeUnit timeUnit) {
            zzx.zzb(startTime > 0, "Invalid start time :%d", Long.valueOf(startTime));
            zzx.zzb(endTime > startTime, "Invalid end time :%d", Long.valueOf(endTime));
            this.zzQj = timeUnit.toMillis(startTime);
            this.zzatQ = timeUnit.toMillis(endTime);
            return this;
        }
    }

    DataDeleteRequest(int versionCode, long startTimeMillis, long endTimeMillis, List<DataSource> dataSources, List<DataType> dataTypes, List<Session> sessions, boolean deleteAllData, boolean deleteAllSessions, IBinder callback) {
        this.mVersionCode = versionCode;
        this.zzQj = startTimeMillis;
        this.zzatQ = endTimeMillis;
        this.zzayl = Collections.unmodifiableList(dataSources);
        this.zzatZ = Collections.unmodifiableList(dataTypes);
        this.zzaym = sessions;
        this.zzayn = deleteAllData;
        this.zzayo = deleteAllSessions;
        this.zzayj = zza.zzbR(callback);
    }

    public DataDeleteRequest(long startTimeMillis, long endTimeMillis, List<DataSource> dataSources, List<DataType> dataTypes, List<Session> sessions, boolean deleteAllData, boolean deleteAllSessions, zzpp callback) {
        this.mVersionCode = 3;
        this.zzQj = startTimeMillis;
        this.zzatQ = endTimeMillis;
        this.zzayl = Collections.unmodifiableList(dataSources);
        this.zzatZ = Collections.unmodifiableList(dataTypes);
        this.zzaym = sessions;
        this.zzayn = deleteAllData;
        this.zzayo = deleteAllSessions;
        this.zzayj = callback;
    }

    private DataDeleteRequest(Builder builder) {
        this(builder.zzQj, builder.zzatQ, builder.zzayl, builder.zzatZ, builder.zzaym, builder.zzayn, builder.zzayo, null);
    }

    public DataDeleteRequest(DataDeleteRequest request, zzpp callback) {
        this(request.zzQj, request.zzatQ, request.zzayl, request.zzatZ, request.zzaym, request.zzayn, request.zzayo, callback);
    }

    private boolean zzb(DataDeleteRequest dataDeleteRequest) {
        return this.zzQj == dataDeleteRequest.zzQj && this.zzatQ == dataDeleteRequest.zzatQ && zzw.equal(this.zzayl, dataDeleteRequest.zzayl) && zzw.equal(this.zzatZ, dataDeleteRequest.zzatZ) && zzw.equal(this.zzaym, dataDeleteRequest.zzaym) && this.zzayn == dataDeleteRequest.zzayn && this.zzayo == dataDeleteRequest.zzayo;
    }

    public boolean deleteAllData() {
        return this.zzayn;
    }

    public boolean deleteAllSessions() {
        return this.zzayo;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof DataDeleteRequest) && zzb((DataDeleteRequest) o));
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

    public List<Session> getSessions() {
        return this.zzaym;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzQj, TimeUnit.MILLISECONDS);
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Long.valueOf(this.zzQj), Long.valueOf(this.zzatQ));
    }

    public String toString() {
        return zzw.zzx(this).zzg("startTimeMillis", Long.valueOf(this.zzQj)).zzg("endTimeMillis", Long.valueOf(this.zzatQ)).zzg("dataSources", this.zzayl).zzg("dateTypes", this.zzatZ).zzg("sessions", this.zzaym).zzg("deleteAllData", Boolean.valueOf(this.zzayn)).zzg("deleteAllSessions", Boolean.valueOf(this.zzayo)).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzd.zza(this, dest, flags);
    }

    public long zzlx() {
        return this.zzQj;
    }

    public long zztB() {
        return this.zzatQ;
    }

    public IBinder zzui() {
        return this.zzayj == null ? null : this.zzayj.asBinder();
    }

    public boolean zzuj() {
        return this.zzayn;
    }

    public boolean zzuk() {
        return this.zzayo;
    }
}
