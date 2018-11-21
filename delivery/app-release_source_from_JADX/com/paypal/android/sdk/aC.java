package com.paypal.android.sdk;

import java.util.ArrayList;
import java.util.List;

public class aC {
    private static final String f128a = aC.class.getSimpleName();
    private final List f129b = new ArrayList();

    public final void m82a() {
        synchronized (this.f129b) {
            for (aD remove : this.f129b) {
                this.f129b.remove(remove);
            }
        }
    }

    public final void m83a(aE aEVar) {
        synchronized (this.f129b) {
            for (aD aDVar : this.f129b) {
                if (aDVar.f130a == aEVar) {
                    new StringBuilder("Ignoring attempt to re-register listener ").append(aEVar);
                    return;
                }
            }
            this.f129b.add(new aD(this, aEVar));
        }
    }

    public final void m84a(bm bmVar, long j) {
        new StringBuilder("dispatching ").append(bmVar.m281o());
        if (bmVar.m282p() < 0) {
            new StringBuilder("discarding ").append(bmVar.m281o());
            return;
        }
        List<aD> arrayList = new ArrayList();
        synchronized (this.f129b) {
            for (aD add : this.f129b) {
                arrayList.add(0, add);
            }
        }
        for (aD add2 : arrayList) {
            add2.f130a.mo3731a(bmVar);
        }
    }
}
