package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.vision.barcode.Barcode.UrlBookmark;

public class zzl implements Creator<UrlBookmark> {
    static void zza(UrlBookmark urlBookmark, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, urlBookmark.versionCode);
        zzb.zza(parcel, 2, urlBookmark.title, false);
        zzb.zza(parcel, 3, urlBookmark.url, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgU(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzkn(x0);
    }

    public UrlBookmark zzgU(Parcel parcel) {
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
            return new UrlBookmark(i, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public UrlBookmark[] zzkn(int i) {
        return new UrlBookmark[i];
    }
}
