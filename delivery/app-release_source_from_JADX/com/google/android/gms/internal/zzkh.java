package com.google.android.gms.internal;

import android.accounts.Account;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.appdatasearch.DocumentContents;
import com.google.android.gms.appdatasearch.DocumentSection;
import com.google.android.gms.appdatasearch.RegisterSectionInfo.zza;
import com.google.android.gms.appdatasearch.UsageInfo;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.internal.zzqd.zzb;
import com.google.android.gms.internal.zzqd.zzc;
import com.google.android.gms.internal.zzqd.zzd;
import com.google.android.gms.plus.PlusShare;
import java.util.ArrayList;
import java.util.List;

public class zzkh {
    private static DocumentSection zza(String str, zzc com_google_android_gms_internal_zzqd_zzc) {
        return new DocumentSection(zztk.toByteArray(com_google_android_gms_internal_zzqd_zzc), new zza(str).zzM(true).zzbz(str).zzby("blob").zzlQ());
    }

    public static UsageInfo zza(Action action, long j, String str, int i) {
        int i2;
        boolean z = false;
        Bundle bundle = new Bundle();
        bundle.putAll(action.zzlT());
        Bundle bundle2 = bundle.getBundle("object");
        Uri parse = bundle2.containsKey("id") ? Uri.parse(bundle2.getString("id")) : null;
        String string = bundle2.getString("name");
        String string2 = bundle2.getString("type");
        Intent zza = zzki.zza(str, Uri.parse(bundle2.getString(PlusShare.KEY_CALL_TO_ACTION_URL)));
        DocumentContents.zza zza2 = UsageInfo.zza(zza, string, parse, string2, null);
        if (bundle.containsKey(".private:ssbContext")) {
            zza2.zza(DocumentSection.zzh(bundle.getByteArray(".private:ssbContext")));
            bundle.remove(".private:ssbContext");
        }
        if (bundle.containsKey(".private:accountName")) {
            zza2.zzb(new Account(bundle.getString(".private:accountName"), GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE));
            bundle.remove(".private:accountName");
        }
        if (bundle.containsKey(".private:isContextOnly") && bundle.getBoolean(".private:isContextOnly")) {
            i2 = 4;
            bundle.remove(".private:isContextOnly");
        } else {
            i2 = 0;
        }
        if (bundle.containsKey(".private:isDeviceOnly")) {
            z = bundle.getBoolean(".private:isDeviceOnly", false);
            bundle.remove(".private:isDeviceOnly");
        }
        zza2.zza(zza(".private:action", zzg(bundle)));
        return new UsageInfo.zza().zza(UsageInfo.zza(str, zza)).zzw(j).zzar(i2).zza(zza2.zzlN()).zzO(z).zzas(i).zzlR();
    }

    private static zzb zzb(String str, Bundle bundle) {
        zzb com_google_android_gms_internal_zzqd_zzb = new zzb();
        com_google_android_gms_internal_zzqd_zzb.name = str;
        com_google_android_gms_internal_zzqd_zzb.zzaJF = new zzd();
        com_google_android_gms_internal_zzqd_zzb.zzaJF.zzaJK = zzg(bundle);
        return com_google_android_gms_internal_zzqd_zzb;
    }

    static zzc zzg(Bundle bundle) {
        List arrayList = new ArrayList();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj instanceof String) {
                arrayList.add(zzq(str, (String) obj));
            } else if (obj instanceof Bundle) {
                arrayList.add(zzb(str, (Bundle) obj));
            } else if (obj instanceof String[]) {
                for (String str2 : (String[]) obj) {
                    if (str2 != null) {
                        arrayList.add(zzq(str, str2));
                    }
                }
            } else if (obj instanceof Bundle[]) {
                for (Bundle bundle2 : (Bundle[]) obj) {
                    if (bundle2 != null) {
                        arrayList.add(zzb(str, bundle2));
                    }
                }
            } else {
                Log.e("SearchIndex", "Unsupported value: " + obj);
            }
        }
        zzc com_google_android_gms_internal_zzqd_zzc = new zzc();
        if (bundle.containsKey("type")) {
            com_google_android_gms_internal_zzqd_zzc.type = bundle.getString("type");
        }
        com_google_android_gms_internal_zzqd_zzc.zzaJG = (zzb[]) arrayList.toArray(new zzb[arrayList.size()]);
        return com_google_android_gms_internal_zzqd_zzc;
    }

    private static zzb zzq(String str, String str2) {
        zzb com_google_android_gms_internal_zzqd_zzb = new zzb();
        com_google_android_gms_internal_zzqd_zzb.name = str;
        com_google_android_gms_internal_zzqd_zzb.zzaJF = new zzd();
        com_google_android_gms_internal_zzqd_zzb.zzaJF.zzakS = str2;
        return com_google_android_gms_internal_zzqd_zzb;
    }
}
