package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.LargeAssetApi.zzb;

public final class LargeAssetQueueEntryParcelable implements SafeParcelable, zzb {
    public static final Creator<LargeAssetQueueEntryParcelable> CREATOR = new zzbf();
    private final String mPath;
    private final int mState;
    final int mVersionCode;
    private final String zzblS;
    private final long zzbnQ;
    private final Uri zzbnR;
    private final int zzbnS;
    private final boolean zzbnT;
    private final boolean zzbnU;
    private final boolean zzbnV;

    LargeAssetQueueEntryParcelable(int versionCode, long transferId, int state, String path, String nodeId, Uri destinationUri, int refuseErrorCode, boolean append, boolean allowedOverMetered, boolean allowedWithLowBattery) {
        this.mVersionCode = versionCode;
        this.zzbnQ = transferId;
        this.mState = state;
        this.mPath = (String) zzx.zzb((Object) path, (Object) "path");
        this.zzblS = (String) zzx.zzb((Object) nodeId, (Object) "nodeId");
        this.zzbnR = (Uri) zzx.zzb((Object) destinationUri, (Object) "destinationUri");
        this.zzbnS = refuseErrorCode;
        this.zzbnT = append;
        this.zzbnU = allowedOverMetered;
        this.zzbnV = allowedWithLowBattery;
    }

    public LargeAssetQueueEntryParcelable(long transferId, int state, String path, String nodeId, Uri destinationUri, int refuseErrorCode, boolean append, boolean allowedOverMetered, boolean allowedWithLowBattery) {
        this(1, transferId, state, path, nodeId, destinationUri, refuseErrorCode, append, allowedOverMetered, allowedWithLowBattery);
    }

    public int describeContents() {
        return 0;
    }

    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LargeAssetQueueEntryParcelable)) {
            return false;
        }
        LargeAssetQueueEntryParcelable largeAssetQueueEntryParcelable = (LargeAssetQueueEntryParcelable) o;
        return this.mVersionCode == largeAssetQueueEntryParcelable.mVersionCode && this.zzbnQ == largeAssetQueueEntryParcelable.zzbnQ && this.mState == largeAssetQueueEntryParcelable.mState && this.mPath.equals(largeAssetQueueEntryParcelable.mPath) && this.zzblS.equals(largeAssetQueueEntryParcelable.zzblS) && this.zzbnR.equals(largeAssetQueueEntryParcelable.zzbnR) && this.zzbnT == largeAssetQueueEntryParcelable.zzbnT && this.zzbnU == largeAssetQueueEntryParcelable.zzbnU && this.zzbnV == largeAssetQueueEntryParcelable.zzbnV && this.zzbnS == largeAssetQueueEntryParcelable.zzbnS;
    }

    public String getNodeId() {
        return this.zzblS;
    }

    public String getPath() {
        return this.mPath;
    }

    public int getState() {
        return this.mState;
    }

    public final int hashCode() {
        int i = 1;
        int hashCode = ((this.zzbnU ? 1 : 0) + (((this.zzbnT ? 1 : 0) + (((((((((((this.mVersionCode * 31) + ((int) (this.zzbnQ ^ (this.zzbnQ >>> 32)))) * 31) + this.mState) * 31) + this.mPath.hashCode()) * 31) + this.zzblS.hashCode()) * 31) + this.zzbnR.hashCode()) * 31)) * 31)) * 31;
        if (!this.zzbnV) {
            i = 0;
        }
        return ((hashCode + i) * 31) + this.zzbnS;
    }

    public String toString() {
        return "QueueEntry{versionCode=" + this.mVersionCode + ", transferId=" + this.zzbnQ + ", state=" + this.mState + ", path='" + this.mPath + "'" + ", nodeId='" + this.zzblS + "'" + ", destinationUri='" + this.zzbnR + "'" + (this.zzbnT ? ", append=true" : "") + (this.zzbnU ? ", allowedOverMetered=true" : "") + (this.zzbnV ? ", allowedWithLowBattery=true" : "") + ", refuseErrorCode=" + this.zzbnS + "}";
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbf.zza(this, dest, flags);
    }

    public Uri zzCO() {
        return this.zzbnR;
    }

    public long zzGQ() {
        return this.zzbnQ;
    }

    public boolean zzGR() {
        return this.zzbnT;
    }

    public boolean zzGS() {
        return this.zzbnU;
    }

    public boolean zzGT() {
        return this.zzbnV;
    }

    public int zzGU() {
        return this.zzbnS;
    }
}
