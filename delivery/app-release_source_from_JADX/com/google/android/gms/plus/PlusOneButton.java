package com.google.android.gms.plus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.zzaf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.plus.internal.zzg;

public final class PlusOneButton extends FrameLayout {
    public static final int ANNOTATION_BUBBLE = 1;
    public static final int ANNOTATION_INLINE = 2;
    public static final int ANNOTATION_NONE = 0;
    public static final int DEFAULT_ACTIVITY_REQUEST_CODE = -1;
    public static final int SIZE_MEDIUM = 1;
    public static final int SIZE_SMALL = 0;
    public static final int SIZE_STANDARD = 3;
    public static final int SIZE_TALL = 2;
    private int mSize;
    private String zzF;
    private View zzaYN;
    private int zzaYO;
    private int zzaYP;
    private OnPlusOneClickListener zzaYQ;

    public interface OnPlusOneClickListener {
        void onPlusOneClick(Intent intent);
    }

    protected class DefaultOnPlusOneClickListener implements OnClickListener, OnPlusOneClickListener {
        private final OnPlusOneClickListener zzaYR;
        final /* synthetic */ PlusOneButton zzaYS;

        public DefaultOnPlusOneClickListener(PlusOneButton plusOneButton, OnPlusOneClickListener proxy) {
            this.zzaYS = plusOneButton;
            this.zzaYR = proxy;
        }

        public void onClick(View view) {
            Intent intent = (Intent) this.zzaYS.zzaYN.getTag();
            if (this.zzaYR != null) {
                this.zzaYR.onPlusOneClick(intent);
            } else {
                onPlusOneClick(intent);
            }
        }

        public void onPlusOneClick(Intent intent) {
            Context context = this.zzaYS.getContext();
            if ((context instanceof Activity) && intent != null) {
                ((Activity) context).startActivityForResult(intent, this.zzaYS.zzaYP);
            }
        }
    }

    public PlusOneButton(Context context) {
        this(context, null);
    }

    public PlusOneButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mSize = getSize(context, attrs);
        this.zzaYO = getAnnotation(context, attrs);
        this.zzaYP = -1;
        zzaq(getContext());
        if (!isInEditMode()) {
        }
    }

    protected static int getAnnotation(Context context, AttributeSet attrs) {
        String zza = zzaf.zza("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "annotation", context, attrs, true, false, "PlusOneButton");
        if ("INLINE".equalsIgnoreCase(zza)) {
            return 2;
        }
        return !"NONE".equalsIgnoreCase(zza) ? 1 : 0;
    }

    protected static int getSize(Context context, AttributeSet attrs) {
        String zza = zzaf.zza("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "size", context, attrs, true, false, "PlusOneButton");
        if ("SMALL".equalsIgnoreCase(zza)) {
            return 0;
        }
        if ("MEDIUM".equalsIgnoreCase(zza)) {
            return 1;
        }
        return "TALL".equalsIgnoreCase(zza) ? 2 : 3;
    }

    private void zzaq(Context context) {
        if (this.zzaYN != null) {
            removeView(this.zzaYN);
        }
        this.zzaYN = zzg.zza(context, this.mSize, this.zzaYO, this.zzF, this.zzaYP);
        setOnPlusOneClickListener(this.zzaYQ);
        addView(this.zzaYN);
    }

    public void initialize(String url, int activityRequestCode) {
        zzx.zza(getContext() instanceof Activity, (Object) "To use this method, the PlusOneButton must be placed in an Activity. Use initialize(String, OnPlusOneClickListener).");
        this.zzF = url;
        this.zzaYP = activityRequestCode;
        zzaq(getContext());
    }

    public void initialize(String url, OnPlusOneClickListener plusOneClickListener) {
        this.zzF = url;
        this.zzaYP = 0;
        zzaq(getContext());
        setOnPlusOneClickListener(plusOneClickListener);
    }

    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        this.zzaYN.layout(0, 0, right - left, bottom - top);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        View view = this.zzaYN;
        measureChild(view, widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void plusOneClick() {
        this.zzaYN.performClick();
    }

    public void setAnnotation(int annotation) {
        this.zzaYO = annotation;
        zzaq(getContext());
    }

    public void setIntent(Intent intent) {
        this.zzaYN.setTag(intent);
    }

    public void setOnPlusOneClickListener(OnPlusOneClickListener listener) {
        this.zzaYQ = listener;
        this.zzaYN.setOnClickListener(new DefaultOnPlusOneClickListener(this, listener));
    }

    public void setSize(int size) {
        this.mSize = size;
        zzaq(getContext());
    }
}
