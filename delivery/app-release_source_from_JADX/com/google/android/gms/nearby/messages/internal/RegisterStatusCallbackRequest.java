package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.internal.zzc.zza;

public final class RegisterStatusCallbackRequest implements SafeParcelable {
    public static final Creator<RegisterStatusCallbackRequest> CREATOR = new zzo();
    final int versionCode;
    public String zzaWI;
    public final zzf zzaXJ;
    public boolean zzaXK;
    public final zzc zzaXm;

    RegisterStatusCallbackRequest(int versionCode, IBinder callbackAsBinder, IBinder statusCallbackAsBinder, boolean isRegister, String zeroPartyPackageName) {
        this.versionCode = versionCode;
        this.zzaXm = zza.zzdu(callbackAsBinder);
        this.zzaXJ = zzf.zza.zzdx(statusCallbackAsBinder);
        this.zzaXK = isRegister;
        this.zzaWI = zeroPartyPackageName;
    }

    RegisterStatusCallbackRequest(IBinder callbackAsBinder, IBinder statusCallbackAsBinder, String zeroPartyPackageName) {
        this(1, callbackAsBinder, statusCallbackAsBinder, false, zeroPartyPackageName);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzo.zza(this, dest, flags);
    }

    IBinder zzCJ() {
        return this.zzaXm.asBinder();
    }

    IBinder zzCL() {
        return this.zzaXJ.asBinder();
    }
}
