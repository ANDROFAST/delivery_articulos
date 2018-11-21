package com.paypal.android.sdk;

import android.util.Log;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public abstract class bm {
    private static final String f319a = bm.class.getSimpleName();
    private static long f320j = 1;
    private String f321b;
    private String f322c;
    private Map f323d;
    private final bn f324e;
    private final C0507c f325f;
    private bk f326g;
    private String f327h;
    private aF f328i;
    private long f329k;
    private Integer f330l;
    private String f331m;

    public bm(bk bkVar, bn bnVar, C0507c c0507c) {
        this(bkVar, bnVar, c0507c, null);
    }

    public bm(bk bkVar, bn bnVar, C0507c c0507c, String str) {
        long j = f320j;
        f320j = 1 + j;
        this.f329k = j;
        this.f326g = bkVar;
        this.f327h = str;
        this.f324e = bnVar;
        this.f325f = c0507c;
        this.f323d = new LinkedHashMap();
    }

    public static void m259l() {
    }

    public String mo3747a(bk bkVar) {
        String a = this.f324e.mo3727a(bkVar);
        if (a != null) {
            return this.f327h != null ? a + this.f327h : a;
        } else {
            throw new RuntimeException("API " + bkVar.toString() + " has no record for server " + this.f324e.mo3729c());
        }
    }

    public final void m261a(aF aFVar) {
        if (this.f328i != null) {
            Throwable illegalStateException = new IllegalStateException("Multiple exceptions reported");
            Log.e(f319a, "first error=" + this.f328i);
            Log.e(f319a, "second error=" + aFVar);
            Log.e(f319a, "", illegalStateException);
            throw illegalStateException;
        }
        this.f328i = aFVar;
    }

    public final void m262a(Integer num) {
        this.f330l = num;
    }

    public final void m263a(String str) {
        this.f321b = str;
    }

    protected final void m264a(String str, String str2) {
        this.f323d.put(str, str2);
    }

    public final void m265a(String str, String str2, String str3) {
        m261a(new aH(str, str2, str3));
    }

    public boolean mo3748a() {
        return false;
    }

    public abstract String mo3749b();

    public final void m268b(String str) {
        this.f322c = str;
    }

    public abstract void mo3750c();

    public final void m270c(String str) {
        this.f331m = str;
    }

    public abstract void mo3751d();

    public abstract String mo3752e();

    public final C0507c m273f() {
        return this.f325f;
    }

    public final String m274g() {
        return this.f321b;
    }

    public final String m275h() {
        return this.f322c;
    }

    public final bk m276i() {
        return this.f326g;
    }

    public final Map m277j() {
        return this.f323d;
    }

    public final String m278k() {
        return this.f331m;
    }

    public void mo4817m() {
    }

    protected final JSONObject m280n() {
        String str = this.f322c;
        Object nextValue = new JSONTokener(str).nextValue();
        if (nextValue instanceof JSONObject) {
            return (JSONObject) nextValue;
        }
        throw new JSONException("could not parse:" + str + "\nnextValue:" + nextValue);
    }

    public final String m281o() {
        return getClass().getSimpleName() + " SN:" + this.f329k;
    }

    public final long m282p() {
        return this.f329k;
    }

    public final aF m283q() {
        return this.f328i;
    }

    public final boolean m284r() {
        return this.f328i == null;
    }

    public final Integer m285s() {
        return this.f330l;
    }

    public final bn m286t() {
        return this.f324e;
    }
}
