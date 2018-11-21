package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzbu implements Creator<StreamContentsRequest> {
    static void zza(StreamContentsRequest streamContentsRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, streamContentsRequest.mVersionCode);
        zzb.zza(parcel, 2, streamContentsRequest.zzaoh, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbS(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdN(x0);
    }

    public StreamContentsRequest zzbS(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    driveId = (DriveId) zza.zza(parcel, zzat, DriveId.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new StreamContentsRequest(i, driveId);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public StreamContentsRequest[] zzdN(int i) {
        return new StreamContentsRequest[i];
    }
}
