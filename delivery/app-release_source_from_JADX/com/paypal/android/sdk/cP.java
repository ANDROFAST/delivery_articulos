package com.paypal.android.sdk;

import android.content.Context;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import com.google.android.gms.cast.TextTrackStyle;

public final class cP {
    public TableLayout f545a;
    public TableLayout f546b;
    public TextView f547c;
    public TextView f548d;
    private int f549e;
    private boolean f550f = false;

    public cP(Context context, String str) {
        this.f546b = new TableLayout(context);
        this.f546b.setColumnShrinkable(0, false);
        this.f546b.setColumnStretchable(0, false);
        this.f546b.setColumnStretchable(1, false);
        this.f546b.setColumnShrinkable(1, false);
        View tableRow = new TableRow(context);
        this.f546b.addView(tableRow);
        this.f548d = new TextView(context);
        this.f548d.setTextColor(bo.f347i);
        this.f548d.setText("Item");
        this.f548d.setSingleLine(true);
        this.f548d.setGravity(83);
        this.f548d.setTextSize(18.0f);
        this.f548d.setTextColor(bo.f347i);
        this.f548d.setTypeface(bo.f355q);
        tableRow.addView(this.f548d);
        bp.m308a(this.f548d, 16, (float) TextTrackStyle.DEFAULT_FONT_SCALE);
        this.f549e = bp.m297a("10dip", context);
        bp.m322b(this.f548d, null, null, "10dip", null);
        this.f547c = new TextView(context);
        this.f547c.setTextSize(18.0f);
        this.f547c.setTypeface(bo.f356r);
        this.f547c.setText(str);
        this.f547c.setSingleLine(true);
        this.f547c.setGravity(85);
        this.f547c.setTextColor(bo.f348j);
        tableRow.addView(this.f547c);
        bp.m308a(this.f547c, 5, (float) TextTrackStyle.DEFAULT_FONT_SCALE);
        this.f545a = this.f546b;
    }

    public final void m398a() {
        TextView textView = this.f547c;
        TextView textView2 = this.f548d;
        int width = (this.f546b.getWidth() - ((int) textView.getPaint().measureText(textView.getText().toString()))) - this.f549e;
        CharSequence ellipsize = TextUtils.ellipsize(textView2.getText(), textView2.getPaint(), (float) width, TruncateAt.END);
        textView2.setWidth(width);
        textView2.setText(ellipsize);
    }
}
