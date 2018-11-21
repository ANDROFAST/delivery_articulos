package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Creator<GetPermissionStatusRequest> {
    static void zza(GetPermissionStatusRequest getPermissionStatusRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, getPermissionStatusRequest.mVersionCode);
        zzb.zza(parcel, 2, getPermissionStatusRequest.zzCJ(), false);
        zzb.zza(parcel, 3, getPermissionStatusRequest.zzaWI, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfX(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zziZ(x0);
    }

    public GetPermissionStatusRequest zzfX(Parcel parcel) {
        String str = null;
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int i = 0;
        IBinder iBinder = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzcc(zzat)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    break;
                case 2:
                    iBinder = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, zzat);
                    break;
                case 3:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new GetPermissionStatusRequest(i, iBinder, str);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public GetPermissionStatusRequest[] zziZ(int i) {
        return new GetPermissionStatusRequest[i];
    }
}
