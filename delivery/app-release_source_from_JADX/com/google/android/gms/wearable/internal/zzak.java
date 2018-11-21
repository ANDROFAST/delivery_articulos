package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzak implements Creator<GetChannelInputStreamResponse> {
    static void zza(GetChannelInputStreamResponse getChannelInputStreamResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, getChannelInputStreamResponse.versionCode);
        zzb.zzc(parcel, 2, getChannelInputStreamResponse.statusCode);
        zzb.zza(parcel, 3, getChannelInputStreamResponse.zzbny, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzic(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzlD(x0);
    }

    public GetChannelInputStreamResponse zzic(Parcel parcel) {
        int i = 0;
        int zzau = zza.zzau(parcel);
        ParcelFileDescriptor parcelFileDescriptor = null;
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
                    parcelFileDescriptor = (ParcelFileDescriptor) zza.zza(parcel, zzat, ParcelFileDescriptor.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new GetChannelInputStreamResponse(i2, i, parcelFileDescriptor);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public GetChannelInputStreamResponse[] zzlD(int i) {
        return new GetChannelInputStreamResponse[i];
    }
}
