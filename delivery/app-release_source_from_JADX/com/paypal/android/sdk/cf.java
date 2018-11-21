package com.paypal.android.sdk;

import com.google.android.gms.plus.PlusShare;
import com.paypal.android.sdk.payments.PayPalPayment;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class cf extends cp {
    private String f1401a;
    private String f1402b;
    private JSONArray f1403c;
    private JSONObject f1404d;
    private JSONArray f1405e;
    private bV f1406f;
    private Map f1407g;
    private cn[] f1408h;
    private String f1409i;
    private String f1410j;
    private boolean f1411k;
    private String f1412l;
    private String f1413m;
    private String f1414n;

    public cf(bn bnVar, C0507c c0507c, String str, String str2, String str3, bV bVVar, Map map, cn[] cnVarArr, String str4, boolean z, String str5, String str6, String str7, boolean z2) {
        super(bs.CreateSfoPaymentRequest, bnVar, c0507c, str);
        this.f1406f = bVVar;
        this.f1407g = map;
        this.f1408h = cnVarArr;
        this.f1409i = str4;
        this.f1411k = z2;
        this.f1410j = str7;
        if (C0510f.m464c(this.f1410j)) {
            this.f1410j = PayPalPayment.PAYMENT_INTENT_SALE;
        }
        this.f1410j = this.f1410j.toLowerCase(Locale.US);
        m264a("PayPal-Request-Id", str2);
        if (C0510f.m467d((CharSequence) str5)) {
            m264a("PayPal-Partner-Attribution-Id", str5);
        }
        if (C0510f.m467d((CharSequence) str6)) {
            m264a("PayPal-Client-Metadata-Id", str6);
        }
    }

    public final String mo3749b() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.accumulate("intent", this.f1410j);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.accumulate("payment_method", "paypal");
        jSONObject.accumulate("payer", jSONObject2);
        jSONObject2 = new JSONObject();
        jSONObject2.accumulate("cancel_url", "http://cancelurl");
        jSONObject2.accumulate("return_url", "http://returnurl");
        jSONObject.accumulate("redirect_urls", jSONObject2);
        bV bVVar = this.f1406f;
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.accumulate("currency", bVVar.m232b().getCurrencyCode());
        jSONObject3.accumulate("total", bVVar.m231a().toPlainString());
        if (!(this.f1407g == null || this.f1407g.isEmpty())) {
            Object obj;
            String str = "details";
            if (this.f1407g == null || this.f1407g.isEmpty()) {
                obj = null;
            } else {
                obj = new JSONObject();
                if (this.f1407g.containsKey("shipping")) {
                    obj.accumulate("shipping", this.f1407g.get("shipping"));
                }
                if (this.f1407g.containsKey("subtotal")) {
                    obj.accumulate("subtotal", this.f1407g.get("subtotal"));
                }
                if (this.f1407g.containsKey("tax")) {
                    obj.accumulate("tax", this.f1407g.get("tax"));
                }
            }
            jSONObject3.accumulate(str, obj);
        }
        jSONObject2 = new JSONObject();
        jSONObject2.accumulate("amount", jSONObject3);
        jSONObject2.accumulate(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, this.f1409i);
        if (this.f1408h != null && this.f1408h.length > 0) {
            jSONObject3 = new JSONObject();
            jSONObject3.accumulate("items", cn.m423a(this.f1408h));
            jSONObject2.accumulate("item_list", jSONObject3);
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(jSONObject2);
        jSONObject.accumulate("transactions", jSONArray);
        if (C0510f.m467d(this.f1412l)) {
            jSONObject2.accumulate("invoice_number", this.f1412l);
        }
        if (C0510f.m467d(this.f1413m)) {
            jSONObject2.accumulate("custom", this.f1413m);
        }
        if (C0510f.m467d(this.f1414n)) {
            jSONObject2.accumulate("soft_descriptor", this.f1414n);
        }
        jSONObject2 = new JSONObject();
        jSONObject2.accumulate("device_info", C0510f.m452a(bQ.m224a().toString()));
        jSONObject2.accumulate("app_info", C0510f.m452a(bN.m212a().toString()));
        jSONObject2.accumulate("risk_data", C0510f.m452a(C0503Y.m52a().m76c().toString()));
        jSONObject3 = new JSONObject();
        jSONObject3.accumulate("payment", jSONObject);
        jSONObject3.accumulate("client_info", jSONObject2);
        if (this.f1411k) {
            jSONObject3.accumulate("retrieve_shipping_addresses", Boolean.valueOf(true));
        }
        return jSONObject3.toString();
    }

    public final void mo3750c() {
        JSONObject n = m280n();
        this.f1401a = n.optString("payment_id");
        this.f1402b = n.getString("session_id");
        this.f1403c = n.optJSONArray("addresses");
        n = n.optJSONObject("funding_options");
        if (n != null) {
            this.f1404d = n.optJSONObject("default_option");
            this.f1405e = n.optJSONArray("alternate_options");
        }
    }

    public final cf m1263d(String str) {
        this.f1412l = str;
        return this;
    }

    public final void mo3751d() {
        m1241b(m280n());
    }

    public final cf m1265e(String str) {
        this.f1413m = str;
        return this;
    }

    public final String mo3752e() {
        return "{    \"session_id\":\"7N0112287V303050T\",    \"payment_id\":\"PAY-18X32451H0459092JKO7KFUI\",    \"addresses\": [          {             \"city\": \"Columbia\",              \"line2\": \"6073 2nd Street\",              \"line1\": \"Suite 222\",              \"recipient_name\": \"Beverly Jello\",             \"state\": \"MD\",              \"postal_code\": \"21045\",             \"default_address\": false,              \"country_code\": \"US\",              \"type\": \"HOME_OR_WORK\",              \"id\": \"366853\"          },          {             \"city\": \"Austin\",              \"line2\": \"Apt. 222\",              \"line1\": \"52 North Main St. \",              \"recipient_name\": \"Michael Chassen\",             \"state\": \"TX\",              \"postal_code\": \"78729\",             \"default_address\": true,              \"country_code\": \"US\",              \"type\": \"HOME_OR_WORK\",              \"id\": \"366852\"          },          {             \"city\": \"Austin\",              \"line1\": \"202 South State St. \",              \"recipient_name\": \"Sam Stone\",             \"state\": \"TX\",              \"postal_code\": \"78729\",             \"default_address\": true,              \"country_code\": \"US\",              \"type\": \"HOME_OR_WORK\",              \"id\": \"366852\"          }     ],     \"funding_options\":{       \"default_option\":{          \"id\":\"1\",          \"backup_funding_instrument\":{             \"payment_card\":{                \"number\":\"8029\",                \"type\":\"VISA\"             }          },          \"funding_sources\":[             {                \"amount\":{                   \"value\":\"216.85\",                   \"currency\":\"USD\"                },                \"funding_instrument_type\":\"BANK_ACCOUNT\",                \"funding_mode\":\"INSTANT_TRANSFER\",                \"bank_account\":{                   \"bank_name\":\"SunTrust\",                   \"account_number\":\"7416\",                   \"account_number_type\":\"BBAN\",                   \"country_code\":\"US\",                   \"account_type\":\"CHECKING\"                }             },             {                \"amount\":{                   \"value\":\"6.00\",                   \"currency\":\"USD\"                },                \"funding_instrument_type\":\"CREDIT\",                \"funding_mode\":\"INSTANT_TRANSFER\",                \"credit\":{                   \"type\":\"BILL_ME_LATER\",                   \"id\":\"mock-id\"                }             }          ]       },       \"alternate_options\":[          {             \"id\":\"2\",             \"funding_sources\":[                {                   \"amount\":{                      \"value\":\"216.85\",                      \"currency\":\"USD\"                   },                   \"funding_instrument_type\":\"PAYMENT_CARD\",                   \"payment_card\":{                      \"number\":\"8029\",                      \"type\":\"VISA\"                   },                   \"funding_mode\":\"INSTANT_TRANSFER\"                },                {                   \"amount\":{                      \"value\":\"6.00\",                      \"currency\":\"USD\"                   },                   \"funding_instrument_type\":\"BALANCE\",                   \"funding_mode\":\"INSTANT_TRANSFER\"                }             ]          },          {             \"id\":\"3\",             \"funding_sources\":[                {                   \"amount\":{                      \"value\":\"216.85\",                      \"currency\":\"USD\"                   },                   \"funding_instrument_type\":\"PAYMENT_CARD\",                   \"payment_card\":{                      \"number\":\"8011\",                      \"type\":\"VISA\"                   },                   \"funding_mode\":\"INSTANT_TRANSFER\"                },                {                   \"amount\":{                      \"value\":\"6.00\",                      \"currency\":\"USD\"                   },                   \"funding_instrument_type\":\"BALANCE\",                   \"funding_mode\":\"INSTANT_TRANSFER\"                }             ]          }       ]    } }";
    }

    public final cf m1267f(String str) {
        this.f1414n = str;
        return this;
    }

    public final String m1268u() {
        return this.f1401a;
    }

    public final String m1269v() {
        return this.f1402b;
    }

    public final JSONArray m1270w() {
        return this.f1403c;
    }

    public final JSONObject m1271x() {
        return this.f1404d;
    }

    public final JSONArray m1272y() {
        return this.f1405e;
    }
}
