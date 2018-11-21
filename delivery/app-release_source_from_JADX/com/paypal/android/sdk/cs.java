package com.paypal.android.sdk;

import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public final class cs extends cp {
    public String f1427a;
    private String f1428b;
    private String f1429c;
    private String f1430d;
    private int f1431e;
    private int f1432f;
    private String f1433g;
    private String f1434h;
    private Date f1435i;

    public cs(bn bnVar, C0507c c0507c, String str, String str2, String str3, String str4, String str5, int i, int i2) {
        super(bs.TokenizeCreditCardRequest, bnVar, c0507c, str);
        this.f1427a = str2;
        this.f1428b = str3;
        if (str4 == null) {
            throw new RuntimeException("cardNumber should not be null.  If it is, then you're probably trying to tokenize a card that's already been tokenized.");
        }
        this.f1429c = str4;
        this.f1430d = str5;
        this.f1431e = i;
        this.f1432f = i2;
    }

    public final String mo3749b() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.accumulate("payer_id", this.f1427a);
        jSONObject.accumulate("cvv2", this.f1430d);
        jSONObject.accumulate("expire_month", Integer.valueOf(this.f1431e));
        jSONObject.accumulate("expire_year", Integer.valueOf(this.f1432f));
        jSONObject.accumulate("number", this.f1429c);
        jSONObject.accumulate("type", this.f1428b);
        return jSONObject.toString();
    }

    public final void mo3750c() {
        JSONObject n = m280n();
        try {
            this.f1433g = n.getString("id");
            String string = n.getString("number");
            if (this.f1434h == null || !this.f1434h.endsWith(string.substring(string.length() - 4))) {
                this.f1434h = string;
            }
            this.f1435i = cb.m422a(n.getString("valid_until"));
        } catch (JSONException e) {
            mo3751d();
        }
    }

    public final void mo3751d() {
        m1241b(m280n());
    }

    public final String mo3752e() {
        return "{\"id\":\"CARD-50Y58962PH1899901KFFBSDA\",\"valid_until\":\"2016-03-19T00:00:00.000Z\",\"state\":\"ok\",\"type\":\"visa\",\"number\":\"xxxxxxxxxxxx" + this.f1429c.substring(this.f1429c.length() - 4) + "\",\"expire_month\":\"" + this.f1431e + "\",\"expire_year\":\"" + this.f1432f + "\",\"links\":[" + "{\"href\":\"https://api.sandbox.paypal.com/v1/vault/credit-card/CARD-50Y58962PH1899901KFFBSDA\"," + "\"rel\":\"self\",\"method\":\"GET\"" + "}]" + "}";
    }

    public final String m1295u() {
        return this.f1433g;
    }

    public final String m1296v() {
        return this.f1434h;
    }

    public final Date m1297w() {
        return this.f1435i;
    }

    public final String m1298x() {
        return this.f1428b;
    }

    public final int m1299y() {
        return this.f1431e;
    }

    public final int m1300z() {
        return this.f1432f;
    }
}
