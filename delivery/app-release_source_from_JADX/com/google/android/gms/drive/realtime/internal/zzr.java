package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzr implements Creator<ParcelableIndexReference> {
    static void zza(ParcelableIndexReference parcelableIndexReference, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, parcelableIndexReference.mVersionCode);
        zzb.zza(parcel, 2, parcelableIndexReference.zzasF, false);
        zzb.zzc(parcel, 3, parcelableIndexReference.mIndex);
        zzb.zza(parcel, 4, parcelableIndexReference.zzasG);
        zzb.zzc(parcel, 5, parcelableIndexReference.zzasH);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcx(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzet(x0);
    }

    public ParcelableIndexReference zzcx(Parcel parcel) {
        boolean z = false;
        int zzau = zza.zzau(parcel);
        String str = null;
        int i = -1;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 3:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 5:
                    i = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ParcelableIndexReference(i3, str, i2, z, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public ParcelableIndexReference[] zzet(int i) {
        return new ParcelableIndexReference[i];
    }
}
