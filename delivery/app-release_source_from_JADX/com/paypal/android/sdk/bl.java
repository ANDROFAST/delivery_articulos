package com.paypal.android.sdk;

public abstract class bl extends bm {
    static {
        bl.class.getSimpleName();
    }

    public bl(bk bkVar, bn bnVar, C0507c c0507c, String str) {
        this(bkVar, bnVar, c0507c, str, null);
    }

    public bl(bk bkVar, bn bnVar, C0507c c0507c, String str, String str2) {
        super(bkVar, bnVar, c0507c, str2);
        m264a("Authorization", str);
        m264a("User-Agent", m273f().mo3787b());
    }
}
