package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh implements Creator<ValueChangedDetails> {
    static void zza(ValueChangedDetails valueChangedDetails, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, valueChangedDetails.mVersionCode);
        zzb.zzc(parcel, 2, valueChangedDetails.zzasI);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcF(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzeB(x0);
    }

    public ValueChangedDetails zzcF(Parcel parcel) {
        int i = 0;
        int zzau = zza.zzau(parcel);
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    i = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ValueChangedDetails(i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public ValueChangedDetails[] zzeB(int i) {
        return new ValueChangedDetails[i];
    }
}
