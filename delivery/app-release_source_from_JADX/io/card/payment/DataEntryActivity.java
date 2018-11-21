package io.card.payment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.text.method.DateKeyListener;
import android.text.method.DigitsKeyListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.google.android.gms.cast.TextTrackStyle;
import com.paypal.android.sdk.C0500V;
import com.paypal.android.sdk.cZ;
import com.paypal.android.sdk.dE;
import com.paypal.android.sdk.dF;
import com.paypal.android.sdk.da;

public final class DataEntryActivity extends Activity implements TextWatcher {
    private int f1054a = 1;
    private int f1055b = 100;
    private TextView f1056c;
    private EditText f1057d;
    private C0567r f1058e;
    private EditText f1059f;
    private C0567r f1060g;
    private EditText f1061h;
    private C0567r f1062i;
    private EditText f1063j;
    private C0567r f1064k;
    private ImageView f1065l;
    private Button f1066m;
    private Button f1067n;
    private CreditCard f1068o;
    private boolean f1069p;
    private String f1070q;
    private boolean f1071r;
    private int f1072s;
    private final String f1073t = getClass().getName();

    private void m831a() {
        if (this.f1068o == null) {
            this.f1068o = new CreditCard();
        }
        if (this.f1059f != null) {
            this.f1068o.expiryMonth = ((C0858j) this.f1060g).f1340a;
            this.f1068o.expiryYear = ((C0858j) this.f1060g).f1341b;
        }
        Parcelable creditCard = new CreditCard(this.f1058e.mo3791b(), this.f1068o.expiryMonth, this.f1068o.expiryYear, this.f1062i.mo3791b(), this.f1064k.mo3791b());
        Intent intent = new Intent();
        intent.putExtra(CardIOActivity.EXTRA_SCAN_RESULT, creditCard);
        setResult(CardIOActivity.RESULT_CARD_INFO, intent);
        finish();
    }

    private void m832a(EditText editText) {
        if (this.f1071r) {
            editText.setTextColor(this.f1072s);
        } else {
            editText.setTextColor(-12303292);
        }
    }

    private EditText m834b() {
        int i = 100;
        while (true) {
            int i2 = i + 1;
            EditText editText = (EditText) findViewById(i);
            if (editText == null) {
                return null;
            }
            if (editText.getText().length() == 0 && editText.requestFocus()) {
                return editText;
            }
            i = i2;
        }
    }

    private void m835c() {
        Button button = this.f1066m;
        boolean z = this.f1058e.mo3790a() && this.f1060g.mo3790a() && this.f1062i.mo3790a() && this.f1064k.mo3790a();
        button.setEnabled(z);
        new StringBuilder("setting doneBtn.enabled=").append(this.f1066m.isEnabled());
        if (this.f1069p && this.f1058e.mo3790a() && this.f1060g.mo3790a() && this.f1062i.mo3790a() && this.f1064k.mo3790a()) {
            m831a();
        }
    }

    public final void afterTextChanged(Editable editable) {
        if (this.f1057d != null && editable == this.f1057d.getText()) {
            if (!this.f1058e.mo3792c()) {
                m832a(this.f1057d);
            } else if (this.f1058e.mo3790a()) {
                m832a(this.f1057d);
                m834b();
            } else {
                this.f1057d.setTextColor(dE.f630d);
            }
            if (this.f1061h != null) {
                C0859k c0859k = (C0859k) this.f1062i;
                int cvvLength = CardType.fromCardNumber(this.f1058e.mo3791b().toString()).cvvLength();
                c0859k.f1343a = cvvLength;
                this.f1061h.setHint(cvvLength == 4 ? "1234" : "123");
            }
        } else if (this.f1059f == null || editable != this.f1059f.getText()) {
            if (this.f1061h == null || editable != this.f1061h.getText()) {
                if (this.f1063j != null && editable == this.f1063j.getText()) {
                    if (!this.f1064k.mo3792c()) {
                        m832a(this.f1063j);
                    } else if (this.f1064k.mo3790a()) {
                        m832a(this.f1063j);
                        m834b();
                    } else {
                        this.f1063j.setTextColor(dE.f630d);
                    }
                }
            } else if (!this.f1062i.mo3792c()) {
                m832a(this.f1061h);
            } else if (this.f1062i.mo3790a()) {
                m832a(this.f1061h);
                m834b();
            } else {
                this.f1061h.setTextColor(dE.f630d);
            }
        } else if (!this.f1060g.mo3792c()) {
            m832a(this.f1059f);
        } else if (this.f1060g.mo3790a()) {
            m832a(this.f1059f);
            m834b();
        } else {
            this.f1059f.setTextColor(dE.f630d);
        }
        m835c();
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent().getExtras() == null) {
            onBackPressed();
            return;
        }
        View textView;
        View textView2;
        LayoutParams layoutParams;
        this.f1071r = getIntent().getBooleanExtra(CardIOActivity.EXTRA_KEEP_APPLICATION_THEME, false);
        if (this.f1071r && getApplicationInfo().theme != 0) {
            setTheme(getApplicationInfo().theme);
        } else if (C0500V.m39a()) {
            setTheme(16973934);
        } else {
            setTheme(16973836);
        }
        this.f1072s = new TextView(this).getTextColors().getDefaultColor();
        this.f1070q = C0500V.m39a() ? "12dip" : "2dip";
        cZ.m421a(getIntent());
        int a = dF.m439a("4dip", this);
        View relativeLayout = new RelativeLayout(this);
        if (!this.f1071r) {
            relativeLayout.setBackgroundColor(dE.f629c);
        }
        View scrollView = new ScrollView(this);
        int i = this.f1054a;
        this.f1054a = i + 1;
        scrollView.setId(i);
        LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(10);
        relativeLayout.addView(scrollView, layoutParams2);
        View linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        scrollView.addView(linearLayout, -1, -1);
        View linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(1);
        LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -1);
        this.f1068o = (CreditCard) getIntent().getParcelableExtra(CardIOActivity.EXTRA_SCAN_RESULT);
        this.f1069p = getIntent().getBooleanExtra("debug_autoAcceptResult", false);
        if (this.f1068o != null) {
            this.f1058e = new C0857e(this.f1068o.cardNumber);
            this.f1065l = new ImageView(this);
            LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
            this.f1065l.setPadding(0, 0, 0, a);
            layoutParams4.weight = TextTrackStyle.DEFAULT_FONT_SCALE;
            this.f1065l.setImageBitmap(CardIOActivity.f1009a);
            linearLayout2.addView(this.f1065l, layoutParams4);
            dF.m445b(this.f1065l, null, null, null, "8dip");
        } else {
            this.f1056c = new TextView(this);
            this.f1056c.setTextSize(24.0f);
            if (!this.f1071r) {
                this.f1056c.setTextColor(dE.f627a);
            }
            linearLayout2.addView(this.f1056c);
            dF.m442a(this.f1056c, null, null, null, "8dip");
            dF.m441a(this.f1056c, -2, -2);
            scrollView = new LinearLayout(this);
            scrollView.setOrientation(1);
            dF.m442a(scrollView, null, "4dip", null, "4dip");
            textView = new TextView(this);
            dF.m442a(textView, this.f1070q, null, null, null);
            textView.setText(cZ.m419a(da.ENTRY_CARD_NUMBER));
            if (!this.f1071r) {
                textView.setTextColor(dE.f631e);
            }
            scrollView.addView(textView, -2, -2);
            this.f1057d = new EditText(this);
            EditText editText = this.f1057d;
            int i2 = this.f1055b;
            this.f1055b = i2 + 1;
            editText.setId(i2);
            this.f1057d.setMaxLines(1);
            this.f1057d.setImeOptions(6);
            this.f1057d.setTextAppearance(getApplicationContext(), 16842816);
            this.f1057d.setInputType(3);
            this.f1057d.setHint("1234 5678 1234 5678");
            this.f1058e = new C0857e();
            this.f1057d.addTextChangedListener(this.f1058e);
            this.f1057d.addTextChangedListener(this);
            this.f1057d.setFilters(new InputFilter[]{new DigitsKeyListener(), this.f1058e});
            scrollView.addView(this.f1057d, -1, -2);
            linearLayout2.addView(scrollView, -1, -1);
        }
        View linearLayout3 = new LinearLayout(this);
        LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
        dF.m442a(linearLayout3, null, "4dip", null, null);
        linearLayout3.setOrientation(0);
        boolean booleanExtra = getIntent().getBooleanExtra(CardIOActivity.EXTRA_REQUIRE_EXPIRY, false);
        boolean booleanExtra2 = getIntent().getBooleanExtra(CardIOActivity.EXTRA_REQUIRE_CVV, false);
        boolean booleanExtra3 = getIntent().getBooleanExtra(CardIOActivity.EXTRA_REQUIRE_POSTAL_CODE, false);
        if (booleanExtra) {
            textView = new LinearLayout(this);
            layoutParams4 = new LinearLayout.LayoutParams(0, -1, TextTrackStyle.DEFAULT_FONT_SCALE);
            textView.setOrientation(1);
            textView2 = new TextView(this);
            if (!this.f1071r) {
                textView2.setTextColor(dE.f631e);
            }
            textView2.setText(cZ.m419a(da.ENTRY_EXPIRES));
            dF.m442a(textView2, this.f1070q, null, null, null);
            textView.addView(textView2, -2, -2);
            this.f1059f = new EditText(this);
            EditText editText2 = this.f1059f;
            int i3 = this.f1055b;
            this.f1055b = i3 + 1;
            editText2.setId(i3);
            this.f1059f.setMaxLines(1);
            this.f1059f.setImeOptions(6);
            this.f1059f.setTextAppearance(getApplicationContext(), 16842816);
            this.f1059f.setInputType(3);
            this.f1059f.setHint(cZ.m419a(da.EXPIRES_PLACEHOLDER));
            if (this.f1068o != null) {
                this.f1060g = new C0858j(this.f1068o.expiryMonth, this.f1068o.expiryYear);
            } else {
                this.f1060g = new C0858j();
            }
            if (this.f1060g.mo3792c()) {
                this.f1059f.setText(this.f1060g.mo3791b());
            }
            this.f1059f.addTextChangedListener(this.f1060g);
            this.f1059f.addTextChangedListener(this);
            this.f1059f.setFilters(new InputFilter[]{new DateKeyListener(), this.f1060g});
            textView.addView(this.f1059f, -1, -2);
            linearLayout3.addView(textView, layoutParams4);
            String str = (booleanExtra2 || booleanExtra3) ? "4dip" : null;
            dF.m445b(textView, null, null, str, null);
        } else {
            this.f1060g = new C0856a();
        }
        if (booleanExtra2) {
            textView2 = new LinearLayout(this);
            layoutParams = new LinearLayout.LayoutParams(0, -1, TextTrackStyle.DEFAULT_FONT_SCALE);
            textView2.setOrientation(1);
            scrollView = new TextView(this);
            if (!this.f1071r) {
                scrollView.setTextColor(dE.f631e);
            }
            dF.m442a(scrollView, this.f1070q, null, null, null);
            scrollView.setText(cZ.m419a(da.ENTRY_CVV));
            textView2.addView(scrollView, -2, -2);
            this.f1061h = new EditText(this);
            EditText editText3 = this.f1061h;
            i3 = this.f1055b;
            this.f1055b = i3 + 1;
            editText3.setId(i3);
            this.f1061h.setMaxLines(1);
            this.f1061h.setImeOptions(6);
            this.f1061h.setTextAppearance(getApplicationContext(), 16842816);
            this.f1061h.setInputType(3);
            this.f1061h.setHint("123");
            int i4 = 4;
            if (this.f1068o != null) {
                i4 = CardType.fromCardNumber(this.f1058e.mo3791b()).cvvLength();
            }
            this.f1062i = new C0859k(i4);
            this.f1061h.setFilters(new InputFilter[]{new DigitsKeyListener(), this.f1062i});
            this.f1061h.addTextChangedListener(this.f1062i);
            this.f1061h.addTextChangedListener(this);
            textView2.addView(this.f1061h, -1, -2);
            linearLayout3.addView(textView2, layoutParams);
            dF.m445b(textView2, booleanExtra ? "4dip" : null, null, booleanExtra3 ? "4dip" : null, null);
        } else {
            this.f1062i = new C0856a();
        }
        if (booleanExtra3) {
            textView = new LinearLayout(this);
            layoutParams4 = new LinearLayout.LayoutParams(0, -1, TextTrackStyle.DEFAULT_FONT_SCALE);
            textView.setOrientation(1);
            textView2 = new TextView(this);
            if (!this.f1071r) {
                textView2.setTextColor(dE.f631e);
            }
            dF.m442a(textView2, this.f1070q, null, null, null);
            textView2.setText(cZ.m419a(da.ENTRY_POSTAL_CODE));
            textView.addView(textView2, -2, -2);
            this.f1063j = new EditText(this);
            EditText editText4 = this.f1063j;
            int i5 = this.f1055b;
            this.f1055b = i5 + 1;
            editText4.setId(i5);
            this.f1063j.setMaxLines(1);
            this.f1063j.setImeOptions(6);
            this.f1063j.setTextAppearance(getApplicationContext(), 16842816);
            this.f1063j.setInputType(1);
            this.f1064k = new C1176l(20);
            this.f1063j.addTextChangedListener(this.f1064k);
            this.f1063j.addTextChangedListener(this);
            textView.addView(this.f1063j, -1, -2);
            linearLayout3.addView(textView, layoutParams4);
            str = (booleanExtra || booleanExtra2) ? "4dip" : null;
            dF.m445b(textView, str, null, null, null);
        } else {
            this.f1064k = new C0856a();
        }
        linearLayout2.addView(linearLayout3, layoutParams5);
        linearLayout.addView(linearLayout2, layoutParams3);
        dF.m445b(linearLayout2, "16dip", "20dip", "16dip", "20dip");
        scrollView = new LinearLayout(this);
        i = this.f1054a;
        this.f1054a = i + 1;
        scrollView.setId(i);
        layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        scrollView.setPadding(0, a, 0, 0);
        scrollView.setBackgroundColor(0);
        layoutParams2.addRule(2, scrollView.getId());
        this.f1066m = new Button(this);
        LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2, TextTrackStyle.DEFAULT_FONT_SCALE);
        this.f1066m.setText(cZ.m419a(da.DONE));
        this.f1066m.setOnClickListener(new C0561h(this));
        this.f1066m.setEnabled(false);
        scrollView.addView(this.f1066m, layoutParams6);
        dF.m443a(this.f1066m, true, (Context) this);
        dF.m442a(this.f1066m, "5dip", null, "5dip", null);
        dF.m445b(this.f1066m, "8dip", "8dip", "4dip", "8dip");
        this.f1066m.setTextSize(16.0f);
        this.f1067n = new Button(this);
        layoutParams6 = new LinearLayout.LayoutParams(-1, -2, TextTrackStyle.DEFAULT_FONT_SCALE);
        this.f1067n.setText(cZ.m419a(da.CANCEL));
        this.f1067n.setOnClickListener(new C0562i(this));
        scrollView.addView(this.f1067n, layoutParams6);
        dF.m443a(this.f1067n, false, (Context) this);
        dF.m442a(this.f1067n, "5dip", null, "5dip", null);
        dF.m445b(this.f1067n, "4dip", "8dip", "8dip", "8dip");
        this.f1067n.setTextSize(16.0f);
        relativeLayout.addView(scrollView, layoutParams);
        C0500V.m37a((Activity) this);
        setContentView(relativeLayout);
        Drawable drawable = null;
        if (getIntent().getBooleanExtra(CardIOActivity.EXTRA_USE_PAYPAL_ACTIONBAR_ICON, true)) {
            drawable = new BitmapDrawable(getResources(), dF.m440a("iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAYAAABXAvmHAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyRpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMy1jMDExIDY2LjE0NTY2MSwgMjAxMi8wMi8wNi0xNDo1NjoyNyAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENTNiAoTWFjaW50b3NoKSIgeG1wTU06SW5zdGFuY2VJRD0ieG1wLmlpZDpCNDMzRTRFQ0M2MjQxMUUzOURBQ0E3QTY0NjU3OUI5QiIgeG1wTU06RG9jdW1lbnRJRD0ieG1wLmRpZDpCNDMzRTRFREM2MjQxMUUzOURBQ0E3QTY0NjU3OUI5QiI+IDx4bXBNTTpEZXJpdmVkRnJvbSBzdFJlZjppbnN0YW5jZUlEPSJ4bXAuaWlkOkI0MzNFNEVBQzYyNDExRTM5REFDQTdBNjQ2NTc5QjlCIiBzdFJlZjpkb2N1bWVudElEPSJ4bXAuZGlkOkI0MzNFNEVCQzYyNDExRTM5REFDQTdBNjQ2NTc5QjlCIi8+IDwvcmRmOkRlc2NyaXB0aW9uPiA8L3JkZjpSREY+IDwveDp4bXBtZXRhPiA8P3hwYWNrZXQgZW5kPSJyIj8+Eyd0MQAABoFJREFUeNrMWl1M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", (Context) this, 240));
        }
        if (booleanExtra && this.f1060g.mo3790a()) {
            afterTextChanged(this.f1059f.getEditableText());
        }
        C0500V.m38a(this, this.f1056c, cZ.m419a(da.MANUAL_ENTRY_TITLE), "card.io - ", drawable);
    }

    protected final void onResume() {
        super.onResume();
        getWindow().setFlags(0, 1024);
        C0500V.m40b((Activity) this);
        m835c();
        if (this.f1057d != null || this.f1059f == null || this.f1060g.mo3790a()) {
            m834b();
        } else {
            this.f1059f.requestFocus();
        }
        if (this.f1057d != null || this.f1059f != null || this.f1061h != null || this.f1063j != null) {
            getWindow().setSoftInputMode(5);
        }
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
