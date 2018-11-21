package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzm implements Creator<NotifyTransactionStatusRequest> {
    static void zza(NotifyTransactionStatusRequest notifyTransactionStatusRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, notifyTransactionStatusRequest.mVersionCode);
        zzb.zza(parcel, 2, notifyTransactionStatusRequest.zzbjg, false);
        zzb.zzc(parcel, 3, notifyTransactionStatusRequest.status);
        zzb.zza(parcel, 4, notifyTransactionStatusRequest.zzbkq, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzhn(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzkH(x0);
    }

    public NotifyTransactionStatusRequest zzhn(Parcel parcel) {
        String str = null;
        int i = 0;
        int zzau = zza.zzau(parcel);
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 3:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 4:
                    str = zza.zzp(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new NotifyTransactionStatusRequest(i2, str2, i, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public NotifyTransactionStatusRequest[] zzkH(int i) {
        return new NotifyTransactionStatusRequest[i];
    }
}
