package com.paypal.android.sdk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Base64;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.gms.fitness.data.WorkoutExercises;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class dF {
    private static final Map f648a;
    private static Pattern f649b = Pattern.compile("^\\s*(\\d+(\\.\\d+)*)\\s*([a-zA-Z]+)\\s*$");
    private static HashMap f650c = new HashMap();

    static {
        Map hashMap = new HashMap();
        hashMap.put("px", Integer.valueOf(0));
        hashMap.put(WorkoutExercises.DIP, Integer.valueOf(1));
        hashMap.put("dp", Integer.valueOf(1));
        hashMap.put("sp", Integer.valueOf(2));
        hashMap.put("pt", Integer.valueOf(3));
        hashMap.put("in", Integer.valueOf(4));
        hashMap.put("mm", Integer.valueOf(5));
        f648a = Collections.unmodifiableMap(hashMap);
    }

    public static int m439a(String str, Context context) {
        return str == null ? 0 : (int) m444b(str, context);
    }

    public static Bitmap m440a(String str, Context context, int i) {
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

    public static void m441a(View view, int i, int i2) {
        LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = -2;
    }

    public static void m442a(View view, String str, String str2, String str3, String str4) {
        Context context = view.getContext();
        view.setPadding(m439a(str, context), m439a(str2, context), m439a(str3, context), m439a(str4, context));
    }

    public static void m443a(View view, boolean z, Context context) {
        m441a(view, -1, -2);
        m442a(view, "10dip", "0dip", "10dip", "0dip");
        Drawable a = z ? dE.m436a(context) : dE.m437b(context);
        if (VERSION.SDK_INT >= 16) {
            view.setBackground(a);
        } else {
            view.setBackgroundDrawable(a);
        }
        view.setFocusable(true);
        view.setMinimumHeight(m439a("54dip", context));
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            textView.setGravity(17);
            textView.setTextColor(-1);
            textView.setTextSize(20.0f);
            textView.setTypeface(dE.f632f);
        }
        if (!(view instanceof Button)) {
            view.setClickable(true);
        }
    }

    public static float m444b(String str, Context context) {
        if (str == null) {
            return 0.0f;
        }
        CharSequence toLowerCase = str.toLowerCase();
        if (f650c.containsKey(toLowerCase)) {
            return ((Float) f650c.get(toLowerCase)).floatValue();
        }
        Matcher matcher = f649b.matcher(toLowerCase);
        if (matcher.matches()) {
            float parseFloat = Float.parseFloat(matcher.group(1));
            Integer num = (Integer) f648a.get(matcher.group(3).toLowerCase());
            if (num == null) {
                num = Integer.valueOf(1);
            }
            float applyDimension = TypedValue.applyDimension(num.intValue(), parseFloat, context.getResources().getDisplayMetrics());
            f650c.put(toLowerCase, Float.valueOf(applyDimension));
            return applyDimension;
        }
        throw new NumberFormatException();
    }

    public static void m445b(View view, String str, String str2, String str3, String str4) {
        Context context = view.getContext();
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof MarginLayoutParams) {
            ((MarginLayoutParams) layoutParams).setMargins(m439a(str, context), m439a(str2, context), m439a(str3, context), m439a(str4, context));
        }
    }

    public static Bitmap m446c(String str, Context context) {
        return m440a(str, context, 240);
    }
}
