package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Creator<CountrySpecification> {
    static void zza(CountrySpecification countrySpecification, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, countrySpecification.getVersionCode());
        zzb.zza(parcel, 2, countrySpecification.zzIE, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzeD(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzha(x0);
    }

    public CountrySpecification zzeD(Parcel parcel) {
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzcc(zzat)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new CountrySpecification(i, str);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public CountrySpecification[] zzha(int i) {
        return new CountrySpecification[i];
    }
}
