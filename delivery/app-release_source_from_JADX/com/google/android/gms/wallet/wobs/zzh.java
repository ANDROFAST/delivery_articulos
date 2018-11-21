package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh implements Creator<UriData> {
    static void zza(UriData uriData, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, uriData.getVersionCode());
        zzb.zza(parcel, 2, uriData.zzaXT, false);
        zzb.zza(parcel, 3, uriData.description, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzhH(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzle(x0);
    }

    public UriData zzhH(Parcel parcel) {
        String str = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
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
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new UriData(i, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public UriData[] zzle(int i) {
        return new UriData[i];
    }
}
