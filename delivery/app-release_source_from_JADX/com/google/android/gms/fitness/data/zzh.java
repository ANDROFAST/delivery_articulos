package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh implements Creator<Device> {
    static void zza(Device device, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, device.getManufacturer(), false);
        zzb.zzc(parcel, 1000, device.getVersionCode());
        zzb.zza(parcel, 2, device.getModel(), false);
        zzb.zza(parcel, 3, device.getVersion(), false);
        zzb.zza(parcel, 4, device.zztP(), false);
        zzb.zzc(parcel, 5, device.getType());
        zzb.zzc(parcel, 6, device.zztN());
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcQ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzeP(x0);
    }

    public Device zzcQ(Parcel parcel) {
        int i = 0;
        String str = null;
        int zzau = zza.zzau(parcel);
        int i2 = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    str4 = zza.zzp(parcel, zzat);
                    break;
                case 2:
                    str3 = zza.zzp(parcel, zzat);
                    break;
                case 3:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 4:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 5:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 6:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 1000:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new Device(i3, str4, str3, str2, str, i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public Device[] zzeP(int i) {
        return new Device[i];
    }
}
