package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzd implements Creator<NearbyAlertFilter> {
    static void zza(NearbyAlertFilter nearbyAlertFilter, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzb(parcel, 1, nearbyAlertFilter.zzaMv, false);
        zzb.zzc(parcel, 1000, nearbyAlertFilter.mVersionCode);
        zzb.zza(parcel, 2, nearbyAlertFilter.zzaMt, false);
        zzb.zzc(parcel, 3, nearbyAlertFilter.zzaMw, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzeT(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzhB(x0);
    }

    public NearbyAlertFilter zzeT(Parcel parcel) {
        List list = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        List list2 = null;
        List list3 = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    list3 = zza.zzD(parcel, zzat);
                    break;
                case 2:
                    list2 = zza.zzC(parcel, zzat);
                    break;
                case 3:
                    list = zza.zzc(parcel, zzat, UserDataType.CREATOR);
                    break;
                case 1000:
                    i = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new NearbyAlertFilter(i, list3, list2, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public NearbyAlertFilter[] zzhB(int i) {
        return new NearbyAlertFilter[i];
    }
}
