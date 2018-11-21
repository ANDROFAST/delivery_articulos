package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi implements Creator<WalletObjectMessage> {
    static void zza(WalletObjectMessage walletObjectMessage, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, walletObjectMessage.getVersionCode());
        zzb.zza(parcel, 2, walletObjectMessage.zzblF, false);
        zzb.zza(parcel, 3, walletObjectMessage.body, false);
        zzb.zza(parcel, 4, walletObjectMessage.zzblI, i, false);
        zzb.zza(parcel, 5, walletObjectMessage.zzblJ, i, false);
        zzb.zza(parcel, 6, walletObjectMessage.zzblK, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzhI(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzlf(x0);
    }

    public WalletObjectMessage zzhI(Parcel parcel) {
        UriData uriData = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        UriData uriData2 = null;
        TimeInterval timeInterval = null;
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
                    timeInterval = (TimeInterval) zza.zza(parcel, zzat, TimeInterval.CREATOR);
                    break;
                case 5:
                    uriData2 = (UriData) zza.zza(parcel, zzat, UriData.CREATOR);
                    break;
                case 6:
                    uriData = (UriData) zza.zza(parcel, zzat, UriData.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new WalletObjectMessage(i, str2, str, timeInterval, uriData2, uriData);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public WalletObjectMessage[] zzlf(int i) {
        return new WalletObjectMessage[i];
    }
}
