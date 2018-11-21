package com.paypal.android.sdk;

import com.paypal.android.sdk.payments.PayPalPayment;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class cc extends cp {
    private String f1391a;
    private String f1392b;
    private boolean f1393c;
    private JSONObject f1394d;
    private JSONObject f1395e;
    private JSONObject f1396f;
    private String f1397g;
    private String f1398h;
    private String f1399i;
    private String f1400j;

    public cc(bn bnVar, C0507c c0507c, String str, String str2, boolean z, String str3, String str4, String str5, String str6, JSONObject jSONObject, JSONObject jSONObject2) {
        super(bs.ApproveAndExecuteSfoPaymentRequest, bnVar, c0507c, str);
        this.f1393c = z;
        this.f1391a = str5;
        this.f1392b = str6;
        this.f1394d = jSONObject;
        this.f1395e = jSONObject2;
        m264a("PayPal-Request-Id", str2);
        if (C0510f.m467d((CharSequence) str3)) {
            m264a("PayPal-Partner-Attribution-Id", str3);
        }
        if (C0510f.m467d((CharSequence) str4)) {
            m264a("PayPal-Client-Metadata-Id", str4);
        }
    }

    private static String m1249a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        try {
            JSONObject jSONObject = jSONArray.getJSONObject(0);
            if (jSONObject == null) {
                return null;
            }
            JSONArray jSONArray2 = jSONObject.getJSONArray("related_resources");
            if (jSONArray2 == null) {
                return null;
            }
            jSONObject = jSONArray2.getJSONObject(0);
            if (jSONObject == null) {
                return null;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("authorization");
            if (optJSONObject != null) {
                return optJSONObject.optString("id");
            }
            jSONObject = jSONObject.optJSONObject(PayPalPayment.PAYMENT_INTENT_ORDER);
            return jSONObject != null ? jSONObject.optString("id") : null;
        } catch (JSONException e) {
            return null;
        }
    }

    public final String mo3749b() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.accumulate("payment_id", this.f1391a);
        jSONObject.accumulate("session_id", this.f1392b);
        if (this.f1395e != null) {
            jSONObject.accumulate("funding_option", this.f1395e);
        }
        if (this.f1394d != null) {
            jSONObject.accumulate("shipping_address", this.f1394d);
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.accumulate("device_info", C0510f.m452a(bQ.m224a().toString()));
        jSONObject2.accumulate("app_info", C0510f.m452a(bN.m212a().toString()));
        jSONObject2.accumulate("risk_data", C0510f.m452a(C0503Y.m52a().m76c().toString()));
        jSONObject.accumulate("client_info", jSONObject2);
        return jSONObject.toString();
    }

    public final void mo3750c() {
        try {
            this.f1396f = m280n().getJSONObject("payment");
            this.f1397g = this.f1396f.optString("state");
            this.f1391a = this.f1396f.optString("id");
            this.f1398h = this.f1396f.optString("create_time");
            this.f1399i = this.f1396f.optString("intent");
            this.f1400j = m1249a(this.f1396f.getJSONArray("transactions"));
        } catch (JSONException e) {
            mo3751d();
        }
    }

    public final void mo3751d() {
        m1241b(m280n());
    }

    public final String mo3752e() {
        return "{     \"payment\": {         \"id\": \"PAY-6PU626847B294842SKPEWXHY\",         \"transactions\": [             {                 \"amount\": {                     \"total\": \"2.85\",                     \"details\": {                         \"subtotal\": \"2.85\"                     },                     \"currency\": \"USD\"                 },                 \"description\": \"Awesome Sauce\",                 \"related_resources\": [                     {                         \"sale\": {                             \"amount\": {                                 \"total\": \"2.85\",                                 \"currency\": \"USD\"                             },                             \"id\": \"5LR21373K59921925\",                             \"parent_payment\": \"PAY-6PU626847B294842SKPEWXHY\",                             \"update_time\": \"2014-07-18T18:47:06Z\",                             \"state\": \"completed\",                             \"create_time\": \"2014-07-18T18:46:55Z\",                             \"links\": [                                 {                                     \"method\": \"GET\",                                     \"rel\": \"self\",                                     \"href\": \"https://www.stage2std019.stage.\"                                 },                                 {                                     \"method\": \"POST\",                                     \"rel\": \"refund\",                                     \"href\": \"https://www.stage2std019.stage. \"                                 },                                 {                                     \"method\": \"GET\",                                     \"rel\": \"parent_payment\",                                     \"href\": \"https://www.stage2std019.stage.PEWXHY \"                                 }                             ]                         }                     }                 ]             }         ],         \"update_time\": \"2014-07-18T18:47:06Z\",         \"payer\": {             \"payer_info\": {                 \"shipping_address\": {                                      }             },             \"payment_method\": \"paypal\"         },         \"state\": \"approved\",         \"create_time\": \"2014-07-18T18:46:55Z\",         \"links\": [             {                 \"method\": \"GET\",                 \"rel\": \"self\",                 \"href\": \"https://www.stage2std019.stage.paypal.\"             }         ],         \"intent\": \"sale\"     } } ";
    }

    public final void mo4817m() {
        C0503Y.m52a().m79g();
    }

    public final String m1255u() {
        return this.f1391a;
    }

    public final boolean m1256v() {
        return this.f1393c;
    }

    public final String m1257w() {
        return this.f1397g;
    }

    public final String m1258x() {
        return this.f1398h;
    }

    public final String m1259y() {
        return this.f1399i;
    }

    public final String m1260z() {
        return this.f1400j;
    }
}
