package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzf implements Creator<DrivePreferences> {
    static void zza(DrivePreferences drivePreferences, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, drivePreferences.mVersionCode);
        zzb.zza(parcel, 2, drivePreferences.zzamV);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaL(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcw(x0);
    }

    public DrivePreferences zzaL(Parcel parcel) {
        boolean z = false;
        int zzau = zza.zzau(parcel);
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    z = zza.zzc(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new DrivePreferences(i, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public DrivePreferences[] zzcw(int i) {
        return new DrivePreferences[i];
    }
}
