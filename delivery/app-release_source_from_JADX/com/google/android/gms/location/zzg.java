package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzg implements Creator<LocationSettingsResult> {
    static void zza(LocationSettingsResult locationSettingsResult, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, locationSettingsResult.getStatus(), i, false);
        zzb.zzc(parcel, 1000, locationSettingsResult.getVersionCode());
        zzb.zza(parcel, 2, locationSettingsResult.getLocationSettingsStates(), i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzeK(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzhn(x0);
    }

    public LocationSettingsResult zzeK(Parcel parcel) {
        LocationSettingsStates locationSettingsStates = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        Status status = null;
        while (parcel.dataPosition() < zzau) {
            int i2;
            LocationSettingsStates locationSettingsStates2;
            Status status2;
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i2 = i;
                    Status status3 = (Status) zza.zza(parcel, zzat, Status.CREATOR);
                    locationSettingsStates2 = locationSettingsStates;
                    status2 = status3;
                    break;
                case 2:
                    locationSettingsStates2 = (LocationSettingsStates) zza.zza(parcel, zzat, LocationSettingsStates.CREATOR);
                    status2 = status;
                    i2 = i;
                    break;
                case 1000:
                    LocationSettingsStates locationSettingsStates3 = locationSettingsStates;
                    status2 = status;
                    i2 = zza.zzg(parcel, zzat);
                    locationSettingsStates2 = locationSettingsStates3;
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    locationSettingsStates2 = locationSettingsStates;
                    status2 = status;
                    i2 = i;
                    break;
            }
            i = i2;
            status = status2;
            locationSettingsStates = locationSettingsStates2;
        }
        if (parcel.dataPosition() == zzau) {
            return new LocationSettingsResult(i, status, locationSettingsStates);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public LocationSettingsResult[] zzhn(int i) {
        return new LocationSettingsResult[i];
    }
}
