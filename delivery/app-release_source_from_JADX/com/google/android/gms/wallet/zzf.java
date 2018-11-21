package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzf implements Creator<FullWalletRequest> {
    static void zza(FullWalletRequest fullWalletRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, fullWalletRequest.getVersionCode());
        zzb.zza(parcel, 2, fullWalletRequest.zzbjg, false);
        zzb.zza(parcel, 3, fullWalletRequest.zzbjh, false);
        zzb.zza(parcel, 4, fullWalletRequest.zzbjr, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzhg(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzkA(x0);
    }

    public FullWalletRequest zzhg(Parcel parcel) {
        Cart cart = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str = null;
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
                    cart = (Cart) zza.zza(parcel, zzat, Cart.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new FullWalletRequest(i, str2, str, cart);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public FullWalletRequest[] zzkA(int i) {
        return new FullWalletRequest[i];
    }
}
