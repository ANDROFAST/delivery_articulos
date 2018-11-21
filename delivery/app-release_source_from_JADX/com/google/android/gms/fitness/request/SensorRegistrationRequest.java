package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.zzj;
import com.google.android.gms.fitness.data.zzj.zza;
import com.google.android.gms.internal.zzpp;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SensorRegistrationRequest implements SafeParcelable {
    public static final Creator<SensorRegistrationRequest> CREATOR = new zzs();
    private final PendingIntent mPendingIntent;
    private final int mVersionCode;
    private DataType zzatO;
    private DataSource zzatP;
    private final long zzavf;
    private final int zzavg;
    private zzj zzayN;
    int zzayO;
    int zzayP;
    private final long zzayQ;
    private final long zzayR;
    private final List<LocationRequest> zzayS;
    private final long zzayT;
    private final List<Object> zzayU;
    private final zzpp zzayj;

    SensorRegistrationRequest(int versionCode, DataSource dataSource, DataType dataType, IBinder listenerBinder, int samplingIntervalMicrosInt, int maxDeliveryLatencyMicrosInt, long samplingIntervalMicros, long maxDeliveryLatencyMicros, PendingIntent intent, long fastestIntervalMicros, int accuracyMode, List<LocationRequest> locationRequests, long registrationTimeOutMicros, IBinder callback) {
        this.mVersionCode = versionCode;
        this.zzatP = dataSource;
        this.zzatO = dataType;
        this.zzayN = listenerBinder == null ? null : zza.zzbt(listenerBinder);
        if (samplingIntervalMicros == 0) {
            samplingIntervalMicros = (long) samplingIntervalMicrosInt;
        }
        this.zzavf = samplingIntervalMicros;
        this.zzayR = fastestIntervalMicros;
        if (maxDeliveryLatencyMicros == 0) {
            maxDeliveryLatencyMicros = (long) maxDeliveryLatencyMicrosInt;
        }
        this.zzayQ = maxDeliveryLatencyMicros;
        this.zzayS = locationRequests;
        this.mPendingIntent = intent;
        this.zzavg = accuracyMode;
        this.zzayU = Collections.emptyList();
        this.zzayT = registrationTimeOutMicros;
        this.zzayj = zzpp.zza.zzbR(callback);
    }

    public SensorRegistrationRequest(DataSource dataSource, DataType dataType, zzj listener, PendingIntent pendingIntent, long samplingIntervalMicros, long fastestIntervalMicros, long maxDeliveryLatencyMicros, int accuracyMode, List<LocationRequest> locationRequests, List<Object> clientIdentities, long registrationTimeOutMicros, zzpp callback) {
        this.mVersionCode = 6;
        this.zzatP = dataSource;
        this.zzatO = dataType;
        this.zzayN = listener;
        this.mPendingIntent = pendingIntent;
        this.zzavf = samplingIntervalMicros;
        this.zzayR = fastestIntervalMicros;
        this.zzayQ = maxDeliveryLatencyMicros;
        this.zzavg = accuracyMode;
        this.zzayS = locationRequests;
        this.zzayU = clientIdentities;
        this.zzayT = registrationTimeOutMicros;
        this.zzayj = callback;
    }

    public SensorRegistrationRequest(SensorRequest request, zzj listener, PendingIntent intent, zzpp callback) {
        zzj com_google_android_gms_fitness_data_zzj = listener;
        PendingIntent pendingIntent = intent;
        this(request.getDataSource(), request.getDataType(), com_google_android_gms_fitness_data_zzj, pendingIntent, request.getSamplingRate(TimeUnit.MICROSECONDS), request.getFastestRate(TimeUnit.MICROSECONDS), request.getMaxDeliveryLatency(TimeUnit.MICROSECONDS), request.getAccuracyMode(), null, Collections.emptyList(), request.zzuA(), callback);
    }

    private boolean zzb(SensorRegistrationRequest sensorRegistrationRequest) {
        return zzw.equal(this.zzatP, sensorRegistrationRequest.zzatP) && zzw.equal(this.zzatO, sensorRegistrationRequest.zzatO) && this.zzavf == sensorRegistrationRequest.zzavf && this.zzayR == sensorRegistrationRequest.zzayR && this.zzayQ == sensorRegistrationRequest.zzayQ && this.zzavg == sensorRegistrationRequest.zzavg && zzw.equal(this.zzayS, sensorRegistrationRequest.zzayS);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof SensorRegistrationRequest) && zzb((SensorRegistrationRequest) that));
    }

    public int getAccuracyMode() {
        return this.zzavg;
    }

    public DataSource getDataSource() {
        return this.zzatP;
    }

    public DataType getDataType() {
        return this.zzatO;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzatP, this.zzatO, this.zzayN, Long.valueOf(this.zzavf), Long.valueOf(this.zzayR), Long.valueOf(this.zzayQ), Integer.valueOf(this.zzavg), this.zzayS);
    }

    public String toString() {
        return String.format("SensorRegistrationRequest{type %s source %s interval %s fastest %s latency %s}", new Object[]{this.zzatO, this.zzatP, Long.valueOf(this.zzavf), Long.valueOf(this.zzayR), Long.valueOf(this.zzayQ)});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzs.zza(this, parcel, flags);
    }

    public long zztU() {
        return this.zzavf;
    }

    public IBinder zzui() {
        return this.zzayj == null ? null : this.zzayj.asBinder();
    }

    public PendingIntent zzuu() {
        return this.mPendingIntent;
    }

    public long zzuv() {
        return this.zzayR;
    }

    public long zzuw() {
        return this.zzayQ;
    }

    public List<LocationRequest> zzux() {
        return this.zzayS;
    }

    public long zzuy() {
        return this.zzayT;
    }

    IBinder zzuz() {
        return this.zzayN == null ? null : this.zzayN.asBinder();
    }
}
