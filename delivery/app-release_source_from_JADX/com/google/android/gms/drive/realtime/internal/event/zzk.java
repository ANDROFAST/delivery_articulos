package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzk implements Creator<ValuesSetDetails> {
    static void zza(ValuesSetDetails valuesSetDetails, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, valuesSetDetails.mVersionCode);
        zzb.zzc(parcel, 2, valuesSetDetails.mIndex);
        zzb.zzc(parcel, 3, valuesSetDetails.zzasJ);
        zzb.zzc(parcel, 4, valuesSetDetails.zzasK);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcI(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzeE(x0);
    }

    public ValuesSetDetails zzcI(Parcel parcel) {
        int i = 0;
        int zzau = zza.zzau(parcel);
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i4 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case 3:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 4:
                    i = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ValuesSetDetails(i4, i3, i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public ValuesSetDetails[] zzeE(int i) {
        return new ValuesSetDetails[i];
    }
}
