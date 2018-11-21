package com.paypal.android.sdk;

public enum bs {
    SiteCatalystRequest(aJ.GET, null),
    FptiRequest(aJ.POST, null),
    PreAuthRequest(aJ.POST, "oauth2/token"),
    LoginRequest(aJ.POST, "oauth2/login"),
    LoginChallengeRequest(aJ.POST, "oauth2/login/challenge"),
    ConsentRequest(aJ.POST, "oauth2/consent"),
    CreditCardPaymentRequest(aJ.POST, "payments/payment"),
    PayPalPaymentRequest(aJ.POST, "payments/payment"),
    CreateSfoPaymentRequest(aJ.POST, "orchestration/msdk-create-sfo-payment"),
    ApproveAndExecuteSfoPaymentRequest(aJ.POST, "orchestration/msdk-approve-and-execute-sfo-payment"),
    TokenizeCreditCardRequest(aJ.POST, "vault/credit-card"),
    DeleteCreditCardRequest(aJ.DELETE, "vault/credit-card"),
    GetAppInfoRequest(aJ.GET, "apis/applications");
    
    private aJ f382n;
    private String f383o;

    private bs(aJ aJVar, String str) {
        this.f382n = aJVar;
        this.f383o = str;
    }

    final aJ m329a() {
        return this.f382n;
    }

    final String m330b() {
        return this.f383o;
    }
}
