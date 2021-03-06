package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzg implements Creator<AdRequestParcel> {
    static void zza(AdRequestParcel adRequestParcel, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, adRequestParcel.versionCode);
        zzb.zza(parcel, 2, adRequestParcel.zztq);
        zzb.zza(parcel, 3, adRequestParcel.extras, false);
        zzb.zzc(parcel, 4, adRequestParcel.zztr);
        zzb.zzb(parcel, 5, adRequestParcel.zzts, false);
        zzb.zza(parcel, 6, adRequestParcel.zztt);
        zzb.zzc(parcel, 7, adRequestParcel.zztu);
        zzb.zza(parcel, 8, adRequestParcel.zztv);
        zzb.zza(parcel, 9, adRequestParcel.zztw, false);
        zzb.zza(parcel, 10, adRequestParcel.zztx, i, false);
        zzb.zza(parcel, 11, adRequestParcel.zzty, i, false);
        zzb.zza(parcel, 12, adRequestParcel.zztz, false);
        zzb.zza(parcel, 13, adRequestParcel.zztA, false);
        zzb.zza(parcel, 14, adRequestParcel.zztB, false);
        zzb.zzb(parcel, 15, adRequestParcel.zztC, false);
        zzb.zza(parcel, 17, adRequestParcel.zztE, false);
        zzb.zza(parcel, 16, adRequestParcel.zztD, false);
        zzb.zza(parcel, 18, adRequestParcel.zztF);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzb(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzl(x0);
    }

    public AdRequestParcel zzb(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        long j = 0;
        Bundle bundle = null;
        int i2 = 0;
        List list = null;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        String str = null;
        SearchAdRequestParcel searchAdRequestParcel = null;
        Location location = null;
        String str2 = null;
        Bundle bundle2 = null;
        Bundle bundle3 = null;
        List list2 = null;
        String str3 = null;
        String str4 = null;
        boolean z3 = false;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    j = zza.zzi(parcel, zzat);
                    break;
                case 3:
                    bundle = zza.zzr(parcel, zzat);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 5:
                    list = zza.zzD(parcel, zzat);
                    break;
                case 6:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 7:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case 8:
                    z2 = zza.zzc(parcel, zzat);
                    break;
                case 9:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 10:
                    searchAdRequestParcel = (SearchAdRequestParcel) zza.zza(parcel, zzat, SearchAdRequestParcel.CREATOR);
                    break;
                case 11:
                    location = (Location) zza.zza(parcel, zzat, Location.CREATOR);
                    break;
                case 12:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 13:
                    bundle2 = zza.zzr(parcel, zzat);
                    break;
                case 14:
                    bundle3 = zza.zzr(parcel, zzat);
                    break;
                case 15:
                    list2 = zza.zzD(parcel, zzat);
                    break;
                case 16:
                    str3 = zza.zzp(parcel, zzat);
                    break;
                case 17:
                    str4 = zza.zzp(parcel, zzat);
                    break;
                case 18:
                    z3 = zza.zzc(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new AdRequestParcel(i, j, bundle, i2, list, z, i3, z2, str, searchAdRequestParcel, location, str2, bundle2, bundle3, list2, str3, str4, z3);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public AdRequestParcel[] zzl(int i) {
        return new AdRequestParcel[i];
    }
}
