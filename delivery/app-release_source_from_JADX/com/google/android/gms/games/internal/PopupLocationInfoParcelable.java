package com.google.android.gms.games.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.PopupManager.PopupLocationInfo;

public final class PopupLocationInfoParcelable implements SafeParcelable {
    public static final PopupLocationInfoParcelableCreator CREATOR = new PopupLocationInfoParcelableCreator();
    private final int mVersionCode;
    private final Bundle zzaCZ;
    private final IBinder zzaDa;

    PopupLocationInfoParcelable(int versionCode, Bundle infoBundle, IBinder windowToken) {
        this.mVersionCode = versionCode;
        this.zzaCZ = infoBundle;
        this.zzaDa = windowToken;
    }

    public PopupLocationInfoParcelable(PopupLocationInfo popupLocationInfo) {
        this.mVersionCode = 1;
        this.zzaCZ = popupLocationInfo.zzwz();
        this.zzaDa = popupLocationInfo.zzaDd;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public IBinder getWindowToken() {
        return this.zzaDa;
    }

    public void writeToParcel(Parcel out, int flags) {
        PopupLocationInfoParcelableCreator.zza(this, out, flags);
    }

    public Bundle zzwz() {
        return this.zzaCZ;
    }
}
