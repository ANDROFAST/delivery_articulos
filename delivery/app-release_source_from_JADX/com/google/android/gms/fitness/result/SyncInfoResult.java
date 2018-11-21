package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class SyncInfoResult implements Result, SafeParcelable {
    public static final Creator<SyncInfoResult> CREATOR = new zzl();
    private final int mVersionCode;
    private final Status zzTA;
    private final long zzacS;

    SyncInfoResult(int versionCode, Status status, long timestamp) {
        this.mVersionCode = versionCode;
        this.zzTA = status;
        this.zzacS = timestamp;
    }

    private boolean zzb(SyncInfoResult syncInfoResult) {
        return this.zzTA.equals(syncInfoResult.zzTA) && zzw.equal(Long.valueOf(this.zzacS), Long.valueOf(syncInfoResult.zzacS));
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof SyncInfoResult) && zzb((SyncInfoResult) that));
    }

    public Status getStatus() {
        return this.zzTA;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzTA, Long.valueOf(this.zzacS));
    }

    public String toString() {
        return zzw.zzx(this).zzg("status", this.zzTA).zzg("timestamp", Long.valueOf(this.zzacS)).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzl.zza(this, dest, flags);
    }

    public long zzuO() {
        return this.zzacS;
    }
}
