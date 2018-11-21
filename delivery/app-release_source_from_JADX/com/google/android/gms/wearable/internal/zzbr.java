package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbr implements Creator<PackageStorageInfo> {
    static void zza(PackageStorageInfo packageStorageInfo, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, packageStorageInfo.versionCode);
        zzb.zza(parcel, 2, packageStorageInfo.packageName, false);
        zzb.zza(parcel, 3, packageStorageInfo.label, false);
        zzb.zza(parcel, 4, packageStorageInfo.zzboB);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zziy(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzma(x0);
    }

    public PackageStorageInfo zziy(Parcel parcel) {
        String str = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        long j = 0;
        String str2 = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 3:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 4:
                    j = zza.zzi(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new PackageStorageInfo(i, str2, str, j);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public PackageStorageInfo[] zzma(int i) {
        return new PackageStorageInfo[i];
    }
}
