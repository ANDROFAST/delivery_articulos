package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzj implements Creator<StopProvidingContentRequest> {
    static void zza(StopProvidingContentRequest stopProvidingContentRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, stopProvidingContentRequest.versionCode);
        zzb.zza(parcel, 2, stopProvidingContentRequest.zzaYa);
        zzb.zza(parcel, 3, stopProvidingContentRequest.zzCJ(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgl(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzjn(x0);
    }

    public StopProvidingContentRequest zzgl(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        long j = 0;
        IBinder iBinder = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    j = zza.zzi(parcel, zzat);
                    break;
                case 3:
                    iBinder = zza.zzq(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new StopProvidingContentRequest(i, j, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public StopProvidingContentRequest[] zzjn(int i) {
        return new StopProvidingContentRequest[i];
    }
}
