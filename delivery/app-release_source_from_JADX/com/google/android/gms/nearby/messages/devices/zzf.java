package com.google.android.gms.nearby.messages.devices;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzf implements Creator<NearbyDevice> {
    static void zza(NearbyDevice nearbyDevice, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, nearbyDevice.zzCI(), i, false);
        zzb.zzc(parcel, 1000, nearbyDevice.mVersionCode);
        zzb.zza(parcel, 2, nearbyDevice.getUrl(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfU(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zziW(x0);
    }

    public NearbyDevice zzfU(Parcel parcel) {
        String str = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        NearbyDeviceId nearbyDeviceId = null;
        while (parcel.dataPosition() < zzau) {
            int i2;
            String str2;
            NearbyDeviceId nearbyDeviceId2;
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i2 = i;
                    NearbyDeviceId nearbyDeviceId3 = (NearbyDeviceId) zza.zza(parcel, zzat, NearbyDeviceId.CREATOR);
                    str2 = str;
                    nearbyDeviceId2 = nearbyDeviceId3;
                    break;
                case 2:
                    str2 = zza.zzp(parcel, zzat);
                    nearbyDeviceId2 = nearbyDeviceId;
                    i2 = i;
                    break;
                case 1000:
                    String str3 = str;
                    nearbyDeviceId2 = nearbyDeviceId;
                    i2 = zza.zzg(parcel, zzat);
                    str2 = str3;
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    str2 = str;
                    nearbyDeviceId2 = nearbyDeviceId;
                    i2 = i;
                    break;
            }
            i = i2;
            nearbyDeviceId = nearbyDeviceId2;
            str = str2;
        }
        if (parcel.dataPosition() == zzau) {
            return new NearbyDevice(i, nearbyDeviceId, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public NearbyDevice[] zziW(int i) {
        return new NearbyDevice[i];
    }
}
