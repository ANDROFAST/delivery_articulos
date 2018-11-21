package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class LargeAssetEnqueueRequest implements SafeParcelable {
    public static final Creator<LargeAssetEnqueueRequest> CREATOR = new zzbd();
    final int mVersionCode;
    public final Uri zzaXR;
    public final String zzbnJ;
    public final String zzbnK;
    public final String zzbnL;
    public final boolean zzbnM;
    public final boolean zzbnN;
    public final boolean zzbnO;

    LargeAssetEnqueueRequest(int versionCode, String nodeId, String path, Uri destinationUri, String destinationCanonicalPath, boolean append, boolean allowedOverMetered, boolean allowedWithLowBattery) {
        this.mVersionCode = versionCode;
        this.zzbnJ = (String) zzx.zzy(nodeId);
        this.zzbnK = (String) zzx.zzy(path);
        this.zzaXR = (Uri) zzx.zzy(destinationUri);
        this.zzbnL = (String) zzx.zzy(destinationCanonicalPath);
        this.zzbnM = append;
        this.zzbnN = allowedOverMetered;
        this.zzbnO = allowedWithLowBattery;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LargeAssetEnqueueRequest)) {
            return false;
        }
        LargeAssetEnqueueRequest largeAssetEnqueueRequest = (LargeAssetEnqueueRequest) o;
        return this.mVersionCode == largeAssetEnqueueRequest.mVersionCode && this.zzbnJ.equals(largeAssetEnqueueRequest.zzbnJ) && this.zzbnK.equals(largeAssetEnqueueRequest.zzbnK) && this.zzaXR.equals(largeAssetEnqueueRequest.zzaXR) && this.zzbnL.equals(largeAssetEnqueueRequest.zzbnL) && this.zzbnM == largeAssetEnqueueRequest.zzbnM && this.zzbnN == largeAssetEnqueueRequest.zzbnN && this.zzbnO == largeAssetEnqueueRequest.zzbnO;
    }

    public int hashCode() {
        int i = 1;
        int hashCode = ((this.zzbnN ? 1 : 0) + (((this.zzbnM ? 1 : 0) + (((((((((this.mVersionCode * 31) + this.zzbnJ.hashCode()) * 31) + this.zzbnK.hashCode()) * 31) + this.zzaXR.hashCode()) * 31) + this.zzbnL.hashCode()) * 31)) * 31)) * 31;
        if (!this.zzbnO) {
            i = 0;
        }
        return hashCode + i;
    }

    public String toString() {
        return "LargeAssetEnqueueRequest{, nodeId='" + this.zzbnJ + "'" + ", path='" + this.zzbnK + "'" + ", destinationUri='" + this.zzaXR + "'" + ", destinationCanonicalPath='" + this.zzbnL + "'" + ", append=" + this.zzbnM + (this.zzbnN ? ", allowedOverMetered=true" : "") + (this.zzbnO ? ", allowedWithLowBattery=true" : "") + "}";
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbd.zza(this, dest, flags);
    }
}
