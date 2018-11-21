package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.realtime.internal.ParcelableChangeInfo;
import java.util.List;

public class zzd implements Creator<ParcelableEventList> {
    static void zza(ParcelableEventList parcelableEventList, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, parcelableEventList.mVersionCode);
        zzb.zzc(parcel, 2, parcelableEventList.zzpw, false);
        zzb.zza(parcel, 3, parcelableEventList.zzasZ, i, false);
        zzb.zza(parcel, 4, parcelableEventList.zzata);
        zzb.zzb(parcel, 5, parcelableEventList.zzatb, false);
        zzb.zza(parcel, 6, parcelableEventList.zzatc, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcB(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzex(x0);
    }

    public ParcelableEventList zzcB(Parcel parcel) {
        boolean z = false;
        ParcelableChangeInfo parcelableChangeInfo = null;
        int zzau = zza.zzau(parcel);
        List list = null;
        DataHolder dataHolder = null;
        List list2 = null;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    list2 = zza.zzc(parcel, zzat, ParcelableEvent.CREATOR);
                    break;
                case 3:
                    dataHolder = (DataHolder) zza.zza(parcel, zzat, DataHolder.CREATOR);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 5:
                    list = zza.zzD(parcel, zzat);
                    break;
                case 6:
                    parcelableChangeInfo = (ParcelableChangeInfo) zza.zza(parcel, zzat, ParcelableChangeInfo.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ParcelableEventList(i, list2, dataHolder, z, list, parcelableChangeInfo);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public ParcelableEventList[] zzex(int i) {
        return new ParcelableEventList[i];
    }
}
