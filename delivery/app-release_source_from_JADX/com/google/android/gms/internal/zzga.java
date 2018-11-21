package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@zzha
public class zzga implements zzfy {
    private final Context mContext;
    final Set<WebView> zzEq = Collections.synchronizedSet(new HashSet());

    public zzga(Context context) {
        this.mContext = context;
    }

    public void zza(String str, final String str2, final String str3) {
        zzb.zzaF("Fetching assets for the given html");
        zzip.zzKO.post(new Runnable(this) {
            final /* synthetic */ zzga zzEt;

            public void run() {
                final WebView zzfE = this.zzEt.zzfE();
                zzfE.setWebViewClient(new WebViewClient(this) {
                    final /* synthetic */ C03141 zzEu;

                    public void onPageFinished(WebView view, String url) {
                        zzb.zzaF("Loading assets have finished");
                        this.zzEu.zzEt.zzEq.remove(zzfE);
                    }

                    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                        zzb.zzaH("Loading assets have failed.");
                        this.zzEu.zzEt.zzEq.remove(zzfE);
                    }
                });
                this.zzEt.zzEq.add(zzfE);
                zzfE.loadDataWithBaseURL(str2, str3, "text/html", "UTF-8", null);
                zzb.zzaF("Fetching assets finished.");
            }
        });
    }

    public WebView zzfE() {
        WebView webView = new WebView(this.mContext);
        webView.getSettings().setJavaScriptEnabled(true);
        return webView;
    }
}
