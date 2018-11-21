package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

public class zza implements Creator<CommonWalletObject> {
    static void zza(CommonWalletObject commonWalletObject, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, commonWalletObject.getVersionCode());
        zzb.zza(parcel, 2, commonWalletObject.zzif, false);
        zzb.zza(parcel, 3, commonWalletObject.zzbjN, false);
        zzb.zza(parcel, 4, commonWalletObject.name, false);
        zzb.zza(parcel, 5, commonWalletObject.zzbjH, false);
        zzb.zza(parcel, 6, commonWalletObject.zzbjJ, false);
        zzb.zza(parcel, 7, commonWalletObject.zzbjK, false);
        zzb.zza(parcel, 8, commonWalletObject.zzbjL, false);
        zzb.zza(parcel, 9, commonWalletObject.zzbjM, false);
        zzb.zzc(parcel, 10, commonWalletObject.state);
        zzb.zzc(parcel, 11, commonWalletObject.zzbjO, false);
        zzb.zza(parcel, 12, commonWalletObject.zzbjP, i, false);
        zzb.zzc(parcel, 13, commonWalletObject.zzbjQ, false);
        zzb.zza(parcel, 14, commonWalletObject.zzbjR, false);
        zzb.zza(parcel, 15, commonWalletObject.zzbjS, false);
        zzb.zza(parcel, 17, commonWalletObject.zzbjU);
        zzb.zzc(parcel, 16, commonWalletObject.zzbjT, false);
        zzb.zzc(parcel, 19, commonWalletObject.zzbjW, false);
        zzb.zzc(parcel, 18, commonWalletObject.zzbjV, false);
        zzb.zzc(parcel, 20, commonWalletObject.zzbjX, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzhA(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzkX(x0);
    }

    public CommonWalletObject zzhA(Parcel parcel) {
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        int i2 = 0;
        ArrayList zzrK = zznh.zzrK();
        TimeInterval timeInterval = null;
        ArrayList zzrK2 = zznh.zzrK();
        String str9 = null;
        String str10 = null;
        ArrayList zzrK3 = zznh.zzrK();
        boolean z = false;
        ArrayList zzrK4 = zznh.zzrK();
        ArrayList zzrK5 = zznh.zzrK();
        ArrayList zzrK6 = zznh.zzrK();
        while (parcel.dataPosition() < zzau) {
            int zzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzcc(zzat)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                case 3:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                case 4:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                case 5:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                case 6:
                    str5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                case 7:
                    str6 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                case 8:
                    str7 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                case 9:
                    str8 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                case 10:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    break;
                case 11:
                    zzrK = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzat, WalletObjectMessage.CREATOR);
                    break;
                case 12:
                    timeInterval = (TimeInterval) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzat, TimeInterval.CREATOR);
                    break;
                case 13:
                    zzrK2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzat, LatLng.CREATOR);
                    break;
                case 14:
                    str9 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                case 15:
                    str10 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                case 16:
                    zzrK3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzat, LabelValueRow.CREATOR);
                    break;
                case 17:
                    z = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzat);
                    break;
                case 18:
                    zzrK4 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzat, UriData.CREATOR);
                    break;
                case 19:
                    zzrK5 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzat, TextModuleData.CREATOR);
                    break;
                case 20:
                    zzrK6 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzat, UriData.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new CommonWalletObject(i, str, str2, str3, str4, str5, str6, str7, str8, i2, zzrK, timeInterval, zzrK2, str9, str10, zzrK3, z, zzrK4, zzrK5, zzrK6);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public CommonWalletObject[] zzkX(int i) {
        return new CommonWalletObject[i];
    }
}
