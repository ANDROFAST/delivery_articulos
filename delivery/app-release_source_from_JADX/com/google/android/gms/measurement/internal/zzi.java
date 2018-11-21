package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi implements Creator<EventParams> {
    static void zza(EventParams eventParams, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, eventParams.versionCode);
        zzb.zza(parcel, 2, eventParams.zzBh(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfD(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zziw(x0);
    }

    public EventParams zzfD(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        Bundle bundle = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    bundle = zza.zzr(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new EventParams(i, bundle);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public EventParams[] zziw(int i) {
        return new EventParams[i];
    }
}
