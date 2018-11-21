package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import java.util.List;

public class zza implements Creator<Query> {
    static void zza(Query query, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1000, query.mVersionCode);
        zzb.zza(parcel, 1, query.zzarP, i, false);
        zzb.zza(parcel, 3, query.zzarQ, false);
        zzb.zza(parcel, 4, query.zzarR, i, false);
        zzb.zzb(parcel, 5, query.zzarS, false);
        zzb.zza(parcel, 6, query.zzarT);
        zzb.zzc(parcel, 7, query.zzanF, false);
        zzb.zza(parcel, 8, query.zzapH);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcf(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzea(x0);
    }

    public Query zzcf(Parcel parcel) {
        boolean z = false;
        List list = null;
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        boolean z2 = false;
        List list2 = null;
        SortOrder sortOrder = null;
        String str = null;
        LogicalFilter logicalFilter = null;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzcc(zzat)) {
                case 1:
                    logicalFilter = (LogicalFilter) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzat, LogicalFilter.CREATOR);
                    break;
                case 3:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                case 4:
                    sortOrder = (SortOrder) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzat, SortOrder.CREATOR);
                    break;
                case 5:
                    list2 = com.google.android.gms.common.internal.safeparcel.zza.zzD(parcel, zzat);
                    break;
                case 6:
                    z2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzat);
                    break;
                case 7:
                    list = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzat, DriveSpace.CREATOR);
                    break;
                case 8:
                    z = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzat);
                    break;
                case 1000:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new Query(i, logicalFilter, str, sortOrder, list2, z2, list, z);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public Query[] zzea(int i) {
        return new Query[i];
    }
}
