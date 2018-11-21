package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbg implements Creator<LargeAssetQueueStateChangeParcelable> {
    static void zza(LargeAssetQueueStateChangeParcelable largeAssetQueueStateChangeParcelable, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, largeAssetQueueStateChangeParcelable.mVersionCode);
        zzb.zza(parcel, 4, largeAssetQueueStateChangeParcelable.zzbnX, i, false);
        zzb.zza(parcel, 5, largeAssetQueueStateChangeParcelable.zzGV(), i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzir(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzlS(x0);
    }

    public LargeAssetQueueStateChangeParcelable zzir(Parcel parcel) {
        LargeAssetQueueStateParcelable largeAssetQueueStateParcelable = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        DataHolder dataHolder = null;
        while (parcel.dataPosition() < zzau) {
            DataHolder dataHolder2;
            int zzg;
            LargeAssetQueueStateParcelable largeAssetQueueStateParcelable2;
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    LargeAssetQueueStateParcelable largeAssetQueueStateParcelable3 = largeAssetQueueStateParcelable;
                    dataHolder2 = dataHolder;
                    zzg = zza.zzg(parcel, zzat);
                    largeAssetQueueStateParcelable2 = largeAssetQueueStateParcelable3;
                    break;
                case 4:
                    zzg = i;
                    DataHolder dataHolder3 = (DataHolder) zza.zza(parcel, zzat, DataHolder.CREATOR);
                    largeAssetQueueStateParcelable2 = largeAssetQueueStateParcelable;
                    dataHolder2 = dataHolder3;
                    break;
                case 5:
                    largeAssetQueueStateParcelable2 = (LargeAssetQueueStateParcelable) zza.zza(parcel, zzat, LargeAssetQueueStateParcelable.CREATOR);
                    dataHolder2 = dataHolder;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    largeAssetQueueStateParcelable2 = largeAssetQueueStateParcelable;
                    dataHolder2 = dataHolder;
                    zzg = i;
                    break;
            }
            i = zzg;
            dataHolder = dataHolder2;
            largeAssetQueueStateParcelable = largeAssetQueueStateParcelable2;
        }
        if (parcel.dataPosition() == zzau) {
            return new LargeAssetQueueStateChangeParcelable(i, dataHolder, largeAssetQueueStateParcelable);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public LargeAssetQueueStateChangeParcelable[] zzlS(int i) {
        return new LargeAssetQueueStateChangeParcelable[i];
    }
}
