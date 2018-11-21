package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.sharing.SharedContent;
import com.google.android.gms.nearby.sharing.internal.zzb.zza;
import java.util.List;

public final class ProvideContentRequest implements SafeParcelable {
    public static final Creator<ProvideContentRequest> CREATOR = new zzf();
    final int versionCode;
    public IBinder zzaXX;
    public zzb zzaXY;
    @Deprecated
    public List<SharedContent> zzaXZ;
    public long zzaYa;
    public zzc zzaYb;

    ProvideContentRequest() {
        this.versionCode = 1;
    }

    ProvideContentRequest(int versionCode, IBinder clientBinder, IBinder contentProviderAsBinder, List<SharedContent> content, long activityId, IBinder callbackAsBinder) {
        this.versionCode = versionCode;
        this.zzaXX = clientBinder;
        this.zzaXY = zza.zzdB(contentProviderAsBinder);
        this.zzaXZ = content;
        this.zzaYa = activityId;
        this.zzaYb = zzc.zza.zzdC(callbackAsBinder);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzf.zza(this, dest, flags);
    }

    IBinder zzCJ() {
        return this.zzaYb.asBinder();
    }

    IBinder zzCU() {
        return this.zzaXY == null ? null : this.zzaXY.asBinder();
    }
}
