package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzh implements Creator<AdResponseParcel> {
    static void zza(AdResponseParcel adResponseParcel, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, adResponseParcel.versionCode);
        zzb.zza(parcel, 2, adResponseParcel.zzDE, false);
        zzb.zza(parcel, 3, adResponseParcel.body, false);
        zzb.zzb(parcel, 4, adResponseParcel.zzAQ, false);
        zzb.zzc(parcel, 5, adResponseParcel.errorCode);
        zzb.zzb(parcel, 6, adResponseParcel.zzAR, false);
        zzb.zza(parcel, 7, adResponseParcel.zzGM);
        zzb.zza(parcel, 8, adResponseParcel.zzGN);
        zzb.zza(parcel, 9, adResponseParcel.zzGO);
        zzb.zzb(parcel, 10, adResponseParcel.zzGP, false);
        zzb.zza(parcel, 11, adResponseParcel.zzAU);
        zzb.zzc(parcel, 12, adResponseParcel.orientation);
        zzb.zza(parcel, 13, adResponseParcel.zzGQ, false);
        zzb.zza(parcel, 14, adResponseParcel.zzGR);
        zzb.zza(parcel, 15, adResponseParcel.zzGS, false);
        zzb.zza(parcel, 19, adResponseParcel.zzGU, false);
        zzb.zza(parcel, 18, adResponseParcel.zzGT);
        zzb.zza(parcel, 21, adResponseParcel.zzGV, false);
        zzb.zza(parcel, 23, adResponseParcel.zztY);
        zzb.zza(parcel, 22, adResponseParcel.zzGW);
        zzb.zza(parcel, 25, adResponseParcel.zzGX);
        zzb.zza(parcel, 24, adResponseParcel.zzGy);
        zzb.zzc(parcel, 27, adResponseParcel.zzGZ);
        zzb.zza(parcel, 26, adResponseParcel.zzGY);
        zzb.zza(parcel, 29, adResponseParcel.zzHb, false);
        zzb.zza(parcel, 28, adResponseParcel.zzHa, i, false);
        zzb.zza(parcel, 31, adResponseParcel.zztZ);
        zzb.zza(parcel, 30, adResponseParcel.zzHc, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzj(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzH(x0);
    }

    public AdResponseParcel[] zzH(int i) {
        return new AdResponseParcel[i];
    }

    public AdResponseParcel zzj(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        List list = null;
        int i2 = 0;
        List list2 = null;
        long j = 0;
        boolean z = false;
        long j2 = 0;
        List list3 = null;
        long j3 = 0;
        int i3 = 0;
        String str3 = null;
        long j4 = 0;
        String str4 = null;
        boolean z2 = false;
        String str5 = null;
        String str6 = null;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        int i4 = 0;
        LargeParcelTeleporter largeParcelTeleporter = null;
        String str7 = null;
        String str8 = null;
        boolean z8 = false;
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
                    list = zza.zzD(parcel, zzat);
                    break;
                case 5:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 6:
                    list2 = zza.zzD(parcel, zzat);
                    break;
                case 7:
                    j = zza.zzi(parcel, zzat);
                    break;
                case 8:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 9:
                    j2 = zza.zzi(parcel, zzat);
                    break;
                case 10:
                    list3 = zza.zzD(parcel, zzat);
                    break;
                case 11:
                    j3 = zza.zzi(parcel, zzat);
                    break;
                case 12:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case 13:
                    str3 = zza.zzp(parcel, zzat);
                    break;
                case 14:
                    j4 = zza.zzi(parcel, zzat);
                    break;
                case 15:
                    str4 = zza.zzp(parcel, zzat);
                    break;
                case 18:
                    z2 = zza.zzc(parcel, zzat);
                    break;
                case 19:
                    str5 = zza.zzp(parcel, zzat);
                    break;
                case 21:
                    str6 = zza.zzp(parcel, zzat);
                    break;
                case 22:
                    z3 = zza.zzc(parcel, zzat);
                    break;
                case 23:
                    z4 = zza.zzc(parcel, zzat);
                    break;
                case 24:
                    z5 = zza.zzc(parcel, zzat);
                    break;
                case 25:
                    z6 = zza.zzc(parcel, zzat);
                    break;
                case 26:
                    z7 = zza.zzc(parcel, zzat);
                    break;
                case 27:
                    i4 = zza.zzg(parcel, zzat);
                    break;
                case 28:
                    largeParcelTeleporter = (LargeParcelTeleporter) zza.zza(parcel, zzat, LargeParcelTeleporter.CREATOR);
                    break;
                case 29:
                    str7 = zza.zzp(parcel, zzat);
                    break;
                case 30:
                    str8 = zza.zzp(parcel, zzat);
                    break;
                case 31:
                    z8 = zza.zzc(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new AdResponseParcel(i, str, str2, list, i2, list2, j, z, j2, list3, j3, i3, str3, j4, str4, z2, str5, str6, z3, z4, z5, z6, z7, i4, largeParcelTeleporter, str7, str8, z8);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }
}
