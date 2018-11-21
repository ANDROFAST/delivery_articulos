package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zzj implements Creator<InFilter> {
    static void zza(InFilter inFilter, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1000, inFilter.mVersionCode);
        zzb.zza(parcel, 1, inFilter.zzasb, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcn(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzei(x0);
    }

    public InFilter zzcn(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        MetadataBundle metadataBundle = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    metadataBundle = (MetadataBundle) zza.zza(parcel, zzat, MetadataBundle.CREATOR);
                    break;
                case 1000:
                    i = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new InFilter(i, metadataBundle);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public InFilter[] zzei(int i) {
        return new InFilter[i];
    }
}
