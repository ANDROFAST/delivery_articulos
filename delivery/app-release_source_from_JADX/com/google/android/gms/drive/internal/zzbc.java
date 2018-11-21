package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbc implements Creator<OnFetchThumbnailResponse> {
    static void zza(OnFetchThumbnailResponse onFetchThumbnailResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, onFetchThumbnailResponse.mVersionCode);
        zzb.zza(parcel, 2, onFetchThumbnailResponse.zzaqo, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbC(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdx(x0);
    }

    public OnFetchThumbnailResponse zzbC(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    parcelFileDescriptor = (ParcelFileDescriptor) zza.zza(parcel, zzat, ParcelFileDescriptor.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new OnFetchThumbnailResponse(i, parcelFileDescriptor);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public OnFetchThumbnailResponse[] zzdx(int i) {
        return new OnFetchThumbnailResponse[i];
    }
}
