package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzil;
import com.google.android.gms.internal.zzip;
import com.google.android.gms.internal.zzis;
import com.google.android.gms.internal.zzjn;
import java.util.Collections;

@zzha
public class zzd extends com.google.android.gms.internal.zzfu.zza implements zzo {
    static final int zzDg = Color.argb(0, 0, 0, 0);
    private final Activity mActivity;
    RelativeLayout zzCm;
    AdOverlayInfoParcel zzDh;
    zzc zzDi;
    zzm zzDj;
    boolean zzDk = false;
    FrameLayout zzDl;
    CustomViewCallback zzDm;
    boolean zzDn = false;
    boolean zzDo = false;
    boolean zzDp = false;
    int zzDq = 0;
    private boolean zzDr;
    private boolean zzDs = false;
    private boolean zzDt = true;
    zzjn zzps;

    @zzha
    private static final class zza extends Exception {
        public zza(String str) {
            super(str);
        }
    }

    @zzha
    static final class zzb extends RelativeLayout {
        zzis zzry;

        public zzb(Context context, String str) {
            super(context);
            this.zzry = new zzis(context, str);
        }

        public boolean onInterceptTouchEvent(MotionEvent event) {
            this.zzry.zze(event);
            return false;
        }
    }

    @zzha
    public static class zzc {
        public final Context context;
        public final int index;
        public final LayoutParams zzDv;
        public final ViewGroup zzDw;

        public zzc(zzjn com_google_android_gms_internal_zzjn) throws zza {
            this.zzDv = com_google_android_gms_internal_zzjn.getLayoutParams();
            ViewParent parent = com_google_android_gms_internal_zzjn.getParent();
            this.context = com_google_android_gms_internal_zzjn.zzhy();
            if (parent == null || !(parent instanceof ViewGroup)) {
                throw new zza("Could not get the parent of the WebView for an overlay.");
            }
            this.zzDw = (ViewGroup) parent;
            this.index = this.zzDw.indexOfChild(com_google_android_gms_internal_zzjn.getView());
            this.zzDw.removeView(com_google_android_gms_internal_zzjn.getView());
            com_google_android_gms_internal_zzjn.zzD(true);
        }
    }

    class C06111 implements com.google.android.gms.internal.zzjo.zza {
        final /* synthetic */ zzd zzDu;

        C06111(zzd com_google_android_gms_ads_internal_overlay_zzd) {
            this.zzDu = com_google_android_gms_ads_internal_overlay_zzd;
        }

        public void zza(zzjn com_google_android_gms_internal_zzjn, boolean z) {
            com_google_android_gms_internal_zzjn.zzfg();
        }
    }

    @zzha
    private class zzd extends zzil {
        final /* synthetic */ zzd zzDu;

        private zzd(zzd com_google_android_gms_ads_internal_overlay_zzd) {
            this.zzDu = com_google_android_gms_ads_internal_overlay_zzd;
        }

        public void onStop() {
        }

        public void zzbp() {
            Bitmap zze = zzp.zzbx().zze(this.zzDu.mActivity, this.zzDu.zzDh.zzDL.zzqc);
            if (zze != null) {
                final Drawable zza = zzp.zzbz().zza(this.zzDu.mActivity, zze, this.zzDu.zzDh.zzDL.zzqd, this.zzDu.zzDh.zzDL.zzqe);
                zzip.zzKO.post(new Runnable(this) {
                    final /* synthetic */ zzd zzDy;

                    public void run() {
                        this.zzDy.zzDu.mActivity.getWindow().setBackgroundDrawable(zza);
                    }
                });
            }
        }
    }

    public zzd(Activity activity) {
        this.mActivity = activity;
    }

    public void close() {
        this.zzDq = 2;
        this.mActivity.finish();
    }

    public void onBackPressed() {
        this.zzDq = 0;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean z = false;
        if (savedInstanceState != null) {
            z = savedInstanceState.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        }
        this.zzDn = z;
        try {
            this.zzDh = AdOverlayInfoParcel.zzb(this.mActivity.getIntent());
            if (this.zzDh == null) {
                throw new zza("Could not get info for ad overlay.");
            }
            if (this.zzDh.zzqR.zzLG > 7500000) {
                this.zzDq = 3;
            }
            if (this.mActivity.getIntent() != null) {
                this.zzDt = this.mActivity.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
            }
            if (this.zzDh.zzDL != null) {
                this.zzDo = this.zzDh.zzDL.zzqa;
            } else {
                this.zzDo = false;
            }
            if (((Boolean) zzbz.zzwI.get()).booleanValue() && this.zzDo && this.zzDh.zzDL.zzqc != null) {
                new zzd().zzgX();
            }
            if (savedInstanceState == null) {
                if (this.zzDh.zzDB != null && this.zzDt) {
                    this.zzDh.zzDB.zzaY();
                }
                if (!(this.zzDh.zzDI == 1 || this.zzDh.zzDA == null)) {
                    this.zzDh.zzDA.onAdClicked();
                }
            }
            this.zzCm = new zzb(this.mActivity, this.zzDh.zzDK);
            switch (this.zzDh.zzDI) {
                case 1:
                    zzx(false);
                    return;
                case 2:
                    this.zzDi = new zzc(this.zzDh.zzDC);
                    zzx(false);
                    return;
                case 3:
                    zzx(true);
                    return;
                case 4:
                    if (this.zzDn) {
                        this.zzDq = 3;
                        this.mActivity.finish();
                        return;
                    } else if (!zzp.zzbu().zza(this.mActivity, this.zzDh.zzDz, this.zzDh.zzDH)) {
                        this.zzDq = 3;
                        this.mActivity.finish();
                        return;
                    } else {
                        return;
                    }
                default:
                    throw new zza("Could not determine ad overlay type.");
            }
        } catch (zza e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH(e.getMessage());
            this.zzDq = 3;
            this.mActivity.finish();
        }
    }

    public void onDestroy() {
        if (this.zzps != null) {
            this.zzCm.removeView(this.zzps.getView());
        }
        zzfe();
    }

    public void onPause() {
        zzfa();
        if (this.zzps != null && (!this.mActivity.isFinishing() || this.zzDi == null)) {
            zzp.zzbz().zzf(this.zzps);
        }
        zzfe();
    }

    public void onRestart() {
    }

    public void onResume() {
        if (this.zzDh != null && this.zzDh.zzDI == 4) {
            if (this.zzDn) {
                this.zzDq = 3;
                this.mActivity.finish();
            } else {
                this.zzDn = true;
            }
        }
        if (this.zzps == null || this.zzps.isDestroyed()) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH("The webview does not exit. Ignoring action.");
        } else {
            zzp.zzbz().zzg(this.zzps);
        }
    }

    public void onSaveInstanceState(Bundle outBundle) {
        outBundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzDn);
    }

    public void onStart() {
    }

    public void onStop() {
        zzfe();
    }

    public void setRequestedOrientation(int requestedOrientation) {
        this.mActivity.setRequestedOrientation(requestedOrientation);
    }

    public void zza(View view, CustomViewCallback customViewCallback) {
        this.zzDl = new FrameLayout(this.mActivity);
        this.zzDl.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.zzDl.addView(view, -1, -1);
        this.mActivity.setContentView(this.zzDl);
        zzaF();
        this.zzDm = customViewCallback;
        this.zzDk = true;
    }

    public void zza(boolean z, boolean z2) {
        if (this.zzDj != null) {
            this.zzDj.zza(z, z2);
        }
    }

    public void zzaF() {
        this.zzDr = true;
    }

    public void zzfa() {
        if (this.zzDh != null && this.zzDk) {
            setRequestedOrientation(this.zzDh.orientation);
        }
        if (this.zzDl != null) {
            this.mActivity.setContentView(this.zzCm);
            zzaF();
            this.zzDl.removeAllViews();
            this.zzDl = null;
        }
        if (this.zzDm != null) {
            this.zzDm.onCustomViewHidden();
            this.zzDm = null;
        }
        this.zzDk = false;
    }

    public void zzfb() {
        this.zzDq = 1;
        this.mActivity.finish();
    }

    public boolean zzfc() {
        this.zzDq = 0;
        if (this.zzps == null) {
            return true;
        }
        boolean zzhI = this.zzps.zzhI();
        if (zzhI) {
            return zzhI;
        }
        this.zzps.zzb("onbackblocked", Collections.emptyMap());
        return zzhI;
    }

    public void zzfd() {
        this.zzCm.removeView(this.zzDj);
        zzw(true);
    }

    protected void zzfe() {
        if (this.mActivity.isFinishing() && !this.zzDs) {
            this.zzDs = true;
            if (this.zzps != null) {
                zzy(this.zzDq);
                this.zzCm.removeView(this.zzps.getView());
                if (this.zzDi != null) {
                    this.zzps.setContext(this.zzDi.context);
                    this.zzps.zzD(false);
                    this.zzDi.zzDw.addView(this.zzps.getView(), this.zzDi.index, this.zzDi.zzDv);
                    this.zzDi = null;
                }
                this.zzps = null;
            }
            if (this.zzDh != null && this.zzDh.zzDB != null) {
                this.zzDh.zzDB.zzaX();
            }
        }
    }

    public void zzff() {
        if (this.zzDp) {
            this.zzDp = false;
            zzfg();
        }
    }

    protected void zzfg() {
        this.zzps.zzfg();
    }

    public void zzw(boolean z) {
        this.zzDj = new zzm(this.mActivity, z ? 50 : 32, this);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(z ? 11 : 9);
        this.zzDj.zza(z, this.zzDh.zzDF);
        this.zzCm.addView(this.zzDj, layoutParams);
    }

    protected void zzx(boolean z) throws zza {
        if (!this.zzDr) {
            this.mActivity.requestWindowFeature(1);
        }
        Window window = this.mActivity.getWindow();
        if (window == null) {
            throw new zza("Invalid activity, no window available.");
        }
        if (!this.zzDo || (this.zzDh.zzDL != null && this.zzDh.zzDL.zzqb)) {
            window.setFlags(1024, 1024);
        }
        boolean zzcb = this.zzDh.zzDC.zzhC().zzcb();
        this.zzDp = false;
        if (zzcb) {
            if (this.zzDh.orientation == zzp.zzbz().zzhd()) {
                this.zzDp = this.mActivity.getResources().getConfiguration().orientation == 1;
            } else if (this.zzDh.orientation == zzp.zzbz().zzhe()) {
                this.zzDp = this.mActivity.getResources().getConfiguration().orientation == 2;
            }
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaF("Delay onShow to next orientation change: " + this.zzDp);
        setRequestedOrientation(this.zzDh.orientation);
        if (zzp.zzbz().zza(window)) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Hardware acceleration on the AdActivity window enabled.");
        }
        if (this.zzDo) {
            this.zzCm.setBackgroundColor(zzDg);
        } else {
            this.zzCm.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        this.mActivity.setContentView(this.zzCm);
        zzaF();
        if (z) {
            this.zzps = zzp.zzby().zza(this.mActivity, this.zzDh.zzDC.zzaP(), true, zzcb, null, this.zzDh.zzqR);
            this.zzps.zzhC().zzb(null, null, this.zzDh.zzDD, this.zzDh.zzDH, true, this.zzDh.zzDJ, null, this.zzDh.zzDC.zzhC().zzhO(), null);
            this.zzps.zzhC().zza(new C06111(this));
            if (this.zzDh.url != null) {
                this.zzps.loadUrl(this.zzDh.url);
            } else if (this.zzDh.zzDG != null) {
                this.zzps.loadDataWithBaseURL(this.zzDh.zzDE, this.zzDh.zzDG, "text/html", "UTF-8", null);
            } else {
                throw new zza("No URL or HTML to display in ad overlay.");
            }
            if (this.zzDh.zzDC != null) {
                this.zzDh.zzDC.zzc(this);
            }
        } else {
            this.zzps = this.zzDh.zzDC;
            this.zzps.setContext(this.mActivity);
        }
        this.zzps.zzb(this);
        ViewParent parent = this.zzps.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this.zzps.getView());
        }
        if (this.zzDo) {
            this.zzps.setBackgroundColor(zzDg);
        }
        this.zzCm.addView(this.zzps.getView(), -1, -1);
        if (!(z || this.zzDp)) {
            zzfg();
        }
        zzw(zzcb);
        if (this.zzps.zzhD()) {
            zza(zzcb, true);
        }
    }

    protected void zzy(int i) {
        this.zzps.zzy(i);
    }
}
