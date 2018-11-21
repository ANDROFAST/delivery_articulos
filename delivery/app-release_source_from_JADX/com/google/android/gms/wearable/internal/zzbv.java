package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbv implements Creator<RemoveListenerRequest> {
    static void zza(RemoveListenerRequest removeListenerRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, removeListenerRequest.mVersionCode);
        zzb.zza(parcel, 2, removeListenerRequest.zzGB(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zziB(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzmg(x0);
    }

    public RemoveListenerRequest zziB(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        IBinder iBinder = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    iBinder = zza.zzq(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new RemoveListenerRequest(i, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public RemoveListenerRequest[] zzmg(int i) {
        return new RemoveListenerRequest[i];
    }
}
