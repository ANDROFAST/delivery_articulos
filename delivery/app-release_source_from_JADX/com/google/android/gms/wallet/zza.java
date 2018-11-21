package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Creator<Address> {
    static void zza(Address address, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, address.getVersionCode());
        zzb.zza(parcel, 2, address.name, false);
        zzb.zza(parcel, 3, address.zzaJQ, false);
        zzb.zza(parcel, 4, address.zzaJR, false);
        zzb.zza(parcel, 5, address.zzaJS, false);
        zzb.zza(parcel, 6, address.zzIE, false);
        zzb.zza(parcel, 7, address.zzbiX, false);
        zzb.zza(parcel, 8, address.zzbiY, false);
        zzb.zza(parcel, 9, address.zzaJX, false);
        zzb.zza(parcel, 10, address.phoneNumber, false);
        zzb.zza(parcel, 11, address.zzaJZ);
        zzb.zza(parcel, 12, address.zzaKa, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzhb(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzkv(x0);
    }

    public Address zzhb(Parcel parcel) {
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
        String str9 = null;
        boolean z = false;
        String str10 = null;
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
                    str9 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                case 11:
                    z = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzat);
                    break;
                case 12:
                    str10 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new Address(i, str, str2, str3, str4, str5, str6, str7, str8, str9, z, str10);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public Address[] zzkv(int i) {
        return new Address[i];
    }
}
