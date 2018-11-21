package com.paypal.android.sdk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class C0514j {
    private static final String f676a = C0514j.class.getSimpleName();
    private static final Map f677b = new HashMap();
    private static final Set f678c = new HashSet();
    private static /* synthetic */ boolean f679g = (!C0514j.class.desiredAssertionStatus());
    private Map f680d = new LinkedHashMap();
    private C0515k f681e;
    private Class f682f;

    static {
        f677b.put("zh_CN", "zh-Hans");
        f677b.put("zh_TW", "zh-Hant_TW");
        f677b.put("zh_HK", "zh-Hant");
        f677b.put("en_UK", "en_GB");
        f677b.put("en_IE", "en_GB");
        f677b.put("iw_IL", "he");
        f677b.put("no", "nb");
        f678c.add("he");
        f678c.add("ar");
    }

    public C0514j(Class cls, List list) {
        this.f682f = cls;
        for (C0515k c0515k : list) {
            String a = c0515k.mo3720a();
            if (a == null) {
                throw new RuntimeException("Null localeName");
            } else if (this.f680d.containsKey(a)) {
                throw new RuntimeException("Locale " + a + " already added");
            } else {
                this.f680d.put(a, c0515k);
                m478b(a);
            }
        }
        m483a(null);
    }

    private void m478b(String str) {
        C0515k c0515k = (C0515k) this.f680d.get(str);
        List arrayList = new ArrayList();
        new StringBuilder("Checking locale ").append(str);
        for (Enum enumR : (Enum[]) this.f682f.getEnumConstants()) {
            String str2 = "[" + str + "," + enumR + "]";
            if (c0515k.mo3721a(enumR, null) == null) {
                arrayList.add("Missing " + str2);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    private C0515k m479c(String str) {
        C0515k c0515k = null;
        if (str == null || str.length() < 2) {
            return null;
        }
        if (f677b.containsKey(str)) {
            String str2 = (String) f677b.get(str);
            C0515k c0515k2 = (C0515k) this.f680d.get(str2);
            new StringBuilder("Overriding locale specifier ").append(str).append(" with ").append(str2);
            c0515k = c0515k2;
        }
        if (c0515k == null) {
            c0515k = (C0515k) this.f680d.get(str.contains("_") ? str : str + "_" + Locale.getDefault().getCountry());
        }
        if (c0515k == null) {
            c0515k = (C0515k) this.f680d.get(str);
        }
        if (c0515k != null) {
            return c0515k;
        }
        return (C0515k) this.f680d.get(str.substring(0, 2));
    }

    public final String m480a() {
        return this.f681e.mo3720a();
    }

    public final String m481a(Enum enumR) {
        C0515k c0515k = this.f681e;
        String toUpperCase = Locale.getDefault().getCountry().toUpperCase(Locale.US);
        String a = c0515k.mo3721a(enumR, toUpperCase);
        if (a == null) {
            new StringBuilder("Missing localized string for [").append(this.f681e.mo3720a()).append(",Key.").append(enumR.toString()).append("]");
            a = ((C0515k) this.f680d.get("en")).mo3721a(enumR, toUpperCase);
        }
        if (a != null) {
            return a;
        }
        new StringBuilder("Missing localized string for [en,Key.").append(enumR.toString()).append("], so defaulting to keyname");
        return enumR.toString();
    }

    public final String m482a(String str, Enum enumR) {
        String a = this.f681e.mo3722a(str);
        if (a != null) {
            return a;
        }
        return String.format(m481a(enumR), new Object[]{str});
    }

    public final void m483a(String str) {
        C0515k c0515k = null;
        new StringBuilder("setLanguage(").append(str).append(")");
        this.f681e = null;
        if (str != null) {
            c0515k = m479c(str);
        }
        if (c0515k == null) {
            String locale = Locale.getDefault().toString();
            new StringBuilder().append(str).append(" not found.  Attempting to look for ").append(locale);
            c0515k = m479c(locale);
        }
        if (c0515k == null) {
            c0515k = (C0515k) this.f680d.get("en");
        }
        if (f679g || c0515k != null) {
            this.f681e = c0515k;
            if (f679g || this.f681e != null) {
                new StringBuilder("setting locale to:").append(this.f681e.mo3720a());
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }
}
