package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Creator<GetBuyFlowInitializationTokenResponse> {
    static void zza(GetBuyFlowInitializationTokenResponse getBuyFlowInitializationTokenResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, getBuyFlowInitializationTokenResponse.getVersionCode());
        zzb.zza(parcel, 2, getBuyFlowInitializationTokenResponse.zzbkI, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzht(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzkN(x0);
    }

    public GetBuyFlowInitializationTokenResponse zzht(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        byte[] bArr = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    bArr = zza.zzs(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new GetBuyFlowInitializationTokenResponse(i, bArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public GetBuyFlowInitializationTokenResponse[] zzkN(int i) {
        return new GetBuyFlowInitializationTokenResponse[i];
    }
}
