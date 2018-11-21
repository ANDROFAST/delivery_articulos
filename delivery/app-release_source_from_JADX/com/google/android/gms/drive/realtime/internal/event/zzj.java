package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzj implements Creator<ValuesRemovedDetails> {
    static void zza(ValuesRemovedDetails valuesRemovedDetails, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, valuesRemovedDetails.mVersionCode);
        zzb.zzc(parcel, 2, valuesRemovedDetails.mIndex);
        zzb.zzc(parcel, 3, valuesRemovedDetails.zzasJ);
        zzb.zzc(parcel, 4, valuesRemovedDetails.zzasK);
        zzb.zza(parcel, 5, valuesRemovedDetails.zzatk, false);
        zzb.zzc(parcel, 6, valuesRemovedDetails.zzatl);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcH(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzeD(x0);
    }

    public ValuesRemovedDetails zzcH(Parcel parcel) {
        int i = 0;
        int zzau = zza.zzau(parcel);
        String str = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i5 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    i4 = zza.zzg(parcel, zzat);
                    break;
                case 3:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 5:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 6:
                    i = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ValuesRemovedDetails(i5, i4, i3, i2, str, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public ValuesRemovedDetails[] zzeD(int i) {
        return new ValuesRemovedDetails[i];
    }
}
