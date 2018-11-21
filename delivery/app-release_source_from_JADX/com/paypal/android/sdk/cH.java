package com.paypal.android.sdk;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class cH implements Iterable {
    private List f481a = new ArrayList();
    private int f482b;

    static {
        cH.class.getSimpleName();
    }

    public cH(JSONArray jSONArray, JSONObject jSONObject) {
        for (int i = 0; i < jSONArray.length(); i++) {
            Object a;
            try {
                a = cG.m356a(jSONArray.getJSONObject(i));
            } catch (JSONException e) {
                Log.w("paypal.sdk", "Error extracting funding source: " + e.getMessage());
                a = null;
            }
            if (a != null) {
                this.f481a.add(a);
            }
        }
        if (jSONObject != null) {
            Object a2;
            try {
                a2 = cG.m356a(jSONObject);
            } catch (JSONException e2) {
                Log.w("paypal.sdk", "Error parsing backup funding instrument: " + e2.getMessage());
                a2 = null;
            }
            if (a2 != null) {
                this.f481a.add(a2);
            }
        }
        this.f482b = m364f();
    }

    private int m364f() {
        Double valueOf = Double.valueOf(0.0d);
        int i = 0;
        for (int i2 = 0; i2 < this.f481a.size(); i2++) {
            if (((cG) this.f481a.get(i2)).m361d().doubleValue() > valueOf.doubleValue()) {
                valueOf = ((cG) this.f481a.get(i2)).m361d();
                i = i2;
            }
        }
        return i;
    }

    public final cG m365a(int i) {
        this.f481a.size();
        return (cG) this.f481a.get(0);
    }

    public final String m366a() {
        return ((cG) this.f481a.get(this.f482b)).m358a();
    }

    public final boolean m367b() {
        CharSequence f = ((cG) this.f481a.get(this.f482b)).m363f();
        return C0510f.m467d(f) ? f.toUpperCase().equals("DELAYED_TRANSFER") : false;
    }

    public final String m368c() {
        return this.f481a.size() == 1 ? ((cG) this.f481a.get(0)).m359b() : cz.m428a(cB.AND_OTHER_FUNDING_SOURCES);
    }

    public final String m369d() {
        return ((cG) this.f481a.get(this.f482b)).m362e();
    }

    public final int m370e() {
        return this.f481a.size();
    }

    public final Iterator iterator() {
        return this.f481a.iterator();
    }
}
