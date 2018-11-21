package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Map;
import org.json.JSONObject;

@zzha
class zzjq extends FrameLayout implements zzjn {
    private final zzjn zzMu;
    private final zzjm zzMv;

    public zzjq(zzjn com_google_android_gms_internal_zzjn) {
        super(com_google_android_gms_internal_zzjn.getContext());
        this.zzMu = com_google_android_gms_internal_zzjn;
        this.zzMv = new zzjm(com_google_android_gms_internal_zzjn.zzhy(), this, this);
        zzjo zzhC = this.zzMu.zzhC();
        if (zzhC != null) {
            zzhC.zze(this);
        }
        addView(this.zzMu.getView());
    }

    public void clearCache(boolean includeDiskFiles) {
        this.zzMu.clearCache(includeDiskFiles);
    }

    public void destroy() {
        this.zzMu.destroy();
    }

    public String getRequestId() {
        return this.zzMu.getRequestId();
    }

    public int getRequestedOrientation() {
        return this.zzMu.getRequestedOrientation();
    }

    public View getView() {
        return this;
    }

    public WebView getWebView() {
        return this.zzMu.getWebView();
    }

    public boolean isDestroyed() {
        return this.zzMu.isDestroyed();
    }

    public void loadData(String data, String mimeType, String encoding) {
        this.zzMu.loadData(data, mimeType, encoding);
    }

    public void loadDataWithBaseURL(String baseUrl, String data, String mimeType, String encoding, String historyUrl) {
        this.zzMu.loadDataWithBaseURL(baseUrl, data, mimeType, encoding, historyUrl);
    }

    public void loadUrl(String url) {
        this.zzMu.loadUrl(url);
    }

    public void onPause() {
        this.zzMv.onPause();
        this.zzMu.onPause();
    }

    public void onResume() {
        this.zzMu.onResume();
    }

    public void setBackgroundColor(int color) {
        this.zzMu.setBackgroundColor(color);
    }

    public void setContext(Context context) {
        this.zzMu.setContext(context);
    }

    public void setOnClickListener(OnClickListener listener) {
        this.zzMu.setOnClickListener(listener);
    }

    public void setOnTouchListener(OnTouchListener listener) {
        this.zzMu.setOnTouchListener(listener);
    }

    public void setRequestedOrientation(int requestedOrientation) {
        this.zzMu.setRequestedOrientation(requestedOrientation);
    }

    public void setWebChromeClient(WebChromeClient client) {
        this.zzMu.setWebChromeClient(client);
    }

    public void setWebViewClient(WebViewClient client) {
        this.zzMu.setWebViewClient(client);
    }

    public void stopLoading() {
        this.zzMu.stopLoading();
    }

    public void zzD(boolean z) {
        this.zzMu.zzD(z);
    }

    public void zzE(boolean z) {
        this.zzMu.zzE(z);
    }

    public void zzF(boolean z) {
        this.zzMu.zzF(z);
    }

    public void zza(Context context, AdSizeParcel adSizeParcel, zzch com_google_android_gms_internal_zzch) {
        this.zzMu.zza(context, adSizeParcel, com_google_android_gms_internal_zzch);
    }

    public void zza(AdSizeParcel adSizeParcel) {
        this.zzMu.zza(adSizeParcel);
    }

    public void zza(zzaz com_google_android_gms_internal_zzaz, boolean z) {
        this.zzMu.zza(com_google_android_gms_internal_zzaz, z);
    }

    public void zza(String str, String str2) {
        this.zzMu.zza(str, str2);
    }

    public void zza(String str, JSONObject jSONObject) {
        this.zzMu.zza(str, jSONObject);
    }

    public void zzaI(String str) {
        this.zzMu.zzaI(str);
    }

    public void zzaJ(String str) {
        this.zzMu.zzaJ(str);
    }

    public AdSizeParcel zzaP() {
        return this.zzMu.zzaP();
    }

    public void zzb(zzd com_google_android_gms_ads_internal_overlay_zzd) {
        this.zzMu.zzb(com_google_android_gms_ads_internal_overlay_zzd);
    }

    public void zzb(String str, Map<String, ?> map) {
        this.zzMu.zzb(str, (Map) map);
    }

    public void zzb(String str, JSONObject jSONObject) {
        this.zzMu.zzb(str, jSONObject);
    }

    public void zzc(zzd com_google_android_gms_ads_internal_overlay_zzd) {
        this.zzMu.zzc(com_google_android_gms_ads_internal_overlay_zzd);
    }

    public void zzfg() {
        this.zzMu.zzfg();
    }

    public zzd zzhA() {
        return this.zzMu.zzhA();
    }

    public zzd zzhB() {
        return this.zzMu.zzhB();
    }

    public zzjo zzhC() {
        return this.zzMu.zzhC();
    }

    public boolean zzhD() {
        return this.zzMu.zzhD();
    }

    public zzan zzhE() {
        return this.zzMu.zzhE();
    }

    public VersionInfoParcel zzhF() {
        return this.zzMu.zzhF();
    }

    public boolean zzhG() {
        return this.zzMu.zzhG();
    }

    public void zzhH() {
        this.zzMv.onDestroy();
        this.zzMu.zzhH();
    }

    public boolean zzhI() {
        return this.zzMu.zzhI();
    }

    public zzjm zzhJ() {
        return this.zzMv;
    }

    public zzcf zzhK() {
        return this.zzMu.zzhK();
    }

    public zzcg zzhL() {
        return this.zzMu.zzhL();
    }

    public void zzhM() {
        this.zzMu.zzhM();
    }

    public void zzhN() {
        this.zzMu.zzhN();
    }

    public void zzhw() {
        this.zzMu.zzhw();
    }

    public Activity zzhx() {
        return this.zzMu.zzhx();
    }

    public Context zzhy() {
        return this.zzMu.zzhy();
    }

    public com.google.android.gms.ads.internal.zzd zzhz() {
        return this.zzMu.zzhz();
    }

    public void zzy(int i) {
        this.zzMu.zzy(i);
    }
}
