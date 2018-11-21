package com.google.android.gms.auth.api.signin;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.ArrayList;

public class zzb implements Creator<FacebookSignInOptions> {
    static void zza(FacebookSignInOptions facebookSignInOptions, Parcel parcel, int i) {
        int zzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, facebookSignInOptions.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, facebookSignInOptions.zzmt(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, 3, facebookSignInOptions.zzmu(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzQ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzaL(x0);
    }

    public FacebookSignInOptions zzQ(Parcel parcel) {
        ArrayList arrayList = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        Intent intent = null;
        while (parcel.dataPosition() < zzau) {
            Intent intent2;
            int zzg;
            ArrayList arrayList2;
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    ArrayList arrayList3 = arrayList;
                    intent2 = intent;
                    zzg = zza.zzg(parcel, zzat);
                    arrayList2 = arrayList3;
                    break;
                case 2:
                    zzg = i;
                    Intent intent3 = (Intent) zza.zza(parcel, zzat, Intent.CREATOR);
                    arrayList2 = arrayList;
                    intent2 = intent3;
                    break;
                case 3:
                    arrayList2 = zza.zzD(parcel, zzat);
                    intent2 = intent;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    arrayList2 = arrayList;
                    intent2 = intent;
                    zzg = i;
                    break;
            }
            i = zzg;
            intent = intent2;
            arrayList = arrayList2;
        }
        if (parcel.dataPosition() == zzau) {
            return new FacebookSignInOptions(i, intent, arrayList);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public FacebookSignInOptions[] zzaL(int i) {
        return new FacebookSignInOptions[i];
    }
}
