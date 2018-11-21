package com.paypal.android.sdk.payments;

import android.content.Intent;
import android.util.Log;

abstract class C0518C {
    private Intent f704a;
    private PayPalConfiguration f705b;

    C0518C(Intent intent, PayPalConfiguration payPalConfiguration) {
        this.f704a = intent;
        this.f705b = payPalConfiguration;
        if (!this.f704a.hasExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION)) {
            Log.w(mo3761a(), "Please add PayPalService.EXTRA_PAYPAL_CONFIGURATION to this activity for restart resiliency.");
        }
    }

    abstract String mo3761a();

    protected final void m488a(boolean z, String str) {
        if (!z) {
            Log.e(mo3761a(), str + " is invalid.  Please see the docs.");
        }
    }

    final Intent m489b() {
        return this.f704a;
    }

    final PayPalConfiguration m490c() {
        return this.f705b;
    }

    protected final boolean m491d() {
        if (this.f705b.m552o()) {
            return true;
        }
        Log.e(mo3761a(), "Service extra invalid.");
        return false;
    }

    abstract boolean mo3762e();
}
