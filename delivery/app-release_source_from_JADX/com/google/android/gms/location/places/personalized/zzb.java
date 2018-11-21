package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzb implements Creator<PlaceAlias> {
    static void zza(PlaceAlias placeAlias, Parcel parcel, int i) {
        int zzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, placeAlias.zzyO(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, placeAlias.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfh(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzhS(x0);
    }

    public PlaceAlias zzfh(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
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
            return new PlaceAlias(i, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public PlaceAlias[] zzhS(int i) {
        return new PlaceAlias[i];
    }
}
