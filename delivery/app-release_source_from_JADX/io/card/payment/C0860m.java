package io.card.payment;

import android.text.Editable;
import android.text.Spanned;

class C0860m implements C0567r {
    private String f1345a;

    C0860m() {
    }

    public boolean mo3790a() {
        return this.f1345a != null && this.f1345a.length() > 0;
    }

    public void afterTextChanged(Editable editable) {
        this.f1345a = editable.toString().trim();
    }

    public final String mo3791b() {
        return this.f1345a;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final boolean mo3792c() {
        return mo3790a();
    }

    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        return null;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
