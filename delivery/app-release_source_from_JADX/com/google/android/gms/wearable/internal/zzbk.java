package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbk implements Creator<LargeAssetSyncRequestPayload> {
    static void zza(LargeAssetSyncRequestPayload largeAssetSyncRequestPayload, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, largeAssetSyncRequestPayload.versionCode);
        zzb.zza(parcel, 2, largeAssetSyncRequestPayload.zzbnK, false);
        zzb.zza(parcel, 3, largeAssetSyncRequestPayload.zzbom);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zziu(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzlW(x0);
    }

    public LargeAssetSyncRequestPayload zziu(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str = null;
        long j = 0;
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
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new LargeAssetSyncRequestPayload(i, str, j);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public LargeAssetSyncRequestPayload[] zzlW(int i) {
        return new LargeAssetSyncRequestPayload[i];
    }
}
