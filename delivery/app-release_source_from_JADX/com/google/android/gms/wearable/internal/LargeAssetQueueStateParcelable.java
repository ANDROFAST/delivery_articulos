package com.google.android.gms.wearable.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.LargeAssetApi.QueueState;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class LargeAssetQueueStateParcelable implements SafeParcelable, QueueState {
    public static final Creator<LargeAssetQueueStateParcelable> CREATOR = new zzbh();
    final int mVersionCode;
    final int zzbnZ;
    final String zzboa;
    final Map<String, Integer> zzbob;
    final int zzboc;
    final int zzbod;

    LargeAssetQueueStateParcelable(int versionCode, int localNodeFlags, String localNodeId, Bundle remoteNodeFlags, int pausedCount, int runningCount) {
        this.mVersionCode = versionCode;
        this.zzbnZ = zzlT(localNodeFlags);
        this.zzboa = (String) zzx.zzy(localNodeId);
        this.zzbob = zzJ(remoteNodeFlags);
        this.zzboc = pausedCount;
        this.zzbod = runningCount;
    }

    private static Map<String, Integer> zzJ(Bundle bundle) {
        Set<String> keySet = bundle.keySet();
        Map<String, Integer> arrayMap = new ArrayMap(keySet.size());
        for (String str : keySet) {
            arrayMap.put(str, Integer.valueOf(zzlT(bundle.getInt(str))));
        }
        return arrayMap;
    }

    private static int zzlT(int i) {
        return i & 15;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LargeAssetQueueStateParcelable)) {
            return false;
        }
        LargeAssetQueueStateParcelable largeAssetQueueStateParcelable = (LargeAssetQueueStateParcelable) o;
        return this.mVersionCode == largeAssetQueueStateParcelable.mVersionCode && this.zzbnZ == largeAssetQueueStateParcelable.zzbnZ && this.zzboc == largeAssetQueueStateParcelable.zzboc && this.zzbod == largeAssetQueueStateParcelable.zzbod && this.zzboa.equals(largeAssetQueueStateParcelable.zzboa) && this.zzbob.equals(largeAssetQueueStateParcelable.zzbob);
    }

    public int hashCode() {
        return (((((((((this.mVersionCode * 31) + this.zzbnZ) * 31) + this.zzboa.hashCode()) * 31) + this.zzbob.hashCode()) * 31) + this.zzboc) * 31) + this.zzbod;
    }

    public String toString() {
        return "QueueState{localNodeFlags=" + this.zzbnZ + ", localNodeId='" + this.zzboa + "'" + ", remoteNodeFlags=" + this.zzbob + ", pausedCount=" + this.zzboc + ", runningCount=" + this.zzbod + "}";
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbh.zza(this, dest, flags);
    }

    Bundle zzGW() {
        Bundle bundle = new Bundle();
        for (Entry entry : this.zzbob.entrySet()) {
            bundle.putInt((String) entry.getKey(), ((Integer) entry.getValue()).intValue());
        }
        return bundle;
    }
}
