package com.paypal.android.sdk.payments;

import com.paypal.android.sdk.aA;
import com.paypal.android.sdk.bI;
import com.paypal.android.sdk.cw;
import java.util.Map;

final class C1175j extends C0839h {
    public C1175j(PayPalService payPalService) {
        super(new aL(payPalService));
    }

    protected final void mo4746a(String str, Map map) {
        if (!m1124a().m738a().f384a.m190c()) {
            m1124a().m738a().f384a = new bI();
            map.put("v49", str);
            map.put("v51", m1124a().m741c().mo3730d().m183d());
            map.put("v52", cw.f586a + " " + cw.f589d);
            map.put("v53", cw.f590e);
        }
        m1124a().m739a(new aA(m1124a().m738a().f384a.m189b(), map, cw.f588c, cw.f587b, true));
    }

    protected final String mo4748b() {
        return "mpl";
    }
}
