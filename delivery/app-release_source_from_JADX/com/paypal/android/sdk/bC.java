package com.paypal.android.sdk;

public enum bC {
    AMEX,
    DINERSCLUB,
    DISCOVER,
    JCB,
    MASTERCARD,
    VISA,
    MAESTRO,
    UNKNOWN,
    INSUFFICIENT_DIGITS;

    public static bC m186a(String str) {
        if (str == null) {
            return UNKNOWN;
        }
        for (bC bCVar : values()) {
            if (bCVar != UNKNOWN && bCVar != INSUFFICIENT_DIGITS && str.equalsIgnoreCase(bCVar.toString())) {
                return bCVar;
            }
        }
        return UNKNOWN;
    }
}
