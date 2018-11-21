package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.zzba.zza;

public class AddListenerRequest implements SafeParcelable {
    public static final Creator<AddListenerRequest> CREATOR = new zzc();
    final int mVersionCode;
    public final zzba zzbmw;
    public final IntentFilter[] zzbmx;
    public final String zzbmy;
    public final String zzbmz;

    AddListenerRequest(int versionCode, IBinder listener, IntentFilter[] filters, String channelToken, String capability) {
        this.mVersionCode = versionCode;
        if (listener != null) {
            this.zzbmw = zza.zzeq(listener);
        } else {
            this.zzbmw = null;
        }
        this.zzbmx = filters;
        this.zzbmy = channelToken;
        this.zzbmz = capability;
    }

    public AddListenerRequest(zzcf stub) {
        this.mVersionCode = 1;
        this.zzbmw = stub;
        this.zzbmx = stub.zzGZ();
        this.zzbmy = stub.zzHa();
        this.zzbmz = null;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzc.zza(this, dest, flags);
    }

    IBinder zzGB() {
        return this.zzbmw == null ? null : this.zzbmw.asBinder();
    }
}
