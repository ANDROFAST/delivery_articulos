package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzha
public final class zzdk {
    public static final zzdl zzyA = new C06903();
    public static final zzdl zzyB = new C06914();
    public static final zzdl zzyC = new C06925();
    public static final zzdl zzyD = new C06936();
    public static final zzdl zzyE = new C06947();
    public static final zzdl zzyF = new C06958();
    public static final zzdl zzyG = new C06969();
    public static final zzdl zzyH = new zzdl() {
        public void zza(zzjn com_google_android_gms_internal_zzjn, Map<String, String> map) {
            String str = (String) map.get("ty");
            String str2 = (String) map.get("td");
            try {
                int parseInt = Integer.parseInt((String) map.get("tx"));
                int parseInt2 = Integer.parseInt(str);
                int parseInt3 = Integer.parseInt(str2);
                zzan zzhE = com_google_android_gms_internal_zzjn.zzhE();
                if (zzhE != null) {
                    zzhE.zzac().zza(parseInt, parseInt2, parseInt3);
                }
            } catch (NumberFormatException e) {
                zzb.zzaH("Could not parse touch parameters from gmsg.");
            }
        }
    };
    public static final zzdl zzyI = new C06892();
    public static final zzdl zzyJ = new zzdt();
    public static final zzdl zzyK = new zzdx();
    public static final zzdl zzyL = new zzdj();
    public static final zzdl zzyz = new C06881();

    static class C06881 implements zzdl {
        C06881() {
        }

        public void zza(zzjn com_google_android_gms_internal_zzjn, Map<String, String> map) {
        }
    }

    static class C06892 implements zzdl {
        C06892() {
        }

        public void zza(zzjn com_google_android_gms_internal_zzjn, Map<String, String> map) {
            if (((Boolean) zzbz.zzwy.get()).booleanValue()) {
                com_google_android_gms_internal_zzjn.zzF(!Boolean.parseBoolean((String) map.get("disabled")));
            }
        }
    }

    static class C06903 implements zzdl {
        C06903() {
        }

        public void zza(zzjn com_google_android_gms_internal_zzjn, Map<String, String> map) {
            String str = (String) map.get("urls");
            if (TextUtils.isEmpty(str)) {
                zzb.zzaH("URLs missing in canOpenURLs GMSG.");
                return;
            }
            String[] split = str.split(",");
            Map hashMap = new HashMap();
            PackageManager packageManager = com_google_android_gms_internal_zzjn.getContext().getPackageManager();
            for (String str2 : split) {
                String[] split2 = str2.split(";", 2);
                hashMap.put(str2, Boolean.valueOf(packageManager.resolveActivity(new Intent(split2.length > 1 ? split2[1].trim() : "android.intent.action.VIEW", Uri.parse(split2[0].trim())), 65536) != null));
            }
            com_google_android_gms_internal_zzjn.zzb("openableURLs", hashMap);
        }
    }

    static class C06914 implements zzdl {
        C06914() {
        }

        public void zza(zzjn com_google_android_gms_internal_zzjn, Map<String, String> map) {
            PackageManager packageManager = com_google_android_gms_internal_zzjn.getContext().getPackageManager();
            try {
                try {
                    JSONArray jSONArray = new JSONObject((String) map.get("data")).getJSONArray("intents");
                    JSONObject jSONObject = new JSONObject();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            String optString = jSONObject2.optString("id");
                            Object optString2 = jSONObject2.optString("u");
                            Object optString3 = jSONObject2.optString("i");
                            Object optString4 = jSONObject2.optString("m");
                            Object optString5 = jSONObject2.optString("p");
                            Object optString6 = jSONObject2.optString("c");
                            jSONObject2.optString("f");
                            jSONObject2.optString("e");
                            Intent intent = new Intent();
                            if (!TextUtils.isEmpty(optString2)) {
                                intent.setData(Uri.parse(optString2));
                            }
                            if (!TextUtils.isEmpty(optString3)) {
                                intent.setAction(optString3);
                            }
                            if (!TextUtils.isEmpty(optString4)) {
                                intent.setType(optString4);
                            }
                            if (!TextUtils.isEmpty(optString5)) {
                                intent.setPackage(optString5);
                            }
                            if (!TextUtils.isEmpty(optString6)) {
                                String[] split = optString6.split("/", 2);
                                if (split.length == 2) {
                                    intent.setComponent(new ComponentName(split[0], split[1]));
                                }
                            }
                            try {
                                jSONObject.put(optString, packageManager.resolveActivity(intent, 65536) != null);
                            } catch (Throwable e) {
                                zzb.zzb("Error constructing openable urls response.", e);
                            }
                        } catch (Throwable e2) {
                            zzb.zzb("Error parsing the intent data.", e2);
                        }
                    }
                    com_google_android_gms_internal_zzjn.zzb("openableIntents", jSONObject);
                } catch (JSONException e3) {
                    com_google_android_gms_internal_zzjn.zzb("openableIntents", new JSONObject());
                }
            } catch (JSONException e4) {
                com_google_android_gms_internal_zzjn.zzb("openableIntents", new JSONObject());
            }
        }
    }

    static class C06925 implements zzdl {
        C06925() {
        }

        public void zza(zzjn com_google_android_gms_internal_zzjn, Map<String, String> map) {
            String str = (String) map.get("u");
            if (str == null) {
                zzb.zzaH("URL missing from click GMSG.");
                return;
            }
            Uri zza;
            Uri parse = Uri.parse(str);
            try {
                zzan zzhE = com_google_android_gms_internal_zzjn.zzhE();
                if (zzhE != null && zzhE.zzb(parse)) {
                    zza = zzhE.zza(parse, com_google_android_gms_internal_zzjn.getContext());
                    new zziw(com_google_android_gms_internal_zzjn.getContext(), com_google_android_gms_internal_zzjn.zzhF().afmaVersion, zza.toString()).zzgX();
                }
            } catch (zzao e) {
                zzb.zzaH("Unable to append parameter to URL: " + str);
            }
            zza = parse;
            new zziw(com_google_android_gms_internal_zzjn.getContext(), com_google_android_gms_internal_zzjn.zzhF().afmaVersion, zza.toString()).zzgX();
        }
    }

    static class C06936 implements zzdl {
        C06936() {
        }

        public void zza(zzjn com_google_android_gms_internal_zzjn, Map<String, String> map) {
            zzd zzhA = com_google_android_gms_internal_zzjn.zzhA();
            if (zzhA != null) {
                zzhA.close();
                return;
            }
            zzhA = com_google_android_gms_internal_zzjn.zzhB();
            if (zzhA != null) {
                zzhA.close();
            } else {
                zzb.zzaH("A GMSG tried to close something that wasn't an overlay.");
            }
        }
    }

    static class C06947 implements zzdl {
        C06947() {
        }

        public void zza(zzjn com_google_android_gms_internal_zzjn, Map<String, String> map) {
            com_google_android_gms_internal_zzjn.zzE("1".equals(map.get("custom_close")));
        }
    }

    static class C06958 implements zzdl {
        C06958() {
        }

        public void zza(zzjn com_google_android_gms_internal_zzjn, Map<String, String> map) {
            String str = (String) map.get("u");
            if (str == null) {
                zzb.zzaH("URL missing from httpTrack GMSG.");
            } else {
                new zziw(com_google_android_gms_internal_zzjn.getContext(), com_google_android_gms_internal_zzjn.zzhF().afmaVersion, str).zzgX();
            }
        }
    }

    static class C06969 implements zzdl {
        C06969() {
        }

        public void zza(zzjn com_google_android_gms_internal_zzjn, Map<String, String> map) {
            zzb.zzaG("Received log message: " + ((String) map.get("string")));
        }
    }
}
