package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzm implements Creator<PartialDriveId> {
    static void zza(PartialDriveId partialDriveId, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, partialDriveId.mVersionCode);
        zzb.zza(parcel, 2, partialDriveId.zzamR, false);
        zzb.zza(parcel, 3, partialDriveId.zzamS);
        zzb.zzc(parcel, 4, partialDriveId.zzamT);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzce(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdZ(x0);
    }

    public PartialDriveId zzce(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str = null;
        long j = 0;
        int i2 = -1;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 3:
                    j = zza.zzi(parcel, zzat);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new PartialDriveId(i, str, j, i2);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public PartialDriveId[] zzdZ(int i) {
        return new PartialDriveId[i];
    }
}
