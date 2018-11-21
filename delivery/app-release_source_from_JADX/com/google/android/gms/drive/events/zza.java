package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zza implements Creator<ChangeEvent> {
    static void zza(ChangeEvent changeEvent, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, changeEvent.mVersionCode);
        zzb.zza(parcel, 2, changeEvent.zzamF, i, false);
        zzb.zzc(parcel, 3, changeEvent.zzanB);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaQ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcF(x0);
    }

    public ChangeEvent zzaQ(Parcel parcel) {
        int i = 0;
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        DriveId driveId = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            DriveId driveId2;
            int zzg;
            int zzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzcc(zzat)) {
                case 1:
                    int i3 = i;
                    driveId2 = driveId;
                    zzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    zzat = i3;
                    break;
                case 2:
                    zzg = i2;
                    DriveId driveId3 = (DriveId) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzat, DriveId.CREATOR);
                    zzat = i;
                    driveId2 = driveId3;
                    break;
                case 3:
                    zzat = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    driveId2 = driveId;
                    zzg = i2;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzat);
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
            return new ChangeEvent(i2, driveId, i);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public ChangeEvent[] zzcF(int i) {
        return new ChangeEvent[i];
    }
}
