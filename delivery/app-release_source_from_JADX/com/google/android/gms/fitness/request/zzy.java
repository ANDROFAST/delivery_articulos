package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzy implements Creator<SessionStopRequest> {
    static void zza(SessionStopRequest sessionStopRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, sessionStopRequest.getName(), false);
        zzb.zzc(parcel, 1000, sessionStopRequest.getVersionCode());
        zzb.zza(parcel, 2, sessionStopRequest.getIdentifier(), false);
        zzb.zza(parcel, 3, sessionStopRequest.zzui(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdy(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfz(x0);
    }

    public SessionStopRequest zzdy(Parcel parcel) {
        IBinder iBinder = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    str2 = zza.zzp(parcel, zzat);
                    break;
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
            return new SessionStopRequest(i, str2, str, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public SessionStopRequest[] zzfz(int i) {
        return new SessionStopRequest[i];
    }
}
