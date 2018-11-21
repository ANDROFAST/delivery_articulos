package com.paypal.android.sdk;

public abstract class aF {
    private String f131a;
    private String f132b;

    private aF(String str) {
    }

    protected aF(String str, String str2) {
        this(str);
        this.f131a = str2;
        this.f132b = null;
    }

    protected aF(String str, String str2, String str3, String str4) {
        this(str);
        this.f131a = str2;
        this.f132b = str3;
    }

    public final String m86a() {
        return this.f132b;
    }

    public final String m87b() {
        return this.f131a;
    }

    public String toString() {
        return "ErrorBase[errorCode=" + this.f131a + " errorMsgShort=" + this.f132b + "]";
    }
}
