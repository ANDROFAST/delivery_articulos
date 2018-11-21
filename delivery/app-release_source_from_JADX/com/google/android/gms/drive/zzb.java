package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzb implements Creator<Contents> {
    static void zza(Contents contents, Parcel parcel, int i) {
        int zzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, contents.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, contents.zzaid, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 3, contents.zzamD);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 4, contents.zzamE);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, contents.zzamF, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, contents.zzamG);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, contents.zzsL, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaI(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzct(x0);
    }

    public Contents zzaI(Parcel parcel) {
        String str = null;
        boolean z = false;
        int zzau = zza.zzau(parcel);
        DriveId driveId = null;
        int i = 0;
        int i2 = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    parcelFileDescriptor = (ParcelFileDescriptor) zza.zza(parcel, zzat, ParcelFileDescriptor.CREATOR);
                    break;
                case 3:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 4:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 5:
                    driveId = (DriveId) zza.zza(parcel, zzat, DriveId.CREATOR);
                    break;
                case 7:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 8:
                    str = zza.zzp(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new Contents(i3, parcelFileDescriptor, i2, i, driveId, z, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public Contents[] zzct(int i) {
        return new Contents[i];
    }
}
