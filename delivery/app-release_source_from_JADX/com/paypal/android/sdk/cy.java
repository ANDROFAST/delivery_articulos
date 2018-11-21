package com.paypal.android.sdk;

public enum cy {
    PreConnect("preconnect", "", false, false),
    DeviceCheck("devicecheck", "", false, false),
    PaymentMethodWindow("selectpaymentmethod", "", false, false),
    PaymentMethodCancel("selectpaymentmethod", "cancel", false, true),
    SelectPayPalPayment("selectpaymentmethod", "paypal", false, true),
    SelectCreditCardPayment("selectpaymentmethod", "card", false, true),
    ConfirmPaymentWindow("confirmpayment", "", false, false),
    ConfirmPayment("confirmpayment", "confirm", false, false),
    ConfirmPaymentCancel("confirmpayment", "cancel", false, true),
    PaymentSuccessful("paymentsuccessful", "", false, false),
    LoginWindow("login", "password", true, false),
    LoginPassword("login", "password", true, true),
    LoginPIN("login", "PIN", true, true),
    SignUp("login", "password", true, true),
    LoginForgotPassword("login", "password", true, true),
    LoginCancel("login", "cancel", true, true),
    ConsentWindow("authorizationconsent", "", false, false),
    ConsentAgree("authorizationconsent", "agree", false, true),
    ConsentCancel("authorizationconsent", "cancel", false, true),
    ConsentMerchantUrl("authorizationconsent", "merchanturl", false, true),
    ConsentPayPalPrivacyUrl("authorizationconsent", "privacy", false, true),
    AuthorizationSuccessful("authorizationsuccessful", "", false, false),
    LegalTextWindow("legaltext", "", false, false);
    
    private boolean f618A;
    private String f619x;
    private String f620y;
    private boolean f621z;

    private cy(String str, String str2, boolean z, boolean z2) {
        this.f619x = str;
        this.f620y = str2;
        this.f621z = z;
        this.f618A = z2;
    }

    public final String m425a() {
        return this.f619x + "::" + this.f620y;
    }

    public final String m426a(String str, boolean z) {
        String str2 = this.f621z ? z ? "returnuser" : "newuser" : "";
        return cw.f586a + ":" + str + ":" + str2;
    }

    public final boolean m427b() {
        return this.f618A;
    }
}
