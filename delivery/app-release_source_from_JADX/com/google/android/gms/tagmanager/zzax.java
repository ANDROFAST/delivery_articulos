package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;

public class zzax {
    private static String zzbdZ;
    static Map<String, String> zzbea = new HashMap();

    public static String zzQ(String str, String str2) {
        return str2 == null ? str.length() > 0 ? str : null : Uri.parse("http://hostname/?" + str).getQueryParameter(str2);
    }

    public static String zzf(Context context, String str, String str2) {
        String str3 = (String) zzbea.get(str);
        if (str3 == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("gtm_click_referrers", 0);
            str3 = sharedPreferences != null ? sharedPreferences.getString(str, "") : "";
            zzbea.put(str, str3);
        }
        return zzQ(str3, str2);
    }

    public static void zzft(String str) {
        synchronized (zzax.class) {
            zzbdZ = str;
        }
    }

    public static String zzl(Context context, String str) {
        if (zzbdZ == null) {
            synchronized (zzax.class) {
                if (zzbdZ == null) {
                    SharedPreferences sharedPreferences = context.getSharedPreferences("gtm_install_referrer", 0);
                    if (sharedPreferences != null) {
                        zzbdZ = sharedPreferences.getString("referrer", "");
                    } else {
                        zzbdZ = "";
                    }
                }
            }
        }
        return zzQ(zzbdZ, str);
    }

    public static void zzm(Context context, String str) {
        String zzQ = zzQ(str, "conv");
        if (zzQ != null && zzQ.length() > 0) {
            zzbea.put(zzQ, str);
            zzcv.zzb(context, "gtm_click_referrers", zzQ, str);
        }
    }
}
