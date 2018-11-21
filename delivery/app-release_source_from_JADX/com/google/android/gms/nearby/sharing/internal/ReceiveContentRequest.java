package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.sharing.internal.zza.zza;

public final class ReceiveContentRequest implements SafeParcelable {
    public static final Creator<ReceiveContentRequest> CREATOR = new zzg();
    public String packageName;
    final int versionCode;
    public IBinder zzaXX;
    public zzc zzaYb;
    public zza zzaYc;

    ReceiveContentRequest() {
        this.versionCode = 1;
    }

    ReceiveContentRequest(int versionCode, IBinder clientBinder, IBinder contentReceiverAsBinder, String packageName, IBinder callbackAsBinder) {
        this.versionCode = versionCode;
        this.zzaXX = clientBinder;
        this.zzaYc = zza.zzdA(contentReceiverAsBinder);
        this.packageName = packageName;
        this.zzaYb = zzc.zza.zzdC(callbackAsBinder);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzg.zza(this, dest, flags);
    }

    IBinder zzCJ() {
        return this.zzaYb.asBinder();
    }

    IBinder zzCV() {
        return this.zzaYc == null ? null : this.zzaYc.asBinder();
    }
}
