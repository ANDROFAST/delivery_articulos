package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class PlacePhotoMetadataResult implements Result, SafeParcelable {
    public static final Creator<PlacePhotoMetadataResult> CREATOR = new zzh();
    final int mVersionCode;
    private final Status zzTA;
    final DataHolder zzaML;
    private final PlacePhotoMetadataBuffer zzaMM;

    PlacePhotoMetadataResult(int versionCode, Status status, DataHolder dataHolder) {
        this.mVersionCode = versionCode;
        this.zzTA = status;
        this.zzaML = dataHolder;
        if (dataHolder == null) {
            this.zzaMM = null;
        } else {
            this.zzaMM = new PlacePhotoMetadataBuffer(this.zzaML);
        }
    }

    public PlacePhotoMetadataResult(Status status, DataHolder dataHolder) {
        this(0, status, dataHolder);
    }

    public int describeContents() {
        return 0;
    }

    public PlacePhotoMetadataBuffer getPhotoMetadata() {
        return this.zzaMM;
    }

    public Status getStatus() {
        return this.zzTA;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzh.zza(this, parcel, flags);
    }
}
