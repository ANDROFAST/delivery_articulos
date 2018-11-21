package com.paypal.android.sdk.payments;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.widget.EditText;

final class C0529P implements Runnable {
    private /* synthetic */ EditText f755a;

    C0529P(LoginActivity loginActivity, EditText editText) {
        this.f755a = editText;
    }

    public final void run() {
        this.f755a.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, 9999.0f, 0.0f, 0));
        this.f755a.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 1, 9999.0f, 0.0f, 0));
    }
}
