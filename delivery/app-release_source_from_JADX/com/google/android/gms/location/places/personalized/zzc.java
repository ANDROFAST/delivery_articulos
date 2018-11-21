package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Creator<PlaceAliasResult> {
    static void zza(PlaceAliasResult placeAliasResult, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, placeAliasResult.getStatus(), i, false);
        zzb.zzc(parcel, 1000, placeAliasResult.mVersionCode);
        zzb.zza(parcel, 2, placeAliasResult.zzyP(), i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfi(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzhT(x0);
    }

    public PlaceAliasResult zzfi(Parcel parcel) {
        PlaceUserData placeUserData = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        Status status = null;
        while (parcel.dataPosition() < zzau) {
            int i2;
            PlaceUserData placeUserData2;
            Status status2;
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i2 = i;
                    Status status3 = (Status) zza.zza(parcel, zzat, Status.CREATOR);
                    placeUserData2 = placeUserData;
                    status2 = status3;
                    break;
                case 2:
                    placeUserData2 = (PlaceUserData) zza.zza(parcel, zzat, PlaceUserData.CREATOR);
                    status2 = status;
                    i2 = i;
                    break;
                case 1000:
                    PlaceUserData placeUserData3 = placeUserData;
                    status2 = status;
                    i2 = zza.zzg(parcel, zzat);
                    placeUserData2 = placeUserData3;
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    placeUserData2 = placeUserData;
                    status2 = status;
                    i2 = i;
                    break;
            }
            i = i2;
            status = status2;
            placeUserData = placeUserData2;
        }
        if (parcel.dataPosition() == zzau) {
            return new PlaceAliasResult(i, status, placeUserData);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public PlaceAliasResult[] zzhT(int i) {
        return new PlaceAliasResult[i];
    }
}
