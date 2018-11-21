package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.Path;
import android.net.Uri;
import android.widget.ImageView;

public final class zzmw extends ImageView {
    private Uri zzaiJ;
    private int zzaiK;
    private int zzaiL;
    private zza zzaiM;
    private int zzaiN;
    private float zzaiO;

    public interface zza {
        Path zzl(int i, int i2);
    }

    protected void onDraw(Canvas canvas) {
        if (this.zzaiM != null) {
            canvas.clipPath(this.zzaiM.zzl(getWidth(), getHeight()));
        }
        super.onDraw(canvas);
        if (this.zzaiL != 0) {
            canvas.drawColor(this.zzaiL);
        }
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int measuredHeight;
        int i;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        switch (this.zzaiN) {
            case 1:
                measuredHeight = getMeasuredHeight();
                i = (int) (((float) measuredHeight) * this.zzaiO);
                break;
            case 2:
                i = getMeasuredWidth();
                measuredHeight = (int) (((float) i) / this.zzaiO);
                break;
            default:
                return;
        }
        setMeasuredDimension(i, measuredHeight);
    }

    public void zzbP(int i) {
        this.zzaiK = i;
    }

    public void zzm(Uri uri) {
        this.zzaiJ = uri;
    }

    public int zzpX() {
        return this.zzaiK;
    }
}
