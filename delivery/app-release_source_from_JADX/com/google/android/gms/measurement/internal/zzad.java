package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzad implements Creator<UserAttributeParcel> {
    static void zza(UserAttributeParcel userAttributeParcel, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, userAttributeParcel.versionCode);
        zzb.zza(parcel, 2, userAttributeParcel.name, false);
        zzb.zza(parcel, 3, userAttributeParcel.zzaVg);
        zzb.zza(parcel, 4, userAttributeParcel.zzaVh, false);
        zzb.zza(parcel, 5, userAttributeParcel.zzaVi, false);
        zzb.zza(parcel, 6, userAttributeParcel.zzakS, false);
        zzb.zza(parcel, 7, userAttributeParcel.zzaSM, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfF(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zziy(x0);
    }

    public UserAttributeParcel zzfF(Parcel parcel) {
        String str = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        long j = 0;
        String str2 = null;
        Float f = null;
        Long l = null;
        String str3 = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    str3 = zza.zzp(parcel, zzat);
                    break;
                case 3:
                    j = zza.zzi(parcel, zzat);
                    break;
                case 4:
                    l = zza.zzj(parcel, zzat);
                    break;
                case 5:
                    f = zza.zzm(parcel, zzat);
                    break;
                case 6:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 7:
                    str = zza.zzp(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new UserAttributeParcel(i, str3, j, l, f, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public UserAttributeParcel[] zziy(int i) {
        return new UserAttributeParcel[i];
    }
}
