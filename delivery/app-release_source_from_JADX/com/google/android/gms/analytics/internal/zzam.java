package com.google.android.gms.analytics.internal;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzqi;
import com.google.android.gms.search.SearchAuth.StatusCodes;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

public class zzam {
    private static final char[] zzSa = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String zzK(boolean z) {
        return z ? "1" : "0";
    }

    public static double zza(String str, double d) {
        if (str != null) {
            try {
                d = Double.parseDouble(str);
            } catch (NumberFormatException e) {
            }
        }
        return d;
    }

    public static zzqi zza(zzaf com_google_android_gms_analytics_internal_zzaf, String str) {
        zzqi com_google_android_gms_internal_zzqi = null;
        zzx.zzy(com_google_android_gms_analytics_internal_zzaf);
        if (TextUtils.isEmpty(str)) {
            return com_google_android_gms_internal_zzqi;
        }
        try {
            List<NameValuePair> parse = URLEncodedUtils.parse(new URI("?" + str), "UTF-8");
            Map hashMap = new HashMap(parse.size());
            for (NameValuePair nameValuePair : parse) {
                hashMap.put(nameValuePair.getName(), nameValuePair.getValue());
            }
            zzqi com_google_android_gms_internal_zzqi2 = new zzqi();
            com_google_android_gms_internal_zzqi2.zzeh((String) hashMap.get("utm_content"));
            com_google_android_gms_internal_zzqi2.zzef((String) hashMap.get("utm_medium"));
            com_google_android_gms_internal_zzqi2.setName((String) hashMap.get("utm_campaign"));
            com_google_android_gms_internal_zzqi2.zzee((String) hashMap.get("utm_source"));
            com_google_android_gms_internal_zzqi2.zzeg((String) hashMap.get("utm_term"));
            com_google_android_gms_internal_zzqi2.zzei((String) hashMap.get("utm_id"));
            com_google_android_gms_internal_zzqi2.zzej((String) hashMap.get("anid"));
            com_google_android_gms_internal_zzqi2.zzek((String) hashMap.get("gclid"));
            com_google_android_gms_internal_zzqi2.zzel((String) hashMap.get("dclid"));
            com_google_android_gms_internal_zzqi2.zzem((String) hashMap.get("aclid"));
            return com_google_android_gms_internal_zzqi2;
        } catch (URISyntaxException e) {
            com_google_android_gms_analytics_internal_zzaf.zzd("No valid campaign data found", e);
            return com_google_android_gms_internal_zzqi;
        }
    }

    public static String zza(Locale locale) {
        if (locale == null) {
            return null;
        }
        Object language = locale.getLanguage();
        if (TextUtils.isEmpty(language)) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(language.toLowerCase());
        if (!TextUtils.isEmpty(locale.getCountry())) {
            stringBuilder.append("-").append(locale.getCountry().toLowerCase());
        }
        return stringBuilder.toString();
    }

    public static void zza(Map<String, String> map, String str, Map<String, String> map2) {
        zzc(map, str, (String) map2.get(str));
    }

    public static boolean zza(double d, String str) {
        return d > 0.0d && d < 100.0d && ((double) (zzbt(str) % StatusCodes.AUTH_DISABLED)) >= 100.0d * d;
    }

    public static boolean zza(Context context, Class<? extends Service> cls) {
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, cls), 4);
            if (serviceInfo != null && serviceInfo.enabled) {
                return true;
            }
        } catch (NameNotFoundException e) {
        }
        return false;
    }

    public static boolean zza(Context context, Class<? extends BroadcastReceiver> cls, boolean z) {
        try {
            ActivityInfo receiverInfo = context.getPackageManager().getReceiverInfo(new ComponentName(context, cls), 2);
            if (receiverInfo != null && receiverInfo.enabled && (!z || receiverInfo.exported)) {
                return true;
            }
        } catch (NameNotFoundException e) {
        }
        return false;
    }

    public static void zzb(Map<String, String> map, String str, boolean z) {
        if (!map.containsKey(str)) {
            map.put(str, z ? "1" : "0");
        }
    }

    public static Map<String, String> zzbp(String str) {
        Map<String, String> hashMap = new HashMap();
        for (String split : str.split("&")) {
            String[] split2 = split.split("=", 3);
            if (split2.length > 1) {
                hashMap.put(split2[0], TextUtils.isEmpty(split2[1]) ? null : split2[1]);
                if (!(split2.length != 3 || TextUtils.isEmpty(split2[1]) || hashMap.containsKey(split2[1]))) {
                    hashMap.put(split2[1], TextUtils.isEmpty(split2[2]) ? null : split2[2]);
                }
            } else if (split2.length == 1 && split2[0].length() != 0) {
                hashMap.put(split2[0], null);
            }
        }
        return hashMap;
    }

    public static long zzbq(String str) {
        long j = 0;
        if (str != null) {
            try {
                j = Long.parseLong(str);
            } catch (NumberFormatException e) {
            }
        }
        return j;
    }

    public static String zzbr(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.contains("?")) {
            String[] split = str.split("[\\?]");
            if (split.length > 1) {
                str = split[1];
            }
        }
        if (str.contains("%3D")) {
            try {
                str = URLDecoder.decode(str, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                return null;
            }
        } else if (!str.contains("=")) {
            return null;
        }
        Map zzbp = zzbp(str);
        String[] strArr = new String[]{"dclid", "utm_source", "gclid", "aclid", "utm_campaign", "utm_medium", "utm_term", "utm_content", "utm_id", "anid", "gmob_t"};
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            if (!TextUtils.isEmpty((CharSequence) zzbp.get(strArr[i]))) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append("&");
                }
                stringBuilder.append(strArr[i]).append("=").append((String) zzbp.get(strArr[i]));
            }
        }
        return stringBuilder.toString();
    }

    public static MessageDigest zzbs(String str) {
        int i = 0;
        while (i < 2) {
            try {
                MessageDigest instance = MessageDigest.getInstance(str);
                if (instance != null) {
                    return instance;
                }
                i++;
            } catch (NoSuchAlgorithmException e) {
            }
        }
        return null;
    }

    public static int zzbt(String str) {
        int i = 1;
        if (!TextUtils.isEmpty(str)) {
            i = 0;
            for (int length = str.length() - 1; length >= 0; length--) {
                char charAt = str.charAt(length);
                i = (((i << 6) & 268435455) + charAt) + (charAt << 14);
                int i2 = 266338304 & i;
                if (i2 != 0) {
                    i ^= i2 >> 21;
                }
            }
        }
        return i;
    }

    public static boolean zzbu(String str) {
        return TextUtils.isEmpty(str) || !str.startsWith("http:");
    }

    public static void zzc(Map<String, String> map, String str, String str2) {
        if (str2 != null && !map.containsKey(str)) {
            map.put(str, str2);
        }
    }

    public static void zzd(Map<String, String> map, String str, String str2) {
        if (str2 != null && TextUtils.isEmpty((CharSequence) map.get(str))) {
            map.put(str, str2);
        }
    }

    public static boolean zze(String str, boolean z) {
        return str != null ? (str.equalsIgnoreCase("true") || str.equalsIgnoreCase("yes") || str.equalsIgnoreCase("1")) ? true : (str.equalsIgnoreCase("false") || str.equalsIgnoreCase("no") || str.equalsIgnoreCase("0")) ? false : z : z;
    }
}
