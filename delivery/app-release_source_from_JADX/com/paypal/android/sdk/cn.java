package com.paypal.android.sdk;

import java.math.BigDecimal;
import org.json.JSONArray;
import org.json.JSONObject;

public class cn {
    private String f581a;
    private Integer f582b;
    private BigDecimal f583c;
    private String f584d;
    private String f585e;

    static {
        cn.class.getSimpleName();
    }

    public cn(String str, Integer num, BigDecimal bigDecimal, String str2, String str3) {
        this.f581a = str;
        this.f582b = num;
        this.f583c = bigDecimal;
        this.f584d = str2;
        this.f585e = str3;
    }

    public static JSONArray m423a(cn[] cnVarArr) {
        if (cnVarArr == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (cn cnVar : cnVarArr) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.accumulate("quantity", Integer.toString(cnVar.f582b.intValue()));
            jSONObject.accumulate("name", cnVar.f581a);
            jSONObject.accumulate("price", cnVar.f583c.toString());
            jSONObject.accumulate("currency", cnVar.f584d);
            jSONObject.accumulate("sku", cnVar.f585e);
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }
}
