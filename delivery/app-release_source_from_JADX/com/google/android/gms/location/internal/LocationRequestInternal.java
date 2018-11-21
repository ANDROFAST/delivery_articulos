package com.google.android.gms.location.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;

public class LocationRequestInternal implements SafeParcelable {
    public static final zzm CREATOR = new zzm();
    static final List<ClientIdentity> zzaMa = Collections.emptyList();
    String mTag;
    private final int mVersionCode;
    boolean zzaMb;
    boolean zzaMc;
    boolean zzaMd;
    List<ClientIdentity> zzaMe;
    boolean zzaMf;
    LocationRequest zzayV;

    LocationRequestInternal(int versionCode, LocationRequest locationRequest, boolean requestNlpDebugInfo, boolean restorePendingIntentListeners, boolean triggerUpdate, List<ClientIdentity> clients, String tag, boolean hideFromAppOps) {
        this.mVersionCode = versionCode;
        this.zzayV = locationRequest;
        this.zzaMb = requestNlpDebugInfo;
        this.zzaMc = restorePendingIntentListeners;
        this.zzaMd = triggerUpdate;
        this.zzaMe = clients;
        this.mTag = tag;
        this.zzaMf = hideFromAppOps;
    }

    public static LocationRequestInternal zza(String str, LocationRequest locationRequest) {
        return new LocationRequestInternal(1, locationRequest, false, true, true, zzaMa, str, false);
    }

    @Deprecated
    public static LocationRequestInternal zzb(LocationRequest locationRequest) {
        return zza(null, locationRequest);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (!(other instanceof LocationRequestInternal)) {
            return false;
        }
        LocationRequestInternal locationRequestInternal = (LocationRequestInternal) other;
        return zzw.equal(this.zzayV, locationRequestInternal.zzayV) && this.zzaMb == locationRequestInternal.zzaMb && this.zzaMc == locationRequestInternal.zzaMc && this.zzaMd == locationRequestInternal.zzaMd && this.zzaMf == locationRequestInternal.zzaMf && zzw.equal(this.zzaMe, locationRequestInternal.zzaMe);
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return this.zzayV.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.zzayV.toString());
        if (this.mTag != null) {
            stringBuilder.append(" tag=").append(this.mTag);
        }
        stringBuilder.append(" nlpDebug=").append(this.zzaMb);
        stringBuilder.append(" trigger=").append(this.zzaMd);
        stringBuilder.append(" restorePIListeners=").append(this.zzaMc);
        stringBuilder.append(" hideAppOps=").append(this.zzaMf);
        stringBuilder.append(" clients=").append(this.zzaMe);
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzm.zza(this, parcel, flags);
    }
}
