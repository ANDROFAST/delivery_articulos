package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Creator<NearbyAlertRequest> {
    static void zza(NearbyAlertRequest nearbyAlertRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, nearbyAlertRequest.zzyj());
        zzb.zzc(parcel, 1000, nearbyAlertRequest.getVersionCode());
        zzb.zzc(parcel, 2, nearbyAlertRequest.zzym());
        zzb.zza(parcel, 3, nearbyAlertRequest.zzyn(), i, false);
        zzb.zza(parcel, 4, nearbyAlertRequest.zzyo(), i, false);
        zzb.zza(parcel, 5, nearbyAlertRequest.zzyp());
        zzb.zzc(parcel, 6, nearbyAlertRequest.zzyq());
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzeU(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzhC(x0);
    }

    public NearbyAlertRequest zzeU(Parcel parcel) {
        NearbyAlertFilter nearbyAlertFilter = null;
        int i = 0;
        int zzau = zza.zzau(parcel);
        int i2 = -1;
        boolean z = false;
        PlaceFilter placeFilter = null;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 3:
                    placeFilter = (PlaceFilter) zza.zza(parcel, zzat, PlaceFilter.CREATOR);
                    break;
                case 4:
                    nearbyAlertFilter = (NearbyAlertFilter) zza.zza(parcel, zzat, NearbyAlertFilter.CREATOR);
                    break;
                case 5:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 6:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 1000:
                    i4 = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new NearbyAlertRequest(i4, i3, i2, placeFilter, nearbyAlertFilter, z, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public NearbyAlertRequest[] zzhC(int i) {
        return new NearbyAlertRequest[i];
    }
}
