package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh implements Creator<FullTextSearchFilter> {
    static void zza(FullTextSearchFilter fullTextSearchFilter, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1000, fullTextSearchFilter.mVersionCode);
        zzb.zza(parcel, 1, fullTextSearchFilter.mValue, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcl(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzeg(x0);
    }

    public FullTextSearchFilter zzcl(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    str = zza.zzp(parcel, zzat);
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
            return new FullTextSearchFilter(i, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public FullTextSearchFilter[] zzeg(int i) {
        return new FullTextSearchFilter[i];
    }
}
