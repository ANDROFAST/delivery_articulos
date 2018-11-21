package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbe implements Creator<LargeAssetQuery> {
    static void zza(LargeAssetQuery largeAssetQuery, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, largeAssetQuery.mVersionCode);
        zzb.zzc(parcel, 2, largeAssetQuery.zzbnP);
        zzb.zza(parcel, 3, largeAssetQuery.zzaXR, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzip(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzlQ(x0);
    }

    public LargeAssetQuery zzip(Parcel parcel) {
        int i = 0;
        int zzau = zza.zzau(parcel);
        Uri uri = null;
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
                    uri = (Uri) zza.zza(parcel, zzat, Uri.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new LargeAssetQuery(i2, i, uri);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public LargeAssetQuery[] zzlQ(int i) {
        return new LargeAssetQuery[i];
    }
}
