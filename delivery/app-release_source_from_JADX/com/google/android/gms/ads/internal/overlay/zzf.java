package com.google.android.gms.ads.internal.overlay;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzf implements Creator<AdOverlayInfoParcel> {
    static void zza(AdOverlayInfoParcel adOverlayInfoParcel, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, adOverlayInfoParcel.versionCode);
        zzb.zza(parcel, 2, adOverlayInfoParcel.zzDz, i, false);
        zzb.zza(parcel, 3, adOverlayInfoParcel.zzfh(), false);
        zzb.zza(parcel, 4, adOverlayInfoParcel.zzfi(), false);
        zzb.zza(parcel, 5, adOverlayInfoParcel.zzfj(), false);
        zzb.zza(parcel, 6, adOverlayInfoParcel.zzfk(), false);
        zzb.zza(parcel, 7, adOverlayInfoParcel.zzDE, false);
        zzb.zza(parcel, 8, adOverlayInfoParcel.zzDF);
        zzb.zza(parcel, 9, adOverlayInfoParcel.zzDG, false);
        zzb.zza(parcel, 10, adOverlayInfoParcel.zzfm(), false);
        zzb.zzc(parcel, 11, adOverlayInfoParcel.orientation);
        zzb.zzc(parcel, 12, adOverlayInfoParcel.zzDI);
        zzb.zza(parcel, 13, adOverlayInfoParcel.url, false);
        zzb.zza(parcel, 14, adOverlayInfoParcel.zzqR, i, false);
        zzb.zza(parcel, 15, adOverlayInfoParcel.zzfl(), false);
        zzb.zza(parcel, 17, adOverlayInfoParcel.zzDL, i, false);
        zzb.zza(parcel, 16, adOverlayInfoParcel.zzDK, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzg(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzz(x0);
    }

    public AdOverlayInfoParcel zzg(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        AdLauncherIntentInfoParcel adLauncherIntentInfoParcel = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        String str = null;
        boolean z = false;
        String str2 = null;
        IBinder iBinder5 = null;
        int i2 = 0;
        int i3 = 0;
        String str3 = null;
        VersionInfoParcel versionInfoParcel = null;
        IBinder iBinder6 = null;
        String str4 = null;
        InterstitialAdParameterParcel interstitialAdParameterParcel = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    adLauncherIntentInfoParcel = (AdLauncherIntentInfoParcel) zza.zza(parcel, zzat, AdLauncherIntentInfoParcel.CREATOR);
                    break;
                case 3:
                    iBinder = zza.zzq(parcel, zzat);
                    break;
                case 4:
                    iBinder2 = zza.zzq(parcel, zzat);
                    break;
                case 5:
                    iBinder3 = zza.zzq(parcel, zzat);
                    break;
                case 6:
                    iBinder4 = zza.zzq(parcel, zzat);
                    break;
                case 7:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 8:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 9:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 10:
                    iBinder5 = zza.zzq(parcel, zzat);
                    break;
                case 11:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 12:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case 13:
                    str3 = zza.zzp(parcel, zzat);
                    break;
                case 14:
                    versionInfoParcel = (VersionInfoParcel) zza.zza(parcel, zzat, (Creator) VersionInfoParcel.CREATOR);
                    break;
                case 15:
                    iBinder6 = zza.zzq(parcel, zzat);
                    break;
                case 16:
                    str4 = zza.zzp(parcel, zzat);
                    break;
                case 17:
                    interstitialAdParameterParcel = (InterstitialAdParameterParcel) zza.zza(parcel, zzat, (Creator) InterstitialAdParameterParcel.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new AdOverlayInfoParcel(i, adLauncherIntentInfoParcel, iBinder, iBinder2, iBinder3, iBinder4, str, z, str2, iBinder5, i2, i3, str3, versionInfoParcel, iBinder6, str4, interstitialAdParameterParcel);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public AdOverlayInfoParcel[] zzz(int i) {
        return new AdOverlayInfoParcel[i];
    }
}
