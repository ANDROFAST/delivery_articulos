package com.paypal.android.sdk;

import android.location.Location;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class C0502X {
    public String f36A;
    public String f37B;
    public Boolean f38C;
    public String f39D;
    public String f40E;
    public Boolean f41F;
    public String f42G;
    public String f43H;
    public long f44I;
    public long f45J;
    public String f46K;
    public int f47L = -1;
    public int f48M = -1;
    public String f49N;
    public int f50O = -1;
    public String f51P;
    public Boolean f52Q;
    public Boolean f53R;
    public String f54S;
    public long f55T;
    public long f56U;
    public String f57V;
    public String f58W;
    public String f59X;
    public String f60Y;
    public String f61Z;
    public String f62a;
    public String aa;
    public String ab;
    public Map ac;
    private String ad = "full";
    public String f63b;
    public String f64c;
    public int f65d = -1;
    public String f66e;
    public int f67f = -1;
    public String f68g;
    public String f69h;
    public String f70i;
    public String f71j;
    public String f72k;
    public String f73l;
    public String f74m;
    public long f75n = -1;
    public String f76o;
    public List f77p;
    public List f78q;
    public String f79r;
    public String f80s;
    public String f81t;
    public String f82u;
    public Location f83v;
    public int f84w = -1;
    public String f85x;
    public String f86y = "Android";
    public String f87z;

    private static JSONObject m46a(Location location) {
        if (location == null) {
            return null;
        }
        try {
            return new JSONObject("{\"lat\":" + location.getLatitude() + ",\"lng\":" + location.getLongitude() + ",\"acc\":" + location.getAccuracy() + ",\"timestamp\":" + location.getTime() + "}");
        } catch (JSONException e) {
            return null;
        }
    }

    private void m47a(JSONObject jSONObject) {
        if (this.ac != null) {
            for (Entry entry : this.ac.entrySet()) {
                try {
                    jSONObject.put((String) entry.getKey(), entry.getValue());
                } catch (Throwable e) {
                    at.m155a(null, null, e);
                }
            }
        }
    }

    public final JSONObject m48a() {
        Object obj = null;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_guid", this.f62a);
            jSONObject.put("app_id", this.f63b);
            jSONObject.put("app_version", this.f64c);
            jSONObject.put("base_station_id", this.f65d == -1 ? null : Integer.valueOf(this.f65d));
            jSONObject.put("bssid", this.f66e);
            jSONObject.put("cell_id", this.f67f == -1 ? null : Integer.valueOf(this.f67f));
            jSONObject.put("comp_version", this.f68g);
            jSONObject.put("conf_url", this.f69h);
            jSONObject.put("conf_version", this.f70i);
            jSONObject.put("conn_type", this.f71j);
            jSONObject.put("device_id", this.f72k);
            jSONObject.put("device_model", this.f73l);
            jSONObject.put("device_name", this.f74m);
            jSONObject.put("device_uptime", this.f75n == -1 ? null : Long.valueOf(this.f75n));
            jSONObject.put("ip_addrs", this.f76o);
            jSONObject.put("ip_addresses", this.f77p == null ? null : new JSONArray(this.f77p));
            jSONObject.put("known_apps", this.f78q == null ? null : new JSONArray(this.f78q));
            jSONObject.put("line_1_number", "".equals(this.f79r) ? null : this.f79r);
            jSONObject.put("linker_id", this.f80s);
            jSONObject.put("locale_country", this.f81t);
            jSONObject.put("locale_lang", this.f82u);
            jSONObject.put("location", C0502X.m46a(this.f83v));
            jSONObject.put("location_area_code", this.f84w == -1 ? null : Integer.valueOf(this.f84w));
            jSONObject.put("mac_addrs", this.f85x);
            jSONObject.put("os_type", this.f86y);
            jSONObject.put("os_version", this.f87z);
            jSONObject.put("payload_type", this.ad);
            jSONObject.put("phone_type", this.f36A);
            jSONObject.put("risk_comp_session_id", this.f37B);
            jSONObject.put("roaming", this.f38C);
            jSONObject.put("sim_operator_name", "".equals(this.f39D) ? null : this.f39D);
            jSONObject.put("sim_serial_number", this.f40E);
            jSONObject.put("sms_enabled", this.f41F);
            jSONObject.put("ssid", this.f42G);
            jSONObject.put("cdma_network_id", this.f48M == -1 ? null : Integer.valueOf(this.f48M));
            jSONObject.put("cdma_system_id", this.f47L == -1 ? null : Integer.valueOf(this.f47L));
            jSONObject.put("subscriber_id", this.f43H);
            jSONObject.put("timestamp", this.f44I);
            jSONObject.put("total_storage_space", this.f45J);
            jSONObject.put("tz_name", this.f46K);
            jSONObject.put("network_operator", this.f49N);
            String str = "source_app";
            if (this.f50O != -1) {
                obj = Integer.valueOf(this.f50O);
            }
            jSONObject.put(str, obj);
            jSONObject.put("source_app_version", this.f51P);
            jSONObject.put("is_emulator", this.f52Q);
            jSONObject.put("is_rooted", this.f53R);
            jSONObject.put("pairing_id", this.f54S);
            jSONObject.put("app_first_install_time", this.f55T);
            jSONObject.put("app_last_update_time", this.f56U);
            jSONObject.put("android_id", this.f57V);
            jSONObject.put("serial_number", this.f60Y);
            jSONObject.put("advertising_identifier", this.f58W);
            jSONObject.put("notif_token", this.f59X);
            jSONObject.put("bluetooth_mac_addrs", null);
            jSONObject.put("gsf_id", this.f61Z);
            jSONObject.put("VPN_setting", this.ab);
            jSONObject.put("proxy_setting", this.aa);
            m47a(jSONObject);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public final JSONObject m49a(C0502X c0502x) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("is_emulator", c0502x.f52Q);
            jSONObject.put("is_rooted", c0502x.f53R);
            jSONObject.put("app_guid", c0502x.f62a);
            jSONObject.put("risk_comp_session_id", c0502x.f37B);
            jSONObject.put("timestamp", c0502x.f44I);
            jSONObject.put("payload_type", "incremental");
            jSONObject.put("source_app", c0502x.f50O);
            jSONObject.put("pairing_id", c0502x.f54S);
            m47a(jSONObject);
            if (!(this.f63b == null || this.f63b.equals(c0502x.f63b))) {
                jSONObject.put("app_id", c0502x.f63b);
            }
            if (!(this.f64c == null || this.f64c.equals(c0502x.f64c))) {
                jSONObject.put("app_version", c0502x.f64c);
            }
            if (this.f65d != c0502x.f65d) {
                jSONObject.put("base_station_id", c0502x.f65d);
            }
            if (!(this.f66e == null || this.f66e.equals(c0502x.f66e))) {
                jSONObject.put("bssid", c0502x.f66e);
            }
            if (this.f67f != c0502x.f67f) {
                jSONObject.put("cell_id", c0502x.f67f);
            }
            if (!(this.f68g == null || this.f68g.equals(c0502x.f68g))) {
                jSONObject.put("comp_version", c0502x.f68g);
            }
            if (!(this.f70i == null || this.f70i.equals(c0502x.f70i))) {
                jSONObject.put("conf_version", c0502x.f70i);
            }
            if (!(this.f69h == null || this.f69h.equals(c0502x.f69h))) {
                jSONObject.put("conf_url", c0502x.f69h);
            }
            if (!(this.f71j == null || this.f71j.equals(c0502x.f71j))) {
                jSONObject.put("conn_type", c0502x.f71j);
            }
            if (!(this.f72k == null || this.f72k.equals(c0502x.f72k))) {
                jSONObject.put("device_id", c0502x.f72k);
            }
            if (!(this.f73l == null || this.f73l.equals(c0502x.f73l))) {
                jSONObject.put("device_model", c0502x.f73l);
            }
            if (!(this.f74m == null || this.f74m.equals(c0502x.f74m))) {
                jSONObject.put("device_name", c0502x.f74m);
            }
            if (this.f75n != c0502x.f75n) {
                jSONObject.put("device_uptime", c0502x.f75n);
            }
            if (!(this.f76o == null || this.f76o.equals(c0502x.f76o))) {
                jSONObject.put("ip_addrs", c0502x.f76o);
            }
            if (!(this.f77p == null || c0502x.f77p == null || this.f77p.toString().equals(c0502x.f77p.toString()))) {
                jSONObject.put("ip_addresses", new JSONArray(c0502x.f77p));
            }
            if (!(this.f78q == null || c0502x.f78q == null || this.f78q.toString().equals(c0502x.f78q.toString()))) {
                jSONObject.put("known_apps", new JSONArray(c0502x.f78q));
            }
            if (!(this.f79r == null || this.f79r.equals(c0502x.f79r))) {
                jSONObject.put("line_1_number", c0502x.f79r);
            }
            if (!(this.f80s == null || this.f80s.equals(c0502x.f80s))) {
                jSONObject.put("linker_id", c0502x.f80s);
            }
            if (!(this.f81t == null || this.f81t.equals(c0502x.f81t))) {
                jSONObject.put("locale_country", c0502x.f81t);
            }
            if (!(this.f82u == null || this.f82u.equals(c0502x.f82u))) {
                jSONObject.put("locale_lang", c0502x.f82u);
            }
            if (!(this.f83v == null || c0502x.f83v == null || this.f83v.toString().equals(c0502x.f83v.toString()))) {
                jSONObject.put("location", C0502X.m46a(c0502x.f83v));
            }
            if (this.f84w != c0502x.f84w) {
                jSONObject.put("location_area_code", c0502x.f84w);
            }
            if (!(this.f85x == null || this.f85x.equals(c0502x.f85x))) {
                jSONObject.put("mac_addrs", c0502x.f85x);
            }
            if (!(this.f86y == null || this.f86y.equals(c0502x.f86y))) {
                jSONObject.put("os_type", c0502x.f86y);
            }
            if (!(this.f87z == null || this.f87z.equals(c0502x.f87z))) {
                jSONObject.put("os_version", c0502x.f87z);
            }
            if (!(this.f36A == null || this.f36A.equals(c0502x.f36A))) {
                jSONObject.put("phone_type", c0502x.f36A);
            }
            if (this.f38C != null && this.f38C.equals(c0502x.f38C)) {
                jSONObject.put("roaming", c0502x.f38C);
            }
            if (!(this.f39D == null || this.f39D.equals(c0502x.f39D))) {
                jSONObject.put("sim_operator_name", c0502x.f39D);
            }
            if (!(this.f40E == null || this.f40E.equals(c0502x.f40E))) {
                jSONObject.put("sim_serial_number", c0502x.f40E);
            }
            if (this.f41F != null && this.f41F.equals(c0502x.f41F)) {
                jSONObject.put("sms_enabled", c0502x.f41F);
            }
            if (!(this.f42G == null || this.f42G.equals(c0502x.f42G))) {
                jSONObject.put("ssid", c0502x.f42G);
            }
            if (this.f48M != c0502x.f48M) {
                jSONObject.put("cdma_network_id", c0502x.f48M);
            }
            if (this.f47L != c0502x.f47L) {
                jSONObject.put("cdma_system_id", c0502x.f47L);
            }
            if (!(this.f43H == null || this.f43H.equals(c0502x.f43H))) {
                jSONObject.put("subscriber_id", c0502x.f43H);
            }
            if (this.f45J != c0502x.f45J) {
                jSONObject.put("total_storage_space", c0502x.f45J);
            }
            if (!(this.f46K == null || this.f46K.equals(c0502x.f46K))) {
                jSONObject.put("tz_name", c0502x.f46K);
            }
            if (!(this.f49N == null || this.f49N.equals(c0502x.f49N))) {
                jSONObject.put("network_operator", c0502x.f49N);
            }
            if (!(this.f51P == null || this.f51P.equals(c0502x.f51P))) {
                jSONObject.put("source_app_version", c0502x.f51P);
            }
            if (this.f55T != c0502x.f55T) {
                jSONObject.put("app_first_install_time", c0502x.f55T);
            }
            if (this.f56U != c0502x.f56U) {
                jSONObject.put("app_last_update_time", c0502x.f56U);
            }
            if (!(this.f57V == null || this.f57V.equals(c0502x.f57V))) {
                jSONObject.put("android_id", c0502x.f57V);
            }
            if (!(this.f60Y == null || this.f60Y.equals(c0502x.f60Y))) {
                jSONObject.put("serial_number", c0502x.f60Y);
            }
            if (!(this.f58W == null || this.f58W.equals(c0502x.f58W))) {
                jSONObject.put("advertising_identifier", c0502x.f58W);
            }
            if (!(this.f59X == null || this.f59X.equals(c0502x.f59X))) {
                jSONObject.put("notif_token", c0502x.f59X);
            }
            if (!(this.f61Z == null || this.f61Z.equals(c0502x.f61Z))) {
                jSONObject.put("gsf_id", c0502x.f61Z);
            }
            if (!(this.ab == null || this.ab.equals(c0502x.ab))) {
                jSONObject.put("VPN_setting", c0502x.ab);
            }
            if (!(this.aa == null || this.aa.equals(c0502x.aa))) {
                jSONObject.put("proxy_setting", c0502x.aa);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
