package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.SystemClock;
import android.support.v4.view.MotionEventCompat;
import com.google.android.gms.cast.TextTrackStyle;

public final class zzmu extends Drawable implements Callback {
    private int mFrom;
    private long zzQj;
    private Drawable zzaiA;
    private boolean zzaiB;
    private boolean zzaiC;
    private boolean zzaiD;
    private int zzaiE;
    private boolean zzail;
    private int zzais;
    private int zzait;
    private int zzaiu;
    private int zzaiv;
    private int zzaiw;
    private boolean zzaix;
    private zzb zzaiy;
    private Drawable zzaiz;

    private static final class zza extends Drawable {
        private static final zza zzaiF = new zza();
        private static final zza zzaiG = new zza();

        private static final class zza extends ConstantState {
            private zza() {
            }

            public int getChangingConfigurations() {
                return 0;
            }

            public Drawable newDrawable() {
                return zza.zzaiF;
            }
        }

        private zza() {
        }

        public void draw(Canvas canvas) {
        }

        public ConstantState getConstantState() {
            return zzaiG;
        }

        public int getOpacity() {
            return -2;
        }

        public void setAlpha(int alpha) {
        }

        public void setColorFilter(ColorFilter cf) {
        }
    }

    static final class zzb extends ConstantState {
        int zzaiH;
        int zzaiI;

        zzb(zzb com_google_android_gms_internal_zzmu_zzb) {
            if (com_google_android_gms_internal_zzmu_zzb != null) {
                this.zzaiH = com_google_android_gms_internal_zzmu_zzb.zzaiH;
                this.zzaiI = com_google_android_gms_internal_zzmu_zzb.zzaiI;
            }
        }

        public int getChangingConfigurations() {
            return this.zzaiH;
        }

        public Drawable newDrawable() {
            return new zzmu(this);
        }
    }

    public zzmu(Drawable drawable, Drawable drawable2) {
        this(null);
        if (drawable == null) {
            drawable = zza.zzaiF;
        }
        this.zzaiz = drawable;
        drawable.setCallback(this);
        zzb com_google_android_gms_internal_zzmu_zzb = this.zzaiy;
        com_google_android_gms_internal_zzmu_zzb.zzaiI |= drawable.getChangingConfigurations();
        if (drawable2 == null) {
            drawable2 = zza.zzaiF;
        }
        this.zzaiA = drawable2;
        drawable2.setCallback(this);
        com_google_android_gms_internal_zzmu_zzb = this.zzaiy;
        com_google_android_gms_internal_zzmu_zzb.zzaiI |= drawable2.getChangingConfigurations();
    }

    zzmu(zzb com_google_android_gms_internal_zzmu_zzb) {
        this.zzais = 0;
        this.zzaiu = MotionEventCompat.ACTION_MASK;
        this.zzaiw = 0;
        this.zzail = true;
        this.zzaiy = new zzb(com_google_android_gms_internal_zzmu_zzb);
    }

    public boolean canConstantState() {
        if (!this.zzaiB) {
            boolean z = (this.zzaiz.getConstantState() == null || this.zzaiA.getConstantState() == null) ? false : true;
            this.zzaiC = z;
            this.zzaiB = true;
        }
        return this.zzaiC;
    }

    public void draw(Canvas canvas) {
        int i = 1;
        int i2 = 0;
        switch (this.zzais) {
            case 1:
                this.zzQj = SystemClock.uptimeMillis();
                this.zzais = 2;
                break;
            case 2:
                if (this.zzQj >= 0) {
                    float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.zzQj)) / ((float) this.zzaiv);
                    if (uptimeMillis < TextTrackStyle.DEFAULT_FONT_SCALE) {
                        i = 0;
                    }
                    if (i != 0) {
                        this.zzais = 0;
                    }
                    float min = Math.min(uptimeMillis, TextTrackStyle.DEFAULT_FONT_SCALE);
                    this.zzaiw = (int) ((min * ((float) (this.zzait - this.mFrom))) + ((float) this.mFrom));
                    break;
                }
                break;
        }
        i2 = i;
        i = this.zzaiw;
        boolean z = this.zzail;
        Drawable drawable = this.zzaiz;
        Drawable drawable2 = this.zzaiA;
        if (i2 != 0) {
            if (!z || i == 0) {
                drawable.draw(canvas);
            }
            if (i == this.zzaiu) {
                drawable2.setAlpha(this.zzaiu);
                drawable2.draw(canvas);
                return;
            }
            return;
        }
        if (z) {
            drawable.setAlpha(this.zzaiu - i);
        }
        drawable.draw(canvas);
        if (z) {
            drawable.setAlpha(this.zzaiu);
        }
        if (i > 0) {
            drawable2.setAlpha(i);
            drawable2.draw(canvas);
            drawable2.setAlpha(this.zzaiu);
        }
        invalidateSelf();
    }

    public int getChangingConfigurations() {
        return (super.getChangingConfigurations() | this.zzaiy.zzaiH) | this.zzaiy.zzaiI;
    }

    public ConstantState getConstantState() {
        if (!canConstantState()) {
            return null;
        }
        this.zzaiy.zzaiH = getChangingConfigurations();
        return this.zzaiy;
    }

    public int getIntrinsicHeight() {
        return Math.max(this.zzaiz.getIntrinsicHeight(), this.zzaiA.getIntrinsicHeight());
    }

    public int getIntrinsicWidth() {
        return Math.max(this.zzaiz.getIntrinsicWidth(), this.zzaiA.getIntrinsicWidth());
    }

    public int getOpacity() {
        if (!this.zzaiD) {
            this.zzaiE = Drawable.resolveOpacity(this.zzaiz.getOpacity(), this.zzaiA.getOpacity());
            this.zzaiD = true;
        }
        return this.zzaiE;
    }

    public void invalidateDrawable(Drawable who) {
        if (zznx.zzrN()) {
            Callback callback = getCallback();
            if (callback != null) {
                callback.invalidateDrawable(this);
            }
        }
    }

    public Drawable mutate() {
        if (!this.zzaix && super.mutate() == this) {
            if (canConstantState()) {
                this.zzaiz.mutate();
                this.zzaiA.mutate();
                this.zzaix = true;
            } else {
                throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
            }
        }
        return this;
    }

    protected void onBoundsChange(Rect bounds) {
        this.zzaiz.setBounds(bounds);
        this.zzaiA.setBounds(bounds);
    }

    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        if (zznx.zzrN()) {
            Callback callback = getCallback();
            if (callback != null) {
                callback.scheduleDrawable(this, what, when);
            }
        }
    }

    public void setAlpha(int alpha) {
        if (this.zzaiw == this.zzaiu) {
            this.zzaiw = alpha;
        }
        this.zzaiu = alpha;
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter cf) {
        this.zzaiz.setColorFilter(cf);
        this.zzaiA.setColorFilter(cf);
    }

    public void startTransition(int durationMillis) {
        this.mFrom = 0;
        this.zzait = this.zzaiu;
        this.zzaiw = 0;
        this.zzaiv = durationMillis;
        this.zzais = 1;
        invalidateSelf();
    }

    public void unscheduleDrawable(Drawable who, Runnable what) {
        if (zznx.zzrN()) {
            Callback callback = getCallback();
            if (callback != null) {
                callback.unscheduleDrawable(this, what);
            }
        }
    }

    public Drawable zzpV() {
        return this.zzaiA;
    }
}
