package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

public class zzg implements Creator<GiftCardWalletObject> {
    static void zza(GiftCardWalletObject giftCardWalletObject, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, giftCardWalletObject.getVersionCode());
        zzb.zza(parcel, 2, giftCardWalletObject.zzbjt, i, false);
        zzb.zza(parcel, 3, giftCardWalletObject.zzbju, false);
        zzb.zza(parcel, 4, giftCardWalletObject.pin, false);
        zzb.zza(parcel, 5, giftCardWalletObject.zzbjv, false);
        zzb.zza(parcel, 6, giftCardWalletObject.zzbjw);
        zzb.zza(parcel, 7, giftCardWalletObject.zzbjx, false);
        zzb.zza(parcel, 8, giftCardWalletObject.zzbjy);
        zzb.zza(parcel, 9, giftCardWalletObject.zzbjz, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzhh(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzkB(x0);
    }

    public GiftCardWalletObject zzhh(Parcel parcel) {
        long j = 0;
        String str = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str2 = null;
        long j2 = 0;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        CommonWalletObject commonWalletObject = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    commonWalletObject = (CommonWalletObject) zza.zza(parcel, zzat, CommonWalletObject.CREATOR);
                    break;
                case 3:
                    str5 = zza.zzp(parcel, zzat);
                    break;
                case 4:
                    str4 = zza.zzp(parcel, zzat);
                    break;
                case 5:
                    str3 = zza.zzp(parcel, zzat);
                    break;
                case 6:
                    j2 = zza.zzi(parcel, zzat);
                    break;
                case 7:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 8:
                    j = zza.zzi(parcel, zzat);
                    break;
                case 9:
                    str = zza.zzp(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new GiftCardWalletObject(i, commonWalletObject, str5, str4, str3, j2, str2, j, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public GiftCardWalletObject[] zzkB(int i) {
        return new GiftCardWalletObject[i];
    }
}
