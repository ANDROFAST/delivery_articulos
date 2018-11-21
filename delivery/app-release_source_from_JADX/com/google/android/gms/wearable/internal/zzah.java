package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzah implements Creator<EnqueueLargeAssetResponse> {
    static void zza(EnqueueLargeAssetResponse enqueueLargeAssetResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, enqueueLargeAssetResponse.mVersionCode);
        zzb.zzc(parcel, 2, enqueueLargeAssetResponse.statusCode);
        zzb.zza(parcel, 3, enqueueLargeAssetResponse.zzbnv, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzhZ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzlA(x0);
    }

    public EnqueueLargeAssetResponse zzhZ(Parcel parcel) {
        int i = 0;
        int zzau = zza.zzau(parcel);
        LargeAssetQueueEntryParcelable largeAssetQueueEntryParcelable = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 3:
                    largeAssetQueueEntryParcelable = (LargeAssetQueueEntryParcelable) zza.zza(parcel, zzat, LargeAssetQueueEntryParcelable.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new EnqueueLargeAssetResponse(i2, i, largeAssetQueueEntryParcelable);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public EnqueueLargeAssetResponse[] zzlA(int i) {
        return new EnqueueLargeAssetResponse[i];
    }
}
