package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zzbf implements Creator<OnMetadataResponse> {
    static void zza(OnMetadataResponse onMetadataResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, onMetadataResponse.mVersionCode);
        zzb.zza(parcel, 2, onMetadataResponse.zzaot, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbF(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdA(x0);
    }

    public OnMetadataResponse zzbF(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        MetadataBundle metadataBundle = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    metadataBundle = (MetadataBundle) zza.zza(parcel, zzat, MetadataBundle.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new OnMetadataResponse(i, metadataBundle);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public OnMetadataResponse[] zzdA(int i) {
        return new OnMetadataResponse[i];
    }
}
