package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzn implements Creator<StringParcel> {
    static void zza(StringParcel stringParcel, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, stringParcel.mVersionCode);
        zzb.zza(parcel, 2, stringParcel.zzxi, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzm(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzK(x0);
    }

    public StringParcel[] zzK(int i) {
        return new StringParcel[i];
    }

    public StringParcel zzm(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    str = zza.zzp(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new StringParcel(i, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }
}
