package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.internal.zznh;
import java.util.ArrayList;

public class zzc implements Creator<LabelValueRow> {
    static void zza(LabelValueRow labelValueRow, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, labelValueRow.getVersionCode());
        zzb.zza(parcel, 2, labelValueRow.zzblw, false);
        zzb.zza(parcel, 3, labelValueRow.zzblx, false);
        zzb.zzc(parcel, 4, labelValueRow.zzbly, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzhC(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzkZ(x0);
    }

    public LabelValueRow zzhC(Parcel parcel) {
        String str = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        ArrayList zzrK = zznh.zzrK();
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
                case 4:
                    zzrK = zza.zzc(parcel, zzat, LabelValue.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new LabelValueRow(i, str2, str, zzrK);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public LabelValueRow[] zzkZ(int i) {
        return new LabelValueRow[i];
    }
}
