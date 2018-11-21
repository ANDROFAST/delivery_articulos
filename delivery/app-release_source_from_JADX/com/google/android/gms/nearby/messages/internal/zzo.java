package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzo implements Creator<RegisterStatusCallbackRequest> {
    static void zza(RegisterStatusCallbackRequest registerStatusCallbackRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, registerStatusCallbackRequest.versionCode);
        zzb.zza(parcel, 2, registerStatusCallbackRequest.zzCJ(), false);
        zzb.zza(parcel, 3, registerStatusCallbackRequest.zzCL(), false);
        zzb.zza(parcel, 4, registerStatusCallbackRequest.zzaXK);
        zzb.zza(parcel, 5, registerStatusCallbackRequest.zzaWI, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgb(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzjd(x0);
    }

    public RegisterStatusCallbackRequest zzgb(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzau = zza.zzau(parcel);
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    iBinder2 = zza.zzq(parcel, zzat);
                    break;
                case 3:
                    iBinder = zza.zzq(parcel, zzat);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 5:
                    str = zza.zzp(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new RegisterStatusCallbackRequest(i, iBinder2, iBinder, z, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public RegisterStatusCallbackRequest[] zzjd(int i) {
        return new RegisterStatusCallbackRequest[i];
    }
}
