package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.internal.zzha;

@zzha
public class ThinAdSizeParcel extends AdSizeParcel {
    public ThinAdSizeParcel(AdSizeParcel originalAdSize) {
        super(originalAdSize.versionCode, originalAdSize.zztV, originalAdSize.height, originalAdSize.heightPixels, originalAdSize.zztW, originalAdSize.width, originalAdSize.widthPixels, originalAdSize.zztX, originalAdSize.zztY, originalAdSize.zztZ, originalAdSize.zzua);
    }

    public void writeToParcel(Parcel parcel, int flags) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, this.versionCode);
        zzb.zza(parcel, 2, this.zztV, false);
        zzb.zzc(parcel, 3, this.height);
        zzb.zzc(parcel, 6, this.width);
        zzb.zzI(parcel, zzav);
    }
}
