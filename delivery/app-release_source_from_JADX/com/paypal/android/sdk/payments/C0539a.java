package com.paypal.android.sdk.payments;

import com.paypal.android.sdk.cf;
import com.paypal.android.sdk.cj;

class C0539a {
    private static final String f889a = C0539a.class.getSimpleName();
    private aI f890b;
    private Object f891c;
    private aF f892d;

    C0539a() {
    }

    private void m724b(aF aFVar) {
        aFVar.mo3759a(this.f891c);
        Object obj = ((this.f891c instanceof cf) || (this.f891c instanceof cj)) ? null : 1;
        this.f891c = null;
        if (obj != null) {
            this.f892d = null;
        }
    }

    final void m725a() {
        if (this.f891c == null) {
            this.f891c = "success";
        }
        if (this.f892d != null) {
            m724b(this.f892d);
        }
    }

    final void m726a(aF aFVar) {
        if (this.f891c != null) {
            m724b(aFVar);
        } else if (this.f890b != null) {
            aFVar.mo3758a(this.f890b);
            this.f890b = null;
            this.f892d = null;
        } else {
            this.f892d = aFVar;
        }
    }

    final void m727a(aI aIVar) {
        if (this.f892d != null) {
            this.f892d.mo3758a(aIVar);
        } else {
            this.f890b = aIVar;
        }
    }

    final void m728a(Object obj) {
        this.f891c = obj;
    }

    final void m729b() {
        this.f892d = null;
    }
}
