package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class FaceParcel implements SafeParcelable {
    public static final zza CREATOR = new zza();
    public final float centerX;
    public final float centerY;
    public final float height;
    public final int id;
    public final int versionCode;
    public final float width;
    public final float zzbiI;
    public final float zzbiJ;
    public final LandmarkParcel[] zzbiK;
    public final float zzbiL;
    public final float zzbiM;
    public final float zzbiN;

    public FaceParcel(int versionCode, int id, float centerX, float centerY, float width, float height, float eulerY, float eulerZ, LandmarkParcel[] landmarkParcels, float isLeftEyeOpenScore, float isRightEyeOpenScore, float isSmilingScore) {
        this.versionCode = versionCode;
        this.id = id;
        this.centerX = centerX;
        this.centerY = centerY;
        this.width = width;
        this.height = height;
        this.zzbiI = eulerY;
        this.zzbiJ = eulerZ;
        this.zzbiK = landmarkParcels;
        this.zzbiL = isLeftEyeOpenScore;
        this.zzbiM = isRightEyeOpenScore;
        this.zzbiN = isSmilingScore;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zza.zza(this, parcel, flags);
    }
}
