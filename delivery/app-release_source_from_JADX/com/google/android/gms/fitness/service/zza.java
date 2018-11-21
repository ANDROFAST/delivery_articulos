package com.google.android.gms.fitness.service;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataSource;

public class zza implements Creator<FitnessSensorServiceRequest> {
    static void zza(FitnessSensorServiceRequest fitnessSensorServiceRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, fitnessSensorServiceRequest.getDataSource(), i, false);
        zzb.zzc(parcel, 1000, fitnessSensorServiceRequest.getVersionCode());
        zzb.zza(parcel, 2, fitnessSensorServiceRequest.zzuz(), false);
        zzb.zza(parcel, 3, fitnessSensorServiceRequest.zztU());
        zzb.zza(parcel, 4, fitnessSensorServiceRequest.zzuQ());
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdR(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfS(x0);
    }

    public FitnessSensorServiceRequest zzdR(Parcel parcel) {
        long j = 0;
        IBinder iBinder = null;
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int i = 0;
        long j2 = 0;
        DataSource dataSource = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzcc(zzat)) {
                case 1:
                    dataSource = (DataSource) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzat, DataSource.CREATOR);
                    break;
                case 2:
                    iBinder = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, zzat);
                    break;
                case 3:
                    j2 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, zzat);
                    break;
                case 4:
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, zzat);
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
            return new FitnessSensorServiceRequest(i, dataSource, iBinder, j2, j);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public FitnessSensorServiceRequest[] zzfS(int i) {
        return new FitnessSensorServiceRequest[i];
    }
}
