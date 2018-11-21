package com.google.android.gms.location.places;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class PlacePhotoResult implements Result, SafeParcelable {
    public static final Creator<PlacePhotoResult> CREATOR = new zzi();
    private final Bitmap mBitmap;
    final int mVersionCode;
    private final Status zzTA;
    final BitmapTeleporter zzaMN;

    PlacePhotoResult(int versionCode, Status status, BitmapTeleporter teleporter) {
        this.mVersionCode = versionCode;
        this.zzTA = status;
        this.zzaMN = teleporter;
        if (this.zzaMN != null) {
            this.mBitmap = teleporter.zzpI();
        } else {
            this.mBitmap = null;
        }
    }

    public PlacePhotoResult(Status status, BitmapTeleporter teleporter) {
        this.mVersionCode = 0;
        this.zzTA = status;
        this.zzaMN = teleporter;
        if (this.zzaMN != null) {
            this.mBitmap = teleporter.zzpI();
        } else {
            this.mBitmap = null;
        }
    }

    public int describeContents() {
        return 0;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public Status getStatus() {
        return this.zzTA;
    }

    public String toString() {
        return zzw.zzx(this).zzg("status", this.zzTA).zzg("bitmap", this.mBitmap).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzi.zza(this, parcel, flags);
    }
}
