package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbi implements Creator<LargeAssetRemoveRequest> {
    static void zza(LargeAssetRemoveRequest largeAssetRemoveRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, largeAssetRemoveRequest.mVersionCode);
        zzb.zza(parcel, 2, largeAssetRemoveRequest.zzbof, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzit(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzlV(x0);
    }

    public LargeAssetRemoveRequest zzit(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        long[] jArr = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    jArr = zza.zzw(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new LargeAssetRemoveRequest(i, jArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public LargeAssetRemoveRequest[] zzlV(int i) {
        return new LargeAssetRemoveRequest[i];
    }
}
