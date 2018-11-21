package com.paypal.android.sdk;

import android.content.Context;
import com.google.android.gms.search.SearchAuth.StatusCodes;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.SyncBasicHttpContext;

public final class aM {
    private static int f146a = 10;
    private static int f147b = StatusCodes.AUTH_DISABLED;
    private final DefaultHttpClient f148c;
    private final HttpContext f149d = new SyncBasicHttpContext(new BasicHttpContext());
    private ThreadPoolExecutor f150e;
    private final Map f151f;
    private final Map f152g;

    public aM() {
        HttpParams basicHttpParams = new BasicHttpParams();
        ConnManagerParams.setTimeout(basicHttpParams, (long) f147b);
        ConnManagerParams.setMaxConnectionsPerRoute(basicHttpParams, new ConnPerRouteBean(f146a));
        ConnManagerParams.setMaxTotalConnections(basicHttpParams, 10);
        HttpConnectionParams.setSoTimeout(basicHttpParams, f147b);
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, f147b);
        HttpConnectionParams.setTcpNoDelay(basicHttpParams, true);
        HttpConnectionParams.setSocketBufferSize(basicHttpParams, 8192);
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setUserAgent(basicHttpParams, String.format("android-async-http/%s (http://loopj.com/android-async-http)", new Object[]{"1.4.3"}));
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        ClientConnectionManager threadSafeClientConnManager = new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry);
        this.f148c = new DefaultHttpClient(threadSafeClientConnManager, basicHttpParams);
        this.f148c.addRequestInterceptor(new aN(this));
        this.f148c.addResponseInterceptor(new aO(this));
        this.f148c.setHttpRequestRetryHandler(new aV(5));
        this.f150e = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        this.f151f = new WeakHashMap();
        this.f152g = new HashMap();
    }

    private void m90a(DefaultHttpClient defaultHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, String str, aR aRVar, Context context) {
        if (str != null) {
            httpUriRequest.addHeader("Content-Type", str);
        }
        Future submit = this.f150e.submit(new aQ(defaultHttpClient, httpContext, httpUriRequest, aRVar));
        if (context != null) {
            List list = (List) this.f151f.get(context);
            if (list == null) {
                list = new LinkedList();
                this.f151f.put(context, list);
            }
            list.add(new WeakReference(submit));
        }
    }

    public final HttpClient m91a() {
        return this.f148c;
    }

    public final void m92a(int i) {
        HttpParams params = this.f148c.getParams();
        ConnManagerParams.setTimeout(params, (long) i);
        HttpConnectionParams.setSoTimeout(params, i);
        HttpConnectionParams.setConnectionTimeout(params, i);
    }

    public final void m93a(Context context, String str, Header[] headerArr, aR aRVar) {
        HttpUriRequest httpDelete = new HttpDelete(str);
        if (headerArr != null) {
            httpDelete.setHeaders(headerArr);
        }
        m90a(this.f148c, this.f149d, httpDelete, null, aRVar, context);
    }

    public final void m94a(Context context, String str, Header[] headerArr, aU aUVar, aR aRVar) {
        String str2 = null;
        if (str2 != null) {
            String a = str2.m112a();
            str = str.indexOf("?") == -1 ? str + "?" + a : str + "&" + a;
        }
        HttpUriRequest httpGet = new HttpGet(str);
        if (headerArr != null) {
            httpGet.setHeaders(headerArr);
        }
        m90a(this.f148c, this.f149d, httpGet, str2, aRVar, context);
    }

    public final void m95a(Context context, String str, Header[] headerArr, HttpEntity httpEntity, String str2, aR aRVar) {
        HttpUriRequest httpPost = new HttpPost(str);
        if (httpEntity != null) {
            httpPost.setEntity(httpEntity);
        }
        if (headerArr != null) {
            httpPost.setHeaders(headerArr);
        }
        m90a(this.f148c, this.f149d, httpPost, null, aRVar, context);
    }

    public final void m96a(Context context, boolean z) {
        List<WeakReference> list = (List) this.f151f.get(context);
        if (list != null) {
            for (WeakReference weakReference : list) {
                Future future = (Future) weakReference.get();
                if (future != null) {
                    future.cancel(true);
                }
            }
        }
        this.f151f.remove(context);
    }

    public final void m97a(String str) {
        HttpProtocolParams.setUserAgent(this.f148c.getParams(), str);
    }

    public final void m98a(ThreadPoolExecutor threadPoolExecutor) {
        this.f150e = threadPoolExecutor;
    }

    public final void m99a(SSLSocketFactory sSLSocketFactory) {
        this.f148c.getConnectionManager().getSchemeRegistry().register(new Scheme("https", sSLSocketFactory, 443));
    }
}
