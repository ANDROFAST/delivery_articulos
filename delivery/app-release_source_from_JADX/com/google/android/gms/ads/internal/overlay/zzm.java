package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.internal.zzha;

@zzha
public class zzm extends FrameLayout implements OnClickListener {
    private final ImageButton zzDV;
    private final zzo zzDW;

    public zzm(Context context, int i, zzo com_google_android_gms_ads_internal_overlay_zzo) {
        super(context);
        this.zzDW = com_google_android_gms_ads_internal_overlay_zzo;
        setOnClickListener(this);
        this.zzDV = new ImageButton(context);
        this.zzDV.setImageResource(17301527);
        this.zzDV.setBackgroundColor(0);
        this.zzDV.setOnClickListener(this);
        this.zzDV.setPadding(0, 0, 0, 0);
        this.zzDV.setContentDescription("Interstitial close button");
        int zzb = zzl.zzcN().zzb(context, i);
        addView(this.zzDV, new LayoutParams(zzb, zzb, 17));
    }

    public void onClick(View view) {
        if (this.zzDW != null) {
            this.zzDW.zzfb();
        }
    }

    public void zza(boolean z, boolean z2) {
        if (!z2) {
            this.zzDV.setVisibility(0);
        } else if (z) {
            this.zzDV.setVisibility(4);
        } else {
            this.zzDV.setVisibility(8);
        }
    }
}
