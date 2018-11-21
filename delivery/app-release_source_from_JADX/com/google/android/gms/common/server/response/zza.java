package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.server.converter.ConverterWrapper;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;

public class zza implements Creator<Field> {
    static void zza(Field field, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, field.getVersionCode());
        zzb.zzc(parcel, 2, field.zzqT());
        zzb.zza(parcel, 3, field.zzqZ());
        zzb.zzc(parcel, 4, field.zzqU());
        zzb.zza(parcel, 5, field.zzra());
        zzb.zza(parcel, 6, field.zzrb(), false);
        zzb.zzc(parcel, 7, field.zzrc());
        zzb.zza(parcel, 8, field.zzre(), false);
        zzb.zza(parcel, 9, field.zzrg(), i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaA(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzci(x0);
    }

    public Field zzaA(Parcel parcel) {
        ConverterWrapper converterWrapper = null;
        int i = 0;
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        String str = null;
        String str2 = null;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzcc(zzat)) {
                case 1:
                    i4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    break;
                case 2:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    break;
                case 3:
                    z2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzat);
                    break;
                case 4:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    break;
                case 5:
                    z = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzat);
                    break;
                case 6:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                case 7:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    break;
                case 8:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                case 9:
                    converterWrapper = (ConverterWrapper) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzat, ConverterWrapper.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new Field(i4, i3, z2, i2, z, str2, i, str, converterWrapper);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public Field[] zzci(int i) {
        return new Field[i];
    }
}
