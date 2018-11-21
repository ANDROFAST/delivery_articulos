package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Creator<DocumentId> {
    static void zza(DocumentId documentId, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, documentId.zzSp, false);
        zzb.zzc(parcel, 1000, documentId.mVersionCode);
        zzb.zza(parcel, 2, documentId.zzSq, false);
        zzb.zza(parcel, 3, documentId.zzSr, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzs(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzaj(x0);
    }

    public DocumentId[] zzaj(int i) {
        return new DocumentId[i];
    }

    public DocumentId zzs(Parcel parcel) {
        String str = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    str3 = zza.zzp(parcel, zzat);
                    break;
                case 2:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 3:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 1000:
                    i = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new DocumentId(i, str3, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }
}
