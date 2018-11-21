package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Permission;
import java.util.List;

public class zzal implements Creator<GetPermissionsResponse> {
    static void zza(GetPermissionsResponse getPermissionsResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, getPermissionsResponse.mVersionCode);
        zzb.zzc(parcel, 2, getPermissionsResponse.zzapL, false);
        zzb.zzc(parcel, 3, getPermissionsResponse.zzyX);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbs(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdn(x0);
    }

    public GetPermissionsResponse zzbs(Parcel parcel) {
        int i = 0;
        int zzau = zza.zzau(parcel);
        List list = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    list = zza.zzc(parcel, zzat, Permission.CREATOR);
                    break;
                case 3:
                    i = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new GetPermissionsResponse(i2, list, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public GetPermissionsResponse[] zzdn(int i) {
        return new GetPermissionsResponse[i];
    }
}
