package com.google.android.gms.internal;

import android.app.Activity;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslError;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import java.io.File;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;

@zzha
public class zziq {

    public static class zza extends zziq {
        public zza() {
            super();
        }

        public boolean zza(Request request) {
            request.setShowRunningNotification(true);
            return true;
        }

        public int zzhd() {
            return 6;
        }

        public int zzhe() {
            return 7;
        }
    }

    public static class zzb extends zza {
        public boolean zza(Request request) {
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(1);
            return true;
        }

        public boolean zza(final Context context, WebSettings webSettings) {
            super.zza(context, webSettings);
            if (((File) zziz.zzb(new Callable<File>(this) {
                final /* synthetic */ zzb zzKS;

                public /* synthetic */ Object call() throws Exception {
                    return zzhh();
                }

                public File zzhh() {
                    return context.getCacheDir();
                }
            })) != null) {
                webSettings.setAppCachePath(context.getCacheDir().getAbsolutePath());
                webSettings.setAppCacheMaxSize(0);
                webSettings.setAppCacheEnabled(true);
            }
            webSettings.setDatabasePath(context.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
            webSettings.setDatabaseEnabled(true);
            webSettings.setDomStorageEnabled(true);
            webSettings.setDisplayZoomControls(false);
            webSettings.setBuiltInZoomControls(true);
            webSettings.setSupportZoom(true);
            webSettings.setAllowContentAccess(false);
            return true;
        }

        public boolean zza(Window window) {
            window.setFlags(ViewCompat.MEASURED_STATE_TOO_SMALL, ViewCompat.MEASURED_STATE_TOO_SMALL);
            return true;
        }

        public zzjo zzb(zzjn com_google_android_gms_internal_zzjn, boolean z) {
            return new zzju(com_google_android_gms_internal_zzjn, z);
        }

        public Set<String> zzf(Uri uri) {
            return uri.getQueryParameterNames();
        }

        public WebChromeClient zzh(zzjn com_google_android_gms_internal_zzjn) {
            return new zzjt(com_google_android_gms_internal_zzjn);
        }

        public boolean zzm(View view) {
            view.setLayerType(0, null);
            return true;
        }

        public boolean zzn(View view) {
            view.setLayerType(1, null);
            return true;
        }
    }

    public static class zzc extends zzb {
        public String zza(SslError sslError) {
            return sslError.getUrl();
        }

        public WebChromeClient zzh(zzjn com_google_android_gms_internal_zzjn) {
            return new zzjv(com_google_android_gms_internal_zzjn);
        }
    }

    public static class zzf extends zzc {
        public void zza(View view, Drawable drawable) {
            view.setBackground(drawable);
        }

        public void zza(ViewTreeObserver viewTreeObserver, OnGlobalLayoutListener onGlobalLayoutListener) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }

        public boolean zza(Context context, WebSettings webSettings) {
            super.zza(context, webSettings);
            webSettings.setAllowFileAccessFromFileURLs(false);
            webSettings.setAllowUniversalAccessFromFileURLs(false);
            return true;
        }

        public void zzb(Activity activity, OnGlobalLayoutListener onGlobalLayoutListener) {
            Window window = activity.getWindow();
            if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
                zza(window.getDecorView().getViewTreeObserver(), onGlobalLayoutListener);
            }
        }
    }

    public static class zzd extends zzf {
        public String getDefaultUserAgent(Context context) {
            return WebSettings.getDefaultUserAgent(context);
        }

        public Drawable zza(Context context, Bitmap bitmap, boolean z, float f) {
            if (!z || f <= 0.0f || f > 25.0f) {
                return new BitmapDrawable(context.getResources(), bitmap);
            }
            try {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), false);
                Bitmap createBitmap = Bitmap.createBitmap(createScaledBitmap);
                RenderScript create = RenderScript.create(context);
                ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
                Allocation createFromBitmap = Allocation.createFromBitmap(create, createScaledBitmap);
                Allocation createFromBitmap2 = Allocation.createFromBitmap(create, createBitmap);
                create2.setRadius(f);
                create2.setInput(createFromBitmap);
                create2.forEach(createFromBitmap2);
                createFromBitmap2.copyTo(createBitmap);
                return new BitmapDrawable(context.getResources(), createBitmap);
            } catch (RuntimeException e) {
                return new BitmapDrawable(context.getResources(), bitmap);
            }
        }

        public boolean zza(Context context, WebSettings webSettings) {
            super.zza(context, webSettings);
            webSettings.setMediaPlaybackRequiresUserGesture(false);
            return true;
        }
    }

    public static class zze extends zzd {
        public boolean isAttachedToWindow(View view) {
            return super.isAttachedToWindow(view) || view.getWindowId() != null;
        }

        public int zzhf() {
            return 14;
        }
    }

    public static class zzg extends zze {
        public boolean isAttachedToWindow(View view) {
            return view.isAttachedToWindow();
        }

        public LayoutParams zzhg() {
            return new LayoutParams(-1, -1);
        }
    }

    private zziq() {
    }

    public static zziq zzP(int i) {
        return i >= 19 ? new zzg() : i >= 18 ? new zze() : i >= 17 ? new zzd() : i >= 16 ? new zzf() : i >= 14 ? new zzc() : i >= 11 ? new zzb() : i >= 9 ? new zza() : new zziq();
    }

    public String getDefaultUserAgent(Context context) {
        return "";
    }

    public boolean isAttachedToWindow(View view) {
        return (view.getWindowToken() == null && view.getWindowVisibility() == 8) ? false : true;
    }

    public Drawable zza(Context context, Bitmap bitmap, boolean z, float f) {
        return new BitmapDrawable(context.getResources(), bitmap);
    }

    public String zza(SslError sslError) {
        return "";
    }

    public void zza(View view, Drawable drawable) {
        view.setBackgroundDrawable(drawable);
    }

    public void zza(ViewTreeObserver viewTreeObserver, OnGlobalLayoutListener onGlobalLayoutListener) {
        viewTreeObserver.removeGlobalOnLayoutListener(onGlobalLayoutListener);
    }

    public boolean zza(Request request) {
        return false;
    }

    public boolean zza(Context context, WebSettings webSettings) {
        return false;
    }

    public boolean zza(Window window) {
        return false;
    }

    public zzjo zzb(zzjn com_google_android_gms_internal_zzjn, boolean z) {
        return new zzjo(com_google_android_gms_internal_zzjn, z);
    }

    public void zzb(Activity activity, OnGlobalLayoutListener onGlobalLayoutListener) {
        Window window = activity.getWindow();
        if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
            zza(window.getDecorView().getViewTreeObserver(), onGlobalLayoutListener);
        }
    }

    public Set<String> zzf(Uri uri) {
        if (uri.isOpaque()) {
            return Collections.emptySet();
        }
        String encodedQuery = uri.getEncodedQuery();
        if (encodedQuery == null) {
            return Collections.emptySet();
        }
        Set linkedHashSet = new LinkedHashSet();
        int i = 0;
        do {
            int indexOf = encodedQuery.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = encodedQuery.length();
            }
            int indexOf2 = encodedQuery.indexOf(61, i);
            if (indexOf2 > indexOf || indexOf2 == -1) {
                indexOf2 = indexOf;
            }
            linkedHashSet.add(Uri.decode(encodedQuery.substring(i, indexOf2)));
            i = indexOf + 1;
        } while (i < encodedQuery.length());
        return Collections.unmodifiableSet(linkedHashSet);
    }

    public boolean zzf(zzjn com_google_android_gms_internal_zzjn) {
        if (com_google_android_gms_internal_zzjn == null) {
            return false;
        }
        com_google_android_gms_internal_zzjn.onPause();
        return true;
    }

    public boolean zzg(zzjn com_google_android_gms_internal_zzjn) {
        if (com_google_android_gms_internal_zzjn == null) {
            return false;
        }
        com_google_android_gms_internal_zzjn.onResume();
        return true;
    }

    public WebChromeClient zzh(zzjn com_google_android_gms_internal_zzjn) {
        return null;
    }

    public int zzhd() {
        return 0;
    }

    public int zzhe() {
        return 1;
    }

    public int zzhf() {
        return 5;
    }

    public LayoutParams zzhg() {
        return new LayoutParams(-2, -2);
    }

    public boolean zzm(View view) {
        return false;
    }

    public boolean zzn(View view) {
        return false;
    }
}
