package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.LargeAssetApi.zzd;

public final class LargeAssetQueueStateChangeParcelable implements SafeParcelable, zzd {
    public static final Creator<LargeAssetQueueStateChangeParcelable> CREATOR = new zzbg();
    final int mVersionCode;
    private final zzbt zzbnW;
    final DataHolder zzbnX;
    private final LargeAssetQueueStateParcelable zzbnY;

    LargeAssetQueueStateChangeParcelable(int versionCode, DataHolder queueEntryBufferDataHolder, LargeAssetQueueStateParcelable queueState) {
        this.mVersionCode = versionCode;
        this.zzbnX = (DataHolder) zzx.zzy(queueEntryBufferDataHolder);
        this.zzbnW = new zzbt(queueEntryBufferDataHolder);
        this.zzbnY = (LargeAssetQueueStateParcelable) zzx.zzy(queueState);
    }

    public int describeContents() {
        return 0;
    }

    public void release() {
        this.zzbnW.release();
    }

    public String toString() {
        return "LargeAssetQueueStateChangeParcelable{queueEntryBuffer=" + this.zzbnW + ", queueState=" + this.zzbnY + "}";
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbg.zza(this, dest, flags);
    }

    public LargeAssetQueueStateParcelable zzGV() {
        return this.zzbnY;
    }
}
