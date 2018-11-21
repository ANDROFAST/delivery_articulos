package com.google.android.gms.playlog.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Creator<PlayLoggerContext> {
    static void zza(PlayLoggerContext playLoggerContext, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, playLoggerContext.versionCode);
        zzb.zza(parcel, 2, playLoggerContext.packageName, false);
        zzb.zzc(parcel, 3, playLoggerContext.zzaYy);
        zzb.zzc(parcel, 4, playLoggerContext.zzaYz);
        zzb.zza(parcel, 5, playLoggerContext.zzaYA, false);
        zzb.zza(parcel, 6, playLoggerContext.zzaYB, false);
        zzb.zza(parcel, 7, playLoggerContext.zzaYC);
        zzb.zza(parcel, 8, playLoggerContext.zzaYD, false);
        zzb.zza(parcel, 9, playLoggerContext.zzaYE);
        zzb.zzc(parcel, 10, playLoggerContext.zzaYF);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgo(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzjq(x0);
    }

    public PlayLoggerContext zzgo(Parcel parcel) {
        String str = null;
        int i = 0;
        int zzau = zza.zzau(parcel);
        boolean z = true;
        boolean z2 = false;
        String str2 = null;
        String str3 = null;
        int i2 = 0;
        int i3 = 0;
        String str4 = null;
        int i4 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i4 = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    str4 = zza.zzp(parcel, zzat);
                    break;
                case 3:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 5:
                    str3 = zza.zzp(parcel, zzat);
                    break;
                case 6:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 7:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 8:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 9:
                    z2 = zza.zzc(parcel, zzat);
                    break;
                case 10:
                    i = zza.zzg(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new PlayLoggerContext(i4, str4, i3, i2, str3, str2, z, str, z2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public PlayLoggerContext[] zzjq(int i) {
        return new PlayLoggerContext[i];
    }
}
