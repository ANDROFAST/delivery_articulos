package com.paypal.android.sdk;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ce extends cm {
    public String f1369a;
    private List f1370b;
    private String f1371c;

    public ce(bn bnVar, C0507c c0507c, String str, String str2, String str3, String str4, List list) {
        super(bs.ConsentRequest, bnVar, c0507c, cm.m1220b(str, str2));
        this.f1369a = str3;
        this.f1371c = str4;
        this.f1370b = list;
    }

    public final String mo3749b() {
        Map hashMap = new HashMap();
        hashMap.put("code", this.f1369a);
        hashMap.put("nonce", this.f1371c);
        hashMap.put("scope", TextUtils.join(" ", this.f1370b));
        return C0510f.m453a(hashMap);
    }

    public final void mo3750c() {
    }

    public final void mo3751d() {
        m1221b(m280n());
    }

    public final String mo3752e() {
        return "{\"code\":\"EOTHbvqh0vwM2ldM2QIXbjVw0hZNuZEJLqdWmfTBLLSvGfqgyy9GKvjGybIxyGMd7gHXCXVtymqFQHS-J-4-Ir6u2LUVVdyLKonwTtdFw9qhBaMb4NZuZHKS0bGxdZlRAB3_Fk8HX2r3z8j03xScx4M\",\"scope\":\"https://uri.paypal.com/services/payments/futurepayments\"}";
    }
}
