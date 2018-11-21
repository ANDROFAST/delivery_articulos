package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzpp;
import com.google.android.gms.internal.zzpp.zza;

public class UnsubscribeRequest implements SafeParcelable {
    public static final Creator<UnsubscribeRequest> CREATOR = new zzae();
    private final int mVersionCode;
    private final DataType zzatO;
    private final DataSource zzatP;
    private final zzpp zzayj;

    UnsubscribeRequest(int versionCode, DataType dataType, DataSource dataSource, IBinder callback) {
        this.mVersionCode = versionCode;
        this.zzatO = dataType;
        this.zzatP = dataSource;
        this.zzayj = zza.zzbR(callback);
    }

    public UnsubscribeRequest(DataType dataType, DataSource dataSource, zzpp callback) {
        this.mVersionCode = 3;
        this.zzatO = dataType;
        this.zzatP = dataSource;
        this.zzayj = callback;
    }

    private boolean zzb(UnsubscribeRequest unsubscribeRequest) {
        return zzw.equal(this.zzatP, unsubscribeRequest.zzatP) && zzw.equal(this.zzatO, unsubscribeRequest.zzatO);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return this == o || ((o instanceof UnsubscribeRequest) && zzb((UnsubscribeRequest) o));
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
        return zzw.hashCode(this.zzatP, this.zzatO);
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzae.zza(this, parcel, flags);
    }

    public IBinder zzui() {
        return this.zzayj == null ? null : this.zzayj.asBinder();
    }
}
