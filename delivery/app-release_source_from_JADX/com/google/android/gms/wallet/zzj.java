package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.wallet.wobs.LabelValueRow;
import com.google.android.gms.wallet.wobs.LoyaltyPoints;
import com.google.android.gms.wallet.wobs.TextModuleData;
import com.google.android.gms.wallet.wobs.TimeInterval;
import com.google.android.gms.wallet.wobs.UriData;
import com.google.android.gms.wallet.wobs.WalletObjectMessage;
import java.util.ArrayList;

public class zzj implements Creator<LoyaltyWalletObject> {
    static void zza(LoyaltyWalletObject loyaltyWalletObject, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, loyaltyWalletObject.getVersionCode());
        zzb.zza(parcel, 2, loyaltyWalletObject.zzif, false);
        zzb.zza(parcel, 3, loyaltyWalletObject.zzbjG, false);
        zzb.zza(parcel, 4, loyaltyWalletObject.zzbjH, false);
        zzb.zza(parcel, 5, loyaltyWalletObject.zzbjI, false);
        zzb.zza(parcel, 6, loyaltyWalletObject.zzaOo, false);
        zzb.zza(parcel, 7, loyaltyWalletObject.zzbjJ, false);
        zzb.zza(parcel, 8, loyaltyWalletObject.zzbjK, false);
        zzb.zza(parcel, 9, loyaltyWalletObject.zzbjL, false);
        zzb.zza(parcel, 10, loyaltyWalletObject.zzbjM, false);
        zzb.zza(parcel, 11, loyaltyWalletObject.zzbjN, false);
        zzb.zzc(parcel, 12, loyaltyWalletObject.state);
        zzb.zzc(parcel, 13, loyaltyWalletObject.zzbjO, false);
        zzb.zza(parcel, 14, loyaltyWalletObject.zzbjP, i, false);
        zzb.zzc(parcel, 15, loyaltyWalletObject.zzbjQ, false);
        zzb.zza(parcel, 17, loyaltyWalletObject.zzbjS, false);
        zzb.zza(parcel, 16, loyaltyWalletObject.zzbjR, false);
        zzb.zza(parcel, 19, loyaltyWalletObject.zzbjU);
        zzb.zzc(parcel, 18, loyaltyWalletObject.zzbjT, false);
        zzb.zzc(parcel, 21, loyaltyWalletObject.zzbjW, false);
        zzb.zzc(parcel, 20, loyaltyWalletObject.zzbjV, false);
        zzb.zza(parcel, 23, loyaltyWalletObject.zzbjY, i, false);
        zzb.zzc(parcel, 22, loyaltyWalletObject.zzbjX, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzhk(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzkE(x0);
    }

    public LoyaltyWalletObject zzhk(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        int i2 = 0;
        ArrayList zzrK = zznh.zzrK();
        TimeInterval timeInterval = null;
        ArrayList zzrK2 = zznh.zzrK();
        String str11 = null;
        String str12 = null;
        ArrayList zzrK3 = zznh.zzrK();
        boolean z = false;
        ArrayList zzrK4 = zznh.zzrK();
        ArrayList zzrK5 = zznh.zzrK();
        ArrayList zzrK6 = zznh.zzrK();
        LoyaltyPoints loyaltyPoints = null;
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
                    str3 = zza.zzp(parcel, zzat);
                    break;
                case 5:
                    str4 = zza.zzp(parcel, zzat);
                    break;
                case 6:
                    str5 = zza.zzp(parcel, zzat);
                    break;
                case 7:
                    str6 = zza.zzp(parcel, zzat);
                    break;
                case 8:
                    str7 = zza.zzp(parcel, zzat);
                    break;
                case 9:
                    str8 = zza.zzp(parcel, zzat);
                    break;
                case 10:
                    str9 = zza.zzp(parcel, zzat);
                    break;
                case 11:
                    str10 = zza.zzp(parcel, zzat);
                    break;
                case 12:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 13:
                    zzrK = zza.zzc(parcel, zzat, WalletObjectMessage.CREATOR);
                    break;
                case 14:
                    timeInterval = (TimeInterval) zza.zza(parcel, zzat, TimeInterval.CREATOR);
                    break;
                case 15:
                    zzrK2 = zza.zzc(parcel, zzat, LatLng.CREATOR);
                    break;
                case 16:
                    str11 = zza.zzp(parcel, zzat);
                    break;
                case 17:
                    str12 = zza.zzp(parcel, zzat);
                    break;
                case 18:
                    zzrK3 = zza.zzc(parcel, zzat, LabelValueRow.CREATOR);
                    break;
                case 19:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 20:
                    zzrK4 = zza.zzc(parcel, zzat, UriData.CREATOR);
                    break;
                case 21:
                    zzrK5 = zza.zzc(parcel, zzat, TextModuleData.CREATOR);
                    break;
                case 22:
                    zzrK6 = zza.zzc(parcel, zzat, UriData.CREATOR);
                    break;
                case 23:
                    loyaltyPoints = (LoyaltyPoints) zza.zza(parcel, zzat, LoyaltyPoints.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new LoyaltyWalletObject(i, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, i2, zzrK, timeInterval, zzrK2, str11, str12, zzrK3, z, zzrK4, zzrK5, zzrK6, loyaltyPoints);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public LoyaltyWalletObject[] zzkE(int i) {
        return new LoyaltyWalletObject[i];
    }
}
