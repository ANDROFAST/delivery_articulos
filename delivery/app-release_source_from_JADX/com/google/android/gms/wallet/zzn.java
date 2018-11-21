package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

public class zzn implements Creator<OfferWalletObject> {
    static void zza(OfferWalletObject offerWalletObject, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, offerWalletObject.getVersionCode());
        zzb.zza(parcel, 2, offerWalletObject.zzif, false);
        zzb.zza(parcel, 3, offerWalletObject.zzbks, false);
        zzb.zza(parcel, 4, offerWalletObject.zzbjt, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzho(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzkI(x0);
    }

    public OfferWalletObject zzho(Parcel parcel) {
        CommonWalletObject commonWalletObject = null;
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
                    commonWalletObject = (CommonWalletObject) zza.zza(parcel, zzat, CommonWalletObject.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new OfferWalletObject(i, str2, str, commonWalletObject);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public OfferWalletObject[] zzkI(int i) {
        return new OfferWalletObject[i];
    }
}
