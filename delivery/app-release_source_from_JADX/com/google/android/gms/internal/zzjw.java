package com.google.android.gms.internal;

import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzw;
import java.net.URI;
import java.net.URISyntaxException;

@zzha
public class zzjw extends WebViewClient {
    private final zzgn zzFr;
    private final String zzMR;
    private boolean zzMS = false;
    private final zzjn zzps;

    public zzjw(zzgn com_google_android_gms_internal_zzgn, zzjn com_google_android_gms_internal_zzjn, String str) {
        this.zzMR = zzaO(str);
        this.zzps = com_google_android_gms_internal_zzjn;
        this.zzFr = com_google_android_gms_internal_zzgn;
    }

    private String zzaO(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (str.endsWith("/")) {
                    str = str.substring(0, str.length() - 1);
                }
            } catch (IndexOutOfBoundsException e) {
                zzb.m6e(e.getMessage());
            }
        }
        return str;
    }

    public void onLoadResource(WebView view, String url) {
        zzb.zzaF("JavascriptAdWebViewClient::onLoadResource: " + url);
        if (!zzaN(url)) {
            this.zzps.zzhC().onLoadResource(this.zzps.getWebView(), url);
        }
    }

    public void onPageFinished(WebView view, String url) {
        zzb.zzaF("JavascriptAdWebViewClient::onPageFinished: " + url);
        if (!this.zzMS) {
            this.zzFr.zzfS();
            this.zzMS = true;
        }
    }

    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        zzb.zzaF("JavascriptAdWebViewClient::shouldOverrideUrlLoading: " + url);
        if (!zzaN(url)) {
            return this.zzps.zzhC().shouldOverrideUrlLoading(this.zzps.getWebView(), url);
        }
        zzb.zzaF("shouldOverrideUrlLoading: received passback url");
        return true;
    }

    protected boolean zzaN(String str) {
        Object zzaO = zzaO(str);
        if (TextUtils.isEmpty(zzaO)) {
            return false;
        }
        try {
            URI uri = new URI(zzaO);
            if ("passback".equals(uri.getScheme())) {
                zzb.zzaF("Passback received");
                this.zzFr.zzfT();
                return true;
            } else if (TextUtils.isEmpty(this.zzMR)) {
                return false;
            } else {
                URI uri2 = new URI(this.zzMR);
                String host = uri2.getHost();
                String host2 = uri.getHost();
                String path = uri2.getPath();
                String path2 = uri.getPath();
                if (!zzw.equal(host, host2) || !zzw.equal(path, path2)) {
                    return false;
                }
                zzb.zzaF("Passback received");
                this.zzFr.zzfT();
                return true;
            }
        } catch (URISyntaxException e) {
            zzb.m6e(e.getMessage());
            return false;
        }
    }
}
