package com.google.android.gms.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View.MeasureSpec;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;

@zzha
public class zzgn implements Runnable {
    private final Handler zzFi;
    private final long zzFj;
    private long zzFk;
    private com.google.android.gms.internal.zzjo.zza zzFl;
    protected boolean zzFm;
    protected boolean zzFn;
    private final int zzov;
    private final int zzow;
    protected final zzjn zzps;

    protected final class zza extends AsyncTask<Void, Void, Boolean> {
        private final WebView zzFo;
        private Bitmap zzFp;
        final /* synthetic */ zzgn zzFq;

        public zza(zzgn com_google_android_gms_internal_zzgn, WebView webView) {
            this.zzFq = com_google_android_gms_internal_zzgn;
            this.zzFo = webView;
        }

        protected /* synthetic */ Object doInBackground(Object[] x0) {
            return zza((Void[]) x0);
        }

        protected /* synthetic */ void onPostExecute(Object x0) {
            zza((Boolean) x0);
        }

        protected synchronized void onPreExecute() {
            this.zzFp = Bitmap.createBitmap(this.zzFq.zzov, this.zzFq.zzow, Config.ARGB_8888);
            this.zzFo.setVisibility(0);
            this.zzFo.measure(MeasureSpec.makeMeasureSpec(this.zzFq.zzov, 0), MeasureSpec.makeMeasureSpec(this.zzFq.zzow, 0));
            this.zzFo.layout(0, 0, this.zzFq.zzov, this.zzFq.zzow);
            this.zzFo.draw(new Canvas(this.zzFp));
            this.zzFo.invalidate();
        }

        protected synchronized Boolean zza(Void... voidArr) {
            Boolean valueOf;
            int width = this.zzFp.getWidth();
            int height = this.zzFp.getHeight();
            if (width == 0 || height == 0) {
                valueOf = Boolean.valueOf(false);
            } else {
                int i = 0;
                for (int i2 = 0; i2 < width; i2 += 10) {
                    for (int i3 = 0; i3 < height; i3 += 10) {
                        if (this.zzFp.getPixel(i2, i3) != 0) {
                            i++;
                        }
                    }
                }
                valueOf = Boolean.valueOf(((double) i) / (((double) (width * height)) / 100.0d) > 0.1d);
            }
            return valueOf;
        }

        protected void zza(Boolean bool) {
            zzgn.zzc(this.zzFq);
            if (bool.booleanValue() || this.zzFq.zzfU() || this.zzFq.zzFk <= 0) {
                this.zzFq.zzFn = bool.booleanValue();
                this.zzFq.zzFl.zza(this.zzFq.zzps, true);
            } else if (this.zzFq.zzFk > 0) {
                if (zzb.zzQ(2)) {
                    zzb.zzaF("Ad not detected, scheduling another run.");
                }
                this.zzFq.zzFi.postDelayed(this.zzFq, this.zzFq.zzFj);
            }
        }
    }

    public zzgn(com.google.android.gms.internal.zzjo.zza com_google_android_gms_internal_zzjo_zza, zzjn com_google_android_gms_internal_zzjn, int i, int i2) {
        this(com_google_android_gms_internal_zzjo_zza, com_google_android_gms_internal_zzjn, i, i2, 200, 50);
    }

    public zzgn(com.google.android.gms.internal.zzjo.zza com_google_android_gms_internal_zzjo_zza, zzjn com_google_android_gms_internal_zzjn, int i, int i2, long j, long j2) {
        this.zzFj = j;
        this.zzFk = j2;
        this.zzFi = new Handler(Looper.getMainLooper());
        this.zzps = com_google_android_gms_internal_zzjn;
        this.zzFl = com_google_android_gms_internal_zzjo_zza;
        this.zzFm = false;
        this.zzFn = false;
        this.zzow = i2;
        this.zzov = i;
    }

    static /* synthetic */ long zzc(zzgn com_google_android_gms_internal_zzgn) {
        long j = com_google_android_gms_internal_zzgn.zzFk - 1;
        com_google_android_gms_internal_zzgn.zzFk = j;
        return j;
    }

    public void run() {
        if (this.zzps == null || zzfU()) {
            this.zzFl.zza(this.zzps, true);
        } else {
            new zza(this, this.zzps.getWebView()).execute(new Void[0]);
        }
    }

    public void zza(AdResponseParcel adResponseParcel) {
        zza(adResponseParcel, new zzjw(this, this.zzps, adResponseParcel.zzGU));
    }

    public void zza(AdResponseParcel adResponseParcel, zzjw com_google_android_gms_internal_zzjw) {
        this.zzps.setWebViewClient(com_google_android_gms_internal_zzjw);
        this.zzps.loadDataWithBaseURL(TextUtils.isEmpty(adResponseParcel.zzDE) ? null : zzp.zzbx().zzaz(adResponseParcel.zzDE), adResponseParcel.body, "text/html", "UTF-8", null);
    }

    public void zzfS() {
        this.zzFi.postDelayed(this, this.zzFj);
    }

    public synchronized void zzfT() {
        this.zzFm = true;
    }

    public synchronized boolean zzfU() {
        return this.zzFm;
    }

    public boolean zzfV() {
        return this.zzFn;
    }
}
