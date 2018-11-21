package com.google.android.gms.plus.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzf implements Creator<PlusCommonExtras> {
    static void zza(PlusCommonExtras plusCommonExtras, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, plusCommonExtras.zzDg(), false);
        zzb.zzc(parcel, 1000, plusCommonExtras.getVersionCode());
        zzb.zza(parcel, 2, plusCommonExtras.zzDh(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgp(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzjs(x0);
    }

    public PlusCommonExtras zzgp(Parcel parcel) {
        String str = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 2:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 1000:
                    i = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new PlusCommonExtras(i, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public PlusCommonExtras[] zzjs(int i) {
        return new PlusCommonExtras[i];
    }
}
