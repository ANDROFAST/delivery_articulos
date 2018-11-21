package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzf implements Creator<InitializeBuyFlowRequest> {
    static void zza(InitializeBuyFlowRequest initializeBuyFlowRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, initializeBuyFlowRequest.getVersionCode());
        zzb.zza(parcel, 2, initializeBuyFlowRequest.zzbkM, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzhw(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzkQ(x0);
    }

    public InitializeBuyFlowRequest zzhw(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        byte[][] bArr = (byte[][]) null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    bArr = zza.zzt(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new InitializeBuyFlowRequest(i, bArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public InitializeBuyFlowRequest[] zzkQ(int i) {
        return new InitializeBuyFlowRequest[i];
    }
}
