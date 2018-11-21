package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.ParcelableChangeInfo;
import java.util.List;

public class ParcelableEventList implements SafeParcelable {
    public static final Creator<ParcelableEventList> CREATOR = new zzd();
    final int mVersionCode;
    final DataHolder zzasZ;
    final boolean zzata;
    final List<String> zzatb;
    final ParcelableChangeInfo zzatc;
    final List<ParcelableEvent> zzpw;

    ParcelableEventList(int versionCode, List<ParcelableEvent> events, DataHolder eventData, boolean undoRedoStateChanged, List<String> affectedObjectIds, ParcelableChangeInfo previousChangeInfo) {
        this.mVersionCode = versionCode;
        this.zzpw = events;
        this.zzasZ = eventData;
        this.zzata = undoRedoStateChanged;
        this.zzatb = affectedObjectIds;
        this.zzatc = previousChangeInfo;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzd.zza(this, dest, flags);
    }
}
