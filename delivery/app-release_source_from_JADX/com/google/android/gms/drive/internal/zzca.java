package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzca implements Creator<UpdatePermissionRequest> {
    static void zza(UpdatePermissionRequest updatePermissionRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, updatePermissionRequest.mVersionCode);
        zzb.zza(parcel, 2, updatePermissionRequest.zzamF, i, false);
        zzb.zza(parcel, 3, updatePermissionRequest.zzano, false);
        zzb.zzc(parcel, 4, updatePermissionRequest.zzaqz);
        zzb.zza(parcel, 5, updatePermissionRequest.zzaob);
        zzb.zza(parcel, 6, updatePermissionRequest.zzanc, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbY(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdT(x0);
    }

    public UpdatePermissionRequest zzbY(Parcel parcel) {
        String str = null;
        boolean z = false;
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str2 = null;
        DriveId driveId = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    driveId = (DriveId) zza.zza(parcel, zzat, DriveId.CREATOR);
                    break;
                case 3:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 4:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 5:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 6:
                    str = zza.zzp(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new UpdatePermissionRequest(i2, driveId, str2, i, z, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public UpdatePermissionRequest[] zzdT(int i) {
        return new UpdatePermissionRequest[i];
    }
}
