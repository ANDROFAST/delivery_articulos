package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzbh implements Creator<OnResourceIdSetResponse> {
    static void zza(OnResourceIdSetResponse onResourceIdSetResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, onResourceIdSetResponse.getVersionCode());
        zzb.zzb(parcel, 2, onResourceIdSetResponse.zzsD(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbH(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdC(x0);
    }

    public OnResourceIdSetResponse zzbH(Parcel parcel) {
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
            return new OnResourceIdSetResponse(i, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public OnResourceIdSetResponse[] zzdC(int i) {
        return new OnResourceIdSetResponse[i];
    }
}
