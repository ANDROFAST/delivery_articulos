package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzk implements Creator<ParentDriveIdSet> {
    static void zza(ParentDriveIdSet parentDriveIdSet, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, parentDriveIdSet.mVersionCode);
        zzb.zzc(parcel, 2, parentDriveIdSet.zzaqM, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcd(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdY(x0);
    }

    public ParentDriveIdSet zzcd(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    list = zza.zzc(parcel, zzat, PartialDriveId.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ParentDriveIdSet(i, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public ParentDriveIdSet[] zzdY(int i) {
        return new ParentDriveIdSet[i];
    }
}
