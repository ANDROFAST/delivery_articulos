package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzf implements Creator<AmsEntityUpdateParcelable> {
    static void zza(AmsEntityUpdateParcelable amsEntityUpdateParcelable, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, amsEntityUpdateParcelable.mVersionCode);
        zzb.zza(parcel, 2, amsEntityUpdateParcelable.zzGC());
        zzb.zza(parcel, 3, amsEntityUpdateParcelable.zzGD());
        zzb.zza(parcel, 4, amsEntityUpdateParcelable.getValue(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzhO(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzlm(x0);
    }

    public AmsEntityUpdateParcelable zzhO(Parcel parcel) {
        byte b = (byte) 0;
        int zzau = zza.zzau(parcel);
        String str = null;
        byte b2 = (byte) 0;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    b2 = zza.zze(parcel, zzat);
                    break;
                case 3:
                    b = zza.zze(parcel, zzat);
                    break;
                case 4:
                    str = zza.zzp(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new AmsEntityUpdateParcelable(i, b2, b, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public AmsEntityUpdateParcelable[] zzlm(int i) {
        return new AmsEntityUpdateParcelable[i];
    }
}
