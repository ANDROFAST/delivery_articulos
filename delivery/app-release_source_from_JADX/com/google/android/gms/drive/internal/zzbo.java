package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzbo implements Creator<RemoveEventListenerRequest> {
    static void zza(RemoveEventListenerRequest removeEventListenerRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, removeEventListenerRequest.mVersionCode);
        zzb.zza(parcel, 2, removeEventListenerRequest.zzamF, i, false);
        zzb.zzc(parcel, 3, removeEventListenerRequest.zzalo);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbN(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdI(x0);
    }

    public RemoveEventListenerRequest zzbN(Parcel parcel) {
        int i = 0;
        int zzau = zza.zzau(parcel);
        DriveId driveId = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            DriveId driveId2;
            int zzg;
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    int i3 = i;
                    driveId2 = driveId;
                    zzg = zza.zzg(parcel, zzat);
                    zzat = i3;
                    break;
                case 2:
                    zzg = i2;
                    DriveId driveId3 = (DriveId) zza.zza(parcel, zzat, DriveId.CREATOR);
                    zzat = i;
                    driveId2 = driveId3;
                    break;
                case 3:
                    zzat = zza.zzg(parcel, zzat);
                    driveId2 = driveId;
                    zzg = i2;
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    zzat = i;
                    driveId2 = driveId;
                    zzg = i2;
                    break;
            }
            i2 = zzg;
            driveId = driveId2;
            i = zzat;
        }
        if (parcel.dataPosition() == zzau) {
            return new RemoveEventListenerRequest(i2, driveId, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public RemoveEventListenerRequest[] zzdI(int i) {
        return new RemoveEventListenerRequest[i];
    }
}
