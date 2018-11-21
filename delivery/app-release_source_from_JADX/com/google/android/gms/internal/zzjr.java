package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.drive.DriveFile;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@zzha
class zzjr extends WebView implements OnGlobalLayoutListener, DownloadListener, zzjn {
    private AdSizeParcel zzBh;
    private int zzCC = -1;
    private int zzCD = -1;
    private int zzCF = -1;
    private int zzCG = -1;
    private String zzDX = "";
    private Boolean zzKh;
    private boolean zzMA;
    private boolean zzMB;
    private boolean zzMC;
    private int zzMD;
    private boolean zzME = true;
    private zzcf zzMF;
    private zzcf zzMG;
    private zzcf zzMH;
    private zzcg zzMI;
    private zzd zzMJ;
    private Map<String, zzdw> zzMK;
    private final zza zzMw;
    private zzjo zzMx;
    private zzd zzMy;
    private boolean zzMz;
    private final VersionInfoParcel zzpI;
    private final Object zzpK = new Object();
    private final com.google.android.gms.ads.internal.zzd zzpc;
    private final WindowManager zzrR;
    private zzja zzrz;
    private final zzan zzxV;

    class C03461 implements Runnable {
        final /* synthetic */ zzjr zzML;

        C03461(zzjr com_google_android_gms_internal_zzjr) {
            this.zzML = com_google_android_gms_internal_zzjr;
        }

        public void run() {
            super.destroy();
        }
    }

    @zzha
    public static class zza extends MutableContextWrapper {
        private Activity zzLy;
        private Context zzMM;
        private Context zzrI;

        public zza(Context context) {
            super(context);
            setBaseContext(context);
        }

        public Object getSystemService(String service) {
            return this.zzMM.getSystemService(service);
        }

        public void setBaseContext(Context base) {
            this.zzrI = base.getApplicationContext();
            this.zzLy = base instanceof Activity ? (Activity) base : null;
            this.zzMM = base;
            super.setBaseContext(this.zzrI);
        }

        public void startActivity(Intent intent) {
            if (this.zzLy == null || zznx.isAtLeastL()) {
                intent.setFlags(DriveFile.MODE_READ_ONLY);
                this.zzrI.startActivity(intent);
                return;
            }
            this.zzLy.startActivity(intent);
        }

        public Activity zzhx() {
            return this.zzLy;
        }

        public Context zzhy() {
            return this.zzMM;
        }
    }

    protected zzjr(zza com_google_android_gms_internal_zzjr_zza, AdSizeParcel adSizeParcel, boolean z, boolean z2, zzan com_google_android_gms_internal_zzan, VersionInfoParcel versionInfoParcel, zzch com_google_android_gms_internal_zzch, com.google.android.gms.ads.internal.zzd com_google_android_gms_ads_internal_zzd) {
        super(com_google_android_gms_internal_zzjr_zza);
        this.zzMw = com_google_android_gms_internal_zzjr_zza;
        this.zzBh = adSizeParcel;
        this.zzMB = z;
        this.zzMD = -1;
        this.zzxV = com_google_android_gms_internal_zzan;
        this.zzpI = versionInfoParcel;
        this.zzpc = com_google_android_gms_ads_internal_zzd;
        this.zzrR = (WindowManager) getContext().getSystemService("window");
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        zzp.zzbx().zza((Context) com_google_android_gms_internal_zzjr_zza, versionInfoParcel.afmaVersion, settings);
        zzp.zzbz().zza(getContext(), settings);
        setDownloadListener(this);
        zzhY();
        if (zznx.zzrS()) {
            addJavascriptInterface(new zzjs(this), "googleAdsJsInterface");
        }
        this.zzrz = new zzja(this.zzMw.zzhx(), this, null);
        zzd(com_google_android_gms_internal_zzch);
    }

    static zzjr zzb(Context context, AdSizeParcel adSizeParcel, boolean z, boolean z2, zzan com_google_android_gms_internal_zzan, VersionInfoParcel versionInfoParcel, zzch com_google_android_gms_internal_zzch, com.google.android.gms.ads.internal.zzd com_google_android_gms_ads_internal_zzd) {
        return new zzjr(new zza(context), adSizeParcel, z, z2, com_google_android_gms_internal_zzan, versionInfoParcel, com_google_android_gms_internal_zzch, com_google_android_gms_ads_internal_zzd);
    }

    private void zzd(zzch com_google_android_gms_internal_zzch) {
        zzic();
        this.zzMI = new zzcg(new zzch(true, "make_wv", this.zzBh.zztV));
        this.zzMI.zzdt().zzc(com_google_android_gms_internal_zzch);
        this.zzMG = zzcd.zzb(this.zzMI.zzdt());
        this.zzMI.zza("native:view_create", this.zzMG);
        this.zzMH = null;
        this.zzMF = null;
    }

    private void zzhW() {
        synchronized (this.zzpK) {
            this.zzKh = zzp.zzbA().zzgQ();
            if (this.zzKh == null) {
                try {
                    evaluateJavascript("(function(){})()", null);
                    zzb(Boolean.valueOf(true));
                } catch (IllegalStateException e) {
                    zzb(Boolean.valueOf(false));
                }
            }
        }
    }

    private void zzhX() {
        zzcd.zza(this.zzMI.zzdt(), this.zzMF, "aeh");
    }

    private void zzhY() {
        synchronized (this.zzpK) {
            if (this.zzMB || this.zzBh.zztW) {
                if (VERSION.SDK_INT < 14) {
                    zzb.zzaF("Disabling hardware acceleration on an overlay.");
                    zzhZ();
                } else {
                    zzb.zzaF("Enabling hardware acceleration on an overlay.");
                    zzia();
                }
            } else if (VERSION.SDK_INT < 18) {
                zzb.zzaF("Disabling hardware acceleration on an AdView.");
                zzhZ();
            } else {
                zzb.zzaF("Enabling hardware acceleration on an AdView.");
                zzia();
            }
        }
    }

    private void zzhZ() {
        synchronized (this.zzpK) {
            if (!this.zzMC) {
                zzp.zzbz().zzn(this);
            }
            this.zzMC = true;
        }
    }

    private void zzia() {
        synchronized (this.zzpK) {
            if (this.zzMC) {
                zzp.zzbz().zzm(this);
            }
            this.zzMC = false;
        }
    }

    private void zzib() {
        synchronized (this.zzpK) {
            if (this.zzMK != null) {
                for (zzdw release : this.zzMK.values()) {
                    release.release();
                }
            }
        }
    }

    private void zzic() {
        if (this.zzMI != null) {
            zzch zzdt = this.zzMI.zzdt();
            if (zzdt != null && zzp.zzbA().zzgM() != null) {
                zzp.zzbA().zzgM().zza(zzdt);
            }
        }
    }

    public void destroy() {
        synchronized (this.zzpK) {
            zzic();
            this.zzrz.zzhn();
            if (this.zzMy != null) {
                this.zzMy.close();
                this.zzMy.onDestroy();
                this.zzMy = null;
            }
            this.zzMx.reset();
            if (this.zzMA) {
                return;
            }
            zzp.zzbL().zza((zzjn) this);
            zzib();
            this.zzMA = true;
            zzb.m7v("Initiating WebView self destruct sequence in 3...");
            this.zzMx.zzhQ();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void evaluateJavascript(java.lang.String r3, android.webkit.ValueCallback<java.lang.String> r4) {
        /*
        r2 = this;
        r1 = r2.zzpK;
        monitor-enter(r1);
        r0 = r2.isDestroyed();	 Catch:{ all -> 0x001b }
        if (r0 == 0) goto L_0x0016;
    L_0x0009:
        r0 = "The webview is destroyed. Ignoring action.";
        com.google.android.gms.ads.internal.util.client.zzb.zzaH(r0);	 Catch:{ all -> 0x001b }
        if (r4 == 0) goto L_0x0014;
    L_0x0010:
        r0 = 0;
        r4.onReceiveValue(r0);	 Catch:{ all -> 0x001b }
    L_0x0014:
        monitor-exit(r1);	 Catch:{ all -> 0x001b }
    L_0x0015:
        return;
    L_0x0016:
        super.evaluateJavascript(r3, r4);	 Catch:{ all -> 0x001b }
        monitor-exit(r1);	 Catch:{ all -> 0x001b }
        goto L_0x0015;
    L_0x001b:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x001b }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzjr.evaluateJavascript(java.lang.String, android.webkit.ValueCallback):void");
    }

    public String getRequestId() {
        String str;
        synchronized (this.zzpK) {
            str = this.zzDX;
        }
        return str;
    }

    public int getRequestedOrientation() {
        int i;
        synchronized (this.zzpK) {
            i = this.zzMD;
        }
        return i;
    }

    public View getView() {
        return this;
    }

    public WebView getWebView() {
        return this;
    }

    public boolean isDestroyed() {
        boolean z;
        synchronized (this.zzpK) {
            z = this.zzMA;
        }
        return z;
    }

    public void loadData(String data, String mimeType, String encoding) {
        synchronized (this.zzpK) {
            if (isDestroyed()) {
                zzb.zzaH("The webview is destroyed. Ignoring action.");
            } else {
                super.loadData(data, mimeType, encoding);
            }
        }
    }

    public void loadDataWithBaseURL(String baseUrl, String data, String mimeType, String encoding, String historyUrl) {
        synchronized (this.zzpK) {
            if (isDestroyed()) {
                zzb.zzaH("The webview is destroyed. Ignoring action.");
            } else {
                super.loadDataWithBaseURL(baseUrl, data, mimeType, encoding, historyUrl);
            }
        }
    }

    public void loadUrl(String uri) {
        synchronized (this.zzpK) {
            if (isDestroyed()) {
                zzb.zzaH("The webview is destroyed. Ignoring action.");
            } else {
                try {
                    super.loadUrl(uri);
                } catch (Throwable th) {
                    zzb.zzaH("Could not call loadUrl. " + th);
                }
            }
        }
    }

    protected void onAttachedToWindow() {
        synchronized (this.zzpK) {
            super.onAttachedToWindow();
            if (!isDestroyed()) {
                this.zzrz.onAttachedToWindow();
            }
        }
    }

    protected void onDetachedFromWindow() {
        synchronized (this.zzpK) {
            if (!isDestroyed()) {
                this.zzrz.onDetachedFromWindow();
            }
            super.onDetachedFromWindow();
        }
    }

    public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimeType, long size) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(url), mimeType);
            zzp.zzbx().zzb(getContext(), intent);
        } catch (ActivityNotFoundException e) {
            zzb.zzaF("Couldn't find an Activity to view url/mimetype: " + url + " / " + mimeType);
        }
    }

    protected void onDraw(Canvas canvas) {
        if (!isDestroyed()) {
            if (VERSION.SDK_INT != 21 || !canvas.isHardwareAccelerated() || isAttachedToWindow()) {
                super.onDraw(canvas);
            }
        }
    }

    public void onGlobalLayout() {
        boolean zzhV = zzhV();
        zzd zzhA = zzhA();
        if (zzhA != null && zzhV) {
            zzhA.zzff();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onMeasure(int r10, int r11) {
        /*
        r9 = this;
        r0 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r8 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r7 = 8;
        r6 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r4 = r9.zzpK;
        monitor-enter(r4);
        r1 = r9.isDestroyed();	 Catch:{ all -> 0x0034 }
        if (r1 == 0) goto L_0x0019;
    L_0x0012:
        r0 = 0;
        r1 = 0;
        r9.setMeasuredDimension(r0, r1);	 Catch:{ all -> 0x0034 }
        monitor-exit(r4);	 Catch:{ all -> 0x0034 }
    L_0x0018:
        return;
    L_0x0019:
        r1 = r9.isInEditMode();	 Catch:{ all -> 0x0034 }
        if (r1 != 0) goto L_0x002f;
    L_0x001f:
        r1 = r9.zzMB;	 Catch:{ all -> 0x0034 }
        if (r1 != 0) goto L_0x002f;
    L_0x0023:
        r1 = r9.zzBh;	 Catch:{ all -> 0x0034 }
        r1 = r1.zztY;	 Catch:{ all -> 0x0034 }
        if (r1 != 0) goto L_0x002f;
    L_0x0029:
        r1 = r9.zzBh;	 Catch:{ all -> 0x0034 }
        r1 = r1.zztZ;	 Catch:{ all -> 0x0034 }
        if (r1 == 0) goto L_0x0037;
    L_0x002f:
        super.onMeasure(r10, r11);	 Catch:{ all -> 0x0034 }
        monitor-exit(r4);	 Catch:{ all -> 0x0034 }
        goto L_0x0018;
    L_0x0034:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0034 }
        throw r0;
    L_0x0037:
        r1 = r9.zzBh;	 Catch:{ all -> 0x0034 }
        r1 = r1.zztW;	 Catch:{ all -> 0x0034 }
        if (r1 == 0) goto L_0x0054;
    L_0x003d:
        r0 = new android.util.DisplayMetrics;	 Catch:{ all -> 0x0034 }
        r0.<init>();	 Catch:{ all -> 0x0034 }
        r1 = r9.zzrR;	 Catch:{ all -> 0x0034 }
        r1 = r1.getDefaultDisplay();	 Catch:{ all -> 0x0034 }
        r1.getMetrics(r0);	 Catch:{ all -> 0x0034 }
        r1 = r0.widthPixels;	 Catch:{ all -> 0x0034 }
        r0 = r0.heightPixels;	 Catch:{ all -> 0x0034 }
        r9.setMeasuredDimension(r1, r0);	 Catch:{ all -> 0x0034 }
        monitor-exit(r4);	 Catch:{ all -> 0x0034 }
        goto L_0x0018;
    L_0x0054:
        r2 = android.view.View.MeasureSpec.getMode(r10);	 Catch:{ all -> 0x0034 }
        r3 = android.view.View.MeasureSpec.getSize(r10);	 Catch:{ all -> 0x0034 }
        r5 = android.view.View.MeasureSpec.getMode(r11);	 Catch:{ all -> 0x0034 }
        r1 = android.view.View.MeasureSpec.getSize(r11);	 Catch:{ all -> 0x0034 }
        if (r2 == r6) goto L_0x0068;
    L_0x0066:
        if (r2 != r8) goto L_0x00fd;
    L_0x0068:
        r2 = r3;
    L_0x0069:
        if (r5 == r6) goto L_0x006d;
    L_0x006b:
        if (r5 != r8) goto L_0x006e;
    L_0x006d:
        r0 = r1;
    L_0x006e:
        r5 = r9.zzBh;	 Catch:{ all -> 0x0034 }
        r5 = r5.widthPixels;	 Catch:{ all -> 0x0034 }
        if (r5 > r2) goto L_0x007a;
    L_0x0074:
        r2 = r9.zzBh;	 Catch:{ all -> 0x0034 }
        r2 = r2.heightPixels;	 Catch:{ all -> 0x0034 }
        if (r2 <= r0) goto L_0x00e7;
    L_0x007a:
        r0 = r9.zzMw;	 Catch:{ all -> 0x0034 }
        r0 = r0.getResources();	 Catch:{ all -> 0x0034 }
        r0 = r0.getDisplayMetrics();	 Catch:{ all -> 0x0034 }
        r0 = r0.density;	 Catch:{ all -> 0x0034 }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0034 }
        r2.<init>();	 Catch:{ all -> 0x0034 }
        r5 = "Not enough space to show ad. Needs ";
        r2 = r2.append(r5);	 Catch:{ all -> 0x0034 }
        r5 = r9.zzBh;	 Catch:{ all -> 0x0034 }
        r5 = r5.widthPixels;	 Catch:{ all -> 0x0034 }
        r5 = (float) r5;	 Catch:{ all -> 0x0034 }
        r5 = r5 / r0;
        r5 = (int) r5;	 Catch:{ all -> 0x0034 }
        r2 = r2.append(r5);	 Catch:{ all -> 0x0034 }
        r5 = "x";
        r2 = r2.append(r5);	 Catch:{ all -> 0x0034 }
        r5 = r9.zzBh;	 Catch:{ all -> 0x0034 }
        r5 = r5.heightPixels;	 Catch:{ all -> 0x0034 }
        r5 = (float) r5;	 Catch:{ all -> 0x0034 }
        r5 = r5 / r0;
        r5 = (int) r5;	 Catch:{ all -> 0x0034 }
        r2 = r2.append(r5);	 Catch:{ all -> 0x0034 }
        r5 = " dp, but only has ";
        r2 = r2.append(r5);	 Catch:{ all -> 0x0034 }
        r3 = (float) r3;	 Catch:{ all -> 0x0034 }
        r3 = r3 / r0;
        r3 = (int) r3;	 Catch:{ all -> 0x0034 }
        r2 = r2.append(r3);	 Catch:{ all -> 0x0034 }
        r3 = "x";
        r2 = r2.append(r3);	 Catch:{ all -> 0x0034 }
        r1 = (float) r1;	 Catch:{ all -> 0x0034 }
        r0 = r1 / r0;
        r0 = (int) r0;	 Catch:{ all -> 0x0034 }
        r0 = r2.append(r0);	 Catch:{ all -> 0x0034 }
        r1 = " dp.";
        r0 = r0.append(r1);	 Catch:{ all -> 0x0034 }
        r0 = r0.toString();	 Catch:{ all -> 0x0034 }
        com.google.android.gms.ads.internal.util.client.zzb.zzaH(r0);	 Catch:{ all -> 0x0034 }
        r0 = r9.getVisibility();	 Catch:{ all -> 0x0034 }
        if (r0 == r7) goto L_0x00df;
    L_0x00db:
        r0 = 4;
        r9.setVisibility(r0);	 Catch:{ all -> 0x0034 }
    L_0x00df:
        r0 = 0;
        r1 = 0;
        r9.setMeasuredDimension(r0, r1);	 Catch:{ all -> 0x0034 }
    L_0x00e4:
        monitor-exit(r4);	 Catch:{ all -> 0x0034 }
        goto L_0x0018;
    L_0x00e7:
        r0 = r9.getVisibility();	 Catch:{ all -> 0x0034 }
        if (r0 == r7) goto L_0x00f1;
    L_0x00ed:
        r0 = 0;
        r9.setVisibility(r0);	 Catch:{ all -> 0x0034 }
    L_0x00f1:
        r0 = r9.zzBh;	 Catch:{ all -> 0x0034 }
        r0 = r0.widthPixels;	 Catch:{ all -> 0x0034 }
        r1 = r9.zzBh;	 Catch:{ all -> 0x0034 }
        r1 = r1.heightPixels;	 Catch:{ all -> 0x0034 }
        r9.setMeasuredDimension(r0, r1);	 Catch:{ all -> 0x0034 }
        goto L_0x00e4;
    L_0x00fd:
        r2 = r0;
        goto L_0x0069;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzjr.onMeasure(int, int):void");
    }

    public void onPause() {
        if (!isDestroyed()) {
            try {
                if (zznx.zzrN()) {
                    super.onPause();
                }
            } catch (Throwable e) {
                zzb.zzb("Could not pause webview.", e);
            }
        }
    }

    public void onResume() {
        if (!isDestroyed()) {
            try {
                if (zznx.zzrN()) {
                    super.onResume();
                }
            } catch (Throwable e) {
                zzb.zzb("Could not resume webview.", e);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (this.zzxV != null) {
            this.zzxV.zza(event);
        }
        return isDestroyed() ? false : super.onTouchEvent(event);
    }

    public void setContext(Context context) {
        this.zzMw.setBaseContext(context);
        this.zzrz.zzk(this.zzMw.zzhx());
    }

    public void setRequestedOrientation(int requestedOrientation) {
        synchronized (this.zzpK) {
            this.zzMD = requestedOrientation;
            if (this.zzMy != null) {
                this.zzMy.setRequestedOrientation(this.zzMD);
            }
        }
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof zzjo) {
            this.zzMx = (zzjo) webViewClient;
        }
    }

    public void stopLoading() {
        if (!isDestroyed()) {
            try {
                super.stopLoading();
            } catch (Throwable e) {
                zzb.zzb("Could not stop loading webview.", e);
            }
        }
    }

    public void zzD(boolean z) {
        synchronized (this.zzpK) {
            this.zzMB = z;
            zzhY();
        }
    }

    public void zzE(boolean z) {
        synchronized (this.zzpK) {
            if (this.zzMy != null) {
                this.zzMy.zza(this.zzMx.zzcb(), z);
            } else {
                this.zzMz = z;
            }
        }
    }

    public void zzF(boolean z) {
        synchronized (this.zzpK) {
            this.zzME = z;
        }
    }

    public void zza(Context context, AdSizeParcel adSizeParcel, zzch com_google_android_gms_internal_zzch) {
        synchronized (this.zzpK) {
            this.zzrz.zzhn();
            setContext(context);
            this.zzMy = null;
            this.zzBh = adSizeParcel;
            this.zzMB = false;
            this.zzMz = false;
            this.zzDX = "";
            this.zzMD = -1;
            zzp.zzbz().zzg(this);
            loadUrl("about:blank");
            this.zzMx.reset();
            setOnTouchListener(null);
            setOnClickListener(null);
            this.zzME = true;
            zzd(com_google_android_gms_internal_zzch);
        }
    }

    public void zza(AdSizeParcel adSizeParcel) {
        synchronized (this.zzpK) {
            this.zzBh = adSizeParcel;
            requestLayout();
        }
    }

    public void zza(zzaz com_google_android_gms_internal_zzaz, boolean z) {
        Map hashMap = new HashMap();
        hashMap.put("isVisible", z ? "1" : "0");
        zzb("onAdVisibilityChanged", hashMap);
    }

    protected void zza(String str, ValueCallback<String> valueCallback) {
        synchronized (this.zzpK) {
            if (isDestroyed()) {
                zzb.zzaH("The webview is destroyed. Ignoring action.");
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(null);
                }
            } else {
                evaluateJavascript(str, valueCallback);
            }
        }
    }

    public void zza(String str, String str2) {
        zzaM(str + "(" + str2 + ");");
    }

    public void zza(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        zza(str, jSONObject.toString());
    }

    public void zzaI(String str) {
        synchronized (this.zzpK) {
            try {
                super.loadUrl(str);
            } catch (Throwable th) {
                zzb.zzaH("Could not call loadUrl. " + th);
            }
        }
    }

    public void zzaJ(String str) {
        synchronized (this.zzpK) {
            if (str == null) {
                str = "";
            }
            this.zzDX = str;
        }
    }

    protected void zzaL(String str) {
        synchronized (this.zzpK) {
            if (isDestroyed()) {
                zzb.zzaH("The webview is destroyed. Ignoring action.");
            } else {
                loadUrl(str);
            }
        }
    }

    protected void zzaM(String str) {
        if (zznx.zzrU()) {
            if (zzgQ() == null) {
                zzhW();
            }
            if (zzgQ().booleanValue()) {
                zza(str, null);
                return;
            } else {
                zzaL("javascript:" + str);
                return;
            }
        }
        zzaL("javascript:" + str);
    }

    public AdSizeParcel zzaP() {
        AdSizeParcel adSizeParcel;
        synchronized (this.zzpK) {
            adSizeParcel = this.zzBh;
        }
        return adSizeParcel;
    }

    public void zzb(zzd com_google_android_gms_ads_internal_overlay_zzd) {
        synchronized (this.zzpK) {
            this.zzMy = com_google_android_gms_ads_internal_overlay_zzd;
        }
    }

    void zzb(Boolean bool) {
        this.zzKh = bool;
        zzp.zzbA().zzb(bool);
    }

    public void zzb(String str, Map<String, ?> map) {
        try {
            zzb(str, zzp.zzbx().zzz(map));
        } catch (JSONException e) {
            zzb.zzaH("Could not convert parameters to JSON.");
        }
    }

    public void zzb(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AFMA_ReceiveMessage('");
        stringBuilder.append(str);
        stringBuilder.append("'");
        stringBuilder.append(",");
        stringBuilder.append(jSONObject2);
        stringBuilder.append(");");
        zzb.m7v("Dispatching AFMA event: " + stringBuilder.toString());
        zzaM(stringBuilder.toString());
    }

    public void zzc(zzd com_google_android_gms_ads_internal_overlay_zzd) {
        synchronized (this.zzpK) {
            this.zzMJ = com_google_android_gms_ads_internal_overlay_zzd;
        }
    }

    public void zzfg() {
        if (this.zzMF == null) {
            zzcd.zza(this.zzMI.zzdt(), this.zzMH, "aes");
            this.zzMF = zzcd.zzb(this.zzMI.zzdt());
            this.zzMI.zza("native:view_show", this.zzMF);
        }
        Map hashMap = new HashMap(1);
        hashMap.put("version", this.zzpI.afmaVersion);
        zzb("onshow", hashMap);
    }

    Boolean zzgQ() {
        Boolean bool;
        synchronized (this.zzpK) {
            bool = this.zzKh;
        }
        return bool;
    }

    public zzd zzhA() {
        zzd com_google_android_gms_ads_internal_overlay_zzd;
        synchronized (this.zzpK) {
            com_google_android_gms_ads_internal_overlay_zzd = this.zzMy;
        }
        return com_google_android_gms_ads_internal_overlay_zzd;
    }

    public zzd zzhB() {
        zzd com_google_android_gms_ads_internal_overlay_zzd;
        synchronized (this.zzpK) {
            com_google_android_gms_ads_internal_overlay_zzd = this.zzMJ;
        }
        return com_google_android_gms_ads_internal_overlay_zzd;
    }

    public zzjo zzhC() {
        return this.zzMx;
    }

    public boolean zzhD() {
        return this.zzMz;
    }

    public zzan zzhE() {
        return this.zzxV;
    }

    public VersionInfoParcel zzhF() {
        return this.zzpI;
    }

    public boolean zzhG() {
        boolean z;
        synchronized (this.zzpK) {
            z = this.zzMB;
        }
        return z;
    }

    public void zzhH() {
        synchronized (this.zzpK) {
            zzb.m7v("Destroying WebView!");
            zzip.zzKO.post(new C03461(this));
        }
    }

    public boolean zzhI() {
        boolean z;
        synchronized (this.zzpK) {
            zzcd.zza(this.zzMI.zzdt(), this.zzMF, "aebb");
            z = this.zzME;
        }
        return z;
    }

    public zzjm zzhJ() {
        return null;
    }

    public zzcf zzhK() {
        return this.zzMH;
    }

    public zzcg zzhL() {
        return this.zzMI;
    }

    public void zzhM() {
        this.zzrz.zzhm();
    }

    public void zzhN() {
        if (this.zzMH == null) {
            this.zzMH = zzcd.zzb(this.zzMI.zzdt());
            this.zzMI.zza("native:view_load", this.zzMH);
        }
    }

    public boolean zzhV() {
        if (!zzhC().zzcb()) {
            return false;
        }
        int i;
        int i2;
        DisplayMetrics zza = zzp.zzbx().zza(this.zzrR);
        int zzb = zzl.zzcN().zzb(zza, zza.widthPixels);
        int zzb2 = zzl.zzcN().zzb(zza, zza.heightPixels);
        Activity zzhx = zzhx();
        if (zzhx == null || zzhx.getWindow() == null) {
            i = zzb2;
            i2 = zzb;
        } else {
            int[] zzg = zzp.zzbx().zzg(zzhx);
            i2 = zzl.zzcN().zzb(zza, zzg[0]);
            i = zzl.zzcN().zzb(zza, zzg[1]);
        }
        if (this.zzCC == zzb && this.zzCD == zzb2 && this.zzCF == i2 && this.zzCG == i) {
            return false;
        }
        boolean z = (this.zzCC == zzb && this.zzCD == zzb2) ? false : true;
        this.zzCC = zzb;
        this.zzCD = zzb2;
        this.zzCF = i2;
        this.zzCG = i;
        new zzfr(this).zza(zzb, zzb2, i2, i, zza.density, this.zzrR.getDefaultDisplay().getRotation());
        return z;
    }

    public void zzhw() {
        zzhX();
        Map hashMap = new HashMap(1);
        hashMap.put("version", this.zzpI.afmaVersion);
        zzb("onhide", hashMap);
    }

    public Activity zzhx() {
        return this.zzMw.zzhx();
    }

    public Context zzhy() {
        return this.zzMw.zzhy();
    }

    public com.google.android.gms.ads.internal.zzd zzhz() {
        return this.zzpc;
    }

    public void zzy(int i) {
        zzhX();
        Map hashMap = new HashMap(2);
        hashMap.put("closetype", String.valueOf(i));
        hashMap.put("version", this.zzpI.afmaVersion);
        zzb("onhide", hashMap);
    }
}
