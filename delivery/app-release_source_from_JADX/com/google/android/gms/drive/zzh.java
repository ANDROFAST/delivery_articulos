package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh implements Creator<DriveSpace> {
    static void zza(DriveSpace driveSpace, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, driveSpace.mVersionCode);
        zzb.zza(parcel, 2, driveSpace.getName(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaM(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcx(x0);
    }

    public DriveSpace zzaM(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    str = zza.zzp(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new DriveSpace(i, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public DriveSpace[] zzcx(int i) {
        return new DriveSpace[i];
    }
}
