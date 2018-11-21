package com.paypal.android.sdk;

import java.util.UUID;

public final class bt {
    public bI f384a = new bI();
    public cu f385b = new cu();
    public bD f386c;
    public String f387d;
    public bw f388e;
    public bF f389f;
    public bK f390g;
    public bD f391h;
    public boolean f392i;
    public String f393j;
    private String f394k;

    public bt() {
        m331a();
    }

    public final void m331a() {
        this.f394k = UUID.randomUUID().toString();
    }

    public final String m332b() {
        return this.f394k;
    }

    public final boolean m333c() {
        return this.f386c != null && this.f386c.m190c();
    }

    public final String toString() {
        return "BackendState(accessTokenState:" + this.f386c + " loginAccessToken:" + this.f391h + ")";
    }
}
