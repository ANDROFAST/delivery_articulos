package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Creator<DataHolder> {
    static void zza(DataHolder dataHolder, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, dataHolder.zzpM(), false);
        zzb.zzc(parcel, 1000, dataHolder.getVersionCode());
        zzb.zza(parcel, 2, dataHolder.zzpN(), i, false);
        zzb.zzc(parcel, 3, dataHolder.getStatusCode());
        zzb.zza(parcel, 4, dataHolder.zzpH(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzak(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzbK(x0);
    }

    public DataHolder zzak(Parcel parcel) {
        int i = 0;
        Bundle bundle = null;
        int zzau = zza.zzau(parcel);
        CursorWindow[] cursorWindowArr = null;
        String[] strArr = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    strArr = zza.zzB(parcel, zzat);
                    break;
                case 2:
                    cursorWindowArr = (CursorWindow[]) zza.zzb(parcel, zzat, CursorWindow.CREATOR);
                    break;
                case 3:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 4:
                    bundle = zza.zzr(parcel, zzat);
                    break;
                case 1000:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() != zzau) {
            throw new zza.zza("Overread allowed size end=" + zzau, parcel);
        }
        DataHolder dataHolder = new DataHolder(i2, strArr, cursorWindowArr, i, bundle);
        dataHolder.zzpL();
        return dataHolder;
    }

    public DataHolder[] zzbK(int i) {
        return new DataHolder[i];
    }
}
