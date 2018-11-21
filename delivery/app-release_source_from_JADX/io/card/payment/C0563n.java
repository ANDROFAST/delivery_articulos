package io.card.payment;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.paypal.android.sdk.cZ;
import com.paypal.android.sdk.da;
import java.lang.ref.WeakReference;

class C0563n extends View {
    private static final String f1084a = C0563n.class.getSimpleName();
    private static final Orientation[] f1085b = new Orientation[]{Orientation.TOP_BOTTOM, Orientation.LEFT_RIGHT, Orientation.BOTTOM_TOP, Orientation.RIGHT_LEFT};
    private final WeakReference f1086c;
    private DetectionInfo f1087d;
    private Bitmap f1088e;
    private Rect f1089f;
    private CreditCard f1090g;
    private int f1091h;
    private int f1092i;
    private boolean f1093j = false;
    private String f1094k;
    private GradientDrawable f1095l;
    private final Paint f1096m;
    private final Paint f1097n;
    private Path f1098o;
    private Rect f1099p;
    private final C0565p f1100q;
    private final C0560g f1101r;
    private Rect f1102s;
    private Rect f1103t;
    private final boolean f1104u;
    private int f1105v;
    private float f1106w = TextTrackStyle.DEFAULT_FONT_SCALE;

    public C0563n(CardIOActivity cardIOActivity, AttributeSet attributeSet, boolean z) {
        super(cardIOActivity, null);
        this.f1104u = z;
        this.f1086c = new WeakReference(cardIOActivity);
        this.f1105v = 1;
        this.f1106w = getResources().getDisplayMetrics().density / 1.5f;
        this.f1100q = new C0565p(70.0f * this.f1106w, 50.0f * this.f1106w);
        this.f1101r = new C0560g(cardIOActivity);
        this.f1096m = new Paint(1);
        this.f1097n = new Paint(1);
        this.f1097n.clearShadowLayer();
        this.f1097n.setStyle(Style.FILL);
        this.f1097n.setColor(-1157627904);
        this.f1094k = cZ.m419a(da.SCAN_GUIDE);
    }

    private Rect m844a(int i, int i2, int i3, int i4) {
        int i5 = (int) (8.0f * this.f1106w);
        Rect rect = new Rect();
        rect.left = Math.min(i, i3) - i5;
        rect.right = Math.max(i, i3) + i5;
        rect.top = Math.min(i2, i4) - i5;
        rect.bottom = i5 + Math.max(i2, i4);
        return rect;
    }

    public final Bitmap m845a() {
        return this.f1088e;
    }

    public final void m846a(int i) {
        this.f1092i = i;
    }

    public final void m847a(Bitmap bitmap) {
        if (this.f1088e != null) {
            this.f1088e.recycle();
        }
        this.f1088e = bitmap;
        if (this.f1088e != null) {
            RectF rectF = new RectF(2.0f, 2.0f, (float) (this.f1088e.getWidth() - 2), (float) (this.f1088e.getHeight() - 2));
            float height = ((float) this.f1088e.getHeight()) * 0.06666667f;
            Bitmap createBitmap = Bitmap.createBitmap(this.f1088e.getWidth(), this.f1088e.getHeight(), Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawColor(0);
            Paint paint = new Paint(1);
            paint.setColor(ViewCompat.MEASURED_STATE_MASK);
            paint.setStyle(Style.FILL);
            canvas.drawRoundRect(rectF, height, height, paint);
            Paint paint2 = new Paint();
            paint2.setFilterBitmap(false);
            Canvas canvas2 = new Canvas(this.f1088e);
            paint2.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
            canvas2.drawBitmap(createBitmap, 0.0f, 0.0f, paint2);
            paint2.setXfermode(null);
            createBitmap.recycle();
        }
    }

    public final void m848a(Rect rect) {
        this.f1099p = rect;
    }

    public final void m849a(Rect rect, int i) {
        Point point;
        new StringBuilder("setGuideAndRotation: ").append(rect).append(", ").append(i);
        this.f1091h = i;
        this.f1089f = rect;
        invalidate();
        if (this.f1091h % 180 != 0) {
            point = new Point((int) (this.f1106w * 40.0f), (int) (this.f1106w * BitmapDescriptorFactory.HUE_YELLOW));
            this.f1105v = -1;
        } else {
            point = new Point((int) (this.f1106w * BitmapDescriptorFactory.HUE_YELLOW), (int) (this.f1106w * 40.0f));
            this.f1105v = 1;
        }
        if (this.f1099p != null) {
            new StringBuilder().append(this.f1099p).append(", ").append(point).append(", ").append(this.f1099p).append(", ").append(point);
            this.f1102s = C0566q.m862a(new Point(this.f1099p.left + point.x, this.f1099p.top + point.y), (int) (70.0f * this.f1106w), (int) (this.f1106w * 50.0f));
            this.f1103t = C0566q.m862a(new Point(this.f1099p.right - point.x, point.y + this.f1099p.top), (int) (100.0f * this.f1106w), (int) (this.f1106w * 50.0f));
            this.f1095l = new GradientDrawable(f1085b[(this.f1091h / 90) % 4], new int[]{-1, ViewCompat.MEASURED_STATE_MASK});
            this.f1095l.setGradientType(0);
            this.f1095l.setBounds(this.f1089f);
            this.f1095l.setAlpha(50);
            this.f1098o = new Path();
            this.f1098o.addRect(new RectF(this.f1099p), Direction.CW);
            this.f1098o.addRect(new RectF(this.f1089f), Direction.CCW);
        }
    }

    public final void m850a(CreditCard creditCard) {
        this.f1090g = creditCard;
    }

    public final void m851a(DetectionInfo detectionInfo) {
        if (this.f1087d != null) {
            DetectionInfo detectionInfo2 = this.f1087d;
            Object obj = (detectionInfo.topEdge == detectionInfo2.topEdge && detectionInfo.bottomEdge == detectionInfo2.bottomEdge && detectionInfo.leftEdge == detectionInfo2.leftEdge && detectionInfo.rightEdge == detectionInfo2.rightEdge) ? 1 : null;
            if (obj == null) {
                invalidate();
            }
        }
        this.f1087d = detectionInfo;
    }

    public final void m852a(String str) {
        this.f1094k = str;
    }

    public final void m853a(boolean z) {
        this.f1093j = z;
    }

    public final Bitmap m854b() {
        return (this.f1088e == null || this.f1088e.isRecycled()) ? null : Bitmap.createBitmap(this.f1088e, 0, 0, this.f1088e.getWidth(), this.f1088e.getHeight());
    }

    public final void m855b(boolean z) {
        this.f1100q.m861a(z);
        invalidate();
    }

    public final void m856c() {
        int i = 0;
        if (this.f1088e != null) {
            if (this.f1090g.flipped) {
                Matrix matrix = new Matrix();
                matrix.setRotate(BitmapDescriptorFactory.HUE_CYAN, (float) (this.f1088e.getWidth() / 2), (float) (this.f1088e.getHeight() / 2));
                this.f1088e = Bitmap.createBitmap(this.f1088e, 0, 0, this.f1088e.getWidth(), this.f1088e.getHeight(), matrix, false);
            }
            Canvas canvas = new Canvas(this.f1088e);
            Paint paint = new Paint();
            C0566q.m864a(paint);
            paint.setTextSize(28.0f * this.f1106w);
            int length = this.f1090g.cardNumber.length();
            float width = ((float) this.f1088e.getWidth()) / 428.0f;
            int i2 = (int) ((((float) this.f1090g.yoff) * width) - 6.0f);
            while (i < length) {
                canvas.drawText(this.f1090g.cardNumber.charAt(i), (float) ((int) (((float) this.f1090g.xoff[i]) * width)), (float) i2, paint);
                i++;
            }
        }
    }

    public final void m857c(boolean z) {
        this.f1101r.m843a(z);
    }

    public final Rect m858d() {
        return this.f1102s;
    }

    public void onDraw(Canvas canvas) {
        if (this.f1089f != null && this.f1099p != null) {
            canvas.save();
            this.f1095l.draw(canvas);
            int i = (this.f1091h == 0 || this.f1091h == 180) ? (this.f1089f.bottom - this.f1089f.top) / 4 : (this.f1089f.right - this.f1089f.left) / 4;
            if (this.f1087d != null && this.f1087d.m837b() == 4) {
                canvas.drawPath(this.f1098o, this.f1097n);
            }
            this.f1096m.clearShadowLayer();
            this.f1096m.setStyle(Style.FILL);
            this.f1096m.setColor(this.f1092i);
            canvas.drawRect(m844a(this.f1089f.left, this.f1089f.top, this.f1089f.left + i, this.f1089f.top), this.f1096m);
            canvas.drawRect(m844a(this.f1089f.left, this.f1089f.top, this.f1089f.left, this.f1089f.top + i), this.f1096m);
            canvas.drawRect(m844a(this.f1089f.right, this.f1089f.top, this.f1089f.right - i, this.f1089f.top), this.f1096m);
            canvas.drawRect(m844a(this.f1089f.right, this.f1089f.top, this.f1089f.right, this.f1089f.top + i), this.f1096m);
            canvas.drawRect(m844a(this.f1089f.left, this.f1089f.bottom, this.f1089f.left + i, this.f1089f.bottom), this.f1096m);
            canvas.drawRect(m844a(this.f1089f.left, this.f1089f.bottom, this.f1089f.left, this.f1089f.bottom - i), this.f1096m);
            canvas.drawRect(m844a(this.f1089f.right, this.f1089f.bottom, this.f1089f.right - i, this.f1089f.bottom), this.f1096m);
            canvas.drawRect(m844a(this.f1089f.right, this.f1089f.bottom, this.f1089f.right, this.f1089f.bottom - i), this.f1096m);
            if (this.f1087d != null) {
                if (this.f1087d.topEdge) {
                    canvas.drawRect(m844a(this.f1089f.left, this.f1089f.top, this.f1089f.right, this.f1089f.top), this.f1096m);
                }
                if (this.f1087d.bottomEdge) {
                    canvas.drawRect(m844a(this.f1089f.left, this.f1089f.bottom, this.f1089f.right, this.f1089f.bottom), this.f1096m);
                }
                if (this.f1087d.leftEdge) {
                    canvas.drawRect(m844a(this.f1089f.left, this.f1089f.top, this.f1089f.left, this.f1089f.bottom), this.f1096m);
                }
                if (this.f1087d.rightEdge) {
                    canvas.drawRect(m844a(this.f1089f.right, this.f1089f.top, this.f1089f.right, this.f1089f.bottom), this.f1096m);
                }
                if (this.f1087d.m837b() < 3) {
                    float f = 34.0f * this.f1106w;
                    float f2 = 26.0f * this.f1106w;
                    C0566q.m864a(this.f1096m);
                    this.f1096m.setTextAlign(Align.CENTER);
                    this.f1096m.setTextSize(f2);
                    canvas.translate((float) (this.f1089f.left + (this.f1089f.width() / 2)), (float) (this.f1089f.top + (this.f1089f.height() / 2)));
                    canvas.rotate((float) (this.f1105v * this.f1091h));
                    if (!(this.f1094k == null || this.f1094k == "")) {
                        String[] split = this.f1094k.split("\n");
                        float f3 = (-(((((float) (split.length - 1)) * f) - f2) / 2.0f)) - 3.0f;
                        for (String drawText : split) {
                            canvas.drawText(drawText, 0.0f, f3, this.f1096m);
                            f3 += f;
                        }
                    }
                }
            }
            canvas.restore();
            if (!this.f1093j) {
                canvas.save();
                canvas.translate(this.f1103t.exactCenterX(), this.f1103t.exactCenterY());
                canvas.rotate((float) (this.f1105v * this.f1091h));
                this.f1101r.m842a(canvas, 100.0f * this.f1106w, 50.0f * this.f1106w);
                canvas.restore();
            }
            if (this.f1104u) {
                canvas.save();
                canvas.translate(this.f1102s.exactCenterX(), this.f1102s.exactCenterY());
                canvas.rotate((float) (this.f1105v * this.f1091h));
                this.f1100q.m860a(canvas);
                canvas.restore();
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            if ((motionEvent.getAction() & MotionEventCompat.ACTION_MASK) == 0) {
                Point point = new Point((int) motionEvent.getX(), (int) motionEvent.getY());
                Rect a = C0566q.m862a(point, 20, 20);
                new StringBuilder("onTouchEvent: ").append(point);
                if (this.f1104u && this.f1102s != null && Rect.intersects(this.f1102s, a)) {
                    ((CardIOActivity) this.f1086c.get()).m813a();
                } else if (this.f1103t == null || !Rect.intersects(this.f1103t, a)) {
                    ((CardIOActivity) this.f1086c.get()).m817b();
                }
            }
        } catch (NullPointerException e) {
        }
        return false;
    }
}
