package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzbv implements Creator<StringListResponse> {
    static void zza(StringListResponse stringListResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, stringListResponse.getVersionCode());
        zzb.zzb(parcel, 2, stringListResponse.zzsY(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbT(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdO(x0);
    }

    public StringListResponse zzbT(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    list = zza.zzD(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new StringListResponse(i, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public StringListResponse[] zzdO(int i) {
        return new StringListResponse[i];
    }
}
