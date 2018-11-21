package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh implements Creator<InstrumentInfo> {
    static void zza(InstrumentInfo instrumentInfo, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, instrumentInfo.getVersionCode());
        zzb.zza(parcel, 2, instrumentInfo.getInstrumentType(), false);
        zzb.zza(parcel, 3, instrumentInfo.getInstrumentDetails(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzhi(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzkC(x0);
    }

    public InstrumentInfo zzhi(Parcel parcel) {
        String str = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 3:
                    str = zza.zzp(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new InstrumentInfo(i, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public InstrumentInfo[] zzkC(int i) {
        return new InstrumentInfo[i];
    }
}
