package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzb implements Creator<AppMetadata> {
    static void zza(AppMetadata appMetadata, Parcel parcel, int i) {
        int zzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, appMetadata.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, appMetadata.packageName, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, appMetadata.zzaSn, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, appMetadata.zzaKi, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, appMetadata.zzaSo, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, appMetadata.zzaSp);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, appMetadata.zzaSq);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, appMetadata.zzaSr, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, appMetadata.zzaSs);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfC(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zziv(x0);
    }

    public AppMetadata zzfC(Parcel parcel) {
        long j = 0;
        boolean z = false;
        String str = null;
        int zzau = zza.zzau(parcel);
        long j2 = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    str5 = zza.zzp(parcel, zzat);
                    break;
                case 3:
                    str4 = zza.zzp(parcel, zzat);
                    break;
                case 4:
                    str3 = zza.zzp(parcel, zzat);
                    break;
                case 5:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 6:
                    j2 = zza.zzi(parcel, zzat);
                    break;
                case 7:
                    j = zza.zzi(parcel, zzat);
                    break;
                case 8:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 9:
                    z = zza.zzc(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new AppMetadata(i, str5, str4, str3, str2, j2, j, str, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public AppMetadata[] zziv(int i) {
        return new AppMetadata[i];
    }
}
