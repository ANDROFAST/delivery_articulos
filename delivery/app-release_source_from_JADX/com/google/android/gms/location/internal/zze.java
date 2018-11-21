package com.google.android.gms.location.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Creator<FusedLocationProviderResult> {
    static void zza(FusedLocationProviderResult fusedLocationProviderResult, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, fusedLocationProviderResult.getStatus(), i, false);
        zzb.zzc(parcel, 1000, fusedLocationProviderResult.getVersionCode());
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzeN(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzhs(x0);
    }

    public FusedLocationProviderResult zzeN(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        Status status = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    status = (Status) zza.zza(parcel, zzat, Status.CREATOR);
                    break;
                case 1000:
                    i = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new FusedLocationProviderResult(i, status);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public FusedLocationProviderResult[] zzhs(int i) {
        return new FusedLocationProviderResult[i];
    }
}
