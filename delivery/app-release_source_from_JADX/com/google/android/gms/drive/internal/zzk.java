package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveFile;

public class zzk implements Creator<CreateContentsRequest> {
    static void zza(CreateContentsRequest createContentsRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, createContentsRequest.mVersionCode);
        zzb.zzc(parcel, 2, createContentsRequest.zzamE);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbf(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcV(x0);
    }

    public CreateContentsRequest zzbf(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        int i2 = DriveFile.MODE_WRITE_ONLY;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new CreateContentsRequest(i, i2);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public CreateContentsRequest[] zzcV(int i) {
        return new CreateContentsRequest[i];
    }
}
