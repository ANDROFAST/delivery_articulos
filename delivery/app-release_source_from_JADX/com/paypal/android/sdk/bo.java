package com.paypal.android.sdk;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RectShape;

public final class bo {
    private static int f332A = f363y;
    private static int f333B = f339a;
    private static int f334C = Color.parseColor("#c5ddeb");
    private static int f335D = Color.parseColor("#717074");
    private static int f336E = Color.parseColor("#aa717074");
    private static int f337F = Color.parseColor("#5a5a5d");
    private static int f338G = Color.parseColor("#f5f5f5");
    public static final int f339a = Color.parseColor("#003087");
    public static final int f340b = Color.parseColor("#009CDE");
    public static final Drawable f341c = new ColorDrawable(Color.parseColor("#717074"));
    public static final int f342d = Color.parseColor("#f5f5f5");
    public static final int f343e = Color.parseColor("#c4dceb");
    public static final int f344f = Color.parseColor("#e5e5e5");
    public static final int f345g = Color.parseColor("#515151");
    public static final int f346h = Color.parseColor("#797979");
    public static final int f347i = f345g;
    public static final int f348j = f345g;
    public static final int f349k = f345g;
    public static final int f350l = f346h;
    public static final Typeface f351m = Typeface.create("sans-serif-light", 0);
    public static final Typeface f352n = Typeface.create("sans-serif-light", 0);
    public static final Typeface f353o = Typeface.create("sans-serif-bold", 0);
    public static final Typeface f354p = Typeface.create("sans-serif", 2);
    public static final Typeface f355q = Typeface.create("sans-serif-light", 0);
    public static final Typeface f356r = Typeface.create("sans-serif", 0);
    public static final Typeface f357s = Typeface.create("sans-serif-light", 0);
    public static final ColorStateList f358t = new ColorStateList(new int[][]{f359u, f360v}, new int[]{f333B, f364z});
    private static int[] f359u = new int[]{16842919, 16842910};
    private static int[] f360v = new int[]{16842910};
    private static int[] f361w = new int[]{-16842910};
    private static int[] f362x = new int[]{16842908};
    private static int f363y = Color.parseColor("#aa009CDE");
    private static int f364z = f340b;

    static {
        Color.parseColor("#aa003087");
        Color.parseColor("#333333");
        Color.parseColor("#b32317");
        Typeface.create("sans-serif-light", 0);
    }

    private static Drawable m291a(int i, float f) {
        Drawable[] drawableArr = new Drawable[2];
        drawableArr[0] = new ColorDrawable(i);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RectShape());
        shapeDrawable.getPaint().setStrokeWidth(2.0f * f);
        shapeDrawable.getPaint().setStyle(Style.STROKE);
        shapeDrawable.getPaint().setColor(f342d);
        drawableArr[1] = shapeDrawable;
        return new LayerDrawable(drawableArr);
    }

    private static Drawable m292a(int i, int i2, float f) {
        Drawable[] drawableArr = new Drawable[3];
        drawableArr[0] = new ColorDrawable(i);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RectShape());
        shapeDrawable.getPaint().setStrokeWidth(2.0f * f);
        shapeDrawable.getPaint().setStyle(Style.STROKE);
        shapeDrawable.getPaint().setColor(f342d);
        drawableArr[1] = shapeDrawable;
        shapeDrawable = new ShapeDrawable(new RectShape());
        shapeDrawable.getPaint().setStrokeWidth(f);
        shapeDrawable.getPaint().setStyle(Style.STROKE);
        shapeDrawable.getPaint().setColor(i2);
        drawableArr[2] = shapeDrawable;
        return new LayerDrawable(drawableArr);
    }

    public static Drawable m293a(Context context) {
        Drawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(f359u, new ColorDrawable(f333B));
        stateListDrawable.addState(f361w, new ColorDrawable(f334C));
        stateListDrawable.addState(f362x, m292a(f364z, f332A, m296d(context)));
        stateListDrawable.addState(f360v, m291a(f364z, m296d(context)));
        return stateListDrawable;
    }

    public static Drawable m294b(Context context) {
        Drawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(f359u, new ColorDrawable(f337F));
        stateListDrawable.addState(f361w, new ColorDrawable(f338G));
        stateListDrawable.addState(f362x, m292a(f335D, f336E, m296d(context)));
        stateListDrawable.addState(f360v, m291a(f335D, m296d(context)));
        return stateListDrawable;
    }

    protected static Drawable m295c(Context context) {
        Drawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(f362x, m292a(0, f332A, m296d(context)));
        stateListDrawable.addState(f360v, new ColorDrawable(0));
        return stateListDrawable;
    }

    private static float m296d(Context context) {
        return context.getResources().getDisplayMetrics().density * (bp.m319b("4dip", context) / 2.0f);
    }
}
