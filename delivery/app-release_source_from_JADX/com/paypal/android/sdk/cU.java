package com.paypal.android.sdk;

import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public final class cU {
    private LinearLayout f559a;
    private RelativeLayout f560b;
    private ImageView f561c;
    private ImageView f562d;
    private TextView f563e;
    private TextView f564f;
    private TextView f565g;
    private TextView f566h;

    public cU(Context context) {
        this.f559a = new LinearLayout(context);
        this.f559a.setOrientation(1);
        this.f560b = new RelativeLayout(context);
        this.f559a.addView(this.f560b);
        this.f561c = new ImageView(context);
        this.f561c.setId(2301);
        this.f560b.addView(this.f561c);
        bp.m321b(this.f561c, "35dip", "35dip");
        bp.m322b(this.f561c, null, "4dip", null, null);
        this.f562d = bp.m302a(context, "iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAYAAABXAvmHAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAATZJREFUeNrsmMENgkAQRVnPUoAWQB0WoAVoAViA3tW7FEADUIDebUAaoAELwDv+TcaEkFUOsDhj5ieTTdgQ5jHLZ3aDQKVSqVSqAVTX9Q4RSUw8RKSIO+KGmI/5fNMzeZvsGdF88yVia4ypxgCY9Lx/ipi1rkUExb8CVIXFh4SvqMKRPQBBrDAcHFMJIHL2AG8XwrB2TJ0AcWEPQBB2ySwdUxtAlBIAQgxpy5WsKnKmkjVAAyJzuJMXezU+ykp/ZFuJsA0BgA17gAZE5ttevQF02GsOiIQ9AEHEGGJf9uodoMNe7UddsAcgiMyHvU4C4dIl9NcfsWgbFf0jE91KiG7mxLfTojc0oreUojf1oo9VvthlgeS3Y7QpfZu5J+LhsMu9mG7w14e7Q4LIPF5XqVQqlWi9BBgAacm2vqgEoPIAAAAASUVORK5CYII=", "go to selection");
        this.f562d.setId(2304);
        this.f562d.setColorFilter(bo.f345g);
        LayoutParams a = bp.m306a(context, "20dip", "20dip", 11);
        a.addRule(15);
        this.f560b.addView(this.f562d, a);
        this.f563e = new TextView(context);
        bp.m327d(this.f563e, 83);
        this.f563e.setId(2302);
        a = bp.m305a(-2, -2, 1, 2301);
        a.addRule(0, 2304);
        this.f560b.addView(this.f563e, a);
        bp.m322b(this.f563e, "6dip", null, null, null);
        View linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setId(2306);
        LayoutParams a2 = bp.m305a(-2, -2, 1, 2301);
        a2.addRule(3, 2302);
        a2.addRule(0, 2304);
        this.f560b.addView(linearLayout, a2);
        this.f564f = new TextView(context);
        bp.m324b(this.f564f, 83);
        linearLayout.addView(this.f564f);
        bp.m322b(this.f564f, "6dip", null, null, null);
        this.f565g = new TextView(context);
        this.f565g.setId(2305);
        bp.m327d(this.f565g, 83);
        linearLayout.addView(this.f565g);
        bp.m322b(this.f565g, "6dip", null, null, null);
        this.f566h = new TextView(context);
        this.f566h.setId(2307);
        bp.m326c(this.f566h, 83);
        a = bp.m305a(-2, -2, 1, 2301);
        a.addRule(3, 2306);
        a.addRule(0, 2304);
        this.f560b.addView(this.f566h, a);
        this.f566h.setText(cz.m428a(cB.PAY_AFTER_DELIVERY));
        bp.m322b(this.f566h, "6dip", null, null, null);
        this.f566h.setVisibility(8);
        bp.m299a(this.f559a);
        this.f559a.setVisibility(8);
    }

    public final View m406a() {
        return this.f559a;
    }

    public final void m407a(Context context, cT cTVar) {
        this.f561c.setImageBitmap(bp.m325c(cTVar.mo3742a(), context));
        this.f563e.setText(cTVar.mo3743b());
        bp.m309a(this.f563e, -2, -1);
        this.f564f.setText(cTVar.mo3744c());
        bp.m309a(this.f564f, -2, -1);
        this.f564f.setEllipsize(TruncateAt.END);
        this.f565g.setText(cTVar.mo3745d());
        bp.m309a(this.f565g, -2, -1);
        this.f565g.setEllipsize(TruncateAt.END);
        if (cTVar.mo3746e()) {
            this.f566h.setVisibility(0);
        } else {
            this.f566h.setVisibility(8);
        }
    }

    public final void m408a(OnClickListener onClickListener) {
        this.f559a.setOnClickListener(onClickListener);
    }
}
