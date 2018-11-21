package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi implements Creator<CapabilityParcel> {
    static void zza(CapabilityParcel capabilityParcel, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, capabilityParcel.versionCode);
        zzb.zza(parcel, 2, capabilityParcel.zzHd);
        zzb.zza(parcel, 3, capabilityParcel.zzHe);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzk(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzI(x0);
    }

    public CapabilityParcel[] zzI(int i) {
        return new CapabilityParcel[i];
    }

    public CapabilityParcel zzk(Parcel parcel) {
        boolean z = false;
        int zzau = zza.zzau(parcel);
        boolean z2 = false;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    z2 = zza.zzc(parcel, zzat);
                    break;
                case 3:
                    z = zza.zzc(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new CapabilityParcel(i, z2, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }
}
