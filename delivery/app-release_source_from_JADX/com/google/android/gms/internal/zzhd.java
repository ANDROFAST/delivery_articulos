package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.SearchAdRequestParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.zzhm.zza;
import com.google.android.gms.plus.PlusShare;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzha
public final class zzhd {
    private static final SimpleDateFormat zzHU = new SimpleDateFormat("yyyyMMdd", Locale.US);

    private static String zzL(int i) {
        return String.format(Locale.US, "#%06x", new Object[]{Integer.valueOf(ViewCompat.MEASURED_SIZE_MASK & i)});
    }

    public static AdResponseParcel zza(Context context, AdRequestInfoParcel adRequestInfoParcel, String str) {
        try {
            String str2;
            AdResponseParcel adResponseParcel;
            int i;
            List list;
            List list2;
            List list3;
            long j;
            String optString;
            String str3;
            boolean optBoolean;
            JSONObject jSONObject = new JSONObject(str);
            String optString2 = jSONObject.optString("ad_base_url", null);
            Object optString3 = jSONObject.optString("ad_url", null);
            String optString4 = jSONObject.optString("ad_size", null);
            boolean z = (adRequestInfoParcel == null || adRequestInfoParcel.zzGw == 0) ? false : true;
            CharSequence optString5 = z ? jSONObject.optString("ad_json", null) : jSONObject.optString("ad_html", null);
            long j2 = -1;
            String optString6 = jSONObject.optString("debug_dialog", null);
            long j3 = jSONObject.has("interstitial_timeout") ? (long) (jSONObject.getDouble("interstitial_timeout") * 1000.0d) : -1;
            String optString7 = jSONObject.optString("orientation", null);
            int i2 = -1;
            if ("portrait".equals(optString7)) {
                i2 = zzp.zzbz().zzhe();
            } else if ("landscape".equals(optString7)) {
                i2 = zzp.zzbz().zzhd();
            }
            if (TextUtils.isEmpty(optString5)) {
                if (TextUtils.isEmpty(optString3)) {
                    zzb.zzaH("Could not parse the mediation config: Missing required " + (z ? "ad_json" : "ad_html") + " or " + "ad_url" + " field.");
                    return new AdResponseParcel(0);
                }
                AdResponseParcel zza = zzhc.zza(adRequestInfoParcel, context, adRequestInfoParcel.zzqR.afmaVersion, optString3, null, null, null, null, null);
                optString2 = zza.zzDE;
                str2 = zza.body;
                j2 = zza.zzGR;
                adResponseParcel = zza;
            } else if (TextUtils.isEmpty(optString2)) {
                zzb.zzaH("Could not parse the mediation config: Missing required ad_base_url field");
                return new AdResponseParcel(0);
            } else {
                adResponseParcel = null;
                CharSequence charSequence = optString5;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("click_urls");
            List list4 = adResponseParcel == null ? null : adResponseParcel.zzAQ;
            if (optJSONArray != null) {
                if (list4 == null) {
                    list4 = new LinkedList();
                }
                for (i = 0; i < optJSONArray.length(); i++) {
                    list4.add(optJSONArray.getString(i));
                }
                list = list4;
            } else {
                list = list4;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("impression_urls");
            list4 = adResponseParcel == null ? null : adResponseParcel.zzAR;
            if (optJSONArray2 != null) {
                if (list4 == null) {
                    list4 = new LinkedList();
                }
                for (i = 0; i < optJSONArray2.length(); i++) {
                    list4.add(optJSONArray2.getString(i));
                }
                list2 = list4;
            } else {
                list2 = list4;
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("manual_impression_urls");
            list4 = adResponseParcel == null ? null : adResponseParcel.zzGP;
            if (optJSONArray3 != null) {
                if (list4 == null) {
                    list4 = new LinkedList();
                }
                for (i = 0; i < optJSONArray3.length(); i++) {
                    list4.add(optJSONArray3.getString(i));
                }
                list3 = list4;
            } else {
                list3 = list4;
            }
            if (adResponseParcel != null) {
                if (adResponseParcel.orientation != -1) {
                    i2 = adResponseParcel.orientation;
                }
                if (adResponseParcel.zzGM > 0) {
                    j = adResponseParcel.zzGM;
                    optString = jSONObject.optString("active_view");
                    str3 = null;
                    optBoolean = jSONObject.optBoolean("ad_is_javascript", false);
                    if (optBoolean) {
                        str3 = jSONObject.optString("ad_passback_url", null);
                    }
                    return new AdResponseParcel(adRequestInfoParcel, optString2, str2, list, list2, j, jSONObject.optBoolean("mediation", false), jSONObject.optLong("mediation_config_cache_time_milliseconds", -1), list3, jSONObject.optLong("refresh_interval_milliseconds", -1), i2, optString4, j2, optString6, optBoolean, str3, optString, jSONObject.optBoolean("custom_render_allowed", false), z, adRequestInfoParcel.zzGy, jSONObject.optBoolean("content_url_opted_out", true), jSONObject.optBoolean("prefetch", false), jSONObject.optInt("oauth2_token_status", 0), jSONObject.optString("gws_query_id", ""), "height".equals(jSONObject.optString("fluid", "")));
                }
            }
            j = j3;
            optString = jSONObject.optString("active_view");
            str3 = null;
            optBoolean = jSONObject.optBoolean("ad_is_javascript", false);
            if (optBoolean) {
                str3 = jSONObject.optString("ad_passback_url", null);
            }
            return new AdResponseParcel(adRequestInfoParcel, optString2, str2, list, list2, j, jSONObject.optBoolean("mediation", false), jSONObject.optLong("mediation_config_cache_time_milliseconds", -1), list3, jSONObject.optLong("refresh_interval_milliseconds", -1), i2, optString4, j2, optString6, optBoolean, str3, optString, jSONObject.optBoolean("custom_render_allowed", false), z, adRequestInfoParcel.zzGy, jSONObject.optBoolean("content_url_opted_out", true), jSONObject.optBoolean("prefetch", false), jSONObject.optInt("oauth2_token_status", 0), jSONObject.optString("gws_query_id", ""), "height".equals(jSONObject.optString("fluid", "")));
        } catch (JSONException e) {
            zzb.zzaH("Could not parse the mediation config: " + e.getMessage());
            return new AdResponseParcel(0);
        }
    }

    public static JSONObject zza(Context context, AdRequestInfoParcel adRequestInfoParcel, zzhi com_google_android_gms_internal_zzhi, zza com_google_android_gms_internal_zzhm_zza, Location location, zzbs com_google_android_gms_internal_zzbs, String str, String str2, List<String> list, Bundle bundle) {
        try {
            HashMap hashMap = new HashMap();
            if (list.size() > 0) {
                hashMap.put("eid", TextUtils.join(",", list));
            }
            if (adRequestInfoParcel.zzGp != null) {
                hashMap.put("ad_pos", adRequestInfoParcel.zzGp);
            }
            zza(hashMap, adRequestInfoParcel.zzGq);
            hashMap.put("format", adRequestInfoParcel.zzqV.zztV);
            if (adRequestInfoParcel.zzqV.width == -1) {
                hashMap.put("smart_w", "full");
            }
            if (adRequestInfoParcel.zzqV.height == -2) {
                hashMap.put("smart_h", "auto");
            }
            if (adRequestInfoParcel.zzqV.zztZ) {
                hashMap.put("fluid", "height");
            }
            if (adRequestInfoParcel.zzqV.zztX != null) {
                StringBuilder stringBuilder = new StringBuilder();
                for (AdSizeParcel adSizeParcel : adRequestInfoParcel.zzqV.zztX) {
                    if (stringBuilder.length() != 0) {
                        stringBuilder.append("|");
                    }
                    stringBuilder.append(adSizeParcel.width == -1 ? (int) (((float) adSizeParcel.widthPixels) / com_google_android_gms_internal_zzhi.zzGC) : adSizeParcel.width);
                    stringBuilder.append("x");
                    stringBuilder.append(adSizeParcel.height == -2 ? (int) (((float) adSizeParcel.heightPixels) / com_google_android_gms_internal_zzhi.zzGC) : adSizeParcel.height);
                }
                hashMap.put("sz", stringBuilder);
            }
            if (adRequestInfoParcel.zzGw != 0) {
                hashMap.put("native_version", Integer.valueOf(adRequestInfoParcel.zzGw));
                if (!adRequestInfoParcel.zzqV.zzua) {
                    hashMap.put("native_templates", adRequestInfoParcel.zzrl);
                    hashMap.put("native_image_orientation", zzc(adRequestInfoParcel.zzrj));
                    if (!adRequestInfoParcel.zzGH.isEmpty()) {
                        hashMap.put("native_custom_templates", adRequestInfoParcel.zzGH);
                    }
                }
            }
            hashMap.put("slotname", adRequestInfoParcel.zzqP);
            hashMap.put("pn", adRequestInfoParcel.applicationInfo.packageName);
            if (adRequestInfoParcel.zzGr != null) {
                hashMap.put("vc", Integer.valueOf(adRequestInfoParcel.zzGr.versionCode));
            }
            hashMap.put("ms", str2);
            hashMap.put("seq_num", adRequestInfoParcel.zzGt);
            hashMap.put("session_id", adRequestInfoParcel.zzGu);
            hashMap.put("js", adRequestInfoParcel.zzqR.afmaVersion);
            zza(hashMap, com_google_android_gms_internal_zzhi, com_google_android_gms_internal_zzhm_zza);
            hashMap.put("platform", Build.MANUFACTURER);
            hashMap.put("submodel", Build.MODEL);
            if (adRequestInfoParcel.zzGq.versionCode >= 2 && adRequestInfoParcel.zzGq.zzty != null) {
                zza(hashMap, adRequestInfoParcel.zzGq.zzty);
            }
            if (adRequestInfoParcel.versionCode >= 2) {
                hashMap.put("quality_signals", adRequestInfoParcel.zzGv);
            }
            if (adRequestInfoParcel.versionCode >= 4 && adRequestInfoParcel.zzGy) {
                hashMap.put("forceHttps", Boolean.valueOf(adRequestInfoParcel.zzGy));
            }
            if (bundle != null) {
                hashMap.put("content_info", bundle);
            }
            if (adRequestInfoParcel.versionCode >= 5) {
                hashMap.put("u_sd", Float.valueOf(adRequestInfoParcel.zzGC));
                hashMap.put("sh", Integer.valueOf(adRequestInfoParcel.zzGB));
                hashMap.put("sw", Integer.valueOf(adRequestInfoParcel.zzGA));
            } else {
                hashMap.put("u_sd", Float.valueOf(com_google_android_gms_internal_zzhi.zzGC));
                hashMap.put("sh", Integer.valueOf(com_google_android_gms_internal_zzhi.zzGB));
                hashMap.put("sw", Integer.valueOf(com_google_android_gms_internal_zzhi.zzGA));
            }
            if (adRequestInfoParcel.versionCode >= 6) {
                if (!TextUtils.isEmpty(adRequestInfoParcel.zzGD)) {
                    try {
                        hashMap.put("view_hierarchy", new JSONObject(adRequestInfoParcel.zzGD));
                    } catch (Throwable e) {
                        zzb.zzd("Problem serializing view hierarchy to JSON", e);
                    }
                }
                hashMap.put("correlation_id", Long.valueOf(adRequestInfoParcel.zzGE));
            }
            if (adRequestInfoParcel.versionCode >= 7) {
                hashMap.put("request_id", adRequestInfoParcel.zzGF);
            }
            if (adRequestInfoParcel.versionCode >= 11 && adRequestInfoParcel.zzGJ != null) {
                hashMap.put("capability", adRequestInfoParcel.zzGJ.toBundle());
            }
            zza(hashMap, str);
            if (adRequestInfoParcel.versionCode >= 12 && !TextUtils.isEmpty(adRequestInfoParcel.zzGK)) {
                hashMap.put("anchor", adRequestInfoParcel.zzGK);
            }
            if (zzb.zzQ(2)) {
                zzb.m7v("Ad Request JSON: " + zzp.zzbx().zzz(hashMap).toString(2));
            }
            return zzp.zzbx().zzz(hashMap);
        } catch (JSONException e2) {
            zzb.zzaH("Problem serializing ad request to JSON: " + e2.getMessage());
            return null;
        }
    }

    private static void zza(HashMap<String, Object> hashMap, Location location) {
        HashMap hashMap2 = new HashMap();
        Float valueOf = Float.valueOf(location.getAccuracy() * 1000.0f);
        Long valueOf2 = Long.valueOf(location.getTime() * 1000);
        Long valueOf3 = Long.valueOf((long) (location.getLatitude() * 1.0E7d));
        Long valueOf4 = Long.valueOf((long) (location.getLongitude() * 1.0E7d));
        hashMap2.put("radius", valueOf);
        hashMap2.put("lat", valueOf3);
        hashMap2.put("long", valueOf4);
        hashMap2.put("time", valueOf2);
        hashMap.put("uule", hashMap2);
    }

    private static void zza(HashMap<String, Object> hashMap, AdRequestParcel adRequestParcel) {
        String zzgW = zzik.zzgW();
        if (zzgW != null) {
            hashMap.put("abf", zzgW);
        }
        if (adRequestParcel.zztq != -1) {
            hashMap.put("cust_age", zzHU.format(new Date(adRequestParcel.zztq)));
        }
        if (adRequestParcel.extras != null) {
            hashMap.put("extras", adRequestParcel.extras);
        }
        if (adRequestParcel.zztr != -1) {
            hashMap.put("cust_gender", Integer.valueOf(adRequestParcel.zztr));
        }
        if (adRequestParcel.zzts != null) {
            hashMap.put("kw", adRequestParcel.zzts);
        }
        if (adRequestParcel.zztu != -1) {
            hashMap.put("tag_for_child_directed_treatment", Integer.valueOf(adRequestParcel.zztu));
        }
        if (adRequestParcel.zztt) {
            hashMap.put("adtest", "on");
        }
        if (adRequestParcel.versionCode >= 2) {
            if (adRequestParcel.zztv) {
                hashMap.put("d_imp_hdr", Integer.valueOf(1));
            }
            if (!TextUtils.isEmpty(adRequestParcel.zztw)) {
                hashMap.put("ppid", adRequestParcel.zztw);
            }
            if (adRequestParcel.zztx != null) {
                zza((HashMap) hashMap, adRequestParcel.zztx);
            }
        }
        if (adRequestParcel.versionCode >= 3 && adRequestParcel.zztz != null) {
            hashMap.put(PlusShare.KEY_CALL_TO_ACTION_URL, adRequestParcel.zztz);
        }
        if (adRequestParcel.versionCode >= 5) {
            if (adRequestParcel.zztB != null) {
                hashMap.put("custom_targeting", adRequestParcel.zztB);
            }
            if (adRequestParcel.zztC != null) {
                hashMap.put("category_exclusions", adRequestParcel.zztC);
            }
            if (adRequestParcel.zztD != null) {
                hashMap.put("request_agent", adRequestParcel.zztD);
            }
        }
        if (adRequestParcel.versionCode >= 6 && adRequestParcel.zztE != null) {
            hashMap.put("request_pkg", adRequestParcel.zztE);
        }
        if (adRequestParcel.versionCode >= 7) {
            hashMap.put("is_designed_for_families", Boolean.valueOf(adRequestParcel.zztF));
        }
    }

    private static void zza(HashMap<String, Object> hashMap, SearchAdRequestParcel searchAdRequestParcel) {
        Object obj;
        Object obj2 = null;
        if (Color.alpha(searchAdRequestParcel.zzuI) != 0) {
            hashMap.put("acolor", zzL(searchAdRequestParcel.zzuI));
        }
        if (Color.alpha(searchAdRequestParcel.backgroundColor) != 0) {
            hashMap.put("bgcolor", zzL(searchAdRequestParcel.backgroundColor));
        }
        if (!(Color.alpha(searchAdRequestParcel.zzuJ) == 0 || Color.alpha(searchAdRequestParcel.zzuK) == 0)) {
            hashMap.put("gradientto", zzL(searchAdRequestParcel.zzuJ));
            hashMap.put("gradientfrom", zzL(searchAdRequestParcel.zzuK));
        }
        if (Color.alpha(searchAdRequestParcel.zzuL) != 0) {
            hashMap.put("bcolor", zzL(searchAdRequestParcel.zzuL));
        }
        hashMap.put("bthick", Integer.toString(searchAdRequestParcel.zzuM));
        switch (searchAdRequestParcel.zzuN) {
            case 0:
                obj = "none";
                break;
            case 1:
                obj = "dashed";
                break;
            case 2:
                obj = "dotted";
                break;
            case 3:
                obj = "solid";
                break;
            default:
                obj = null;
                break;
        }
        if (obj != null) {
            hashMap.put("btype", obj);
        }
        switch (searchAdRequestParcel.zzuO) {
            case 0:
                obj2 = "light";
                break;
            case 1:
                obj2 = "medium";
                break;
            case 2:
                obj2 = "dark";
                break;
        }
        if (obj2 != null) {
            hashMap.put("callbuttoncolor", obj2);
        }
        if (searchAdRequestParcel.zzuP != null) {
            hashMap.put("channel", searchAdRequestParcel.zzuP);
        }
        if (Color.alpha(searchAdRequestParcel.zzuQ) != 0) {
            hashMap.put("dcolor", zzL(searchAdRequestParcel.zzuQ));
        }
        if (searchAdRequestParcel.zzuR != null) {
            hashMap.put("font", searchAdRequestParcel.zzuR);
        }
        if (Color.alpha(searchAdRequestParcel.zzuS) != 0) {
            hashMap.put("hcolor", zzL(searchAdRequestParcel.zzuS));
        }
        hashMap.put("headersize", Integer.toString(searchAdRequestParcel.zzuT));
        if (searchAdRequestParcel.zzuU != null) {
            hashMap.put("q", searchAdRequestParcel.zzuU);
        }
    }

    private static void zza(HashMap<String, Object> hashMap, zzhi com_google_android_gms_internal_zzhi, zza com_google_android_gms_internal_zzhm_zza) {
        hashMap.put("am", Integer.valueOf(com_google_android_gms_internal_zzhi.zzIA));
        hashMap.put("cog", zzy(com_google_android_gms_internal_zzhi.zzIB));
        hashMap.put("coh", zzy(com_google_android_gms_internal_zzhi.zzIC));
        if (!TextUtils.isEmpty(com_google_android_gms_internal_zzhi.zzID)) {
            hashMap.put("carrier", com_google_android_gms_internal_zzhi.zzID);
        }
        hashMap.put("gl", com_google_android_gms_internal_zzhi.zzIE);
        if (com_google_android_gms_internal_zzhi.zzIF) {
            hashMap.put("simulator", Integer.valueOf(1));
        }
        if (com_google_android_gms_internal_zzhi.zzIG) {
            hashMap.put("is_sidewinder", Integer.valueOf(1));
        }
        hashMap.put("ma", zzy(com_google_android_gms_internal_zzhi.zzIH));
        hashMap.put("sp", zzy(com_google_android_gms_internal_zzhi.zzII));
        hashMap.put("hl", com_google_android_gms_internal_zzhi.zzIJ);
        if (!TextUtils.isEmpty(com_google_android_gms_internal_zzhi.zzIK)) {
            hashMap.put("mv", com_google_android_gms_internal_zzhi.zzIK);
        }
        hashMap.put("muv", Integer.valueOf(com_google_android_gms_internal_zzhi.zzIL));
        if (com_google_android_gms_internal_zzhi.zzIM != -2) {
            hashMap.put("cnt", Integer.valueOf(com_google_android_gms_internal_zzhi.zzIM));
        }
        hashMap.put("gnt", Integer.valueOf(com_google_android_gms_internal_zzhi.zzIN));
        hashMap.put("pt", Integer.valueOf(com_google_android_gms_internal_zzhi.zzIO));
        hashMap.put("rm", Integer.valueOf(com_google_android_gms_internal_zzhi.zzIP));
        hashMap.put("riv", Integer.valueOf(com_google_android_gms_internal_zzhi.zzIQ));
        Bundle bundle = new Bundle();
        bundle.putString("build", com_google_android_gms_internal_zzhi.zzIV);
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("is_charging", com_google_android_gms_internal_zzhi.zzIS);
        bundle2.putDouble("battery_level", com_google_android_gms_internal_zzhi.zzIR);
        bundle.putBundle("battery", bundle2);
        bundle2 = new Bundle();
        bundle2.putInt("active_network_state", com_google_android_gms_internal_zzhi.zzIU);
        bundle2.putBoolean("active_network_metered", com_google_android_gms_internal_zzhi.zzIT);
        if (com_google_android_gms_internal_zzhm_zza != null) {
            Bundle bundle3 = new Bundle();
            bundle3.putInt("predicted_latency_micros", com_google_android_gms_internal_zzhm_zza.zzJa);
            bundle3.putLong("predicted_down_throughput_bps", com_google_android_gms_internal_zzhm_zza.zzJb);
            bundle3.putLong("predicted_up_throughput_bps", com_google_android_gms_internal_zzhm_zza.zzJc);
            bundle2.putBundle("predictions", bundle3);
        }
        bundle.putBundle("network", bundle2);
        hashMap.put("device", bundle);
    }

    private static void zza(HashMap<String, Object> hashMap, String str) {
        if (str != null) {
            Map hashMap2 = new HashMap();
            hashMap2.put("token", str);
            hashMap.put("pan", hashMap2);
        }
    }

    private static String zzc(NativeAdOptionsParcel nativeAdOptionsParcel) {
        switch (nativeAdOptionsParcel != null ? nativeAdOptionsParcel.zzyd : 0) {
            case 1:
                return "portrait";
            case 2:
                return "landscape";
            default:
                return "any";
        }
    }

    private static Integer zzy(boolean z) {
        return Integer.valueOf(z ? 1 : 0);
    }
}
