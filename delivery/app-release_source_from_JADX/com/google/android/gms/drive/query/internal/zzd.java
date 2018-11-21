package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd implements Creator<FilterHolder> {
    static void zza(FilterHolder filterHolder, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, filterHolder.zzase, i, false);
        zzb.zzc(parcel, 1000, filterHolder.mVersionCode);
        zzb.zza(parcel, 2, filterHolder.zzasf, i, false);
        zzb.zza(parcel, 3, filterHolder.zzasg, i, false);
        zzb.zza(parcel, 4, filterHolder.zzash, i, false);
        zzb.zza(parcel, 5, filterHolder.zzasi, i, false);
        zzb.zza(parcel, 6, filterHolder.zzasj, i, false);
        zzb.zza(parcel, 7, filterHolder.zzask, i, false);
        zzb.zza(parcel, 8, filterHolder.zzasl, i, false);
        zzb.zza(parcel, 9, filterHolder.zzasm, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzck(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzef(x0);
    }

    public FilterHolder zzck(Parcel parcel) {
        OwnedByMeFilter ownedByMeFilter = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        FullTextSearchFilter fullTextSearchFilter = null;
        HasFilter hasFilter = null;
        MatchAllFilter matchAllFilter = null;
        InFilter inFilter = null;
        NotFilter notFilter = null;
        LogicalFilter logicalFilter = null;
        FieldOnlyFilter fieldOnlyFilter = null;
        ComparisonFilter comparisonFilter = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    comparisonFilter = (ComparisonFilter) zza.zza(parcel, zzat, ComparisonFilter.CREATOR);
                    break;
                case 2:
                    fieldOnlyFilter = (FieldOnlyFilter) zza.zza(parcel, zzat, FieldOnlyFilter.CREATOR);
                    break;
                case 3:
                    logicalFilter = (LogicalFilter) zza.zza(parcel, zzat, LogicalFilter.CREATOR);
                    break;
                case 4:
                    notFilter = (NotFilter) zza.zza(parcel, zzat, NotFilter.CREATOR);
                    break;
                case 5:
                    inFilter = (InFilter) zza.zza(parcel, zzat, InFilter.CREATOR);
                    break;
                case 6:
                    matchAllFilter = (MatchAllFilter) zza.zza(parcel, zzat, MatchAllFilter.CREATOR);
                    break;
                case 7:
                    hasFilter = (HasFilter) zza.zza(parcel, zzat, HasFilter.CREATOR);
                    break;
                case 8:
                    fullTextSearchFilter = (FullTextSearchFilter) zza.zza(parcel, zzat, FullTextSearchFilter.CREATOR);
                    break;
                case 9:
                    ownedByMeFilter = (OwnedByMeFilter) zza.zza(parcel, zzat, OwnedByMeFilter.CREATOR);
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
            return new FilterHolder(i, comparisonFilter, fieldOnlyFilter, logicalFilter, notFilter, inFilter, matchAllFilter, hasFilter, fullTextSearchFilter, ownedByMeFilter);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public FilterHolder[] zzef(int i) {
        return new FilterHolder[i];
    }
}
