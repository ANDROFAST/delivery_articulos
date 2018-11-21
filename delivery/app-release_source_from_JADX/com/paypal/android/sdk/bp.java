package com.paypal.android.sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.method.LinkMovementMethod;
import android.util.Base64;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.google.android.gms.fitness.data.WorkoutExercises;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class bp {
    private static final Map f365a;
    private static Pattern f366b = Pattern.compile("^\\s*(\\d+(\\.\\d+)*)\\s*([a-zA-Z]+)\\s*$");
    private static HashMap f367c = new HashMap();

    static {
        Map hashMap = new HashMap();
        hashMap.put("px", Integer.valueOf(0));
        hashMap.put(WorkoutExercises.DIP, Integer.valueOf(1));
        hashMap.put("dp", Integer.valueOf(1));
        hashMap.put("sp", Integer.valueOf(2));
        hashMap.put("pt", Integer.valueOf(3));
        hashMap.put("in", Integer.valueOf(4));
        hashMap.put("mm", Integer.valueOf(5));
        f365a = Collections.unmodifiableMap(hashMap);
    }

    public static int m297a(String str, Context context) {
        return str == null ? 0 : (int) m319b(str, context);
    }

    public static Bitmap m298a(String str, Context context, int i) {
        Options options = new Options();
        if (context != null) {
            options.inTargetDensity = context.getResources().getDisplayMetrics().densityDpi;
        } else {
            options.inTargetDensity = 160;
        }
        options.inDensity = 240;
        options.inScaled = false;
        byte[] decode = Base64.decode(str, 0);
        return BitmapFactory.decodeByteArray(decode, 0, decode.length, options);
    }

    public static View m299a(LinearLayout linearLayout) {
        View view = new View(linearLayout.getContext());
        linearLayout.addView(view);
        m311a(view, new ColorDrawable(bo.f344f));
        m310a(view, -1, "1dip");
        m322b(view, null, "12dip", null, "12dip");
        return view;
    }

    public static LayoutParams m300a() {
        return new LayoutParams(-1, -2);
    }

    public static ViewGroup m301a(Context context) {
        ViewGroup scrollView = new ScrollView(context);
        scrollView.setBackgroundColor(bo.f342d);
        return scrollView;
    }

    public static ImageView m302a(Context context, String str, String str2) {
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ScaleType.CENTER_INSIDE);
        imageView.setImageBitmap(m325c(str, context));
        imageView.setAdjustViewBounds(true);
        imageView.setContentDescription(str2);
        return imageView;
    }

    public static LinearLayout m303a(Context context, boolean z, int i, LinearLayout linearLayout) {
        View linearLayout2 = new LinearLayout(context);
        if (i != 0) {
            linearLayout2.setId(i);
        }
        linearLayout.addView(linearLayout2);
        linearLayout2.setGravity(17);
        linearLayout2.setOrientation(0);
        m315a(linearLayout2, z, context);
        m310a(linearLayout2, -1, "58dip");
        m322b(linearLayout2, null, null, null, "4dip");
        return linearLayout2;
    }

    public static LinearLayout m304a(ViewGroup viewGroup) {
        View linearLayout = new LinearLayout(viewGroup.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(bo.f342d);
        viewGroup.addView(linearLayout);
        m309a(linearLayout, -1, -2);
        return linearLayout;
    }

    public static RelativeLayout.LayoutParams m305a(int i, int i2, int i3, int i4) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(i3, i4);
        return layoutParams;
    }

    public static RelativeLayout.LayoutParams m306a(Context context, String str, String str2, int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(m297a(str, context), m297a(str2, context));
        layoutParams.addRule(i);
        return layoutParams;
    }

    public static void m307a(View view) {
        m322b(view, "4dip", null, "4dip", null);
    }

    public static void m308a(View view, int i, float f) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            layoutParams2.gravity = i;
            layoutParams2.weight = f;
        }
    }

    public static void m309a(View view, int i, int i2) {
        LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
    }

    public static void m310a(View view, int i, String str) {
        m309a(view, i, m297a(str, view.getContext()));
    }

    private static void m311a(View view, Drawable drawable) {
        if (VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    public static void m312a(View view, String str, int i) {
        m309a(view, m297a(str, view.getContext()), -2);
    }

    public static void m313a(View view, String str, String str2) {
        m322b(view, "4dip", str, "4dip", str2);
    }

    public static void m314a(View view, String str, String str2, String str3, String str4) {
        Context context = view.getContext();
        view.setPadding(m297a(str, context), m297a(str2, context), m297a(str3, context), m297a(str4, context));
    }

    public static void m315a(View view, boolean z, Context context) {
        m309a(view, -1, -2);
        m314a(view, "10dip", "0dip", "10dip", "0dip");
        m311a(view, z ? bo.m293a(context) : bo.m294b(context));
        view.setFocusable(true);
        view.setMinimumHeight(m297a("54dip", context));
        if (view instanceof TextView) {
            m317a((TextView) view);
        }
        if (!(view instanceof Button)) {
            view.setClickable(true);
        }
    }

    public static void m316a(Button button) {
        m318a((TextView) button, 17);
    }

    public static void m317a(TextView textView) {
        textView.setGravity(17);
        textView.setTextColor(-1);
        textView.setTextSize(20.0f);
        textView.setTypeface(bo.f351m);
    }

    public static void m318a(TextView textView, int i) {
        m314a(textView, "2dip", "2dip", "2dip", "2dip");
        textView.setTypeface(bo.f352n);
        textView.setTextColor(bo.f358t);
        if (VERSION.SDK_INT < 16) {
            textView.setBackgroundDrawable(bo.m295c(textView.getContext()));
        } else {
            textView.setBackground(bo.m295c(textView.getContext()));
        }
        textView.setAutoLinkMask(15);
        textView.setTextSize(14.0f);
        textView.setTextColor(bo.f358t);
        textView.setGravity(i);
    }

    public static float m319b(String str, Context context) {
        if (str == null) {
            return 0.0f;
        }
        CharSequence toLowerCase = str.toLowerCase();
        if (f367c.containsKey(toLowerCase)) {
            return ((Float) f367c.get(toLowerCase)).floatValue();
        }
        Matcher matcher = f366b.matcher(toLowerCase);
        if (matcher.matches()) {
            float parseFloat = Float.parseFloat(matcher.group(1));
            Integer num = (Integer) f365a.get(matcher.group(3).toLowerCase());
            if (num == null) {
                num = Integer.valueOf(1);
            }
            float applyDimension = TypedValue.applyDimension(num.intValue(), parseFloat, context.getResources().getDisplayMetrics());
            f367c.put(toLowerCase, Float.valueOf(applyDimension));
            return applyDimension;
        }
        throw new NumberFormatException();
    }

    public static LinearLayout m320b(ViewGroup viewGroup) {
        View linearLayout = new LinearLayout(viewGroup.getContext());
        linearLayout.setOrientation(1);
        m314a(linearLayout, "10dip", "14dip", "10dip", "14dip");
        viewGroup.addView(linearLayout, m300a());
        return linearLayout;
    }

    public static void m321b(View view, String str, String str2) {
        Context context = view.getContext();
        m309a(view, m297a(str, context), m297a(str2, context));
    }

    public static void m322b(View view, String str, String str2, String str3, String str4) {
        Context context = view.getContext();
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof MarginLayoutParams) {
            ((MarginLayoutParams) layoutParams).setMargins(m297a(str, context), m297a(str2, context), m297a(str3, context), m297a(str4, context));
        }
    }

    public static void m323b(TextView textView) {
        textView.setTextColor(bo.f349k);
        textView.setLinkTextColor(bo.f358t);
        textView.setTypeface(bo.f357s);
        textView.setTextSize(13.0f);
        textView.setSingleLine(false);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public static void m324b(TextView textView, int i) {
        textView.setTextSize(18.0f);
        textView.setTypeface(bo.f353o);
        textView.setSingleLine(true);
        textView.setGravity(i);
        textView.setTextColor(bo.f345g);
    }

    public static Bitmap m325c(String str, Context context) {
        return m298a(str, context, 240);
    }

    public static void m326c(TextView textView, int i) {
        textView.setTextSize(16.0f);
        textView.setTypeface(bo.f354p);
        textView.setSingleLine(true);
        textView.setGravity(83);
        textView.setTextColor(bo.f345g);
    }

    public static void m327d(TextView textView, int i) {
        textView.setTextSize(14.0f);
        textView.setTypeface(bo.f355q);
        textView.setSingleLine(true);
        textView.setGravity(i);
        textView.setTextColor(bo.f345g);
    }

    public static void m328e(TextView textView, int i) {
        textView.setTextSize(13.0f);
        textView.setTypeface(bo.f355q);
        textView.setSingleLine(true);
        textView.setGravity(83);
        textView.setTextColor(bo.f345g);
    }
}
