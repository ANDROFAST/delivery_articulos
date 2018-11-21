package com.google.android.gms.drive.metadata;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Creator<CustomPropertyKey> {
    static void zza(CustomPropertyKey customPropertyKey, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, customPropertyKey.mVersionCode);
        zzb.zza(parcel, 2, customPropertyKey.zzuX, false);
        zzb.zzc(parcel, 3, customPropertyKey.mVisibility);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbZ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdU(x0);
    }

    public CustomPropertyKey zzbZ(Parcel parcel) {
        int i = 0;
        int zzau = zza.zzau(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 3:
                    i = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new CustomPropertyKey(i2, str, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public CustomPropertyKey[] zzdU(int i) {
        return new CustomPropertyKey[i];
    }
}
