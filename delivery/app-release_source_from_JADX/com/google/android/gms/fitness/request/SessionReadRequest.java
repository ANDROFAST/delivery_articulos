package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzpn;
import com.google.android.gms.internal.zzpn.zza;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SessionReadRequest implements SafeParcelable {
    public static final Creator<SessionReadRequest> CREATOR = new zzv();
    private final int mVersionCode;
    private final String zzJX;
    private final long zzQj;
    private final long zzatQ;
    private final List<DataType> zzatZ;
    private final List<DataSource> zzayl;
    private final boolean zzayw;
    private final String zzaza;
    private boolean zzazb;
    private final List<String> zzazc;
    private final zzpn zzazd;

    public static class Builder {
        private String zzJX;
        private long zzQj = 0;
        private long zzatQ = 0;
        private List<DataType> zzatZ = new ArrayList();
        private List<DataSource> zzayl = new ArrayList();
        private boolean zzayw = false;
        private String zzaza;
        private boolean zzazb = false;
        private List<String> zzazc = new ArrayList();

        public SessionReadRequest build() {
            zzx.zzb(this.zzQj > 0, "Invalid start time: %s", Long.valueOf(this.zzQj));
            boolean z = this.zzatQ > 0 && this.zzatQ > this.zzQj;
            zzx.zzb(z, "Invalid end time: %s", Long.valueOf(this.zzatQ));
            return new SessionReadRequest();
        }

        public Builder enableServerQueries() {
            this.zzayw = true;
            return this;
        }

        public Builder excludePackage(String appPackageName) {
            zzx.zzb((Object) appPackageName, (Object) "Attempting to use a null package name");
            if (!this.zzazc.contains(appPackageName)) {
                this.zzazc.add(appPackageName);
            }
            return this;
        }

        public Builder read(DataSource dataSource) {
            zzx.zzb((Object) dataSource, (Object) "Attempting to add a null data source");
            if (!this.zzayl.contains(dataSource)) {
                this.zzayl.add(dataSource);
            }
            return this;
        }

        public Builder read(DataType dataType) {
            zzx.zzb((Object) dataType, (Object) "Attempting to use a null data type");
            if (!this.zzatZ.contains(dataType)) {
                this.zzatZ.add(dataType);
            }
            return this;
        }

        public Builder readSessionsFromAllApps() {
            this.zzazb = true;
            return this;
        }

        public Builder setSessionId(String sessionId) {
            this.zzJX = sessionId;
            return this;
        }

        public Builder setSessionName(String sessionName) {
            this.zzaza = sessionName;
            return this;
        }

        public Builder setTimeInterval(long startTime, long endTime, TimeUnit timeUnit) {
            this.zzQj = timeUnit.toMillis(startTime);
            this.zzatQ = timeUnit.toMillis(endTime);
            return this;
        }
    }

    SessionReadRequest(int versionCode, String sessionName, String sessionId, long startTimeMillis, long endTimeMillis, List<DataType> dataTypes, List<DataSource> dataSources, boolean getSessionsFromAllApps, boolean serverQueriesEnabled, List<String> excludedPackages, IBinder callback) {
        this.mVersionCode = versionCode;
        this.zzaza = sessionName;
        this.zzJX = sessionId;
        this.zzQj = startTimeMillis;
        this.zzatQ = endTimeMillis;
        this.zzatZ = dataTypes;
        this.zzayl = dataSources;
        this.zzazb = getSessionsFromAllApps;
        this.zzayw = serverQueriesEnabled;
        this.zzazc = excludedPackages;
        this.zzazd = zza.zzbP(callback);
    }

    private SessionReadRequest(Builder builder) {
        this(builder.zzaza, builder.zzJX, builder.zzQj, builder.zzatQ, builder.zzatZ, builder.zzayl, builder.zzazb, builder.zzayw, builder.zzazc, null);
    }

    public SessionReadRequest(SessionReadRequest request, zzpn callback) {
        this(request.zzaza, request.zzJX, request.zzQj, request.zzatQ, request.zzatZ, request.zzayl, request.zzazb, request.zzayw, request.zzazc, callback);
    }

    public SessionReadRequest(String sessionName, String sessionId, long startTimeMillis, long endTimeMillis, List<DataType> dataTypes, List<DataSource> dataSources, boolean getSessionsFromAllApps, boolean serverQueriesEnabled, List<String> excludedPackages, zzpn callback) {
        this(5, sessionName, sessionId, startTimeMillis, endTimeMillis, dataTypes, dataSources, getSessionsFromAllApps, serverQueriesEnabled, excludedPackages, callback == null ? null : callback.asBinder());
    }

    private boolean zzb(SessionReadRequest sessionReadRequest) {
        return zzw.equal(this.zzaza, sessionReadRequest.zzaza) && this.zzJX.equals(sessionReadRequest.zzJX) && this.zzQj == sessionReadRequest.zzQj && this.zzatQ == sessionReadRequest.zzatQ && zzw.equal(this.zzatZ, sessionReadRequest.zzatZ) && zzw.equal(this.zzayl, sessionReadRequest.zzayl) && this.zzazb == sessionReadRequest.zzazb && this.zzazc.equals(sessionReadRequest.zzazc) && this.zzayw == sessionReadRequest.zzayw;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return this == o || ((o instanceof SessionReadRequest) && zzb((SessionReadRequest) o));
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

    public List<String> getExcludedPackages() {
        return this.zzazc;
    }

    public String getSessionId() {
        return this.zzJX;
    }

    public String getSessionName() {
        return this.zzaza;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzQj, TimeUnit.MILLISECONDS);
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaza, this.zzJX, Long.valueOf(this.zzQj), Long.valueOf(this.zzatQ));
    }

    public boolean includeSessionsFromAllApps() {
        return this.zzazb;
    }

    public String toString() {
        return zzw.zzx(this).zzg("sessionName", this.zzaza).zzg("sessionId", this.zzJX).zzg("startTimeMillis", Long.valueOf(this.zzQj)).zzg("endTimeMillis", Long.valueOf(this.zzatQ)).zzg("dataTypes", this.zzatZ).zzg("dataSources", this.zzayl).zzg("sessionsFromAllApps", Boolean.valueOf(this.zzazb)).zzg("excludedPackages", this.zzazc).zzg("useServer", Boolean.valueOf(this.zzayw)).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzv.zza(this, dest, flags);
    }

    public long zzlx() {
        return this.zzQj;
    }

    public long zztB() {
        return this.zzatQ;
    }

    public boolean zzuC() {
        return this.zzazb;
    }

    public IBinder zzui() {
        return this.zzazd == null ? null : this.zzazd.asBinder();
    }

    public boolean zzun() {
        return this.zzayw;
    }
}
