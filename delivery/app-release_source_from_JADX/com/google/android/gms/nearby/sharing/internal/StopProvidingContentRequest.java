package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.sharing.internal.zzc.zza;

public final class StopProvidingContentRequest implements SafeParcelable {
    public static final Creator<StopProvidingContentRequest> CREATOR = new zzj();
    final int versionCode;
    public long zzaYa;
    public zzc zzaYb;

    StopProvidingContentRequest() {
        this.versionCode = 1;
    }

    StopProvidingContentRequest(int versionCode, long activityId, IBinder callbackAsBinder) {
        this.versionCode = versionCode;
        this.zzaYa = activityId;
        this.zzaYb = zza.zzdC(callbackAsBinder);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzj.zza(this, dest, flags);
    }

    IBinder zzCJ() {
        return this.zzaYb.asBinder();
    }
}
