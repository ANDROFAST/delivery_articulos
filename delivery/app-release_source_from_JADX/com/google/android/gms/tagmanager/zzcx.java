package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;

class zzcx implements zzac {
    private final Context zzbfJ;
    private final String zzbga = zza("GoogleTagManager", "4.00", VERSION.RELEASE, zzc(Locale.getDefault()), Build.MODEL, Build.ID);
    private final HttpClient zzbgb;
    private zza zzbgc;

    public interface zza {
        void zza(zzaq com_google_android_gms_tagmanager_zzaq);

        void zzb(zzaq com_google_android_gms_tagmanager_zzaq);

        void zzc(zzaq com_google_android_gms_tagmanager_zzaq);
    }

    zzcx(HttpClient httpClient, Context context, zza com_google_android_gms_tagmanager_zzcx_zza) {
        this.zzbfJ = context.getApplicationContext();
        this.zzbgb = httpClient;
        this.zzbgc = com_google_android_gms_tagmanager_zzcx_zza;
    }

    private void zza(HttpEntityEnclosingRequest httpEntityEnclosingRequest) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Object obj : httpEntityEnclosingRequest.getAllHeaders()) {
            stringBuffer.append(obj.toString()).append("\n");
        }
        stringBuffer.append(httpEntityEnclosingRequest.getRequestLine().toString()).append("\n");
        if (httpEntityEnclosingRequest.getEntity() != null) {
            try {
                InputStream content = httpEntityEnclosingRequest.getEntity().getContent();
                if (content != null) {
                    int available = content.available();
                    if (available > 0) {
                        byte[] bArr = new byte[available];
                        content.read(bArr);
                        stringBuffer.append("POST:\n");
                        stringBuffer.append(new String(bArr)).append("\n");
                    }
                }
            } catch (IOException e) {
                zzbg.m10v("Error Writing hit to log...");
            }
        }
        zzbg.m10v(stringBuffer.toString());
    }

    static String zzc(Locale locale) {
        if (locale == null || locale.getLanguage() == null || locale.getLanguage().length() == 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(locale.getLanguage().toLowerCase());
        if (!(locale.getCountry() == null || locale.getCountry().length() == 0)) {
            stringBuilder.append("-").append(locale.getCountry().toLowerCase());
        }
        return stringBuilder.toString();
    }

    private HttpEntityEnclosingRequest zzd(URL url) {
        HttpEntityEnclosingRequest basicHttpEntityEnclosingRequest;
        URISyntaxException e;
        try {
            basicHttpEntityEnclosingRequest = new BasicHttpEntityEnclosingRequest("GET", url.toURI().toString());
            try {
                basicHttpEntityEnclosingRequest.addHeader("User-Agent", this.zzbga);
            } catch (URISyntaxException e2) {
                e = e2;
                zzbg.zzaH("Exception sending hit: " + e.getClass().getSimpleName());
                zzbg.zzaH(e.getMessage());
                return basicHttpEntityEnclosingRequest;
            }
        } catch (URISyntaxException e3) {
            URISyntaxException uRISyntaxException = e3;
            basicHttpEntityEnclosingRequest = null;
            e = uRISyntaxException;
            zzbg.zzaH("Exception sending hit: " + e.getClass().getSimpleName());
            zzbg.zzaH(e.getMessage());
            return basicHttpEntityEnclosingRequest;
        }
        return basicHttpEntityEnclosingRequest;
    }

    public void zzB(List<zzaq> list) {
        int min = Math.min(list.size(), 40);
        Object obj = 1;
        int i = 0;
        while (i < min) {
            Object obj2;
            zzaq com_google_android_gms_tagmanager_zzaq = (zzaq) list.get(i);
            URL zzd = zzd(com_google_android_gms_tagmanager_zzaq);
            if (zzd == null) {
                zzbg.zzaH("No destination: discarding hit.");
                this.zzbgc.zzb(com_google_android_gms_tagmanager_zzaq);
                obj2 = obj;
            } else {
                HttpRequest zzd2 = zzd(zzd);
                if (zzd2 == null) {
                    this.zzbgc.zzb(com_google_android_gms_tagmanager_zzaq);
                    obj2 = obj;
                } else {
                    HttpHost httpHost = new HttpHost(zzd.getHost(), zzd.getPort(), zzd.getProtocol());
                    zzd2.addHeader("Host", httpHost.toHostString());
                    zza(zzd2);
                    if (obj != null) {
                        try {
                            zzbl.zzbb(this.zzbfJ);
                            obj = null;
                        } catch (ClientProtocolException e) {
                            zzbg.zzaH("ClientProtocolException sending hit; discarding hit...");
                            this.zzbgc.zzb(com_google_android_gms_tagmanager_zzaq);
                            obj2 = obj;
                        } catch (IOException e2) {
                            zzbg.zzaH("Exception sending hit: " + e2.getClass().getSimpleName());
                            zzbg.zzaH(e2.getMessage());
                            this.zzbgc.zzc(com_google_android_gms_tagmanager_zzaq);
                            obj2 = obj;
                        }
                    }
                    HttpResponse execute = this.zzbgb.execute(httpHost, zzd2);
                    int statusCode = execute.getStatusLine().getStatusCode();
                    HttpEntity entity = execute.getEntity();
                    if (entity != null) {
                        entity.consumeContent();
                    }
                    if (statusCode != 200) {
                        zzbg.zzaH("Bad response: " + execute.getStatusLine().getStatusCode());
                        this.zzbgc.zzc(com_google_android_gms_tagmanager_zzaq);
                    } else {
                        this.zzbgc.zza(com_google_android_gms_tagmanager_zzaq);
                    }
                    obj2 = obj;
                }
            }
            i++;
            obj = obj2;
        }
    }

    public boolean zzEA() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.zzbfJ.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        zzbg.m10v("...no network connectivity");
        return false;
    }

    String zza(String str, String str2, String str3, String str4, String str5, String str6) {
        return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{str, str2, str3, str4, str5, str6});
    }

    URL zzd(zzaq com_google_android_gms_tagmanager_zzaq) {
        try {
            return new URL(com_google_android_gms_tagmanager_zzaq.zzEJ());
        } catch (MalformedURLException e) {
            zzbg.m9e("Error trying to parse the GTM url.");
            return null;
        }
    }
}
