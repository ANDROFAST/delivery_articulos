package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzb implements Creator<AccountChangeEventsRequest> {
    static void zza(AccountChangeEventsRequest accountChangeEventsRequest, Parcel parcel, int i) {
        int zzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, accountChangeEventsRequest.mVersion);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 2, accountChangeEventsRequest.zzTF);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, accountChangeEventsRequest.zzTD, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, accountChangeEventsRequest.zzSo, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzA(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzav(x0);
    }

    public AccountChangeEventsRequest zzA(Parcel parcel) {
        Account account = null;
        int i = 0;
        int zzau = zza.zzau(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 3:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 4:
                    account = (Account) zza.zza(parcel, zzat, Account.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new AccountChangeEventsRequest(i2, i, str, account);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public AccountChangeEventsRequest[] zzav(int i) {
        return new AccountChangeEventsRequest[i];
    }
}
