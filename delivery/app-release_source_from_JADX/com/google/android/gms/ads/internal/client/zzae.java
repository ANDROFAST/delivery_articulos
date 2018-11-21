package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzae implements Creator<SearchAdRequestParcel> {
    static void zza(SearchAdRequestParcel searchAdRequestParcel, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, searchAdRequestParcel.versionCode);
        zzb.zzc(parcel, 2, searchAdRequestParcel.zzuI);
        zzb.zzc(parcel, 3, searchAdRequestParcel.backgroundColor);
        zzb.zzc(parcel, 4, searchAdRequestParcel.zzuJ);
        zzb.zzc(parcel, 5, searchAdRequestParcel.zzuK);
        zzb.zzc(parcel, 6, searchAdRequestParcel.zzuL);
        zzb.zzc(parcel, 7, searchAdRequestParcel.zzuM);
        zzb.zzc(parcel, 8, searchAdRequestParcel.zzuN);
        zzb.zzc(parcel, 9, searchAdRequestParcel.zzuO);
        zzb.zza(parcel, 10, searchAdRequestParcel.zzuP, false);
        zzb.zzc(parcel, 11, searchAdRequestParcel.zzuQ);
        zzb.zza(parcel, 12, searchAdRequestParcel.zzuR, false);
        zzb.zzc(parcel, 13, searchAdRequestParcel.zzuS);
        zzb.zzc(parcel, 14, searchAdRequestParcel.zzuT);
        zzb.zza(parcel, 15, searchAdRequestParcel.zzuU, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzd(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzo(x0);
    }

    public SearchAdRequestParcel zzd(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        String str = null;
        int i10 = 0;
        String str2 = null;
        int i11 = 0;
        int i12 = 0;
        String str3 = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 3:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case 4:
                    i4 = zza.zzg(parcel, zzat);
                    break;
                case 5:
                    i5 = zza.zzg(parcel, zzat);
                    break;
                case 6:
                    i6 = zza.zzg(parcel, zzat);
                    break;
                case 7:
                    i7 = zza.zzg(parcel, zzat);
                    break;
                case 8:
                    i8 = zza.zzg(parcel, zzat);
                    break;
                case 9:
                    i9 = zza.zzg(parcel, zzat);
                    break;
                case 10:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 11:
                    i10 = zza.zzg(parcel, zzat);
                    break;
                case 12:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 13:
                    i11 = zza.zzg(parcel, zzat);
                    break;
                case 14:
                    i12 = zza.zzg(parcel, zzat);
                    break;
                case 15:
                    str3 = zza.zzp(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new SearchAdRequestParcel(i, i2, i3, i4, i5, i6, i7, i8, i9, str, i10, str2, i11, i12, str3);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public SearchAdRequestParcel[] zzo(int i) {
        return new SearchAdRequestParcel[i];
    }
}
