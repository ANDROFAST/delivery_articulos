package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbu implements Creator<RemoveLargeAssetQueueEntriesResponse> {
    static void zza(RemoveLargeAssetQueueEntriesResponse removeLargeAssetQueueEntriesResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, removeLargeAssetQueueEntriesResponse.versionCode);
        zzb.zza(parcel, 2, removeLargeAssetQueueEntriesResponse.zzSE, i, false);
        zzb.zzc(parcel, 3, removeLargeAssetQueueEntriesResponse.zzbnu);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zziA(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzmf(x0);
    }

    public RemoveLargeAssetQueueEntriesResponse zziA(Parcel parcel) {
        int i = 0;
        int zzau = zza.zzau(parcel);
        Status status = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            Status status2;
            int zzg;
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    int i3 = i;
                    status2 = status;
                    zzg = zza.zzg(parcel, zzat);
                    zzat = i3;
                    break;
                case 2:
                    zzg = i2;
                    Status status3 = (Status) zza.zza(parcel, zzat, Status.CREATOR);
                    zzat = i;
                    status2 = status3;
                    break;
                case 3:
                    zzat = zza.zzg(parcel, zzat);
                    status2 = status;
                    zzg = i2;
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    zzat = i;
                    status2 = status;
                    zzg = i2;
                    break;
            }
            i2 = zzg;
            status = status2;
            i = zzat;
        }
        if (parcel.dataPosition() == zzau) {
            return new RemoveLargeAssetQueueEntriesResponse(i2, status, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public RemoveLargeAssetQueueEntriesResponse[] zzmf(int i) {
        return new RemoveLargeAssetQueueEntriesResponse[i];
    }
}
