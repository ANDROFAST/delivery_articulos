package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Creator<BitmapTeleporter> {
    static void zza(BitmapTeleporter bitmapTeleporter, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, bitmapTeleporter.mVersionCode);
        zzb.zza(parcel, 2, bitmapTeleporter.zzHf, i, false);
        zzb.zzc(parcel, 3, bitmapTeleporter.zzZU);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaj(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzbF(x0);
    }

    public BitmapTeleporter zzaj(Parcel parcel) {
        int i = 0;
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        ParcelFileDescriptor parcelFileDescriptor = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            ParcelFileDescriptor parcelFileDescriptor2;
            int zzg;
            int zzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzcc(zzat)) {
                case 1:
                    int i3 = i;
                    parcelFileDescriptor2 = parcelFileDescriptor;
                    zzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    zzat = i3;
                    break;
                case 2:
                    zzg = i2;
                    ParcelFileDescriptor parcelFileDescriptor3 = (ParcelFileDescriptor) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzat, ParcelFileDescriptor.CREATOR);
                    zzat = i;
                    parcelFileDescriptor2 = parcelFileDescriptor3;
                    break;
                case 3:
                    zzat = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    parcelFileDescriptor2 = parcelFileDescriptor;
                    zzg = i2;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzat);
                    zzat = i;
                    parcelFileDescriptor2 = parcelFileDescriptor;
                    zzg = i2;
                    break;
            }
            i2 = zzg;
            parcelFileDescriptor = parcelFileDescriptor2;
            i = zzat;
        }
        if (parcel.dataPosition() == zzau) {
            return new BitmapTeleporter(i2, parcelFileDescriptor, i);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public BitmapTeleporter[] zzbF(int i) {
        return new BitmapTeleporter[i];
    }
}
