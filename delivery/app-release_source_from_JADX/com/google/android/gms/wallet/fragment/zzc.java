package com.google.android.gms.wallet.fragment;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Creator<WalletFragmentStyle> {
    static void zza(WalletFragmentStyle walletFragmentStyle, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, walletFragmentStyle.mVersionCode);
        zzb.zza(parcel, 2, walletFragmentStyle.zzbll, false);
        zzb.zzc(parcel, 3, walletFragmentStyle.zzblm);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzhz(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzkU(x0);
    }

    public WalletFragmentStyle zzhz(Parcel parcel) {
        int i = 0;
        int zzau = zza.zzau(parcel);
        Bundle bundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    bundle = zza.zzr(parcel, zzat);
                    break;
                case 3:
                    i = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new WalletFragmentStyle(i2, bundle, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public WalletFragmentStyle[] zzkU(int i) {
        return new WalletFragmentStyle[i];
    }
}
