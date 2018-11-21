package com.paypal.android.sdk;

import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class cg extends co {
    private String f1436b;
    private String f1437c;
    private String f1438d;
    private int f1439e;
    private int f1440f;
    private String f1441g;
    private String f1442h;
    private String f1443i;
    private String f1444j;

    public cg(bn bnVar, C0507c c0507c, String str, String str2, String str3, String str4, bV bVVar, Map map, cn[] cnVarArr, String str5, boolean z, String str6, String str7, String str8) {
        super(bs.CreditCardPaymentRequest, bnVar, c0507c, str, str2, str4, bVVar, map, cnVarArr, str5, z, str6, str7, str8);
        this.f1441g = str3;
    }

    public cg(bn bnVar, C0507c c0507c, String str, String str2, String str3, String str4, String str5, int i, int i2, String str6, bV bVVar, Map map, cn[] cnVarArr, String str7, boolean z, String str8, String str9, String str10) {
        super(bs.CreditCardPaymentRequest, bnVar, c0507c, str, str2, null, bVVar, map, cnVarArr, str7, z, str8, str9, str10);
        this.f1436b = str3;
        this.f1437c = str4;
        this.f1438d = str5;
        this.f1439e = i;
        this.f1440f = i2;
    }

    protected final String mo4829A() {
        return "credit_card";
    }

    final void mo4830a(JSONObject jSONObject) {
        if (C0510f.m467d(this.f1442h)) {
            jSONObject.accumulate("invoice_number", this.f1442h);
        }
        if (C0510f.m467d(this.f1443i)) {
            jSONObject.accumulate("custom", this.f1443i);
        }
        if (C0510f.m467d(this.f1444j)) {
            jSONObject.accumulate("soft_descriptor", this.f1444j);
        }
    }

    public final cg m1303d(String str) {
        this.f1442h = str;
        return this;
    }

    public final cg m1304e(String str) {
        this.f1443i = str;
        return this;
    }

    public final String mo3752e() {
        String a = bO.m217a(m1280C().m231a().doubleValue(), m1280C().m232b());
        return "{\"id\":\"PAY-6RV70583SB702805EKEYSZ6Y\",\"intent\":\"sale\",\"create_time\": \"2014-02-12T22:29:49Z\",\"update_time\": \"2014-02-12T22:29:50Z\",\"payer\":{\"funding_instruments\":[{\"credit_card\":{\"expire_month\":\"" + this.f1439e + "\",\"expire_year\":\"" + this.f1440f + "\",\"number\":\"" + (this.f1436b != null ? this.f1437c.substring(this.f1437c.length() - 4) : "xxxxxxxxxx1111") + "\",\"type\":\"VISA\"}" + "}]," + "\"payment_method\":\"credit_card\"}," + "\"state\":\"approved\",\"transactions\":" + "[{" + "\"amount\":{\"currency\":\"USD\"," + "\"total\":\"" + a + "\"},\"description\":\"I am a sanity check payment.\"," + "\"item_list\":{},\"payee\":" + "{\"merchant_id\":\"PKKPTJKL75YDS\"},\"related_resources\":" + "[{\"sale\":{\"amount\":{\"currency\":\"USD\",\"total\":\"" + a + "\"},\"id\":\"0EW02334X44816642\"," + "\"parent_payment\":\"PAY-123456789012345689\",\"state\":\"completed\"}}]}]}";
    }

    public final cg m1306f(String str) {
        this.f1444j = str;
        return this;
    }

    public final String m1307u() {
        return this.f1437c;
    }

    public final String m1308v() {
        return this.f1436b;
    }

    public final String m1309w() {
        return this.f1438d;
    }

    public final int m1310x() {
        return this.f1439e;
    }

    public final int m1311y() {
        return this.f1440f;
    }

    protected final JSONArray mo4831z() {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject;
        JSONObject jSONObject2;
        if (this.f1436b != null) {
            jSONObject = new JSONObject();
            jSONObject.accumulate("cvv2", this.f1438d);
            jSONObject.accumulate("expire_month", Integer.valueOf(this.f1439e));
            jSONObject.accumulate("expire_year", Integer.valueOf(this.f1440f));
            jSONObject.accumulate("number", this.f1437c);
            jSONObject.accumulate("type", this.f1436b);
            jSONObject2 = new JSONObject();
            jSONObject2.accumulate("credit_card", jSONObject);
            jSONArray.put(jSONObject2);
        } else {
            jSONObject = new JSONObject();
            jSONObject.accumulate("payer_id", this.f1416a);
            jSONObject.accumulate("credit_card_id", this.f1441g);
            jSONObject2 = new JSONObject();
            jSONObject2.accumulate("credit_card_token", jSONObject);
            jSONArray.put(jSONObject2);
        }
        return jSONArray;
    }
}
