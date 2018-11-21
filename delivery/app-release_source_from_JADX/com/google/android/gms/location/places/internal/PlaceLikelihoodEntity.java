package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceLikelihood;

public class PlaceLikelihoodEntity implements SafeParcelable, PlaceLikelihood {
    public static final Creator<PlaceLikelihoodEntity> CREATOR = new zzm();
    final int mVersionCode;
    final PlaceImpl zzaNV;
    final float zzaNW;

    PlaceLikelihoodEntity(int versionCode, PlaceImpl place, float likelihood) {
        this.mVersionCode = versionCode;
        this.zzaNV = place;
        this.zzaNW = likelihood;
    }

    public static PlaceLikelihoodEntity zza(PlaceImpl placeImpl, float f) {
        return new PlaceLikelihoodEntity(0, (PlaceImpl) zzx.zzy(placeImpl), f);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof PlaceLikelihoodEntity)) {
            return false;
        }
        PlaceLikelihoodEntity placeLikelihoodEntity = (PlaceLikelihoodEntity) object;
        return this.zzaNV.equals(placeLikelihoodEntity.zzaNV) && this.zzaNW == placeLikelihoodEntity.zzaNW;
    }

    public /* synthetic */ Object freeze() {
        return zzyM();
    }

    public float getLikelihood() {
        return this.zzaNW;
    }

    public Place getPlace() {
        return this.zzaNV;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaNV, Float.valueOf(this.zzaNW));
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzw.zzx(this).zzg("place", this.zzaNV).zzg("likelihood", Float.valueOf(this.zzaNW)).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzm.zza(this, parcel, flags);
    }

    public PlaceLikelihood zzyM() {
        return this;
    }
}
