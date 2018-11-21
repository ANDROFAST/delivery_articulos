package com.google.android.gms.nearby.messages.devices;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh implements Creator<NearbyDeviceId> {
    static void zza(NearbyDeviceId nearbyDeviceId, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, nearbyDeviceId.getType());
        zzb.zzc(parcel, 1000, nearbyDeviceId.mVersionCode);
        zzb.zza(parcel, 2, nearbyDeviceId.zzaXb, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfW(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zziY(x0);
    }

    public NearbyDeviceId zzfW(Parcel parcel) {
        int i = 0;
        int zzau = zza.zzau(parcel);
        byte[] bArr = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    bArr = zza.zzs(parcel, zzat);
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
            return new NearbyDeviceId(i2, i, bArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public NearbyDeviceId[] zziY(int i) {
        return new NearbyDeviceId[i];
    }
}
