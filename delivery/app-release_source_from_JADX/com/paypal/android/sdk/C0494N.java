package com.paypal.android.sdk;

import com.google.android.gms.common.Scopes;
import java.util.Collection;

public enum C0494N {
    FUTURE_PAYMENTS("https://uri.paypal.com/services/payments/futurepayments", false),
    PROFILE(Scopes.PROFILE, true),
    PAYPAL_ATTRIBUTES("https://uri.paypal.com/services/paypalattributes", true),
    OPENID("openid", true),
    EMAIL("email", true),
    ADDRESS("address", true),
    PHONE("phone", true),
    GET_FUNDING_OPTIONS("https://uri.paypal.com/services/payments/funding-options", false),
    PAYMENT_CODE("https://uri.paypal.com/services/pos/payments", false),
    MIS_CUSTOMER("https://uri.paypal.com/services/mis/customer", false),
    FINANCIAL_INSTRUMENTS("https://uri.paypal.com/services/wallet/financial-instruments/view", false),
    SEND_MONEY("https://uri.paypal.com/services/wallet/sendmoney", false),
    REQUEST_MONEY("https://uri.paypal.com/services/wallet/money-request/requests", false),
    LOYALTY("https://uri.paypal.com/services/loyalty/memberships/update", false),
    EXPRESS_CHECKOUT("https://uri.paypal.com/services/expresscheckout", false);
    
    public static final Collection f17p = null;
    public static final Collection f18q = null;
    private String f20r;
    private boolean f21s;

    static {
        f17p = new C0495O();
        f18q = new C0496P();
    }

    private C0494N(String str, boolean z) {
        this.f20r = str;
        this.f21s = z;
    }

    public final String m16a() {
        return this.f20r;
    }
}
