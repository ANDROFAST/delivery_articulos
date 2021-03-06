package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataSource;

public class zzg implements Creator<DataSourceQueryParams> {
    static void zza(DataSourceQueryParams dataSourceQueryParams, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, dataSourceQueryParams.zzatP, i, false);
        zzb.zzc(parcel, 1000, dataSourceQueryParams.mVersionCode);
        zzb.zza(parcel, 2, dataSourceQueryParams.zzTC);
        zzb.zza(parcel, 3, dataSourceQueryParams.zzauf);
        zzb.zza(parcel, 4, dataSourceQueryParams.zzayz);
        zzb.zzc(parcel, 5, dataSourceQueryParams.zzayu);
        zzb.zzc(parcel, 6, dataSourceQueryParams.zzayA);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdh(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfh(x0);
    }

    public DataSourceQueryParams zzdh(Parcel parcel) {
        long j = 0;
        int i = 0;
        int zzau = zza.zzau(parcel);
        DataSource dataSource = null;
        int i2 = 0;
        long j2 = 0;
        long j3 = 0;
        int i3 = 0;
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
                    j2 = zza.zzi(parcel, zzat);
                    break;
                case 4:
                    j = zza.zzi(parcel, zzat);
                    break;
                case 5:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 6:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 1000:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new DataSourceQueryParams(i3, dataSource, j3, j2, j, i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public DataSourceQueryParams[] zzfh(int i) {
        return new DataSourceQueryParams[i];
    }
}
