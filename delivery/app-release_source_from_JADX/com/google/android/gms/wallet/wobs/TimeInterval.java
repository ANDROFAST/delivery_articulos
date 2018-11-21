package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class TimeInterval implements SafeParcelable {
    public static final Creator<TimeInterval> CREATOR = new zzg();
    private final int mVersionCode;
    long zzblG;
    long zzblH;

    TimeInterval() {
        this.mVersionCode = 1;
    }

    TimeInterval(int versionCode, long startTimestamp, long endTimestamp) {
        this.mVersionCode = versionCode;
        this.zzblG = startTimestamp;
        this.zzblH = endTimestamp;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzg.zza(this, dest, flags);
    }
}
