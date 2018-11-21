package com.paypal.android.sdk;

import android.content.Context;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.nearby.messages.Strategy;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class C0499U {
    private static final String f29a = C0499U.class.getSimpleName();
    private Context f30b;
    private String f31c;
    private JSONObject f32d;

    public C0499U(Context context) {
        this.f30b = context;
        this.f31c = null;
        this.f32d = m19j();
        at.m154a(f29a, "Configuation initialize, dumping config");
        at.m156a(f29a, this.f32d);
    }

    public C0499U(Context context, String str) {
        this(context, str, (byte) 0);
    }

    private C0499U(Context context, String str, byte b) {
        at.m154a(f29a, "entering Configuration url loading");
        this.f30b = context;
        this.f31c = str;
        String o = m24o();
        if ("".equals(o)) {
            throw new IOException("No valid config found for " + str);
        }
        at.m154a(f29a, "entering saveConfigDataToDisk");
        try {
            File file = new File(this.f30b.getFilesDir(), "CONFIG_DATA");
            File file2 = new File(this.f30b.getFilesDir(), "CONFIG_TIME");
            C0510f.m458a(file, o);
            C0510f.m458a(file2, String.valueOf(System.currentTimeMillis()));
            at.m154a(f29a, "leaving saveConfigDataToDisk successfully");
        } catch (IOException e) {
            new StringBuilder("Failed to write config data: ").append(e.toString());
        }
        this.f32d = new JSONObject(o);
        at.m154a(f29a, "leaving Configuration url loading");
    }

    private JSONObject m17a(String str) {
        try {
            at.m154a(f29a, "entering getIncrementalConfig");
            JSONObject jSONObject = new JSONObject(at.m161b(this.f30b, str));
            at.m154a(f29a, "leaving getIncrementalConfig");
            return jSONObject;
        } catch (Throwable e) {
            at.m153a(6, "PRD", "Error while loading prdc Config " + str, e);
            return null;
        }
    }

    private static JSONObject m18a(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            at.m154a(f29a, "entering mergeConfig");
            Iterator keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                at.m154a(f29a, "overridding " + str);
                jSONObject.put(str, jSONObject2.get(str));
            }
            at.m154a(f29a, "leaving mergeConfig");
            return jSONObject;
        } catch (Throwable e) {
            at.m153a(6, "PRD", "Error encountered while applying prdc Config", e);
            return null;
        }
    }

    private JSONObject m19j() {
        try {
            JSONObject l = m21l();
            if (l != null) {
                if (at.m162b(l.optString("conf_version", ""), "3.0")) {
                    if ((System.currentTimeMillis() > Long.parseLong(m27r()) + (l.optLong("conf_refresh_time_interval", 0) * 1000) ? 1 : null) != null) {
                        C0499U.m23n();
                    }
                    at.m154a(f29a, "Using cached config");
                    return l;
                }
                m26q();
            }
            l = C0499U.m20k();
            if (l == null) {
                Log.e(f29a, "default Configuration loading failed,Using hardcoded config");
                return C0499U.m22m();
            }
            String a = at.m150a(this.f30b, "prdc", null);
            if (a == null) {
                C0499U.m23n();
                at.m152a(3, "PRD", "prdc field not configured, using default config");
                return l;
            }
            at.m152a(3, "PRD", "prdc field is configured, loading path:" + a);
            JSONObject a2 = m17a(a);
            if (a2 == null) {
                at.m152a(6, "PRD", "prdc Configuration loading failed, using default config");
                return l;
            }
            a2 = C0499U.m18a(l, a2);
            if (a2 == null) {
                at.m152a(6, "PRD", "applying prdc Configuration failed, using default config");
                return l;
            }
            at.m152a(3, "PRD", "prdc configuration loaded successfully");
            return a2;
        } catch (Throwable e) {
            at.m153a(6, "PRD", "Severe Error while loading config, using hard code version", e);
            return C0499U.m22m();
        }
    }

    private static JSONObject m20k() {
        at.m154a(f29a, "entering getDefaultConfigurations");
        try {
            String str = new String(Base64.decode("eyAiY29uZl92ZXJzaW9uIjogIjMuMCIsImFzeW5jX3VwZGF0ZV90aW1lX2ludGVydmFsIjogMzYwMCwgImZvcmNlZF9mdWxsX3VwZGF0ZV90aW1lX2ludGVydmFsIjogMTgwMCwgImNvbmZfcmVmcmVzaF90aW1lX2ludGVydmFsIjogODY0MDAsICJhbmRyb2lkX2FwcHNfdG9fY2hlY2siOiBbICJjb20uZWJheS5jbGFzc2lmaWVkcy9jb20uZWJheS5hcHAuTWFpblRhYkFjdGl2aXR5IiwgImNvbS5lYmF5Lm1vYmlsZS9jb20uZWJheS5tb2JpbGUuYWN0aXZpdGllcy5lQmF5IiwgImNvbS5lYmF5LnJlZGxhc2VyL2NvbS5lYmF5LnJlZGxhc2VyLlNjYW5uZWRJdGVtc0FjdGl2aXR5IiwgImNvbS5taWxvLmFuZHJvaWQvY29tLm1pbG8uYW5kcm9pZC5hY3Rpdml0eS5Ib21lQWN0aXZpdHkiLCAiY29tLnBheXBhbC5hbmRyb2lkLnAycG1vYmlsZS9jb20ucGF5cGFsLmFuZHJvaWQucDJwbW9iaWxlLmFjdGl2aXR5LlNlbmRNb25leUFjdGl2aXR5IiwgImNvbS5yZW50L2NvbS5yZW50LmFjdGl2aXRpZXMuc2Vzc2lvbi5BY3Rpdml0eUhvbWUiLCAiY29tLnN0dWJodWIvY29tLnN0dWJodWIuQWJvdXQiLCAiY29tLnVsb2NhdGUvY29tLnVsb2NhdGUuYWN0aXZpdGllcy5TZXR0aW5ncyIsICJjb20ubm9zaHVmb3UuYW5kcm9pZC5zdS9jb20ubm9zaHVmb3UuYW5kcm9pZC5zdS5TdSIsICJzdGVyaWNzb24uYnVzeWJveC9zdGVyaWNzb24uYnVzeWJveC5BY3Rpdml0eS5NYWluQWN0aXZpdHkiLCAib3JnLnByb3h5ZHJvaWQvb3JnLnByb3h5ZHJvaWQuUHJveHlEcm9pZCIsICJjb20uYWVkLmRyb2lkdnBuL2NvbS5hZWQuZHJvaWR2cG4uTWFpbkdVSSIsICJuZXQub3BlbnZwbi5vcGVudnBuL25ldC5vcGVudnBuLm9wZW52cG4uT3BlblZQTkNsaWVudCIsICJjb20ucGhvbmVhcHBzOTkuYWFiaXByb3h5L2NvbS5waG9uZWFwcHM5OS5hYWJpcHJveHkuT3Jib3QiLCAiY29tLmV2YW5oZS5wcm94eW1hbmFnZXIucHJvL2NvbS5ldmFuaGUucHJveHltYW5hZ2VyLk1haW5BY3Rpdml0eSIsICJjb20uZXZhbmhlLnByb3h5bWFuYWdlci9jb20uZXZhbmhlLnByb3h5bWFuYWdlci5NYWluQWN0aXZpdHkiLCAiY29tLmFuZHJvbW8uZGV2MzA5MzYuYXBwNzYxOTgvY29tLmFuZHJvbW8uZGV2MzA5MzYuYXBwNzYxOTguQW5kcm9tb0Rhc2hib2FyZEFjdGl2aXR5IiwgImNvbS5tZ3JhbmphLmF1dG9wcm94eV9saXRlL2NvbS5tZ3JhbmphLmF1dG9wcm94eV9saXRlLlByb3h5TGlzdEFjdGl2aXR5IiwgImNvbS52cG5vbmVjbGljay5hbmRyb2lkL2NvbS52cG5vbmVjbGljay5hbmRyb2lkLk1haW5BY3Rpdml0eSIsICJuZXQuaGlkZW1hbi9uZXQuaGlkZW1hbi5TdGFydGVyQWN0aXZpdHkiLCAiY29tLmRvZW50ZXIuYW5kcm9pZC52cG4uZml2ZXZwbi9jb20uZG9lbnRlci5hbmRyb2lkLnZwbi5maXZldnBuLkZpdmVWcG4iLCAiY29tLnRpZ2VydnBucy5hbmRyb2lkL2NvbS50aWdlcnZwbnMuYW5kcm9pZC5NYWluQWN0aXZpdHkiLCAiY29tLnBhbmRhcG93LnZwbi9jb20ucGFuZGFwb3cudnBuLlBhbmRhUG93IiwgImNvbS5leHByZXNzdnBuLnZwbi9jb20uZXhwcmVzc3Zwbi52cG4uTWFpbkFjdGl2aXR5IiwgImNvbS5sb25kb250cnVzdG1lZGlhLnZwbi9jb20ubG9uZG9udHJ1c3RtZWRpYS52cG4uVnBuU2VydmljZUFjdGl2aXR5IiwgImZyLm1lbGVjb20uVlBOUFBUUC52MTAxL2ZyLm1lbGVjb20uVlBOUFBUUC52MTAxLlNwbGFzaFNjcmVlbiIsICJjb20uY2hlY2twb2ludC5WUE4vY29tLmNoZWNrcG9pbnQuVlBOLk1haW5IYW5kbGVyIiwgImNvbS50dW5uZWxiZWFyLmFuZHJvaWQvY29tLnR1bm5lbGJlYXIuYW5kcm9pZC5UYmVhck1haW5BY3Rpdml0eSIsICJkZS5ibGlua3Qub3BlbnZwbi9kZS5ibGlua3Qub3BlbnZwbi5NYWluQWN0aXZpdHkiLCAib3JnLmFqZWplLmZha2Vsb2NhdGlvbi9vcmcuYWplamUuZmFrZWxvY2F0aW9uLkZha2UiLCAiY29tLmxleGEuZmFrZWdwcy9jb20ubGV4YS5mYWtlZ3BzLlBpY2tQb2ludCIsICJjb20uZm9yZ290dGVucHJvamVjdHMubW9ja2xvY2F0aW9ucy9jb20uZm9yZ290dGVucHJvamVjdHMubW9ja2xvY2F0aW9ucy5NYWluIiwgImtyLndvb3QwcGlhLmdwcy9rci53b290MHBpYS5ncHMuQ2F0Y2hNZUlmVUNhbiIsICJjb20ubXkuZmFrZS5sb2NhdGlvbi9jb20ubXkuZmFrZS5sb2NhdGlvbi5jb20ubXkuZmFrZS5sb2NhdGlvbiIsICJqcC5uZXRhcnQuYXJzdGFsa2luZy9qcC5uZXRhcnQuYXJzdGFsa2luZy5NeVByZWZlcmVuY2VBY3Rpdml0eSIsICJsb2NhdGlvblBsYXkuR1BTQ2hlYXRGcmVlL2xvY2F0aW9uUGxheS5HUFNDaGVhdEZyZWUuQWN0aXZpdHlTbWFydExvY2F0aW9uIiwgIm9yZy5nb29kZXYubGF0aXR1ZGUvb3JnLmdvb2Rldi5sYXRpdHVkZS5MYXRpdHVkZUFjdGl2aXR5IiwgImNvbS5zY2hlZmZzYmxlbmQuZGV2aWNlc3Bvb2YvY29tLnNjaGVmZnNibGVuZC5kZXZpY2VzcG9vZi5EZXZpY2VTcG9vZkFjdGl2aXR5IiwgImNvbS5wcm94eUJyb3dzZXIvY29tLnByb3h5QnJvd3Nlci5OZXdQcm94eUJyb3dzZXJBY3Rpdml0eSIsICJjb20uaWNlY29sZGFwcHMucHJveHlzZXJ2ZXJwcm8vY29tLmljZWNvbGRhcHBzLnByb3h5c2VydmVycHJvLnZpZXdTdGFydCIsICJob3RzcG90c2hpZWxkLmFuZHJvaWQudnBuL2NvbS5hbmNob3JmcmVlLnVpLkhvdFNwb3RTaGllbGQiLCAiY29tLmRvZW50ZXIub25ldnBuL2NvbS5kb2VudGVyLm9uZXZwbi5WcG5TZXR0aW5ncyIsICJjb20ueWVzdnBuLmVuL2NvbS55ZXN2cG4uTWFpblRhYiIsICJjb20ub2ZmaWNld3l6ZS5wbHV0b3Zwbi9jb20ub2ZmaWNld3l6ZS5wbHV0b3Zwbi5Ib21lQWN0aXZpdHkiLCAib3JnLmFqZWplLmxvY2F0aW9uc3Bvb2ZlcnByby9vcmcuYWplamUubG9jYXRpb25zcG9vZmVycHJvLkZha2UiLCAibG9jYXRpb25QbGF5LkdQU0NoZWF0L2xvY2F0aW9uUGxheS5HUFNDaGVhdC5BY3Rpdml0eVNtYXJ0TG9jYXRpb24iIF0sICJsb2NhdGlvbl9taW5fYWNjdXJhY3kiOiA1MDAsICJsb2NhdGlvbl9tYXhfY2FjaGVfYWdlIjogMTgwMCwgInNlbmRfb25fYXBwX3N0YXJ0IjogMSwgImVuZHBvaW50X3VybCI6ICJodHRwczovL3N2Y3MucGF5cGFsLmNvbS9BY2Nlc3NDb250cm9sL0xvZ1Jpc2tNZXRhZGF0YSIsICJpbnRlcm5hbF9jYWNoZV9tYXhfYWdlIjogMzAsICJjb21wX3RpbWVvdXQiOiA2MDAgfQ==", 0), "UTF-8");
            at.m154a(f29a, "leaving getDefaultConfigurations, Default Conf load succeed");
            return new JSONObject(str);
        } catch (Throwable e) {
            at.m153a(6, "PRD", "Read default config file exception.", e);
            at.m154a(f29a, "leaving getDefaultConfigurations,returning null");
            return null;
        }
    }

    private JSONObject m21l() {
        at.m154a(f29a, "entering getCachedConfiguration");
        try {
            String p = m25p();
            if (!"".equals(p)) {
                at.m154a(f29a, "leaving getCachedConfiguration,cached config load succeed");
                return new JSONObject(p);
            }
        } catch (Throwable e) {
            at.m155a(f29a, "JSON Exception in creating config file", e);
        }
        at.m154a(f29a, "leaving getCachedConfiguration,cached config load failed");
        return null;
    }

    private static JSONObject m22m() {
        at.m154a(f29a, "entering getHardcodedConfig");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("conf_version", "3.0");
            jSONObject.put("async_update_time_interval", 3600);
            jSONObject.put("forced_full_update_time_interval", 1800);
            jSONObject.put("conf_refresh_time_interval", Strategy.TTL_SECONDS_MAX);
            jSONObject.put("location_min_accuracy", 500);
            jSONObject.put("location_max_cache_age", 1800);
            jSONObject.put("endpoint_url", "https://svcs.paypal.com/AccessControl/LogRiskMetadata");
        } catch (JSONException e) {
        }
        at.m154a(f29a, "leaving getHardcodedConfig");
        return jSONObject;
    }

    private static void m23n() {
        at.m154a(f29a, "Loading web config");
        C0503Y.m52a().m75b();
    }

    private String m24o() {
        Throwable th;
        Closeable closeable = null;
        at.m154a(f29a, "entering getRemoteConfig");
        StringBuilder stringBuilder = new StringBuilder();
        Closeable bufferedReader;
        try {
            Closeable openStream = new URL(this.f31c).openStream();
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(openStream, "UTF-8"));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            stringBuilder.append(readLine);
                        } else {
                            C0510f.m457a(openStream);
                            C0510f.m457a(bufferedReader);
                            at.m154a(f29a, "leaving getRemoteConfig successfully");
                            return stringBuilder.toString();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        closeable = openStream;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                closeable = openStream;
                C0510f.m457a(closeable);
                C0510f.m457a(bufferedReader);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            C0510f.m457a(closeable);
            C0510f.m457a(bufferedReader);
            throw th;
        }
    }

    private String m25p() {
        try {
            return C0510f.m451a(new File(this.f30b.getFilesDir(), "CONFIG_DATA"));
        } catch (Throwable e) {
            at.m155a(f29a, "Load cached config failed", e);
            return "";
        }
    }

    private boolean m26q() {
        try {
            at.m154a(f29a, "entering deleteCachedConfigDataFromDisk");
            File file = new File(this.f30b.getFilesDir(), "CONFIG_DATA");
            File file2 = new File(this.f30b.getFilesDir(), "CONFIG_TIME");
            if (file.exists()) {
                at.m154a(f29a, "cached Config Data found, deleting");
                file.delete();
            }
            if (file2.exists()) {
                at.m154a(f29a, "cached Config Time found, deleting");
                file.delete();
            }
            at.m154a(f29a, "leaving deleteCachedConfigDataFromDisk");
            return true;
        } catch (Throwable e) {
            at.m155a(f29a, "error encountered while deleteCachedConfigData", e);
            return false;
        }
    }

    private String m27r() {
        try {
            return C0510f.m451a(new File(this.f30b.getFilesDir(), "CONFIG_TIME"));
        } catch (IOException e) {
            return "";
        }
    }

    public final String m28a() {
        return this.f31c;
    }

    public final String m29b() {
        return this.f32d.optString("conf_version", "");
    }

    public final long m30c() {
        return this.f32d.optLong("async_update_time_interval", 0);
    }

    public final long m31d() {
        return this.f32d.optLong("forced_full_update_time_interval", 0);
    }

    public final long m32e() {
        return this.f32d.optLong("comp_timeout", 0);
    }

    public final List m33f() {
        List arrayList = new ArrayList();
        JSONArray optJSONArray = this.f32d.optJSONArray("android_apps_to_check");
        int i = 0;
        while (optJSONArray != null && i < optJSONArray.length()) {
            arrayList.add(optJSONArray.getString(i));
            i++;
        }
        return arrayList;
    }

    public final String m34g() {
        return this.f32d.optString("endpoint_url", null);
    }

    public final boolean m35h() {
        return this.f32d.optBoolean("endpoint_is_stage", false);
    }

    public final ar m36i() {
        try {
            String optString = this.f32d.optString("CDS", "");
            if (optString == null || "".equals(optString)) {
                at.m152a(3, "PRD", "No CDS is configured, enabling all variables");
                return ar.f197a;
            }
            at.m152a(3, "PRD", "CDS field was found");
            return new ar(optString.trim());
        } catch (Throwable e) {
            at.m153a(6, "PRD", "Failed to decode CDS", e);
            return ar.f197a;
        }
    }
}
