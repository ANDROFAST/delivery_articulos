package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzg implements Creator<ReceiveContentRequest> {
    static void zza(ReceiveContentRequest receiveContentRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, receiveContentRequest.versionCode);
        zzb.zza(parcel, 2, receiveContentRequest.zzaXX, false);
        zzb.zza(parcel, 3, receiveContentRequest.zzCV(), false);
        zzb.zza(parcel, 4, receiveContentRequest.packageName, false);
        zzb.zza(parcel, 5, receiveContentRequest.zzCJ(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgk(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzjm(x0);
    }

    public ReceiveContentRequest zzgk(Parcel parcel) {
        IBinder iBinder = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    iBinder3 = zza.zzq(parcel, zzat);
                    break;
                case 3:
                    iBinder2 = zza.zzq(parcel, zzat);
                    break;
                case 4:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 5:
                    iBinder = zza.zzq(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ReceiveContentRequest(i, iBinder3, iBinder2, str, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public ReceiveContentRequest[] zzjm(int i) {
        return new ReceiveContentRequest[i];
    }
}
