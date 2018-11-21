package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzam implements Creator<GetCloudSyncOptInOutDoneResponse> {
    static void zza(GetCloudSyncOptInOutDoneResponse getCloudSyncOptInOutDoneResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, getCloudSyncOptInOutDoneResponse.versionCode);
        zzb.zzc(parcel, 2, getCloudSyncOptInOutDoneResponse.statusCode);
        zzb.zza(parcel, 3, getCloudSyncOptInOutDoneResponse.zzbnz);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzie(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzlF(x0);
    }

    public GetCloudSyncOptInOutDoneResponse zzie(Parcel parcel) {
        boolean z = false;
        int zzau = zza.zzau(parcel);
        int i = 0;
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
                    z = zza.zzc(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new GetCloudSyncOptInOutDoneResponse(i2, i, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public GetCloudSyncOptInOutDoneResponse[] zzlF(int i) {
        return new GetCloudSyncOptInOutDoneResponse[i];
    }
}
