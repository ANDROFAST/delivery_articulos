package io.card.payment;

import android.text.Editable;
import android.text.Spanned;

final class C0859k implements C0567r {
    public int f1343a;
    private String f1344b;

    public C0859k(int i) {
        this.f1343a = i;
    }

    public final boolean mo3790a() {
        return this.f1344b != null && this.f1344b.length() == this.f1343a;
    }

    public final void afterTextChanged(Editable editable) {
        this.f1344b = editable.toString();
    }

    public final String mo3791b() {
        return this.f1344b;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final boolean mo3792c() {
        return mo3790a();
    }

    public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        return (i2 <= 0 || ((spanned.length() + i4) - i3) + i2 <= this.f1343a) ? null : "";
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
