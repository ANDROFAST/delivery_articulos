package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbx implements Creator<SendMessageResponse> {
    static void zza(SendMessageResponse sendMessageResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, sendMessageResponse.versionCode);
        zzb.zzc(parcel, 2, sendMessageResponse.statusCode);
        zzb.zzc(parcel, 3, sendMessageResponse.zzaKw);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zziD(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzmi(x0);
    }

    public SendMessageResponse zziD(Parcel parcel) {
        int i = 0;
        int zzau = zza.zzau(parcel);
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 3:
                    i = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new SendMessageResponse(i3, i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public SendMessageResponse[] zzmi(int i) {
        return new SendMessageResponse[i];
    }
}
