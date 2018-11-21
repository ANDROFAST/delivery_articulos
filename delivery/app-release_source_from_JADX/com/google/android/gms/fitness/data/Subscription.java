package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public class Subscription implements SafeParcelable {
    public static final Creator<Subscription> CREATOR = new zzr();
    private final int mVersionCode;
    private final DataType zzatO;
    private final DataSource zzatP;
    private final long zzavf;
    private final int zzavg;

    public static class zza {
        private DataType zzatO;
        private DataSource zzatP;
        private long zzavf = -1;
        private int zzavg = 2;

        public zza zzb(DataSource dataSource) {
            this.zzatP = dataSource;
            return this;
        }

        public zza zzb(DataType dataType) {
            this.zzatO = dataType;
            return this;
        }

        public Subscription zztW() {
            boolean z = false;
            boolean z2 = (this.zzatP == null && this.zzatO == null) ? false : true;
            zzx.zza(z2, (Object) "Must call setDataSource() or setDataType()");
            if (this.zzatO == null || this.zzatP == null || this.zzatO.equals(this.zzatP.getDataType())) {
                z = true;
            }
            zzx.zza(z, (Object) "Specified data type is incompatible with specified data source");
            return new Subscription();
        }
    }

    Subscription(int versionCode, DataSource dataSource, DataType dataType, long samplingIntervalMicros, int accuracyMode) {
        this.mVersionCode = versionCode;
        this.zzatP = dataSource;
        this.zzatO = dataType;
        this.zzavf = samplingIntervalMicros;
        this.zzavg = accuracyMode;
    }

    private Subscription(zza builder) {
        this.mVersionCode = 1;
        this.zzatO = builder.zzatO;
        this.zzatP = builder.zzatP;
        this.zzavf = builder.zzavf;
        this.zzavg = builder.zzavg;
    }

    private boolean zza(Subscription subscription) {
        return zzw.equal(this.zzatP, subscription.zzatP) && zzw.equal(this.zzatO, subscription.zzatO) && this.zzavf == subscription.zzavf && this.zzavg == subscription.zzavg;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof Subscription) && zza((Subscription) that));
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
        return zzw.hashCode(this.zzatP, this.zzatP, Long.valueOf(this.zzavf), Integer.valueOf(this.zzavg));
    }

    public String toDebugString() {
        String str = "Subscription{%s}";
        Object[] objArr = new Object[1];
        objArr[0] = this.zzatP == null ? this.zzatO.getName() : this.zzatP.toDebugString();
        return String.format(str, objArr);
    }

    public String toString() {
        return zzw.zzx(this).zzg("dataSource", this.zzatP).zzg("dataType", this.zzatO).zzg("samplingIntervalMicros", Long.valueOf(this.zzavf)).zzg("accuracyMode", Integer.valueOf(this.zzavg)).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzr.zza(this, dest, flags);
    }

    public long zztU() {
        return this.zzavf;
    }

    public DataType zztV() {
        return this.zzatO == null ? this.zzatP.getDataType() : this.zzatO;
    }
}
