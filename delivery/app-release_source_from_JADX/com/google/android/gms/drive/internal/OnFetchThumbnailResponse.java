package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnFetchThumbnailResponse implements SafeParcelable {
    public static final Creator<OnFetchThumbnailResponse> CREATOR = new zzbc();
    final int mVersionCode;
    final ParcelFileDescriptor zzaqo;

    OnFetchThumbnailResponse(int versionCode, ParcelFileDescriptor thumbnailPfd) {
        this.mVersionCode = versionCode;
        this.zzaqo = thumbnailPfd;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbc.zza(this, dest, flags | 1);
    }
}
