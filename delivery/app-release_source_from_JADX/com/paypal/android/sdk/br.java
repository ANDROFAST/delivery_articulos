package com.paypal.android.sdk;

import java.util.ArrayList;
import java.util.List;

public final class br implements bk {
    private bs f1199a;

    public br(bs bsVar) {
        this.f1199a = bsVar;
    }

    public static List m952d() {
        List arrayList = new ArrayList();
        for (bs brVar : bs.values()) {
            arrayList.add(new br(brVar));
        }
        return arrayList;
    }

    public final String mo3739a() {
        return this.f1199a.name();
    }

    public final aJ mo3740b() {
        return this.f1199a.m329a();
    }

    public final String mo3741c() {
        return this.f1199a.m330b();
    }
}
