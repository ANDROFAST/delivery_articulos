package com.paypal.android.sdk.payments;

import com.paypal.android.sdk.C0510f;
import com.paypal.android.sdk.aA;
import com.paypal.android.sdk.cu;
import com.paypal.android.sdk.cw;
import com.paypal.android.sdk.cy;
import java.util.Map;

final class C1174i extends C0839h {
    public C1174i(PayPalService payPalService) {
        super(new aL(payPalService));
    }

    protected final void mo4746a(String str, Map map) {
        if (!m1124a().m738a().f385b.m190c()) {
            m1124a().m738a().f385b = new cu();
        }
        map.put("v49", str);
        map.put("v51", m1124a().m741c().mo3730d().m183d());
        map.put("v52", cw.f586a + " " + cw.f589d);
        map.put("v53", cw.f590e);
        map.put("clid", m1124a().m740b());
        map.put("apid", m1124a().m741c().mo3730d().m181c() + "|" + str + "|" + m1124a().m744f());
        m1124a().m739a(new aA(m1124a().m738a().f385b.m189b(), map, cw.f588c, cw.f587b, false));
    }

    protected final void mo4747a(Map map, cy cyVar, String str, String str2) {
        map.put("g", m1124a().m743e());
        map.put("vers", cw.f586a + ":" + m1124a().m742d() + ":");
        map.put("srce", "msdk");
        map.put("sv", "mobile");
        map.put("bchn", "msdk");
        map.put("adte", "FALSE");
        map.put("bzsr", "mobile");
        if (C0510f.m467d((CharSequence) str)) {
            map.put("calc", str);
        }
        if (C0510f.m467d((CharSequence) str2)) {
            map.put("prid", str2);
        }
        map.put("e", cyVar.m427b() ? "cl" : "im");
    }

    protected final String mo4748b() {
        return "msdk";
    }
}
