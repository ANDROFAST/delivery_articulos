package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh implements Creator<PlacePhotoMetadataResult> {
    static void zza(PlacePhotoMetadataResult placePhotoMetadataResult, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, placePhotoMetadataResult.getStatus(), i, false);
        zzb.zzc(parcel, 1000, placePhotoMetadataResult.mVersionCode);
        zzb.zza(parcel, 2, placePhotoMetadataResult.zzaML, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzeW(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzhF(x0);
    }

    public PlacePhotoMetadataResult zzeW(Parcel parcel) {
        DataHolder dataHolder = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        Status status = null;
        while (parcel.dataPosition() < zzau) {
            int i2;
            DataHolder dataHolder2;
            Status status2;
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i2 = i;
                    Status status3 = (Status) zza.zza(parcel, zzat, Status.CREATOR);
                    dataHolder2 = dataHolder;
                    status2 = status3;
                    break;
                case 2:
                    dataHolder2 = (DataHolder) zza.zza(parcel, zzat, DataHolder.CREATOR);
                    status2 = status;
                    i2 = i;
                    break;
                case 1000:
                    DataHolder dataHolder3 = dataHolder;
                    status2 = status;
                    i2 = zza.zzg(parcel, zzat);
                    dataHolder2 = dataHolder3;
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    dataHolder2 = dataHolder;
                    status2 = status;
                    i2 = i;
                    break;
            }
            i = i2;
            status = status2;
            dataHolder = dataHolder2;
        }
        if (parcel.dataPosition() == zzau) {
            return new PlacePhotoMetadataResult(i, status, dataHolder);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public PlacePhotoMetadataResult[] zzhF(int i) {
        return new PlacePhotoMetadataResult[i];
    }
}
