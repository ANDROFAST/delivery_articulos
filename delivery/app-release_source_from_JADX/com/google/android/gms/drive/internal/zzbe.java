package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbe implements Creator<OnListParentsResponse> {
    static void zza(OnListParentsResponse onListParentsResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, onListParentsResponse.mVersionCode);
        zzb.zza(parcel, 2, onListParentsResponse.zzaqq, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbE(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdz(x0);
    }

    public OnListParentsResponse zzbE(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        DataHolder dataHolder = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    dataHolder = (DataHolder) zza.zza(parcel, zzat, DataHolder.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new OnListParentsResponse(i, dataHolder);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public OnListParentsResponse[] zzdz(int i) {
        return new OnListParentsResponse[i];
    }
}
