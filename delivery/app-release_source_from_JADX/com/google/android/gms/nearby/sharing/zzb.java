package com.google.android.gms.nearby.sharing;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzb implements Creator<LocalContent> {
    static void zza(LocalContent localContent, Parcel parcel, int i) {
        int zzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, localContent.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 2, localContent.getType());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, localContent.zzCP(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgg(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzji(x0);
    }

    public LocalContent zzgg(Parcel parcel) {
        int i = 0;
        int zzau = zza.zzau(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    i = zza.zzg(parcel, zzat);
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
            return new LocalContent(i2, i, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public LocalContent[] zzji(int i) {
        return new LocalContent[i];
    }
}
