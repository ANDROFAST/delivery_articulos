package com.paypal.android.sdk;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class cj extends bl {
    private static final String f1359a = cj.class.getSimpleName();
    private Map f1360b;
    private String f1361c;
    private String f1362d;
    private String f1363e;

    public cj(bn bnVar, C0507c c0507c, String str, String str2, String str3) {
        bk brVar = new br(bs.GetAppInfoRequest);
        StringBuilder stringBuilder = new StringBuilder("Bearer ");
        if (av.m167a(str) && str2 == null) {
            str2 = "mock_euat";
        }
        super(brVar, bnVar, c0507c, stringBuilder.append(str2).toString(), "/" + str3);
        this.f1360b = new HashMap();
        m264a("Content-Type", "application/x-www-form-urlencoded");
    }

    private static void m1210a(JSONArray jSONArray, Map map) {
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject != null) {
                    CharSequence optString = jSONObject.optString("name");
                    CharSequence optString2 = jSONObject.optString("value");
                    if (C0510f.m467d(optString) && C0510f.m467d(optString2)) {
                        map.put(optString, optString2);
                    }
                }
            }
        }
    }

    public final String mo3749b() {
        return "";
    }

    public final void mo3750c() {
        JSONObject n = m280n();
        JSONArray optJSONArray = n.optJSONArray("capabilities");
        if (optJSONArray != null) {
            JSONObject jSONObject;
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                if (jSONObject2 != null && "PAYPAL_ACCESS".equals(jSONObject2.optString("name"))) {
                    jSONObject = jSONObject2;
                    break;
                }
            }
            jSONObject = null;
            if (jSONObject != null) {
                m1210a(jSONObject.optJSONArray("attributes"), this.f1360b);
                new StringBuilder("Attributes: ").append(this.f1360b.toString());
            }
        }
        JSONArray optJSONArray2 = n.optJSONArray("attributes");
        if (optJSONArray2 != null) {
            Map hashMap = new HashMap();
            m1210a(optJSONArray2, hashMap);
            this.f1361c = (String) hashMap.get("privacy_policy_url");
            this.f1362d = (String) hashMap.get("user_agreement_url");
            this.f1363e = (String) hashMap.get("display_name");
        }
    }

    public final void mo3751d() {
    }

    public final String mo3752e() {
        return " {\n     \"attributes\": [\n         {\n             \"name\": \"display_name\",\n             \"value\": \"Example Merchant\"\n         },\n         {\n             \"name\": \"privacy_policy_url\",\n             \"value\": \"http://www.example.com/privacy-policy\"\n         },\n         {\n             \"name\": \"user_agreement_url\",\n             \"value\": \"http://www.example.com/user-agreement\"\n         }\n     ],\n     \"name\": \"LiveTestApp\",\n     \"capabilities\": [\n         {\n             \"scopes\": [],\n             \"name\": \"PAYPAL_ACCESS\",\n             \"attributes\": [\n                 {\n                     \"name\": \"openid_connect\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_date_of_birth\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_fullname\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_gender\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_zip\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_language\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_city\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_country\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_timezone\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_email\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_street_address1\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_street_address2\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_phone_number\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_locale\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_state\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_age_range\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_account_verified\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_account_creation_date\",\n                     \"value\": \"Y\"\n                 },\n                 {\n                     \"name\": \"oauth_account_type\",\n                     \"value\": \"Y\"\n                 }\n             ]\n         },\n         {\n             \"scopes\": [\n                 \"https://api.paypal.com/v1/payments/.*\",\n                 \"https://api.paypal.com/v1/vault/credit-card\",\n                 \"https://api.paypal.com/v1/vault/credit-card/.*\"\n             ],\n             \"name\": \"PAYMENT\",\n             \"features\": [\n                 {\n                     \"status\": \"ACTIVE\",\n                     \"name\": \"ACCEPT_CARD\"\n                 },\n                 {\n                     \"status\": \"ACTIVE\",\n                     \"name\": \"ACCEPT_PAYPAL\"\n                 }\n             ]\n         }\n     ]\n }    ";
    }

    public final Map m1215u() {
        return this.f1360b;
    }

    public final String m1216v() {
        return this.f1361c;
    }

    public final String m1217w() {
        return this.f1362d;
    }

    public final String m1218x() {
        return this.f1363e;
    }
}
