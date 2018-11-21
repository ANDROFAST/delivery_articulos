package com.google.android.gms.drive.events;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.WriteAwareParcelable;

public class QueryResultEventParcelable extends WriteAwareParcelable implements DriveEvent {
    public static final zzk CREATOR = new zzk();
    final int mVersionCode;
    final DataHolder zzafC;
    final boolean zzanW;
    final int zzanX;

    QueryResultEventParcelable(int versionCode, DataHolder dataHolder, boolean isStatusChanged, int queryStatus) {
        this.mVersionCode = versionCode;
        this.zzafC = dataHolder;
        this.zzanW = isStatusChanged;
        this.zzanX = queryStatus;
    }

    public int describeContents() {
        return 0;
    }

    public int getType() {
        return 3;
    }

    public void zzJ(Parcel parcel, int i) {
        zzk.zza(this, parcel, i);
    }

    public DataHolder zzsA() {
        return this.zzafC;
    }

    public boolean zzsB() {
        return this.zzanW;
    }

    public int zzsC() {
        return this.zzanX;
    }
}
