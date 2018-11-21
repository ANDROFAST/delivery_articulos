package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzpk;
import com.google.android.gms.internal.zzpk.zza;

public class ListSubscriptionsRequest implements SafeParcelable {
    public static final Creator<ListSubscriptionsRequest> CREATOR = new zzp();
    private final int mVersionCode;
    private final DataType zzatO;
    private final zzpk zzayJ;

    ListSubscriptionsRequest(int versionCode, DataType dataType, IBinder callback) {
        this.mVersionCode = versionCode;
        this.zzatO = dataType;
        this.zzayJ = zza.zzbM(callback);
    }

    public ListSubscriptionsRequest(DataType dataType, zzpk callback) {
        this.mVersionCode = 3;
        this.zzatO = dataType;
        this.zzayJ = callback;
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

    public void writeToParcel(Parcel parcel, int flags) {
        zzp.zza(this, parcel, flags);
    }

    public IBinder zzui() {
        return this.zzayJ == null ? null : this.zzayJ.asBinder();
    }
}
