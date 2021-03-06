package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi implements Creator<PutDataRequest> {
    static void zza(PutDataRequest putDataRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, putDataRequest.mVersionCode);
        zzb.zza(parcel, 2, putDataRequest.getUri(), i, false);
        zzb.zza(parcel, 4, putDataRequest.zzGy(), false);
        zzb.zza(parcel, 5, putDataRequest.getData(), false);
        zzb.zza(parcel, 6, putDataRequest.zzGz());
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzhL(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzlj(x0);
    }

    public PutDataRequest zzhL(Parcel parcel) {
        byte[] bArr = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        long j = 0;
        Bundle bundle = null;
        Uri uri = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    uri = (Uri) zza.zza(parcel, zzat, Uri.CREATOR);
                    break;
                case 4:
                    bundle = zza.zzr(parcel, zzat);
                    break;
                case 5:
                    bArr = zza.zzs(parcel, zzat);
                    break;
                case 6:
                    j = zza.zzi(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new PutDataRequest(i, uri, bundle, bArr, j);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public PutDataRequest[] zzlj(int i) {
        return new PutDataRequest[i];
    }
}
