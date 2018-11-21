package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzan implements Creator<GetCloudSyncOptInStatusResponse> {
    static void zza(GetCloudSyncOptInStatusResponse getCloudSyncOptInStatusResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, getCloudSyncOptInStatusResponse.versionCode);
        zzb.zzc(parcel, 2, getCloudSyncOptInStatusResponse.statusCode);
        zzb.zza(parcel, 3, getCloudSyncOptInStatusResponse.zzbnA);
        zzb.zza(parcel, 4, getCloudSyncOptInStatusResponse.zzbnB);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzif(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzlG(x0);
    }

    public GetCloudSyncOptInStatusResponse zzif(Parcel parcel) {
        boolean z = false;
        int zzau = zza.zzau(parcel);
        boolean z2 = false;
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
                    z2 = zza.zzc(parcel, zzat);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new GetCloudSyncOptInStatusResponse(i2, i, z2, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public GetCloudSyncOptInStatusResponse[] zzlG(int i) {
        return new GetCloudSyncOptInStatusResponse[i];
    }
}
