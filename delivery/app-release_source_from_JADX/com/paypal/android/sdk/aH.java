package com.paypal.android.sdk;

public class aH extends aF {
    public aH(aG aGVar, Exception exception) {
        this(aGVar.toString(), (Throwable) exception);
    }

    public aH(String str) {
        super("RequestError", str);
    }

    public aH(String str, String str2, String str3) {
        super("RequestError", str, str2, str3);
    }

    public aH(String str, Throwable th) {
        super(th.getClass().toString(), str, th.toString(), th.getMessage());
    }
}
