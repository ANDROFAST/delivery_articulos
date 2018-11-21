package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.Collection;

public class zzc implements Creator<AutocompleteFilter> {
    static void zza(AutocompleteFilter autocompleteFilter, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, autocompleteFilter.zzyl());
        zzb.zzc(parcel, 1000, autocompleteFilter.mVersionCode);
        zzb.zza(parcel, 2, autocompleteFilter.zzaMt, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzeS(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzhA(x0);
    }

    public AutocompleteFilter zzeS(Parcel parcel) {
        boolean z = false;
        int zzau = zza.zzau(parcel);
        Collection collection = null;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 2:
                    collection = zza.zzC(parcel, zzat);
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
            return new AutocompleteFilter(i, z, collection);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public AutocompleteFilter[] zzhA(int i) {
        return new AutocompleteFilter[i];
    }
}
