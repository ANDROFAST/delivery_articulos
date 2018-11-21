package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataSource;

public class zzd implements Creator<DataSourceStatsResult> {
    static void zza(DataSourceStatsResult dataSourceStatsResult, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, dataSourceStatsResult.zzatP, i, false);
        zzb.zzc(parcel, 1000, dataSourceStatsResult.mVersionCode);
        zzb.zza(parcel, 2, dataSourceStatsResult.zzTC);
        zzb.zza(parcel, 3, dataSourceStatsResult.zzazo);
        zzb.zza(parcel, 4, dataSourceStatsResult.zzazp);
        zzb.zza(parcel, 5, dataSourceStatsResult.zzazq);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdI(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfJ(x0);
    }

    public DataSourceStatsResult zzdI(Parcel parcel) {
        boolean z = false;
        long j = 0;
        int zzau = zza.zzau(parcel);
        DataSource dataSource = null;
        long j2 = 0;
        long j3 = 0;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    dataSource = (DataSource) zza.zza(parcel, zzat, DataSource.CREATOR);
                    break;
                case 2:
                    j3 = zza.zzi(parcel, zzat);
                    break;
                case 3:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 4:
                    j2 = zza.zzi(parcel, zzat);
                    break;
                case 5:
                    j = zza.zzi(parcel, zzat);
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
            return new DataSourceStatsResult(i, dataSource, j3, z, j2, j);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public DataSourceStatsResult[] zzfJ(int i) {
        return new DataSourceStatsResult[i];
    }
}
