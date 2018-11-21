package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzau implements Creator<GetLargeAssetQueueStateResponse> {
    static void zza(GetLargeAssetQueueStateResponse getLargeAssetQueueStateResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, getLargeAssetQueueStateResponse.mVersionCode);
        zzb.zza(parcel, 2, getLargeAssetQueueStateResponse.zzSE, i, false);
        zzb.zza(parcel, 3, getLargeAssetQueueStateResponse.zzbnH, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzim(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzlN(x0);
    }

    public GetLargeAssetQueueStateResponse zzim(Parcel parcel) {
        LargeAssetQueueStateParcelable largeAssetQueueStateParcelable = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        Status status = null;
        while (parcel.dataPosition() < zzau) {
            Status status2;
            int zzg;
            LargeAssetQueueStateParcelable largeAssetQueueStateParcelable2;
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    LargeAssetQueueStateParcelable largeAssetQueueStateParcelable3 = largeAssetQueueStateParcelable;
                    status2 = status;
                    zzg = zza.zzg(parcel, zzat);
                    largeAssetQueueStateParcelable2 = largeAssetQueueStateParcelable3;
                    break;
                case 2:
                    zzg = i;
                    Status status3 = (Status) zza.zza(parcel, zzat, Status.CREATOR);
                    largeAssetQueueStateParcelable2 = largeAssetQueueStateParcelable;
                    status2 = status3;
                    break;
                case 3:
                    largeAssetQueueStateParcelable2 = (LargeAssetQueueStateParcelable) zza.zza(parcel, zzat, LargeAssetQueueStateParcelable.CREATOR);
                    status2 = status;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    largeAssetQueueStateParcelable2 = largeAssetQueueStateParcelable;
                    status2 = status;
                    zzg = i;
                    break;
            }
            i = zzg;
            status = status2;
            largeAssetQueueStateParcelable = largeAssetQueueStateParcelable2;
        }
        if (parcel.dataPosition() == zzau) {
            return new GetLargeAssetQueueStateResponse(i, status, largeAssetQueueStateParcelable);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public GetLargeAssetQueueStateResponse[] zzlN(int i) {
        return new GetLargeAssetQueueStateResponse[i];
    }
}
