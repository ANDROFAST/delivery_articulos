package com.google.android.gms.ads.internal.formats;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzha;
import java.util.List;

@zzha
class zzb extends RelativeLayout {
    private static final float[] zzxt = new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f};
    private final RelativeLayout zzxu;
    private AnimationDrawable zzxv;

    public zzb(Context context, zza com_google_android_gms_ads_internal_formats_zza) {
        super(context);
        zzx.zzy(com_google_android_gms_ads_internal_formats_zza);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        Drawable shapeDrawable = new ShapeDrawable(new RoundRectShape(zzxt, null, null));
        shapeDrawable.getPaint().setColor(com_google_android_gms_ads_internal_formats_zza.getBackgroundColor());
        this.zzxu = new RelativeLayout(context);
        this.zzxu.setLayoutParams(layoutParams);
        zzp.zzbz().zza(this.zzxu, shapeDrawable);
        layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (!TextUtils.isEmpty(com_google_android_gms_ads_internal_formats_zza.getText())) {
            LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            View textView = new TextView(context);
            textView.setLayoutParams(layoutParams2);
            textView.setId(1195835393);
            textView.setTypeface(Typeface.DEFAULT);
            textView.setText(com_google_android_gms_ads_internal_formats_zza.getText());
            textView.setTextColor(com_google_android_gms_ads_internal_formats_zza.getTextColor());
            textView.setTextSize((float) com_google_android_gms_ads_internal_formats_zza.getTextSize());
            textView.setPadding(zzl.zzcN().zzb(context, 4), 0, zzl.zzcN().zzb(context, 4), 0);
            this.zzxu.addView(textView);
            layoutParams.addRule(1, textView.getId());
        }
        View imageView = new ImageView(context);
        imageView.setLayoutParams(layoutParams);
        imageView.setId(1195835394);
        List<Drawable> zzdz = com_google_android_gms_ads_internal_formats_zza.zzdz();
        if (zzdz.size() > 1) {
            this.zzxv = new AnimationDrawable();
            for (Drawable addFrame : zzdz) {
                this.zzxv.addFrame(addFrame, com_google_android_gms_ads_internal_formats_zza.zzdA());
            }
            zzp.zzbz().zza(imageView, this.zzxv);
        } else if (zzdz.size() == 1) {
            imageView.setImageDrawable((Drawable) zzdz.get(0));
        }
        this.zzxu.addView(imageView);
        addView(this.zzxu);
    }

    public void onAttachedToWindow() {
        if (this.zzxv != null) {
            this.zzxv.start();
        }
        super.onAttachedToWindow();
    }

    public ViewGroup zzdB() {
        return this.zzxu;
    }
}
