package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh implements Creator<StopScanRequest> {
    static void zza(StopScanRequest stopScanRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, stopScanRequest.zzui(), false);
        zzb.zzc(parcel, 1000, stopScanRequest.versionCode);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfO(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zziH(x0);
    }

    public StopScanRequest zzfO(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        IBinder iBinder = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
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
            return new StopScanRequest(i, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public StopScanRequest[] zziH(int i) {
        return new StopScanRequest[i];
    }
}
