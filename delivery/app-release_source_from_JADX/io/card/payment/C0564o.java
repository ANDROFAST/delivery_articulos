package io.card.payment;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.ViewGroup;

class C0564o extends ViewGroup {
    static final /* synthetic */ boolean f1107a = (!C0564o.class.desiredAssertionStatus());
    private static final String f1108b = C0564o.class.getSimpleName();
    private int f1109c = 480;
    private int f1110d = 640;
    private SurfaceView f1111e;

    public C0564o(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, null);
        this.f1111e = new SurfaceView(context);
        addView(this.f1111e);
    }

    public final SurfaceView m859a() {
        if (f1107a || this.f1111e != null) {
            return this.f1111e;
        }
        throw new AssertionError();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawARGB(MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK, 0, 0);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        new StringBuilder("- isSurfaceValid: ").append(false);
        if (z && getChildCount() > 0) {
            if (f1107a || this.f1111e != null) {
                int i5 = i3 - i;
                int i6 = i4 - i2;
                int i7;
                if (this.f1110d * i5 > this.f1109c * i6) {
                    i7 = (this.f1109c * i6) / this.f1110d;
                    this.f1111e.layout((i5 - i7) / 2, 0, (i5 + i7) / 2, i6);
                    return;
                }
                i7 = (this.f1110d * i5) / this.f1109c;
                this.f1111e.layout(0, (i6 - i7) / 2, i5, (i6 + i7) / 2);
                return;
            }
            throw new AssertionError();
        }
    }

    protected void onMeasure(int i, int i2) {
        String.format("Preview.onMeasure(w:%d, h:%d) setMeasuredDimension(w:%d, h:%d)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(C0564o.resolveSize(getSuggestedMinimumWidth(), i)), Integer.valueOf(C0564o.resolveSize(getSuggestedMinimumHeight(), i2))});
        setMeasuredDimension(r0, r1);
    }
}
