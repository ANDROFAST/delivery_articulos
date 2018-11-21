package io.card.payment;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import java.util.Date;

final class C0858j implements C0567r {
    public int f1340a;
    public int f1341b;
    private boolean f1342c;

    public C0858j() {
        getClass().getName();
    }

    public C0858j(int i, int i2) {
        getClass().getName();
        this.f1340a = i;
        this.f1341b = i2;
        boolean z = this.f1340a > 0 && this.f1341b > 0;
        this.f1342c = z;
        if (this.f1341b < 2000) {
            this.f1341b += 2000;
        }
    }

    public final boolean mo3790a() {
        if (this.f1340a <= 0 || 12 < this.f1340a) {
            return false;
        }
        Date date = new Date();
        return this.f1341b <= (date.getYear() + 1900) + 15 ? this.f1341b > date.getYear() + 1900 || (this.f1341b == date.getYear() + 1900 && this.f1340a >= date.getMonth() + 1) : false;
    }

    public final void afterTextChanged(Editable editable) {
        this.f1342c = editable.length() >= 5;
        String obj = editable.toString();
        if (obj != null) {
            Date a = C0560g.m839a(obj);
            if (a != null) {
                this.f1340a = a.getMonth() + 1;
                this.f1341b = a.getYear();
                if (this.f1341b < 1900) {
                    this.f1341b += 1900;
                }
            }
        }
    }

    public final String mo3791b() {
        return String.format("%02d/%02d", new Object[]{Integer.valueOf(this.f1340a), Integer.valueOf(this.f1341b % 100)});
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f1340a = 0;
        this.f1341b = 0;
        this.f1342c = false;
    }

    public final boolean mo3792c() {
        return this.f1342c;
    }

    public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        int i5;
        CharSequence spannableStringBuilder = new SpannableStringBuilder(charSequence);
        if (i3 != 0 || spannableStringBuilder.length() <= 0 || '1' >= spannableStringBuilder.charAt(0) || spannableStringBuilder.charAt(0) > '9') {
            i5 = i2;
        } else {
            spannableStringBuilder.insert(0, "0");
            i5 = i2 + 1;
        }
        int i6 = i4 - i3;
        if (i3 - i6 <= 2 && (i3 + i5) - i6 >= 2) {
            i6 = 2 - i3;
            if (i6 == i5 || (i6 >= 0 && i6 < i5 && spannableStringBuilder.charAt(i6) != '/')) {
                spannableStringBuilder.insert(i6, "/");
                i5++;
            }
        }
        String spannableStringBuilder2 = new SpannableStringBuilder(spanned).replace(i3, i4, spannableStringBuilder, i, i5).toString();
        if (spannableStringBuilder2.length() > 0 && (spannableStringBuilder2.charAt(0) < '0' || '1' < spannableStringBuilder2.charAt(0))) {
            return "";
        }
        if (spannableStringBuilder2.length() >= 2) {
            if (spannableStringBuilder2.charAt(0) != '0' && spannableStringBuilder2.charAt(1) > '2') {
                return "";
            }
            if (spannableStringBuilder2.charAt(0) == '0' && spannableStringBuilder2.charAt(1) == '0') {
                return "";
            }
        }
        return spannableStringBuilder2.length() > 5 ? "" : spannableStringBuilder;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
