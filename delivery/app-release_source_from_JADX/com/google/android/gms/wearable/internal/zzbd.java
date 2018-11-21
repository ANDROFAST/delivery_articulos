package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbd implements Creator<LargeAssetEnqueueRequest> {
    static void zza(LargeAssetEnqueueRequest largeAssetEnqueueRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, largeAssetEnqueueRequest.mVersionCode);
        zzb.zza(parcel, 2, largeAssetEnqueueRequest.zzbnJ, false);
        zzb.zza(parcel, 3, largeAssetEnqueueRequest.zzbnK, false);
        zzb.zza(parcel, 4, largeAssetEnqueueRequest.zzaXR, i, false);
        zzb.zza(parcel, 5, largeAssetEnqueueRequest.zzbnL, false);
        zzb.zza(parcel, 6, largeAssetEnqueueRequest.zzbnM);
        zzb.zza(parcel, 7, largeAssetEnqueueRequest.zzbnN);
        zzb.zza(parcel, 8, largeAssetEnqueueRequest.zzbnO);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzio(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzlP(x0);
    }

    public LargeAssetEnqueueRequest zzio(Parcel parcel) {
        String str = null;
        boolean z = false;
        int zzau = zza.zzau(parcel);
        boolean z2 = false;
        boolean z3 = false;
        Uri uri = null;
        String str2 = null;
        String str3 = null;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    str3 = zza.zzp(parcel, zzat);
                    break;
                case 3:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 4:
                    uri = (Uri) zza.zza(parcel, zzat, Uri.CREATOR);
                    break;
                case 5:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 6:
                    z3 = zza.zzc(parcel, zzat);
                    break;
                case 7:
                    z2 = zza.zzc(parcel, zzat);
                    break;
                case 8:
                    z = zza.zzc(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new LargeAssetEnqueueRequest(i, str3, str2, uri, str, z3, z2, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public LargeAssetEnqueueRequest[] zzlP(int i) {
        return new LargeAssetEnqueueRequest[i];
    }
}
