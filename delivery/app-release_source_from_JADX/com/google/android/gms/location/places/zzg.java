package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzg implements Creator<PlaceFilter> {
    static void zza(PlaceFilter placeFilter, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, placeFilter.zzaMt, false);
        zzb.zzc(parcel, 1000, placeFilter.mVersionCode);
        zzb.zza(parcel, 3, placeFilter.zzaMH);
        zzb.zzc(parcel, 4, placeFilter.zzaMw, false);
        zzb.zzb(parcel, 6, placeFilter.zzaMv, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzeV(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzhD(x0);
    }

    public PlaceFilter zzeV(Parcel parcel) {
        boolean z = false;
        List list = null;
        int zzau = zza.zzau(parcel);
        List list2 = null;
        List list3 = null;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    list3 = zza.zzC(parcel, zzat);
                    break;
                case 3:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 4:
                    list = zza.zzc(parcel, zzat, UserDataType.CREATOR);
                    break;
                case 6:
                    list2 = zza.zzD(parcel, zzat);
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
            return new PlaceFilter(i, list3, z, list2, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public PlaceFilter[] zzhD(int i) {
        return new PlaceFilter[i];
    }
}
