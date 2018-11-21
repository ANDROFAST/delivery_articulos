package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzpq;
import com.google.android.gms.internal.zzpq.zza;

public class GetSyncInfoRequest implements SafeParcelable {
    public static final Creator<GetSyncInfoRequest> CREATOR = new zzm();
    private final int mVersionCode;
    private final zzpq zzayH;

    GetSyncInfoRequest(int versionCode, IBinder callback) {
        this.mVersionCode = versionCode;
        this.zzayH = zza.zzbS(callback);
    }

    public int describeContents() {
        return 0;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        return String.format("GetSyncInfoRequest {%d, %s, %s}", new Object[]{Integer.valueOf(this.mVersionCode), this.zzayH});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzm.zza(this, parcel, flags);
    }

    public IBinder zzui() {
        return this.zzayH.asBinder();
    }
}
