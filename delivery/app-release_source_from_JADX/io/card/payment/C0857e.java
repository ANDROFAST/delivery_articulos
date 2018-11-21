package io.card.payment;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

final class C0857e implements C0567r {
    private static int[] f1336b = new int[]{4, 11};
    private static int[] f1337c = new int[]{4, 9, 14};
    private String f1338a;
    private int f1339d = 0;

    public C0857e(String str) {
        this.f1338a = str;
    }

    public final boolean mo3790a() {
        if (!mo3792c()) {
            return false;
        }
        boolean z;
        int[][] iArr = new int[][]{new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, new int[]{0, 2, 4, 6, 8, 1, 3, 5, 7, 9}};
        CharacterIterator stringCharacterIterator = new StringCharacterIterator(this.f1338a);
        char last = stringCharacterIterator.last();
        int i = 0;
        int i2 = 0;
        while (last != '￿') {
            if (!Character.isDigit(last)) {
                break;
            }
            int i3 = i2 + 1;
            i += iArr[i2 & 1][last - 48];
            last = stringCharacterIterator.previous();
            i2 = i3;
        }
        if (i % 10 == 0) {
            z = true;
            return z;
        }
        z = false;
        if (z) {
        }
    }

    public final void afterTextChanged(Editable editable) {
        int i = 0;
        this.f1338a = C0560g.m840b(editable.toString());
        CardType fromCardNumber = CardType.fromCardNumber(this.f1338a);
        if (this.f1339d > 1) {
            int i2 = this.f1339d;
            int i3 = this.f1339d - 1;
            this.f1339d = 0;
            if (i2 > i3) {
                editable.delete(i3, i2);
            }
        }
        while (i < editable.length()) {
            char charAt = editable.charAt(i);
            if ((fromCardNumber.numberLength() == 15 && (i == 4 || i == 11)) || ((fromCardNumber.numberLength() == 16 || fromCardNumber.numberLength() == 14) && (i == 4 || i == 9 || i == 14))) {
                if (charAt != ' ') {
                    editable.insert(i, " ");
                }
            } else if (charAt == ' ') {
                editable.delete(i, i + 1);
                i--;
            }
            i++;
        }
    }

    public final String mo3791b() {
        return this.f1338a;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final boolean mo3792c() {
        if (TextUtils.isEmpty(this.f1338a)) {
            return false;
        }
        return this.f1338a.length() == CardType.fromCardNumber(this.f1338a).numberLength();
    }

    public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        String b = C0560g.m840b(new SpannableStringBuilder(spanned).replace(i3, i4, charSequence, i, i2).toString());
        int numberLength = CardType.fromCardNumber(b).numberLength();
        if (b.length() > numberLength) {
            return "";
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        int[] iArr = numberLength == 15 ? f1336b : f1337c;
        int i5 = i4 - i3;
        numberLength = 0;
        while (numberLength < iArr.length) {
            if (charSequence.length() == 0 && i3 == iArr[numberLength] && spanned.charAt(i3) == ' ') {
                this.f1339d = iArr[numberLength];
            }
            if (i3 - i5 <= iArr[numberLength] && (i3 + i2) - i5 >= iArr[numberLength]) {
                int i6 = iArr[numberLength] - i3;
                if (i6 == i2 || (i6 >= 0 && i6 < i2 && spannableStringBuilder.charAt(i6) != ' ')) {
                    spannableStringBuilder.insert(i6, " ");
                    i2++;
                }
            }
            numberLength++;
        }
        return spannableStringBuilder;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
