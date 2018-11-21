package com.paypal.android.sdk;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class bQ {
    private static final HashMap f287a = new bR();
    private static Map f288b;

    static {
        bQ.class.getSimpleName();
    }

    public static JSONObject m224a() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str : f288b.keySet()) {
                jSONObject.put(str, f288b.get(str));
            }
            return jSONObject;
        } catch (Throwable e) {
            Log.e("paypal.sdk", "Error encoding JSON", e);
            return null;
        }
    }

    public static void m225a(C0506b c0506b) {
        if (f288b == null) {
            Map hashMap = new HashMap();
            f288b = hashMap;
            hashMap.put("device_identifier", C0510f.m452a(c0506b.m184e()));
            f288b.put("device_type", "Android");
            f288b.put("device_name", C0510f.m452a(Build.DEVICE));
            f288b.put("device_model", C0510f.m452a(Build.MODEL));
            Map map = f288b;
            String str = "device_key_type";
            Object obj = (String) f287a.get(Integer.valueOf(c0506b.m179b()));
            if (TextUtils.isEmpty(obj)) {
                obj = "ANDROIDGSM_UNDEFINED";
            }
            map.put(str, obj);
            f288b.put("device_os", "Android");
            f288b.put("device_os_version", C0510f.m452a(VERSION.RELEASE));
            map = f288b;
            str = "is_device_simulator";
            boolean z = Build.PRODUCT.equals("sdk") || Build.PRODUCT.equals("google_sdk") || Build.FINGERPRINT.contains("generic");
            map.put(str, Boolean.toString(z));
        }
    }
}
