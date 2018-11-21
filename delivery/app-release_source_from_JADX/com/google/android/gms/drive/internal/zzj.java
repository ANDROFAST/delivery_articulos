package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzj implements Creator<ControlProgressRequest> {
    static void zza(ControlProgressRequest controlProgressRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, controlProgressRequest.mVersionCode);
        zzb.zzc(parcel, 2, controlProgressRequest.zzaoo);
        zzb.zzc(parcel, 3, controlProgressRequest.zzaop);
        zzb.zza(parcel, 4, controlProgressRequest.zzamF, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbe(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcU(x0);
    }

    public ControlProgressRequest zzbe(Parcel parcel) {
        int i = 0;
        int zzau = zza.zzau(parcel);
        DriveId driveId = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 3:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 4:
                    driveId = (DriveId) zza.zza(parcel, zzat, DriveId.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ControlProgressRequest(i3, i2, i, driveId);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public ControlProgressRequest[] zzcU(int i) {
        return new ControlProgressRequest[i];
    }
}
