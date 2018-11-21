package com.google.android.gms.fitness.service;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.zzj;
import com.google.android.gms.fitness.data.zzj.zza;
import java.util.concurrent.TimeUnit;

public class FitnessSensorServiceRequest implements SafeParcelable {
    public static final Creator<FitnessSensorServiceRequest> CREATOR = new zza();
    public static final int UNSPECIFIED = -1;
    private final int mVersionCode;
    private final DataSource zzatP;
    private final zzj zzayN;
    private final long zzazx;
    private final long zzazy;

    FitnessSensorServiceRequest(int versionCode, DataSource dataSource, IBinder listenerBinder, long samplingRateMicros, long batchIntervalMicros) {
        this.mVersionCode = versionCode;
        this.zzatP = dataSource;
        this.zzayN = zza.zzbt(listenerBinder);
        this.zzazx = samplingRateMicros;
        this.zzazy = batchIntervalMicros;
    }

    private boolean zza(FitnessSensorServiceRequest fitnessSensorServiceRequest) {
        return zzw.equal(this.zzatP, fitnessSensorServiceRequest.zzatP) && this.zzazx == fitnessSensorServiceRequest.zzazx && this.zzazy == fitnessSensorServiceRequest.zzazy;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof FitnessSensorServiceRequest) && zza((FitnessSensorServiceRequest) that));
    }

    public long getBatchInterval(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzazy, TimeUnit.MICROSECONDS);
    }

    public DataSource getDataSource() {
        return this.zzatP;
    }

    public SensorEventDispatcher getDispatcher() {
        return new zzb(this.zzayN);
    }

    public long getSamplingRate(TimeUnit timeUnit) {
        return this.zzazx == -1 ? -1 : timeUnit.convert(this.zzazx, TimeUnit.MICROSECONDS);
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzatP, Long.valueOf(this.zzazx), Long.valueOf(this.zzazy));
    }

    public String toString() {
        return String.format("FitnessSensorServiceRequest{%s}", new Object[]{this.zzatP});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zza.zza(this, parcel, flags);
    }

    public long zztU() {
        return this.zzazx;
    }

    public long zzuQ() {
        return this.zzazy;
    }

    IBinder zzuz() {
        return this.zzayN.asBinder();
    }
}
