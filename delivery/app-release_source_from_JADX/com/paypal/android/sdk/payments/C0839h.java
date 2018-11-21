package com.paypal.android.sdk.payments;

import com.paypal.android.sdk.C0510f;
import com.paypal.android.sdk.bq;
import com.paypal.android.sdk.cw;
import com.paypal.android.sdk.cy;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

abstract class C0839h implements C0545k {
    private aL f1302a;

    protected C0839h(aL aLVar) {
        this.f1302a = aLVar;
    }

    private String m1123a(cy cyVar, boolean z) {
        String str = cw.f587b + ":" + mo4748b() + ":" + cyVar.m425a();
        return z ? str + "|error" : str;
    }

    protected final aL m1124a() {
        return this.f1302a;
    }

    public final void mo3785a(cy cyVar, boolean z, String str, String str2, String str3) {
        Object obj;
        String str4 = "2.9.8";
        bq.m947a();
        String locale = Locale.getDefault().toString();
        Map hashMap = new HashMap();
        boolean z2 = !C0510f.m459a((CharSequence) str);
        hashMap.put("gn", m1123a(cyVar, z2));
        hashMap.put("v31", m1123a(cyVar, z2));
        String str5 = "c25";
        String str6 = m1123a(cyVar, z2) + ":" + cyVar.m426a(this.f1302a.m742d(), z);
        if (z2) {
            obj = str6 + "|error";
        } else {
            String str7 = str6;
        }
        hashMap.put(str5, obj);
        hashMap.put("v25", "D=c25");
        hashMap.put("c37", cw.f586a + "::");
        hashMap.put("c50", locale);
        hashMap.put("c35", "out");
        mo4747a(hashMap, cyVar, str2, str3);
        if (str != null) {
            hashMap.put("c29", str);
        }
        mo4746a(str4, hashMap);
    }

    abstract void mo4746a(String str, Map map);

    protected void mo4747a(Map map, cy cyVar, String str, String str2) {
    }

    protected abstract String mo4748b();
}
