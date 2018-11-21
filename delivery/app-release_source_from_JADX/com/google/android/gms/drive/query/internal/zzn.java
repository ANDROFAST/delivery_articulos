package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzn implements Creator<Operator> {
    static void zza(Operator operator, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1000, operator.mVersionCode);
        zzb.zza(parcel, 1, operator.mTag, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcr(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzem(x0);
    }

    public Operator zzcr(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    str = zza.zzp(parcel, zzat);
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
            return new Operator(i, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public Operator[] zzem(int i) {
        return new Operator[i];
    }
}
