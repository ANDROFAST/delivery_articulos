package com.paypal.android.sdk.payments;

import android.text.Editable;
import android.text.TextWatcher;

final class C0528M implements TextWatcher {
    private /* synthetic */ LoginActivity f754a;

    C0528M(LoginActivity loginActivity) {
        this.f754a = loginActivity;
    }

    public final void afterTextChanged(Editable editable) {
        this.f754a.m527h();
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
