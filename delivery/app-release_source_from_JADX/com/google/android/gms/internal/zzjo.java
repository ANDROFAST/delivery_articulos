package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.v4.media.TransportMediator;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzg;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.iid.InstanceID;
import com.google.android.gms.location.places.Place;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@zzha
public class zzjo extends WebViewClient {
    private static final String[] zzMe = new String[]{"UNKNOWN", "HOST_LOOKUP", "UNSUPPORTED_AUTH_SCHEME", "AUTHENTICATION", "PROXY_AUTHENTICATION", "CONNECT", "IO", InstanceID.ERROR_TIMEOUT, "REDIRECT_LOOP", "UNSUPPORTED_SCHEME", "FAILED_SSL_HANDSHAKE", "BAD_URL", "FILE", "FILE_NOT_FOUND", "TOO_MANY_REQUESTS"};
    private static final String[] zzMf = new String[]{"NOT_YET_VALID", "EXPIRED", "ID_MISMATCH", "UNTRUSTED", "DATE_INVALID", "INVALID"};
    private zzfs zzCk;
    private zza zzFl;
    private final HashMap<String, List<zzdl>> zzMg;
    private zzg zzMh;
    private zzb zzMi;
    private boolean zzMj;
    private boolean zzMk;
    private zzn zzMl;
    private final zzfq zzMm;
    private boolean zzMn;
    private boolean zzMo;
    private boolean zzMp;
    private boolean zzMq;
    private int zzMr;
    private final Object zzpK;
    protected zzjn zzps;
    private boolean zzrE;
    private com.google.android.gms.ads.internal.client.zza zztn;
    private zzdp zzyZ;
    private zzdh zzyy;
    private zze zzzb;
    private zzfm zzzc;
    private zzdn zzze;

    class C03451 implements Runnable {
        final /* synthetic */ zzjo zzMs;

        C03451(zzjo com_google_android_gms_internal_zzjo) {
            this.zzMs = com_google_android_gms_internal_zzjo;
        }

        public void run() {
            this.zzMs.zzps.zzhM();
            com.google.android.gms.ads.internal.overlay.zzd zzhA = this.zzMs.zzps.zzhA();
            if (zzhA != null) {
                zzhA.zzfd();
            }
            if (this.zzMs.zzMi != null) {
                this.zzMs.zzMi.zzbh();
                this.zzMs.zzMi = null;
            }
        }
    }

    public interface zza {
        void zza(zzjn com_google_android_gms_internal_zzjn, boolean z);
    }

    public interface zzb {
        void zzbh();
    }

    private static class zzc implements zzg {
        private zzg zzMh;
        private zzjn zzMt;

        public zzc(zzjn com_google_android_gms_internal_zzjn, zzg com_google_android_gms_ads_internal_overlay_zzg) {
            this.zzMt = com_google_android_gms_internal_zzjn;
            this.zzMh = com_google_android_gms_ads_internal_overlay_zzg;
        }

        public void zzaX() {
            this.zzMh.zzaX();
            this.zzMt.zzhw();
        }

        public void zzaY() {
            this.zzMh.zzaY();
            this.zzMt.zzfg();
        }
    }

    private class zzd implements zzdl {
        final /* synthetic */ zzjo zzMs;

        private zzd(zzjo com_google_android_gms_internal_zzjo) {
            this.zzMs = com_google_android_gms_internal_zzjo;
        }

        public void zza(zzjn com_google_android_gms_internal_zzjn, Map<String, String> map) {
            if (map.keySet().contains("start")) {
                this.zzMs.zzhR();
            } else if (map.keySet().contains("stop")) {
                this.zzMs.zzhS();
            } else if (map.keySet().contains("cancel")) {
                this.zzMs.zzhT();
            }
        }
    }

    public zzjo(zzjn com_google_android_gms_internal_zzjn, boolean z) {
        this(com_google_android_gms_internal_zzjn, z, new zzfq(com_google_android_gms_internal_zzjn, com_google_android_gms_internal_zzjn.zzhy(), new zzbr(com_google_android_gms_internal_zzjn.getContext())), null);
    }

    zzjo(zzjn com_google_android_gms_internal_zzjn, boolean z, zzfq com_google_android_gms_internal_zzfq, zzfm com_google_android_gms_internal_zzfm) {
        this.zzMg = new HashMap();
        this.zzpK = new Object();
        this.zzMj = false;
        this.zzps = com_google_android_gms_internal_zzjn;
        this.zzrE = z;
        this.zzMm = com_google_android_gms_internal_zzfq;
        this.zzzc = com_google_android_gms_internal_zzfm;
    }

    private void zza(Context context, String str, String str2, String str3) {
        if (((Boolean) zzbz.zzwt.get()).booleanValue()) {
            Bundle bundle = new Bundle();
            bundle.putString("err", str);
            bundle.putString("code", str2);
            bundle.putString("host", zzaK(str3));
            zzp.zzbx().zza(context, this.zzps.zzhF().afmaVersion, "gmob-apps", bundle, true);
        }
    }

    private String zzaK(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Uri parse = Uri.parse(str);
        return parse.getHost() != null ? parse.getHost() : "";
    }

    private static boolean zzg(Uri uri) {
        String scheme = uri.getScheme();
        return "http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme);
    }

    private void zzhR() {
        synchronized (this.zzpK) {
            this.zzMk = true;
        }
        this.zzMr++;
        zzhU();
    }

    private void zzhS() {
        this.zzMr--;
        zzhU();
    }

    private void zzhT() {
        this.zzMq = true;
        zzhU();
    }

    public final void onLoadResource(WebView webView, String url) {
        com.google.android.gms.ads.internal.util.client.zzb.m7v("Loading resource: " + url);
        Uri parse = Uri.parse(url);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzh(parse);
        }
    }

    public final void onPageFinished(WebView webView, String url) {
        synchronized (this.zzpK) {
            if (this.zzMo) {
                com.google.android.gms.ads.internal.util.client.zzb.m7v("Blank page loaded, 1...");
                this.zzps.zzhH();
                return;
            }
            this.zzMp = true;
            zzhU();
        }
    }

    public final void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        String valueOf = (errorCode >= 0 || (-errorCode) - 1 >= zzMe.length) ? String.valueOf(errorCode) : zzMe[(-errorCode) - 1];
        zza(this.zzps.getContext(), "http_err", valueOf, failingUrl);
        super.onReceivedError(view, errorCode, description, failingUrl);
    }

    public final void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        if (error != null) {
            int primaryError = error.getPrimaryError();
            String valueOf = (primaryError < 0 || primaryError >= zzMf.length) ? String.valueOf(primaryError) : zzMf[primaryError];
            zza(this.zzps.getContext(), "ssl_err", valueOf, zzp.zzbz().zza(error));
        }
        super.onReceivedSslError(view, handler, error);
    }

    public final void reset() {
        synchronized (this.zzpK) {
            this.zzMg.clear();
            this.zztn = null;
            this.zzMh = null;
            this.zzFl = null;
            this.zzyy = null;
            this.zzMj = false;
            this.zzrE = false;
            this.zzMk = false;
            this.zzze = null;
            this.zzMl = null;
            this.zzMi = null;
            if (this.zzzc != null) {
                this.zzzc.zzp(true);
                this.zzzc = null;
            }
            this.zzMn = false;
        }
    }

    public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
        switch (event.getKeyCode()) {
            case 79:
            case Place.TYPE_SPA /*85*/:
            case Place.TYPE_STADIUM /*86*/:
            case Place.TYPE_STORAGE /*87*/:
            case Place.TYPE_STORE /*88*/:
            case Place.TYPE_SUBWAY_STATION /*89*/:
            case 90:
            case Place.TYPE_TAXI_STAND /*91*/:
            case TransportMediator.KEYCODE_MEDIA_PLAY /*126*/:
            case TransportMediator.KEYCODE_MEDIA_PAUSE /*127*/:
            case 128:
            case 129:
            case TransportMediator.KEYCODE_MEDIA_RECORD /*130*/:
            case 222:
                return true;
            default:
                return false;
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String url) {
        com.google.android.gms.ads.internal.util.client.zzb.m7v("AdWebView shouldOverrideUrlLoading: " + url);
        Uri parse = Uri.parse(url);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzh(parse);
        } else if (this.zzMj && webView == this.zzps.getWebView() && zzg(parse)) {
            if (!this.zzMn) {
                this.zzMn = true;
                if (this.zztn != null && ((Boolean) zzbz.zzwb.get()).booleanValue()) {
                    this.zztn.onAdClicked();
                }
            }
            return super.shouldOverrideUrlLoading(webView, url);
        } else if (this.zzps.getWebView().willNotDraw()) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH("AdWebView unable to handle URL: " + url);
        } else {
            Uri uri;
            try {
                zzan zzhE = this.zzps.zzhE();
                if (zzhE != null && zzhE.zzb(parse)) {
                    parse = zzhE.zza(parse, this.zzps.getContext());
                }
                uri = parse;
            } catch (zzao e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaH("Unable to append parameter to URL: " + url);
                uri = parse;
            }
            if (this.zzzb == null || this.zzzb.zzbg()) {
                zza(new AdLauncherIntentInfoParcel("android.intent.action.VIEW", uri.toString(), null, null, null, null, null));
            } else {
                this.zzzb.zzp(url);
            }
        }
        return true;
    }

    public void zzG(boolean z) {
        this.zzMj = z;
    }

    public void zza(int i, int i2, boolean z) {
        this.zzMm.zzf(i, i2);
        if (this.zzzc != null) {
            this.zzzc.zza(i, i2, z);
        }
    }

    public final void zza(AdLauncherIntentInfoParcel adLauncherIntentInfoParcel) {
        zzg com_google_android_gms_ads_internal_overlay_zzg = null;
        boolean zzhG = this.zzps.zzhG();
        com.google.android.gms.ads.internal.client.zza com_google_android_gms_ads_internal_client_zza = (!zzhG || this.zzps.zzaP().zztW) ? this.zztn : null;
        if (!zzhG) {
            com_google_android_gms_ads_internal_overlay_zzg = this.zzMh;
        }
        zza(new AdOverlayInfoParcel(adLauncherIntentInfoParcel, com_google_android_gms_ads_internal_client_zza, com_google_android_gms_ads_internal_overlay_zzg, this.zzMl, this.zzps.zzhF()));
    }

    public void zza(AdOverlayInfoParcel adOverlayInfoParcel) {
        boolean z = false;
        boolean zzeC = this.zzzc != null ? this.zzzc.zzeC() : false;
        com.google.android.gms.ads.internal.overlay.zze zzbv = zzp.zzbv();
        Context context = this.zzps.getContext();
        if (!zzeC) {
            z = true;
        }
        zzbv.zza(context, adOverlayInfoParcel, z);
    }

    public void zza(zza com_google_android_gms_internal_zzjo_zza) {
        this.zzFl = com_google_android_gms_internal_zzjo_zza;
    }

    public void zza(zzb com_google_android_gms_internal_zzjo_zzb) {
        this.zzMi = com_google_android_gms_internal_zzjo_zzb;
    }

    public void zza(String str, zzdl com_google_android_gms_internal_zzdl) {
        synchronized (this.zzpK) {
            List list = (List) this.zzMg.get(str);
            if (list == null) {
                list = new CopyOnWriteArrayList();
                this.zzMg.put(str, list);
            }
            list.add(com_google_android_gms_internal_zzdl);
        }
    }

    public final void zza(boolean z, int i) {
        com.google.android.gms.ads.internal.client.zza com_google_android_gms_ads_internal_client_zza = (!this.zzps.zzhG() || this.zzps.zzaP().zztW) ? this.zztn : null;
        zza(new AdOverlayInfoParcel(com_google_android_gms_ads_internal_client_zza, this.zzMh, this.zzMl, this.zzps, z, i, this.zzps.zzhF()));
    }

    public final void zza(boolean z, int i, String str) {
        zzg com_google_android_gms_ads_internal_overlay_zzg = null;
        boolean zzhG = this.zzps.zzhG();
        com.google.android.gms.ads.internal.client.zza com_google_android_gms_ads_internal_client_zza = (!zzhG || this.zzps.zzaP().zztW) ? this.zztn : null;
        if (!zzhG) {
            com_google_android_gms_ads_internal_overlay_zzg = new zzc(this.zzps, this.zzMh);
        }
        zza(new AdOverlayInfoParcel(com_google_android_gms_ads_internal_client_zza, com_google_android_gms_ads_internal_overlay_zzg, this.zzyy, this.zzMl, this.zzps, z, i, str, this.zzps.zzhF(), this.zzze));
    }

    public final void zza(boolean z, int i, String str, String str2) {
        boolean zzhG = this.zzps.zzhG();
        com.google.android.gms.ads.internal.client.zza com_google_android_gms_ads_internal_client_zza = (!zzhG || this.zzps.zzaP().zztW) ? this.zztn : null;
        zza(new AdOverlayInfoParcel(com_google_android_gms_ads_internal_client_zza, zzhG ? null : new zzc(this.zzps, this.zzMh), this.zzyy, this.zzMl, this.zzps, z, i, str, str2, this.zzps.zzhF(), this.zzze));
    }

    public void zzb(com.google.android.gms.ads.internal.client.zza com_google_android_gms_ads_internal_client_zza, zzg com_google_android_gms_ads_internal_overlay_zzg, zzdh com_google_android_gms_internal_zzdh, zzn com_google_android_gms_ads_internal_overlay_zzn, boolean z, zzdn com_google_android_gms_internal_zzdn, zzdp com_google_android_gms_internal_zzdp, zze com_google_android_gms_ads_internal_zze, zzfs com_google_android_gms_internal_zzfs) {
        if (com_google_android_gms_ads_internal_zze == null) {
            com_google_android_gms_ads_internal_zze = new zze(false);
        }
        this.zzzc = new zzfm(this.zzps, com_google_android_gms_internal_zzfs);
        zza("/appEvent", new zzdg(com_google_android_gms_internal_zzdh));
        zza("/backButton", zzdk.zzyI);
        zza("/canOpenURLs", zzdk.zzyA);
        zza("/canOpenIntents", zzdk.zzyB);
        zza("/click", zzdk.zzyC);
        zza("/close", zzdk.zzyD);
        zza("/customClose", zzdk.zzyE);
        zza("/instrument", zzdk.zzyL);
        zza("/delayPageLoaded", new zzd());
        zza("/httpTrack", zzdk.zzyF);
        zza("/log", zzdk.zzyG);
        zza("/mraid", new zzdr(com_google_android_gms_ads_internal_zze, this.zzzc));
        zza("/mraidLoaded", this.zzMm);
        zza("/open", new zzds(com_google_android_gms_internal_zzdn, com_google_android_gms_ads_internal_zze, this.zzzc));
        zza("/precache", zzdk.zzyK);
        zza("/touch", zzdk.zzyH);
        zza("/video", zzdk.zzyJ);
        if (com_google_android_gms_internal_zzdp != null) {
            zza("/setInterstitialProperties", new zzdo(com_google_android_gms_internal_zzdp));
        }
        this.zztn = com_google_android_gms_ads_internal_client_zza;
        this.zzMh = com_google_android_gms_ads_internal_overlay_zzg;
        this.zzyy = com_google_android_gms_internal_zzdh;
        this.zzze = com_google_android_gms_internal_zzdn;
        this.zzMl = com_google_android_gms_ads_internal_overlay_zzn;
        this.zzzb = com_google_android_gms_ads_internal_zze;
        this.zzCk = com_google_android_gms_internal_zzfs;
        this.zzyZ = com_google_android_gms_internal_zzdp;
        zzG(z);
        this.zzMn = false;
    }

    public void zzb(String str, zzdl com_google_android_gms_internal_zzdl) {
        synchronized (this.zzpK) {
            List list = (List) this.zzMg.get(str);
            if (list == null) {
                return;
            }
            list.remove(com_google_android_gms_internal_zzdl);
        }
    }

    public boolean zzcb() {
        boolean z;
        synchronized (this.zzpK) {
            z = this.zzrE;
        }
        return z;
    }

    public void zze(int i, int i2) {
        if (this.zzzc != null) {
            this.zzzc.zze(i, i2);
        }
    }

    public void zze(zzjn com_google_android_gms_internal_zzjn) {
        this.zzps = com_google_android_gms_internal_zzjn;
    }

    public final void zzfd() {
        synchronized (this.zzpK) {
            this.zzMj = false;
            this.zzrE = true;
            zzip.runOnUiThread(new C03451(this));
        }
    }

    public void zzh(Uri uri) {
        String path = uri.getPath();
        List<zzdl> list = (List) this.zzMg.get(path);
        if (list != null) {
            Map zze = zzp.zzbx().zze(uri);
            if (com.google.android.gms.ads.internal.util.client.zzb.zzQ(2)) {
                com.google.android.gms.ads.internal.util.client.zzb.m7v("Received GMSG: " + path);
                for (String path2 : zze.keySet()) {
                    com.google.android.gms.ads.internal.util.client.zzb.m7v("  " + path2 + ": " + ((String) zze.get(path2)));
                }
            }
            for (zzdl zza : list) {
                zza.zza(this.zzps, zze);
            }
            return;
        }
        com.google.android.gms.ads.internal.util.client.zzb.m7v("No GMSG handler found for GMSG: " + uri);
    }

    public zze zzhO() {
        return this.zzzb;
    }

    public boolean zzhP() {
        boolean z;
        synchronized (this.zzpK) {
            z = this.zzMk;
        }
        return z;
    }

    public void zzhQ() {
        synchronized (this.zzpK) {
            com.google.android.gms.ads.internal.util.client.zzb.m7v("Loading blank page in WebView, 2...");
            this.zzMo = true;
            this.zzps.zzaI("about:blank");
        }
    }

    public final void zzhU() {
        if (this.zzFl != null && ((this.zzMp && this.zzMr <= 0) || this.zzMq)) {
            this.zzFl.zza(this.zzps, !this.zzMq);
            this.zzFl = null;
        }
        this.zzps.zzhN();
    }
}
