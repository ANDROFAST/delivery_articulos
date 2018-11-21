package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzby implements Creator<UntrashResourceRequest> {
    static void zza(UntrashResourceRequest untrashResourceRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, untrashResourceRequest.mVersionCode);
        zzb.zza(parcel, 2, untrashResourceRequest.zzaoh, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbW(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdR(x0);
    }

    public UntrashResourceRequest zzbW(Parcel parcel) {
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
            return new UntrashResourceRequest(i, driveId);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public UntrashResourceRequest[] zzdR(int i) {
        return new UntrashResourceRequest[i];
    }
}
