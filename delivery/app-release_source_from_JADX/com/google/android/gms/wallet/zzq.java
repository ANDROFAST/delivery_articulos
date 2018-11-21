package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzq implements Creator<ProxyCard> {
    static void zza(ProxyCard proxyCard, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, proxyCard.getVersionCode());
        zzb.zza(parcel, 2, proxyCard.zzbkw, false);
        zzb.zza(parcel, 3, proxyCard.zzbkx, false);
        zzb.zzc(parcel, 4, proxyCard.zzbky);
        zzb.zzc(parcel, 5, proxyCard.zzbkz);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzhr(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzkL(x0);
    }

    public ProxyCard zzhr(Parcel parcel) {
        String str = null;
        int i = 0;
        int zzau = zza.zzau(parcel);
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 3:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 5:
                    i = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ProxyCard(i3, str2, str, i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public ProxyCard[] zzkL(int i) {
        return new ProxyCard[i];
    }
}
