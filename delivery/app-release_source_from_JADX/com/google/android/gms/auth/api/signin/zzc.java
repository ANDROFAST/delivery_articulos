package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzc implements Creator<GoogleSignInAccount> {
    static void zza(GoogleSignInAccount googleSignInAccount, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, googleSignInAccount.versionCode);
        zzb.zza(parcel, 2, googleSignInAccount.getId(), false);
        zzb.zza(parcel, 3, googleSignInAccount.getIdToken(), false);
        zzb.zza(parcel, 4, googleSignInAccount.getEmail(), false);
        zzb.zza(parcel, 5, googleSignInAccount.getDisplayName(), false);
        zzb.zza(parcel, 6, googleSignInAccount.getPhotoUrl(), i, false);
        zzb.zza(parcel, 7, googleSignInAccount.getServerAuthCode(), false);
        zzb.zza(parcel, 8, googleSignInAccount.zzmv());
        zzb.zza(parcel, 9, googleSignInAccount.zzmw(), false);
        zzb.zzc(parcel, 10, googleSignInAccount.zzTV, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzR(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzaM(x0);
    }

    public GoogleSignInAccount zzR(Parcel parcel) {
        List list = null;
        int zzau = zza.zzau(parcel);
        int i = 0;
        long j = 0;
        String str = null;
        String str2 = null;
        Uri uri = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzcc(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    str6 = zza.zzp(parcel, zzat);
                    break;
                case 3:
                    str5 = zza.zzp(parcel, zzat);
                    break;
                case 4:
                    str4 = zza.zzp(parcel, zzat);
                    break;
                case 5:
                    str3 = zza.zzp(parcel, zzat);
                    break;
                case 6:
                    uri = (Uri) zza.zza(parcel, zzat, Uri.CREATOR);
                    break;
                case 7:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 8:
                    j = zza.zzi(parcel, zzat);
                    break;
                case 9:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 10:
                    list = zza.zzc(parcel, zzat, Scope.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new GoogleSignInAccount(i, str6, str5, str4, str3, uri, str2, j, str, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public GoogleSignInAccount[] zzaM(int i) {
        return new GoogleSignInAccount[i];
    }
}
