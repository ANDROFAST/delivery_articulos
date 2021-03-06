package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbg implements Creator<OnLoadRealtimeResponse> {
    static void zza(OnLoadRealtimeResponse onLoadRealtimeResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, onLoadRealtimeResponse.mVersionCode);
        zzb.zza(parcel, 2, onLoadRealtimeResponse.zzqh);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbG(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdB(x0);
    }

    public OnLoadRealtimeResponse zzbG(Parcel parcel) {
        boolean z = false;
        int zzau = zza.zzau(parcel);
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    z = zza.zzc(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new OnLoadRealtimeResponse(i, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public OnLoadRealtimeResponse[] zzdB(int i) {
        return new OnLoadRealtimeResponse[i];
    }
}
