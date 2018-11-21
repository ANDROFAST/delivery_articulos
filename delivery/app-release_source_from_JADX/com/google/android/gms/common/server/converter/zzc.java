package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.server.converter.StringToIntConverter.Entry;

public class zzc implements Creator<Entry> {
    static void zza(Entry entry, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, entry.versionCode);
        zzb.zza(parcel, 2, entry.zzakS, false);
        zzb.zzc(parcel, 3, entry.zzakT);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaz(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzch(x0);
    }

    public Entry zzaz(Parcel parcel) {
        int i = 0;
        int zzau = zza.zzau(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    str = zza.zzp(parcel, zzat);
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
            return new Entry(i2, str, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public Entry[] zzch(int i) {
        return new Entry[i];
    }
}
