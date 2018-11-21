package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.concurrent.TimeUnit;

public final class PlaceRequest implements SafeParcelable {
    public static final Creator<PlaceRequest> CREATOR = new zzk();
    static final long zzaMQ = TimeUnit.HOURS.toMillis(1);
    private final int mPriority;
    final int mVersionCode;
    private final long zzaKP;
    private final long zzaLk;
    private final PlaceFilter zzaMR;

    public PlaceRequest(int versionCode, PlaceFilter filter, long interval, int priority, long expireAt) {
        this.mVersionCode = versionCode;
        this.zzaMR = filter;
        this.zzaLk = interval;
        this.mPriority = priority;
        this.zzaKP = expireAt;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof PlaceRequest)) {
            return false;
        }
        PlaceRequest placeRequest = (PlaceRequest) object;
        return zzw.equal(this.zzaMR, placeRequest.zzaMR) && this.zzaLk == placeRequest.zzaLk && this.mPriority == placeRequest.mPriority && this.zzaKP == placeRequest.zzaKP;
    }

    public long getExpirationTime() {
        return this.zzaKP;
    }

    public long getInterval() {
        return this.zzaLk;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaMR, Long.valueOf(this.zzaLk), Integer.valueOf(this.mPriority), Long.valueOf(this.zzaKP));
    }

    public String toString() {
        return zzw.zzx(this).zzg("filter", this.zzaMR).zzg("interval", Long.valueOf(this.zzaLk)).zzg("priority", Integer.valueOf(this.mPriority)).zzg("expireAt", Long.valueOf(this.zzaKP)).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzk.zza(this, parcel, flags);
    }

    public PlaceFilter zzyn() {
        return this.zzaMR;
    }
}
