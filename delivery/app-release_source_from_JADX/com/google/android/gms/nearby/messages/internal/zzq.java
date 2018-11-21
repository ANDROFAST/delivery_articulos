package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzq implements Creator<UnpublishRequest> {
    static void zza(UnpublishRequest unpublishRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, unpublishRequest.mVersionCode);
        zzb.zza(parcel, 2, unpublishRequest.zzaXF, i, false);
        zzb.zza(parcel, 3, unpublishRequest.zzCJ(), false);
        zzb.zza(parcel, 4, unpublishRequest.zzaWI, false);
        zzb.zza(parcel, 5, unpublishRequest.zzaXH, false);
        zzb.zza(parcel, 6, unpublishRequest.zzaWK);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgd(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzjf(x0);
    }

    public UnpublishRequest zzgd(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzau = zza.zzau(parcel);
        String str2 = null;
        IBinder iBinder = null;
        MessageWrapper messageWrapper = null;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    messageWrapper = (MessageWrapper) zza.zza(parcel, zzat, MessageWrapper.CREATOR);
                    break;
                case 3:
                    iBinder = zza.zzq(parcel, zzat);
                    break;
                case 4:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 5:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 6:
                    z = zza.zzc(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new UnpublishRequest(i, messageWrapper, iBinder, str2, str, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public UnpublishRequest[] zzjf(int i) {
        return new UnpublishRequest[i];
    }
}
