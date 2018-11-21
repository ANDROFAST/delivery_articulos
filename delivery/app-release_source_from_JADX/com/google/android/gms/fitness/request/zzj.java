package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzj implements Creator<DataTypeReadRequest> {
    static void zza(DataTypeReadRequest dataTypeReadRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, dataTypeReadRequest.getName(), false);
        zzb.zzc(parcel, 1000, dataTypeReadRequest.getVersionCode());
        zzb.zza(parcel, 3, dataTypeReadRequest.zzui(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdk(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfk(x0);
    }

    public DataTypeReadRequest zzdk(Parcel parcel) {
        IBinder iBinder = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
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
            return new DataTypeReadRequest(i, str, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public DataTypeReadRequest[] zzfk(int i) {
        return new DataTypeReadRequest[i];
    }
}
