package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzg implements Creator<PointOfInterest> {
    static void zza(PointOfInterest pointOfInterest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, pointOfInterest.getVersionCode());
        zzb.zza(parcel, 2, pointOfInterest.zzaQI, i, false);
        zzb.zza(parcel, 3, pointOfInterest.zzaQJ, false);
        zzb.zza(parcel, 4, pointOfInterest.name, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfs(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzid(x0);
    }

    public PointOfInterest zzfs(Parcel parcel) {
        String str = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str2 = null;
        LatLng latLng = null;
        while (parcel.dataPosition() < zzau) {
            LatLng latLng2;
            int zzg;
            String str3;
            int zzat = zza.zzat(parcel);
            String str4;
            switch (zza.zzcc(zzat)) {
                case 1:
                    str4 = str;
                    str = str2;
                    latLng2 = latLng;
                    zzg = zza.zzg(parcel, zzat);
                    str3 = str4;
                    break;
                case 2:
                    zzg = i;
                    str4 = str2;
                    latLng2 = (LatLng) zza.zza(parcel, zzat, LatLng.CREATOR);
                    str3 = str;
                    str = str4;
                    break;
                case 3:
                    latLng2 = latLng;
                    zzg = i;
                    str4 = str;
                    str = zza.zzp(parcel, zzat);
                    str3 = str4;
                    break;
                case 4:
                    str3 = zza.zzp(parcel, zzat);
                    str = str2;
                    latLng2 = latLng;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    str3 = str;
                    str = str2;
                    latLng2 = latLng;
                    zzg = i;
                    break;
            }
            i = zzg;
            latLng = latLng2;
            str2 = str;
            str = str3;
        }
        if (parcel.dataPosition() == zzau) {
            return new PointOfInterest(i, latLng, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public PointOfInterest[] zzid(int i) {
        return new PointOfInterest[i];
    }
}
