package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzaz implements Creator<OnDriveIdResponse> {
    static void zza(OnDriveIdResponse onDriveIdResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, onDriveIdResponse.mVersionCode);
        zzb.zza(parcel, 2, onDriveIdResponse.zzaoh, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbz(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdu(x0);
    }

    public OnDriveIdResponse zzbz(Parcel parcel) {
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
            return new OnDriveIdResponse(i, driveId);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public OnDriveIdResponse[] zzdu(int i) {
        return new OnDriveIdResponse[i];
    }
}
