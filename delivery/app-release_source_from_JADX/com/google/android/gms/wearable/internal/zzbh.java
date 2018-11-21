package com.google.android.gms.wearable.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbh implements Creator<LargeAssetQueueStateParcelable> {
    static void zza(LargeAssetQueueStateParcelable largeAssetQueueStateParcelable, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, largeAssetQueueStateParcelable.mVersionCode);
        zzb.zzc(parcel, 2, largeAssetQueueStateParcelable.zzbnZ);
        zzb.zza(parcel, 3, largeAssetQueueStateParcelable.zzboa, false);
        zzb.zza(parcel, 4, largeAssetQueueStateParcelable.zzGW(), false);
        zzb.zzc(parcel, 5, largeAssetQueueStateParcelable.zzboc);
        zzb.zzc(parcel, 6, largeAssetQueueStateParcelable.zzbod);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzis(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzlU(x0);
    }

    public LargeAssetQueueStateParcelable zzis(Parcel parcel) {
        Bundle bundle = null;
        int i = 0;
        int zzau = zza.zzau(parcel);
        int i2 = 0;
        String str = null;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i4 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case 3:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 4:
                    bundle = zza.zzr(parcel, zzat);
                    break;
                case 5:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 6:
                    i = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new LargeAssetQueueStateParcelable(i4, i3, str, bundle, i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public LargeAssetQueueStateParcelable[] zzlU(int i) {
        return new LargeAssetQueueStateParcelable[i];
    }
}
