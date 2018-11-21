package com.google.android.gms.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zze implements Creator<LocationResult> {
    static void zza(LocationResult locationResult, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, locationResult.getLocations(), false);
        zzb.zzc(parcel, 1000, locationResult.getVersionCode());
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzeI(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzhl(x0);
    }

    public LocationResult zzeI(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        List list = LocationResult.zzaLp;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    list = zza.zzc(parcel, zzat, Location.CREATOR);
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
            return new LocationResult(i, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public LocationResult[] zzhl(int i) {
        return new LocationResult[i];
    }
}
