package com.google.android.gms.fitness.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzt implements Creator<Value> {
    static void zza(Value value, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, value.getFormat());
        zzb.zzc(parcel, 1000, value.getVersionCode());
        zzb.zza(parcel, 2, value.isSet());
        zzb.zza(parcel, 3, value.zztR());
        zzb.zza(parcel, 4, value.zztX(), false);
        zzb.zza(parcel, 5, value.zztY(), false);
        zzb.zza(parcel, 6, value.zztZ(), false);
        zzb.zza(parcel, 7, value.zzua(), false);
        zzb.zza(parcel, 8, value.zzub(), false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcZ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzeZ(x0);
    }

    public Value zzcZ(Parcel parcel) {
        boolean z = false;
        byte[] bArr = null;
        int zzau = zza.zzau(parcel);
        float f = 0.0f;
        float[] fArr = null;
        int[] iArr = null;
        Bundle bundle = null;
        String str = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 3:
                    f = zza.zzl(parcel, zzat);
                    break;
                case 4:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 5:
                    bundle = zza.zzr(parcel, zzat);
                    break;
                case 6:
                    iArr = zza.zzv(parcel, zzat);
                    break;
                case 7:
                    fArr = zza.zzy(parcel, zzat);
                    break;
                case 8:
                    bArr = zza.zzs(parcel, zzat);
                    break;
                case 1000:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new Value(i2, i, z, f, str, bundle, iArr, fArr, bArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public Value[] zzeZ(int i) {
        return new Value[i];
    }
}
