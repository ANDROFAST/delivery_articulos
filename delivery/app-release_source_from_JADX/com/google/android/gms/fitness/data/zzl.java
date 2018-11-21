package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzl implements Creator<MapValue> {
    static void zza(MapValue mapValue, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, mapValue.getFormat());
        zzb.zzc(parcel, 1000, mapValue.getVersionCode());
        zzb.zza(parcel, 2, mapValue.zztR());
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcS(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzeR(x0);
    }

    public MapValue zzcS(Parcel parcel) {
        int i = 0;
        int zzau = zza.zzau(parcel);
        float f = 0.0f;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    f = zza.zzl(parcel, zzat);
                    break;
                case 1000:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new MapValue(i2, i, f);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public MapValue[] zzeR(int i) {
        return new MapValue[i];
    }
}
