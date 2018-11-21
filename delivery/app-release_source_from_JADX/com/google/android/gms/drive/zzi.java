package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi implements Creator<Permission> {
    static void zza(Permission permission, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, permission.mVersionCode);
        zzb.zza(parcel, 2, permission.zzsr(), false);
        zzb.zzc(parcel, 3, permission.zzss());
        zzb.zza(parcel, 4, permission.zzst(), false);
        zzb.zza(parcel, 5, permission.zzsu(), false);
        zzb.zzc(parcel, 6, permission.getRole());
        zzb.zza(parcel, 7, permission.zzsv());
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaN(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcC(x0);
    }

    public Permission zzaN(Parcel parcel) {
        String str = null;
        boolean z = false;
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str2 = null;
        int i2 = 0;
        String str3 = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    str3 = zza.zzp(parcel, zzat);
                    break;
                case 3:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 4:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 5:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 6:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 7:
                    z = zza.zzc(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new Permission(i3, str3, i2, str2, str, i, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public Permission[] zzcC(int i) {
        return new Permission[i];
    }
}
