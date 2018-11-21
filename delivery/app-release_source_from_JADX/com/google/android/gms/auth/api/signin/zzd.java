package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzd implements Creator<GoogleSignInOptions> {
    static void zza(GoogleSignInOptions googleSignInOptions, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, googleSignInOptions.versionCode);
        zzb.zzc(parcel, 2, googleSignInOptions.zzmu(), false);
        zzb.zza(parcel, 3, googleSignInOptions.getAccount(), i, false);
        zzb.zza(parcel, 4, googleSignInOptions.zzmy());
        zzb.zza(parcel, 5, googleSignInOptions.zzmz());
        zzb.zza(parcel, 6, googleSignInOptions.zzmA());
        zzb.zza(parcel, 7, googleSignInOptions.zzmB(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzS(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzaN(x0);
    }

    public GoogleSignInOptions zzS(Parcel parcel) {
        String str = null;
        boolean z = false;
        int zzau = zza.zzau(parcel);
        boolean z2 = false;
        boolean z3 = false;
        Account account = null;
        ArrayList arrayList = null;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    arrayList = zza.zzc(parcel, zzat, Scope.CREATOR);
                    break;
                case 3:
                    account = (Account) zza.zza(parcel, zzat, Account.CREATOR);
                    break;
                case 4:
                    z3 = zza.zzc(parcel, zzat);
                    break;
                case 5:
                    z2 = zza.zzc(parcel, zzat);
                    break;
                case 6:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 7:
                    str = zza.zzp(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new GoogleSignInOptions(i, arrayList, account, z3, z2, z, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public GoogleSignInOptions[] zzaN(int i) {
        return new GoogleSignInOptions[i];
    }
}
