package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzie.zza;

@zzha
public class zzgs extends zzgr {
    private Object zzFu = new Object();
    private PopupWindow zzFv;
    private boolean zzFw = false;

    zzgs(Context context, zza com_google_android_gms_internal_zzie_zza, zzjn com_google_android_gms_internal_zzjn, zzgq.zza com_google_android_gms_internal_zzgq_zza) {
        super(context, com_google_android_gms_internal_zzie_zza, com_google_android_gms_internal_zzjn, com_google_android_gms_internal_zzgq_zza);
    }

    private void zzfX() {
        synchronized (this.zzFu) {
            this.zzFw = true;
            if ((this.mContext instanceof Activity) && ((Activity) this.mContext).isDestroyed()) {
                this.zzFv = null;
            }
            if (this.zzFv != null) {
                if (this.zzFv.isShowing()) {
                    this.zzFv.dismiss();
                }
                this.zzFv = null;
            }
        }
    }

    public void cancel() {
        zzfX();
        super.cancel();
    }

    protected void zzC(int i) {
        zzfX();
        super.zzC(i);
    }

    protected void zzfW() {
        Window window = this.mContext instanceof Activity ? ((Activity) this.mContext).getWindow() : null;
        if (window != null && window.getDecorView() != null && !((Activity) this.mContext).isDestroyed()) {
            View frameLayout = new FrameLayout(this.mContext);
            frameLayout.setLayoutParams(new LayoutParams(-1, -1));
            frameLayout.addView(this.zzps.getView(), -1, -1);
            synchronized (this.zzFu) {
                if (this.zzFw) {
                    return;
                }
                this.zzFv = new PopupWindow(frameLayout, 1, 1, false);
                this.zzFv.setOutsideTouchable(true);
                this.zzFv.setClippingEnabled(false);
                zzb.zzaF("Displaying the 1x1 popup off the screen.");
                try {
                    this.zzFv.showAtLocation(window.getDecorView(), 0, -1, -1);
                } catch (Exception e) {
                    this.zzFv = null;
                }
            }
        }
    }
}
