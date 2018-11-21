package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzai implements Creator<GetAllCapabilitiesResponse> {
    static void zza(GetAllCapabilitiesResponse getAllCapabilitiesResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, getAllCapabilitiesResponse.versionCode);
        zzb.zzc(parcel, 2, getAllCapabilitiesResponse.statusCode);
        zzb.zzc(parcel, 3, getAllCapabilitiesResponse.zzbnw, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzia(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzlB(x0);
    }

    public GetAllCapabilitiesResponse zzia(Parcel parcel) {
        int i = 0;
        int zzau = zza.zzau(parcel);
        List list = null;
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
                    list = zza.zzc(parcel, zzat, CapabilityInfoParcelable.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new GetAllCapabilitiesResponse(i2, i, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public GetAllCapabilitiesResponse[] zzlB(int i) {
        return new GetAllCapabilitiesResponse[i];
    }
}
