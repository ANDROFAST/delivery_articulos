package com.google.android.gms.location.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.location.LocationRequest;
import java.util.List;

public class zzm implements Creator<LocationRequestInternal> {
    static void zza(LocationRequestInternal locationRequestInternal, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, locationRequestInternal.zzayV, i, false);
        zzb.zzc(parcel, 1000, locationRequestInternal.getVersionCode());
        zzb.zza(parcel, 2, locationRequestInternal.zzaMb);
        zzb.zza(parcel, 3, locationRequestInternal.zzaMc);
        zzb.zza(parcel, 4, locationRequestInternal.zzaMd);
        zzb.zzc(parcel, 5, locationRequestInternal.zzaMe, false);
        zzb.zza(parcel, 6, locationRequestInternal.mTag, false);
        zzb.zza(parcel, 7, locationRequestInternal.zzaMf);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzeO(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzhu(x0);
    }

    public LocationRequestInternal zzeO(Parcel parcel) {
        String str = null;
        boolean z = true;
        boolean z2 = false;
        int zzau = zza.zzau(parcel);
        List list = LocationRequestInternal.zzaMa;
        boolean z3 = true;
        boolean z4 = false;
        LocationRequest locationRequest = null;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    locationRequest = (LocationRequest) zza.zza(parcel, zzat, LocationRequest.CREATOR);
                    break;
                case 2:
                    z4 = zza.zzc(parcel, zzat);
                    break;
                case 3:
                    z3 = zza.zzc(parcel, zzat);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 5:
                    list = zza.zzc(parcel, zzat, ClientIdentity.CREATOR);
                    break;
                case 6:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 7:
                    z2 = zza.zzc(parcel, zzat);
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
            return new LocationRequestInternal(i, locationRequest, z4, z3, z, list, str, z2);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public LocationRequestInternal[] zzhu(int i) {
        return new LocationRequestInternal[i];
    }
}
