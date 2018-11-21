package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzn implements Creator<RawDataPoint> {
    static void zza(RawDataPoint rawDataPoint, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, rawDataPoint.zzaue);
        zzb.zzc(parcel, 1000, rawDataPoint.mVersionCode);
        zzb.zza(parcel, 2, rawDataPoint.zzauf);
        zzb.zza(parcel, 3, rawDataPoint.zzaug, i, false);
        zzb.zzc(parcel, 4, rawDataPoint.zzauX);
        zzb.zzc(parcel, 5, rawDataPoint.zzauY);
        zzb.zza(parcel, 6, rawDataPoint.zzaui);
        zzb.zza(parcel, 7, rawDataPoint.zzauj);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcU(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzeT(x0);
    }

    public RawDataPoint zzcU(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        long j = 0;
        long j2 = 0;
        Value[] valueArr = null;
        int i2 = 0;
        int i3 = 0;
        long j3 = 0;
        long j4 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    j = zza.zzi(parcel, zzat);
                    break;
                case 2:
                    j2 = zza.zzi(parcel, zzat);
                    break;
                case 3:
                    valueArr = (Value[]) zza.zzb(parcel, zzat, Value.CREATOR);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 5:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case 6:
                    j3 = zza.zzi(parcel, zzat);
                    break;
                case 7:
                    j4 = zza.zzi(parcel, zzat);
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
            return new RawDataPoint(i, j, j2, valueArr, i2, i3, j3, j4);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public RawDataPoint[] zzeT(int i) {
        return new RawDataPoint[i];
    }
}
