package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzbp implements Creator<RemovePermissionRequest> {
    static void zza(RemovePermissionRequest removePermissionRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, removePermissionRequest.mVersionCode);
        zzb.zza(parcel, 2, removePermissionRequest.zzamF, i, false);
        zzb.zza(parcel, 3, removePermissionRequest.zzano, false);
        zzb.zza(parcel, 4, removePermissionRequest.zzaob);
        zzb.zza(parcel, 5, removePermissionRequest.zzanc, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbO(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdJ(x0);
    }

    public RemovePermissionRequest zzbO(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzau = zza.zzau(parcel);
        String str2 = null;
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
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 5:
                    str = zza.zzp(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new RemovePermissionRequest(i, driveId, str2, z, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public RemovePermissionRequest[] zzdJ(int i) {
        return new RemovePermissionRequest[i];
    }
}
