package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzab implements Creator<StopBleScanRequest> {
    static void zza(StopBleScanRequest stopBleScanRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, stopBleScanRequest.zzuE(), false);
        zzb.zzc(parcel, 1000, stopBleScanRequest.getVersionCode());
        zzb.zza(parcel, 2, stopBleScanRequest.zzui(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdB(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfC(x0);
    }

    public StopBleScanRequest zzdB(Parcel parcel) {
        IBinder iBinder = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        IBinder iBinder2 = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    iBinder2 = zza.zzq(parcel, zzat);
                    break;
                case 2:
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
            return new StopBleScanRequest(i, iBinder2, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public StopBleScanRequest[] zzfC(int i) {
        return new StopBleScanRequest[i];
    }
}
