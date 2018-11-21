package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzqv;
import com.google.android.gms.internal.zzqv.zza;
import com.google.android.gms.nearby.bootstrap.Device;

public class SendDataRequest implements SafeParcelable {
    public static final zzf CREATOR = new zzf();
    private final byte[] data;
    final int versionCode;
    private final Device zzaVV;
    private final zzqv zzaVY;

    SendDataRequest(int versionCode, Device device, byte[] data, IBinder callback) {
        this.versionCode = versionCode;
        this.zzaVV = (Device) zzx.zzy(device);
        this.data = (byte[]) zzx.zzy(data);
        zzx.zzy(callback);
        this.zzaVY = zza.zzdn(callback);
    }

    public int describeContents() {
        zzf com_google_android_gms_nearby_bootstrap_request_zzf = CREATOR;
        return 0;
    }

    public byte[] getData() {
        return this.data;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzf com_google_android_gms_nearby_bootstrap_request_zzf = CREATOR;
        zzf.zza(this, out, flags);
    }

    public Device zzCm() {
        return this.zzaVV;
    }

    public IBinder zzui() {
        return this.zzaVY == null ? null : this.zzaVY.asBinder();
    }
}
