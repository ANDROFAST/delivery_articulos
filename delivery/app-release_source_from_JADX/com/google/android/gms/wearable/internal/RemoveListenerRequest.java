package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.zzba.zza;

public class RemoveListenerRequest implements SafeParcelable {
    public static final Creator<RemoveListenerRequest> CREATOR = new zzbv();
    final int mVersionCode;
    public final zzba zzbmw;

    RemoveListenerRequest(int versionCode, IBinder listener) {
        this.mVersionCode = versionCode;
        if (listener != null) {
            this.zzbmw = zza.zzeq(listener);
        } else {
            this.zzbmw = null;
        }
    }

    public RemoveListenerRequest(zzba listener) {
        this.mVersionCode = 1;
        this.zzbmw = listener;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbv.zza(this, dest, flags);
    }

    IBinder zzGB() {
        return this.zzbmw == null ? null : this.zzbmw.asBinder();
    }
}
