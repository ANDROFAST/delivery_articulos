package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzk implements Creator<CapabilityInfoParcelable> {
    static void zza(CapabilityInfoParcelable capabilityInfoParcelable, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, capabilityInfoParcelable.mVersionCode);
        zzb.zza(parcel, 2, capabilityInfoParcelable.getName(), false);
        zzb.zzc(parcel, 3, capabilityInfoParcelable.zzGK(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzhQ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzlo(x0);
    }

    public CapabilityInfoParcelable zzhQ(Parcel parcel) {
        List list = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str = null;
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
                    list = zza.zzc(parcel, zzat, NodeParcelable.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new CapabilityInfoParcelable(i, str, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public CapabilityInfoParcelable[] zzlo(int i) {
        return new CapabilityInfoParcelable[i];
    }
}
