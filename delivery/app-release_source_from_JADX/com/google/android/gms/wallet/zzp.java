package com.google.android.gms.wallet;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzp implements Creator<PaymentMethodTokenizationParameters> {
    static void zza(PaymentMethodTokenizationParameters paymentMethodTokenizationParameters, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, paymentMethodTokenizationParameters.getVersionCode());
        zzb.zzc(parcel, 2, paymentMethodTokenizationParameters.zzbkt);
        zzb.zza(parcel, 3, paymentMethodTokenizationParameters.zzbku, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzhq(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzkK(x0);
    }

    public PaymentMethodTokenizationParameters zzhq(Parcel parcel) {
        int i = 0;
        int zzau = zza.zzau(parcel);
        Bundle bundle = null;
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
                    bundle = zza.zzr(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new PaymentMethodTokenizationParameters(i2, i, bundle);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public PaymentMethodTokenizationParameters[] zzkK(int i) {
        return new PaymentMethodTokenizationParameters[i];
    }
}
