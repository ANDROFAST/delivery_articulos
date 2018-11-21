package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class FaceSettingsParcel implements SafeParcelable {
    public static final zzb CREATOR = new zzb();
    public int mode;
    public final int versionCode;
    public int zzbiO;
    public int zzbiP;
    public boolean zzbiQ;
    public boolean zzbiR;

    public FaceSettingsParcel() {
        this.versionCode = 1;
    }

    public FaceSettingsParcel(int versionCode, int mode, int landmarkType, int classificationType, boolean prominentFaceOnly, boolean trackingEnabled) {
        this.versionCode = versionCode;
        this.mode = mode;
        this.zzbiO = landmarkType;
        this.zzbiP = classificationType;
        this.zzbiQ = prominentFaceOnly;
        this.zzbiR = trackingEnabled;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzb.zza(this, parcel, flags);
    }
}
