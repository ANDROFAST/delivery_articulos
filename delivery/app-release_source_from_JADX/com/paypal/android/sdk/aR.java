package com.paypal.android.sdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.nearby.messages.Strategy;
import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.util.EntityUtils;

public class aR {
    private Handler f160a;

    public aR() {
        if (Looper.myLooper() != null) {
            this.f160a = new aS(this);
        }
    }

    protected final Message m101a(int i, Object obj) {
        if (this.f160a != null) {
            return this.f160a.obtainMessage(i, obj);
        }
        Message obtain = Message.obtain();
        obtain.what = i;
        obtain.obj = obj;
        return obtain;
    }

    protected final void m102a() {
        m110b(m101a(2, null));
    }

    protected void mo3723a(Message message) {
        Object[] objArr;
        switch (message.what) {
            case 0:
                objArr = (Object[]) message.obj;
                ((Integer) objArr[0]).intValue();
                mo3732a((String) objArr[1], (String) objArr[2]);
                return;
            case 1:
                objArr = (Object[]) message.obj;
                mo3733a((Throwable) objArr[0], (String) objArr[1], (String) objArr[2]);
                return;
            default:
                return;
        }
    }

    public void mo3732a(String str, String str2) {
    }

    public void mo3734a(Throwable th, String str) {
    }

    public void mo3733a(Throwable th, String str, String str2) {
        mo3734a(th, str2);
    }

    protected void mo3724a(Throwable th, byte[] bArr, String str) {
        m110b(m101a(1, new Object[]{th, bArr, str}));
    }

    void mo3725a(HttpResponse httpResponse) {
        String entityUtils;
        Throwable e;
        int statusCode;
        String str = null;
        StatusLine statusLine = httpResponse.getStatusLine();
        try {
            HttpEntity entity = httpResponse.getEntity();
            if (entity != null) {
                entityUtils = EntityUtils.toString(new BufferedHttpEntity(entity), "UTF-8");
                try {
                    Header[] headers = httpResponse.getHeaders("Paypal-Debug-Id");
                    if (headers != null && headers.length > 0) {
                        str = headers[0].getValue();
                    }
                } catch (IOException e2) {
                    e = e2;
                    m111b(e, null, null);
                    if (statusLine.getStatusCode() >= Strategy.TTL_SECONDS_DEFAULT) {
                        statusCode = statusLine.getStatusCode();
                        m110b(m101a(0, new Object[]{Integer.valueOf(statusCode), entityUtils, str}));
                    }
                    m111b(new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase()), entityUtils, str);
                    return;
                }
            }
            entityUtils = null;
        } catch (Throwable e3) {
            e = e3;
            entityUtils = null;
            m111b(e, null, null);
            if (statusLine.getStatusCode() >= Strategy.TTL_SECONDS_DEFAULT) {
                m111b(new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase()), entityUtils, str);
                return;
            }
            statusCode = statusLine.getStatusCode();
            m110b(m101a(0, new Object[]{Integer.valueOf(statusCode), entityUtils, str}));
        }
        if (statusLine.getStatusCode() >= Strategy.TTL_SECONDS_DEFAULT) {
            m111b(new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase()), entityUtils, str);
            return;
        }
        statusCode = statusLine.getStatusCode();
        m110b(m101a(0, new Object[]{Integer.valueOf(statusCode), entityUtils, str}));
    }

    protected final void m109b() {
        m110b(m101a(3, null));
    }

    protected final void m110b(Message message) {
        if (this.f160a != null) {
            this.f160a.sendMessage(message);
        } else {
            mo3723a(message);
        }
    }

    protected final void m111b(Throwable th, String str, String str2) {
        m110b(m101a(1, new Object[]{th, str, str2}));
    }
}
