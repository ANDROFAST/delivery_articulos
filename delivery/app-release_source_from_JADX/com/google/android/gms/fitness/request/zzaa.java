package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataType;
import java.util.List;

public class zzaa implements Creator<StartBleScanRequest> {
    static void zza(StartBleScanRequest startBleScanRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, startBleScanRequest.getDataTypes(), false);
        zzb.zzc(parcel, 1000, startBleScanRequest.getVersionCode());
        zzb.zza(parcel, 2, startBleScanRequest.zzuE(), false);
        zzb.zzc(parcel, 3, startBleScanRequest.getTimeoutSecs());
        zzb.zza(parcel, 4, startBleScanRequest.zzui(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdA(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfB(x0);
    }

    public StartBleScanRequest zzdA(Parcel parcel) {
        int i = 0;
        IBinder iBinder = null;
        int zzau = zza.zzau(parcel);
        IBinder iBinder2 = null;
        List list = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    list = zza.zzc(parcel, zzat, DataType.CREATOR);
                    break;
                case 2:
                    iBinder2 = zza.zzq(parcel, zzat);
                    break;
                case 3:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 4:
                    iBinder = zza.zzq(parcel, zzat);
                    break;
                case 1000:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new StartBleScanRequest(i2, list, iBinder2, i, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public StartBleScanRequest[] zzfB(int i) {
        return new StartBleScanRequest[i];
    }
}
