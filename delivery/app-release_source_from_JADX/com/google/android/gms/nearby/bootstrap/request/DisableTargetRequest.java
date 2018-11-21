package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzqv;
import com.google.android.gms.internal.zzqv.zza;

public class DisableTargetRequest implements SafeParcelable {
    public static final zzc CREATOR = new zzc();
    final int versionCode;
    private final zzqv zzaVY;

    DisableTargetRequest(int versionCode, IBinder callback) {
        this.versionCode = versionCode;
        zzx.zzy(callback);
        this.zzaVY = zza.zzdn(callback);
    }

    public int describeContents() {
        zzc com_google_android_gms_nearby_bootstrap_request_zzc = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzc com_google_android_gms_nearby_bootstrap_request_zzc = CREATOR;
        zzc.zza(this, out, flags);
    }

    public IBinder zzui() {
        return this.zzaVY == null ? null : this.zzaVY.asBinder();
    }
}
