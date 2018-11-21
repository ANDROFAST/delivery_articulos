package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public class LargeAssetSyncRequestPayload implements SafeParcelable {
    public static final Creator<LargeAssetSyncRequestPayload> CREATOR = new zzbk();
    final int versionCode;
    public final String zzbnK;
    public final long zzbom;

    public LargeAssetSyncRequestPayload(int versionCode, String path, long offset) {
        this.versionCode = versionCode;
        this.zzbnK = (String) zzx.zzb((Object) path, (Object) "path");
        this.zzbom = offset;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "LargeAssetSyncRequestPayload{path='" + this.zzbnK + "'" + ", offset=" + this.zzbom + "}";
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbk.zza(this, dest, flags);
    }
}
