package com.google.android.gms.identity.intents;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.List;

public class zza implements Creator<UserAddressRequest> {
    static void zza(UserAddressRequest userAddressRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, userAddressRequest.getVersionCode());
        zzb.zzc(parcel, 2, userAddressRequest.zzaJN, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzeC(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzgZ(x0);
    }

    public UserAddressRequest zzeC(Parcel parcel) {
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzcc(zzat)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    break;
                case 2:
                    list = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzat, CountrySpecification.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new UserAddressRequest(i, list);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public UserAddressRequest[] zzgZ(int i) {
        return new UserAddressRequest[i];
    }
}
