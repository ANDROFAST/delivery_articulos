package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveSpace;
import java.util.List;

public class zzd implements Creator<ChangesAvailableOptions> {
    static void zza(ChangesAvailableOptions changesAvailableOptions, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, changesAvailableOptions.mVersionCode);
        zzb.zzc(parcel, 2, changesAvailableOptions.zzanD);
        zzb.zza(parcel, 3, changesAvailableOptions.zzanE);
        zzb.zzc(parcel, 4, changesAvailableOptions.zzanF, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaS(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcH(x0);
    }

    public ChangesAvailableOptions zzaS(Parcel parcel) {
        boolean z = false;
        int zzau = zza.zzau(parcel);
        List list = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 3:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 4:
                    list = zza.zzc(parcel, zzat, DriveSpace.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ChangesAvailableOptions(i2, i, z, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public ChangesAvailableOptions[] zzcH(int i) {
        return new ChangesAvailableOptions[i];
    }
}
