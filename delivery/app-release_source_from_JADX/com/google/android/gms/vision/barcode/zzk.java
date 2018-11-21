package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.vision.barcode.Barcode.Sms;

public class zzk implements Creator<Sms> {
    static void zza(Sms sms, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, sms.versionCode);
        zzb.zza(parcel, 2, sms.message, false);
        zzb.zza(parcel, 3, sms.phoneNumber, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgT(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzkm(x0);
    }

    public Sms zzgT(Parcel parcel) {
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
            return new Sms(i, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public Sms[] zzkm(int i) {
        return new Sms[i];
    }
}
