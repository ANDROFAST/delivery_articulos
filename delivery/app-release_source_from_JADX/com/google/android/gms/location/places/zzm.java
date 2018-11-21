package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzm implements Creator<UserDataType> {
    static void zza(UserDataType userDataType, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, userDataType.zzIx, false);
        zzb.zzc(parcel, 1000, userDataType.mVersionCode);
        zzb.zzc(parcel, 2, userDataType.zzaNi);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfa(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzhK(x0);
    }

    public UserDataType zzfa(Parcel parcel) {
        int i = 0;
        int zzau = zza.zzau(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 2:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 1000:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new UserDataType(i2, str, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public UserDataType[] zzhK(int i) {
        return new UserDataType[i];
    }
}
