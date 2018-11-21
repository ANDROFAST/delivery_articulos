package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.Permission;

public class zzb implements Creator<AddPermissionRequest> {
    static void zza(AddPermissionRequest addPermissionRequest, Parcel parcel, int i) {
        int zzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, addPermissionRequest.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, addPermissionRequest.zzamF, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, addPermissionRequest.zzanY, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, addPermissionRequest.zzanZ);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, addPermissionRequest.zzaoa, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, addPermissionRequest.zzaob);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, addPermissionRequest.zzanc, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaX(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcN(x0);
    }

    public AddPermissionRequest zzaX(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzau = zza.zzau(parcel);
        String str2 = null;
        boolean z2 = false;
        Permission permission = null;
        DriveId driveId = null;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    driveId = (DriveId) zza.zza(parcel, zzat, DriveId.CREATOR);
                    break;
                case 3:
                    permission = (Permission) zza.zza(parcel, zzat, Permission.CREATOR);
                    break;
                case 4:
                    z2 = zza.zzc(parcel, zzat);
                    break;
                case 5:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 6:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 7:
                    str = zza.zzp(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new AddPermissionRequest(i, driveId, permission, z2, str2, z, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public AddPermissionRequest[] zzcN(int i) {
        return new AddPermissionRequest[i];
    }
}
