package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd implements Creator<AddLocalCapabilityResponse> {
    static void zza(AddLocalCapabilityResponse addLocalCapabilityResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, addLocalCapabilityResponse.versionCode);
        zzb.zzc(parcel, 2, addLocalCapabilityResponse.statusCode);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzhN(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzll(x0);
    }

    public AddLocalCapabilityResponse zzhN(Parcel parcel) {
        int i = 0;
        int zzau = zza.zzau(parcel);
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
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new AddLocalCapabilityResponse(i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public AddLocalCapabilityResponse[] zzll(int i) {
        return new AddLocalCapabilityResponse[i];
    }
}
