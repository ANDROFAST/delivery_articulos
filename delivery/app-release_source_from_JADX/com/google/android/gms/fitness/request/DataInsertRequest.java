package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.internal.zzpp;
import com.google.android.gms.internal.zzpp.zza;

public class DataInsertRequest implements SafeParcelable {
    public static final Creator<DataInsertRequest> CREATOR = new zze();
    private final int mVersionCode;
    private final DataSet zzave;
    private final zzpp zzayj;
    private final boolean zzayp;

    DataInsertRequest(int versionCode, DataSet dataSet, IBinder callback, boolean skipSync) {
        this.mVersionCode = versionCode;
        this.zzave = dataSet;
        this.zzayj = zza.zzbR(callback);
        this.zzayp = skipSync;
    }

    public DataInsertRequest(DataSet dataSet, zzpp callback, boolean skipSync) {
        this.mVersionCode = 4;
        this.zzave = dataSet;
        this.zzayj = callback;
        this.zzayp = skipSync;
    }

    private boolean zzc(DataInsertRequest dataInsertRequest) {
        return zzw.equal(this.zzave, dataInsertRequest.zzave);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof DataInsertRequest) && zzc((DataInsertRequest) o));
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzave);
    }

    public String toString() {
        return zzw.zzx(this).zzg("dataSet", this.zzave).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zze.zza(this, dest, flags);
    }

    public DataSet zztT() {
        return this.zzave;
    }

    public IBinder zzui() {
        return this.zzayj == null ? null : this.zzayj.asBinder();
    }

    public boolean zzum() {
        return this.zzayp;
    }
}
