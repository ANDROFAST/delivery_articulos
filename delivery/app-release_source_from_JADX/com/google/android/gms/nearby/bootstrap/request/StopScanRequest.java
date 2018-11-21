package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzqv;
import com.google.android.gms.internal.zzqv.zza;

public class StopScanRequest implements SafeParcelable {
    public static final zzh CREATOR = new zzh();
    final int versionCode;
    private final zzqv zzaVY;

    StopScanRequest(int versionCode, IBinder callback) {
        this.versionCode = versionCode;
        zzx.zzy(callback);
        this.zzaVY = zza.zzdn(callback);
    }

    public int describeContents() {
        zzh com_google_android_gms_nearby_bootstrap_request_zzh = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzh com_google_android_gms_nearby_bootstrap_request_zzh = CREATOR;
        zzh.zza(this, out, flags);
    }

    public IBinder zzui() {
        return this.zzaVY == null ? null : this.zzaVY.asBinder();
    }
}
