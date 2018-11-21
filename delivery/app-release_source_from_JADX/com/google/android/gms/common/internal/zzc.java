package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Creator<AuthAccountRequest> {
    static void zza(AuthAccountRequest authAccountRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, authAccountRequest.mVersionCode);
        zzb.zza(parcel, 2, authAccountRequest.zzaiS, false);
        zzb.zza(parcel, 3, authAccountRequest.zzaem, i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzam(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzbQ(x0);
    }

    public AuthAccountRequest zzam(Parcel parcel) {
        Scope[] scopeArr = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        IBinder iBinder = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    iBinder = zza.zzq(parcel, zzat);
                    break;
                case 3:
                    scopeArr = (Scope[]) zza.zzb(parcel, zzat, Scope.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new AuthAccountRequest(i, iBinder, scopeArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public AuthAccountRequest[] zzbQ(int i) {
        return new AuthAccountRequest[i];
    }
}
