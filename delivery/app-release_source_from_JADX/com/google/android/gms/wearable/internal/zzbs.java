package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbs implements Creator<PutDataResponse> {
    static void zza(PutDataResponse putDataResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, putDataResponse.versionCode);
        zzb.zzc(parcel, 2, putDataResponse.statusCode);
        zzb.zza(parcel, 3, putDataResponse.zzbnF, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zziz(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzmb(x0);
    }

    public PutDataResponse zziz(Parcel parcel) {
        int i = 0;
        int zzau = zza.zzau(parcel);
        DataItemParcelable dataItemParcelable = null;
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
                    dataItemParcelable = (DataItemParcelable) zza.zza(parcel, zzat, DataItemParcelable.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new PutDataResponse(i2, i, dataItemParcelable);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public PutDataResponse[] zzmb(int i) {
        return new PutDataResponse[i];
    }
}
