package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzqv;
import com.google.android.gms.internal.zzqv.zza;
import com.google.android.gms.nearby.bootstrap.Device;

public class DisconnectRequest implements SafeParcelable {
    public static final zzd CREATOR = new zzd();
    final int versionCode;
    private final Device zzaVV;
    private final zzqv zzaVY;

    DisconnectRequest(int versionCode, Device device, IBinder callback) {
        this.versionCode = versionCode;
        this.zzaVV = (Device) zzx.zzy(device);
        zzx.zzy(callback);
        this.zzaVY = zza.zzdn(callback);
    }

    public int describeContents() {
        zzd com_google_android_gms_nearby_bootstrap_request_zzd = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzd com_google_android_gms_nearby_bootstrap_request_zzd = CREATOR;
        zzd.zza(this, out, flags);
    }

    public Device zzCm() {
        return this.zzaVV;
    }

    public IBinder zzui() {
        return this.zzaVY.asBinder();
    }
}
