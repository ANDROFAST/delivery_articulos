package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.realtime.internal.event.ParcelableEvent;
import java.util.List;

public class zzp implements Creator<ParcelableChangeInfo> {
    static void zza(ParcelableChangeInfo parcelableChangeInfo, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, parcelableChangeInfo.mVersionCode);
        zzb.zza(parcel, 2, parcelableChangeInfo.zzacS);
        zzb.zzc(parcel, 3, parcelableChangeInfo.zzpw, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcv(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzer(x0);
    }

    public ParcelableChangeInfo zzcv(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        long j = 0;
        List list = null;
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
                    list = zza.zzc(parcel, zzat, ParcelableEvent.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ParcelableChangeInfo(i, j, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public ParcelableChangeInfo[] zzer(int i) {
        return new ParcelableChangeInfo[i];
    }
}
