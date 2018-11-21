package com.paypal.android.sdk;

import android.os.Handler;
import android.os.Message;
import com.google.android.gms.search.SearchAuth.StatusCodes;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStreamReader;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;

public class ae extends aj {
    private static final String f1162a = ae.class.getSimpleName();
    private Handler f1163b;
    private String f1164c;
    private String f1165d;
    private String f1166e;
    private C0510f f1167f;

    public ae(String str, String str2, String str3, C0510f c0510f, Handler handler) {
        this.f1163b = handler;
        this.f1164c = str;
        this.f1165d = str2;
        this.f1166e = str3;
        this.f1167f = c0510f;
    }

    public void run() {
        Closeable bufferedReader;
        Object e;
        HttpClient httpClient;
        Throwable th;
        if (this.f1163b != null) {
            Closeable closeable = null;
            HttpClient defaultHttpClient;
            try {
                this.f1163b.sendMessage(Message.obtain(this.f1163b, 20, this.f1164c));
                defaultHttpClient = new DefaultHttpClient();
                try {
                    HttpConnectionParams.setSoTimeout(defaultHttpClient.getParams(), StatusCodes.AUTH_DISABLED);
                    HttpConnectionParams.setConnectionTimeout(defaultHttpClient.getParams(), StatusCodes.AUTH_DISABLED);
                    HttpUriRequest httpGet = new HttpGet(this.f1164c);
                    httpGet.setHeader("User-Agent", String.format("%s/%s/%s/%s/Android", new Object[]{this.f1167f.m470a(), this.f1167f.m471b(), this.f1166e, this.f1165d}));
                    httpGet.setHeader("Accept-Language", "en-us");
                    at.m154a(f1162a, String.format("%s/%s/%s/%s/Android", new Object[]{this.f1167f.m470a(), this.f1167f.m471b(), this.f1166e, this.f1165d}));
                    bufferedReader = new BufferedReader(new InputStreamReader(defaultHttpClient.execute(httpGet).getEntity().getContent(), "UTF-8"));
                    try {
                        StringBuilder stringBuilder = new StringBuilder();
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine != null) {
                                stringBuilder.append(readLine);
                            } else {
                                this.f1163b.sendMessage(Message.obtain(this.f1163b, 22, stringBuilder.toString()));
                                C0510f.m457a(bufferedReader);
                                defaultHttpClient.getConnectionManager().shutdown();
                                ak.m129a().m132b(this);
                                return;
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        httpClient = defaultHttpClient;
                        try {
                            this.f1163b.sendMessage(Message.obtain(this.f1163b, 21, e));
                            C0510f.m457a(bufferedReader);
                            if (httpClient != null) {
                                httpClient.getConnectionManager().shutdown();
                            }
                            ak.m129a().m132b(this);
                        } catch (Throwable th2) {
                            th = th2;
                            defaultHttpClient = httpClient;
                            closeable = bufferedReader;
                            C0510f.m457a(closeable);
                            if (defaultHttpClient != null) {
                                defaultHttpClient.getConnectionManager().shutdown();
                            }
                            ak.m129a().m132b(this);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        closeable = bufferedReader;
                        C0510f.m457a(closeable);
                        if (defaultHttpClient != null) {
                            defaultHttpClient.getConnectionManager().shutdown();
                        }
                        ak.m129a().m132b(this);
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    bufferedReader = null;
                    httpClient = defaultHttpClient;
                    this.f1163b.sendMessage(Message.obtain(this.f1163b, 21, e));
                    C0510f.m457a(bufferedReader);
                    if (httpClient != null) {
                        httpClient.getConnectionManager().shutdown();
                    }
                    ak.m129a().m132b(this);
                } catch (Throwable th4) {
                    th = th4;
                    C0510f.m457a(closeable);
                    if (defaultHttpClient != null) {
                        defaultHttpClient.getConnectionManager().shutdown();
                    }
                    ak.m129a().m132b(this);
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
                httpClient = null;
                bufferedReader = null;
                this.f1163b.sendMessage(Message.obtain(this.f1163b, 21, e));
                C0510f.m457a(bufferedReader);
                if (httpClient != null) {
                    httpClient.getConnectionManager().shutdown();
                }
                ak.m129a().m132b(this);
            } catch (Throwable th5) {
                th = th5;
                defaultHttpClient = null;
                C0510f.m457a(closeable);
                if (defaultHttpClient != null) {
                    defaultHttpClient.getConnectionManager().shutdown();
                }
                ak.m129a().m132b(this);
                throw th;
            }
        }
    }
}
