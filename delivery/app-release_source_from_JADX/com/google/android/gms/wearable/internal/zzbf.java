package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbf implements Creator<LargeAssetQueueEntryParcelable> {
    static void zza(LargeAssetQueueEntryParcelable largeAssetQueueEntryParcelable, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, largeAssetQueueEntryParcelable.mVersionCode);
        zzb.zza(parcel, 2, largeAssetQueueEntryParcelable.zzGQ());
        zzb.zzc(parcel, 3, largeAssetQueueEntryParcelable.getState());
        zzb.zza(parcel, 4, largeAssetQueueEntryParcelable.getPath(), false);
        zzb.zza(parcel, 5, largeAssetQueueEntryParcelable.getNodeId(), false);
        zzb.zza(parcel, 6, largeAssetQueueEntryParcelable.zzCO(), i, false);
        zzb.zzc(parcel, 8, largeAssetQueueEntryParcelable.zzGU());
        zzb.zza(parcel, 9, largeAssetQueueEntryParcelable.zzGR());
        zzb.zza(parcel, 10, largeAssetQueueEntryParcelable.zzGS());
        zzb.zza(parcel, 11, largeAssetQueueEntryParcelable.zzGT());
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zziq(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzlR(x0);
    }

    public LargeAssetQueueEntryParcelable zziq(Parcel parcel) {
        Uri uri = null;
        boolean z = false;
        int zzau = zza.zzau(parcel);
        long j = 0;
        boolean z2 = false;
        boolean z3 = false;
        int i = 0;
        String str = null;
        String str2 = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    j = zza.zzi(parcel, zzat);
                    break;
                case 3:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 4:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 5:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 6:
                    uri = (Uri) zza.zza(parcel, zzat, Uri.CREATOR);
                    break;
                case 8:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 9:
                    z3 = zza.zzc(parcel, zzat);
                    break;
                case 10:
                    z2 = zza.zzc(parcel, zzat);
                    break;
                case 11:
                    z = zza.zzc(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new LargeAssetQueueEntryParcelable(i3, j, i2, str2, str, uri, i, z3, z2, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public LargeAssetQueueEntryParcelable[] zzlR(int i) {
        return new LargeAssetQueueEntryParcelable[i];
    }
}
