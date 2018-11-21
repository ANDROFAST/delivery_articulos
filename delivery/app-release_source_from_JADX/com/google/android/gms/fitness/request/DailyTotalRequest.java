package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzoz;
import com.google.android.gms.internal.zzoz.zza;

public class DailyTotalRequest implements SafeParcelable {
    public static final Creator<DailyTotalRequest> CREATOR = new zzc();
    private final int mVersionCode;
    private DataType zzatO;
    private final zzoz zzayk;

    DailyTotalRequest(int versionCode, IBinder callback, DataType dataType) {
        this.mVersionCode = versionCode;
        this.zzayk = zza.zzbB(callback);
        this.zzatO = dataType;
    }

    public DailyTotalRequest(zzoz callback, DataType dataType) {
        this.mVersionCode = 2;
        this.zzayk = callback;
        this.zzatO = dataType;
    }

    public int describeContents() {
        return 0;
    }

    public DataType getDataType() {
        return this.zzatO;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        return String.format("DailyTotalRequest{%s}", new Object[]{this.zzatO.zztM()});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzc.zza(this, parcel, flags);
    }

    public IBinder zzui() {
        return this.zzayk.asBinder();
    }
}
