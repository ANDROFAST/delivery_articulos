package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Creator<AccountChangeEvent> {
    static void zza(AccountChangeEvent accountChangeEvent, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, accountChangeEvent.mVersion);
        zzb.zza(parcel, 2, accountChangeEvent.zzTC);
        zzb.zza(parcel, 3, accountChangeEvent.zzTD, false);
        zzb.zzc(parcel, 4, accountChangeEvent.zzTE);
        zzb.zzc(parcel, 5, accountChangeEvent.zzTF);
        zzb.zza(parcel, 6, accountChangeEvent.zzTG, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzz(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzau(x0);
    }

    public AccountChangeEvent[] zzau(int i) {
        return new AccountChangeEvent[i];
    }

    public AccountChangeEvent zzz(Parcel parcel) {
        String str = null;
        int i = 0;
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        long j = 0;
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzcc(zzat)) {
                case 1:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    break;
                case 2:
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, zzat);
                    break;
                case 3:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                case 4:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    break;
                case 5:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    break;
                case 6:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new AccountChangeEvent(i3, j, str2, i2, i, str);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzau, parcel);
    }
}
