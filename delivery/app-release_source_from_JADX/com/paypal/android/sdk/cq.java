package com.paypal.android.sdk;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class cq extends cm {
    public String f1385a;
    public String f1386b;
    public long f1387c;
    public boolean f1388d;

    public cq(String str, bn bnVar, C0507c c0507c, String str2) {
        super(bs.PreAuthRequest, bnVar, c0507c, cm.m1220b(str, str2));
    }

    public final String mo3749b() {
        Map hashMap = new HashMap();
        hashMap.put("response_type", "token");
        hashMap.put("grant_type", "client_credentials");
        hashMap.put("return_authn_schemes", "true");
        hashMap.put("device_info", C0510f.m452a(bQ.m224a().toString()));
        hashMap.put("app_info", C0510f.m452a(bN.m212a().toString()));
        hashMap.put("risk_data", C0510f.m452a(C0503Y.m52a().m76c().toString()));
        return C0510f.m453a(hashMap);
    }

    public final void mo3750c() {
        JSONObject n = m280n();
        try {
            this.f1385a = n.getString("access_token");
            this.f1386b = n.getString("scope");
            this.f1387c = n.getLong("expires_in");
            JSONArray jSONArray = n.getJSONArray("supported_authn_schemes");
            for (int i = 0; i < jSONArray.length(); i++) {
                if (jSONArray.get(i).equals("phone_pin")) {
                    this.f1388d = true;
                }
            }
        } catch (JSONException e) {
            m1221b(n);
        }
    }

    public final void mo3751d() {
        m1221b(m280n());
    }

    public final String mo3752e() {
        return "{\"scope\":\"https://api.paypal.com/v1/payments/.* https://api.paypal.com/v1/vault/credit-card https://api.paypal.com/v1/vault/credit-card/.* openid\",\"access_token\":\"iPVzWUwTo1fEG6n.2sTZCahv8wa2b8uGpBs1KZ-6XxA\",\"token_type\":\"Bearer\",\"expires_in\":900,\"supported_authn_schemes\": [ \"email_password\", \"phone_pin\" ]}";
    }
}
