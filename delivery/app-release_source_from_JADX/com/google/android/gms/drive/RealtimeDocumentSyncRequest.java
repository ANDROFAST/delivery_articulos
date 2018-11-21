package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.List;

public class RealtimeDocumentSyncRequest implements SafeParcelable {
    public static final Creator<RealtimeDocumentSyncRequest> CREATOR = new zzj();
    final int mVersionCode;
    final List<String> zzanu;
    final List<String> zzanv;

    RealtimeDocumentSyncRequest(int versionCode, List<String> documentsToSync, List<String> documentsToDeleteCache) {
        this.mVersionCode = versionCode;
        this.zzanu = (List) zzx.zzy(documentsToSync);
        this.zzanv = (List) zzx.zzy(documentsToDeleteCache);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzj.zza(this, dest, flags);
    }
}
