package com.google.android.gms.vision.barcode.internal.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Creator<BarcodeDetectorOptions> {
    static void zza(BarcodeDetectorOptions barcodeDetectorOptions, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, barcodeDetectorOptions.versionCode);
        zzb.zzc(parcel, 2, barcodeDetectorOptions.zzbiq);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgW(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzkp(x0);
    }

    public BarcodeDetectorOptions zzgW(Parcel parcel) {
        int i = 0;
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzcc(zzat)) {
                case 1:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    break;
                case 2:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new BarcodeDetectorOptions(i2, i);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public BarcodeDetectorOptions[] zzkp(int i) {
        return new BarcodeDetectorOptions[i];
    }
}
