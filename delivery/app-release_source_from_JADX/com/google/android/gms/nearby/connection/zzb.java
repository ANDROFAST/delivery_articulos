package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.List;

public class zzb implements Creator<AppMetadata> {
    static void zza(AppMetadata appMetadata, Parcel parcel, int i) {
        int zzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, appMetadata.getAppIdentifiers(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, appMetadata.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfQ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zziJ(x0);
    }

    public AppMetadata zzfQ(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    list = zza.zzc(parcel, zzat, AppIdentifier.CREATOR);
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
            return new AppMetadata(i, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public AppMetadata[] zziJ(int i) {
        return new AppMetadata[i];
    }
}
