package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.maps.model.CameraPosition;

public class zza implements Creator<GoogleMapOptions> {
    static void zza(GoogleMapOptions googleMapOptions, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, googleMapOptions.getVersionCode());
        zzb.zza(parcel, 2, googleMapOptions.zzyV());
        zzb.zza(parcel, 3, googleMapOptions.zzyW());
        zzb.zzc(parcel, 4, googleMapOptions.getMapType());
        zzb.zza(parcel, 5, googleMapOptions.getCamera(), i, false);
        zzb.zza(parcel, 6, googleMapOptions.zzyX());
        zzb.zza(parcel, 7, googleMapOptions.zzyY());
        zzb.zza(parcel, 8, googleMapOptions.zzyZ());
        zzb.zza(parcel, 9, googleMapOptions.zzza());
        zzb.zza(parcel, 10, googleMapOptions.zzzb());
        zzb.zza(parcel, 11, googleMapOptions.zzzc());
        zzb.zza(parcel, 12, googleMapOptions.zzzd());
        zzb.zza(parcel, 14, googleMapOptions.zzze());
        zzb.zza(parcel, 15, googleMapOptions.zzzf());
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfk(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzhV(x0);
    }

    public GoogleMapOptions zzfk(Parcel parcel) {
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int i = 0;
        byte b = (byte) -1;
        byte b2 = (byte) -1;
        int i2 = 0;
        CameraPosition cameraPosition = null;
        byte b3 = (byte) -1;
        byte b4 = (byte) -1;
        byte b5 = (byte) -1;
        byte b6 = (byte) -1;
        byte b7 = (byte) -1;
        byte b8 = (byte) -1;
        byte b9 = (byte) -1;
        byte b10 = (byte) -1;
        byte b11 = (byte) -1;
        while (parcel.dataPosition() < zzau) {
            int zzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzcc(zzat)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    break;
                case 2:
                    b = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzat);
                    break;
                case 3:
                    b2 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzat);
                    break;
                case 4:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    break;
                case 5:
                    cameraPosition = (CameraPosition) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzat, CameraPosition.CREATOR);
                    break;
                case 6:
                    b3 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzat);
                    break;
                case 7:
                    b4 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzat);
                    break;
                case 8:
                    b5 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzat);
                    break;
                case 9:
                    b6 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzat);
                    break;
                case 10:
                    b7 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzat);
                    break;
                case 11:
                    b8 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzat);
                    break;
                case 12:
                    b9 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzat);
                    break;
                case 14:
                    b10 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzat);
                    break;
                case 15:
                    b11 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzat);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new GoogleMapOptions(i, b, b2, i2, cameraPosition, b3, b4, b5, b6, b7, b8, b9, b10, b11);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public GoogleMapOptions[] zzhV(int i) {
        return new GoogleMapOptions[i];
    }
}
