package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzb implements Creator<FaceSettingsParcel> {
    static void zza(FaceSettingsParcel faceSettingsParcel, Parcel parcel, int i) {
        int zzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, faceSettingsParcel.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 2, faceSettingsParcel.mode);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 3, faceSettingsParcel.zzbiO);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 4, faceSettingsParcel.zzbiP);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, faceSettingsParcel.zzbiQ);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, faceSettingsParcel.zzbiR);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgY(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzkr(x0);
    }

    public FaceSettingsParcel zzgY(Parcel parcel) {
        boolean z = false;
        int zzau = zza.zzau(parcel);
        boolean z2 = false;
        int i = 0;
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
                case 5:
                    z2 = zza.zzc(parcel, zzat);
                    break;
                case 6:
                    z = zza.zzc(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new FaceSettingsParcel(i4, i3, i2, i, z2, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public FaceSettingsParcel[] zzkr(int i) {
        return new FaceSettingsParcel[i];
    }
}
