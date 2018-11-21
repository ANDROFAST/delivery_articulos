package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Creator<EmailSignInOptions> {
    static void zza(EmailSignInOptions emailSignInOptions, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, emailSignInOptions.versionCode);
        zzb.zza(parcel, 2, emailSignInOptions.zzmo(), i, false);
        zzb.zza(parcel, 3, emailSignInOptions.zzmq(), false);
        zzb.zza(parcel, 4, emailSignInOptions.zzmp(), i, false);
        zzb.zzI(parcel, zzav);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzP(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzaK(x0);
    }

    public EmailSignInOptions zzP(Parcel parcel) {
        Uri uri = null;
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int i = 0;
        String str = null;
        Uri uri2 = null;
        while (parcel.dataPosition() < zzau) {
            String str2;
            Uri uri3;
            int zzg;
            Uri uri4;
            int zzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            Uri uri5;
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzcc(zzat)) {
                case 1:
                    uri5 = uri;
                    str2 = str;
                    uri3 = uri2;
                    zzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    uri4 = uri5;
                    break;
                case 2:
                    zzg = i;
                    String str3 = str;
                    uri3 = (Uri) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzat, Uri.CREATOR);
                    uri4 = uri;
                    str2 = str3;
                    break;
                case 3:
                    uri3 = uri2;
                    zzg = i;
                    uri5 = uri;
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    uri4 = uri5;
                    break;
                case 4:
                    uri4 = (Uri) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzat, Uri.CREATOR);
                    str2 = str;
                    uri3 = uri2;
                    zzg = i;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzat);
                    uri4 = uri;
                    str2 = str;
                    uri3 = uri2;
                    zzg = i;
                    break;
            }
            i = zzg;
            uri2 = uri3;
            str = str2;
            uri = uri4;
        }
        if (parcel.dataPosition() == zzau) {
            return new EmailSignInOptions(i, uri2, str, uri);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzau, parcel);
    }

    public EmailSignInOptions[] zzaK(int i) {
        return new EmailSignInOptions[i];
    }
}
