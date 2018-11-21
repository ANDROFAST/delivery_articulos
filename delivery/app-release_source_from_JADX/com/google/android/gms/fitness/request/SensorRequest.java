package com.google.android.gms.fitness.request;

import android.os.SystemClock;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.location.LocationRequest;
import java.util.concurrent.TimeUnit;

public class SensorRequest {
    public static final int ACCURACY_MODE_DEFAULT = 2;
    public static final int ACCURACY_MODE_HIGH = 3;
    public static final int ACCURACY_MODE_LOW = 1;
    private final DataType zzatO;
    private final DataSource zzatP;
    private final long zzavf;
    private final int zzavg;
    private final long zzayQ;
    private final long zzayR;
    private final LocationRequest zzayV;
    private final long zzayW;

    public static class Builder {
        private DataType zzatO;
        private DataSource zzatP;
        private long zzavf = -1;
        private int zzavg = 2;
        private long zzayQ = 0;
        private long zzayR = 0;
        private long zzayW = Long.MAX_VALUE;
        private boolean zzayX = false;

        public SensorRequest build() {
            boolean z = false;
            boolean z2 = (this.zzatP == null && this.zzatO == null) ? false : true;
            zzx.zza(z2, (Object) "Must call setDataSource() or setDataType()");
            if (this.zzatO == null || this.zzatP == null || this.zzatO.equals(this.zzatP.getDataType())) {
                z = true;
            }
            zzx.zza(z, (Object) "Specified data type is incompatible with specified data source");
            return new SensorRequest();
        }

        public Builder setAccuracyMode(int accuracyMode) {
            this.zzavg = SensorRequest.zzft(accuracyMode);
            return this;
        }

        public Builder setDataSource(DataSource dataSource) {
            this.zzatP = dataSource;
            return this;
        }

        public Builder setDataType(DataType dataType) {
            this.zzatO = dataType;
            return this;
        }

        public Builder setFastestRate(int fastestInterval, TimeUnit unit) {
            zzx.zzb(fastestInterval >= 0, (Object) "Cannot use a negative interval");
            this.zzayX = true;
            this.zzayR = unit.toMicros((long) fastestInterval);
            return this;
        }

        public Builder setMaxDeliveryLatency(int interval, TimeUnit unit) {
            zzx.zzb(interval >= 0, (Object) "Cannot use a negative delivery interval");
            this.zzayQ = unit.toMicros((long) interval);
            return this;
        }

        public Builder setSamplingRate(long interval, TimeUnit unit) {
            zzx.zzb(interval >= 0, (Object) "Cannot use a negative sampling interval");
            this.zzavf = unit.toMicros(interval);
            if (!this.zzayX) {
                this.zzayR = this.zzavf / 2;
            }
            return this;
        }

        public Builder setTimeout(long timeout, TimeUnit timeUnit) {
            boolean z = true;
            zzx.zzb(timeout > 0, "Invalid time out value specified: %d", Long.valueOf(timeout));
            if (timeUnit == null) {
                z = false;
            }
            zzx.zzb(z, (Object) "Invalid time unit specified");
            this.zzayW = timeUnit.toMicros(timeout);
            return this;
        }
    }

    private SensorRequest(DataSource dataSource, LocationRequest locationRequest) {
        this.zzayV = locationRequest;
        this.zzavf = TimeUnit.MILLISECONDS.toMicros(locationRequest.getInterval());
        this.zzayR = TimeUnit.MILLISECONDS.toMicros(locationRequest.getFastestInterval());
        this.zzayQ = this.zzavf;
        this.zzatO = dataSource.getDataType();
        this.zzavg = zza(locationRequest);
        this.zzatP = dataSource;
        long expirationTime = locationRequest.getExpirationTime();
        if (expirationTime == Long.MAX_VALUE) {
            this.zzayW = Long.MAX_VALUE;
        } else {
            this.zzayW = TimeUnit.MILLISECONDS.toMicros(expirationTime - SystemClock.elapsedRealtime());
        }
    }

    private SensorRequest(Builder builder) {
        this.zzatP = builder.zzatP;
        this.zzatO = builder.zzatO;
        this.zzavf = builder.zzavf;
        this.zzayR = builder.zzayR;
        this.zzayQ = builder.zzayQ;
        this.zzavg = builder.zzavg;
        this.zzayV = null;
        this.zzayW = builder.zzayW;
    }

    public static SensorRequest fromLocationRequest(DataSource dataSource, LocationRequest locationRequest) {
        return new SensorRequest(dataSource, locationRequest);
    }

    private static int zza(LocationRequest locationRequest) {
        switch (locationRequest.getPriority()) {
            case 100:
                return 3;
            case LocationRequest.PRIORITY_LOW_POWER /*104*/:
                return 1;
            default:
                return 2;
        }
    }

    private boolean zza(SensorRequest sensorRequest) {
        return zzw.equal(this.zzatP, sensorRequest.zzatP) && zzw.equal(this.zzatO, sensorRequest.zzatO) && this.zzavf == sensorRequest.zzavf && this.zzayR == sensorRequest.zzayR && this.zzayQ == sensorRequest.zzayQ && this.zzavg == sensorRequest.zzavg && zzw.equal(this.zzayV, sensorRequest.zzayV) && this.zzayW == sensorRequest.zzayW;
    }

    public static int zzft(int i) {
        switch (i) {
            case 1:
            case 3:
                return i;
            default:
                return 2;
        }
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof SensorRequest) && zza((SensorRequest) that));
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

    public long getFastestRate(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzayR, TimeUnit.MICROSECONDS);
    }

    public long getMaxDeliveryLatency(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzayQ, TimeUnit.MICROSECONDS);
    }

    public long getSamplingRate(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzavf, TimeUnit.MICROSECONDS);
    }

    public int hashCode() {
        return zzw.hashCode(this.zzatP, this.zzatO, Long.valueOf(this.zzavf), Long.valueOf(this.zzayR), Long.valueOf(this.zzayQ), Integer.valueOf(this.zzavg), this.zzayV, Long.valueOf(this.zzayW));
    }

    public String toString() {
        return zzw.zzx(this).zzg("dataSource", this.zzatP).zzg("dataType", this.zzatO).zzg("samplingRateMicros", Long.valueOf(this.zzavf)).zzg("deliveryLatencyMicros", Long.valueOf(this.zzayQ)).zzg("timeOutMicros", Long.valueOf(this.zzayW)).toString();
    }

    public long zzuA() {
        return this.zzayW;
    }
}
