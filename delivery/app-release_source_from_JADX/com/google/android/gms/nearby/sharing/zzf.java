package com.google.android.gms.nearby.sharing;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzf implements Creator<ViewableItem> {
    static void zza(ViewableItem viewableItem, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, viewableItem.getVersionCode());
        zzb.zza(parcel, 2, viewableItem.zzCS(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgi(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzjk(x0);
    }

    public ViewableItem zzgi(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        String[] strArr = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    strArr = zza.zzB(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ViewableItem(i, strArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public ViewableItem[] zzjk(int i) {
        return new ViewableItem[i];
    }
}
