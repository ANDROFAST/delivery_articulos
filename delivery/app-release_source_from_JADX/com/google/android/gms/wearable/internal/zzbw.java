package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbw implements Creator<RemoveLocalCapabilityResponse> {
    static void zza(RemoveLocalCapabilityResponse removeLocalCapabilityResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, removeLocalCapabilityResponse.versionCode);
        zzb.zzc(parcel, 2, removeLocalCapabilityResponse.statusCode);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zziC(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzmh(x0);
    }

    public RemoveLocalCapabilityResponse zziC(Parcel parcel) {
        int i = 0;
        int zzau = zza.zzau(parcel);
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
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new RemoveLocalCapabilityResponse(i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public RemoveLocalCapabilityResponse[] zzmh(int i) {
        return new RemoveLocalCapabilityResponse[i];
    }
}
