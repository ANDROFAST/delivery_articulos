package com.google.android.gms.games.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class ConnectionInfoCreator implements Creator<ConnectionInfo> {
    static void zza(ConnectionInfo connectionInfo, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, connectionInfo.zzvN(), false);
        zzb.zzc(parcel, 1000, connectionInfo.getVersionCode());
        zzb.zzc(parcel, 2, connectionInfo.zzvO());
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzed(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzgj(x0);
    }

    public ConnectionInfo zzed(Parcel parcel) {
        int i = 0;
        int zzau = zza.zzau(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 2:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 1000:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ConnectionInfo(i2, str, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public ConnectionInfo[] zzgj(int i) {
        return new ConnectionInfo[i];
    }
}
