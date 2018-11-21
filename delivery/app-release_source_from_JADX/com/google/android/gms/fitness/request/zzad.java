package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzad implements Creator<UnclaimBleDeviceRequest> {
    static void zza(UnclaimBleDeviceRequest unclaimBleDeviceRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1000, unclaimBleDeviceRequest.getVersionCode());
        zzb.zza(parcel, 2, unclaimBleDeviceRequest.getDeviceAddress(), false);
        zzb.zza(parcel, 3, unclaimBleDeviceRequest.zzui(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdD(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfE(x0);
    }

    public UnclaimBleDeviceRequest zzdD(Parcel parcel) {
        IBinder iBinder = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 2:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 3:
                    iBinder = zza.zzq(parcel, zzat);
                    break;
                case 1000:
                    i = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new UnclaimBleDeviceRequest(i, str, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public UnclaimBleDeviceRequest[] zzfE(int i) {
        return new UnclaimBleDeviceRequest[i];
    }
}
