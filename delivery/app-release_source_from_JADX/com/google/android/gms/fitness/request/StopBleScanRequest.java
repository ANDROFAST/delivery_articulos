package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.request.zzn.zza;
import com.google.android.gms.internal.zzpp;

public class StopBleScanRequest implements SafeParcelable {
    public static final Creator<StopBleScanRequest> CREATOR = new zzab();
    private final int mVersionCode;
    private final zzpp zzayj;
    private final zzn zzazg;

    StopBleScanRequest(int versionCode, IBinder bleScanCallback, IBinder callback) {
        this.mVersionCode = versionCode;
        this.zzazg = zza.zzbU(bleScanCallback);
        this.zzayj = zzpp.zza.zzbR(callback);
    }

    public StopBleScanRequest(BleScanCallback bleScanCallback, zzpp callback) {
        this(zza.zza.zzug().zzb(bleScanCallback), callback);
    }

    public StopBleScanRequest(zzn bleScanCallback, zzpp callback) {
        this.mVersionCode = 3;
        this.zzazg = bleScanCallback;
        this.zzayj = callback;
    }

    public int describeContents() {
        return 0;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzab.zza(this, parcel, flags);
    }

    public IBinder zzuE() {
        return this.zzazg.asBinder();
    }

    public IBinder zzui() {
        return this.zzayj == null ? null : this.zzayj.asBinder();
    }
}
