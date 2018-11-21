package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.sharing.internal.zzc.zza;

public final class TrustedDevicesRequest implements SafeParcelable {
    public static final Creator<TrustedDevicesRequest> CREATOR = new zzk();
    final int versionCode;
    public zzc zzaYb;
    public String zzaYd;
    public byte[] zzaYe;

    TrustedDevicesRequest(int versionCode, String deviceIdentifier, byte[] message, IBinder callbackAsBinder) {
        this.versionCode = versionCode;
        this.zzaYd = (String) zzx.zzy(deviceIdentifier);
        this.zzaYe = (byte[]) zzx.zzy(message);
        this.zzaYb = zza.zzdC(callbackAsBinder);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzk.zza(this, dest, flags);
    }

    IBinder zzCJ() {
        return this.zzaYb.asBinder();
    }
}
