package com.paypal.android.sdk;

public abstract class cd extends bl {
    public cd(bs bsVar, bn bnVar, C0507c c0507c, String str) {
        super(new br(bsVar), bnVar, c0507c, "Bearer " + str);
        m264a("Content-Type", "application/json");
        m264a("Accept", "application/json");
    }
}
