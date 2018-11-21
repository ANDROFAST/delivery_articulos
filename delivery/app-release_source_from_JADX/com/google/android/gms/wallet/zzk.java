package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.identity.intents.model.UserAddress;

public class zzk implements Creator<MaskedWallet> {
    static void zza(MaskedWallet maskedWallet, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, maskedWallet.getVersionCode());
        zzb.zza(parcel, 2, maskedWallet.zzbjg, false);
        zzb.zza(parcel, 3, maskedWallet.zzbjh, false);
        zzb.zza(parcel, 4, maskedWallet.zzbjm, false);
        zzb.zza(parcel, 5, maskedWallet.zzbjj, false);
        zzb.zza(parcel, 6, maskedWallet.zzbjk, i, false);
        zzb.zza(parcel, 7, maskedWallet.zzbjl, i, false);
        zzb.zza(parcel, 8, maskedWallet.zzbjZ, i, false);
        zzb.zza(parcel, 9, maskedWallet.zzbka, i, false);
        zzb.zza(parcel, 10, maskedWallet.zzbjn, i, false);
        zzb.zza(parcel, 11, maskedWallet.zzbjo, i, false);
        zzb.zza(parcel, 12, maskedWallet.zzbjp, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzhl(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzkF(x0);
    }

    public MaskedWallet zzhl(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String[] strArr = null;
        String str3 = null;
        Address address = null;
        Address address2 = null;
        LoyaltyWalletObject[] loyaltyWalletObjectArr = null;
        OfferWalletObject[] offerWalletObjectArr = null;
        UserAddress userAddress = null;
        UserAddress userAddress2 = null;
        InstrumentInfo[] instrumentInfoArr = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 3:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 4:
                    strArr = zza.zzB(parcel, zzat);
                    break;
                case 5:
                    str3 = zza.zzp(parcel, zzat);
                    break;
                case 6:
                    address = (Address) zza.zza(parcel, zzat, Address.CREATOR);
                    break;
                case 7:
                    address2 = (Address) zza.zza(parcel, zzat, Address.CREATOR);
                    break;
                case 8:
                    loyaltyWalletObjectArr = (LoyaltyWalletObject[]) zza.zzb(parcel, zzat, LoyaltyWalletObject.CREATOR);
                    break;
                case 9:
                    offerWalletObjectArr = (OfferWalletObject[]) zza.zzb(parcel, zzat, OfferWalletObject.CREATOR);
                    break;
                case 10:
                    userAddress = (UserAddress) zza.zza(parcel, zzat, UserAddress.CREATOR);
                    break;
                case 11:
                    userAddress2 = (UserAddress) zza.zza(parcel, zzat, UserAddress.CREATOR);
                    break;
                case 12:
                    instrumentInfoArr = (InstrumentInfo[]) zza.zzb(parcel, zzat, InstrumentInfo.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new MaskedWallet(i, str, str2, strArr, str3, address, address2, loyaltyWalletObjectArr, offerWalletObjectArr, userAddress, userAddress2, instrumentInfoArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public MaskedWallet[] zzkF(int i) {
        return new MaskedWallet[i];
    }
}
