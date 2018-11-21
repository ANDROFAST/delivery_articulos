package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zzha
public class zzju extends zzjo {
    public zzju(zzjn com_google_android_gms_internal_zzjn, boolean z) {
        super(com_google_android_gms_internal_zzjn, z);
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String url) {
        Exception e;
        try {
            if (!"mraid.js".equalsIgnoreCase(new File(url).getName())) {
                return super.shouldInterceptRequest(webView, url);
            }
            if (webView instanceof zzjn) {
                zzjn com_google_android_gms_internal_zzjn = (zzjn) webView;
                com_google_android_gms_internal_zzjn.zzhC().zzfd();
                String str = com_google_android_gms_internal_zzjn.zzaP().zztW ? (String) zzbz.zzvK.get() : com_google_android_gms_internal_zzjn.zzhG() ? (String) zzbz.zzvJ.get() : (String) zzbz.zzvI.get();
                zzb.m7v("shouldInterceptRequest(" + str + ")");
                return zzd(com_google_android_gms_internal_zzjn.getContext(), this.zzps.zzhF().afmaVersion, str);
            }
            zzb.zzaH("Tried to intercept request from a WebView that wasn't an AdWebView.");
            return super.shouldInterceptRequest(webView, url);
        } catch (IOException e2) {
            e = e2;
            zzb.zzaH("Could not fetch MRAID JS. " + e.getMessage());
            return super.shouldInterceptRequest(webView, url);
        } catch (ExecutionException e3) {
            e = e3;
            zzb.zzaH("Could not fetch MRAID JS. " + e.getMessage());
            return super.shouldInterceptRequest(webView, url);
        } catch (InterruptedException e4) {
            e = e4;
            zzb.zzaH("Could not fetch MRAID JS. " + e.getMessage());
            return super.shouldInterceptRequest(webView, url);
        } catch (TimeoutException e5) {
            e = e5;
            zzb.zzaH("Could not fetch MRAID JS. " + e.getMessage());
            return super.shouldInterceptRequest(webView, url);
        }
    }

    protected WebResourceResponse zzd(Context context, String str, String str2) throws IOException, ExecutionException, InterruptedException, TimeoutException {
        Map hashMap = new HashMap();
        hashMap.put("User-Agent", zzp.zzbx().zzd(context, str));
        hashMap.put("Cache-Control", "max-stale=3600");
        String str3 = (String) new zziu(context).zza(str2, hashMap).get(60, TimeUnit.SECONDS);
        return str3 == null ? null : new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(str3.getBytes("UTF-8")));
    }
}
