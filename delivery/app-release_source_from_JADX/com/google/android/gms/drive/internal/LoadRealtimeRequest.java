package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.List;

public class LoadRealtimeRequest implements SafeParcelable {
    public static final Creator<LoadRealtimeRequest> CREATOR = new zzar();
    final int mVersionCode;
    final DriveId zzamF;
    final boolean zzapN;
    final List<String> zzapO;
    final boolean zzapP;
    final DataHolder zzapQ;
    final String zzapR;

    LoadRealtimeRequest(int versionCode, DriveId driveId, boolean useTestMode, List<String> customTypeWhitelist, boolean isInMemory, DataHolder json, String localId) {
        this.mVersionCode = versionCode;
        this.zzamF = driveId;
        this.zzapN = useTestMode;
        this.zzapO = customTypeWhitelist;
        this.zzapP = isInMemory;
        this.zzapQ = json;
        this.zzapR = localId;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzar.zza(this, dest, flags);
    }
}
