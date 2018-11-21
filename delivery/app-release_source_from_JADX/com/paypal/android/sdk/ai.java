package com.paypal.android.sdk;

import android.os.Handler;
import android.os.Message;
import com.google.android.gms.search.SearchAuth.StatusCodes;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

public final class ai extends aj {
    private String f1172a;
    private List f1173b;
    private List f1174c = new ArrayList();
    private Handler f1175d;
    private boolean f1176e;
    private SSLSocketFactory f1177f;

    public ai(String str, List list, Handler handler, boolean z, SSLSocketFactory sSLSocketFactory) {
        this.f1172a = str;
        this.f1173b = list;
        this.f1175d = handler;
        this.f1176e = z;
        this.f1177f = sSLSocketFactory;
    }

    public final void run() {
        HttpClient defaultHttpClient;
        HttpClient httpClient;
        Object e;
        Throwable th;
        Closeable closeable = null;
        if (this.f1175d != null) {
            try {
                this.f1175d.sendMessage(Message.obtain(this.f1175d, 0, this.f1172a));
                if (!this.f1176e) {
                    this.f1174c.add(new BasicNameValuePair("CLIENT-AUTH", "No cert"));
                }
                this.f1174c.add(new BasicNameValuePair("X-PAYPAL-RESPONSE-DATA-FORMAT", "NV"));
                this.f1174c.add(new BasicNameValuePair("X-PAYPAL-REQUEST-DATA-FORMAT", "NV"));
                this.f1174c.add(new BasicNameValuePair("X-PAYPAL-SERVICE-VERSION", "1.0.0"));
                if (this.f1176e) {
                    defaultHttpClient = new DefaultHttpClient();
                    try {
                        defaultHttpClient.getConnectionManager().getSchemeRegistry().register(new Scheme("https", new ao(), 443));
                        httpClient = defaultHttpClient;
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            this.f1175d.sendMessage(Message.obtain(this.f1175d, 1, e));
                            C0510f.m457a(closeable);
                            if (defaultHttpClient != null) {
                                defaultHttpClient.getConnectionManager().shutdown();
                            }
                            ak.m129a().m132b(this);
                        } catch (Throwable th2) {
                            th = th2;
                            httpClient = defaultHttpClient;
                            C0510f.m457a(closeable);
                            if (httpClient != null) {
                                httpClient.getConnectionManager().shutdown();
                            }
                            ak.m129a().m132b(this);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        httpClient = defaultHttpClient;
                        C0510f.m457a(closeable);
                        if (httpClient != null) {
                            httpClient.getConnectionManager().shutdown();
                        }
                        ak.m129a().m132b(this);
                        throw th;
                    }
                }
                SchemeRegistry schemeRegistry = new SchemeRegistry();
                schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
                if (this.f1177f == null) {
                    schemeRegistry.register(new Scheme("https", new af(), 443));
                } else {
                    schemeRegistry.register(new Scheme("https", this.f1177f, 443));
                }
                HttpParams basicHttpParams = new BasicHttpParams();
                basicHttpParams.setParameter("http.conn-manager.max-total", Integer.valueOf(30));
                basicHttpParams.setParameter("http.conn-manager.max-per-route", new ConnPerRouteBean(30));
                basicHttpParams.setParameter("http.protocol.expect-continue", Boolean.valueOf(false));
                HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
                httpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
                try {
                    HttpConnectionParams.setSoTimeout(httpClient.getParams(), StatusCodes.AUTH_DISABLED);
                    HttpConnectionParams.setConnectionTimeout(httpClient.getParams(), StatusCodes.AUTH_DISABLED);
                    HttpUriRequest httpPost = new HttpPost(this.f1172a);
                    for (NameValuePair nameValuePair : this.f1174c) {
                        httpPost.addHeader(nameValuePair.getName(), nameValuePair.getValue());
                    }
                    httpPost.setEntity(new UrlEncodedFormEntity(this.f1173b, "UTF-8"));
                    Closeable bufferedReader = new BufferedReader(new InputStreamReader(httpClient.execute(httpPost).getEntity().getContent(), "UTF-8"));
                    try {
                        StringBuilder stringBuilder = new StringBuilder();
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine != null) {
                                stringBuilder.append(readLine);
                            } else {
                                this.f1175d.sendMessage(Message.obtain(this.f1175d, 2, stringBuilder.toString()));
                                C0510f.m457a(bufferedReader);
                                httpClient.getConnectionManager().shutdown();
                                ak.m129a().m132b(this);
                                return;
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        closeable = bufferedReader;
                        defaultHttpClient = httpClient;
                        this.f1175d.sendMessage(Message.obtain(this.f1175d, 1, e));
                        C0510f.m457a(closeable);
                        if (defaultHttpClient != null) {
                            defaultHttpClient.getConnectionManager().shutdown();
                        }
                        ak.m129a().m132b(this);
                    } catch (Throwable th4) {
                        th = th4;
                        closeable = bufferedReader;
                        C0510f.m457a(closeable);
                        if (httpClient != null) {
                            httpClient.getConnectionManager().shutdown();
                        }
                        ak.m129a().m132b(this);
                        throw th;
                    }
                } catch (Exception e4) {
                    e = e4;
                    defaultHttpClient = httpClient;
                    this.f1175d.sendMessage(Message.obtain(this.f1175d, 1, e));
                    C0510f.m457a(closeable);
                    if (defaultHttpClient != null) {
                        defaultHttpClient.getConnectionManager().shutdown();
                    }
                    ak.m129a().m132b(this);
                } catch (Throwable th5) {
                    th = th5;
                    C0510f.m457a(closeable);
                    if (httpClient != null) {
                        httpClient.getConnectionManager().shutdown();
                    }
                    ak.m129a().m132b(this);
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                defaultHttpClient = null;
                this.f1175d.sendMessage(Message.obtain(this.f1175d, 1, e));
                C0510f.m457a(closeable);
                if (defaultHttpClient != null) {
                    defaultHttpClient.getConnectionManager().shutdown();
                }
                ak.m129a().m132b(this);
            } catch (Throwable th6) {
                th = th6;
                httpClient = null;
                C0510f.m457a(closeable);
                if (httpClient != null) {
                    httpClient.getConnectionManager().shutdown();
                }
                ak.m129a().m132b(this);
                throw th;
            }
        }
    }
}
