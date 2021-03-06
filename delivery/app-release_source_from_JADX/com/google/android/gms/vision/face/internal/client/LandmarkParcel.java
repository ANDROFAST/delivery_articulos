package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LandmarkParcel implements SafeParcelable {
    public static final zze CREATOR = new zze();
    public final int type;
    public final int versionCode;
    public final float f1122x;
    public final float f1123y;

    public LandmarkParcel(int versionCode, float x, float y, int type) {
        this.versionCode = versionCode;
        this.f1122x = x;
        this.f1123y = y;
        this.type = type;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zze.zza(this, parcel, flags);
    }
}
