package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.plus.internal.model.people.PersonEntity.CoverEntity.CoverInfoEntity;
import java.util.HashSet;
import java.util.Set;

public class zzd implements Creator<CoverInfoEntity> {
    static void zza(CoverInfoEntity coverInfoEntity, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        Set set = coverInfoEntity.zzaZA;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, coverInfoEntity.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zzc(parcel, 2, coverInfoEntity.zzbaW);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zzc(parcel, 3, coverInfoEntity.zzbaX);
        }
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgw(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzjz(x0);
    }

    public CoverInfoEntity zzgw(Parcel parcel) {
        int i = 0;
        int zzau = zza.zzau(parcel);
        Set hashSet = new HashSet();
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i3 = zza.zzg(parcel, zzat);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    i2 = zza.zzg(parcel, zzat);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    i = zza.zzg(parcel, zzat);
                    hashSet.add(Integer.valueOf(3));
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new CoverInfoEntity(hashSet, i3, i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public CoverInfoEntity[] zzjz(int i) {
        return new CoverInfoEntity[i];
    }
}
