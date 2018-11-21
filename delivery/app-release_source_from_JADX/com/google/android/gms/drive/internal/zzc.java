package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzc implements Creator<AuthorizeAccessRequest> {
    static void zza(AuthorizeAccessRequest authorizeAccessRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, authorizeAccessRequest.mVersionCode);
        zzb.zza(parcel, 2, authorizeAccessRequest.zzaoc);
        zzb.zza(parcel, 3, authorizeAccessRequest.zzamF, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaY(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcO(x0);
    }

    public AuthorizeAccessRequest zzaY(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        long j = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    j = zza.zzi(parcel, zzat);
                    break;
                case 3:
                    driveId = (DriveId) zza.zza(parcel, zzat, DriveId.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new AuthorizeAccessRequest(i, j, driveId);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public AuthorizeAccessRequest[] zzcO(int i) {
        return new AuthorizeAccessRequest[i];
    }
}
